<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="Bean.*"%>
<%@ page import="DAO.*"%>
<%@ page import="DAO.impl.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="index.css">

<title>Admin|财务管理</title>
</head>

<body>
	<nav>
		<a href="./index.jsp">首页</a> <a href="./userManager/userManager.jsp">用户管理</a>
		<a href="./infoManager/infoManager.jsp">信息管理</a> <a
			href="./incomeManager/incomeManager.jsp">财务管理</a>
	</nav>
	<main>
		<h1>Ceelia 人事管理系统</h1>
		<div class="row-container">
			<h3>您的个人信息</h3>
			<%
			int id = (int) session.getAttribute("id");
			userDAO userDao = new userDAOimpl();
			user a_user = userDao.getById(id);
			infoDAO infoDao = new infoDAOimpl();
			info a_info = infoDao.getById(id);
			incomeDAO incomeDao = new incomeDAOimpl();
			income a_income = incomeDao.getById(id);
			%>
			<div class="row">
				<span>姓名</span><span><%=a_info.getName()%></span></div>
			<div class="row">
				<span>帐号</span><span><%=a_user.getAccount()%></span></div>
			<div class="row">
				<span>年龄</span><span><%=a_info.getAge()%></span></div>
			<div class="row">
				<span>身份</span><span><%=a_user.getRole()%></span></div>
			<div class="row">
				<span>实际工资</span><span><%=a_income.getReal()%></span></div>
		</div>
		<div class="box-container">
			<div class="box pic1">Ceelia</div>
			<div class="box pic2">人事</div>
			<div class="box pic3">管理</div>
		</div>

		<button onclick="_exit()">退出</button>
	</main>
	<script>
		function _exit() {
			location.href = "../"
		}
	</script>
</body>

</html>