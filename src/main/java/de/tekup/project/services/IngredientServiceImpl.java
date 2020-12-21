package de.tekup.project.services;

import org.springframework.stereotype.Service;

import de.tekup.project.data.repositories.IngredientRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {

	private IngredientRepository reposIngred;
	@Override
	public void deleteById(long id) {
	
		reposIngred.deleteById(id);
 
	}

}
