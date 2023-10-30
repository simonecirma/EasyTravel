package model;

import java.io.Serializable;

public class utenteBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	int Id ;
	String nome;
	String cognome;
	String email;
	String password;
	String indirizzo;
	int numeroCivico;
	int cap;
	String citta;
	String provincia;
	String dataDiNascita; 
	String numeroTelefono;
	String immagine;
	boolean flagAmm; //0=Utente; 1=Amministratore
	
	public utenteBean() {
		this.Id=0;
		this.nome="";
		this.cognome="";
		this.email="";
		this.password="";
		this.indirizzo="";
		this.numeroCivico=0;
		this.cap=0;
		this.citta="";
		this.provincia="";
		this.dataDiNascita="";
		this.numeroTelefono="";
		this.immagine="";
		this.flagAmm=false;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(int numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public boolean isFlagAmm() {
		return flagAmm;
	}

	public void setFlagAmm(boolean flagAmm) {
		this.flagAmm = flagAmm;
	}
	
}
