<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<%
String pageTitle = "Employee assets";
%>
<jsp:include page="header.jsp">
<jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>

<div id="wrapper">
	
		<div id="header">
		
			<h2>HW EMPLOYEE LIST</h2>
			
		</div>
		
		<div id="container">
			
			<form:form modelAttribute="employee" method="POST">
			
			<form:hidden path="empID" />
			
			<c:url var="addAssetLink" value="/employee/add-asset">
				<c:param name="empID" value="${employee.empID }" />
			</c:url>
	
			<form:label path="">Employee Name: ${employee.empFName} ${employee.empLName} </form:label>
					
			<div id="content">
		
			
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
						
						<c:url var="removeAssetLink" value="/employee/remove-asset">
							<c:param name="empID" value="${employee.empID }" />
							<c:param name="itemID" value="${tempAssets.itemID }"></c:param>
						</c:url>
						
						<tr>
						
							<td>${tempAssets.itemName }</td>
							
							<td>
								<!-- display the update link -->
								<a href="${removeAssetLink }" onclick="if(!(confirm('Are you sure you want to remove this item from ${employee.empFName} ${employee.empLName}?'))) return false">Remove</a>
							</td>
						
						</tr>
						
					</c:forEach>
					
				</table>
				
			</div>
			

			</form:form>
			
			<div style="clear;both;"></div>
			
			<p>
				<a class="btn btn-primary add-button" href="${addAssetLink }">Add Asset</a> 
				<a href="${pageContext.request.contextPath}/employee/list" >Back</a>
			</p>
			
		</div>
		
		
	
	</div>


<jsp:include page="footer.jsp"/>