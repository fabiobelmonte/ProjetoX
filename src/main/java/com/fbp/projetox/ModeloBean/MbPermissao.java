/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author F.Belmonte
 */
@Named
@ViewScoped
public class MbPermissao implements Serializable {

    @Inject
    MbLogin mbLogin;

    public boolean isAdministrador() {
        return mbLogin.getUsuario().getPermissao().equals("Admin");
    }

    public boolean isBasico() {
        return mbLogin.getUsuario().getPermissao().equals("Basico");
    }

}
