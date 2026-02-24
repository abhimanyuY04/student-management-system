package com.sms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.dao.StudentDAO;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	 protected void doGet(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {

     StudentDAO dao = new StudentDAO();

     int total = dao.getStudentCount();

     request.setAttribute("totalStudents", total);

     request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	 }
}
