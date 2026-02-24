package com.sms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.dao.StudentDAO;
import com.sms.model.Student;

/**
 * Servlet implementation class EditStudentServlet
 */
@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		StudentDAO dao= new StudentDAO();
		Student s = dao.getStudentByID(id);
		req.setAttribute("student", s);
		req.getRequestDispatcher("update-student.jsp").forward(req, resp);
		
				
	}
}
