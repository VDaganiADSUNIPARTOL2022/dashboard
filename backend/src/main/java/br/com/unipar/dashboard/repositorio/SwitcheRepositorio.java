package br.com.unipar.dashboard.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unipar.dashboard.entidade.Switche;

@Repository
public interface SwitcheRepositorio extends JpaRepository<Switche, Long> {

}
