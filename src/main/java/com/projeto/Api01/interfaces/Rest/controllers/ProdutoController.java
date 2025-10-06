package com.projeto.Api01.interfaces.Rest.controllers;

import com.projeto.Api01.application.services.ProdutoService;
import com.projeto.Api01.domain.models.Produto;
import com.projeto.Api01.interfaces.dtos.ProdutoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService produtoService) {
        this.service = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody ProdutoDTO dto){
        var produto = new Produto();
        BeanUtils.copyProperties(dto, produto);
        return ResponseEntity.ok(service.criarProduto(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deletePorId(@PathVariable Long id){
       service.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }


}
