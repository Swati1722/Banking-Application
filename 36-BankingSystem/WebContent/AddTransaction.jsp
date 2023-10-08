<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Transaction</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
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
                    <b>New Transaction</b>
                </div>
                <div class="card-body">
                    <!-- Transaction Form -->
                    <form action="AddTransactionController" method="post">
                        <div class="form-group mt-1">
                            <label for="transactionType">Transaction Type*</label>
                            <select class="form-control rounded-pill" id="transactionType" name="transactionType">
                                <option value="debit">Debit</option>
                                <option value="credit">Credit</option>
                                <option value="transfer">Transfer</option>
                            </select>
                        </div>

                        <div class="form-group mt-1">
                            <label for="amount">Amount *</label>
                            <input type="number" class="form-control rounded-pill" id="amount" name="amount" required>
                        </div>
                        
                        <div class="form-group mt-1">
                            <label for="transferAccountNo">Transfer Account No</label>
                            <input type="number" class="form-control rounded-pill" id="transferAccountNo" name="transferAccountNo"  placeholder="In Case of transfer  only">
                        </div>

                        
                       <div class="col-md-4">
		                <div class="mb-3">
		                    <label for="Date" class="form-label">Date</label>
		                    <input type="date" class="form-control" id="Date" name="date" required>
		                </div>
		            </div>

                      

                        <div class="text-center mt-2">
                            <button type="submit" class="btn btn-primary rounded-pill" name="submitBtn">Submit</button>
                            <button type="reset" class="btn btn-secondary rounded-pill" name="resetBtn">Reset</button>
                        </div>
                    </form>

                    <div class="text-center mt-2">
                        <!-- Center-aligned "Home" link -->
                        <a href="Admin.jsp" style="text-decoration: none;">Home</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    <script>
        document.getElementById("transactionType").addEventListener("change", function() {
            var transferFields = document.getElementById("transferFields");
            if (this.value === "transfer") {
                transferFields.style.display = "block";
            } else {
                transferFields.style.display = "none";
            }
        });
    </script>

    
</body>
</html>
