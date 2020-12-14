package de.tekup.project.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.project.data.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>{

}
