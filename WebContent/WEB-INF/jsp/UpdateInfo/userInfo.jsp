<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="shop.css">
<title>会員情報確認</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>
	<h3>●会員情報</h3>
	<form action="changeForm.html" method="post">
		<table border="1">
			<tr>
				<th class="form">会員NO</th>
				<td>
					<c:out value="${userInfo.memNum}"/>
					<input type="hidden" value="${userInfo.memNum}" name="memNum" />					
				</td>
			</tr>
			<tr>
				<th class="form">氏名</th>
				<td>
					<c:out value="${userInfo.name}"/>
					<input type="hidden" value="${userInfo.name}" name="name" />				
				</td>
			</tr>
			<tr>
				<th class="form">年齢</th>
				<td>
					<c:out value="${userInfo.age}"/>
					<input type="hidden" value="${userInfo.age}" name="age" />				
				</td>
			</tr>
			<tr>
				<th class="form">性別</th>
				<td>
					<c:out value="${userInfo.sex}"/>
					<input type="hidden" value="${userInfo.sex}" name="sex" />				
				</td>
			</tr>
			<tr>
				<th class="form">郵便番号</th>
				<td>
					<c:out value="${userInfo.postCode}"/>
					<input type="hidden" value="${userInfo.postCode}" name="postCode" />				
				</td>
			</tr>
			<tr>
				<th class="form">住所</th>
				<td>
					<c:out value="${userInfo.address}"/>
					<input type="hidden" value="${userInfo.address}" name="address" />				
				</td>
			</tr>
			<tr>
				<th class="form">電話番号</th>
				<td>
					<c:out value="${userInfo.phoneNum}"/>
					<input type="hidden" value="${userInfo.phoneNum}" name="phoneNum" />				
				</td>
			</tr>
			<tr>
				<th class="form">登録日</th>
				<td>
					<c:out value="${userInfo.updateTime}"/>
					<input type="hidden" value="${userInfo.updateTime}" name="updateTime" />				
				</td>
			</tr>
		</table>
		<br>
		
		<input type="submit" value="修正">  <input type="button" value="戻る" onClick="history.back()" class="ppp">
	</form><br>
	<form action="fireConf.html" method="post">
		<input type="hidden" value="${userInfo.memNum}" name="memNum" />	
		<input type="submit" value="削除">
	</form><br>
	<form action="menu.html">
			<input type="submit" value="メニューへ">
	</form>
</body>
</html>