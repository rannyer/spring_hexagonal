package com.projeto.Api01.infra.repositories;

import com.projeto.Api01.infra.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoJpaRepository extends JpaRepository<ProdutoEntity, Long> {
}
