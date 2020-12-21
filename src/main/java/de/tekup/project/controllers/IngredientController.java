package de.tekup.project.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	// save Ingredient
	@PostMapping("/recipe/{recipeId}/ingredient")
	public String saveOrUpdate(@Valid @ModelAttribute("ingredient")IngredientRequest ingredient, BindingResult bindingResult,
			@PathVariable("recipeId") long recipeId,Model model) {
		// if errors of validation return to form
		if (bindingResult.hasErrors()) {
			model.addAttribute("ingredient", ingredient);
			
			model.addAttribute("uomList", uomService.listUOMs());
			return "recipe/ingredient/ingredientform";
		}
		
		ingredientService.saveIngredient(ingredient);
		
		return "redirect:/recipe/"+ recipeId + "/ingredients";
	}
	
	// Update Ingredient
		@GetMapping("/recipe/{recipeId}/ingredient/{id}/update")
		public String updateIngredient(@PathVariable("recipeId") long recipeId,
				@PathVariable("id") long id,Model model) {
			IngredientRequest ingredient = ingredientService.findIngredientRequestById(id);
			ingredient.setRecipeId(recipeId);
			
			model.addAttribute("ingredient", ingredient);
			
			model.addAttribute("uomList", uomService.listUOMs());
			return "recipe/ingredient/ingredientform";
		}

}
