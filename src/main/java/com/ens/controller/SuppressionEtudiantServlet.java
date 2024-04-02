package com.ens.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.ens.dao.EtudiantDAO;

/**
 * Servlet implementation class SuppressionEtudiantServlet
 */
public class SuppressionEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionEtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cne = Integer.parseInt(request.getParameter("cne"));

        EtudiantDAO etudiantDAO = new EtudiantDAO();
        try {
            etudiantDAO.deleteEtudiant(cne);
            response.sendRedirect("etudiant/listeEtudiants.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	
}
