package br.com.unipar.dashboard.servico;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Switche> getAllPaged(String hostname, String marca, String minDate, String maxDate, Pageable pageable) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		return switcheRepositorio.findAll(hostname, marca, min, max, pageable);
	}
}
