package com.sms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.dao.StudentDAO;

/**
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		StudentDAO dao = new StudentDAO();
		dao.deleteStudent(id);
		resp.sendRedirect("viewStudents");
	}
    
}
