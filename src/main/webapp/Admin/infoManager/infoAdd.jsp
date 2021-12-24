<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>添加信息</h1>
	<main>
	<form action="../../infoAdd" method="post">
	<input type="text" name="id" placeholder="ID">
		<input type="text" name="name" placeholder="姓名"> <input
			type="text" name="gender" placeholder="性別"> <input
			type="text" name="age" placeholder="年龄"><input type="text"
			name="address" placeholder="地址">
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