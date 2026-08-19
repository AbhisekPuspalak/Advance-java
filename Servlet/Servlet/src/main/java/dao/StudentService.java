package dao;

import entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentService {
    private static Connection con=null;
    static {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","Abhi@1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int register(Student student) {
        String sql = "insert into student values(?,?,?,?)";

        try {
            PreparedStatement prt = con.prepareStatement(sql);

            prt.setInt(1, student.getId());
            prt.setString(2, student.getName());
            prt.setString(3, student.getEmail());
            prt.setInt(4, student.getRegd());

            return prt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
