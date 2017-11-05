/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Entidade;

import com.fbp.projetox.Enums.Situacao;
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
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author F.Belmonte
 */
@Entity
public @Data
class Filial implements AbstractEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    private Empresa empresa;

    @NotNull(message = "O nome da Filial é Obrigatório!")
    private String nomefilial;

    @NotNull(message = "Informe o nome fantasia!")
    private String fantasia;

    @CNPJ(message = "CNPJ Invalido!")
    @NotEmpty(message = "C.N.P.J é Obrigatório!")
    private String Cnpj;

    private String telefone;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Endereco> enderecos = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Situacao situacao = Situacao.ATIVO;

}
