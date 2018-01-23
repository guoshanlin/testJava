<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.myclass.bean.Students"%>
<%@page import="com.myclass.bean.StudentsSearch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>这是一个测试页面</h2>
	<%
	     List<Students> student =new StudentsSearch().finStudents();
		 pageContext.setAttribute("student", student);
   %>
	<div>
		<table border="1" width="100%">
			<thead>
				<tr>
					<td width="15%">姓名</td>
					<td width="15%">年龄</td>
					<td width="35%">编号</td>
					<td width="35%">id</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="stu" items="${student}">
					<tr>
						<td>${stu.names}</td>
						<td>${stu.age}</td>
						<td>${stu.id}</td>
						<td>${stu.rowId}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>