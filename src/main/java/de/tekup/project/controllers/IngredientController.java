package de.tekup.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import de.tekup.project.dto.models.IngredientRequest;
import de.tekup.project.dto.models.UnitOfMeasureRequest;
import de.tekup.project.services.IngredientService;
import de.tekup.project.services.RecipeService;
import de.tekup.project.services.UnitOfMeasureService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IngredientController {
	
	private RecipeService recipeService;
	private IngredientService ingredientService;
	private UnitOfMeasureService uomService;
	
	@GetMapping("/recipe/{recipeId}/ingredients")
	public String showIngredients(@PathVariable("recipeId") long recipeId, Model model) {
		model.addAttribute("recipeId", recipeId);
		model.addAttribute("ingredients", recipeService.getRecipeById(recipeId).getIngredients());
		return "recipe/ingredient/show";
	}
	
	
	// to delete an ingredient
	
	@GetMapping("/recipe/{recipeId}/ingredient/{id}/delete")
	public String deleteIngredient(@PathVariable("recipeId") long recipeId,
			@PathVariable("id") long id) {
		ingredientService.deleteById(id);
		return "redirect:/recipe/"+ recipeId + "/ingredients";
	}
	
	// Add new Ingredient
	@GetMapping("/recipe/{recipeId}/ingredient/add")
	public String newIngredient(@PathVariable("recipeId") long recipeId,
			Model model) {
		IngredientRequest ingredient = new IngredientRequest();
		ingredient.setRecipeId(recipeId);
		ingredient.setUom(new UnitOfMeasureRequest());
		model.addAttribute("ingredient", ingredient);
		
		model.addAttribute("uomList", uomService.listUOMs());
		return "recipe/ingredient/ingredientform";
	}

}
