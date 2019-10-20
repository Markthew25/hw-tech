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
		<h3>Add new item</h3>
		
		<form:form action="saveItem" modelAttribute="item" method="POST">
			<table>
				<tbody>
					<tr>
						<td><label>Item name:</label></td>
						<td><form:input path="itemName"/>
					</tr>
					<tr>
						<td><label>Category #:</label></td>
						<td><form:input path="catID"/>
					</tr>
					<tr>
						<td><label>Brand #:</label></td>
						<td><form:input path="brandID"/>
					</tr>
					<tr>
						<td><label>Supplier #:</label></td>
						<td><form:input path="suppID"/>
					</tr>
					<tr>
						<td><label>Status:</label></td>
						<td><form:input path="itemStatus"/>
					</tr>
					<tr>
						<td><label>Quantity:</label></td>
						<td><form:input path="itemQty"/>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear;both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/item/list" >Back to List</a>
		</p>
		
	</div>

</body>
</html>