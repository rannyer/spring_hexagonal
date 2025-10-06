package com.projeto.Api01.application.port;

import com.projeto.Api01.domain.models.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepositoryPort {
    Produto  salvar(Produto produto);
    Optional<Produto> buscarPorId(Long id);
    List<Produto> buscarTodos();
    void deletarPorId(Long id);
//[Service / Domínio] <--- Port ---> [Adapter / Externo]
}
