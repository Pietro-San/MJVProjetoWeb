<%@page import="java.awt.print.Printable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="br.com.mjv.dao.*" import="br.com.mjv.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Usuario user = new Usuario();
UsuarioDao userDao = new UsuarioDao();
Conteudo cont = new Conteudo();
ConteudoDao contDao = new ConteudoDao();

user.setUser(request.getParameter("user"));
cont.setTitle(request.getParameter("title"));
cont.setBody(request.getParameter("body"));
out.println(userDao.incluir(user));


//out.println(contDao.incluir(cont));

%>
</body>
</html>