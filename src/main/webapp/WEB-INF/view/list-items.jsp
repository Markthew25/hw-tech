<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<%
String pageTitle = "Item list";
%>
<jsp:include page="header.jsp">
<jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>

	<div id="wrapper">
	
		<div id="header">
		
			<h2>HW ITEM LIST</h2>
			
		</div>
		
		<div id="container">
			
			<div id="content">
			
				<input type="submit" value="Add OS"
						onclick="window.location.href='add-os'; return false;"
						class="btn btn-primary add-button"/>
				<input type="submit" value="Add Peripheral"
						onclick="window.location.href='add-peripheral'; return false;"
						class="btn btn-primary add-button"/>
			
				<!-- add our html table here -->
				<hr>
				<table class="table table-sm table-striped table-bordered table-hover">			
					<thead class="thead-dark">
						<tr>			
							<th>Item name</th>
							<th>Item Status</th>
							<th>Action</th>
						 </tr>
					 </thead>
					
					<!-- Loop through items -->
					<c:forEach var="tempItem" items="${items }">
						
						<!--  construct an update link with item id 
							so while looping through items, we can get item id.
						-->
						<c:url var="updateLink" value="/item/update-item">
							<c:param name="itemID" value="${tempItem.itemID }" />
						</c:url>
						
						<!-- Construct dele link with item id -->
						<c:url var="deleteLink" value="/item/delete-item">
							<c:param name="itemID" value="${tempItem.itemID }" />
						</c:url>
						
						<tr>
						
							<td>${tempItem.itemName }</td>
							<td>${tempItem.itemStatus }</td>
							
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

<jsp:include page="footer.jsp"/>