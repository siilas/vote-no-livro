package br.com.silas.votenolivro.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.silas.votenolivro.model.Ponto;

public class PontoValidator extends GenericValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Ponto.class.equals(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
	}
}