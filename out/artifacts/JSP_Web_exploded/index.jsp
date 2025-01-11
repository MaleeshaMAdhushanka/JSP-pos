<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP -Customer Management System- </title>
    <link rel="stylesheet"type="text/css" href="css/style.css">
</head>
<body>
<div class="navbar">
    <a href="index.jsp">Home</a>
    <div class="dropdown">
        <button>Customer
        <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="customer-save.jsp">Add New Customer</a>
            <a href="customer-list.jsp">Customer List</a>
            <a href="customer-delete.jsp">Delete Customer</a>
            <a href="customer-update.jsp">Update Customer</a>
        </div>

    </div>

</div>
<h1><%="Customer Management System"%><br/>
     <a href="customer-save.jsp">Add New Customer</a><br/>
     <a href="customer-list.jsp">Customer List</a><br/>
     <a href="customer-delete.jsp">Delete Customer</a><br/>
    <a href="customer-update.jsp">Update Customer</a><br/>
</body>
</html>