package com.techlabs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlab.entity.BankDatabase;
import com.techlab.entity.Customer;


@WebServlet("/EditProfileControlller")
public class EditProfileControlller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditProfileControlller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher dispatcher;
		String OldPassword = request.getParameter("oldPassword");
		String NewPassword = request.getParameter("newPassword");
		
		BankDatabase bankDb = BankDatabase.getBankDatabase();
		bankDb.connect();
		Customer customer = (Customer) request.getSession().getAttribute("currentUserSession");
//		System.out.println("OldPassword: " + OldPassword);
//		System.out.println("Customer Password: " + customer.getPassword());
		if(OldPassword!=null && (customer.getPassword()).contentEquals(OldPassword))
		{
			bankDb.EditProfile( NewPassword, customer.getCid());
		
			dispatcher =request.getRequestDispatcher("ProfileUpdated.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			dispatcher =request.getRequestDispatcher("wrongOldPassword.jsp");
			dispatcher.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
