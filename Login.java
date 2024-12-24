package com.r_dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("login")
public class Login extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		System.out.println(email);
		System.out.println(pass);
		
		if(email.equals("checharednyaneshwar@gmail.com") && pass.equals("")) {
			
			PrintWriter out= resp.getWriter();
			resp.setContentType("text/html");
			out.print("Login successfully..");
			RequestDispatcher rd=req.getRequestDispatcher("/login.html");
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


