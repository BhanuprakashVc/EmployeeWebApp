<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Employee Details</title>
<%@ include file="/includes/header-in.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/JavaScript" src="${jsRoot}/jquery.min.js"></script>
	<script type="text/Javascript" src="${jsRoot}/common.js"></script>
	<link rel="stylesheet" href="${cssRoot}/style.css" />
</head>
	<body>
        <form:form method="post" name="flow" >
		    
		    <%@ include file="Header_top.jsp" %>
		    
			<table border="1" cellspacing="2" cellpadding="2" align="center">
				<thead>
					<tr><td> ID </td>
					<td> FirstName </td>
					<td> LastName </td>
					<td> Address </td>
					<td> LoggedInUserID </td></tr>
				</thead>
				<c:forEach var="emp" items="${empList}" varStatus="i">
				<tbody>
				<tr>
					<td>
						${emp.ID}
					</td>
					<td>
						${emp.firstName}
					</td>
					<td>
						${emp.lastName}
					</td>
					<td>
						${emp.address}
					</td>
					<td>
						${emp.loggedInUserCaasId}
					</td>
				</tr>
				</tbody>
				</c:forEach>
			</table>
		</form:form>
</body>
</html>