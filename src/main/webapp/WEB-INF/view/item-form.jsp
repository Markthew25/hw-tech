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
		
			<!-- when updating: need to associate this data with item id -->
			<!-- this line is very important, without this, you'll lose context or lose the actual id of original item -->
			<!-- it simply call the .getItemID and place it here in hidden form field 
				and when we do a submit, it will submit data by calling setItemID with the appropriate data
			-->
			<form:hidden path="itemID" />
			
			<i>Fill out the form. Asterisk (*) means required.</i>
		
			<table>
				<tbody>
				
					<tr>
						<td><label>Item name (*) :</label></td>
						<td>
							<form:input path="itemName"/>
							<form:errors path="itemName" Class="error"/>
						</td>
					</tr>
					<tr>
						<td><label>Brand #:</label></td>
						<td><form:input path="brandID"/></td>
					</tr>
					<tr>
						<td><label>Supplier #:</label></td>
						<td><form:input path="suppID"/></td>
					</tr>
					<tr>
						<td><label>Status:</label></td>
						<td>
							<form:select path="itemStatus">
								<form:option value="" label="--Please Select"/>
								<form:option value="Okay">Available</form:option>
								<form:option value="Not Okay">Not Available</form:option>
							</form:select>
						</td>
					</tr>
					<tr>
						<td><form:label path="catID">Category:</form:label></td>
						<td>
							
								<form:select path = "catID" >
									<form:option value = "-1" label = "--Please Select"/>
									<c:forEach var="tempCats" items="${category }">
										<form:option value="${tempCats.catID }"  label="${tempCats.catName }"/>
				                	</c:forEach>
				                </form:select>
			               
						</td>
					</tr>
					<tr>
						<td><label>Quantity:</label></td>
						<td><form:input path="itemQty"/></td>
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