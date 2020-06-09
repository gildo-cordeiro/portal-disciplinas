package com.gildocordeiro.portal.configs;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

//@Controller
public class ServletConfig extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	ServletContext context; 
	
	public ServletConfig() {
		System.out.println("dale"+context);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		context = req.getServletContext();
		System.out.println(context);
	}
}
