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
import java.sql.SQLException;

@WebServlet(name = "CustomerUpdateServlet", value ="/customer-update")
public class CustomerUpdateServlet extends HttpServlet {
    String DB_URL = "jdbc:mysql://localhost:3306/customerdb";
    String DB_USER = "root";
    String DB_PASSWORD = "Ijse@123";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String id =   req.getParameter("id");
      String name = req.getParameter("name");
      String address = req.getParameter("address");
      String email   =  req.getParameter("email");


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
         Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         String sql = "UPDATE customer SET name=?, address=?, email=? WHERE id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, name);
        pstm.setString(2, address);
        pstm.setString(3, email);
        pstm.setString(4, id);
        int updateRowCount =  pstm.executeUpdate();

            if (updateRowCount > 0 ) {
                resp.sendRedirect("customer-update.jsp?message=Customer Updated");
            } else {
                resp.sendRedirect("customer-update.jsp?error=Customer Not Updated");
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            resp.sendRedirect("customer-update.jsp?error=Failed to update the customer");
        }
    }
}
