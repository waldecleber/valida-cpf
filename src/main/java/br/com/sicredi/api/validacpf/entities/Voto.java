package br.com.sicredi.api.validacpf.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "voto")
@Data
@Builder
public class Voto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "resposta")
	private boolean resposta;
	
	@Column(name = "data_voto")
	private LocalDateTime data;
	
	@JoinColumn(name = "id_associado")
	@OneToOne(fetch = FetchType.LAZY)
	private Associado associado;
	
	@JoinColumn(name = "id_pauta")
	@ManyToOne(fetch = FetchType.LAZY)
	private Pauta pauta;

	public Voto() {
		super();
	}

	public Voto(Long id, boolean resposta, LocalDateTime data, Associado associado, Pauta pauta) {
		super();
		this.id = id;
		this.resposta = resposta;
		this.data = data;
		this.associado = associado;
		this.pauta = pauta;
	}
	
	
	
	
}
