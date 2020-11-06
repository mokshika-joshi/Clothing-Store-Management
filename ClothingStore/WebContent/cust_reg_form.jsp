<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>

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
	<spr:form action="reg.htm" method="post" commandName="customer" >
	<table align="center" >
	  
		<tr>
			<td>
				 
			</td>
			<td>
				<spr:hidden path="custId" />
			</td>
		</tr>
		<tr>
			<td>
				Name:
			</td>
			<td>
				<spr:input path="custName" />
				<font color="red" ><spr:errors path="custName"></spr:errors></font>
			</td>
		</tr>
		
		<tr>
			<td>
				Email:
			</td>
			<td>
				<spr:input path="email" />
				<font color="red" ><spr:errors path="email"></spr:errors></font>
			</td>
		</tr>
		
		<tr>
			<td>
				Password:
			</td>
			<td>
				<spr:password path="custPass" />
				<font color="red" ><spr:errors path="custPass"></spr:errors></font>
				
			</td>
		</tr>
		
		<tr>
			<td>
				Gender:
			</td>
			<td>
				<spr:radiobutton path="gender" value="male" />Male
				<spr:radiobutton path="gender" value="female" />Female
				<font color="red" ><spr:errors path="gender"></spr:errors></font>
			</td>
		</tr>
		<tr>
			<td>
				Address:
			</td>
			<td>
				<spr:textarea path="city" />
				<font color="red" ><spr:errors path="city"></spr:errors></font>
			</td>
		</tr>
		
		<tr>
			<td>
				<input type="submit" value="Register" align="middle">
			</td>
			<td>
				<a href="prep_cust_form.htm" >Sign in</a> </td>
			</td>
		</tr>
	</table>
	</spr:form>
	</div>
	</div>
</body>
</html>