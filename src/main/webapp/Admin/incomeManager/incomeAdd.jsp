<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../style.css">
<link rel="stylesheet" href="./incomeAdd.css">
<title>Admin|财务管理</title>
</head>
<body>
	<nav>
		<a href="../index.jsp">首页</a> <a href="../userManager/userManager.jsp">用户管理</a>
		<a href="../infoManager/infoManager.jsp">信息管理</a> <a
			href="./incomeManager.jsp">财务管理</a>
	</nav>
	<h1>新增财务</h1>
<main>
	<form action="../../incomeAdd" method="post">
	<input type="text" name="id" placeholder="ID">
		<input type="text" name="min" placeholder="基本工资"> <input
			type="text" name="merit" placeholder="额外工资"> <input type="text"
			name="allo" placeholder="绩效工资" ><input type="text" name="ponins"
			placeholder="养老保险"><input type="text" name="heains"
			placeholder="医疗保险">
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