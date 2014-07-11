package br.com.silas.votenolivro.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.silas.votenolivro.model.Livro;

public class LivroValidator extends GenericValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Livro.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		validarNotEmpty("nome", errors);
		validarNotEmpty("genero", errors);
	}
}