package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.carrelloBean;
import model.pacchettoModel;
import model.immaginiModel;

@WebServlet("/pacchettoControl")
public class pacchettoControl extends HttpServlet {
	static Logger logger = Logger.getLogger(pacchettoControl.class.getName());
	private static final long serialVersionUID = 1L;
       
	static boolean isDataSource = true;
	
	static pacchettoModel productModel = new pacchettoModel();
	static immaginiModel immaginiModel = new immaginiModel();
	
    public pacchettoControl() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		carrelloBean carrello = (carrelloBean)request.getSession().getAttribute("carrello");
		if(carrello == null) {
			carrello = new carrelloBean();
			request.getSession().setAttribute("carrello", carrello);
		}
		carrelloBean immaginiCarrello = (carrelloBean)request.getSession().getAttribute("immaginiCarrello");
		if(immaginiCarrello == null) {
			immaginiCarrello = new carrelloBean();
			request.getSession().setAttribute("immaginiCarrello", immaginiCarrello);
		}
		
		String action = request.getParameter("action");

		try {
			if (action != null) {
				if (action.equalsIgnoreCase("read")) {
					String id = request.getParameter("id");
					request.removeAttribute("product");
					request.setAttribute("product", productModel.ricercaPerCodice(id));
					request.removeAttribute("img");
					request.setAttribute("img", immaginiModel.immaginiPerPacchetto(id));
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dettagliPacchetto.jsp");
					dispatcher.forward(request, response);
				} else if (action.equalsIgnoreCase("delete")){
					String id = request.getParameter("id");
					productModel.cancellaPacchetto(id);
				}else if (action.equalsIgnoreCase("AggiungiAlCarrello")) {
					String id = request.getParameter("id");
					carrello.addPacchetto(productModel.ricercaPerCodice(id));
					immaginiCarrello.addImmagine(immaginiModel.immagineCopertina(id));
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/carrello.jsp");
					dispatcher.forward(request, response);
				}else if (action.equalsIgnoreCase("Rimuovi")) {
					String id = request.getParameter("id");
					carrello.cancellaPacchetto(productModel.ricercaPerCodice(id));
					request.getSession().setAttribute("carrello", carrello);
					immaginiCarrello.cancellaImmagine(immaginiModel.immagineCopertina(id));
					request.getSession().setAttribute("immaginiCarrello", immaginiCarrello);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/carrello.jsp");
					dispatcher.forward(request, response); 
				}
			}
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		}

		try {
			request.removeAttribute("products");
			request.setAttribute("products", productModel.stampaTutti());
			request.removeAttribute("copertine");
			request.setAttribute("copertine", immaginiModel.Copertine());
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
