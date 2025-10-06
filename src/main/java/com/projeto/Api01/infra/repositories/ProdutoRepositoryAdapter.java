package com.projeto.Api01.infra.repositories;

import com.projeto.Api01.application.port.ProdutoRepositoryPort;
import com.projeto.Api01.domain.models.Produto;
import com.projeto.Api01.infra.entities.ProdutoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProdutoRepositoryAdapter implements ProdutoRepositoryPort {


    private final ProdutoJpaRepository jpa;

    public ProdutoRepositoryAdapter(ProdutoJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Produto salvar(Produto produto) {
        return jpa.save(ProdutoEntity.fromDomain(produto)).toDomain();
    }

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        return jpa.findById(id).map(ProdutoEntity::toDomain);
    }

    @Override
    public List<Produto> buscarTodos() {
        return jpa.findAll().stream().map(ProdutoEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        jpa.deleteById(id);
    }
}
