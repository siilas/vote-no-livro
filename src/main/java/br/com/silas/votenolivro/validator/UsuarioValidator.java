package br.com.silas.votenolivro.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.silas.votenolivro.model.Usuario;

public class UsuarioValidator extends GenericValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		validarNotEmpty("nome", errors);
		validarNotEmpty("email", errors);
		validarEmail(object, errors);
	}

	private void validarEmail(Object object, Errors errors) {
		Usuario usuario = (Usuario) object;
		Pattern pattern = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher matcher = pattern.matcher(usuario.getEmail());
		if (!matcher.find()) {
			errors.rejectValue("email", "email.invalido");
		}
	}
}