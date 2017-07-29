/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Entidade;

import com.fbp.projetox.Entidade.AbstractEntity;
import com.fbp.projetox.Enums.SimNao;
import com.fbp.projetox.Enums.Situacao;
import com.fbp.projetox.Enums.UnidadeMedida;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author F.Belmonte
 */
@Entity
public @Data
class Produto implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String descricao;

    private Integer usuarioCadastro;
    private Integer usuarioAlteracao;

    @ManyToOne
    @NotNull(message = "A Unidade de Medida não pode ser vazia")
    private UnidadeMedida unidadeMedida;

    @ManyToOne
    @NotNull
    private Familia familia;

    @ManyToOne
    private Marca marca;

    private String tipoProduto; //Comprado,produzido

    @Enumerated(EnumType.STRING)
    private SimNao requisitado;

    @Enumerated(EnumType.STRING)
    private SimNao vendido;

    @Enumerated(EnumType.STRING)
    private SimNao comprado;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    private BigDecimal custo;
    private BigDecimal peso;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAlteracao;

}
