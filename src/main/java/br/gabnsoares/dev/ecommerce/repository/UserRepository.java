package br.gabnsoares.dev.ecommerce.repository;

import br.gabnsoares.dev.ecommerce.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
