/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBackBean;

import com.fbp.projetox.Entidade.OrdemServico;
import com.fbp.projetox.Repositorio.OrdemServicos;
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
public class MbConsultaOrdemServico implements Serializable {

    @Inject
    OrdemServicos ordemServicos;

    @Getter
    @Setter
    OrdemServico ordemServico;

    List<OrdemServico> listaOrdemServicos;

    public List<OrdemServico> getListaOrdensServicos() {
        return ordemServicos.findAll();
    }

}
