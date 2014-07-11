package br.com.silas.votenolivro.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class GenericValidator {
	
	protected void validarNotEmpty(String field, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, "field.required");
	}
}