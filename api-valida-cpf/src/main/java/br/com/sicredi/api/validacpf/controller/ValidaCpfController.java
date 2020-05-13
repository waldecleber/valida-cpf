package br.com.sicredi.api.validacpf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.api.validacpf.enums.StatusVote;
import br.com.sicredi.api.validacpf.service.ValidadorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/valida")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ValidaCpfController {
	
	private final ValidadorService validadorService;
	
	@GetMapping(path = "/{cpf}")
	public ResponseEntity<StatusVote> validaCpf(@PathVariable String cpf) {		
		return ResponseEntity.ok().body(validadorService.validaCpf(cpf));
	}

}
