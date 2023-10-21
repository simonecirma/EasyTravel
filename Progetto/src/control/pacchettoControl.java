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
				}
			}
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		}

		try {
			request.removeAttribute("products");
			request.setAttribute("products", productModel.stampaTutti());
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
