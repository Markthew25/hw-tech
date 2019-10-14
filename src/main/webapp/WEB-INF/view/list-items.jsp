<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item List</title>
</head>
<body>

	<div id="wrapper">
	
		<div id="header">
		
			<h2>HW ITEM LIST</h2>
			
		</div>
		
		<div id="container">
			
			<div id="content">
			
				<!-- add our html table here -->
				
				<table>
				
					<tr>
					
						<th>Item name</th>
						<th>Item Status</th>
						<th>Item Quantity</th>
						
					 </tr>
					
					<c:forEach var="tempItem" items="${items }">
						
						<tr>
						
							<td>${tempItem.itemName }</td>
							<td>${tempItem.itemStatus }</td>
							<td>${tempItem.itemQty }</td>
						
						</tr>
						
					</c:forEach>
					
				</table>
				
			</div>
		
		</div>
		
	
	</div>

</body>
</html>