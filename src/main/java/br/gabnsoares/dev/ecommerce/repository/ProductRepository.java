package br.gabnsoares.dev.ecommerce.repository;

import br.gabnsoares.dev.ecommerce.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <ProductEntity, Long> {
}
