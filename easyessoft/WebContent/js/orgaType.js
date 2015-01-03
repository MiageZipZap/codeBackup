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

				}
			},
			label: {
				group: '.col-sm-5',
				validators: {

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