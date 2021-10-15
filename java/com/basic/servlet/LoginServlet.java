package com.basic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.dao.UserDao;
import com.basic.entity.User;
import com.basics.helper.FactoryProvider;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out= response.getWriter();
//		try{
//			
//			
//			String user_email = request.getParameter("email");
//			String user_password = request.getParameter("password");
//			
//			UserDao userDao= new UserDao(FactoryProvider.getFactory());
//			System.out.println("hello m here");
//			
//			User user=userDao.getUserByEmailAndPassword(user_email, user_password);
//			
//			System.out.println(user);
//			
//			
//			
//			HttpSession httpSession=request.getSession();
//			if(user==null) {
//				
//				//out.println("<h1> Invalid details </h1>");
//				httpSession.setAttribute("message", "Invalid Details !! Try with another one ");
//				response.sendRedirect("login.jsp");
//				return;
//			}
//				else {
//					
//					out.println("<h1> Welcome "+user.getName()+"<h1>");
//					
//				 httpSession.setAttribute("current-user",user);
//				 
//				 if(user.getUserType().equals("admin")) {
//					 
//					 response.sendRedirect("admin.jsp");
//					 
//				 }else if(user.getUserType().equals("normal")) {
//					 
//					 
//					 response.sendRedirect("normal.jsp");
//				 }else {
//					 
//					 out.println("We have not Identified user");
//					 
//				 }
//	
//
//			}
//			
//			
//			
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			
//		}
//		
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out= response.getWriter();
		try{
			
			
			String user_email = request.getParameter("email");
			String user_password = request.getParameter("password");
			
			UserDao userDao= new UserDao(FactoryProvider.getFactory());
			System.out.println("hello m here");
			
			User user=userDao.getUserByEmailAndPassword(user_email, user_password);
			
			System.out.println(user);
			
			
			
			HttpSession httpSession=request.getSession();
			if(user==null) {
				
				//out.println("<h1> Invalid details </h1>");
				httpSession.setAttribute("message", "Invalid Details !! Try with another one ");
				response.sendRedirect("login.jsp");
				return;
			}
				else {
					
					out.println("<h1> Welcome "+user.getName()+"<h1>");
					
				 httpSession.setAttribute("current-user",user);
				 
				 if(user.getUserType().equals("admin")) {
					 
					 response.sendRedirect("admin.jsp");
					 
				 }else if(user.getUserType().equals("normal")) {
					 
					httpSession.setAttribute("current-user",user);
					 response.sendRedirect("index.jsp");
				 }else {
					 
					 out.println("We have not Identified user");
					 
				 }
	

			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		

}
	}
