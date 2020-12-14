package de.tekup.project.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import de.tekup.project.data.entities.Recipe;
import de.tekup.project.data.repositories.RecipeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService{

	private RecipeRepository reposRecipe;
	
	@Override
	public List<Recipe> getRecipes() {
		return reposRecipe.findAll();
	}

	@Override
	public Recipe getRecipeById(long id) {
		
		return reposRecipe.findById(id)
						.orElseThrow(()-> new NoSuchElementException("Recipe with this id is not found"));
	}

}
