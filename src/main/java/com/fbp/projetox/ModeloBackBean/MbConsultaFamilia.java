/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBackBean;
import com.fbp.projetox.Entidade.Familia;
import com.fbp.projetox.Repositorio.Familias;
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
public class MbConsultaFamilia implements Serializable {

    @Inject
    Familias familias;

    @Getter
    @Setter
    Familia familia;

    List<Familia> listaFamilias;

    public List<Familia> getListaFamilias() {
        return familias.findAll();
    }

    public MbConsultaFamilia() {
        familia = new Familia();
    }

}
