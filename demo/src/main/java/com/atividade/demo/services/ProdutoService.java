package com.atividade.demo.services;

import com.atividade.demo.models.ProdutoModel;
import com.atividade.demo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel criar(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> buscarTodosProdutos(){
        return produtoRepository.findAll();
    }

    public void deletar(Long id){
        produtoRepository.deleteById(id);
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produtoModel){
        ProdutoModel newProduto = produtoRepository.findById(id).get();

        newProduto.setNome(produtoModel.getNome());

        return produtoRepository.save(newProduto);
    }
}
