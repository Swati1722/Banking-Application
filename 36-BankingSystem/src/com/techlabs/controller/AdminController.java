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

import com.techlab.entity.BankDatabase;
import com.techlab.entity.Customer;
import com.techlab.entity.Transaction;


@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		BankDatabase bankDb = BankDatabase.getBankDatabase();
		bankDb.connect();
	
		
		if(request.getParameter("AddNewCustomer")!=null && request.getParameter("AddNewCustomer").contentEquals("Add New Customer"))
		{
			dispatcher =request.getRequestDispatcher("AddCustomer.jsp");
			dispatcher.forward(request, response);
			
		}
		
		if(request.getParameter("ViewCustomer")!=null && request.getParameter("ViewCustomer").contentEquals("View Customer"))
		{
			
			List<Customer> customers = bankDb.getCustomerLoginInfo();
			
			request.setAttribute("customer", customers);
			dispatcher = request.getRequestDispatcher("CustomerInfo.jsp");
			dispatcher.forward(request, response);
			
		}
		if(request.getParameter("transaction")!=null && request.getParameter("transaction").contentEquals("Transaction"))
		{	
			
//			System.out.println("intransaction");
			List<Transaction> transactions= bankDb.fetchTransactionData();			
			
			request.setAttribute("transactions", transactions);
	        dispatcher = request.getRequestDispatcher("Transaction.jsp");
	        dispatcher.forward(request, response);
	            
			
			
		}
		
		
		if(request.getParameter("searchBy")!=null && request.getParameter("searchBy").contentEquals("Name"))
		{
			
			List<Customer> customers = bankDb.getCustomerLoginInfo();
			
			String name = request.getParameter("nameacc");
			List<Customer> customerToBeSearch = new ArrayList<Customer>();
			for (Customer customer : customers) {

				if (customer.getFirstname().equals(name))
				{
					customerToBeSearch.add(customer);
				}
			}
			request.setAttribute("customer", customerToBeSearch );
			dispatcher = request.getRequestDispatcher("CustomerInfo.jsp");
			dispatcher.forward(request, response);
			
		}
		if(request.getParameter("searchBy")!=null && request.getParameter("searchBy").contentEquals("account"))
		{
			
			int accountNo = Integer.parseInt(request.getParameter("nameacc"));
			Customer customer = bankDb.retrieveCustomerDataByAccount(accountNo);
//			System.out.println(customer);
			List<Customer> customerToBeSearch = new ArrayList<Customer>();
			customerToBeSearch.add(customer);
			request.setAttribute("customer", customerToBeSearch);
			dispatcher = request.getRequestDispatcher("CustomerInfo.jsp");
			dispatcher.forward(request, response);
			
		}
	
		if(request.getParameter("startDate")!=null &&  request.getParameter("endDate")!=null )
		{
			
			Date fromdate = Date.valueOf(request.getParameter("startDate"));
			Date todate = Date.valueOf(request.getParameter("endDate"));
			
//			System.out.println(fromdate);
//			System.out.println(todate);
			List<Transaction>transactions = bankDb.fetchTransactionData();
			List<Transaction>findTransactions = new ArrayList<Transaction>();
			for(Transaction transaction : transactions)
			{
//				System.out.println(transaction);
				if(todate.compareTo(transaction.getDate())>=0 && fromdate.compareTo(transaction.getDate())<=0)
				{
					
					findTransactions.add(transaction);
				}
				
			}
			
			request.setAttribute("transactions", findTransactions);
			dispatcher = request.getRequestDispatcher("Transaction.jsp");
			dispatcher.forward(request, response);
			
		}

		if(request.getParameter("Home")!=null && request.getParameter("Home").contentEquals("Home"))
		{
			dispatcher =request.getRequestDispatcher("Admin.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
