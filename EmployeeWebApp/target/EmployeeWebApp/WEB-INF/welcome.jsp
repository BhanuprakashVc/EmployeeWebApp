<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/includes/header-in.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome page</title>
	<script type="text/JavaScript" src="${jsRoot}/jquery.min.js"></script>
	<script type="text/Javascript" src="${jsRoot}/common.js"></script>
	<link rel="stylesheet" href="${cssRoot}/style.css" />
</head>
	<body>
        <form:form method="post" name="flow" >
	
			<c:out value="${cssRoot}" />
		    
		    <%@ include file="Header_top.jsp" %>
		    
			<table border="1" cellspacing="2" cellpadding="2" align="center">
				<tr>
					<td>
						Welcome to Home Screen of Employee Association. Here user can add new employee details to Database </br>
			 			and update the existing employee details and delete unwanted employees and can search for employee with their Ids.</br>
						This association exists from 1990 and is still continuing.
					</td>
				</tr>
				<tr align="center">
					<td>
						<button id="btn-xps">Add Employee Info</button>
					</td>
				</tr>
				<tr align="center">
					<td>
						<button id="bt-search">Search an Employee Info</button>
					</td>
				</tr>
				<tr align="center">
					<td>
						<button id="bt-update">Update Employee Info</button>
					</td>
					</tr>
				<tr align="center">
					<td>
						<button id="bt-delete">Delete Employee Info</button>
					</td>
					</tr>
				<tr align="center">
					<td>
						<button id="bt-showAll">Show all Employee Info</button>
					</td>
				</tr>
			</table>
			
			<!-- div align="center">
			</br></br><button id="btn-xps">Add Employee Info</button>
			</br></br><button id="bt-search">Search an Employee Info</button>
			</br></br><button id="bt-update">Update Employee Info</button>
			</br></br><button id="bt-delete">Delete Employee Info</button>
			</div -->
			<input type="hidden" id="operation" name="operation" value="" />
		</form:form>
</body>
</html>