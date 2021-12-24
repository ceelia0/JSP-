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
<link rel="stylesheet" href="./incomeManager.css">
<title>Admin|财务管理</title>
</head>
<body>
	<nav>
		<a href="../index.jsp">首页</a> <a href="../userManager/userManager.jsp">用户管理</a>
		<a href="../infoManager/infoManager.jsp">信息管理</a> <a
			href="./incomeManager.jsp">财务管理</a>
	</nav>
	<h1>财务管理</h1>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>基本工资</th>
				<th>额外工资</th>
				<th>绩效工资</th>
				<th>养老保险</th>
				<th>医疗保险</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<income> incomes = new ArrayList<income>();
			incomeDAO incomeDao = new incomeDAOimpl();
			incomes = incomeDao.getAll();
			if (incomes != null) {
				for (income a_user : incomes) {
					int id = a_user.getId();
					double min = a_user.getMin();
					double merit = a_user.getMerit();
					double allo = a_user.getAllo();
					double ponins = a_user.getPonins();
					double heains = a_user.getHeains();
			%>
			<tr>
				<td><%=id%></td>
				<td><%=min%></td>
				<td><%=merit%></td>
				<td><%=allo%></td>
				<td><%=ponins%></td>
				<td><%=heains%></td>
				<td>
					<button onclick="_edit(<%=id%>)">Edit</button>
					<button
						onclick="_delete('<%=id%>','<%=min%>','<%=merit%>','<%=allo%>','<%=ponins%>','<%=heains%>')">Delete</button>
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
		function _edit(id) {
			location.href = "./incomeUpdate.jsp?id=" + id;
		};
		function _delete(id,min,merit,allo,ponins,heains) {
 			location.href = "../../incomeDelete?id="+id+"&min="+min+"&merit="+merit+"&allo="+allo+"&ponins="+ponins+"&heains="+heains;
		};
		function _add(){
			location.href="./incomeAdd.jsp";
		}
		function _exit(){
			location.href="../../";
		}
		</script>
</body>
</html>