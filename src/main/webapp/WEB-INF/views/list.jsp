<%@page import="java.util.List"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {
	text-align: center; margin: auto;
	}
	table {
	width: 500px; margin: auto; text-align: center;
	}
	table, th, td{
		border: 3px solid skyblue;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<div>
		<h1 style="text-align: center">방명록</h1>
		<hr>
		<p style="text-align: center">
			[<a href="write.do">방명록쓰기</a>]
		</p>
		<form method="post">
			<table>
				<thead style="background-color: #99ccff">
					<tr>
						<th style="width: 10%">번호</th>
						<th style="width: 20%">작성자</th>
						<th style="width: 40%">제목</th>
						<th style="width: 30%">작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty list}">
							<tr>
								<td colspan="4"><h2>원하는 정보가 존재하지 않습니다</h2></td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="k" items="${list}" varStatus="vs">
								<tr>
									<td>${vs.count}</td>
									<td>${k.name }</td>
									<td><a href="onelist.do?idx=${k.idx}">${k.title}</a></td>
									<td>${k.reg.substring(0,10)}</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>