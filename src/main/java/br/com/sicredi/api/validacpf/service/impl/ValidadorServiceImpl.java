package br.com.sicredi.api.validacpf.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.sicredi.api.validacpf.entities.Voto;
import br.com.sicredi.api.validacpf.enums.StatusVote;
import br.com.sicredi.api.validacpf.exception.CpfInvalidoException;
import br.com.sicredi.api.validacpf.exception.CpfVotoUnicoExpection;
import br.com.sicredi.api.validacpf.repository.ValidaVotoRepository;
import br.com.sicredi.api.validacpf.service.ValidadorService;

@Service
public class ValidadorServiceImpl implements ValidadorService {
	
	@Autowired
	private ValidaVotoRepository votoRepository;

	@Override
	public StatusVote validaCpf(String cpf, Long idPauta) {
		CPFValidator cpfValidator = new CPFValidator();
		try {
			cpfValidator.assertValid(cpf);
			
			if (Objects.isNull(buscarVotoPorAssociado(cpf, idPauta))) {
				return StatusVote.ABLE_TO_VOTE;				
			} else {
				return StatusVote.UNABLE_TO_VOTE;
			}
		} catch (Exception e) {
			throw new CpfInvalidoException("CPF inválido!");
		}
	}
	
	public Voto buscarVotoPorAssociado(String cpf, Long idPauta) {
		return votoRepository.findVotoPorAssociado(cpf, idPauta).orElse(null);
		
	}

}
