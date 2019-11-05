<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<%
String pageTitle = "Employee list";
%>
<jsp:include page="header.jsp">
<jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>

	<div id="wrapper">
	
		<div id="header">
		
			<h2>HW EMPLOYEE LIST</h2>
			
		</div>
		
		<div id="container">
			
			<div id="content">
			
				<input type="submit" value="Add Employee"
						onclick="window.location.href='add-employee'; return false;"
						class="btn btn-primary add-button"/>
			
				<!-- add our html table here -->
				
				<table class="table table-sm table-striped table-bordered table-hover">
					<thead class="thead-dark">
						<tr>
						
							<th>First Name</th>
							<th>Middle Name</th>
							<th>Last Name</th>
							<th>Action</th>
							
						</tr>
					</thead>
					
					<!-- Loop through items -->
					<c:forEach var="tempEmp" items="${employees }">
						
						<!--  construct an update link with item id 
							so while looping through items, we can get item id.
						-->
						<c:url var="updateLink" value="/employee/update-employee">
							<c:param name="empID" value="${tempEmp.empID }" />
						</c:url>
						
						<!-- Construct dele link with item id -->
						<c:url var="deleteLink" value="/employee/delete">
							<c:param name="empID" value="${tempEmp.empID }" />
						</c:url>
						
						<c:url var="assetsLink" value="/employee/assets">
							<c:param name="empID" value="${tempEmp.empID }" />
						</c:url>
						
						<tr>
						
							<td>${tempEmp.empFName }</td>
							<td>${tempEmp.empMName }</td>
							<td>${tempEmp.empLName }</td>
							
							<td>
								<!-- display the update link -->
								<a href="${updateLink }">Update</a> 
								| <a href="${deleteLink }" onclick="if(!(confirm('Are you sure you want to delete this item?'))) return false">Delete</a>
								| <a href="${assetsLink }">Assets</a> 
							</td>
						
						</tr>
						
					</c:forEach>
					
				</table>
				
			</div>
		
		</div>
		
	
	</div>

<jsp:include page="footer.jsp"/>