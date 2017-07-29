/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Entidade;


import com.fbp.projetox.Enums.EstadoCivil;
import com.fbp.projetox.Enums.Operadora;
import com.fbp.projetox.Enums.Origem;
import com.fbp.projetox.Enums.RamoAtividade;
import com.fbp.projetox.Enums.Situacao;
import com.fbp.projetox.Enums.TipoPessoa;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author F.Belmonte
 */
@Entity
public @Data
class ClienteFornecedor implements AbstractEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String fantasia;
    private String cpfCnpj;
    private String incricaoEstatual;
    private String rg;
    private String emailNfe;
    private String fone;
    private String celular;
    private String informacaoAdicional;
    private BigDecimal limiteCredito;
    private String nomeMae;
    private String nomePai;

    /*ENUMS*/
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @Enumerated(EnumType.STRING)
    private RamoAtividade ramoAtividade;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @Enumerated(EnumType.STRING)
    private Origem origem;

    @Enumerated(EnumType.STRING)
    private Operadora operadora;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    /*TABELAS REFERENCIADAS*/
    @ManyToOne
    private Endereco endereco;

    @ManyToOne
    private Contato contato;

}
