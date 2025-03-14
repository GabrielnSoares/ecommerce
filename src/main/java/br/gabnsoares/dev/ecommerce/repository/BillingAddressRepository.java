package br.gabnsoares.dev.ecommerce.repository;

import br.gabnsoares.dev.ecommerce.entities.BillingAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingAddressRepository extends JpaRepository<BillingAddressEntity, Long> {
}
