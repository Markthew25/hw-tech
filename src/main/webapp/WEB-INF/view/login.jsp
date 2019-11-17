<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	<title>Login Form</title>
	
	<style>
		.login-failed{
			color:red;
		}
	</style>

</head>
<body>
	
	<h3>User Login</h3>
	
	<form:form action="${pageContext.request.contextPath}/user-authentication" 
				method="POST">
				
				<!-- Check for login error -->
				
				<c:if test="${param.error != null }">
					<i class="login-failed">Sorry! You have entered wrong username or password.</i>
				</c:if>
				
				<p>
					Username: <input type="text" name="username"/>
				</p>
				
				<p>
					Password: <input type="password" name="password"/>
				</p>
								
				<input type="submit" value="Login"/>
		
	</form:form>

</body>
</html>