import java.sql.*;
import java.util.Scanner;

public class Main {

    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASS = "Abhi@1234";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {

                System.out.println("STUDENT MENU ");
                System.out.println("1. Register");
                System.out.println("2. Get Student By ID");
                System.out.println("3. Get All Students");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");
                System.out.print("Enter Choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    // Register
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        String insert = "INSERT INTO student VALUES(?,?,?,?)";
                        PreparedStatement ps = con.prepareStatement(insert);
                        ps.setInt(1, id);
                        ps.setString(2, name);
                        ps.setInt(3, age);
                        ps.setString(4, course);

                        if (ps.executeUpdate() > 0)
                            System.out.println("Student Registered Successfully");
                        break;

                    // Get Student By ID
                    case 2:
                        System.out.print("Enter ID: ");
                        id = sc.nextInt();

                        String select = "SELECT * FROM student WHERE id=?";
                        ps = con.prepareStatement(select);
                        ps.setInt(1, id);

                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                            System.out.println("ID      : " + rs.getInt("id"));
                            System.out.println("Name    : " + rs.getString("name"));
                            System.out.println("Age     : " + rs.getInt("age"));
                            System.out.println("Course  : " + rs.getString("course"));
                        } else {
                            System.out.println("Student Not Found");
                        }
                        break;

                    // Get All Students
                    case 3:
                        Statement st = con.createStatement();
                        rs = st.executeQuery("SELECT * FROM student");

                        while (rs.next()) {
                            System.out.println("--------------------------");
                            System.out.println("ID      : " + rs.getInt(1));
                            System.out.println("Name    : " + rs.getString(2));
                            System.out.println("Age     : " + rs.getInt(3));
                            System.out.println("Course  : " + rs.getString(4));
                        }
                        break;

                    // Update Student
                    case 4:
                        System.out.print("Enter ID: ");
                        id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        name = sc.nextLine();

                        System.out.print("Enter New Age: ");
                        age = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Course: ");
                        course = sc.nextLine();

                        String update = "UPDATE student SET name=?, age=?, course=? WHERE id=?";
                        ps = con.prepareStatement(update);
                        ps.setString(1, name);
                        ps.setInt(72, age);
                        ps.setString(3, course);
                        ps.setInt(4, id);

                        if (ps.executeUpdate() > 0)
                            System.out.println("Updated Successfully");
                        else
                            System.out.println("Student Not Found");
                        break;

                    // Delete Student
                    case 5:
                        System.out.print("Enter ID: ");
                        id = sc.nextInt();

                        String delete = "DELETE FROM student WHERE id=?";
                        ps = con.prepareStatement(delete);
                        ps.setInt(1, id);

                        if (ps.executeUpdate() > 0)
                            System.out.println("Deleted Successfully");
                        else
                            System.out.println("Student Not Found");
                        break;

                    // Exit
                    case 6:
                        con.close();
                        sc.close();
                        System.out.println("Thank You!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}