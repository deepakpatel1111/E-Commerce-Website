<%@page import = "com.basics.helper.FactoryProvider" %>
<%@page import = "com.basic.dao.ProductDao" %>
<%@page import = "com.basic.dao.CategoryDao" %>

<%@ page  import="java.util.List" %> 
 <%@ page  import="com.basic.entity.Product" %> 
 <%@ page  import="com.basic.entity.Category" %> 
  <%@ page import="com.basics.helper.Helper" %> 
 
<html>
<body>
<h2>Hello World!</h2>

<h1> session factory object</h1>
<%@include file="component/common_css_js.jsp"  %>
<%@include file="component/navbar.jsp"  %>

<!--  show facroty session -->

<%-- <%
    out.println(FactoryProvider.getFactory());
    out.println(FactoryProvider.getFactory());
    out.println(FactoryProvider.getFactory());


%> --%>


				<!-- Home -->
				
				<!-- show categories -->
			<div class="row mt-3 mx-2">	
			
				<% 
				String cat= request.getParameter("category");
			//	out.println(cat);
				ProductDao dao=new ProductDao(FactoryProvider.getFactory());
				List<Product>list=null;
			
				 if(cat==null || cat.trim().equals("all")){
				   list=dao.getAllProducts();
				}else{
					
					int cid=Integer.parseInt(cat.trim());
					list=dao.getAllProductsById(cid);
				} 
				
				CategoryDao cdao =new CategoryDao(FactoryProvider.getFactory());
				List<Category> clist= cdao.getCategories();
				   
				%>
				
				<div class="col-md-2">
				
					<div class="list-group">
					
						 <a href="index.jsp?category=all" class="list-group-item list-group-item-action active">
						    Categories
						  </a>
						  
						  <% 
						      for(Category c : clist){
							  
							  
							  %>
							  
              					 <a href="index.jsp?category=<%=c.getCategoryId() %>" class="list-group-item list-group-item-action"> <%=c.getCategoryTitle()  %></a>
              
						 <%
						 }
						  
						  
						  %>
					</div>
				
				
				</div>
				
				<!-- show products -->
				<div class="col-md-10">
				<%-- <h1> Number of Products is <%= list.size() %></h1> --%>
			     <!-- row -->
			     <div class="row" mt-4>
			     	<div class="col-md-12">
			         	
			         	<div class="card-columns">
			         	
			         		<!-- traversing produvt -->
			         		
			         		<%
			         			for(Product p:list){
			         		
			         		%>
			         		
			         		<div class="card product-card">
			         		
			         			<div class ="container text-center">
			         					 <img src="img/products/<%=p.getProductPhoto() %>" style="max-height:200px; max-width :100%; width:auto" class="card-img-top m-2" alt="...">
			         		
			         			
			         			</div>
			         			<div  class= "card-body">
			         			 
			         			 	<h5 class="card-title"> <%=p.getProductName() %></h5>
			         				
			         				<p class="card-description"><%=Helper.getTenWords(p.getProductDescription()) %>
			         			</div>
			         			
			         			
			         			<div  class="card-footer text-center">
			         			 	<button class="btn custom-bg text-white" onclick="add_to_cart(<%= p.getProductId() %>,'<%= p.getProductName() %>','<%= p.getProductPrice()  %>')">Add to Cart</button>
			         			 	<button class="btn btn-outline-success"> &#8377 <%=p.getPriceAfterApplyingDiscount() %>/- <span class="text-secondary discount-label"> &#8377 <%=p.getProductPrice()  %> ,<%=p.getProductDiscount() %> % off </span></button>
			         			</div>
			         		
			         		</div>
			         		
			         		
			         		
			         		<%}
			         		if(list.size()==0){
			         			
			         			out.println("<h3>No item Available</h3>");
			         		}
			         		%>
			         		
			         	
			         	
			         	
			         	
			         	
			         	
			         	</div>	
			     	
			     	</div>
			     	 
			     
			     
			     </div>
				
				
				</div>
				
			</div>		
				

<%@include file="component/common_modals.jsp"  %>
      
</body>
</html>


<!-- We can do pagination for more product like 100000.
 -->