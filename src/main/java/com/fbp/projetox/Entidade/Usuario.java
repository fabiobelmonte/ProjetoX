/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Entidade;

import com.fbp.projetox.Enums.OperadoraCelular;
import com.fbp.projetox.Enums.Situacao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author F.Belmonte
 */
@Entity 
public @Data
class Usuario implements AbstractEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O Usuário é Obrigatório")
    private String usuario;

    @NotEmpty(message = "O Nome é Obrigatório")
    private String nomeCompleto;

    @NotEmpty(message = "A Senha é Obrigatório")
    private String senha;

    @Enumerated(EnumType.STRING)
    private OperadoraCelular operadora = OperadoraCelular.TIM;

    private String telefoneFixo;
    
    private String celular;

    private String email;

    @Enumerated(EnumType.STRING)
    private Situacao situacao = Situacao.ATIVO;

    @ManyToOne(optional = true)
    private Filial ultimaFilialLogada;

    /*TABELAS REFERENCIADAS*/
    @OneToMany(cascade = CascadeType.ALL)
    @Column(nullable = true)
    private List<Endereco> enderecos = new ArrayList<>();

}
