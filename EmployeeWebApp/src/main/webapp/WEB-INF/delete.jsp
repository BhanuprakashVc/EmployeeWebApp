<html>
<head>
<%@ include file="header-in.jspf"%>
<script type="text/JavaScript" src="${jsRoot}/jquery.min.js"></script>
<script type="text/Javascript" src="${jsRoot}/common.js"></script>
<link rel="stylesheet" href="${cssRoot}/style.css" />
</head>
<body>
	<%@ include file="Header_top.jsp" %>
	<h2 align="center">Create Employee Information using below form</h2>
	<form:form method="post" action="${pageContext.request.contextPath}/delete" name="deleteEmp" commandName="emp">
		<table name="employeeTable" align="center" border="2" cellspacing="2" cellpadding="2">
			<tr>
				<td>ID:</td>
				<td><form:input path="ID" readonly="true" /></td>
			</tr>
			<tr>
				<td>FirstName:</td>
				<td><form:input path="firstName" readonly="true" /></td>
			</tr>
			<tr>
				<td>LastName:</td>
				<td><form:input path="lastName" readonly="true" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input path="Address" readonly="true" /></td>
			</tr>
			<tr>
				<td>LoggedInUserID:</td>
				<td><form:input path="loggedInUserCaasId" readonly="true"  /></td>
			</tr>
			<tr>
				<td><form:button onclick="submitDeleteEmp()">Submit</form:button>
				<td><form:button onclick="cancelDeleteEmp()">Cancel</form:button></td>
			</tr>
		</table>
		<input type="hidden" id="operation" name="operation" value=" " />
	</form:form>
</body>
</html>
