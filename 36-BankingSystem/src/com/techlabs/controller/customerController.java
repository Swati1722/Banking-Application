package com.techlabs.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techlab.entity.Account;
import com.techlab.entity.BankDatabase;
import com.techlab.entity.Customer;
import com.techlab.entity.Transaction;


@WebServlet("/customerController")
public class customerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public customerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		BankDatabase bankDb = BankDatabase.getBankDatabase();
		bankDb.connect();
		
		
		if(request.getParameter("Passbook")!=null && request.getParameter("Passbook").equals("Passbook"))
		{
			Customer customer = (Customer) request.getSession().getAttribute("currentUserSession");
			Account account = bankDb.fetchAccountDetails(customer.getCid());
//			System.out.println(account);
			List<Transaction> transactions = bankDb.customerTransaction(account.getAccountno());
			double balance=account.getBalance();
			request.setAttribute("transaction", transactions);
			request.setAttribute("balance",balance);
			dispatcher =request.getRequestDispatcher("Passbook.jsp");
			dispatcher.forward(request, response);
		}
		
		
		if(request.getParameter("NewTransaction")!=null && request.getParameter("NewTransaction").contentEquals("New Transaction"))
		{
			
			Customer customer = (Customer) request.getSession().getAttribute("currentUserSession");
			Account account = bankDb.fetchAccountDetails(customer.getCid());
		
			
			HttpSession session =request.getSession();
			session.setAttribute("currentUserAccount", account);
			
			dispatcher =request.getRequestDispatcher("AddTransaction.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("EditProfile")!=null && request.getParameter("EditProfile").contentEquals("Edit Profile"))
		{
			dispatcher =request.getRequestDispatcher("CustomerEditProfile.jsp");
			dispatcher.forward(request, response);
		}
		
		
		if(request.getParameter("startDate")!=null &&  request.getParameter("endDate")!=null )
		{
			
			Date fromdate = Date.valueOf(request.getParameter("startDate"));
			Date todate = Date.valueOf(request.getParameter("endDate"));
			
			Customer customer = (Customer) request.getSession().getAttribute("currentUserSession");
			Account account = bankDb.fetchAccountDetails(customer.getCid());
			List<Transaction> transactions = bankDb.customerTransaction(account.getAccountno());
			
			List<Transaction>findTransactions = new ArrayList<Transaction>();
			for(Transaction transaction : transactions)
			{
				if(todate.compareTo(transaction.getDate())>=0 && fromdate.compareTo(transaction.getDate())<=0)
				{
					
					findTransactions.add(transaction);
				}
			}
			request.setAttribute("transaction", findTransactions);
			dispatcher =request.getRequestDispatcher("Passbook.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
