package com.proj.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proj.dao.Dao;
import com.proj.dao.DaoImpl;
import com.proj.domain.Student;

/**
 * Servlet implementation class UserActions
 */
@WebServlet(urlPatterns = { "/signup", "/login", "/dashboard", "/addnewproject", "/myprofile" })
public class UserActions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Dao dao = new DaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url = request.getRequestURI();
		HttpSession hs = request.getSession();
		Student student = null;
		if (url.endsWith("signup")) {
			String usn, name, dept, email, mob, pwd;
			int sem;
			usn = request.getParameter("name").toUpperCase();
			Student s = new Student(usn, name, dept, email, mob, pwd, sem);
		} else if (url.endsWith("login")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			if (email.equalsIgnoreCase("admin@ncet.com") && password.equals("ncet")) {
				response.sendRedirect("admin.html");
			} else if ((student = dao.loginStudent(email, password)) != null) {
				String name = student.getName();
				String usn = student.getUsn();
				hs.setAttribute("usn", usn);
				hs.setAttribute("name", name);
			}

		} else if (url.endsWith("addnewproject")) {

		} else if (url.endsWith("myprofile")) {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
