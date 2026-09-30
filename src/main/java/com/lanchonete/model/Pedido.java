
package com.lanchonete.model;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemPedido> itens;

    private Double total;
    
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
    public List<ItemPedido> getItens(){return itens;}
    public void setItens(List<ItemPedido> i){this.itens=i;}
    public Long getId() {return id;}
    public Double getTotal(){return total;}
    public void setTotal(Double t){this.total=t;}
}
