package de.tekup.project.dto.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UnitOfMeasureRequest {

	private Long id;
	@NotBlank
	@Size(min = 2)
	private String description;
}
