package br.com.ControleFinanceiro.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ControleFinanceiro.model.Patrimonio;

public interface PatrimonioRepository extends CrudRepository<Patrimonio, Integer> {
	
}
