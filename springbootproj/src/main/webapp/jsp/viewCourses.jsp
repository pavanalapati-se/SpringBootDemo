<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Courses</h1>

	<hr />

	<table border="1">
		<tr>
			<th>Course Id</th>
			<th>Course Name</th>
			<th>Course Duration</th>
		</tr>
		<core:forEach items="${courses}" var="course">
			<tr>
				<td>${course.courseId}</td>
				<td>${course.courseName}</td>
				<td>${course.courseDuration}</td>
				<td><a href="/loadeditcourse">Edit Course</a></td>
				<td><a href="/loaddeletecourse">Delete Course</a></td>
			</tr>

		</core:forEach>

	</table>

	<span><a href="/ocms/loadaddcoursepage">Click Here to Add New Course</a></span>

</body>
</html>