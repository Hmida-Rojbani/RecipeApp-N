package de.tekup.project.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.project.data.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{

}
