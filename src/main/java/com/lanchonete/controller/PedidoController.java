package com.lanchonete.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lanchonete.model.ItemPedido;
import com.lanchonete.model.Pedido;
import com.lanchonete.model.Produto;
import com.lanchonete.model.StatusPedido;
import com.lanchonete.repository.PedidoRepository;
import com.lanchonete.repository.ProdutoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepo;

    @Autowired
    private ProdutoRepository produtoRepo;
    
    @PostMapping
    public Pedido criarPedido(
            @RequestBody Pedido pedido) {

        double total = 0.0;

        for (ItemPedido item : pedido.getItens()) {

            Produto produto =
                    produtoRepo.findById(
                            item.getProduto().getId())
                            .orElseThrow();

            item.setProduto(produto);

            total += produto.getPreco()
                    * item.getQuantidade();
        }

        pedido.setTotal(total);

        pedido.setStatus(
                StatusPedido.RECEBIDO);

        return pedidoRepo.save(pedido);
    }
    
    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoRepo.findAll();
    }
    
    @PutMapping("/{id}/status")
    public Pedido alterarStatus(
            @PathVariable Long id,
            @RequestParam StatusPedido status) {

        Pedido pedido =
            pedidoRepo.findById(id)
            .orElseThrow();

        pedido.setStatus(status);

        return pedidoRepo.save(pedido);
    }
}