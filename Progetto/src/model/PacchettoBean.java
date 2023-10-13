package model;

import java.io.Serializable;

public class PacchettoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String CodSeriale;
	String Nome;
	float Prezzo;
	String DescrizioneRidotta;
	String Descrizione;
	String Immagine;
	String Tipo;
	int NumGiorni;
	boolean Disponibilità;
	
	public PacchettoBean() {
		this.CodSeriale="";
		this.Nome="";
		this.Prezzo=0;
		this.DescrizioneRidotta="";
		this.Descrizione="";
		this.Immagine="";
		this.Tipo="";
		this.NumGiorni=0;
		this.Disponibilità=false;
	}

	public String getCodSeriale() {
		return CodSeriale;
	}

	public void setCodSeriale(String codSeriale) {
		CodSeriale = codSeriale;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public float getPrezzo() {
		return Prezzo;
	}

	public void setPrezzo(float prezzo) {
		Prezzo = prezzo;
	}

	public String getDescrizioneRidotta() {
		return DescrizioneRidotta;
	}

	public void setDescrizioneRidotta(String descrizioneRidotta) {
		DescrizioneRidotta = descrizioneRidotta;
	}

	public String getDescrizione() {
		return Descrizione;
	}

	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}

	public String getImmagine() {
		return Immagine;
	}

	public void setImmagine(String immagine) {
		Immagine = immagine;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public int getNumGiorni() {
		return NumGiorni;
	}

	public void setNumGiorni(int numGiorni) {
		NumGiorni = numGiorni;
	}

	public boolean isDisponibilità() {
		return Disponibilità;
	}

	public void setDisponibilità(boolean disponibilità) {
		Disponibilità = disponibilità;
	}
	
}
