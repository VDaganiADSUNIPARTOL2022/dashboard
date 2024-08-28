package br.com.unipar.dashboard.controlador;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.unipar.dashboard.entidade.Switche;
import br.com.unipar.dashboard.servico.SwitcheServico;

@RestController
@RequestMapping("/switches")
public class SwitcheControlador {
	
	private final SwitcheServico switcheServico;
	
	public SwitcheControlador(SwitcheServico switcheServico) {
		this.switcheServico = switcheServico;
	}

	@GetMapping(produces = "application/json")
    public ResponseEntity<Page<Switche>> getAllPaged(
            @RequestParam(required = false) String hostname, 
            @RequestParam(required = false) String marca, 
            @RequestParam(required = false) String data, 
            Pageable pageable) {
		Page<Switche> page = switcheServico.getAllPaged(hostname, marca, data, pageable);
        return ResponseEntity.ok().body(page);
	}
	
	
	
}
