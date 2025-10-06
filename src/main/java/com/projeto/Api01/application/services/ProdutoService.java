package com.projeto.Api01.application.services;

import com.projeto.Api01.application.port.PrecoLegadoPort;
import com.projeto.Api01.application.port.ProdutoRepositoryPort;
import com.projeto.Api01.domain.models.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {


//    Controller (DTO) → Domain (Produto) → Port (Repository) → Adapter (JPA)


    private final ProdutoRepositoryPort repository;
    private final PrecoLegadoPort precoLegadoPort;

    public ProdutoService(ProdutoRepositoryPort repository, PrecoLegadoPort precoLegadoPort){
        this.repository = repository;
        this.precoLegadoPort = precoLegadoPort;
    }

    public Produto criarProduto(Produto produto){
        return repository.salvar(produto);
    }

    public Produto atualizarProduto(Produto produto){
        return repository.salvar(produto);
    }

    public List<Produto> listarTodos(){
        return repository.buscarTodos();
    }
    public Produto buscarPorId(Long id){
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado") );
    }
    public void deletarProduto(Long id){
        repository.deletarPorId(id);
    }

    public void verificarPreçoLegado(String codigo){
        var preco = precoLegadoPort.buscarPrecoPorProduto(codigo);
        System.out.println("Preço vindo do sisterma legado:"+preco);
    }
}
