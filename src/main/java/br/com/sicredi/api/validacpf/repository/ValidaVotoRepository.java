package br.com.sicredi.api.validacpf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.sicredi.api.validacpf.entities.Voto;

@RepositoryRestResource(collectionResourceRel = "validaVoto", path = "validaVoto")
public interface ValidaVotoRepository extends JpaRepository<Voto, Long> {

	@Query(" SELECT v FROM Voto v "
			+ " WHERE v.associado.cpf = :cpf "
			+ "	AND v.pauta.id = :idPauta")
	Optional<Voto> findVotoPorAssociado(@Param("cpf") String cpf, @Param("idPauta") Long idPauta);

}
