<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.19.0/font/bootstrap-icons.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
 
<title>Login</title>

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
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="card ">
                    <div class="card-header text-center">
                        Bank Login
                    </div>
                    <div class="card-body">
                        <form action="loginController">
                            <div class="mb-3">
                                <label for="userType" class="form-label ">Choose Type of User</label>
                                <select class="form-select rounded-pill" id="userType" name="usertype" required>
                                    <option value="customer" class="mt-1 mb-1">Customer</option>
                                    <option value="admin" class="mt-1 mb-1">Admin</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="username" class="form-label" >Username *</label>
                                <input type="text" class="form-control rounded-pill" id="username" name="username" required>
                            </div>
                           	<div class="mb-3">
							    <label for="password" class="form-label">Password *</label>
							    <div class="input-group">
							        <input type="password" class="form-control rounded-pill" id="password" name="password" required>
							        <button type="button" id="showPasswordBtn" class="btn btn-outline-secondary rounded-pill">
							            <i id="editToggler" class="far fa-eye"></i>
							        </button>
							    </div>
							</div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary rounded-pill" name="submitBtn">Submit</button>
                                <button type="reset" class="btn btn-secondary rounded-pill" name="cancleBtn">Reset</button>
                            </div>
                            
                        </form>
                    </div>
                     <div class="signup-link text-center mt-2 mb-2">
                    <!-- Center-aligned "Register" link -->
                    	Not registered? <a href="AdminRegistration.jsp" style="text-decoration:none;">Register</a>
                	</div>
                      <!-- Button for regular user registration -->
       
                </div>
            </div>
        </div>
    </div>
    <script>
    const passwordInput = document.getElementById("password");
    const showPasswordBtn = document.getElementById("showPasswordBtn");
    const eyeIcon = document.getElementById("editToggler");

    showPasswordBtn.addEventListener("click", () => {
        if (passwordInput.type === "password") {
            passwordInput.type = "text";
            eyeIcon.classList.remove("far", "fa-eye");
            eyeIcon.classList.add("far", "fa-eye-slash");
        } else {
            passwordInput.type = "password";
            eyeIcon.classList.remove("far", "fa-eye-slash");
            eyeIcon.classList.add("far", "fa-eye");
        }
    });

</script>

</body>
</html>