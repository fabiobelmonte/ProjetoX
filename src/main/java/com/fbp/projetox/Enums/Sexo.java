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
public enum Sexo {
    FEMININO("Feminino"), MASCULINO("Masculino");

    @Getter
    private final String descricao;

    private Sexo(String descricao) {
        this.descricao = descricao;
    }
}
