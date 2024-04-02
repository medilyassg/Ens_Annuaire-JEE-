package com.ens.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ens.dao.FiliereDAO;
import com.ens.model.Filiere;

/**
 * Servlet implementation class ListeFilieresServlet
 */
public class ListeFilieresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeFilieresServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try {
	        FiliereDAO filiereDAO = new FiliereDAO();
	        List<Filiere> filieres = filiereDAO.getAllFilieres(); // Utilisez la nouvelle méthode
	        request.setAttribute("filieres", filieres);
	        request.getRequestDispatcher("filiere/listeFilieres.jsp").forward(request, response);
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	}

	
}
