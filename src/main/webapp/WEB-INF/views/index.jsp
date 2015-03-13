<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Homepage</title>
</head>
<body>
    <h1>Hibernate 4 Example - Homepage</h1>
    <p>This is a good Homepage for the Hibernate 4 example.</p>

    <p>
        To see all <a href='<c:url value="/suppliers"/>'>suppliers</a>.
    </p>
    <p>
        To see vendor <a href='<c:url value="/supplier/10"/>'>10</a>.
    </p>
</body>
</html>