/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBackBean;

import com.fbp.projetox.Entidade.UnidadeMedida;
import com.fbp.projetox.Repositorio.UnidadeMedidas;
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
public class MbConsultaUnidadeMedida implements Serializable {

    @Inject
    UnidadeMedidas unidadeMedidas;

    @Getter
    @Setter
    UnidadeMedida unidadeMedida;

    List<UnidadeMedida> listaUnidadeMedidas;

    public List<UnidadeMedida> getListaUnidadeMedida() {
        return unidadeMedidas.findAll();
    }

}
