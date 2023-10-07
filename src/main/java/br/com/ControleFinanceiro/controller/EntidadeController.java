package br.com.ControleFinanceiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ControleFinanceiro.model.Entidade;
import br.com.ControleFinanceiro.service.EntidadeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")  // endereço que recebe acesso , se quiser que seja publico tem que colocar "*"
@RequestMapping("/controlefinanceiro/entidade")
public class EntidadeController {
	
	@Autowired
	private EntidadeService service;
	
	@GetMapping
	public Iterable<Entidade> selecionar() {
		return service.selecionar();
	}
	
	@PostMapping
	public Entidade cadastrar(@RequestBody Entidade entidade) {
		return service.cadastrar(entidade);
	}
	
	@PutMapping
	public Entidade alterar(@RequestBody Entidade entidade) {
		return service.alterar(entidade);
	}
	
	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable int codigo) {
		service.remover(codigo);
	}
	
	// -----------------------------------
	
	@GetMapping("/{codigo}")
	public Entidade entidadeById(@PathVariable int codigo) {
		return service.pickEntidadeById(codigo);
	}
	
	
	

}
