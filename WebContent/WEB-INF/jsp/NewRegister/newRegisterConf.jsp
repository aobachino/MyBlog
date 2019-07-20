<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="shop.css">
<meta charset="UTF-8">
<title>会員登録</title>
</head>

<body>
		<jsp:include page="/header.jsp"/>
	<form action="register.html" method="post" >
		<table border="1" class="ppp">
			<tr>
				<th class="form">氏名</th>
				<td>
					<c:out value="${newRegisterForm.name}"/>
					<input type="hidden" value="${newRegisterForm.name}" name="name" />
				</td>			
			</tr>
			<tr>
				<th class="form">パスワード</th>
				<td>
					<c:out value="${newRegisterForm.pass}"/>
					<input type="hidden" value="${newRegisterForm.pass}" name="pass" />
				</td>			
			</tr>
			<tr>
				<th class="form">年齢</th>
				<td>
					<c:out value="${newRegisterForm.age}"/>
					<input type="hidden" value="${newRegisterForm.age}" name="age" />
				</td>			
			</tr>
			<tr>
				<th class="form">性別</th>
				<td>
					<c:out value="${newRegisterForm.sex}"/>
					<input type="hidden" value="${newRegisterForm.sex}" name="sex" />
				</td>			
			</tr>
			<tr>
				<th class="form">郵便番号</th>
				<td>
					<c:out value="${newRegisterForm.postCode}"/>
					<input type="hidden" value="${newRegisterForm.postCode}" name="postCode" />
				</td>			
			</tr>
			<tr>
				<th class="form">住所</th>
				<td>
					<c:out value="${newRegisterForm.address}"/>
					<input type="hidden" value="${newRegisterForm.address}" name="address" />
				</td>			
			</tr>
			<tr>
				<th class="form">電話番号</th>
				<td>
					<c:out value="${newRegisterForm.phoneNum}"/>
					<input type="hidden" value="${newRegisterForm.phoneNum}" name="phoneNum" />
				</td>			
			</tr>
		</table>
		<div class="ppp">
		<input type="submit" value="登録" class="ppp">	
		<input type="button" value="戻る" onClick="history.back()" class="ppp">
		</div>
	</form>
</body>
</html>