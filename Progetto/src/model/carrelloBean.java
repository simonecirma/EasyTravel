package model;

import java.util.ArrayList;
import java.util.List;

import model.PacchettoBean;

public class carrelloBean {

	private List<PacchettoBean> carrello;
	private List<immaginiBean> immaginiCarrello;
	
	public carrelloBean() {
		this.carrello = new ArrayList<PacchettoBean>();
		this.immaginiCarrello = new ArrayList<immaginiBean>();
	}
	
	public void addPacchetto(PacchettoBean pacchetto) {
		this.carrello.add(pacchetto);
	}
	public void addImmagine(immaginiBean img) {
		this.immaginiCarrello.add(img);
	}
	public void cancellaPacchetto(PacchettoBean pacchetto) {
		for(PacchettoBean pacc : carrello) {
			if(pacc.getCodSeriale().contains(pacchetto.getCodSeriale())) {
				this.carrello.remove(pacc);
				break;
			}
		}
 	}
	public void cancellaImmagine(immaginiBean img) {
		for(immaginiBean bean : immaginiCarrello) {
			if(bean.getNome().contains(img.getNome())) {
				this.immaginiCarrello.remove(bean);
				break;
			}
		}
 	}
	
	public List<PacchettoBean> getPacchetti() {
		return  carrello;
	}
	public List<immaginiBean> getImmagini() {
		return  immaginiCarrello;
	}
}
