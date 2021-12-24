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
<link rel="stylesheet" href="./infoManager.css">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<a href="../index.jsp">首页</a> <a
			href="../userManager/userManager.jsp">用户管理</a> <a
			href="./infoManager.jsp">信息管理</a> <a
			href="../incomeManager/incomeManager.jsp">财务管理</a>
	</nav>
	<h1>更新信息</h1>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	infoDAO infoDao = new infoDAOimpl();

	info a_info = infoDao.getById(id);
	String name = a_info.getName();
	String gender = a_info.getGender();
	int age = a_info.getAge();
	String address = a_info.getAddress();
	%>
	<main>
	<form action="../../infoUpdate" method="post">
		<input type="hidden" name="id" value=<%=id%>> <input
			type="text" name="name" value=<%=name%>> <input type="text"
			name="gender" value=<%=gender%>> <input type="text"
			name="age" value=<%=age%>><input type="text" name="address"
			value=<%=address%>>
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