package com.unifaj.restaurant.backend.controller;

import com.unifaj.restaurant.backend.model.Produto;
import com.unifaj.restaurant.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> buscarProdutos() {
        return produtoService.buscarProdutos();
    }

    @GetMapping("/{id}")
    public Produto obterProduto(@PathVariable int id) throws Exception {
        return produtoService.obterProduto(id);
    }

    @PostMapping("/")
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoService.criarProduto(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@RequestBody Produto produto, @PathVariable int id)
            throws Exception {
        return produtoService.atualizarProduto(produto, id);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable int id) {
        produtoService.deletarProduto(id);
    }
}
