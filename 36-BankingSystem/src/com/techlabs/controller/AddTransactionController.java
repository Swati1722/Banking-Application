package com.techlabs.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlab.entity.Account;
import com.techlab.entity.Admin;
import com.techlab.entity.BankDatabase;
import com.techlab.entity.Customer;
import com.techlab.entity.Transaction;


@WebServlet("/AddTransactionController")
public class AddTransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddTransactionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		String TransactionType = request.getParameter("transactionType");
		String amountstr = request.getParameter("amount");
		
		Date date = Date.valueOf(request.getParameter("date"));
		double amount = Double.parseDouble(amountstr);
		
		
		
		if(TransactionType.equals("debit"))
		{
			Customer customer = (Customer) request.getSession().getAttribute("currentUserSession");
			Account account = (Account) request.getSession().getAttribute("currentUserAccount");
		
			Transaction transaction = new Transaction("Debit", account.getAccountno(),0,amount,date);
			
			
			BankDatabase bankDb = BankDatabase.getBankDatabase();
			bankDb.connect();
			
			
			bankDb.createNewTransactionforDebitandCredit(transaction); 
			dispatcher =request.getRequestDispatcher("SuccessfullyAddedTransation.jsp");
			dispatcher.forward(request, response);
			
		}
		
		if(TransactionType.equals("credit"))
		{
			Account account = (Account) request.getSession().getAttribute("currentUserAccount");
			Transaction transaction = new Transaction("Credit", account.getAccountno(),amount,date);
			
			 
			BankDatabase bankDb = BankDatabase.getBankDatabase();
			bankDb.connect();
			
			
			bankDb.createNewTransactionforDebitandCredit(transaction); 
			dispatcher =request.getRequestDispatcher("SuccessfullyAddedTransation.jsp");
			dispatcher.forward(request, response);
		}
		
		if(TransactionType.equals("transfer"))
		{
			String ReceiverAcNoStr= request.getParameter("transferAccountNo");
			int ReceiverAcNo = Integer.parseInt(ReceiverAcNoStr);
			
			
			Account account = (Account) request.getSession().getAttribute("currentUserAccount");
			
			if(ReceiverAcNo == account.getAccountno())
			{
				dispatcher =request.getRequestDispatcher("WrongTransferAc.jsp");
				dispatcher.forward(request, response);
			}
			BankDatabase bankDb = BankDatabase.getBankDatabase();
			bankDb.connect();
			List<Account>accounts = bankDb.ListOfAccount();
			for (Account acc : accounts) {
				 if (acc.getAccountno() == ReceiverAcNo ) {
					
					Transaction transaction = new Transaction("Transfer", account.getAccountno(),ReceiverAcNo, amount,date);
					bankDb.createNewTransactionforTransfer(transaction); 
					dispatcher =request.getRequestDispatcher("SuccessfullyAddedTransation.jsp");
					dispatcher.forward(request, response);
				 }
			}
			dispatcher =request.getRequestDispatcher("WrongTransferAc.jsp");
			dispatcher.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
