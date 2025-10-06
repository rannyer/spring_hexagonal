package com.projeto.Api01.infra.legacy;

import com.projeto.Api01.application.port.PrecoLegadoPort;
import com.projeto.Api01.domain.models.Produto;
import com.projeto.Api01.interfaces.dtos.ProdutoDTO;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class PrecoLegadoAdapter implements PrecoLegadoPort {

    private final RestTemplate restTemplate =  new RestTemplate();

    @Override
    public BigDecimal buscarPrecoPorProduto(String codigo) {

        ProdutoDTO resposta = restTemplate.getForObject("http://api_legado.com/api/produtos/"+codigo, ProdutoDTO.class);
        //aplicar parsing de informações/regras de negocio de transação


        return new BigDecimal(resposta.preco());
    }
}
