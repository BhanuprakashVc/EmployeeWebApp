$(document).ready(function() {
	
	$('#bt-go-admin').click(function(){
		// alert('Button is clicked');
		document.flow.submit();
	});
		
	$('#bt-add').click(function(){
		// alert('Add button is clicked');
		document.getElementById('operation').value='add';
		document.flow.submit();
	});
	
	$('#bt-search').click(function(){
		// alert("Search button is clicked");
		document.getElementById('operation').value='search';
		document.flow.submit();
	});
	
	$('#bt-update').click(function(){
		// alert("Update button is clicked");
		document.getElementById('operation').value='update';
		document.flow.submit();
	});
	
	$('#bt-delete').click(function(){
		// alert('delete button is clicked');
		document.getElementById('operation').value='delete';
		document.flow.submit();
	});
	
	$('#updateButton').click(function(){
		// alert('update button is clicked');
		console.log('update button is clicked');
		document.getElementById('operation').value='update';
		var actionChoosen = fetchSelectedValues();
		document.showAllFlow.action=actionChoosen;
		document.showAllFlow.submit();
	});
	
	$('#deleteButton').click(function(){
		// alert('delete button is clicked');
		console.log('delete button is clicked');
		document.getElementById('operation').value='delete';
		var actionChoosen = fetchSelectedValues();
		document.showAllFlow.action=actionChoosen;
		document.showAllFlow.submit();
	});
	
	$('#bt-showAll').click(function(){
		// alert('showAll button is clicked');
		console.log('showAll button is clicked');
		document.flow.action="showAll";
		document.flow.method="GET";
		document.flow.submit();
	});
	
	$('#homeButton').click(function(){
		// alert('home button is clicked');
		console.log('home button is clicked');
		document.showAllFlow.action="welcome";
		document.showAllFlow.method="GET";
		document.showAllFlow.submit();
	});
	
	function fetchSelectedValues(){
		var allDataValues = [];
		var idVal = $('input[type=radio]:checked').closest('tr').find('.data').each(function(){
			var value = $(this).html();
			allDataValues.push(value);
			console.log('td value: '+value);
		});
		console.log('allDataValues: ' +allDataValues);
		var loggedInUserCaasId = allDataValues.pop();
		var address = allDataValues.pop();
		var lastName  = allDataValues.pop();
		var firstName = allDataValues.pop();
		var id = allDataValues.pop();
		var actionChoosen = "showAll/"+id + '/'+firstName + '/' + lastName + '/' + address + '/' +loggedInUserCaasId;
		console.log('actionChoosen: ' +actionChoosen);
		return actionChoosen;
	}
	
});



function submitCreateEmp()
{
	// alert("submitCreateEmp is clicked");
	document.createEmp.action="add";
	document.createEmp.submit();
}

function cancelCreateEmp()
{
	// alert("cancelCreateEmp is clicked - so reset is made");
	document.createEmp.action="welcome";
	document.createEmp.submit();
}

function submitUpdateEmp(){
	// alert("submitUpdateEmp is clicked");
	document.getElementById('operation').value='update';
	document.updateEmp.submit();
}

function cancelUpdateEmp(){
	// alert("cancelUpdateEmp is clicked ");
	document.getElementById('operation').value='cancel';
	document.updateEmp.submit();
}

function submitDeleteEmp(){
	// alert("submitDeleteEmp is clicked ");
	document.getElementById('operation').value='delete';
	document.deleteEmp.submit();
}

function cancelDeleteEmp(){
	// alert("cancelDeleteEmp is clicked ");
	document.getElementById('operation').value='cancel';
	document.deleteEmp.submit();
}
