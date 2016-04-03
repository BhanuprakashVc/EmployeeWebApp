<html>
<head>
<%@ include file="/includes/header-in.jspf"%>
<script type="text/JavaScript" src="${jsRoot}/jquery.min.js"></script>
<script type="text/Javascript" src="${jsRoot}/common.js"></script>
<link rel="stylesheet" href="${cssRoot}/style.css" />
</head>
<body>
	<%@ include file="Header_top.jsp" %>
	<h2 align="center">Create Employee Information using below form</h2>
	<form:form method="post" name="createEmp" commandName="emp">
		<table name="employeeTable" align="center" border="2" cellspacing="2" cellpadding="2">
			<tr>
				<td>FirstName:</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>LastName:</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input path="Address" /></td>
			</tr>
			<tr>
				<td>ID:</td>
				<td><form:input path="ID" /></td>
			</tr>
			<tr>
				<td><form:button onclick="submitCreateEmp()">Submit</form:button>
				<td><form:button onclick="cancelCreateEmp()">Cancel</form:button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
