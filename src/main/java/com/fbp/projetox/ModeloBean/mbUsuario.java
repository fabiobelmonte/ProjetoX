/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.Endereco;
import com.fbp.projetox.Entidade.Usuario;
import com.fbp.projetox.Enums.OperadoraCelular;
import com.fbp.projetox.Enums.Situacao;
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

/**
 *
 * @author F.Belmonte
 */
@Named
@ViewScoped
public class mbUsuario implements Serializable {

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

    @Getter
    private final OperadoraCelular[] operadoraCelular;

    @Getter
    private final Situacao[] situacao;

    public mbUsuario() {
        usuario = new Usuario();
        operadoraCelular = OperadoraCelular.values();
        situacao = Situacao.values();
    }

    public void novoUsuario() {
        usuario = new Usuario();
    }

    public List<Usuario> getListaUsuario() {
        return usuarios.findAll();
    }

    public void salvar() {

        usuario.setSenha(ConverterSHA1.cipher(usuario.getSenha()));
        usuarios.save(usuario);
        FacesContext ctx = FacesContext.getCurrentInstance();

        ctx.addMessage("", new FacesMessage("Usuario Cadastrado com Sucesso!"));
        usuario = new Usuario();
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

    public void editaUsuario() {
        if (usuario == null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("", new FacesMessage("Selecione um usuario primeiro!"));
        } else {
            org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('cadastrousuario').show()");
        }
    }
}
