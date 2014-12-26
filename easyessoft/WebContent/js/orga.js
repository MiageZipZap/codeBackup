$(document).ready(function() {
	$('#orgaForm').bootstrapValidator({
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			'orgaType.id': {
				group: '.col-sm-5',
				validators: {
					greaterThan: {
						value:1,
						message: 'The Organization type is required'
					},
					stringLength: {
						max: 200,
						message: 'The title must be less than 200 characters long'
					}
				}
			}, 
			name: {
				validators: {
					stringLength: {
						min:2,
						max:45,
						message: 'The organization name should be between 2 and 45 caracters'
					},
					notEmpty:{
						message: 'The organization name is required'
					}
				}
			},
			siret: {
				validators: {
					digits: {
						message: 'The siret is a numeric value'
					},
					stringLength: {
						min:14,
						max:14,
						message: 'The siret should be 14 numbers'
					},
					notEmpty: {
						message: 'The siret is required'
					}
				}
			},
			streetNumber: {
				validators: {
					stringLength: {
						max:45,
						message: 'The street number is limited 45 caracters'
					}
				}
			},
			streetType: {
				validators: {
					stringLength: {
						min:2,
						max:45,
						message: 'The street type should be between 2 and 45 caracters'
					}
				}
			},
			streetName: {
				validators: {
					stringLength: {
						min:2,
						max:45,
						message: 'The street name should be between 2 and 45 caracters'
					}
				}
			},
			city:{
				validators: {
					stringLength: {
						min:2,
						max:45,
						message: 'The city name should be between 2 and 45 caracters'
					}
				}

			},
			zipCode:{
				validators: {
					zipCode:{
						country:'FR',
						message: 'The Zip Code is not valid'
					},
					notEmpty:{
						message: 'The Zip Code is required'
					}
				}
			},
			department:{
				validators:{
					stringLength: {
						min:2,
						max:45,
						message: 'The department name should be between 2 and 45 caracters'
					}
				}
			},
			latitude: {
				validators: {
					between: {
						min: -90.0,
						max: 90,
						message: 'The latitude must be between -90.0 and 90.0'
					}
				}
			},
			longitude: {
				validators: {
					between: {
						min: -180,
						max: 180,
						message: 'The longitude must be between -180.0 and 180.0'
					}
				}
			},
			fax: {
				validators: {
					phone: {
						country:"FR",
						message: 'Please provide a valid fax number'
					}
				}
			},
			phone: {
				validators: {
					phone: {
						country:"FR",
						message: 'Please provide a valid fax number'
					}
				}
			}

		}
	});






	/*$(function() {
	var orgaTypeVar=document.getElementById('OrgaType').value;
	$("#createButOrga").click(function() {
		controlManager.reset();
		String.check("name", 2, 45);
		String.check("siret", 14, 14);
		Integer_check("streetNumber", 1, 6);
		String.check("streetType", 2, 45);
		String.check("streetName", 2, 45);
		String.check("city", 2, 45);
		String.check("zipCode", 2, 45);
		String.check("department", 2, 45);

		//Hospital fields check
		if( orgaTypeVar != 0){
			if(orgaTypeVar==2){
				String.check("finess", 2, 45);
			}
		}

		if (controlManager.hasNoError()) {
			$("#orgaForm").removeAttr("onsubmit");
			$("#orgaForm").submit();
		}
	});



	$("#OrgaType").on('change', function (e) {
	    var valueSelected = this.value;
	    alert(valueSelected);
	    if (valueSelected==2){
			$('#OrgaType').append('<div class="container include-contact">'+	
					'testestestte</div>');
		}
	});
	 */
});