package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PacchettoBean;
import model.pacchettoModel;

@WebServlet("/pacchettoControl")
public class pacchettoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static boolean isDataSource = true;
	
	static pacchettoModel productModel = new pacchettoModel();
	
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
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dettagliPacchetto.jsp");
					dispatcher.forward(request, response);
				} else if (action.equalsIgnoreCase("delete")) {
					String id = request.getParameter("id");
					productModel.cancellaPacchetto(id);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		try {
			request.removeAttribute("products");
			request.setAttribute("products", productModel.stampaTutti());
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
