<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="shop.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>
	<h3>●会員情報</h3>
	<form action="changeDo.html" method="post">
		<table>
			<tr>
				<th class="form">会員NO</th>
				<td>
					<c:out value="${newInfo.memNum}"/>
					<input type="hidden" value="${newInfo.memNum}" name="memNum" />					
				</td>
			</tr>
			<tr>
				<th class="form">氏名</th>
				<td>
					<c:out value="${newInfo.name}"/>
					<input type="hidden" value="${newInfo.name}" name="name" />				
				</td>
			</tr>
			<tr>
				<th class="form">年齢</th>
				<td>
					<c:out value="${newInfo.age}"/>
					<input type="hidden" value="${newInfo.age}" name="age" />				
				</td>
			</tr>
			<tr>
				<th class="form">性別</th>
				<td>
					<c:out value="${newInfo.sex}"/>
					<input type="hidden" value="${newInfo.sex}" name="sex" />				
				</td>
			</tr>
			<tr>
				<th class="form">郵便番号</th>
				<td>
					<c:out value="${newInfo.postCode}"/>
					<input type="hidden" value="${newInfo.postCode}" name="postCode" />				
				</td>
			</tr>
			<tr>
				<th class="form">住所</th>
				<td>
					<c:out value="${newInfo.address}"/>
					<input type="hidden" value="${newInfo.address}" name="address" />				
				</td>
			</tr>
			<tr>
				<th class="form">電話番号</th>
				<td>
					<c:out value="${newInfo.phoneNum}"/>
					<input type="hidden" value="${newInfo.phoneNum}" name="phoneNum" />				
				</td>
			</tr>
			<tr>
				<th class="form">登録日</th>
				<td>
		<span id="view_today"></span>

		<script type="text/javascript">
			document.getElementById("view_today").innerHTML = getToday();

			function getToday() {
				var now = new Date();
				var year = now.getFullYear();
				var mon = now.getMonth() + 1; //１を足すこと
				var day = now.getDate();

				var s = year + "-" + mon + "-" + day ;
				return s;
			}
		</script>			
				</td>
			</tr>
		</table>
		<br>
		
		<input type="submit" value="修正"><input type="button" value="戻る" onClick="history.back()" class="ppp">
	</form>

</body>
</html>