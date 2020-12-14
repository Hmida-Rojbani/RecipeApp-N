package de.tekup.project.services;

import java.util.List;

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

}
