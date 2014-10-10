<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'result.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <!-- -->
  <body>
  <h3>Details</h3>
  <table border="3" width="200px">
  <tr><td>Author</td><td>${author}</td></tr>
  	<tr>
  		<td>Title</td>
  		<td><a href="details.jsp?isbn=${isbn}&age=${age}&price=${price}&country=${country}&publishdate=${publishdate}&publisher=${publisher}">${title}</a></td>
  		<td><a href="view.jsp?authorid=${authorid}">Delete</a></td>
 	 </tr>
  </table>
  
  </body>
</html>
