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
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		Student s = new Student(id ,name ,age);
		StudentDAO dao = new StudentDAO();
		dao.updateStudent(s);
		resp.sendRedirect("viewStudents");
	}
}
