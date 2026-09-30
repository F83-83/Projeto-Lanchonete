
package com.lanchonete.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lanchonete.model.Produto;
public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
