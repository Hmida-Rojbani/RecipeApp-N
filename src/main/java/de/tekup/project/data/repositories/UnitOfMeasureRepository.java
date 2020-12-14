package de.tekup.project.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.project.data.entities.UnitOfMeasure;

public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure, Long>{
		 Optional<UnitOfMeasure> findByDescription(String description);
}
