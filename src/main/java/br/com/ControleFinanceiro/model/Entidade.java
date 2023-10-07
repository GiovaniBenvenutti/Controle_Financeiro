package br.com.ControleFinanceiro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "entidades")
public class Entidade {

	// Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int identidade;

	private String razaosocial;

	private String classe;

	private String subclasse;

	private String tipo;

	private String infad;

	@Override	
	public String toString() {
		return "Colaborador [identidade=" + identidade + ", razaosocial=" + razaosocial + ", classe=" + classe
				+ ", subclasse=" + subclasse + ", tipo=" + tipo + ", infad=" + infad + "]";
	}

	public int getIdentidade() {
		return identidade;
	}

	public void setIdentidade(int identidade) {
		this.identidade = identidade;
	}

	public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getSubclasse() {
		return subclasse;
	}

	public void setSubclasse(String subclasse) {
		this.subclasse = subclasse;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getInfad() {
		return infad;
	}

	public void setInfad(String infad) {
		this.infad = infad;
	}

	
	
}
