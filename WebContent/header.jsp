<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html style="height: 42px;">
<head>
<style type="text/css">
p {
	list-style: none;
	float:left;
	margin:10px;
}
.logo{
	float:left;
	padding:20px 10px;
}
</style>
<link rel="stylesheet" type="text/css" href="shop.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="header">
		<div class="header-logo"><h3>オンラインショッピングサイト</h3></div>
	</div>
	<div class="header-list">
	

	</div>
	<p class="name"><c:out value="${userInfo.name}" /></p>

	<p class="time">
		<span id="view_today"></span>

		<script type="text/javascript">
			document.getElementById("view_today").innerHTML = getToday();

			function getToday() {
				var now = new Date();
				var year = now.getFullYear();
				var mon = now.getMonth() + 1; //１を足すこと
				var day = now.getDate();

				var s = year + "/" + mon + "/" + day;
				return s;
			}
		</script>
	</p><br>
	<br>
</body>
</html>