package com.ens.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ens.dao.EtudiantDAO;
import com.ens.model.Etudiant;

/**
 * Servlet implementation class ListeEtudiantsServlet
 */
public class ListeEtudiantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeEtudiantsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            EtudiantDAO etudiantDAO = new EtudiantDAO();
            List<Etudiant> etudiants = etudiantDAO.getAllEtudiants();
            request.setAttribute("etudiants", etudiants);
            request.getRequestDispatcher("etudiant/listeEtudiants.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}

	
}
