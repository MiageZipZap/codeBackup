$(function() {
	$('#interactionNetworkForm').bootstrapValidator({
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			'beginDate': {
				group: '.col-sm-3',
				validators: {
					notEmpty: {
						message: 'La date de debut est requise'
					},
					date: {
                        format: 'DD/MM/YYYY h:m',
                        message: 'Format invalide : "JJ/MM/AAAA HH:MM"'
                    }
				}
			},
			'endDate':{
				group: '.col-sm-3',
				validators: {
					notEmpty: {
						message: 'La date de fin est requise'
					},
					date: {
                        format: 'DD/MM/YYYY h:m',
                        message: 'Format invalide : "JJ/MM/AAAA HH:MM"'
                    }
				}
			}
		}

	});
	
	$("#beginDate").datetimepicker({
		  format:'d/m/Y H:i',
		  lang:'fr',
		  mask:true,
		  onSelectTime:function(ct,$i){
			  $('#interactionNetworkForm').bootstrapValidator('revalidateField', 'beginDate');
		  }
	});
	$("#endDate").datetimepicker({
		  format:'d/m/Y H:i',
		  lang:'fr',
		  mask:true,
		  onSelectTime:function(ct,$i){
			  $('#interactionNetworkForm').bootstrapValidator('revalidateField', 'endDate');
		  }
	});

});