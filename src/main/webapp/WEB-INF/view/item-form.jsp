<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<jsp:include page="header.jsp"/>

	<div id="wrapper">
		<div id="header">
			<h2>Add new item</h2>
		</div>
	</div>	
	
	<div id="container" class="add-form">	
		<form:form action="save-item" modelAttribute="item" method="POST">
		
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
							<!-- Set up form:error to hold error , in our case is null fields -->
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
								<form:option value="1">Available</form:option>
								<form:option value="0">Not Available</form:option>
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
						<td>
							<form:input path="itemQty"/>
							<form:errors path="itemQty" Class="error"/>
						</td>
						
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save-button btn btn-success"/>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear;both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/item/list" >Back to List</a>
		</p>
		
	</div>


<jsp:include page="footer.jsp"/>