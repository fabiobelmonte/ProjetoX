/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Entidade;

import com.fbp.projetox.Enums.EntradaSaida;
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
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author FA&GRA
 */
@Entity
@Data
@EqualsAndHashCode(of = "id")
public class MovimentoEstoque implements AbstractEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private BigDecimal quantidadeMovimentada;
    private BigDecimal valorMovimento;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataMovimento;
    private String observacaoMovimento;

    @Enumerated(EnumType.STRING)
    private EntradaSaida tipoMovimento;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Filial filial;

}
