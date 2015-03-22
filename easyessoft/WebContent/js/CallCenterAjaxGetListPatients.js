$(document).ready(function() {
	//check name availability on focus lost
//	$('#dynamicPatientbutton').click(function() {
//
//		getPatients();
//	});
	variableFields();

	//
});

function getTextArea(){
	alert("test");
	var simpleContent =$('#testRemarks').val('toto');
	alert(simpleContent.val());
	console.debug(tinyMCE.activeEditor.getContent());
//	alert(simpleContent.value);
//	simpleContent.value=tinyMCE.get('remarks').getContent();
//	$('diagnostics').value=tinyMCE.get('diagnostics').getContent();
}
function getPatients() {
	var patients;
	var injPatientNumber = +$('#injPatientNumber').val();
	if(injPatientNumber==0) 
		return false;
	$.getJSON("patients/jsonList/",{injPatientNumber:injPatientNumber}, function(patients) {
		var options = $("#dynamicPatientForms")
		$.each(patients, function() {
			options.append('<div id="'+this.person.name+'">');
			options.append($('<div id="'+this.person.name+'">').load('/easyessoft/ajax/person.jsp'));
			options.append($("</div>"));
//			$(this).children("div:first").html('/easyessoft/ajax/person.jsp');
		});
	})
};
function getVehicules() {
	var vehicules;
	var injPatientNumber = +$('#injPatientNumber').val();
	if(injPatientNumber==0) 
		return false;
	$.getJSON("vehicules/jsonList/",{injPatientNumber:injPatientNumber}, function(patients) {
		var options = $("#dynamicPatientForms");
		$.each(patients, function() {
			options.append('<div id="'+this.person.name+'">');
			options.append($('<div id="'+this.person.name+'">').load('/easyessoft/ajax/person.jsp'));
			options.append($("</div>"));
//			$(this).children("div:first").html('/easyessoft/ajax/person.jsp');
		});
	})
};
function variableFields() {
	var iCnt = 0;
	// CREATE A "DIV" ELEMENT AND DESIGN IT USING JQUERY ".css()" CLASS.
	var container = $(
			document
			.createElement('div'))
			.css(
					{
						padding : '5px',
						margin : '20px',
						width : '170px',
						border : '1px dashed',
						borderTopColor : '#999',
						borderBottomColor : '#999',
						borderLeftColor : '#999',
						borderRightColor : '#999'
					});

	$('#btAdd')
	.click(
			function() {
				if (iCnt <= 19) {

					iCnt = iCnt + 1;

					// ADD TEXTBOX.
					$(
							container)
							.append(
									'<input type=text class="input" id=tb' + iCnt + ' ' +
									'value="Text Element ' + iCnt + '" />');

					if (iCnt == 1) { // SHOW SUBMIT BUTTON IF ATLEAST "1" ELEMENT HAS BEEN CREATED.

						var divSubmit = $(document
								.createElement('div'));
						$(
								divSubmit)
								.append(
										'<input type=button class="bt" onclick="GetTextValue()"'
										+ 'id=btSubmit value=Submit />');

					}

					$(
					'#main')
					.after(
							container,
							divSubmit); // ADD BOTH THE DIV ELEMENTS TO THE "main" CONTAINER.
				} else { // AFTER REACHING THE SPECIFIED LIMIT, DISABLE THE "ADD" BUTTON. (20 IS THE LIMIT WE HAVE SET)

					$(
							container)
							.append(
							'<label>Reached the limit</label>');
					$(
					'#btAdd')
					.attr(
							'class',
					'bt-disable');
					$(
					'#btAdd')
					.attr(
							'disabled',
					'disabled');

				}
			});

	$(
	'#btRemove')
	.click(
			function() { // REMOVE ELEMENTS ONE PER CLICK.
				if (iCnt != 0) {
					$(
							'#tb'
							+ iCnt)
							.remove();
					iCnt = iCnt - 1;
				}

				if (iCnt == 0) {
					$(
							container)
							.empty();

					$(
							container)
							.remove();
					$(
					'#btSubmit')
					.remove();
					$(
					'#btAdd')
					.removeAttr(
					'disabled');
					$(
					'#btAdd')
					.attr(
							'class',
					'bt')

				}
			});

	$(
	'#btRemoveAll')
	.click(
			function() { // REMOVE ALL THE ELEMENTS IN THE CONTAINER.

				$(
						container)
						.empty();
				$(
						container)
						.remove();
				$(
				'#btSubmit')
				.remove();
				iCnt = 0;
				$(
				'#btAdd')
				.removeAttr(
				'disabled');
				$(
				'#btAdd')
				.attr(
						'class',
				'bt');

			});
}
//PICK THE VALUES FROM EACH TEXTBOX WHEN "SUBMIT" BUTTON IS CLICKED.
var divValue, values = '';
function GetTextValue() {

	$(divValue).empty();
	$(divValue).remove();
	values = '';

	$('.input')
	.each(
			function() {
				divValue = $(
						document
						.createElement('div'))
						.css(
								{
									padding : '5px',
									width : '200px'
								});
				values += this.value
				+ '<br />'
			});

	$(divValue).append(
			'<p><b>Your selected values</b></p>'
			+ values);
	$('body').append(divValue);

}