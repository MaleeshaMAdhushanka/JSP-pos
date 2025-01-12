package org.example.jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "CustomerDeleteServlet", value ="/customer-delete")
public class CustomerDeleteServlet extends HttpServlet {

    String DB_URL = "jdbc:mysql://localhost:3306/customerdb";
    String DB_USER = "root";
    String DB_PASSWORD = "Ijse@123";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String id = req.getParameter("id");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
          Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );

          String sql = "DELETE FROM customer WHERE id = ?";
         PreparedStatement pst = connection.prepareStatement(sql);
         pst.setString(1, id);

        int deleteRowCount = pst.executeUpdate();

            if (deleteRowCount > 0) {
                resp.sendRedirect("customer-delete.jsp?message=Customer Deleted");
            } else {
                resp.sendRedirect("customer-delete.jsp?error=Customer Not Deleted");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("customer-delete.jsp?error=Fail to delete customer");
        }
    }
}
