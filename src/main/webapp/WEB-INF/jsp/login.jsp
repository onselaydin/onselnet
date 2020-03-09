<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Custom Login Form</title>
</head>
<body>
<h1> Onselnet login page</h1>
<form action="login" method="post">
	UserName:<input type="text" name="username"/><br/>
	Password:<input type="password" name="password"/><br/>
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
	<input type="submit" value="Login" />
	<font color="red">
		<c:if test="${not empty param.loginFailed }">
			<c:out value="Login failed, Incorrect Username and Password"></c:out>
		</c:if>
	</font>
</form>
</body>
</html>