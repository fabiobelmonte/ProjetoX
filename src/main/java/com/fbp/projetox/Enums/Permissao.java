/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Enums;

import lombok.Getter;

/**
 *
 * @author F.Belmonte
 */
public enum Permissao {

    ADMIN("Admin"), BASICO("Basico");
 
    @Getter
    private final String descricao;

    private Permissao(String descricao) {
        this.descricao = descricao;
    }

}
