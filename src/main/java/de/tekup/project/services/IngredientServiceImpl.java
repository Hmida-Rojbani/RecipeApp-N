package de.tekup.project.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.project.data.entities.Ingredient;
import de.tekup.project.data.repositories.IngredientRepository;
import de.tekup.project.dto.models.IngredientRequest;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {

	private IngredientRepository reposIngred;
	private ModelMapper mapper;
	@Override
	public void deleteById(long id) {
	
		reposIngred.deleteById(id);
 
	}
	@Override
	public IngredientRequest saveIngredient(IngredientRequest request) {
		// save 
		Ingredient ingredientEntity = mapper.map(request, Ingredient.class);
		
		reposIngred.save(ingredientEntity);
		
		// update
		return null;
	}

}
