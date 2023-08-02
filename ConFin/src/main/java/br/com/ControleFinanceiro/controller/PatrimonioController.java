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

import br.com.ControleFinanceiro.model.Patrimonio;
import br.com.ControleFinanceiro.service.PatrimonioService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")  // endereço que recebe acesso , se quiser que seja publico tem que colocar "*"
@RequestMapping("/controlefinanceiro/patrimonio")
public class PatrimonioController {
	
	@Autowired
	private PatrimonioService service;
	
	@GetMapping
	public Iterable<Patrimonio> selecionar() {
		return service.selecionar();
	}
	
	@PostMapping
	public Patrimonio cadastrar(@RequestBody Patrimonio patrimonio) {
		return service.cadastrar(patrimonio);
	}
	
	@PutMapping
	public Patrimonio alterar(@RequestBody Patrimonio patrimonio) {
		return service.alterar(patrimonio);
	}
	
	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable int codigo) {
		service.remover(codigo);
	}	
	

}
