/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.Cliente;
import com.fbp.projetox.Entidade.Endereco;
import com.fbp.projetox.Enums.EstadoCivil;
import com.fbp.projetox.Enums.EstadoProvincia;
import com.fbp.projetox.Enums.OperadoraCelular;
import com.fbp.projetox.Enums.Origem;
import com.fbp.projetox.Enums.RamoAtividade;
import com.fbp.projetox.Enums.SimNao;
import com.fbp.projetox.Enums.Situacao;
import com.fbp.projetox.Enums.TipoEndereco;
import com.fbp.projetox.Enums.TipoPessoa;
import com.fbp.projetox.Repositorio.Clientes;
import com.fbp.projetox.WebService.CepRetorno;
import com.fbp.projetox.WebService.ConsultaCep;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
public class MbCliente implements Serializable {

    @Inject
    Clientes clientes;

    @Inject
    ConsultaCep consultaCep;

    @Getter
    @Setter
    Cliente cliente;

    @Getter
    @Setter
    Endereco endereco;

    @Getter
    private final Situacao[] situacao;

    @Getter
    private final SimNao[] simNao;

    @Getter
    private final RamoAtividade[] ramoAtividade;

    @Getter
    private final TipoPessoa[] tipoPessoa;

    @Getter
    private final Origem[] origem;

    @Getter
    private final OperadoraCelular[] operadoraCelular;

    @Getter
    private final EstadoCivil[] estadoCivil;

    @Getter
    private final EstadoProvincia[] estadoProvincia;

    @Getter
    private final TipoEndereco[] tipoEndereco;

    List<Cliente> listaClientes;

    public List<Cliente> getListaClientes() {
        return clientes.findAll();
    }

    public MbCliente() {
        cliente = new Cliente();
        endereco = new Endereco();

        situacao = Situacao.values();
        simNao = SimNao.values();
        ramoAtividade = RamoAtividade.values();
        tipoPessoa = TipoPessoa.values();
        origem = Origem.values();
        operadoraCelular = OperadoraCelular.values();
        estadoCivil = EstadoCivil.values();
        estadoProvincia = EstadoProvincia.values();
        tipoEndereco = TipoEndereco.values();
    }

    public void salvar() {
        clientes.save(cliente);
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage("", new FacesMessage("Cliente Cadastrado com Sucesso!"));
        cliente = new Cliente();
        endereco = new Endereco();
    }

    public void salvarEndereco() {
        cliente.getEnderecos().add(endereco);
        endereco = new Endereco();
    }

    public void consultaEndereco() {
        try {
            String CEP = endereco.getCep();
            CepRetorno retorno = consultaCep.retorna(CEP);

            endereco.setEndereco(retorno.getEndereco());
            endereco.setBairro(retorno.getBairro());
            endereco.setCidade(retorno.getCidade());
            endereco.setEstado(retorno.getUf());

        } catch (IOException ex) {
            Logger.getLogger(MbCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void novoCliente() {
        cliente = new Cliente();
    }

    public void editarCliente() {
        if (cliente == null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("", new FacesMessage("Selecione um Clinte Primeiro!"));
        } else {
            org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('cadastrocliente').show()");
        }
    }
}
