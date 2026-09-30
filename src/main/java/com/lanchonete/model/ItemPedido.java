
package com.lanchonete.model;
import jakarta.persistence.*;

@Entity
public class ItemPedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    private Integer quantidade;

    public Produto getProduto(){return produto;}
    public void setProduto(Produto p){this.produto=p;}
    public Integer getQuantidade(){return quantidade;}
    public void setQuantidade(Integer q){this.quantidade=q;}
}
