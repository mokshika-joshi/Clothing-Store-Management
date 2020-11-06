<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password Form</title>

<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	

</head>
<body>
	<div class="container-fluid">
        <div class="row bg-primary justify-content-between align-items-center sticky-top" style="height: 60px;">
            <div class="col-6 text-light" style="font-size: 24px;">Shoppers Stop</div>
            <div class="col-3 text-light d-flex justify-content-end">
            
            </div>
     </div>


	<div class="d-flex justify-content-center align-item-center mt-5">


	<form action="forgot_password.htm" method="post" >
	<table align="center" >
		<tr>
			<td>
				Enter Your Registered Mail ID:
			</td>
			<td>
				<input type="text" name="custEmail" required="required">
			</td>
		</tr>
		
		<tr>
			<td>
				<a href="home.jsp" >Back</a>
			</td>
			<td>
				<input type="submit"  value="Submit" >
			</td>
		</tr>
	</table>
	</form>
	</div>
	</div>
</body>
</html>