<%@page import="com.cdac.dto.Customer"%>
<%@page import="com.cdac.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ include file="cache-control.jsp" %>
<% 
  if(((Customer)session.getAttribute("customer"))!=null)
  {
%>    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product list for customer</title>

<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	


</head>
<body>


	<div class="container-fluid">
        <div class="row bg-primary justify-content-between align-items-center sticky-top" style="height: 60px;">
            <div class="col-6 text-light" style="font-size: 24px;">Shoppers Stop</div>
            <div class="col-3 text-light d-flex justify-content-end">
            <div class="col-3 text-light d-flex justify-content-end">
            <a href="getCart.htm" class="btn btn-outline-light mr-2" >Cart</a>
        
            </div>
            </div>
     </div>


	
	<div class="d-flex justify-content-center align-item-center mt-5">
	
	
	
	
	<table align="center" >
 	<%
	List<Product> plist = (List<Product>)request.getAttribute("itemList");
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
			
			
			<form  action="addToCart.htm"  method="post" >
							<td>
                    		<input type="text" name="ProductQuantity" />
                    		</td>
                    		<td>
	                    	<input type="hidden" name="ProductId" value="<%= pro.getProductId()%>"/>
	                    	</td>
	                    	<td>
	                         	<button>AddToCart</button>
	                         	</td>
                    </form>
			
		</tr>
		<% } %>
		<tr>
			<td>
				<a href="CustomerWelcome.jsp"" class="btn btn-outline-primary btn-block">Back</a>
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