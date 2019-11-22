<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function() {
		$("#delete").click(function() {
			if (confirm("삭제하시겠습니까?") != true){
			    return false;
			}
		})
	})
</script>
<style>
	div{
		width: 500px;
		margin: 30px auto;
		text-align: center;
	}
	table{
		width: 100%;
	}
	table, th, td{
		border: 1px solid black;
		border-collapse: collapse;
		padding: 10px;
		text-align: center;
		margin: 0 auto;
	}
	a{
		text-decoration: none;
		color: black;
	}
	p{
		overflow: hidden;
	}
	p>a{
		background: #ccc;
		color: #fff;
		border: 1px solid #ccc;
		padding: 0px 5px;
		margin: 0px 5px;
		font-size: 14px;
		float: left;
	}
	a:hover {
		font-weight: bold;
	}
</style>
</head>
<body>
	<div>
		<h1>상세 내용</h1>
		<table>
			<tr>
				<th>프로젝트 이름</th>
				<td>${spms.name}</td>
			</tr>
			<tr>
				<th>프로젝트 내용</th>
				<td>${spms.content}</td>
			</tr>
			<tr>
				<th>시작 날짜</th>
				<fmt:formatDate var="startdate" value="${spms.startdate}" pattern="yyyy-MM-dd"/>
				<td>${startdate}</td>
			</tr>
			<tr>
				<th>종료 날짜</th>
				<fmt:formatDate var="enddate" value="${spms.enddate}" pattern="yyyy-MM-dd"/>
				<td>${enddate}</td>
			<tr>
				<th>상태</th>
				<td>${spms.progress}</td>
			</tr>
		</table>
		<p>
			<a href="update.do?no=${spms.no}">수정</a>
			<a href="delete.do?no=${spms.no}" id="delete">삭제</a>
			<a href="list.do">돌아가기</a>
		</p>
	</div>
</body>
</html>