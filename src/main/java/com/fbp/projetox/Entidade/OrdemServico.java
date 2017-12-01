/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Entidade;

import com.fbp.projetox.Enums.SituacaoOds;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author FA&GRA
 */
@Entity
public @Data
class OrdemServico implements AbstractEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    /*TABELAS REFERENCIADAS*/
    @ManyToMany
    private List<Servico> servicos = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private SituacaoOds situacaoOds = SituacaoOds.ABERTA;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEmissao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFechamento;

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdemServico)) {
            return false;
        }
        OrdemServico other = (OrdemServico) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return "com.fbp.projetox.Entidade.OrdemServico[ id=" + id + " ]";
    }

}
