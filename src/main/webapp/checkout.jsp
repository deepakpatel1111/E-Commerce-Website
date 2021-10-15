 
     <%
    
    		User user=(User)session.getAttribute("current-user");
    		if(user==null){
    			session.setAttribute("message","You are not logged in");
    			response.sendRedirect("login.jsp");
    			
    			return;
    		}
    			
    			%>
    			
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>checkout</title>
<%@include file="component/common_css_js.jsp"  %>


</head>
<body>
<%@include file="component/navbar.jsp"  %>
<%@include file="component/common_modals.jsp"  %>



<div class="container">

	<div class="row mt-5">
	
		<div class="col-md-6">
		
		<div class="card">
		
		<div class="card-body">
		
		  <h3 class="text-center mb-5"> Your Selected Product</h3>
		
			 <div class="cart-body">
		 
		
		
		 
		
		
		</div>
		
		
		</div>
		
		
		</div>
		
		
		
		</div>
		
		<div class="col-md-6">
		
		
			<div class="card">
				<div class="card-body">
				 	  <h3 class="text-center mb-5"> Your Details for Order</h3>
				 	  <form action="#! ">
				 	  
				 	  		 <div class="form-group">
   							 <label for="exampleInputEmail1">Email address</label>
							 <input value ="<%=user.getEmail() %>" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter your Email">
							    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
							  </div>
							  
							  
							 <div class="form-group">
   							 <label for="name">Your Name</label>
							 <input value="<%=user.getName() %>" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter your Name">
							   
							  </div>		
							  
							   <div class="form-group">
   							 <label for="name">Your Mobile Number </label>
							 <input value="<%=user.getPhoneNumber() %>" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter your Mobile Number">
							   
							  </div>
							  
							  
							  	 	  
				 	  
	
	 						<div class="form-group">
   							 <label for="address" class="form-label">Your Address</label>
							 <textarea value="<%=user.getAddress() %>" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" rows="3.5" placeholder="Enter your Address"></textarea>
								</div>
								
												
								<div class=" container text-center">
								<button class="btn btn-outline-success"> Order Now</button>
								<button class="btn btn-outline-primary">Continue Shopping </button>
								</div>							   
							 
				 	  </form>
		
				
				</div>
			</div>
		
		
		</div>
	
	
	
	
	</div>









</div>



</body>
</html>