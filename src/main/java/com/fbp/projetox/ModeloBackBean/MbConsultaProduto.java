/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.ModeloBackBean;

import com.fbp.projetox.ModeloBean.*;
import com.fbp.projetox.Entidade.Filial;
import com.fbp.projetox.Entidade.Marca;
import com.fbp.projetox.Entidade.Produto;
import com.fbp.projetox.Repositorio.Produtos;
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
public class MbConsultaProduto implements Serializable {

    @Inject
    Produtos produtos;

    @Inject
    MbSelecionaFilial mbSelecionaFilial;

    @Getter
    @Setter
    private Produto produto;

    @Getter
    @Setter
    private Filial filial;

    @Getter
    @Setter
    private Marca marca;

    @Getter
    @Setter
    List<Produto> listaSaldoProdutos;

    List<Produto> listaProdutos;

    @Getter
    List<Produto> listaProdutoMarca;

    public List<Produto> getListaProdutos() {
        return produtos.getProdutoFilial(mbSelecionaFilial.getFilial());
    }

    public void buscaSaldos() {
        listaSaldoProdutos = produtos.pesquisaSaldoProduto(marca, produto, filial);
    }

    public void pesquisaProdutoMarca() {
        listaProdutoMarca = produtos.getProdutoMarca(marca, mbSelecionaFilial.getFilial());
    }
}
