<%@page import="com.cdac.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="cache-control.jsp" %>
<% 
  if(((Admin)session.getAttribute("admin"))!=null)
  {
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home 2</title>

<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	

</head>
<body>

	<div class="container-fluid">
        <div class="row bg-primary justify-content-between align-items-center sticky-top" style="height: 60px;">
            <div class="col-4 text-light" style="font-size: 24px;">Shoppers Stop</div>
           
            <div class="col-4 text-light d-flex justify-content-end">
            <a href="logoutadmin.jsp" class="btn btn-outline-light" >Logout</a>
            </div>
     </div>
      <div class=" d-flex justify-content-right">
            Welcome <%=((Admin)session.getAttribute("admin")).getAdminName()%> 
            </div>


	<div class="d-flex justify-content-center align-item-center mt-5">
	
	<table align="center" >
	
		<tr>
			<td>
				<a href="prep_Product_add_form.htm" class="btn btn-outline-primary btn-block">Add Product</a>
			</td>
			
		</tr> 
		<tr>
			<td>
				<a href="Product_list.htm" class="btn btn-outline-primary btn-block">Product List</a>
			</td>
			
		</tr> 
		
		
		
	</table>
</body>
</html>


<%}
else{
	
		response.sendRedirect("errorpage.jsp");

}
%>