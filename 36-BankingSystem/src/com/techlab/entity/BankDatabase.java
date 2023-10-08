package com.techlab.entity;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankDatabase {

	private static BankDatabase BankDb;
	private static Connection connection;
	private static PreparedStatement pStatement;
	private ResultSet resultSet;
	
	
	private BankDatabase()
	{
		
	}
	
	public static BankDatabase getBankDatabase()
	{
		if(BankDb==null)
		{
			BankDb =new BankDatabase();
		}
		return BankDb;
	}
	
	public void connect()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankloginDb", "root", "root");
			System.out.println("Connection is Successfull");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public static PreparedStatement getPreparedStatement() throws SQLException
	{
		if(pStatement==null)
		{
			pStatement=(PreparedStatement) connection.createStatement();
		}
		return pStatement;
	}
	
	public List<Customer> getCustomerLoginInfo()
	{
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer;
		try {
			pStatement =connection.prepareStatement("Select * from customer");
			 resultSet = pStatement.executeQuery();
			 while(resultSet.next())
			 {
				 int cid = resultSet.getInt("cid");
	             String firstName = resultSet.getString("firstname");
	             String lastName = resultSet.getString("lastname");
	             String password = resultSet.getString("password");
	             String username = resultSet.getString("username");
	             String mobile = resultSet.getString("mobile");
	             customer = new Customer(cid, firstName, lastName, password, username, mobile);
	            
	             customers.add(customer);

			 }
		}
		catch (Exception e) {
			        e.printStackTrace(); // Handle exceptions properly in your application
		}
			 
		return customers;		
	}
		
	
	
	public List<Admin> getAdminLoginInfo()
	{
		List<Admin> admins = new ArrayList<Admin>();
		Admin admin;
		try {
			pStatement =connection.prepareStatement("Select username, password,mobile from admin");
			 resultSet = pStatement.executeQuery();
			 while(resultSet.next())
			 {
				
	             String password = resultSet.getString("password");
	             String username = resultSet.getString("username");
	             String mobile = resultSet.getString("mobile");
	             admin = new Admin( username, password, mobile);
	             

	             admins.add(admin);

			 }
		}
		catch (Exception e) {
			        e.printStackTrace(); // Handle exceptions properly in your application
		}
		return admins;
	}
	
	
	
	public void createNewAdmin(Admin admin) {
	    try {
	        pStatement = connection.prepareStatement("INSERT INTO admin (username, password ,mobile) VALUES (?, ?,?)");
	        pStatement.setString(1, admin.getUsername());
	        pStatement.setString(2, admin.getPassword());
	        pStatement.setString(3, admin.getMobile());
	        
	        pStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace(); // Handle exceptions properly in your application
	    }
	}
	
	public void createNewCustomer(Customer customer,double balance)
	{
		
		try {
			  pStatement = connection.prepareStatement("INSERT INTO customer (firstName, lastName, password, username, mobile) VALUES (?, ?, ?, ?, ?)");
		        pStatement.setString(1, customer.getFirstname());
		        pStatement.setString(2, customer.getLastname());
		        pStatement.setString(3, customer.getPassword());
		        pStatement.setString(4, customer.getUsername());
		        pStatement.setString(5, customer.getMobile());
		        pStatement.executeUpdate();
	
		        // Retrieve the generated customer ID
		        pStatement = connection.prepareStatement("SELECT cid FROM customer WHERE username = ?");
		        pStatement.setString(1, customer.getUsername());
		        resultSet = pStatement.executeQuery();
		        resultSet.next();
		        int cid = resultSet.getInt("cid");
		            
		            // Insert account details with the retrieved customer ID and opening balance
		            pStatement = connection.prepareStatement("INSERT INTO Account (cid, balance) VALUES (?, ?)");
		            pStatement.setInt(1, cid);
		            pStatement.setDouble(2, balance);
		            pStatement.executeUpdate();
		            
		            // Commit the transaction
		            connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace(); // Handle exceptions properly in your application
	    }
		
	}
	
	public Customer retrieveCustomerDataByAccount(int accountNo)
	{
		  Customer  customer=null;
//		String query="Select * from customer where cid =(select cid from account where accountno = ?";
		try {
			pStatement = connection.prepareStatement("Select * from customer where cid =(select cid from account where accountno = ?)");
			pStatement.setInt(1,accountNo);
			resultSet = pStatement.executeQuery();
			resultSet.next();
			int cid = resultSet.getInt("cid");
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            String password = resultSet.getString("password");
            String username = resultSet.getString("username");
            String mobile = resultSet.getString("mobile");
             customer = new Customer(cid, firstName, lastName, password, username, mobile);
		}
		catch (SQLException e) {
	        e.printStackTrace(); // Handle exceptions properly in your application
	    } 
			
			
		return customer;
		
	}

	public List<Transaction> fetchTransactionData()
	{
		List<Transaction>transactions = new ArrayList<Transaction>();
		Transaction transaction;
		try {
			pStatement = connection.prepareStatement("Select * from transactions ;");
			resultSet = pStatement.executeQuery();
			 while(resultSet.next())
			 {
				 int transactionid= resultSet.getInt("transactionid");
	             String transactionType = resultSet.getString("transactionType");
	             int AccountNo = resultSet.getInt("AccountNo");
	             int recieverAcNo = resultSet.getInt("ReceiverAccno");
	             double Amount = resultSet.getDouble("Amount");
	             Date date = resultSet.getDate("date");
	             
	           
	            transaction  = new Transaction(transactionid, transactionType, AccountNo,recieverAcNo, Amount, date);
//	            System.out.println(transaction);
	            transactions.add(transaction);
			 }
		}
		catch (SQLException e) {
	        e.printStackTrace(); 
	    } 
		return transactions;
	}
	
	public Account  fetchAccountDetails(int Cid)
	{
		Account account=null;

		try {
			pStatement = connection.prepareStatement("Select * from account where cid =?");
			pStatement.setInt(1,Cid);
			resultSet = pStatement.executeQuery();
			resultSet.next();
            int accoutno = resultSet.getInt("accountno");
            double balance = resultSet.getDouble("balance");
             account = new Account(accoutno,balance,Cid);
		}
		catch (SQLException e) {
	        e.printStackTrace(); // Handle exceptions properly in your application
	    } 
		
		return account;
	}
	
	
	public List<Account>  ListOfAccount()
	{
		List<Account>accounts = new ArrayList<Account>();
		Account account;
		try {
			pStatement = connection.prepareStatement("Select * from account ;");
			resultSet = pStatement.executeQuery();
			 while(resultSet.next())
			 {
				 int AccountNo= resultSet.getInt("accountno");
	             int cid = resultSet.getInt("cid");
	            
	             double balance = resultSet.getDouble("balance");
	            
	            account  = new Account( AccountNo,balance,cid);
//	            System.out.println(transaction);
	            accounts.add(account);
			 }
		}
		catch (SQLException e) {
	        e.printStackTrace(); 
	    } 
		return accounts;
	}
	
	
	
	public void createNewTransactionforDebitandCredit(Transaction transaction)
	{
		
		try {
			  pStatement = connection.prepareStatement("INSERT INTO transactions ( TransactionType,   AccountNo,   Amount, Date, ReceiverAccno) VALUES (?, ?, ?, ?,?)");
		        pStatement.setString(1, transaction.getTransactionType());
		        pStatement.setInt(2, transaction.getAccountNo());
		        pStatement.setDouble(3, transaction.getAmount());
		        pStatement.setDate(4, transaction.getDate());
		        pStatement.setInt(5, transaction.getReceiverAcNo());
		    	pStatement.executeUpdate();
		    	pStatement.close();
		    	 
		        if((transaction.getTransactionType()).equals("Debit"))
		        {
		        	 double amount = transaction.getAmount();
		        	 pStatement = connection.prepareStatement("UPDATE Account SET Balance = Balance - ? WHERE AccountNo = ?;");
		        	 pStatement.setDouble(1, amount);
		        	 pStatement.setInt(2, transaction.getAccountNo());
		        	 int rowsAffected = pStatement.executeUpdate();
		        	 pStatement.close();
		        	    if (rowsAffected > 0) {
		        	        System.out.println("updated");
		        	    } 
		        	    else {
		        	      System.out.println("not updated");
		        	    }
		        }
		        else if((transaction.getTransactionType()).equals("Credit"))
		        {
		        	 double amount = transaction.getAmount();
		        	 pStatement = connection.prepareStatement("UPDATE Account SET Balance = Balance + ? WHERE AccountNo = ?;");
		        	 pStatement.setDouble(1, amount);
		        	 pStatement.setInt(2, transaction.getAccountNo());
		        	 int rowsAffected = pStatement.executeUpdate();
		        	 pStatement.close();  
		        	 
		        	 if (rowsAffected > 0) {
		        	        System.out.println("updated");
		        	    } 
		        	 else {
		        	        
		        	    	System.out.println("not updated");
		        	    }
		        }
		}
		catch (SQLException e) {
	        e.printStackTrace(); // Handle exceptions properly in your application
	    }
	}
	

	public void createNewTransactionforTransfer(Transaction transaction)
	{
		try {
			  pStatement = connection.prepareStatement("INSERT INTO transactions ( TransactionType,   AccountNo,   Amount, Date, ReceiverAccno) VALUES (?, ?, ?, ?, ?)");
		        pStatement.setString(1, transaction.getTransactionType());
		        pStatement.setInt(2, transaction.getAccountNo());
		        pStatement.setDouble(3, transaction.getAmount());
		        pStatement.setDate(4, transaction.getDate());
		        pStatement.setInt(5, transaction.getReceiverAcNo());
		    	pStatement.executeUpdate();
		    	pStatement.close();
		       
		        
		       
		        double amount = transaction.getAmount();
	        	pStatement = connection.prepareStatement("UPDATE Account SET Balance = Balance - ? WHERE AccountNo = ?;");
	        	pStatement.setDouble(1, amount);
	        	pStatement.setInt(2, transaction.getAccountNo());
	        	int rowsAffected = pStatement.executeUpdate();
	        	    
	        	 if (rowsAffected > 0) {
	        	        System.out.println("updated sender account");
	        	 } 
	        	 else {
	        	      System.out.println("not updated sender acc");
	        	 }
	        	 
	        	
	        	pStatement = connection.prepareStatement("UPDATE Account SET Balance = Balance + ? WHERE AccountNo = ?;");
	        	pStatement.setDouble(1, amount);
	        	pStatement.setInt(2, transaction.getReceiverAcNo());
	        	int rowaffect = pStatement.executeUpdate();
	        	    
	        	 if (rowaffect > 0) {
	        	        System.out.println("updated reciever account");
	        	 } 
	        	 else {
	        	      System.out.println("not updated recievr");
	        	 }
		       
			}
			catch (SQLException e) {
			        e.printStackTrace(); // Handle exceptions properly in your application
			  }
	}

	public List<Transaction> customerTransaction(int accountDetails)
	{
		List<Transaction> transactions = new ArrayList<Transaction>();
		Transaction transaction;
		try {
			pStatement =connection.prepareStatement("Select * from transactions where accountNo=?");
			pStatement.setInt(1, accountDetails);
			resultSet = pStatement.executeQuery();
			 while(resultSet.next())
			 {
				
				 int transactionid = resultSet.getInt("transactionid");
	             String transactionType = resultSet.getString("transactionType");
	             int  accountNo = resultSet.getInt("accountNo");
	             int receiverAcNo = resultSet.getInt("receiverAccNo");
	             double amount = resultSet.getDouble("amount");
	             Date date = resultSet.getDate("date");
	             
	             
	            
	            transaction = new Transaction(transactionid, transactionType, accountNo, receiverAcNo, amount, date);
	            
	            transactions.add(transaction);

			 }
		}
		catch (Exception e) {
			        e.printStackTrace(); // Handle exceptions properly in your application
		}
			 
		return transactions;
	}

	public void EditProfile(String EditPassword, int cid)  {
		// TODO Auto-generated method stub
		try {	
			pStatement = connection.prepareStatement("UPDATE customer SET  Password = ? WHERE CID = ?");
			
			 // Set EditUsername as the first parameter
			pStatement.setString(1, EditPassword); // Set EditPassword as the second parameter
			pStatement.setInt(2, cid);
			
			
			int rowsAffected = pStatement.executeUpdate();
    	    
    	    if (rowsAffected > 0) {
    	        System.out.println("updated");
    	    } 
    	    else {
    	      System.out.println("not updated");
    	    }
		}
		catch (Exception e) {
	        e.printStackTrace(); // Handle exceptions properly in your application
		}
		
	}
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	

