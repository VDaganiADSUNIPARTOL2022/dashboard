package br.com.unipar.dashboard.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.unipar.dashboard.entidade.Switche;

@Repository
public interface SwitcheRepositorio extends JpaRepository<Switche, Long> {
	List<Switche> findAllByMarca(String marca);

	List<Switche> findAllByHostname(String hostname);
	
	@Query("SELECT distinct s.modelo, COUNT(*) FROM Switche s GROUP BY s.modelo ORDER BY s.modelo")
	List<Switche> findAllByModelo(String hostname);
	
}
