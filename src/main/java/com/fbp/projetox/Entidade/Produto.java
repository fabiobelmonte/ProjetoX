/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Entidade;

import com.fbp.projetox.Enums.SimNao;
import com.fbp.projetox.Enums.Situacao;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
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
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author F.Belmonte
 */
@Entity
@EqualsAndHashCode
public @Data
class Produto implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Informe uma descrição!")
    private String descricao;

    private Integer usuarioCadastro;
    private Integer usuarioAlteracao;

    @ManyToOne
    @NotNull(message = "A Unidade de Medida não pode ser vazia!")
    private UnidadeMedida unidadeMedida;

    @ManyToOne
    @NotNull(message = "Escolha uma Família!")
    private Familia familia;

    @ManyToOne
    @NotNull(message = "Escolha uma Marca!")
    private Marca marca;

    private String tipoProduto; //Comprado,produzido

    @Enumerated(EnumType.STRING)
    private SimNao requisitado;

    @Enumerated(EnumType.STRING)
    private SimNao vendido;

    @Enumerated(EnumType.STRING)
    private SimNao comprado;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Situacao situacao;

    private BigDecimal custo;

    @ManyToOne
    private Filial filial;

    @Column(scale = 5)
    private BigDecimal peso;
    private BigDecimal valorEmEstoque;

    private BigDecimal saldoEstoque;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAlteracao;

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

}
