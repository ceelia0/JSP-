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
<link rel="stylesheet" href="../style.css">
<link rel="stylesheet" href="./userManager.css">
<style type="text/css">

</style>
<title>Admin|用户管理</title>
</head>
<body>
	<nav>
		<a href="../index.jsp">首页</a> <a href="./userManager.jsp">用户管理</a> <a
			href="../infoManager/infoManager.jsp">信息管理</a> <a
			href="../incomeManager/incomeManager.jsp">财务管理</a>
	</nav>
	<h1>用户管理</h1>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>帐号</th>
				<th>密码</th>
				<th>身份</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<user> users = new ArrayList<user>();
			userDAO userDao = new userDAOimpl();
			users = userDao.getAll();
			if (users != null) {
				for (user a_user : users) {
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
				<td><button onclick="_edit(<%=emId%>)">Edit</button>
					<button
						onclick="_delete('<%=emId%>','<%=uname%>','<%=upass%>','<%=role%>')">Delete</button></td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
	<button onclick="_add()">添加信息</button>
	<button onclick="_exit()">退出</button>
	<div class="box-container">
		<div class="box pic1">Ceelia</div>
		<div class="box pic2">用户</div>
		<div class="box pic3">管理</div>
	</div>
	<script>
		function _edit(emId) {
			location.href = "./userUpdate.jsp?id=" + emId;
		};
		function _delete(emId,uname,upass,role) {
 			location.href = "../../userDelete?id="+emId+"&uname="+uname+"&upass="+upass+"&role="+role;
		};
		function _add(){
			location.href="./userAdd.jsp";
		}
		function _exit(){
			location.href="../../";
		}
	</script>
</body>
</html>