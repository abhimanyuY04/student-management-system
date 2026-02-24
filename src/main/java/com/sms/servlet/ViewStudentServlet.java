package com.sms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.dao.StudentDAO;
import com.sms.model.Student;

/**
 * Servlet implementation class ViewStudentServlet
 */
@WebServlet("/viewStudents")
public class ViewStudentServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      int page = 1;
      int recordsPerPage = 5;

      if(request.getParameter("page") != null){
          page = Integer.parseInt(request.getParameter("page"));
        }

        StudentDAO dao = new StudentDAO();

        List<Student> list = dao.getStudentsByPage((page-1)*recordsPerPage, recordsPerPage);

        request.setAttribute("students", list);
        request.setAttribute("currentPage", page);

        request.getRequestDispatcher("view-students.jsp").forward(request, response);
	}

	

}
