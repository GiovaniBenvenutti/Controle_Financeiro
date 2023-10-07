package br.com.ControleFinanceiro.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ControleFinanceiro.model.Entidade;

public interface EntidadeRepository extends CrudRepository<Entidade, Integer> {
	
}
