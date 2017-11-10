/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Servico.ConverterSHA1;
import com.fbp.projetox.Entidade.Usuario;
import com.fbp.projetox.Repositorio.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author FA&GRA
 */
@Named
@RequestScoped
public class MbLogin implements Serializable {

    Usuario usuario = new Usuario();

    @Getter
    @Setter
    private String user;

    @Getter
    @Setter
    private String pass;

    @Inject
    Usuarios usuarios;
    
    @Inject
    MbSelecionaFilial mbSelecionaFilial;

    private boolean cadastroAdmin = false;

    public MbLogin() {
    }

    public String efetuarLogin() {

        if (retornaUserBanco()) {
            //Adiciona o usuário logado na sessão      
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Seja Bem-Vindo ! " + usuario.getNomeCompleto(), ""));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuario);
            mbSelecionaFilial.setFilial(usuario.getUltimaFilialLogada());
            
            return "/restrito/index.jsf";
        } else {
            if (cadastroAdmin == false) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos!", ""));

            }
            return "";
        }
    }

    /**
     * Efetua logout do usuário do sistema
     *
     * @return retorna para página de login
     */
    public String efetuarLogout() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        usuario = new Usuario();
        return "/login.jsf";
    }

    public Usuario usuarioLogado() {
        return (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
    }

    private boolean retornaUserBanco() {
        boolean ok = false;

        List<Usuario> users = usuarios.validaUsuario(user, ConverterSHA1.cipher(pass));

        if ((users.isEmpty()) && (user.equals("admin"))) {
            cadastroAdmin = true;
            usuario.setNomeCompleto("Administrador");
            usuario.setUsuario(user);
            usuario.setSenha(ConverterSHA1.cipher(pass));
            usuarios.save(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Administrador Cadastrado com Sucesso! Efetue um Login novamente!", ""));
        }

        for (Usuario usu : users) {
            usuario = usu;
            ok = true;
        }
        return ok;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
