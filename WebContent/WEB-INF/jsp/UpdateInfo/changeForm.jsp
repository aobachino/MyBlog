<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="shop.css">
<title>入力</title>
</head>
<body>
	<jsp:include page="/header.jsp"/>
	<h3>●会員情報の修正</h3>
	<form action="changeDo.html" method="post">
		<table border="1">
			<tr>
				<th class="form">会員NO</th>
				<td>
					<c:out value="${userInfo.memNum}"/>
					<input type="hidden" value="${userInfo.memNum}" name="memNum">
				</td>
			</tr>
			<tr>
				<th class="form">氏名</th>
				<td>
					<input type="text" name="name" value="${userInfo.name}">
					<form:errors cssClass="error" path="changeInfoFormModel.name" />
				</td>
			</tr>
			<tr>
				<th class="form">パスワード</th>
				<td>
					<input type="password" name="pass" value="${userInfo.pass}">
					<form:errors cssClass="error" path="changeInfoFormModel.pass" />
					<span class="error"><c:out value="${error}" /></span>
				</td>
			</tr>
			<tr>
				<th class="form">確認用パスワード</th>
				<td>
					<input type="password" name="confPass">
					<form:errors cssClass="error" path="changeInfoFormModel.confPass" />
					<span class="error"><c:out value="${error}" /></span>
				</td>
			</tr>
			
			<tr>
				<th class="form">年齢</th>
				<td>
					<input type="text" name="age" value="${userInfo.age}">
					<form:errors cssClass="error" path="changeInfoFormModel.age" />
				</td>
			</tr>
			<tr>
				<th class="form">性別</th>
				<td>
					<select name="sex" >
						<option value="m">男性</option>
						<option value="f">女性</option>
					</select>
					<form:errors cssClass="error" path="changeInfoFormModel.sex" />
				</td>
			</tr>
			<tr>
				<th class="form">郵便番号</th>
				<td>
					<input type="text" name="postCode" value="${userInfo.postCode}">
					<form:errors cssClass="error" path="changeInfoFormModel.postCode" />
				</td>
			</tr>
			<tr>
				<th class="form">住所</th>
				<td>
					<textarea name="address" ><c:out value="${userInfo.address}"/></textarea>
					<form:errors cssClass="error" path="changeInfoFormModel.address" />
				</td>
			</tr>
			<tr>
				<th class="form">電話番号</th>
				<td>
					<input type="text" name="phoneNum" value="${userInfo.phoneNum}">
					<form:errors cssClass="error" path="changeInfoFormModel.phoneNum" />
				</td>
			</tr>
			<tr>
				<th class="form">登録日</th>
				<td>
					<c:out value="${userInfo.regTime}"/>
					<input type="hidden" value="${userInfo.regTime}">
				</td>
			</tr>
		</table>
		<br>
		
		<input type="submit" value="修正"><input type="button" value="戻る" onClick="history.back()" class="ppp">
	</form>

</body>
</html>