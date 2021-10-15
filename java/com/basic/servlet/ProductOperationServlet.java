package com.basic.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.basic.dao.CategoryDao;
import com.basic.dao.ProductDao;
import com.basic.entity.Category;
import com.basic.entity.Product;
import com.basics.helper.FactoryProvider;
@MultipartConfig


public class ProductOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		try(PrintWriter out= response.getWriter()){
			
			//add category
			String op=request.getParameter("operation");
			if(op.trim().equals("addcategory")) {
				
				//fetching category data
				
				String title=request.getParameter("catTitle");
				String description=request.getParameter("catDescription");
				
				Category category = new Category();
				category.setCategoryTitle(title);
				category.setCztegoryDescription(description);
				
				CategoryDao categoryDao = new CategoryDao(FactoryProvider.getFactory());
				int catId=categoryDao.saveCategory(category);
				out.println(catId);
				
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("message", "Category added successfully "+category.getCategoryId());
				response.sendRedirect("admin.jsp");
				return;
				
				
			}else if(op.trim().equals("addproduct")) {
				
				String productName = request.getParameter("productName");
				String productDescription = request.getParameter("productDescription");
				int productPrice =Integer.parseInt(request.getParameter("productPrice")) ;
				 int productDiscount =Integer.parseInt( request.getParameter("productDiscount"));
				 int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
				 int catId = Integer.parseInt(request.getParameter("catId"));
				 Part part=request.getPart("pPic");
				 
				 
				 Product p=new Product();
				 p.setProductName(productName);
				 p.setProductDescription(productDescription);
				 p.setProductPrice(productPrice);
				 p.setProductDiscount(productDiscount);
				 p.setProductQuantity(productQuantity);
				 p.setProductPhoto(part.getSubmittedFileName());
				 
				 
				 //getCategory iD
				 
				 CategoryDao cdao=new  CategoryDao(FactoryProvider.getFactory());
				 Category category=cdao.getCategoryById(catId);
				 p.setCategory(category);
				 
				 //product save...
				 
				 ProductDao pdao=new ProductDao(FactoryProvider.getFactory());
				 pdao.saveProduct(p);
				 
				 //pic upload
				 //find out the p[ath ti upload photo.......
				 
				 String path=request.getRealPath("img") + File.separator+"products"+ File.separator+ part.getSubmittedFileName();
				 System.out.println(path);
				 
				 try {
					 
				
					
					 FileOutputStream fos= new FileOutputStream(path); 
					  InputStream
					  is=part.getInputStream();
					  byte[] data=new byte[is.available()];
					  
					  is.read(data); 
					  fos.write(data); 
					  fos.close();
					 
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
				 
				 out.println("Product save success..........");
				 HttpSession httpSession = request.getSession();
					httpSession.setAttribute("message", "Product added successfully "+category.getCategoryId());
					response.sendRedirect("admin.jsp");
					return;
				 
				 	
			}
			
			
			
		}
	}

}
