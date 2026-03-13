package com.atividade.demo.controllers;

import com.atividade.demo.models.ProdutoModel;
import com.atividade.demo.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ProdutoModel criar(@RequestBody ProdutoModel produtoModel){
        return produtoService.criar(produtoModel);
    }

    @GetMapping
    public List<ProdutoModel> buscarTodosProdutos(){
        return produtoService.buscarTodosProdutos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        produtoService.deletar(id);
    }

    @PutMapping
    public ProdutoModel atualizar(@PathVariable Long id, @RequestBody ProdutoModel produtoModel){
        return  produtoService.atualizar(id, produtoModel);
    }


}
