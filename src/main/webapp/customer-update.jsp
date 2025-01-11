<%--
  Created by IntelliJ IDEA.
  User: ZeejMaleesha
  Date: 1/11/2025
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Update</title>
</head>
<body>
<h1>Update Customer</h1>

<%
   String message = (String) request.getParameter("message");
   String error = (String) request.getParameter("error");
%>
<%
    if (message != null){

%>
<div style="color: green">
    <%= message %>
</div>

<%
    }
%>
<%
    if (error != null){
%>
<div style="color: red">
    <%= error%>
</div>
<%
    }
%>

<form action="customer-update" method="post">
    <label for="id">ID:</label>
    <input type="text" id="id" name="id"/>
    <br/>
    <br/>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name"/>
    <br/>
    <br/>
    <label for="address">Address:</label>
    <input type="text" id="address" name="address"/>
       <br/>
    <br/>
    <label for="email">Email:</label>
    <input type="text" id="email" name="email"/>

    <button type="submit" id="update">Update</button>







</form>

</body>
</html>
