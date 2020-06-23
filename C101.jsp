<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員メニュー</title>
</head>
<body>
<a href="/jmaster2/Top.html">トップメニュー</a><br>
	会員情報
	<form action="/library2/MemberServlet" method="get">
			<input type="hidden" name="code" value="${memberPH.code}">
		<table>
			<tr align="justify">
				<th>会員ID&nbsp;&nbsp;&nbsp;&nbsp;：</th><th>${memberPH.code}</th>
			</tr>
			<tr align="justify">
				<th>氏名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</th><th><input type="text" name="name" placeholder="${memberPH.name}" value="${member.name}"></th>
			</tr>
			<tr align="justify">
				<th>郵便番号&nbsp;&nbsp;：</th><th><input type="text" name="postal" placeholder="${memberPH.postal}" value="${member.postal}"></th>
			</tr>
			<tr align="justify">
				<th>住所&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</th><th><input type="text" name="address" placeholder="${memberPH.address}" value="${member.address}"></th>
			</tr>
			<tr align="justify">
				<th>電話番号&nbsp;&nbsp;：</th><th><input type="text" name="tel" placeholder="${memberPH.tel}" value="${member.tel}"></th>
			</tr>
			<tr align="justify">
				<th>E-Mail&nbsp;&nbsp;&nbsp;&nbsp;：</th><th><input type="text" name="email" placeholder="${memberPH.email}" value="${member.email}"></th>
			</tr>
			<tr align="justify">
				<th>生年月日&nbsp;&nbsp;：</th><th><input type="text" name="birthday" placeholder="${memberPH.birthday}" value="${member.birthday}"></th>
			</tr>
			<tr align="justify">
				<th>入会年月日：</th><th><input type="text" name="joinDate" placeholder="${memberPH.joinDate}" value="${member.joinDate}"></th>
			</tr>
			<tr align="justify">
				<th>退会年月日：</th><th>${memberPH.quitDate}</th>
			</tr>
		</table>
		<%

		 %>
		<c:if test="${empty memberPH.code}">
			<c:set var="disableUpdate">disabled</c:set>
			<c:set var="disableWithdraw">disabled</c:set>
		</c:if>
		<c:if test="${not empty memberPH.code}">
			<c:set var="disableRegist">disabled</c:set>
		</c:if>		<c:if test="${not empty memberPH.quitDate}">
			<c:set var="disableRegist">disabled</c:set>
			<c:set var="disableUpdate">disabled</c:set>
			<c:set var="disableWithdraw">disabled</c:set>
		</c:if>
		<button type="submit" name="action" value="regist" ${disableRegist}>登録</button>
		<button type="submit" name="action" value="update" ${disableUpdate}>変更</button>
		<button type="submit" name="action" value="withdraw" ${disableWithdraw}>退会</button>
	</form>

	<hr>
	貸出情報
	<form action="/library2/XXXXXXServlet" method="get">
	    <table border="1">
	    <tr>
	    	<td>資料ID</td><td>貸出年月日</td><td>貸出期日</td><td>返却</td>
	    </tr>
	    <tr>
	      	<td><input type="text"></td><td>99999999</td><td>99999999</td><td><input type="checkbox"></td>
	    </tr>
	    <tr>
	      	<td><input type="text"></td><td>99999999</td><td>99999999</td><td><input type="checkbox"></td>
	    </tr>
	    <tr>
	      	<td><input type="text"></td><td>99999999</td><td>99999999</td><td><input type="checkbox"></td>
	    </tr>
	    <tr>
	      	<td><input type="text"></td><td>99999999</td><td>99999999</td><td><input type="checkbox"></td>
	    </tr>
	    <tr>
	      	<td><input type="text"></td><td>99999999</td><td>99999999</td><td><input type="checkbox"></td>
	    </tr>
	    </table>
	</form>
	<br>
	<br>
	<hr>
	<input type="submit" value="貸出" >
	<input type="submit" value="返却" >

</body>
</html>