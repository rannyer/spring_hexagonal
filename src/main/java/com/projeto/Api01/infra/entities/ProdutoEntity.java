package com.projeto.Api01.infra.entities;

import com.projeto.Api01.domain.models.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer quantidade;
    private Double preco;

    public Produto toDomain(){
        return new Produto(id, nome, quantidade, preco);
    }

    public static ProdutoEntity fromDomain(Produto produto){
        ProdutoEntity entity =  new ProdutoEntity();
        entity.id = produto.getId();
        entity.nome = produto.getNome();
        entity.quantidade = produto.getQuantidade();
        entity.preco = produto.getPreco();
        return entity;
    }

}
