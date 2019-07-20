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

		<jsp:include page="/header.jsp"/>
<form action="conf.html" method="post">

	<table border="1" class="ppp">
		<tr>
			<th class="form">氏名</th>
			<td><input type="text" name="name" id="name">
			<form:errors cssClass="error" path="registerModel.name" /></td>
		</tr>
		<tr>
			<th class="form">パスワード</th>
			<td><input type="password" name="pass" id="pass">
			<form:errors cssClass="error" path="registerModel.pass" /><span
				class="error"> <c:out value="${error}" /></span></td>
		</tr>
		<tr>
			<th class="form">確認用パスワード<br>(確認用)
			</th>
			<td><input type="password" name="confPass" id="confPass">
			<form:errors cssClass="error" path="registerModel.confPass" /> <span
				class="error"><c:out value="${error}" /></span></td>
		</tr>
		<tr>
			<th class="form">年齢</th>
			<td><input type="text" name="age">
			<form:errors cssClass="error" path="registerModel.age" /></td>
		</tr>
		<tr>
			<th class="form">性別</th>
			<td><select name="sex" id="sex">
					<option value="m">男性</option>
					<option value="f">女性</option>
			</select>
			<form:errors cssClass="error" path="registerModel.sex" /></td>
		</tr>
		<tr>
			<th class="form">郵便番号</th>
			<td><input type="text" name="postCode" id="postCode">
			<form:errors cssClass="error" path="registerModel.postCode" /></td>
		</tr>
		<tr>
			<th class="form">住所</th>
			<td><textarea name="address"></textarea>
				<form:errors cssClass="error" path="registerModel.address" /></td>
		</tr>
		<tr>
			<th class="form">電話番号</th>
			<td><input type="text" name="phoneNum" id="phoneNum">
			<form:errors cssClass="error" path="registerModel.phoneNum" /></td>
		</tr>
	</table>
	<div class="ppp">
		<input type="submit" value="確認"> <input type="reset"
			value="クリア">
	</div>
</form>
</body>
</html>