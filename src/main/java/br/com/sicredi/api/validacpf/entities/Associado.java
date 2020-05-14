package br.com.sicredi.api.validacpf.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "associado")
@Data
@Builder
public class Associado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cpf")
	private String cpf;

	public Associado() {
		super();
	}
	
	public Associado(Long id, String cpf) {
		super();
		this.id = id;
		this.cpf = cpf;
	}
}
