<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
	font-weight: bold;
	font-style: italic;
}
</style>
</head>
<body>
	<h2>Add Course Page</h2>
	<hr />
	<form:form action="/ocms/addcourse" method="post"
		modelAttribute="courseDto">
		<table>
			<tr>
				<td>Course Id</td>
				<td><form:input path="courseId" /></td>

			</tr>
			<tr>
				<td>Course Name</td>
				<td><form:input path="courseName" /></td>
				<td><form:errors path="courseName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Course Duration</td>
				<td><form:input path="courseDuration" /></td>
				<td><form:errors path="courseDuration" cssClass="error"></form:errors></td>
			</tr>

			<tr>
				<td>
					<table>
						<tr>
							<th>Assignment Id</th>
							<th>Assignment Name</th>
						</tr>
						<tr>
							<td><form:input path="assignments[0].assignmentId" /></td>
							<td><form:textarea path="assignments[0].assignmentDescription" /></td>
						</tr>
						<tr>
							<td><form:input path="assignments[1].assignmentId"  /></td>
							<td><form:textarea path="assignments[1].assignmentDescription" /></td>
						</tr>
						<tr>
							<td><form:input path="assignments[2].assignmentId"  /></td>
							<td><form:textarea path="assignments[2].assignmentDescription" /></td>
						</tr>
					</table>
				</td>
			</tr>


			<tr>
				<td><input type="submit" value="Add Course"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>