<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="exercise">
		<form:input path="minutes"/>
		<input type="submit" value="Submit">
	</form:form>
	
	<h2>Our goal for the day is:${goal.minutes}</h2>
</body>
</html>
	