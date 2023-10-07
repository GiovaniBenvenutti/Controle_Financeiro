package br.com.ControleFinanceiro.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "patrimonio")
public class Patrimonio {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpatrimonio;	
	
	private int identidade;
	
	@Column(columnDefinition = "DATE")
	private LocalDate levantamento;

	private double valor;

	@Override
	public String toString() {
		return "Patrimonio [idpatrimonio=" + idpatrimonio + ", identidade=" + identidade + ", levantamento="
				+ levantamento + ", valor=" + valor + "]";
	}

	public int getIdpatrimonio() {
		return idpatrimonio;
	}

	public void setIdpatrimonio(int idpatrimonio) {
		this.idpatrimonio = idpatrimonio;
	}

	public int getIdentidade() {
		return identidade;
	}

	public void setIdentidade(int identidade) {
		this.identidade = identidade;
	}

	public LocalDate getLevantamento() {
		return levantamento;
	}

	public void setLevantamento(LocalDate levantamento) {
		this.levantamento = levantamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	
}
