/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBean;

import com.fbp.projetox.Entidade.OrdemServico;
import com.fbp.projetox.Entidade.Servico;
import com.fbp.projetox.Enums.SituacaoOds;
import com.fbp.projetox.Repositorio.OrdemServicos;
import java.io.Serializable;
import java.util.Date;
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
public class MbOrdemServico implements Serializable {

    @Inject
    OrdemServicos ordenServicos;

    @Inject
    MbLogin mbLogin;

    @Getter
    @Setter
    OrdemServico ordemServico;

    @Getter
    @Setter
    Servico servico;

    @Getter
    private final SituacaoOds[] situacaoOds;

    public MbOrdemServico() {
        ordemServico = new OrdemServico();
        situacaoOds = SituacaoOds.values();
        ordemServico.setDataEmissao(new Date());
    }

    public void salvar() {
        ordemServico.setUsuario(mbLogin.usuarioLogado());
        ordemServico.setSituacaoOds(SituacaoOds.ABERTA);
        ordenServicos.save(ordemServico);

        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage("", new FacesMessage("Serviço Adicionado com Sucesso!"));
        ordemServico = new OrdemServico();
        ordemServico.setDataEmissao(new Date());
    }

    public void salvarServico() {
        ordemServico.getServicos().add(servico);
    }

    public void editarOrdemServico() {
        if (ordemServico == null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("", new FacesMessage("Selecione uma Orderm de Serviço primeiro!"));
        } else {
//            org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('').show()");
        }
    }
}
