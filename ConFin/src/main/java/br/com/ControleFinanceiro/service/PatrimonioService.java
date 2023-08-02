package br.com.ControleFinanceiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ControleFinanceiro.model.Patrimonio;
import br.com.ControleFinanceiro.repository.PatrimonioRepository;

@Service
public class PatrimonioService {

	@Autowired
	private PatrimonioRepository repository;

	public Iterable<Patrimonio> selecionar() {
		return repository.findAll();
	}
	
	public Patrimonio cadastrar(Patrimonio patrimonio) {
		return repository.save(patrimonio);		
	}
	
	public Patrimonio alterar(Patrimonio patrimonio) {
		return repository.save(patrimonio);
	}
	
	public void remover(int codigo) {
		repository.deleteById(codigo);
	}
	
	
}
