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
public enum Origem {
    NACIONAL("Nacional"), ESTRANGEIRA("Estrangeira");

    @Getter
    private final String descricao;

    private Origem(String descricao) {
        this.descricao = descricao;
    }
}
