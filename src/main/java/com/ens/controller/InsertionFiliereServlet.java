package com.ens.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.ens.dao.FiliereDAO;
import com.ens.model.Filiere;

/**
 * Servlet implementation class InsertionFiliereServlet
 */
public class InsertionFiliereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertionFiliereServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomFiliere = request.getParameter("nomFiliere");
        int idDepartement = Integer.parseInt(request.getParameter("idDepartement"));

        Filiere filiere = new Filiere();
        filiere.setNom(nomFiliere);
        filiere.setIdDepartement(idDepartement);

        FiliereDAO filiereDAO = new FiliereDAO();
        try {
            filiereDAO.insertFiliere(filiere);
            response.sendRedirect("filiere/listeFilieres.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
