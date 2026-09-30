
package com.lanchonete.model;
import jakarta.persistence.*;

@Entity
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;

    public Long getId(){return id;}
    public String getNome(){return nome;}
    public void setNome(String n){this.nome=n;}
    public Double getPreco(){return preco;}
    public void setPreco(Double p){this.preco=p;}
}
