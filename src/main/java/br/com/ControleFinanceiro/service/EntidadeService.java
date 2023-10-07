package br.com.ControleFinanceiro.service;

import java.util.Optional;

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
	
	// criar aqui um moetodo para retornar entidade por id
	public Entidade pickEntidadeById(int codigo) {
	    Optional<Entidade> entidadeOpt = repository.findById(codigo);
	    if (entidadeOpt.isPresent()) {
	        Entidade ent = entidadeOpt.get();
	        return ent;
	    } else {
	    	Entidade ent = new Entidade();
	    	ent.setRazaosocial("quase lá");
	    	ent.setInfad("end");
	    	ent.setSubclasse("do ");
	    	ent.setClasse("veio ");
	    	ent.setTipo("back ");
		    return ent;
	    }
	}

	
	
	
}
