<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Student Information</h2>
      <form:form method = "POST" modelAttribute="login">
         <table>
            <tr>
               <td><form:label path = "id">id</form:label></td>
               <td><form:input path = "id" /></td>
            </tr>
            <tr>
               <td><form:label path = "name">Name</form:label></td>
               <td><form:input path = "name" /></td>
            </tr>
            <tr>
               <td><form:label path = "Rollnum">Rollnum</form:label></td>
               <td><form:input path = "Rollnum" /></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
</body>
</html>