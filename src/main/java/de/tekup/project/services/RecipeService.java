package de.tekup.project.services;

import java.util.List;

import de.tekup.project.data.entities.Recipe;

public interface RecipeService {

	List<Recipe> getRecipes();
	Recipe getRecipeById(long id);
}
