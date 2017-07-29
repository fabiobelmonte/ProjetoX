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
    ACRE("Acre"), ALAGOAS("Alagoas"), AMAPA("Amapá"), AMAZONAS("Amazonas"), 
    BAHIA("Bahia"), CEARA("Ceará"), DISTRITO_FEDERAL("Distrito Federal"), ESPIRITO_SANTO("Espirito Santo"), 
    GOIAS("Goias"), MARANHAO("Maranhão"), MATO_GROSSO("Mato Grosso"), MATO_GROSSO_DO_SUL("Mato Grosso do Sul"), 
    MINAS_GERAIS("Minas Gerais"), PARA("Pará"), PARAIBA("Paraíba"), PARANA("Paraná"), PERNAMBUCO("Pernambuco"),
    PIAUI("Piauí"), RIO_DE_JANEIRO("Rio de Janeiro"), RIO_GRANDE_DO_NORTE("Rio Grande do Norte"), 
    RIO_GRANDE_DO_SUL("Rio Grande do Sul"), RONDONIA("Rondonia"), RORAIMA("Roraima"), SANTA_CATARINA("Santa Catarina"), 
    SAO_PAULO("São Paulo"), SERGIPE("Sergipe"), TOCANTINS("Tocantins");

    @Getter
    private final String descricao;

    private EstadoProvincia(String descricao) {
        this.descricao = descricao;
    }
}
