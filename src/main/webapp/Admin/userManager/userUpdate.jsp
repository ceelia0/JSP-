<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="Bean.*"%>
<%@ page import="DAO.*"%>
<%@ page import="DAO.impl.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../style.css">
<link rel="stylesheet" href="./userUpdate.css">
<title>Admin|用户管理</title>
</head>
<body>
	<nav>
		<a href="../index.jsp">首页</a> <a href="./userManager.jsp">用户管理</a> <a
			href="../infoManager/infoManager.jsp">信息管理</a> <a
			href="../incomeManager/incomeManager.jsp">财务管理</a>
	</nav>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	userDAO userDao = new userDAOimpl();

	user a_user = userDao.getById(id);
	String uname = a_user.getAccount();
	String upass = a_user.getPasswd();
	int role = a_user.getRole();
	%>
	<h1>更新用户信息</h1>
	<main>
	<form action="../../userUpdate" method="post">
		<input type="hidden" name="id" value=<%=id%>> <input
			type="text" name="uname" value=<%=uname%>> <input type="text"
			name="upass" value=<%=upass%>> <input type="text" name="role"
			value=<%=role%>>
		<button>提交</button>
	</form>
	</main>
		<div class="box-container">
		<div class="box pic1">Ceelia</div>
		<div class="box pic2">用户</div>
		<div class="box pic3">管理</div>
	</div>
</body>
</html>