package br.com.unipar.dashboard.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping(value = "/marca=Edge-Core", produces = "application/json")
    public ResponseEntity<List<Switche>> getAllMarca1() {
		List<Switche> page = switcheServico.getAllMarca("Edge-Core");
        return ResponseEntity.ok().body(page);
	}
	
	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping(value = "/marca=Cisco", produces = "application/json")
    public ResponseEntity<List<Switche>> getAllMarca2() {
		List<Switche> page = switcheServico.getAllMarca("Cisco");
        return ResponseEntity.ok().body(page);   
	}
	
	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping(value = "/marca=HP", produces = "application/json")
    public ResponseEntity<List<Switche>> getAllMarca3() {
		List<Switche> page = switcheServico.getAllMarca("HP");
        return ResponseEntity.ok().body(page);
	}
	
	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping(value = "/marca=SMC", produces = "application/json")
    public ResponseEntity<List<Switche>> getAllMarca4() {
		List<Switche> page = switcheServico.getAllMarca("SMC");
        return ResponseEntity.ok().body(page);
	}
	
	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping(value = "/marca=Rockwell", produces = "application/json")
    public ResponseEntity<List<Switche>> getAllMarca5() {
		List<Switche> page = switcheServico.getAllMarca("Rockwell");
        return ResponseEntity.ok().body(page);
	}
	
	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping(value = "/marca=Hirschmann", produces = "application/json")
    public ResponseEntity<List<Switche>> getAllMarca6() {
		List<Switche> page = switcheServico.getAllMarca("Hirschmann");
        return ResponseEntity.ok().body(page);
	}
}
