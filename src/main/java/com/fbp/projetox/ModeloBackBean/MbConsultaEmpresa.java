/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBackBean;

import com.fbp.projetox.Entidade.Empresa;
import com.fbp.projetox.Repositorio.Empresas;
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
public class MbConsultaEmpresa implements Serializable {

    @Inject
    Empresas empresas;

    @Getter
    @Setter
    Empresa empresa;

    List<Empresa> listaEmpresas;

    public List<Empresa> getListaEmpresas() {
        return empresas.findAll();
    }

    public MbConsultaEmpresa() {
        empresa = new Empresa();
    }

}
