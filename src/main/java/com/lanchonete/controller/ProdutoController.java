
package com.lanchonete.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lanchonete.model.Produto;
import com.lanchonete.repository.ProdutoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepo;

    @GetMapping
    public List<Produto> listar() {
        return produtoRepo.findAll();
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoRepo.save(produto);
    }
    
    
}
