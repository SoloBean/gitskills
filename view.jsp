<%@ page language="java" import="java.sql.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'view.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <!-- -->
  </head>
  
  <body>
  <form action="GetBooksAction" method="get">
  <%String authorid = request.getParameter("authorid"); 
  String sql = "delete from book where authorid = '" + authorid+"'";
  Connection con = null;
       try {  
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动  
               
            con = DriverManager.getConnection(  
                    "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_booksdb", "1ox3mx5znn", "5l5x3113wzjwh3xjihhhilw0mh0h144kzlz2ymxl");// 创建数据连接 
                    Statement st = con.createStatement();
         
         int rs = st.executeUpdate(sql); 
              
        } catch (Exception e) {  
            System.out.println("数据库连接失败" + e.getMessage());  
        }  
         con.close();
         %>
    <%out.println("Delete successfully"); %>
   </form>
  </body>
</html>
