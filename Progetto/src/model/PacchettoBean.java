package model;

import java.io.Serializable;

public class PacchettoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String codSeriale;
	String nome;
	float prezzo;
	String descrizioneRidotta;
	String descrizione;
	String immagine;
	String tipo;
	int numGiorni;
	boolean disponibilità;
	
	public PacchettoBean() {
		this.codSeriale="";
		this.nome="";
		this.prezzo=0;
		this.descrizioneRidotta="";
		this.descrizione="";
		this.immagine="";
		this.tipo="";
		this.numGiorni=0;
		this.disponibilità=false;
	}

	public String getCodSeriale() {
		return codSeriale;
	}

	public void setCodSeriale(String codSeriale) {
		this.codSeriale = codSeriale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public String getDescrizioneRidotta() {
		return descrizioneRidotta;
	}

	public void setDescrizioneRidotta(String descrizioneRidotta) {
		this.descrizioneRidotta = descrizioneRidotta;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getNumGiorni() {
		return numGiorni;
	}

	public void setNumGiorni(int numGiorni) {
		this.numGiorni = numGiorni;
	}

	public boolean isDisponibilità() {
		return disponibilità;
	}

	public void setDisponibilità(boolean disponibilità) {
		this.disponibilità = disponibilità;
	}
	
	}
