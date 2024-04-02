package com.ens.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.ens.dao.DepartementDAO;
import com.ens.model.Departement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertionDepartementServlet
 */
public class InsertionDepartementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertionDepartementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String nomDepartement = request.getParameter("nomDepartement");

	        Departement departement = new Departement();
	        departement.setNom(nomDepartement);

	        DepartementDAO departementDAO = new DepartementDAO();
	        try {
	            departementDAO.insertDepartement(departement);
	            response.sendRedirect("departement/listDepartement.jsp");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

}
