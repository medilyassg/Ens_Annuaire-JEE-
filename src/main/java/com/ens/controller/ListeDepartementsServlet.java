package com.ens.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ens.dao.DepartementDAO;
import com.ens.model.Departement;

/**
 * Servlet implementation class ListeDepartementsServlet
 */
public class ListeDepartementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeDepartementsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            DepartementDAO departementDAO = new DepartementDAO();
            List<Departement> departements = departementDAO.getAllDepartements();
            request.setAttribute("departements", departements);
            request.getRequestDispatcher("departement/listeDepartements.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

	}

	
}
