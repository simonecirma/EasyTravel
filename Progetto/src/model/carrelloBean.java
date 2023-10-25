package model;

import java.util.ArrayList;
import java.util.List;

import model.PacchettoBean;

public class carrelloBean {

	private List<PacchettoBean> products;
	private List<immaginiBean> immagini;
	
	public carrelloBean() {
		products = new ArrayList<PacchettoBean>();
		immagini = new ArrayList<immaginiBean>();
	}
	
	public void addPacchetto(PacchettoBean product) {
		products.add(product);
	}
	public void addImmagine(immaginiBean img) {
		immagini.add(img);
	}
	public void cancellaPacchetto(PacchettoBean product) {
		for(PacchettoBean prod : products) {
			if(prod.getCodSeriale() == product.getCodSeriale()) {
				products.remove(prod);
				break;
			}
		}
 	}
	public void cancellaImmagine(immaginiBean img) {
		for(immaginiBean bean : immagini) {
			if(bean.getNome() == img.getNome()) {
				immagini.remove(bean);
				break;
			}
		}
 	}
	
	public List<PacchettoBean> getPacchetti() {
		return  products;
	}
	public List<immaginiBean> getImmagini() {
		return  immagini;
	}
}
