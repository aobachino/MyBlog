<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="shop.css">
<title>商品検索</title>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<h3>●商品検索</h3>
	<form action="/serch">

		<table border="1" class="ppp">

			<tr>
				<th class="form">カテゴリ</th>
				<td><input type="text" name="goodsPart"></td>
			</tr>
			<tr>
				<th class="form">商品名</th>
				<td><input type="text" name="goodsName"></td>
			</tr>
			<tr>
				<th class="form">販売元</th>
				<td><input type="text" name="meker"></td>
			</tr>
			<tr>
				<th class="form">金額上限</th>
				<td><input type="text" name="maxPrice"></td>
			</tr>
			<tr>
				<th class="form">金額下限</th>
				<td><input type="text" name="minPrice"></td>
			</tr>
		</table>
		<div class="ppp">
			<input type="submit" value="検索"> <input type="button"
				value="戻る" onClick="history.back()"> <input type="reset"
				value="クリア">
		</div>
	</form>
	<hr>

	<h3>●商品一覧</h3>

	<c:out value="${gdZero}" />
	<table>
		<tr>
			<th>選択</th>
			<th>商品コード</th>
			<th>商品名</th>
			<th>販売元</th>
			<th>金額(単価)</th>
			<th>メモ</th>
			<th>購入数</th>
		</tr>
		<c:forEach var="gd" items="${gdInfo.gdList}">
			<tr>
				<td><input type="checkbox" name="selectProduct"></td>
				<td><c:out value="${gd.goodsName}" /></td>
				<td><c:out value="${gd.maker}" /></td>
				<td><c:out value="${gd.price}" /></td>
				<td><c:out value="${gd.memo}" /></td>
				<td><input type="text" name="gdCnt"></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>