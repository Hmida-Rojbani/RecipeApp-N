package de.tekup.project.data.entities;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	private LocalTime prepTime;
	private LocalTime cookTime;
	private Integer servings;
	
	@Lob
	private String directions;
	
	@OneToMany(mappedBy = "recipe")
	private List<Ingredient> ingredients = new ArrayList<>();
	
	@Enumerated(value = EnumType.STRING)
	private Difficulty difficulty;
	
	public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }
	
	public String getPrepTime() {
		DateTimeFormatter form= DateTimeFormatter.ofPattern("HH 'Hour' mm 'Min'.");
		return prepTime.format(form);
	}

}
