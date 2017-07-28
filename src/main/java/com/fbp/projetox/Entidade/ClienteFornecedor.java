/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author F.Belmonte
 */
@Entity
public @Data class ClienteFornecedor implements AbstractEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String fantasia;
    private TipoPessoa tipoPessoa;
    private String cpfCnpj;
    private String incricaoEstatual;
    private String rg;
    private Situacao situacao;

    
    
    
    
    

}
