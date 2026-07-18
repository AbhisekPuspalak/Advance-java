import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "Abhi@1234";

        try {

            // Connect to the database
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Database Connected Successfully!");

            // SQL query with placeholders
            String sql = "INSERT INTO student (id, name, age) VALUES (?, ?, ?)";

            // Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(sql);

            // Set values
            ps.setInt(1, 2);
            ps.setString(2, "Rahul");
            ps.setInt(3, 23);

            // Execute the query
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Record not inserted.");
            }

            // Close resources
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


