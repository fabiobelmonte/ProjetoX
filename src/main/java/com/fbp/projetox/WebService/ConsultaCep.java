package com.fbp.projetox.WebService;

import com.fbp.projetox.Enums.EstadoProvincia;
import java.io.IOException;
import java.net.SocketTimeoutException;
import javax.ejb.Stateless;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author FA&GRA
 */
@Stateless
public class ConsultaCep {

    public CepRetorno retorna(String CEP) throws IOException {
        CepRetorno ret = new CepRetorno();
        try {
            Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP)
                    .timeout(120000)
                    .get();
            Elements urlPesquisa = doc.select("span[itemprop=streetAddress]"); // endereço
            ret.setEndereco(urlPesquisa.get(0).text());

            urlPesquisa = doc.select("td:gt(1)"); //bairro
            ret.setBairro(urlPesquisa.get(0).text());

            urlPesquisa = doc.select("span[itemprop=addressLocality]");//cidade
            ret.setCidade(urlPesquisa.get(0).text());

            urlPesquisa = doc.select("span[itemprop=addressRegion]"); //uf            
            ret.setUf(EstadoProvincia.valueOf(urlPesquisa.get(0).text()));

        } catch (SocketTimeoutException | HttpStatusException e) {

        }
        return ret;
    }
}
