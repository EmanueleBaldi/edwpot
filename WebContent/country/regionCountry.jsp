<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Countries</title>
</head>
<body>
	<p>
        Back to <a href="http://localhost:8082/edwpot/country.html">home</a>
    </p>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
        </tr>
        <c:forEach var="country" items="${countries}">
            <tr>
                <td>${country.id}</td>
                <td>${country.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>