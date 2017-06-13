<script>
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
	$(document).ready(function() {
		$('#salutation').change(function() {
			if ($('#salutation').val() > 1) {
				$('#gender').val(2);
			} else {
				$('#gender').val(1);
			}
		});

		$('#gender').change(function() {
			if ($('#gender').val() > 1) {
				$('#salutation').val(3);
			} else {
				$('#salutation').val(1);
			}
		});

		var f = function disabler() {
			if ($('#staff').val() > 1) {
				$("#employeeNumber").prop('disabled', true);
			} else {
				$("#employeeNumber").prop('disabled', false);
			}
		}
		$('#staff').change(f);
		
		var seniorcitizen = function disabler() {
			if ($('#seniorCitizen').val() > 1) {
				$("#seniorCitizenProof").prop('disabled', true);
			} else {
				$("#seniorCitizenProof").prop('disabled', false);
			}
		}
		$('#seniorCitizen').change(seniorcitizen);
		
		
	});
</script>