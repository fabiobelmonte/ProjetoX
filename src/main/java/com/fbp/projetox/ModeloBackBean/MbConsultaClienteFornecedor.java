/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBackBean;

import com.fbp.projetox.Entidade.ClienteFornecedor;
import com.fbp.projetox.Entidade.Endereco;
import com.fbp.projetox.Repositorio.Clientes;
import com.fbp.projetox.WebService.ConsultaCep;
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
public class MbConsultaClienteFornecedor implements Serializable {

    @Inject
    Clientes clientes;

    @Inject
    ConsultaCep consultaCep;

    @Getter
    @Setter
    ClienteFornecedor cliente;

    @Getter
    @Setter
    Endereco endereco;

    List<ClienteFornecedor> listaClientes;

    public List<ClienteFornecedor> getListaClientes() {
        return clientes.findAll();
    }

}
