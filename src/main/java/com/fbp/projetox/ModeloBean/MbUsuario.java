/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.Usuario;
import com.fbp.projetox.Enums.OperadoraCelular;
import com.fbp.projetox.Repositorio.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author F.Belmonte
 */
@Named
@ViewScoped
public class MbUsuario implements Serializable {

    @Inject
    Usuarios usuarios;

    @Getter
    @Setter
    Usuario usuario;

    List<Usuario> listaUsuario;

    @Getter
    private final OperadoraCelular[] operadoraCelular;

    public MbUsuario() {
        usuario = new Usuario();
        operadoraCelular = OperadoraCelular.values();
    }

    public List<Usuario> getListaUsuario() {
        return usuarios.findAll();
    }

    public void salvar() {
        usuarios.save(usuario);
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage("", new FacesMessage("Usuário cadastrado com Sucesso!"));
        usuario = new Usuario();

    }

    public void alterarUsuario() {

        if (usuario == null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("", new FacesMessage("Selecione um usuário primeiro!"));
        } else {
            org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('cadastrousuario').show()");
        }
    }

}
