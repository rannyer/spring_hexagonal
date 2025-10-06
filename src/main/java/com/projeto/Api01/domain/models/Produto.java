package com.projeto.Api01.domain.models;

public class Produto {
    private Long id;
    private String nome;
    private Integer quantidade;
    private Double preco;

    public Produto(Long id, String nome, Integer quantidade, Double preco) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Produto() {
    }

    public void reduzirEstoque(int qtd){
        if(quantidade < qtd)
            throw  new IllegalArgumentException("Estoque insuficiente");
        this.quantidade -= qtd;
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPreco() {
        return preco;
    }
}
