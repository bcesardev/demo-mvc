package com.cesar.bruno.curso.boot.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cesar.bruno.curso.boot.domain.Funcionario;

public class FuncionarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Funcionario f = (Funcionario) target;

		if (f.getDataSaida() != null) {
			if (f.getDataSaida().isBefore(f.getDataEntrada())) {
				errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");
			}
		}
	}

}
