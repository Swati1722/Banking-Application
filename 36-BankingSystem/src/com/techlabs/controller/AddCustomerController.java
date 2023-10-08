package com.techlabs.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlab.entity.Admin;
import com.techlab.entity.BankDatabase;
import com.techlab.entity.Customer;


@WebServlet("/AddCustomerController")
public class AddCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		
		String firstName = request.getParameter("regFirstName");
	    String lastName = request.getParameter("regLastName");
	    String username = request.getParameter("regUsername");
	    String password = request.getParameter("regPassword");
	    String mobile = request.getParameter("regMobile");
	    String openingBalanceStr = request.getParameter("regOpeningBalance");
	    
	   double openingBalance = Double.parseDouble(openingBalanceStr);
	  
	   
	   
	   if(mobile != null && mobile.matches("\\d{10}")) {
		   if(openingBalance<2000)
		   {
			   	dispatcher =request.getRequestDispatcher("LessAmount.jsp");
				dispatcher.forward(request, response);
		   }
		   else
		   {
			   BankDatabase bankDb = BankDatabase.getBankDatabase();
			   bankDb.connect();
			   List<Customer> customers = bankDb.getCustomerLoginInfo();
			   
			   
			   for (Customer customer : customers) {
//					System.out.println(customer.getUsername());
					 if (customer.getUsername().contentEquals(username) ) {
						 dispatcher =request.getRequestDispatcher("UserNameExist.jsp");
						 dispatcher.forward(request, response);
					 }
			   }
		       Customer customer = new Customer(firstName, lastName, password ,username,mobile);
			  
	
				
				
				bankDb.createNewCustomer(customer,openingBalance); 
				dispatcher =request.getRequestDispatcher("SuccessfulAddedCustomer.jsp");
				dispatcher.forward(request, response);
				
		   }
		}
		else {
		
			dispatcher = request.getRequestDispatcher("AddCustMobile.jsp");
		    dispatcher.forward(request, response);
		}
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
