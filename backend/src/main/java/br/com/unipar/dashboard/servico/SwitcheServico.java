package br.com.unipar.dashboard.servico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.unipar.dashboard.entidade.Switche;
import br.com.unipar.dashboard.repositorio.SwitcheRepositorio;

@Service
public class SwitcheServico {

	private final SwitcheRepositorio switcheRepositorio;
	
	public SwitcheServico(SwitcheRepositorio switcheRepositorio) {
		this.switcheRepositorio = switcheRepositorio;
	}

	public Page<Switche> getAllPaged(String hostname, String marca, String data, Pageable pageable) {
		return switcheRepositorio.findAll(hostname, marca, data, pageable);
	}
}
