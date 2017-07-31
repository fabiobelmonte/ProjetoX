package com.fbp.projetox.WebService;

import com.fbp.projetox.Enums.EstadoProvincia;
import lombok.Data;

/**
 *
 * @author F.Belmonte
 */

public @Data class CepRetorno {
    private String endereco;
    private String bairro;
    private String cidade;
    private EstadoProvincia uf;    
}
