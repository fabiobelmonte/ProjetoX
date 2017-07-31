/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Entidade;

import com.fbp.projetox.Enums.EstadoCivil;
import com.fbp.projetox.Enums.OperadoraCelular;
import com.fbp.projetox.Enums.Origem;
import com.fbp.projetox.Enums.RamoAtividade;
import com.fbp.projetox.Enums.Situacao;
import com.fbp.projetox.Enums.TipoPessoa;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 *
 * @author F.Belmonte
 */
@Entity
public @Data
class Cliente implements AbstractEntity {

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
    private TipoPessoa tipoPessoa = TipoPessoa.FISICA;

    @Enumerated(EnumType.STRING)
    private RamoAtividade ramoAtividade = RamoAtividade.CONSUMIDOR_FINAL;

    @Enumerated(EnumType.STRING)
    private Situacao situacao = Situacao.ATIVO;

    @Enumerated(EnumType.STRING)
    private Origem origem = Origem.NACIONAL;

    @Enumerated(EnumType.STRING)
    private OperadoraCelular operadora = OperadoraCelular.TIM;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil = EstadoCivil.SOLTEIRO;

    /*TABELAS REFERENCIADAS*/
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Contato> contatos = new ArrayList<>();

}
