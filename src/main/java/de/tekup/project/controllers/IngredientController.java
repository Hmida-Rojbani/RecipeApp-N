package de.tekup.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IngredientController {
	
	
	@GetMapping("/recipe/{recipeId}/ingredients")
	public String showIngredients() {
		
		return "recipe/ingredient/show";
	}

}
