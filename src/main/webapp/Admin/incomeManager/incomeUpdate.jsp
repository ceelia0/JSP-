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
<link rel="stylesheet" href="./incomeUpdate.css">
<title>Admin|财务管理</title>
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	incomeDAO incomeDao = new incomeDAOimpl();

	income a_income = incomeDao.getById(id);
	Double min = a_income.getMin();
	Double merit = a_income.getMerit();
	Double allo = a_income.getAllo();
	Double ponins = a_income.getPonins();
	Double heains = a_income.getHeains();
	%>
		<nav>
		<a href="../index.jsp">首页</a> <a href="../userManager/userManager.jsp">用户管理</a>
		<a href="../infoManager/infoManager.jsp">信息管理</a> <a
			href="./incomeManager.jsp">财务管理</a>
	</nav>
	<h1>更新财务</h1>
	<main>
	<form action="../../incomeUpdate" method="post">
		<input type="hidden" name="id" value=<%=id%>> <input
			type="text" name="min" value=<%=min%>> <input type="text"
			name="merit" value=<%=merit%>> <input type="text" name="allo"
			value=<%=allo%>><input type="text" name="ponins"
			value=<%=ponins%>><input type="text" name="heains"
			value=<%=heains%>>
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