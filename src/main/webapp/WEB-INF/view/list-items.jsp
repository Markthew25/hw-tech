<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>

	<!-- <link type="text/css" rel="stylesheet"
			href="resources/css/style.css" media="screen"/> -->
			
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>

<title>Item List</title>
</head>
<body>

	<div id="wrapper">
	
		<div id="header">
		
			<h2>HW ITEM LIST</h2>
			
		</div>
		
		<div id="container">
			
			<div id="content">
			
				<input type="submit" value="Add Item"
						onclick="window.location.href='showAddItemForm'; return false;"
						class="add-button"/>
			
				<!-- add our html table here -->
				
				<table>
				
					<tr>
					
						<th>Item name</th>
						<th>Item Status</th>
						<th>Item Quantity</th>
						<th>Action</th>
						
					 </tr>
					
					<!-- Loop through items -->
					<c:forEach var="tempItem" items="${items }">
						
						<!--  construct an update link with item id 
							so while looping through items, we can get item id.
						-->
						<c:url var="updateLink" value="/item/showUpdateItemForm">
							<c:param name="itemID" value="${tempItem.itemID }" />
						</c:url>
						
						<!-- Construct dele link with item id -->
						<c:url var="deleteLink" value="/item/delete">
							<c:param name="itemID" value="${tempItem.itemID }" />
						</c:url>
						
						<tr>
						
							<td>${tempItem.itemName }</td>
							<td>${tempItem.itemStatus }</td>
							<td>${tempItem.itemQty }</td>
							
							<td>
								<!-- display the update link -->
								<a href="${updateLink }">Update</a> | <a href="${deleteLink }" onclick="if(!(confirm('Are you sure you want to delete this item?'))) return false">Delete</a>
							</td>
						
						</tr>
						
					</c:forEach>
					
				</table>
				
			</div>
		
		</div>
		
	
	</div>

</body>
</html>