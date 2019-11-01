<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<jsp:include page="header.jsp"/>

	<div id="wrapper">
	
		<div id="header">
		
			<h2>HW ITEM LIST</h2>
			
		</div>
		
		<div id="container">
			
			<div id="content">
			
			<form:form action="save-asset" modelAttribute="employee" method="GET">

				<form:hidden path="empID" />

				<!-- add our html table here -->
				
				<table class="table table-sm table-striped table-bordered table-hover">			
					<thead class="thead-dark">
						<tr>			
							<th>Item name</th>
							<th>Item Status</th>
							<th>Item Quantity</th>
							<th>Action</th>
						 </tr>
					 </thead>
					 
						<!-- Loop through items -->
						<c:forEach var="tempItem" items="${itemsAvail }">

							<c:url var="addAssetLink" value="/employee/add-asset">
								<c:param name="empID" value="${employee.empID }" />
								<c:param name="itemID" value="${tempItem.itemID }" />
							</c:url>
							
							<tr>
							
								<td>${tempItem.itemName }</td>
								<td>${tempItem.itemStatus }</td>
								<td>${tempItem.itemQty }</td>
								
								<td>
									<!-- display the update link -->
									<a href="${addAssetLink }" onclick="if(!(confirm('Are you sure you want to add this item to ${employee.empFName} ${employee.empLName}?'))) return false">Add</a>
									<input type="submit" value="Add Asset" class="save"/>
								</td>
							
							</tr>
							
						</c:forEach>

				</table>
				
				</form:form>
				
			</div>
		
		</div>
		
	
	</div>

<jsp:include page="footer.jsp"/>