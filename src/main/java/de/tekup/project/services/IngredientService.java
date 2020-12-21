package de.tekup.project.services;

import de.tekup.project.dto.models.IngredientRequest;

public interface IngredientService {

	void deleteById(long id);
	IngredientRequest saveIngredient(IngredientRequest request);
}
