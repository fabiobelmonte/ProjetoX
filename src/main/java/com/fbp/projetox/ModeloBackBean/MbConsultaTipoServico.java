/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBackBean;

import com.fbp.projetox.Entidade.Filial;
import com.fbp.projetox.Entidade.Marca;
import com.fbp.projetox.Entidade.Servico;
import com.fbp.projetox.Entidade.TipoServico;
import com.fbp.projetox.ModeloBean.MbSelecionaFilial;
import com.fbp.projetox.Repositorio.TipoServicos;
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
public class MbConsultaTipoServico implements Serializable {

    @Inject
    TipoServicos tipoServicos;

    @Inject
    MbSelecionaFilial mbSelecionaFilial;

    @Getter
    @Setter
    TipoServico tipoServico;

    @Getter
    @Setter
    private Filial filial;

    List<TipoServico> listaTipoServicos;

    public List<TipoServico> getListaTipoServicos() {
        return tipoServicos.tipoServicoPorFilial(mbSelecionaFilial.getFilial());
    }

}
