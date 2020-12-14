package de.tekup.project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.project.services.RecipeService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class RecipeController {

	private RecipeService service;
	
	@GetMapping("/recipe/{id}/show")
	public String viewRecipe(@PathVariable("id") long id) {
		
		return "recipe/show";
	}
}
