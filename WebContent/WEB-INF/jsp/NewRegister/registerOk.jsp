<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録完了</title>
</head>
<body>
		<jsp:include page="/header.jsp"/>
<div class="ppp">
	<p>会員登録が完了しました。</p>
	<p>あなたの会員番号は</p>	
			<div>
				<span><c:out value="${regInfo}" /></span>
			</div><br>
		<form action="menu.html">
			<input type="submit" value="メニューへ">
		</form>
	</div>
</body>
</html>