package org.example.jsp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Value;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerAllServlet", value = "/customer-all")
public class CustomerAllServlet extends HttpServlet {
    String DB_URL = "jdbc:mysql://localhost:3306/customerdb";
    String DB_USER = "root";
    String DB_PASSWORD = "Ijse@123";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CustomerDTO> customerList  = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL,  DB_USER, DB_PASSWORD);
            String sql = "SELECT * FROM customer";
            Statement stm  = connection.createStatement();
            ResultSet resultSet = stm.executeQuery(sql);
            while (resultSet.next()){
               CustomerDTO customerDTO = new CustomerDTO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
               customerList.add(customerDTO);
            }

            // Attaches the customers list to the request object, making it accessible in the JSP.

            req.setAttribute("customers", customerList);

            //Used to forwad the request to jsp file
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("customer-list.jsp");

            //Send tge request and response objects to the Specified JSP for rendering
            requestDispatcher.forward(req, resp);


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();;
            resp.sendRedirect("customer-list.jsp?error= Failed to get customers");
        }
    }
}
