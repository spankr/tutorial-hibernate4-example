<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Supplier Details</title>
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
    <h1>Supplier Details</h1>
    <dl>
        <dt>ID</dt>
        <dd>${supplier.id}</dd>
        <dt>NAME</dt>
        <dd>${supplier.name}</dd>
        <dt>PARENT ID</dt>
        <dd>${supplier.parentId}</dd>
    </dl>

    <h3>Parts Listing</h3>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>MFG Number</th>
                <th>RoHS Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="part" items="${supplier.parts}">
                <tr>
                    <td>${part.id}</td>
                    <td>${part.name}</td>
                    <td>${part.mfgNumber}</td>
                    <td>${part.rohsStatus}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>