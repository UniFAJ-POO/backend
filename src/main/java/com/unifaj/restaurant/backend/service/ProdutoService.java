package com.unifaj.restaurant.backend.service;

import com.unifaj.restaurant.backend.model.Produto;
import com.unifaj.restaurant.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto obterProduto(int id) throws Exception {
        return produtoRepository.findById(id).orElseThrow(() -> new Exception("Produto não existente"));
    }

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Produto produto, int id) throws Exception {
        Produto produtoToUpdate = produtoRepository.findById(id).orElseThrow(() -> new Exception("Produto não existente"));
        produtoToUpdate.setIdProduto(id);
        produtoToUpdate.setNomeProduto(produto.getNomeProduto());
        produtoToUpdate.setQtdProduto(produto.getQtdProduto());
        produtoToUpdate.setValorProduto(produto.getValorProduto());

        return produtoRepository.save(produtoToUpdate);
    }

    public void deletarProduto(int id) {
        produtoRepository.deleteById(id);
    }
}
