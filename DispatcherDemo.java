package com.r_dispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submit")      
public class DispatcherDemo  extends HttpServlet{
	
	protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
		
		String email =req.getParameter("email");
		String pass=req.getParameter("pass");
		
		System.out.println(email);
		System.out.println(pass);
		
		if(email.equals("sai@gmail.com") && pass.equals("sai@121")) {
			PrintWriter out= resp.getWriter();
			resp.setContentType("text/html");
			out.print("Login successfully..");
			RequestDispatcher rd=req.getRequestDispatcher("/index.html");
			rd.include(req, resp);
			
		}
		else {
			PrintWriter out=resp.getWriter();
			resp.setContentType ("text/html");
			out.print("<h1>username and pass did not match <h>");
			RequestDispatcher rd=req.getRequestDispatcher("/index.html");
			rd.include(req, resp);
			
		}
		
}
}
