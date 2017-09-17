<script>
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
	$(document).ready(function() {
		$('#salutation').change(function() {
			if ($('#salutation').val() > 3) {
				$('#gender').val(7);
			} else {
				$('#gender').val(6);
				
			}
		});

		$('#gender').change(function() {
			if ($('#gender').val() > 6) {
				$('#salutation').val(5);
			} else {
				$('#salutation').val(3);
			}
		});

		var f = function disabler() {
			if ($('#staff').val() > 8) {
				$("#employeeNumber").prop('disabled', true);
			} else {
				$("#employeeNumber").prop('disabled', false);
			}
		}
		$('#staff').change(f);
		
		var seniorcitizen = function disabler() {
			if ($('#seniorCitizen').val() > 10) {
				$("#seniorCitizenProof").prop('disabled', true);
			} else {
				$("#seniorCitizenProof").prop('disabled', false);
			}
		}
		$('#seniorCitizen').change(seniorcitizen);
		
		
	});
</script>