package br.com.sicredi.api.validacpf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CpfVotoUnicoExpection extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CpfVotoUnicoExpection(String msg) {
		super(msg);
	}

}
