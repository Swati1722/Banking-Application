<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<title>Customer Information</title>

<style>
  
        body {
        	height: 100vh;
  			width: 100%;
            background: linear-gradient(115deg, #56d8e4 10%, #9f01ea 90%);
        }
       
       
</style>
</head>
<body>
<div class="container mt-5">
    <h2>Customer Information</h2>
    
    <!-- Search Form -->
    <form action="AdminController" method="post">
    <div class="container mt-5">
    	 
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="mb-3">
                   <label for="searchBy" class="form-label">Search by:</label>
                    <select class="form-select rounded-pill" id="searchBy" name="searchBy">
                        <option value="Name">Name</option>
                        <option value="account">Account Number</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="nameacc" class="form-label">.</label>
                    <input type="text" class="form-control rounded-pill" id="nameacc" name="nameacc"  placeholder="Enter Name or Account Number" required >
                </div>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-6 text-center">
                <input type="submit" class="btn btn-primary rounded-pill" name="search">
            </div>
            <div class="signup-link text-center mt-2 mb-2 ">
                    <a href="Admin.jsp" style="color: white; text-decoration: None;">Back to Home !</a>
            </div>
        </div>
    </div>
	</form>
    

    <!-- Display Customer Details -->
	<div class="container m">
		<div class="row justify-content-center ">
		    <div class="mt-4 ">
		        <table class="table table-striped round pills">
		            
		                <tr >
		                    <th>Customer ID</th>
		                    <th>First Name</th>
		                    <th>Last Name</th>
		                    <th>Mobile No</th>
		                    <th>Password</th>
		                    <!-- Add more columns as needed -->
		                </tr>
		           
		            
		                <!-- Use a loop to display customer details -->
		                <c:forEach var="cust" items="${customer}">
		                    <tr>
		                        <td>${cust.cid}</td>
		                        <td>${cust.firstname}</td>
		                        <td>${cust.lastname}</td>
		                        <td>${cust.mobile}</td>
		                        <td>${cust.password}</td>
		                        <!-- Add more columns as needed -->
		                    </tr>
		                </c:forEach>
		            
		        </table>
		    </div>
		  </div>
	</div>
	
</div>
</body>
</html>
