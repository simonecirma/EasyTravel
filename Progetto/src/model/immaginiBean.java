package model;

import java.io.Serializable;

public class immaginiBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String nome;
	String codice;
	
	public immaginiBean() {
		this.nome="";
		this.codice="";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	
}
