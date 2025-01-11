<%@ page import="java.util.List" %>
<%@ page import="org.example.jsp.CustomerDTO" %><%--
  Created by IntelliJ IDEA.
  User: ZeejMaleesha
  Date: 1/11/2025
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<%--navbar--%>
<div class="navbar">
    <a href="index.jsp">Home</a>
    <div class="dropdown">
        <button class="dropbtn">Customer
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="customer-save.jsp">ADD NEW CUSTOMER</a>
            <a href="customer-list.jsp">VIEW CUSTOMERS</a>
            <a href="customer-delete.jsp">DELETE CUSTOMER</a>
            <a href="customer-update.jsp">EDIT CUSTOMER</a>
        </div>
    </div>
</div>
<body>
<h1> Customer List</h1>
<%
  List<CustomerDTO> customerDataList = (List<CustomerDTO>) request.getAttribute("customers");
  if(customerDataList != null && customerDataList.size() > 0){

%>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Email</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (CustomerDTO customer : customerDataList){
    %>
    <tr>
        <td><%= customer.getId() %></td>
        <td><%= customer.getName() %></td>
        <td><%= customer.getAddress() %></td>
        <td><%= customer.getEmail() %></td>
        <td>
            <a href="customer-edit?id=<%= customer.getId() %>">Edit</a>
            <a href="customer-delete?id=<%= customer.getId() %>">Delete</a>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
    <%
        }
    %>
</table>

</body>
</html>
