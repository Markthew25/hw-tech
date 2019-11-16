<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html SYSTEM "about:legacy-compat">
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
	
	<title>Item form</title>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="<c:url value="/resources/css/add-style.css" />" rel="stylesheet"/>
	
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#dbpicker").datepicker();
        });

        $(function () {
            $("#dwpicker").datepicker();
        });
        
        $(document).ready(function () {
            $('#serial').keyup(function (event) {
                addHyphen (this);
            });
        });

        function addHyphen (element) {
            let val = $(element).val().split('-').join('');   // Remove dash (-) if mistakenly entered.

            let finalVal = val.match(/.{1,5}/g).join('-');    // Add (-) after 3rd every char.
            $(element).val(finalVal);		// Update the input box.
        }
         
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
			<h2>Add new item</h2>
		</div>
	</div>	
	
	<div id="container" class="add-form">	
		<form:form action="save-item-peripheral" modelAttribute="item" method="POST">
		
			<!-- when updating: need to associate this data with item id -->
			<!-- this line is very important, without this, you'll lose context or lose the actual id of original item -->
			<!-- it simply call the .getItemID and place it here in hidden form field 
				and when we do a submit, it will submit data by calling setItemID with the appropriate data
			-->
			<form:hidden path="itemID" />
			
			<i>Fill out the form. Asterisk (*) means required.</i>
			<hr>
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
							<form:select path = "catID">
								<form:option value = "-1" label = "--Please Select"/>
								<c:forEach var="tempCats" items="${categories }">
									<form:option value="${tempCats.catID }"  label="${tempCats.catName }"/>
			                	</c:forEach>
			                </form:select>
						</td>
					</tr>
					<tr>
						<td><form:label path="brandID">Brand:</form:label></td>
						<td>
							<form:select path = "brandID" >
								<form:option value = "-1" label = "--Please Select"/>
								<c:forEach var="tempBrands" items="${brands }">
									<form:option value="${tempBrands.brandID }"  label="${tempBrands.brandName }"/>
			                	</c:forEach>
			                </form:select>
						</td>
					</tr>
					<tr>
						<td><form:label path="suppID">Supplier:</form:label></td>
						<td>
							<form:select path = "suppID" >
								<form:option value = "-1" label = "--Select Select"/>
								<c:forEach var="tempSupps" items="${suppliers }">
									<form:option value="${tempSupps.suppID }"  label="${tempSupps.suppName }"/>
			                	</c:forEach>
			                </form:select>
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
	
<hr>
<footer><i>Copyright @ Mark Morales</i></footer>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>