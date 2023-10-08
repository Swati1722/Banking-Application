<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <title>Customer Dashboard</title>
    <style>
        body {
            background: linear-gradient(115deg, #56d8e4 10%, #9f01ea 90%);
            height: 100vh;
            width: 100%;
        }
    </style>
</head>
<body>
<div>
    
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col">
                <div class="card">
                    <div class="card-header text-center">
                        Customer Dashboard
                    </div>
                    <div class="card-body text-center">
                        <div class="container mt-5 mb-5">
                            <form action="customerController" class="text-center m-3">
                                <input type="submit" class="btn btn-primary btn-lg" name="Passbook" value="Passbook">
                                <input type="submit" class="btn btn-primary btn-lg" name="NewTransaction" value="New Transaction">
                                <input type="submit" class="btn btn-primary btn-lg" name="EditProfile" value="Edit Profile">
                            </form>
                        </div>
                        <div class="signup-link text-center mt-2 mb-2">
                    <!-- Center-aligned "Register" link -->
                    	 <a href="login.jsp" style="text-decoration:none;">Logout</a>
                		</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
