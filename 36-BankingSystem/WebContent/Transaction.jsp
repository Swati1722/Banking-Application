<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <title>Transaction Details</title>
    <style>
        body {
            height: 100vh;
            width: 100%;
            background: linear-gradient(115deg, #56d8e4 10%, #9f01ea 90%);
        }
    </style>
</head>
<body>
    <div class="container mt-4">
    	<h1>Transaction Details</h1>
    	<form action="AdminController" method="post" class="row g-3">
		    <div class="container mt-5">     
		        <div class="row">
		        
		        	<div class="col-md-4">
		                <div class="mb-3">
		                    <label for="startDate" class="form-label">Search by From Date</label>
		                    <input type="date" class="form-control  rounded-pill" id="startDate" name="startDate" required>
		                </div>
		            </div>
		        	 <div class="col-md-4">
		                <div class="mb-3">
		                    <label for="endDate" class="form-label">Search by To Date</label>
		                    <input type="date" class="form-control  rounded-pill" id="endDate" name="endDate" required>
		                </div>
		            </div>
		            
		           
		            
		        </div>
		        <div class="col-md-4">
                <button type="submit" class="btn btn-primary rounded-pill">Search</button>
            	
            	       	
            	</div>
		    </div>
		</form>
    	
    	
    	 <!-- Transaction Table -->
    	<div class="container m">
			<div class="row justify-content-center ">
			    <div class="mt-4 ">
			        <table class="table table-striped round pills">
			            
			                <tr>
		                       <th>Transaction ID</th>
		                       <th>Transaction Type</th>
		                       <th>Account No</th>
		                        <th>Receiver Account No</th>
		                       <th>Amount</th>
		                       <th>Date</th>
		                     </tr>
			           
			            
			                <!-- Use a loop to display customer details -->
			                <c:forEach var="tra" items="${transactions}">
					             <tr>
						              <td>${tra.transactionid}</td>
						              <td>${tra.transactionType}</td>
						              <td>${tra.accountNo}</td>
						              <td>${tra.receiverAcNo}</td>
						              <td>${tra.amount}</td>
						              <td>${tra.date}</td>
						                     
					              </tr>
				            </c:forEach>
			        </table>
			    </div>
		  	</div>
		</div>
		<div class="container mt-3">
			<form action="AdminController" method="post" class="row g-3">
				<input type="submit" class="btn btn-primary  rounded-pill" name="Home"  value="Home">
		     </form>         
		</div>  
	
</div>
  
	     
   
</body>
</html>
