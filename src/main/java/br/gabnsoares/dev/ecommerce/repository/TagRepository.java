package br.gabnsoares.dev.ecommerce.repository;

import br.gabnsoares.dev.ecommerce.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
}
