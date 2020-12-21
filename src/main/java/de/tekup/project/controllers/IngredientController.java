package de.tekup.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import de.tekup.project.services.RecipeService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IngredientController {
	
	private RecipeService recipeService;
	
	@GetMapping("/recipe/{recipeId}/ingredients")
	public String showIngredients(@PathVariable("recipeId") long recipeId, Model model) {
		model.addAttribute("recipeId", recipeId);
		model.addAttribute("ingredients", recipeService.getRecipeById(recipeId).getIngredients());
		return "recipe/ingredient/show";
	}

}
