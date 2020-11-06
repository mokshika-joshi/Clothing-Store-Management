<%@page import="com.cdac.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="cache-control.jsp" %>
<% 
  if(((Customer)session.getAttribute("customer"))!=null)
  {
%>    



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CustomerWel</title>

<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	


</head>
<body>

	<div class="container-fluid">
        <div class="row bg-primary justify-content-between align-items-center sticky-top" style="height: 60px;">
            <div class="col-4 text-light" style="font-size: 24px;">Shoppers Stop</div>
           
            <div class="col-4 text-light d-flex justify-content-end">
            <a href="logout_customer.jsp" class="btn btn-outline-light" >Logout</a>
            </div>
     </div>
      <div class=" d-flex justify-content-right">
            Welcome <%= (session.getAttribute("customer") != null)?((Customer)session.getAttribute("customer")).getCustName():"!!" %>
            </div>


	<div class="d-flex justify-content-center align-item-center mt-5">

	

	<table align="center" >
	  
<%-- 		<tr>
			<td>
				 Welcome <%= (session.getAttribute("customer") != null)?((Customer)session.getAttribute("customer")).getCustName():"!!" %>
			</td>
			
		</tr> --%>
		
		<tr>
			<td>
				<a href="list.htm" class="btn btn-outline-primary btn-block">Products</a>
			</td>
			
		</tr>  
		<!-- <tr>
			<td>
				<a href="logout_customer.jsp" >Logout</a>
			</td>
			
		</tr>  -->
		
	</table>
	</div>
	</div>

		
    

</body>
</html>

<%}
else{
	
		response.sendRedirect("errorpage.jsp");

}
%>
