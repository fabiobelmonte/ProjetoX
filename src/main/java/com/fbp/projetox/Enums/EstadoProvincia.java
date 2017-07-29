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
public enum EstadoProvincia {
    ACRE, ALAGOAS, AMAPA, AMAZONAS, BAHIA, CEARA, DISTRITO_FEDERAL, ESPIRITO_SANTO, GOIAS, MARANHAO, MATO_GROSSO, MATO_GROSSO_DO_SUL, MINAS_GERAIS, PARA, PARAIBA, PARANA, PERNAMBUCO,
    PIAUI, RIO_DE_JANEIRO, RIO_GRANDE_DO_NORTE, RIO_GRANDE_DO_SUL, RONDONIA, RORAIMA, SANTA_CATARINA, SAO_PAULO, SERGIPE, TOCANTINS;

    @Getter
    private final String descricao;

    private EstadoProvincia(String descricao) {
        this.descricao = descricao;
    }
}
