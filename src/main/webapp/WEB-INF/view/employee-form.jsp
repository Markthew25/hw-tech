
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
    
<!DOCTYPE html SYSTEM "about:legacy-compat">
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Employee form</title>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="<c:url value="/resources/css/add-style.css" />" rel="stylesheet"/>
	
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
    <script>
        $(function () {
            $("#dobpicker").datepicker();
        });
    </script>
    <script>
        $(function () {
            $("#dhpicker").datepicker();
        });
    </script>
	
</head>
<body>
	
	<header>
		<div class="container-fluid p-0">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <a class="navbar-brand" href="#">TECH</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			  <div class="collapse navbar-collapse" id="navbarNavDropdown">
			    <ul class="navbar-nav">
			      <li class="nav-item active">
			        <a class="nav-link" href="${pageContext.request.contextPath }/">Home <span class="sr-only">(current)</span></a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="${pageContext.request.contextPath }/employee/list">Employee</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="${pageContext.request.contextPath }/item/list">Item</a>
			      </li>
			      <li class="nav-item dropdown">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          Dropdown link
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
			          <a class="dropdown-item" href="#">Action</a>
			          <a class="dropdown-item" href="#">Another action</a>
			          <a class="dropdown-item" href="#">Something else here</a>
			        </div>
			      </li>
			    </ul>
			  </div>
			</nav>
		</div>
	
	</header>

	<div id="wrapper">
		<div id="header">
			<h2>HW Tech</h2>
		</div>
	</div>
	
	<div id="container" class="add-form">
		<h3>Add new employee</h3>
		
		<form:form action="save-employee" modelAttribute="employee" method="POST">
		
			<!-- when updating: need to associate this data with employee id -->
			<!-- this line is very important, without this, you'll lose context or lose the actual id of original employee -->
			<!-- it simply call the .getEmpID and place it here in hidden form field 
				and when we do a submit, it will submit data by calling setEmpID with the appropriate data
			-->
			<form:hidden path="empID" />
					
			
			<i>Fill out the form. Asterisk (*) means required.</i>
		
			<table>
				<tbody>
				
					<tr>
						<td><label>First Name (*) :</label></td>
						<td>
							<form:input path="empFName"/>
							<!-- Set up form:error to hold error , in our case is null fields -->
							<form:errors path="empFName" Class="error"/>
						</td>
					</tr>
					<tr>
						<td><label>Middle Name:</label></td>
						<td><form:input path="empMName"/></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="empLName"/></td>
					</tr>
					<tr>
						<td><label>Date of Birth:</label></td>
						<td><form:input path="empDOB" id="dobpicker" /></td>
					</tr>
					<tr>
						<td><label>Date Hired:</label></td>
						<td><form:input path="empDH" id="dhpicker" /></td>
					</tr>
					<tr>
						<td><form:label path="deptID">Department:</form:label></td>
						<td>		
							<form:select path = "deptID" >
								<form:option value = "-1" label = "--Please Select"/>
								<c:forEach var="tempDept" items="${departments }">
									<form:option value="${tempDept.deptID }"  label="${tempDept.deptName }"/>
			                	</c:forEach>
			                </form:select>
						</td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear;both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/employee/list" >Back to List</a>
		</p>
		
	</div>


<jsp:include page="footer.jsp"/>