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
<title>Admin|信息管理</title>
</head>
<body>
	<nav>
		<a href="../index.jsp">首页</a> <a
			href="../userManager/userManager.jsp">用户管理</a> <a
			href="./infoManager.jsp">信息管理</a> <a
			href="../incomeManager/incomeManager.jsp">财务管理</a>
	</nav>
	<h1>信息管理</h1>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>姓名</th>
				<th>性別</th>
				<th>年齡</th>
				<th>地址</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<info> infos = new ArrayList<info>();
			infoDAO infoDao = new infoDAOimpl();
			infos = infoDao.getAll();
			if (infos != null) {
				for (info a_info : infos) {
					int emId = a_info.getId();
					String name = a_info.getName();
					String gender = a_info.getGender();
					int age = a_info.getAge();
					String address = a_info.getAddress();
			%>
			<tr>
				<td><%=emId%></td>
				<td><%=name%></td>
				<td><%=gender%></td>
				<td><%=age%></td>
				<td><%=address%></td>
				<td>
					<button onclick="_edit(<%=emId%>)">Edit</button>
					<button
						onclick="_delete('<%=emId%>','<%=name%>','<%=gender%>','<%=age%>','<%=address%>')">Delete</button>
				</td>
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
			location.href = "./infoUpdate.jsp?id=" + emId;
		};
		function _delete(id,name,gender,age,address) {
 			location.href = "../../infoDelete?id="+id+"&name="+name+"&gender="+gender+"&age="+age+"&address="+address;
		};
		function _add(){
			location.href="./infoAdd.jsp";
		}
		function _exit(){
			location.href="../../";
		}
		</script>
</body>
</html>