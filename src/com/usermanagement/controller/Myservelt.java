package com.usermanagement.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermanagement.bean.User;
import com.usermanagement.dao.UserDao;


@WebServlet("/")
public class Myservelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		
		case "/validate":validateAdmin(request,response);
		break;
		case "/add":getAddUserForm(request,response);
		break;
		case "/list":displayUser(request,response);
		break;
		case "/insert":insertUser(request,response);
		break;
		case "/delete":deleteUser(request,response);
		break;
		default:getAdminLoginPage(request,response);
		break;
		}

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		int id =Integer.parseInt(request.getParameter("id"));
		UserDao.delete(id);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		
		User u = new User(name, email, city);
		UserDao.insertStudentDetails(u);
		
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	private void displayUser(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<User> al = UserDao.display();
		request.setAttribute("userlist", al);
		RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getAddUserForm(HttpServletRequest request, HttpServletResponse response) {
		
		RequestDispatcher rd = request.getRequestDispatcher("UserForm.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	private void validateAdmin(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		
		boolean status = UserDao.CheckLogin(username, password);
		if(status) 
		{
			try {
				response.sendRedirect("list");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		else {
			try {
				response.sendRedirect("my");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void getAdminLoginPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("AdminLogin.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}

