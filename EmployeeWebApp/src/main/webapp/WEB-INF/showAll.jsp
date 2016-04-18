<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Employee Details</title>
<%@ include file="header-in.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/JavaScript" src="${jsRoot}/jquery.min.js"></script>
	<script type="text/Javascript" src="${jsRoot}/common.js"></script>
	<link rel="stylesheet" href="${cssRoot}/style.css" />
</head>
	<body>
        <form:form method="post" name="showAllFlow" commandName="employee">
		    
		    <%@ include file="Header_top.jsp" %>
		    
			<table border="1" cellspacing="2" cellpadding="2" align="center" id="showAllTable">
				<thead bgcolor="yellow">
					<tr> <td>SELECTION </td>
					<td> ID </td>
					<td> FirstName </td>
					<td> LastName </td>
					<td> Address </td>
					<td> LoggedInUserID </td>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="emp" items="${empList}" varStatus="i">
				<tr class="row${i.index}" id="row${i.index}">
					<td align="center">
						<input type="radio" name="select" value="${emp.selected}" />
					</td>
					<td class="data">
						${emp.ID}
					</td>
					<td class="data">
						${emp.firstName}
					</td>
					<td class="data">
						${emp.lastName}
					</td>
					<td class="data">
						${emp.address}
					</td>
					<td class="data">
						${emp.loggedInUserCaasId}
					</td>
				</tr>
				</c:forEach>
				<tr>
					<td  colspan="3" align="center">
						<button id="updateButton">Update</button>
					</td>
					<td align="center">
						<button id="deleteButton">Delete</button>
					</td>
					<td colspan="2" align="center">
						<button id="homeButton">Go To Home</button>
					</td>
				</tr>
				</tbody>
			</table>
			<input type="hidden" name="operation" id="operation" value=" " />
		</form:form>
</body>
</html>
