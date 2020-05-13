package br.com.sicredi.api.validacpf.service.impl;

import org.springframework.stereotype.Service;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.sicredi.api.validacpf.enums.StatusVote;
import br.com.sicredi.api.validacpf.service.ValidadorService;

@Service
public class ValidadorServiceImpl implements ValidadorService {

	@Override
	public StatusVote validaCpf(String cpf) {
		CPFValidator cpfValidator = new CPFValidator();
		try {
			cpfValidator.assertValid(cpf);
			return StatusVote.ABLE_TO_VOTE;
		} catch (Exception e) {
			e.printStackTrace();
			return StatusVote.UNABLE_TO_VOTE;
		}
	}

}
