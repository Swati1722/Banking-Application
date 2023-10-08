<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <style>
        body {
            height: 100vh;
            width: 100%;
            background: linear-gradient(115deg, #56d8e4 10%, #9f01ea 90%);
        }
    </style>  
<title>Edit Profile</title>
</head>
<body>
	  <div class="row justify-content-center mt-4">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header text-center">
                    <b>Edit Profile</b>
                </div>
                <div class="card-body">
                    <!-- Edit Profile Form -->
                    <form action="EditProfileControlller" method="post">
                        <div class="mb-2">
                            <label for="oldPassword" class="form-label">Old Password</label>
                            <input type="text" class="form-control rounded-pill" id="oldPassword" name="oldPassword">
                        </div>
                        <div class="mb-2">
                            <label for="newPassword" class="form-label">New Password</label>
                            <div class="input-group">
                                <input type="password" class="form-control rounded-pill" id="newPassword" name="newPassword">
                                <button type="button" class="btn btn-outline-secondary rounded-pill" id="showEditPasswordBtn">
                                    <i id="editToggler" class="far fa-eye"></i>
                                </button>
                            </div>
                        </div>
                        <!-- Add more fields for editing here if needed -->
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary rounded-pill" name="updateBtn">Update Password </button>
                            <button type="reset" class="btn btn-secondary rounded-pill" name="cancelUpdateBtn">Cancel</button>
                        </div>
                    </form>
                    <div class="signup-link text-center mt-2 mb-2">
                        <!-- Center-aligned "Home" link -->
                        <a href="Customer.jsp" style="text-decoration:none;">Home</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
 // JavaScript for toggling password visibility
    const newPasswordInput = document.getElementById("newPassword");
    const showEditPasswordBtn = document.getElementById("showEditPasswordBtn");
    const editToggler = document.getElementById("editToggler");

    showEditPasswordBtn.addEventListener("click", () => {
        if (newPasswordInput.type === "password") {
            newPasswordInput.type = "text";
            editToggler.classList.remove("far", "fa-eye");
            editToggler.classList.add("far", "fa-eye-slash");
        } else {
            newPasswordInput.type = "password";
            editToggler.classList.remove("far", "fa-eye-slash");
            editToggler.classList.add("far", "fa-eye");
        }
    });

    </script>
	
</body>
</html>