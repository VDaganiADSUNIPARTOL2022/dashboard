package br.com.unipar.dashboard.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.unipar.dashboard.entidade.Switche;

@Repository
public interface SwitcheRepositorio extends JpaRepository<Switche, Long> {

	@Query("SELECT s FROM Switche s WHERE (:hostname IS NULL OR s.hostname = :hostname) AND (:marca IS NULL OR s.marca = :marca) AND (:data IS NULL OR s.numSerie = :data)")
	Page<Switche> findAll(@Param("hostname") String hostname, @Param("marca") String marca, @Param("data") String data, Pageable pageable);

}
