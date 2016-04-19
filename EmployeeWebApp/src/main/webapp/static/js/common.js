$(document).ready(function() {
	
	$('#bt-go-admin').click(function(){
		document.flow.submit();
	});
		
	$('#bt-add').click(function(){
		document.getElementById('operation').value='add';
		document.flow.submit();
	});
	
	$('#bt-search').click(function(){
		document.getElementById('operation').value='search';
		document.flow.submit();
	});
	
	$('#bt-update').click(function(){
		document.getElementById('operation').value='update';
		document.flow.submit();
	});
	
	$('#bt-delete').click(function(){
		document.getElementById('operation').value='delete';
		document.flow.submit();
	});
	
	$('#updateButton').click(function(){
		console.log('update button is clicked');
		document.getElementById('operation').value='update';
		var actionChoosen = fetchSelectedValues();
		document.showAllFlow.action=actionChoosen;
		document.showAllFlow.submit();
	});
	
	$('#deleteButton').click(function(){
		console.log('delete button is clicked');
		document.getElementById('operation').value='delete';
		var actionChoosen = fetchSelectedValues();
		document.showAllFlow.action=actionChoosen;
		document.showAllFlow.submit();
	});
	
	$('#bt-showAll').click(function(){
		console.log('showAll button is clicked');
		document.flow.action="showAll";
		document.flow.method="GET";
		document.flow.submit();
	});
	
	$('#homeButton').click(function(){
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
	document.createEmp.action="add";
	document.createEmp.submit();
}

function cancelCreateEmp()
{
	document.createEmp.action="welcome";
	document.createEmp.submit();
}

function submitUpdateEmp(){
	document.getElementById('operation').value='update';
	document.updateEmp.submit();
}

function cancelUpdateEmp(){
	document.getElementById('operation').value='cancel';
	document.updateEmp.submit();
}

function submitDeleteEmp(){
	document.getElementById('operation').value='delete';
	document.deleteEmp.submit();
}

function cancelDeleteEmp(){
	document.getElementById('operation').value='cancel';
	document.deleteEmp.submit();
}
