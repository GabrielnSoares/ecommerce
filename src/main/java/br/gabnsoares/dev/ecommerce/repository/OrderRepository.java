package br.gabnsoares.dev.ecommerce.repository;

import br.gabnsoares.dev.ecommerce.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
