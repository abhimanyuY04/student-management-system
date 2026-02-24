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
 * Servlet implementation class SearchStudentServlet
 */
@WebServlet("/searchStudent")
public class SearchStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        StudentDAO dao = new StudentDAO();

        List<Student> list = dao.searchStudentByName(name);

        request.setAttribute("students", list);

        request.getRequestDispatcher("view-students.jsp")
               .forward(request, response);
    }
}
