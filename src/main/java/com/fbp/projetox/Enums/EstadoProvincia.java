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
    AC("Acre"), AL("Alagoas"), AP("Amapá"), AM("Amazonas"), 
    BA("Bahia"), CE("Ceará"), DF("Distrito Federal"), ES("Espirito Santo"), 
    GO("Goias"), MA("Maranhão"), MT("Mato Grosso"), MS("Mato Grosso do Sul"), 
    MG("Minas Gerais"), PA("Pará"), PB("Paraíba"), PR("Paraná"), PE("Pernambuco"),
    PI("Piauí"), RJ("Rio de Janeiro"), RN("Rio Grande do Norte"), 
    RS("Rio Grande do Sul"), RO("Rondonia"), RR("Roraima"), SC("Santa Catarina"), 
    SP("São Paulo"), SE("Sergipe"), TO("Tocantins");

    @Getter
    private final String descricao;

    private EstadoProvincia(String descricao) {
        this.descricao = descricao;
    }
}
