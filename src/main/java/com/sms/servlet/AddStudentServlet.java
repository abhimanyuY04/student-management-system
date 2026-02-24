package com.sms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.dao.StudentDAO;
import com.sms.model.Student;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		Student s = new Student(id ,name , age);
		StudentDAO  dao = new StudentDAO();
		boolean status = dao.saveStudent(s);
		
		if(status){
		    req.setAttribute("msg", "Student Added Successfully!");
		    req.getRequestDispatcher("success.jsp")
		           .forward(req, resp);
		}else{
		    req.setAttribute("msg", "Error Adding Student!");
		    req.getRequestDispatcher("success.jsp")
		           .forward(req, resp);
		}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
