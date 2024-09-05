package br.com.unipar.dashboard.servico;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.unipar.dashboard.entidade.Switche;
import br.com.unipar.dashboard.repositorio.SwitcheRepositorio;

@Service
public class SwitcheServico {

	private final SwitcheRepositorio switcheRepositorio;
	LocalDate min;
	LocalDate max;
	
	public SwitcheServico(SwitcheRepositorio switcheRepositorio) {
		this.switcheRepositorio = switcheRepositorio;
	}

	@Transactional(readOnly = true)
	public List<Switche> getAllMarca(String marca) {
		return switcheRepositorio.findAllByMarca(marca);
	}

	@Transactional(readOnly = true)
	public List<Switche> getAllHostName(String hostname) {
		return switcheRepositorio.findAllByHostname(hostname);
	}
}
