/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Entidade;

import java.io.Serializable;

/**
 *
 * @author F.Belmonte
 */
/**
 * Estipula um contrato base para as entidades persistentes da aplicação.
 *
 * <p>
 * Esse contrato é utilizado pelo componente responsável pelas operações básicas
 * de persistência: <code>AbstractPersistence</code>.</p>
 *
 * @author Diego Arantes
 */
public interface AbstractEntity extends Serializable {

    /**
     * @return A referência para a chave primária (Primary Key) de cada objeto
     * persistido. Caso o objeto ainda não tenha sido persistido, deve retornar
     * <code>null</code>.
     */
    public Number getId();
}
