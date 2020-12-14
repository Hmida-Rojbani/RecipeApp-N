package de.tekup.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.tekup.project.services.RecipeService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IndexController {
	
	// call service 
	private RecipeService service;
	// to get all Recipes
	
	// add recipes to model of index.html
	@GetMapping({"","/","/index"})
	public String getIndex(Model model) {
		model.addAttribute("recipes", service.getRecipes());
		return "index";
	}

}
