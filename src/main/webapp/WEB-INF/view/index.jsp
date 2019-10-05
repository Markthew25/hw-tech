<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>Home</title>
	<security:authentication property="principal" />
</head>
<body>
<h2>HWTech Home Page</h2>
	
	<p>
		Welcome to HWTech Website
	</p>
	
	<hr>
	
	<!-- Display username and role -->
	<p>
		User: <security:authentication property="principal.username"/>
		<br>
		Roles(s): <security:authentication property="principal.authorities"/>
	</p>
	
	<hr>
	
	<!-- Add a link to point to /leaders or /admin -->
	<p>
		<a href="${pageContext.request.contextPath }/leaders">Leadership Meeting</a>
		(Only for Managers)
	</p>
	
	<hr>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input  type="submit" value="Logout"/>
	</form:form>

</body>
</html>
