package com.techlabs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techlab.entity.Admin;
import com.techlab.entity.BankDatabase;
import com.techlab.entity.Customer;


@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
   
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher;

		String usertype = request.getParameter("usertype");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		System.out.println(usertype);
		BankDatabase bankDb = BankDatabase.getBankDatabase();
		bankDb.connect();
		

		if (usertype.equals("customer")) {
			
			List<Customer> customers = bankDb.getCustomerLoginInfo();
			for (Customer customer : customers) {
//				System.out.println(customer.getUsername());
				 if (customer.getUsername().contentEquals(username) && customer.getPassword().contentEquals(password)) {

					
					dispatcher = request.getRequestDispatcher("Customer.jsp");
					
					HttpSession session =request.getSession();
					session.setAttribute("currentUserSession", customer);
					
					request.setAttribute("name", username);
					dispatcher.forward(request, response);
					return;
				}

			}
		}

		if (usertype.equals("admin")) {
			
			// Assuming you have an 'adminUsername' and 'adminPassword' for admin login
			List<Admin> admins = bankDb.getAdminLoginInfo();
			for (Admin admin : admins) {
				 if (admin.getUsername().contentEquals(username) && admin.getPassword().contentEquals(password)) {
					dispatcher = request.getRequestDispatcher("Admin.jsp");
					request.setAttribute("name", username);
					dispatcher.forward(request, response);
					return;
				}
			}

		}
		dispatcher = request.getRequestDispatcher("WrongLogin.jsp");
		dispatcher.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
