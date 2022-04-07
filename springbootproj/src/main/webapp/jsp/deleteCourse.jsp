<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/ocms/loaddeletecourses" method="post">
		<table>
			<tr>
				<td>Course Id</td>
				<td><input type="text" name="courseId"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Delete Course"> </td>
			</tr>
		</table>
	</form>
</body>
</html>