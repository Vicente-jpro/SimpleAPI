//alert("Hello I am server request file");


function searchStudent() {

	var keyWord = $('#key-word-from-form-seach').val();

	if (keyWord.length < 1) {
		alert("Error on seaching student: Type at least a letters");
	} else {


		// Saving using ajax
		$.ajax({
			method: "GET",
			url: "/student/search/" + keyWord,
			contentType: "application/json; charset=utf-8",
			success: function(response) {
				// response has all values from this particular user 

				$('#search-result > tbody > tr').remove();
				for (var i = 0; i < response.length; i++) {
					$('#search-result > tbody ').append(
						'<tr class="hide-deteted' + response[i].id + '"+>'
						+ '<td>' + response[i].id + '</td>'
						+ '<td>' + response[i].name + '</td>'
						+ '<td>' + response[i].phoneNumber + '</td>'
						+ '<td> <i class="bi-pencil-square" onclick="edit(' + response[i].id + ')"></i></td>'
						+ '<td> <i class="bi-trash-fill " onclick="deleteStudent(' + response[i].id + ')"></i> </td>'
						+ '</tr>'
					);
				}
			}
		}).fail(function(xhr, status, errorThrown) {
			alert("Error. It was not possible created:" + xhr.responseText);
		});


	}

}




function saveStudent() {
	var id = $('#id').val();
	var name = $('#name').val();
	var phoneNumber = $('#phoneNumber').val();
	// Saving using ajax
	$.ajax({
		method: "POST",
		url: "/student/add", //localhost:8080/student/add
		data: JSON.stringify(
			{
				id: id,
				name: name,
				phoneNumber: phoneNumber
			}
		),
		contentType: "application/json; charset=utf-8",
		success: function(response) {
			// response has all values from this particular user 

			alert("Successfully created!");
			$('#id').val(response.id);

		}
	}).fail(function(xhr, status, errorThrown) {
		alert("Error. It was not possible created:" + xhr.responseText);
	});

}

function edit(id) {
	// Saving using ajax
	$.ajax({
		method: "GET",
		url: "/student/get/" + id,
		contentType: "application/json; charset=utf-8",
		success: function(response) {
			// response has all values from this particular user 

			$('#id').val(response.id);
			$('#name').val(response.name);
			$('#phoneNumber').val(response.phoneNumber);
			//$('#exampleModal').modal('hide');
		}
	}).fail(function(xhr, status, errorThrown) {
		alert("Error. It was not possible created:" + xhr.responseText);
	});

}


function deleteStudent(id) {

	// Saving using ajax
	$.ajax({
		method: "DELETE",
		url: "/student/delete/" + id,
		contentType: "application/json; charset=utf-8",
		success: function(response) {

			$('.hide-deteted' + id).hide(1500);

		}
	}).fail(function(xhr, status, errorThrown) {
		alert("Error. It was not possible created:" + xhr.responseText);
	});

}


