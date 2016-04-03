$(document).ready(function() {
	
	$('#bt-go-admin').click(function(){
		alert('Button is clicked');
		document.flow.submit();
	});
		
	$('#bt-add').click(function(){
		alert('Add button is clicked');
		document.getElementById('operation').value='add';
		document.flow.submit();
	});
	
	$('#bt-search').click(function(){
		alert("Search button is clicked");
		document.getElementById('operation').value='search';
		document.flow.submit();
	});
	
	$('#bt-update').click(function(){
		alert("Update button is clicked");
		document.getElementById('operation').value='update';
		document.flow.submit();
	});
	
	$('#bt-delete').click(function(){
		alert('delete button is clicked');
		document.getElementById('operation').value='delete';
		document.flow.submit();
	});
	
	
});

function submitCreateEmp()
{
	alert("submitCreateEmp is clicked");
	document.createEmp.action="add";
	document.createEmp.submit();
}

function cancelCreateEmp()
{
	alert("cancelCreateEmp is clicked - so reset is made");
	document.createEmp.action="welcome";
	document.createEmp.submit();
}