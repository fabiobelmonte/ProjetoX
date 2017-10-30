/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Entidade;

import com.fbp.projetox.Enums.EstadoProvincia;
import com.fbp.projetox.Enums.TipoEndereco;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author FA&GRA
 */
@Entity
public @Data
class Endereco implements AbstractEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String endereco;
    
    private String cep;
  
    private String numero;
    
    private String complemento;
    private String proximidade;
    private String referencia;
    private String bairro;
    private String cidade;
    
    private EstadoProvincia estado;
    
    private boolean principal;

    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;

}
