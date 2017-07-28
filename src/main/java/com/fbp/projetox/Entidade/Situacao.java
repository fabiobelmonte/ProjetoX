/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Entidade;

import lombok.Getter;

/**
 *
 * @author F.Belmonte
 */
public enum Situacao {

    ATIVO("Ativo"), INATIVO("Inativo");
 
    @Getter
    private final String descricao;

    private Situacao(String descricao) {
        this.descricao = descricao;
    }

}
