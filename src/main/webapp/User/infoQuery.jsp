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
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="index.css">
<title>User|信息查询</title>
</head>
<body>
	<nav>
		<a href="./index.jsp">首页</a> <a href="./infoQuery.jsp">信息查询</a>
	</nav>
	<main>
		<h1>Ceelia 信息查询</h1>
		<h2>帐号信息</h2>
		<%
		int id = (int) session.getAttribute("id");
		userDAO userDao = new userDAOimpl();
		infoDAO infoDao = new infoDAOimpl();
		incomeDAO incomeDao = new incomeDAOimpl();
		user a_user = userDao.getById(id);
		info a_info = infoDao.getById(id);
		income a_income = incomeDao.getById(id);
		%>
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>帐号</th>
					<th>密码</th>
					<th>身份</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (a_user != null) {
					int emId = a_user.getId();
					String uname = a_user.getAccount();
					String upass = a_user.getPasswd();
					int role = a_user.getRole();
				%>
				<tr>
					<td><%=emId%></td>
					<td><%=uname%></td>
					<td><%=upass%></td>
					<td><%=role%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<h2>个人详细信息</h2>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>住址</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<%
					if (a_info != null) {
						int emId = a_info.getId();
						String name = a_info.getName();
						String gender = a_info.getGender();
						int age = a_info.getAge();
						String address = a_info.getAddress();
					%>
					<td><%=emId%></td>
					<td><%=name%></td>
					<td><%=gender%></td>
					<td><%=age%></td>
					<td><%=address%></td>
					<%
					}
					%>
				</tr>
			</tbody>
		</table>
		<h2>收入详情</h2>
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>基本工资</th>
					<th>额外工资</th>
					<th>绩效工资</th>
					<th>养老保险</th>
					<th>医疗保险</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (a_income != null) {
					double min = a_income.getMin();
					double merit = a_income.getMerit();
					double allo = a_income.getAllo();
					double ponins = a_income.getPonins();
					double heains = a_income.getHeains();
				%>
				<tr>
					<td><%=id%></td>
					<td><%=min%></td>
					<td><%=merit%></td>
					<td><%=allo%></td>
					<td><%=ponins%></td>
					<td><%=heains%></td>
				</tr>
				<%}%>
			</tbody>
		</table>
	</main>
	<div class="box-container">
		<div class="box pic1">Ceelia</div>
		<div class="box pic2">人事</div>
		<div class="box pic3">管理</div>
	</div>
</body>
</html>