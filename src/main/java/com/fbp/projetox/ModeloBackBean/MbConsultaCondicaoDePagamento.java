/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBackBean;

import com.fbp.projetox.Entidade.CondicaoDePagamento;
import com.fbp.projetox.Repositorio.CondicoesDePagamentos;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author F.Belmonte
 */
@Named
@ViewScoped
public class MbConsultaCondicaoDePagamento implements Serializable {

    @Inject
    CondicoesDePagamentos condicoesDePagamentos;

    @Getter
    @Setter
    CondicaoDePagamento condicaoDePagamento;

    List<CondicaoDePagamento> listaCondicaoDePagamentos;

    public List<CondicaoDePagamento> getListaCondicaoDePagamentos() {
        return condicoesDePagamentos.findAll();
    }

}
