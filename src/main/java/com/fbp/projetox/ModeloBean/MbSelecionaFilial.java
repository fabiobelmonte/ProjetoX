/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.Filial;
import com.fbp.projetox.Entidade.Usuario;
import com.fbp.projetox.Repositorio.Usuarios;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author F.Belmonte
 */
@Named
@SessionScoped
public class MbSelecionaFilial implements Serializable {

    @Getter
    @Setter
    private Filial filial;

    @Inject
    MbLogin mblogin;

    @Inject
    Usuarios usuarios;

    public void alteraFilialUsuario() {
        Usuario usuario = mblogin.usuarioLogado();
        usuario.setUltimaFilialLogada(filial);
        usuarios.save(usuario);
    }

}
