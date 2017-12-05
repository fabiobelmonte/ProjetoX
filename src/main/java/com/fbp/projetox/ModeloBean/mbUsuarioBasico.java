/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.Endereco;
import com.fbp.projetox.Entidade.Usuario;
import com.fbp.projetox.Enums.OperadoraCelular;
import com.fbp.projetox.Enums.Permissao;
import com.fbp.projetox.Enums.Situacao;
import com.fbp.projetox.Enums.TipoEndereco;
import com.fbp.projetox.Repositorio.Usuarios;
import com.fbp.projetox.Servico.ConverterSHA1;
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
import org.primefaces.event.FlowEvent;

/**
 *
 * @author F.Belmonte
 */
@Named
@ViewScoped
public class mbUsuarioBasico implements Serializable {

    @Inject
    Usuarios usuarios;

    @Inject
    ConsultaCep consultaCep;

    @Getter
    @Setter
    Usuario usuario;

    @Getter
    @Setter
    Endereco endereco;

    List<Usuario> listaUsuario;

    private boolean skip;

    @Getter
    private final OperadoraCelular[] operadoraCelular;

    @Getter
    private final TipoEndereco[] tipoEndereco;

    @Getter
    private final Situacao[] situacao;
    
     @Getter
    private final Permissao[] permissao;

    public mbUsuarioBasico() {
        usuario = new Usuario();
        endereco = new Endereco();
        permissao = Permissao.values();
        operadoraCelular = OperadoraCelular.values();
        situacao = Situacao.values();
        tipoEndereco = TipoEndereco.values();
    }

    public List<Usuario> getListaUsuario() {
        return usuarios.findAll();
    }

    public String salvar() {
        
        usuario.setPermissao(Permissao.BASICO);
        usuario.setSituacao(Situacao.ATIVO);
        usuario.setSenha(ConverterSHA1.cipher(usuario.getSenha()));
        usuarios.save(usuario);

        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage("", new FacesMessage("Usuario Cadastrado com Sucesso!"));
        String novoUsuario = "/login.jsf?usuario=" + usuario.getUsuario();

        usuario = new Usuario();

        return novoUsuario;
    }

    public void mudaPagina() {
        try {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("", new FacesMessage("Usuario Cadastrado com Sucesso!"));
            ctx.getExternalContext().redirect("/ProjetoX/login.jsf");

        } catch (IOException ex) {
            Logger.getLogger(mbUsuarioBasico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvarEndereco() {
        endereco.getTipoEndereco();
        usuario.getEnderecos().add(endereco);
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
            System.out.println(ex.getMessage());
        }
        if (endereco != null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("", new FacesMessage("Endereço Localizado!"));
            salvarEndereco();
        }

    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {

        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }

    }

}
