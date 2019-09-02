<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<sql:query dataSource="jdbc/hr" var="regions">select * from regions</sql:query>
<title>HR Regions</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
        </tr>
        <c:forEach var="cur" items="${regions.rows}">
            <tr>
                <td>${cur.REGION_ID}</td>
                <td>${cur.REGION_NAME}</td>
            </tr>
        </c:forEach>
    </table>
    
    
 <sql:query dataSource="jdbc/hr" var="countries">SELECT c.country_id, c.country_name
												FROM countries c JOIN regions r
												ON (c.region_id=r.region_id)
												WHERE r.region_id=1</sql:query> 
    <table class="table table-dark">
        <tr>
            <th>country_id</th>
            <th>country_name</th>
        </tr>
        <c:forEach var="cursor" items="${countries.rows}">
            <tr>
                <td>${cursor.COUNTRY_ID}</td>
                <td>${cursor.COUNTRY_NAME}</td>
            </tr>
        </c:forEach>
    </table> 
    
</body>
</html>