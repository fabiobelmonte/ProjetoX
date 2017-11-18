/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbp.projetox.Entidade;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author FA&GRA
 */
@Entity
public @Data class CondicaoDePagamento implements AbstractEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "A Condição de Pagamento é obrigatória!")
    private String descricaoCondicaoDePagamento;
    
    private BigDecimal quantidadeDeParcela;

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CondicaoDePagamento)) {
            return false;
        }
        CondicaoDePagamento other = (CondicaoDePagamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fbp.projetox.Entidade.FormaDePagamento[ id=" + id + " ]";
    }
    
}
