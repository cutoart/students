/**
 * 
 */
$('document').ready(function(){	
	$('.table #editButton').on('click',function(event){	
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		$.get(href,function(student,status){
			$('#IdEdit').val(student.id);
			$('#nameEdit').val(student.name);
			$('#departmentEdit').val(student.department);
			$('#updatedByEdit').val(student.updatedBy);
			$('#updatedOnEdit').val(student.updatedOn);
		});
		
		$('#editModal').modal();				
	});	
	
$('.table #deleteButton').on('click',function(event){
	event.preventDefault();		
	var href = $(this).attr('href');
	$('#deleteModal #delRef').attr('href', href);		
	$('#deleteModal').modal();
});
});