/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBackBean;

import com.fbp.projetox.Entidade.Usuario;
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
public class MbConsultaUsuario implements Serializable {

    @Inject
    Usuarios usuarios;

    @Getter
    @Setter
    Usuario usuario;

    List<Usuario> listaUsuario;

    public List<Usuario> getListaUsuario() {
        return usuarios.findAll();
    }

}
