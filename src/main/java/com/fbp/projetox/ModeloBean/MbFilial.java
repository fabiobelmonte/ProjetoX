/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.Endereco;
import com.fbp.projetox.Entidade.Filial;
import com.fbp.projetox.Enums.EstadoProvincia;
import com.fbp.projetox.Enums.Situacao;
import com.fbp.projetox.Enums.TipoEndereco;
import com.fbp.projetox.Repositorio.Filiais;
import com.fbp.projetox.WebService.CepRetorno;
import com.fbp.projetox.WebService.ConsultaCep;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
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
public class MbFilial implements Serializable {

    @Inject
    Filiais filiais;

    @Getter
    @Setter
    Filial filial;

    @Getter
    @Setter
    Endereco endereco;

    @Inject
    ConsultaCep consultaCep;

    List<Filial> listaMarcas;

    @Getter
    private final Situacao[] situacao;

    @Getter
    private final EstadoProvincia[] estadoProvincia;

    @Getter
    private final TipoEndereco[] tipoEndereco;
    
    
    public List<Filial> getListaFiliais() {
        return filiais.findAll();
    }

    public MbFilial() {
        filial = new Filial();
        endereco = new Endereco();
        situacao = Situacao.values();
        estadoProvincia = EstadoProvincia.values();
        tipoEndereco = TipoEndereco.values();
    }

    public void novaFilial() {
        filial = new Filial();
    }

    public void salvar() {
        filiais.save(filial);
        System.out.println(filial.getCnpj());
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage("", new FacesMessage("Filial Cadastrada/Alterada com sucesso!"));
        filial = new Filial();
    }

    public void salvarEndereco() {
        filial.getEnderecos().add(endereco);
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
            Logger.getLogger(MbClienteFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterarFilial() {
        if (filial == null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("", new FacesMessage("Selecione uma filial para alterar!"));
        } else {
            org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('alterarfilial').show()");
        }
    }

}
