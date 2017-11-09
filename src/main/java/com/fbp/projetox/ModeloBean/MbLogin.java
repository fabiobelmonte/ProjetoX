/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.Usuario;
import com.fbp.projetox.Repositorio.Usuarios;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author FA&GRA
 */
@Named
@ViewScoped
public class MbLogin implements Serializable {

    Usuario usuario = new Usuario();

    private String senhaConvertida;

    @Inject
    Usuarios usuarios;

    public MbLogin() {
    }

    public String efetuarLogin() {
        if (retornaUserBanco(usuario)) {
            //Adiciona o usuário logado na sessão            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuario);
            return "/restrito/index.jsf";
        } else {
            System.out.println(usuario);
            //   msg.retornaErro("Usuário ou senha inválidos!");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos!", ""));
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

    private boolean retornaUserBanco(Usuario usuario) {
        boolean ok = false;

        try {

            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(usuario.getSenha().getBytes("UTF-8"));
            senhaConvertida = String.valueOf(messageDigest);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, ex.getMessage(), ""));
        }

        List<Usuario> users = usuarios.validaUsuario(usuario.getUsuario(), senhaConvertida);
        for (Usuario usu : users) {
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
