<%--
  Created by IntelliJ IDEA.
  User: ZeejMaleesha
  Date: 1/11/2025
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Delete</title>
</head>
<div class="navbar">
    <a href="index.jsp">Home</a>
    <div class="dropdown">
        <button class="dropbtn">Customer
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="customer-save.jsp">ADD NEW CUSTOMER</a>
            <a href="customer-all">VIEW CUSTOMERS</a>
            <a href="customer-delete.jsp">DELETE CUSTOMER</a>
            <a href="customer-update.jsp">EDIT CUSTOMER</a>
        </div>
    </div>
</div>

<body>
<h1> Customer Delete</h1>

<%
    String message = (String) request.getParameter("message");
    String error = (String) request.getParameter("error");
%>

<%
    if (message != null) {


%>
<div style="color: green">
    <%=message%>
</div>

<%
    }

%>

<%
    if (error != null) {


%>

<div style="color: red">
    <%=error%>
</div>
<%
    }
%>

<form action="customer-delete" method="post">
    <label for="id">ID:</label>
    <input type="text" id="id" name="id"/>
    <br/>
    <button type="submit" id="delete">Delete</button>
</form>
</body>
</html>
