package com.techlabs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlab.entity.Admin;
import com.techlab.entity.BankDatabase;

/**
 * Servlet implementation class AdminRegistrationController
 */
@WebServlet("/AdminRegistrationController")
public class AdminRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher dispatcher;
    public AdminRegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Inside your servlet doPost method
		
		
		String Username = request.getParameter("regUsername");
		String Password = request.getParameter("regPassword");
		String mobile = request.getParameter("regMobile");


		 if (mobile != null && mobile.matches("\\d{10}")) {
			 BankDatabase bankDb = BankDatabase.getBankDatabase();
		     bankDb.connect();
			 List<Admin> admins = bankDb.getAdminLoginInfo();
				
			 for (Admin admin : admins) {
//					System.out.println("admin");
					 if (admin.getUsername().contentEquals(Username) ) {
						dispatcher = request.getRequestDispatcher("AdminUserNameExist.jsp");
						dispatcher.forward(request, response);
					 }
			 }
			 
			 
		        Admin admin = new Admin(Username, Password, mobile);
		        bankDb.createNewAdmin(admin); // Assuming you have a create method in BankDatabase

		        dispatcher = request.getRequestDispatcher("Registered.jsp");
		        dispatcher.forward(request, response);
		  } 
		 else {
		
			 dispatcher = request.getRequestDispatcher("mobileNo.jsp");
		     dispatcher.forward(request, response);
		 }
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
