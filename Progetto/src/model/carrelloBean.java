package model;

import java.util.ArrayList;
import java.util.List;

import model.PacchettoBean;

public class carrelloBean {

	private List<PacchettoBean> products;
	
	public carrelloBean() {
		products = new ArrayList<PacchettoBean>();
	}
	
	public void addPacchetto(PacchettoBean product) {
		products.add(product);
	}
	
	public void cancellaPacchetto(PacchettoBean product) {
		for(PacchettoBean prod : products) {
			if(prod.getCodSeriale() == product.getCodSeriale()) {
				products.remove(prod);
				break;
			}
		}
 	}
	
	public List<PacchettoBean> getProducts() {
		return  products;
	}
}
