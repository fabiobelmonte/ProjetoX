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
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author F.Belmonte
 */
@Entity
public @Data
class UnidadeMedida implements AbstractEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "A Descrição da U.M não pode ser vazia!")
    private String descricao;

}
