package br.com.sicredi.api.validacpf.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "pauta")
@Data
@Builder
public class Pauta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo", length = 255)
	private String titulo;
	
	@Column(name = "data_validade")
	private LocalDateTime dataValidade;
	
	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao;
	
	@Column(name = "pauta_encerrada")
	private boolean encerrada;
	
	@Column(name = "total_votos")
	private Integer total;
	
	@OneToMany(mappedBy = "pauta")
	private List<Voto> votos;

	public Pauta() {
		super();
	}

	public Pauta(Long id, String titulo, LocalDateTime dataValidade, LocalDateTime dataCriacao, boolean encerrada,
			Integer total) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.dataValidade = dataValidade;
		this.dataCriacao = dataCriacao;
		this.encerrada = encerrada;
		this.total = total;
	}

	public Pauta(Long id, String titulo, LocalDateTime dataValidade, LocalDateTime dataCriacao, boolean encerrada,
			Integer total, List<Voto> votos) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.dataValidade = dataValidade;
		this.dataCriacao = dataCriacao;
		this.encerrada = encerrada;
		this.total = total;
		this.votos = votos;
	}
	
	

}
