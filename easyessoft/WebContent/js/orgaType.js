$(document).ready(function() {
	$('#orgaTypeForm').bootstrapValidator({
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			code: {
				group: '.col-sm-5',
				validators: {
					stringLength: {
						min:2,
						max:45,
						message: 'The code length should be between 2 and 45 caracters'
					},
					notEmpty:{
						message: 'The organization name is required'
					}
				}
			},
			label: {
				group: '.col-sm-5',
				validators: {
					stringLength: {
						min:2,
						max:45,
						message: 'The code length should be between 2 and 45 caracters'
					},
					notEmpty:{
						message: 'The organization name is required'
					}
				}
			},
			legalStatus: {
				group: '.col-sm-5',
				validators: {

				}
			}
		}

	});

});