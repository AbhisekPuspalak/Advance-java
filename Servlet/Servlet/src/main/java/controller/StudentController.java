package controller;

import dao.StudentService;
import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String uname =req.getParameter("username");
        String email=req.getParameter("email");
        String regd= req.getParameter("regd");
        System.out.println(id+" "+uname+" "+email+" "+" "+regd);
        Student s1=new Student();
        s1.setId(id);
        s1.setName(uname);
        s1.setEmail(email);
        s1.setRegd(Integer.parseInt(regd));
        StudentService service=new StudentService();
        service.register(s1);
    }
}
