/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBackBean;

import com.fbp.projetox.Entidade.Filial;
import com.fbp.projetox.Repositorio.Filiais;
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
public class MbConsultaFilial implements Serializable {

    @Inject
    Filiais filiais;

    @Getter
    @Setter
    Filial filial;

   
    public List<Filial> getListaFiliais() {
        return filiais.findAll();
    }

    public MbConsultaFilial() {
        filial = new Filial();
        
    }

    public void novaFilial() {
        filial = new Filial();
    }

  
}
