<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<jsp:include page="header.jsp"/>



<div id="wrapper">
	
		<div id="header">
		
			<h2>HW EMPLOYEE LIST</h2>
			
		</div>
		
		<div id="container">
			
			<form:form action="add-asset" modelAttribute="employee" method="POST">
			
			<form:hidden path="empID" />
			
			<form:label path="">Employee Name: ${employee.empFName} ${employee.empLName} </form:label>
					
			<div id="content">
			
				<input type="submit" value="Add Employee"
						onclick="window.location.href='add-employee'; return false;"
						class="btn btn-primary add-button"/>
			
				<!-- add our html table here -->
				
				<table class="table table-sm table-striped table-bordered table-hover">
					<thead class="thead-dark">
						<tr>
						
							<th>Item Name</th>
							<th>Action</th>
							
						</tr>
					</thead>
					
					<!-- Loop through items -->
					<c:forEach var="tempAssets" items="${empAssets }">
						
						<tr>
						
							<td>${tempAssets.itemName }</td>
							
							<td>
								<!-- display the update link -->
								<a href="${removeAssetLink }" onclick="if(!(confirm('Are you sure you want to delete this item?'))) return false">Remove</a>
							</td>
						
						</tr>
						
					</c:forEach>
					
				</table>
				
			</div>
			</form:form>
		</div>
		
		
	
	</div>


<jsp:include page="footer.jsp"/>