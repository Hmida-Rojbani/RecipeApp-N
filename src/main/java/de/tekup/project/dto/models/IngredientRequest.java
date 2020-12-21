package de.tekup.project.dto.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class IngredientRequest {
	
	private Long id;
	@NotBlank
	@Size(min = 5)
	private String description;
	@Positive
	private Double amount;
	@Valid
	private UnitOfMeasureRequest uom;
	
	private long recipeId;
	
	

}
