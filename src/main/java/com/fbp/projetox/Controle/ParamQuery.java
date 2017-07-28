/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Controle;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 *
 * @author F.Belmonte
 */
public class ParamQuery {

    @Getter
    private List<ParamQuery> params;

    @Getter
    private String param;

    @Getter
    private Object object;

    public ParamQuery() {
        this.params = new ArrayList<>();
    }

    public void add(String param, Object object) {
        params.add(new ParamQuery(param, object));
    }

    private ParamQuery(String param, Object object) {
        this.param = param;
        this.object = object;
    }

}