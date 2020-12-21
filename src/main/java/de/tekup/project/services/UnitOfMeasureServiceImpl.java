package de.tekup.project.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.project.data.repositories.UnitOfMeasureRepository;
import de.tekup.project.dto.models.UnitOfMeasureRequest;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

	private ModelMapper mapper;
	private UnitOfMeasureRepository uomRepos;
	@Override
	public List<UnitOfMeasureRequest> listUOMs() {
		
		return uomRepos.findAll().stream()
								.map(u -> mapper.map(u, UnitOfMeasureRequest.class))
								.collect(Collectors.toList());
	}

}
