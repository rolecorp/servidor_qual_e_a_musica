package es.ufc.qualeamusica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ranking {
	
	@Id
	@GeneratedValue
	private long id;
	private String nomeUsuario;
	private double pontuacao;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public double getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	

}
