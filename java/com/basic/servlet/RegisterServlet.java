package com.basic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.basic.entity.User;
import com.basics.helper.FactoryProvider;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		try {
			
			  String userName=request.getParameter("user_name");
			  String  userEmail=request.getParameter("user_email");
			  String  userPassword=request.getParameter("user_password");
			  String  userPhone=request.getParameter("user_phone");
			  String userAddress=request.getParameter("user_address");
			  
			  
			  if(userName.isEmpty())
			  {
				  out.print("name is blank");
				  return ;
			  }
			  
			 User user= new User(userName, userEmail, userPassword, userPhone,"default.jpg", userAddress,"normal");
			  
			  Session hibernateSession= FactoryProvider.getFactory().openSession();
			  Transaction tx=hibernateSession.beginTransaction();
			  
			  int userId=(int) hibernateSession.save(user);
			  
			  
			  tx.commit();
			  
			  hibernateSession.close();
			  
			  HttpSession httpSession=request.getSession();
			  httpSession.setAttribute("message", "Registration succesfully!!  User Id : "+userId  );
			  response.sendRedirect("register.jsp");
			  out.println("");
			  out.println("<br> user id is "+userId);


			  
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
