<html><%@ include file="header-in.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome page</title>
	<script type="text/JavaScript" src="${jsRoot}/jquery.min.js"></script>
	<script type="text/Javascript" src="${jsRoot}/common.js"></script>
	<link rel="stylesheet" href="${cssRoot}/style.css" />
</head>
<body>
<h2>Hello World to Update Screen!</h2>
Hi User, Welcome to Update Screen

	<form:form name="updateForm" method="post" commandName="emp">
	
		<%@ include file="Header_top.jsp" %>
			    
		<table border="1" cellspacing="2" cellpadding="2" align="center">
			<tr>
				<td>FirstName:</td>
				<td><input type="text" name="firstName" value="${emp.firstName}"/></td>
			</tr>
			<tr>
				<td>LastName:</td>
				<td><input type="text" name="lastName" value="${emp.lastName}"/></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="Address" value="${emp.address}"/></td>
			</tr>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="ID" value="${emp.ID}"/></td>
			</tr>
			<tr>
				<td><form:button onclick="submitUpdateEmp()">Submit</form:button>
				<td><form:button onclick="cancelUpdateEmp()">Cancel</form:button></td>
			</tr>
			</table>
			<input type="hidden" id="operation" name="operation" value="" />
		</form:form>

</body>
</html>
