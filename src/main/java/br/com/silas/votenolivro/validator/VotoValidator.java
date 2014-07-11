package br.com.silas.votenolivro.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.silas.votenolivro.model.Voto;

public class VotoValidator extends GenericValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Voto.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		validarNotEmpty("livro", errors);
	}
}