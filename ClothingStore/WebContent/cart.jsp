<%@page import="com.cdac.dto.Customer"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    
 
   <%@page import="com.cdac.dto.Product"%>
   <%@page import="com.cdac.dto.Cart"%>
<%@page import="java.util.List"%>

	<%
	Customer customer = (Customer)session.getAttribute("customer");
	String custName = "";
	if(customer!=null){
		custName = customer.getCustName();
		
	}
	%>   
	
	
  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Customer</title>

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
      <div class=" d-flex justify-content-center">
            Welcome <%= (session.getAttribute("customer") != null)?((Customer)session.getAttribute("customer")).getCustName():"!!" %>
            </div>


	<div class="d-flex justify-content-center align-item-center mt-5">
	
	
	<table >
	
		
		</table>
		 <%
			  	List<Cart> list = (List<Cart>) request.getAttribute("itemsList");
			  	int i = 0;
			  	float total=0f;
			  	if(list.size() > 0){
			  %>
			  
			<table align="center" class="table table-bordered" >
		<tr>
      		
      		<th scope="col">No</th>
      		<th scope="col">Product</th>
      		<th scope="col">Catagory</th>
      		<th scope="col">Quantity</th>
      		<th scope="col">Price</th>
      		<th> </th>
    	</tr>			  
       
	   		<!-- <table>
			  <tr>
			    <th>No.</th>
			    <th>Product</th>
			    <th>Category</th>
			    <th>Quatity</th>
			    <th>Price</th>
			    <th> </th>
			  </tr> -->
			 
			 
			  <%
			  	for(Cart c : list){
			  		total += c.getProductPrice();
			  %>
			   <tr>
			    <td><%= ++i %></td>
			    <td><%= c.getProductName() %></td>
			    <td><%= c.getProductCatagory() %></td>
			    <td><%= c.getProductQuantity() %></td>
			    <td><%= c.getProductPrice() %></td>
			    <td><a href="delItem.htm?cartId=<%=c.getCartId() %>">delete</a></td>
			  </tr>
			  <% } %>
			  <tr>
			  	<td></td>
			  	<td></td>
			  	<td >Total Price => </td>
			  	<td><%= total  %></td>
			  	<td></td>
			  </tr>
			  <% } %>
			</table>
			</div>
	</div>

	

</body>
</html>