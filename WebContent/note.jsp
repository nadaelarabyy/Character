<%@page import="javax.swing.plaf.basic.BasicBorders.MarginBorder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">

</style>
<title>Success</title>
</head>
<body style="background-color: #f2f2f2;">
<div style="margin-top: 7%">
<h1 style="font-family: monospace;text-transform: capitalize;margin-left: 35%;font-size: 50px;">
thank you! <%=session.getAttribute("username") %></h1>
<h3 style="text-transform: capitalize;font-family: monospace;margin-left: 10%;font-size: 18px;">
your feedback and information have been of a great help and we appreciate your willingness to contribute to our research
</h3>

</div>

</body>
</html>