<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Supplier Listing</title>
<style>
table {
	border-collapse: collapse;
}

td,th {
	border: 1px solid black;
}

th {
	background: lightgrey;
}
</style>
</head>
<body>
    <h1>All Supplier</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Details</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="supplier" items="${suppliers}">
                <tr>
                    <td>${supplier.id}</td>
                    <td>${supplier.name}</td>
                    <td><a href='<c:url value="/supplier/${supplier.id}"/>'>details</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>