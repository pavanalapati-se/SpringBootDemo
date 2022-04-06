<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.labeltext {
	font-weight: bold;
	color: blue;
}
</style>
</head>
<body>

	<h3>View Course</h3>
	<hr />

	<table border="1">
		<tr>
			<td class="labeltext">Course Id</td>
			<td>${course.courseId}</td>
		</tr>
		<tr>
			<td class="labeltext">Course Name</td>
			<td>${course.courseName}</td>
		</tr>
		<tr>
			<td class="labeltext">Course Duration</td>
			<td>${course.courseDuration}</td>
		</tr>
	</table>
</body>
</html>