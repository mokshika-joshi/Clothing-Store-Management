<%@page import="com.cdac.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    

<%@ include file="cache-control.jsp" %>
<% 
  if(((Admin)session.getAttribute("admin"))!=null)
  {
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product Form</title>

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

	<div class="text-primary d-flex justify-content-center">
	<h3>Add Product</h3>
	</div>
	<div class="d-flex justify-content-center align-item-center mt-5">
	
	<spr:form action="Product_add.htm" method="post" commandName="product" >
	<table align="center" >
		<tr>
			<td>
				Product Name :
			</td>
			<td>
				<spr:input path="ProductName"/>
			</td>
		</tr>
		<tr>
			<td>
				ProductPrice:
			</td>
			<td>
				<spr:input path="ProductPrice"/>
			</td>
		</tr>
		<tr>
			<td>
				ProductCategory:
			</td>
			<td>
				<spr:input path="ProductCategory"/>
			</td>
		</tr>
		<tr>
			<td>
				ProductQuantity:
			</td>
			<td>
				<spr:input path="ProductQuantity"/>
			</td>
		</tr>
		<tr>
			<td>
				ProductDescription:
			</td>
			<td>
				<spr:input path="ProductDescription"/>
			</td>
		</tr>
		<tr>
			<td>
				<a href="home2.jsp" >Back</a>
			</td>
			<td>
				<input type="submit"  value="Add" class="btn btn-outline-primary btn-block">
			</td>
		</tr>
		
	</table>
	</spr:form>
	 </div>
     </div>
</body>
</html>

<%}
else{
	
		response.sendRedirect("errorpage.jsp");

}
%>