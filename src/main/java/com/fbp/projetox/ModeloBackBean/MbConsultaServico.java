/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBackBean;

import com.fbp.projetox.Entidade.Servico;
import com.fbp.projetox.Entidade.TipoServico;
import com.fbp.projetox.ModeloBean.MbSelecionaFilial;
import com.fbp.projetox.Repositorio.Servicos;
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
public class MbConsultaServico implements Serializable {

    @Inject
    Servicos servicos;

    @Inject
    MbSelecionaFilial mbSelecionaFilial;

    @Getter
    @Setter
    Servico servico;

    @Getter
    @Setter
    TipoServico tipoServico;

    List<Servico> listaServicos;

    @Getter
    @Setter
    List<Servico> listaServicosPorTipoDeServico;

    public List<Servico> getListaServicos() {
        return servicos.servicoPorTipoEFilial(mbSelecionaFilial.getFilial());
    }

    public void pesquisaServicoPeloTipo() {
        listaServicosPorTipoDeServico = servicos.servicoPorTipodeServico(tipoServico);
    }

}
