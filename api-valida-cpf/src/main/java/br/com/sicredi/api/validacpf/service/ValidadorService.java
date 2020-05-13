package br.com.sicredi.api.validacpf.service;

import br.com.sicredi.api.validacpf.enums.StatusVote;

public interface ValidadorService {

	StatusVote validaCpf(String cpf);
}
