<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Add Item</title>
	<link href="<c:url value="/resources/css/add-style.css" />" rel="stylesheet"/>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>HW Tech</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add new employee</h3>
		
		<form:form action="save-employee" modelAttribute="employee" method="POST">
		
			<!-- when updating: need to associate this data with employee id -->
			<!-- this line is very important, without this, you'll lose context or lose the actual id of original employee -->
			<!-- it simply call the .getEmpID and place it here in hidden form field 
				and when we do a submit, it will submit data by calling setEmpID with the appropriate data
			-->
			<form:hidden path="empID" />
					
			
			<i>Fill out the form. Asterisk (*) means required.</i>
		
			<table>
				<tbody>
				
					<tr>
						<td><label>First Name (*) :</label></td>
						<td>
							<form:input path="empFName"/>
							<!-- Set up form:error to hold error , in our case is null fields -->
							<form:errors path="empFName" Class="error"/>
						</td>
					</tr>
					<tr>
						<td><label>Middle Name:</label></td>
						<td><form:input path="empMName"/></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="empLName"/></td>
					</tr>
					<tr>
						<td><form:label path="deptID">Department:</form:label></td>
						<td>
							
							<form:select path = "deptID" >
								<form:option value = "-1" label = "--Please Select"/>
								<c:forEach var="tempDept" items="${departments }">
									<form:option value="${tempDept.deptID }"  label="${tempDept.deptName }"/>
			                	</c:forEach>
			                </form:select>
		               
						</td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear;both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/employee/list" >Back to List</a>
		</p>
		
	</div>

</body>
</html>