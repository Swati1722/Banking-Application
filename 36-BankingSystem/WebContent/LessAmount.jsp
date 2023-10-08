<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <title>Insufficient Balance</title>
    <style>
        body {
            height: 100vh;
            width: 100%;
            background: linear-gradient(115deg, #56d8e4 10%, #9f01ea 90%);
        }
        
    </style>
</head>
<body>
    <div class="row justify-content-center mt-4">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header text-center">
                    Insufficient Opening Balance
                </div>
                <div class="card-body">
                    <p class="text-center">The entered opening balance is less than the required minimum balance.</p>
                    <p class="text-center">Please go back and enter a sufficient opening balance.</p>
                    <div class="text-center">
                        <form action="AddCustomer.jsp">
                            <button type="submit" class="btn btn-primary" name="goBackBtn">Go Back</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
