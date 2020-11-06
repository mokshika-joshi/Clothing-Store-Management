<%@page import="com.cdac.dto.Admin"%>
<%@page import="com.cdac.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="cache-control.jsp" %>
<% 
  if(((Admin)session.getAttribute("admin"))!=null)
  {
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	

</head>
<body>
	
	<div class="container-fluid">
        <div class="row bg-primary justify-content-between align-items-center sticky-top" style="height: 60px;">
            <div class="col-6 text-light" style="font-size: 24px;">Shoppers Stop</div>
            
     </div>

	<div class="text-primary d-flex justify-content-center">
	<h3>Product List</h3>
	</div>
	<div class="d-flex justify-content-center align-item-center mt-5">
	
	
	<table align="center" >
	
 	<%
	List<Product> plist = (List<Product>)request.getAttribute("proList");
 	for(Product pro : plist){
		%>
		<tr>
			<td>
				<%=pro.getProductName()%>
			</td>
			<td>
				<%=pro.getProductPrice()%>
			</td>
			<td>
				<%=pro.getProductQuantity()%>
			</td>
			<td>
				<%=pro.getProductCategory()%>
			</td>
			<td>
				<%=pro.getProductDescription()%>
			</td>
			<td>
				<a href="Product_delete.htm?productId=<%=pro.getProductId()%>">Delete</a>
			</td>
			<td>
				<a href="product_update_form.htm?productId=<%=pro.getProductId()%>">Update</a>
			</td>
		</tr>
		<% } %>
		<tr>
			<td>
				<a href="home2.jsp" class="btn btn-outline-primary btn-block">Back</a>
			</td>
			<td>
				
			</td>
		</tr>
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