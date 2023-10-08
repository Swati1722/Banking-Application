<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Admin Registration</title>
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
        <div class="col-md-4">
            <div class="card">
                <div class="card-header text-center">
                    Admin Registration
                </div>
                <div class="card-body">
                    <!-- Registration Form -->
                    <form action="AdminRegistrationController" method="post">
                        <div class="mb-3">
                            <label for="regUsername" class="form-label">Username*</label>
                            <input type="text" class="form-control  rounded-pill " id="regUsername" name="regUsername" required>
                        </div>
                        <div class="mb-3">
                            <label for="regPassword" class="form-label">Password*</label>
                            <div class="input-group">
                                <input type="password" class="form-control  rounded-pill" id="regPassword" name="regPassword" required>
                                <button type="button" class="btn btn-outline-secondary  rounded-pill" id="showPasswordBtn">
                                    <i id="editToggler" class="far fa-eye"></i>
                                </button>
                            </div>
                        </div>
                        <div class="mb-3">
    						<label for="regMobile" class="form-label">Mobile Number*</label>
    						<input type="text" class="form-control  rounded-pill" id="regMobile" name="regMobile" required>
						</div>
                        <!-- Add more registration fields here as needed -->
                        <div class="text-center">
                        	 
                            <button type="submit" class="btn btn-primary  rounded-pill" name="registerBtn">Register</button>
                            <button type="reset" class="btn btn-secondary  rounded-pill" name="cancelRegBtn">Cancel</button>
                        </div>
                    </form>
                     <div class="signup-link text-center mt-2 mb-2">
                    <!-- Center-aligned "Register" link -->
                    	Back to <a href="login.jsp" style="text-decoration:none;">login!</a>
                	</div>
                </div>
            </div>
        </div>
    </div>
    
    <script>
        const passwordInput = document.getElementById("regPassword");
        const showPasswordBtn = document.getElementById("showPasswordBtn");
        const eyeIcon = document.getElementById("eyeIcon");

        showPasswordBtn.addEventListener("click", () => {
            if (passwordInput.type === "password") {
                passwordInput.type = "text";
                eyeIcon.classList.remove("bi-eye");
                eyeIcon.classList.add("bi-eye-slash");
            } else {
                passwordInput.type = "password";
                eyeIcon.classList.remove("bi-eye-slash");
                eyeIcon.classList.add("bi-eye");
            }
        });
    </script>
</body>
</html>