package br.com.ControleFinanceiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ControleFinanceiro.model.Entidade;

import br.com.ControleFinanceiro.repository.EntidadeRepository;

@Service
public class EntidadeService {

	@Autowired
	private EntidadeRepository repository;

	public Iterable<Entidade> selecionar() {
		return repository.findAll();
	}
	
	public Entidade cadastrar(Entidade entidade) {
		return repository.save(entidade);		
	}
	
	public Entidade alterar(Entidade entidade) {
		return repository.save(entidade);
	}
	
	public void remover(int codigo) {
		repository.deleteById(codigo);
	}
	
	
}
