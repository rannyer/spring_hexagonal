package com.projeto.Api01.application.port;

import java.math.BigDecimal;

public interface PrecoLegadoPort {
    BigDecimal buscarPrecoPorProduto(String codigo);
}
