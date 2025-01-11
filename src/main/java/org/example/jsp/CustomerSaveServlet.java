package org.example.jsp;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CustomerSaveServlet", value = "/customer-save")
public class CustomerSaveServlet extends HttpServlet {
    String DB_URL = "jdbc:mysql://localhost:3306/customerdb";
    String DB_USER = "root";
    String DB_PASSWORD = "Ijse@123";




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "INSERT INTO customer (name, address, email) VALUES (?, ?, ?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setString(3, address);
            pstm.setString(2, email);

            int i = pstm.executeUpdate();
            pstm.close();
            connection.close();

            if (i > 0){
                //success
                response.sendRedirect("customer-save.jsp?message=Customer Saved successfully");
            }else{
                //fail
                response.sendRedirect("customer-save.jsp?error=Failed to save the customer");
            }


        } catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("customer-save.jsp?error=Failed to save the customer");
        }
    }
}


