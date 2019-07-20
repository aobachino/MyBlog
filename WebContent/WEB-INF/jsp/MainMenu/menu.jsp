<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="shop.css">
<title>メインメニュー</title>
</head>
<body>
		<jsp:include page="/header.jsp"/>
<div class="ppp">
	<h1>ユーザーメニュー</h1>
	<a href="/ONLINEKadai1/loginForm.html">ログイン</a><br>
	<a href="/ONLINEKadai1/newRegisterForm.html">新規会員登録</a><br>
	<a href="/ONLINEKadai1/userInfo.html">会員情報修正・削除</a><br>
	<a href="/ONLINEKadai1/product.html">商品検索</a><br>
	<a href="">お買い物かご</a><br>
	<a href="/ONLINEKadai1/logout.html">ログアウト</a><br>
</div>
</body>
</html>