// JavaScript Document
var rateOfInt = 0;
var DisInt;

$(function() {

	$("#calculateBtn").click(function() {
		
		getfdTxnDtls();

	});

});
$(function() {
	$("#selectedFdSchemeTypeId").change(function() {
		var selectedVal = this.value;
		getroidetails(selectedVal);
	});

});

function fdSubmit() {
	$('#fixedDepositAdd').attr('method', 'post');
	$('#fixedDepositAdd').attr('action', '/fdsubmit');
	$('#fixedDepositAdd').submit();
}

function getfdTxnDtls() {
	var rateOfInter = parseFloat($("#ROI").val());
	var principalAm = parseFloat($('#principalAmt').val());
	var inputMonth = $('#monthsPeriod').val();
	var inputDays = $('#daysPeriod').val();
	//var dateOfDep = $("#dateOfDeposit").datepicker("option","dateFormat",'yyyy-mm-dd');
	var dateOfDep = $("#dateOfDeposit").datepicker({
		dateFormat : 'yyyy-mm-dd'
	}).val();
	$.ajax({
		type : "POST",
		url : "/getFdTxnDtls",
		data : "rateOfInterest=" + rateOfInter + "&principalAmt=" + principalAm
				+ "&daysPeriod=" + inputDays + "&monthsPeriod=" + inputMonth
				+ "&dateOfDeposit=" + dateOfDep,
		success : function(response) {
			var jsonString = response;
			var myData = JSON.parse(jsonString);
			$('.tabs1 table').find('td').parent('tr').remove();
			$.each(myData, function(index, txndtl) {
				$('.tabs1 table').append(
						"<tr><td>" + txndtl.dateOfIntMaturity + "</td><td>"
								+ txndtl.intAmount + "</td><td>"
								+ txndtl.intCapitalized + "</td><td>"
								+ txndtl.fdBalance + "</td><td>"
								+ txndtl.fdTxnTypeEnum + "</td></tr>");
			});
		}
	})
}

function getroidetails(selectedValue) {
	$.ajax({
		type : "POST",
		url : "/getroibyschemeid",
		data : "selectedFdSchemeTypeId=" + selectedValue,
		success : function(response) {
			document.getElementById('ROI').value = response.roi;
		}
	})
}

function depositValidation() {
	var thisDeposit = $('.selectedvalue').text();

}

var myDate, myMonth, myday, myYear, AmtValue, thisMonthDays, maturityValue;
var monthArray = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];
var shortMonthArray = [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'July',
		'Aug', 'Sept', 'Oct', 'Nov', 'Dec' ];
var PAtotalDays = 365;
var inputMonth, inputDays, addMonth, addDateDays, addDays, leapYr, captchupAmt;
var eachIntAmt = 0;
var eachTotalAmt = 0;
var totalIntAmt = 0;
var lastCount, lastShortTermCount;
var FDint, myLastDay;
var plusMonth = 0;
var flag = true;
var lastAdd = true;
var catchUpdate = 0;
var withAccrual = true;

function Reinvestmentcalc() {
	$('.tabs1 table').find('td').parent('tr').remove();
	PAtotalDays = 365;
	eachIntAmt = 0;
	eachTotalAmt = 0;
	totalIntAmt = 0;
	flag = true;

	var date = $("#dateOfDeposit").datepicker('getDate');
	//alert ('date:'+date);
	myDate = date.getDate(); // Day of the month
	//alert ('myDate:'+myDate);
	myMonth = date.getMonth() + 1; // Month with a zero index
	//alert ('myMonth:'+myMonth);
	myDay = date.getDay(); // Day of the week
	//alert ('myDay:'+myDay);
	myYear = date.getFullYear(); // The "full" year, e.g. 2011
	//alert ('myYear:'+myYear);
	leapYr = myYear % 4;
	//alert ('leapYr'+leapYr);
	if (leapYr == 0) {
		PAtotalDays = 366;
		monthArray[1] = 29;
	} else {
		PAtotalDays = 365;
		monthArray[1] = 28;
	}

	// alert(myMonth);
	AmtValue = parseInt($('#principalAmt').val());
	//alert ('AmtValue'+AmtValue);
	// alert(thisMonthDays);
	inputMonth = parseInt($('#monthsPeriod').val());
	//alert ('inputMonth'+inputMonth);
	inputDays = parseInt($('#daysPeriod').val());
	// alert(inputMonth);
	addMonth = parseInt((myMonth - 1) + inputMonth);
	//alert ('addMonth:'+addMonth);
	// alert(shortMonthArray[addMonth]);
	addDateDays = myDate + inputDays;
	//alert ('addDateDays:'+addDateDays);
	addDays = myDate + addDateDays;
	//alert ('addDays:'+addDays);
	// alert(addDateDays);
	if (myMonth == 1 || myMonth == 3 || myMonth == 5 || myMonth == 7
			|| myMonth == 8 || myMonth == 10 || myMonth == 12) {
		if (addDateDays >= 31) {
			// inputMonth = inputMonth + 1;
			plusMonth = 1;
		} else {
			plusMonth = 0;
		}
	} else if (myMonth == 2) {
		if (addDateDays >= 28) {
			// inputMonth = inputMonth + 1;
			plusMonth = 1;
		} else {
			plusMonth = 0;
		}
	} else {
		if (addDateDays >= 30) {
			// inputMonth = inputMonth + 1;
			plusMonth = 1;
		} else {
			plusMonth = 0;
		}
	}
	//alert ('plusMonth:'+plusMonth);
	// totalMonth = Math.floor(inputMonth/3);
	// alert(plusMonth);

	// alert('months' + myMonth);
	// if(catchUpdate==true){
	if (myMonth == 0 || myMonth == 1 || myMonth == 3 || myMonth == 5
			|| myMonth == 7 || myMonth == 8 || myMonth == 10 || myMonth == 12) {
		if (myDate == monthArray[myMonth - 1]) {
			// myDate = monthArray[myMonth];
			catchUpdate = false;
		} else {
			catchUpdate = true;
		}
	} else if (myMonth == 4 || myMonth == 6 || myMonth == 9 || myMonth == 11) {
		if (myDate == monthArray[myMonth - 1]) {
			// myDate = monthArray[myMonth];
			catchUpdate = false;
		} else {
			catchUpdate = true;
		}
	} else if (myMonth == 2) {
		if (myDate == monthArray[myMonth - 1]) {
			// myDate = monthArray[myMonth];
			catchUpdate = false;
		} else {
			catchUpdate = true;
		}
	}
	// }
	// alert(catchUpdate);
	//alert ('catchUpdate:'+catchUpdate);		
	// console.log('Date-'+myDate + ' Month-'+shortMonthArray[myMonth-1]);
	$('.tabs1 table').append(
			"<tr><td>" + myDate + '-' + shortMonthArray[myMonth - 1] + '-'
					+ myYear + "</td><td>&nbsp;</td><td>&nbsp;</td><td>"
					+ AmtValue.toFixed(2) + "</td></tr>");

	captchupAmt = AmtValue;
	//alert ('captchupAmt:'+captchupAmt);
	FDint = totalIntAmt + AmtValue;
	//alert ('totalIntAmt:'+totalIntAmt);
	//alert ('FDint:'+FDint);
	for (var a = 0; a < inputMonth; a++) {
		//alert ('a:'+a);
		eachIntAmt = 0;
		//alert ('eachIntAmt:'+eachIntAmt);
		lastAdd = true;
		//alert ('lastAdd:'+lastAdd);
		thisMonthDays = (monthArray[myMonth - 1]) - myDate + 1; // +1 to add
		// means
		// including
		// start date
		//alert ('thisMonthDays:'+thisMonthDays);

		maturityValue = preciseRound((thisMonthDays * rateOfInt * FDint)
				/ (PAtotalDays * 100), 2);
		//alert ('maturityValue:'+maturityValue);
		// console.log('Date-1' + ' Month-'+shortMonthArray[myMonth] + ' =' +
		// maturityValue.toFixed(2));
		$('.tabs1 table').append(
				"<tr><td>" + monthArray[myMonth - 1] + "-"
						+ shortMonthArray[myMonth - 1] + '-' + myYear
						+ "</td><td>" + maturityValue.toFixed(2)
						+ "</td><td>&nbsp;</td><td>"
						+ Math.round(FDint).toFixed(2) + "</td></tr>");

		if (myMonth >= 12) {
			myMonth = 0;
			myYear = myYear + 1;
		}
		leapYr = myYear % 4;
		if (leapYr == 0) {
			PAtotalDays = 366;
			monthArray[1] = 29;
		} else {
			PAtotalDays = 365;
			monthArray[1] = 28;
		}
		//alert ('eachIntAmt:'+eachIntAmt);
		eachIntAmt = eachIntAmt + maturityValue;
		// count++;
		// alert('count' + count);
		for (var i = 0; i < 2; i++) {
			//alert ('i:'+i);
			a++;
			//alert ('a:'+a);
			if (a == inputMonth) {
				//alert ('a == inputMonth');
				i = 2;
				flag = false;
				withAccrual = true;
			} else {
				//alert ('else a == inputMonth');
				myMonth = myMonth + 1;
				//alert ('myMonth'+myMonth);
				maturityValue = (monthArray[myMonth - 1] * rateOfInt * FDint)
						/ (PAtotalDays * 100);
				//alert ('maturityValue'+maturityValue);
				eachIntAmt = preciseRound((eachIntAmt + maturityValue), 2);
				//alert ('eachIntAmt'+eachIntAmt);
				// console.log('Date-1' + ' Month-'+shortMonthArray[myMonth] + '
				// =' + maturityValue.toFixed(2));
				$('.tabs1 table').append(
						"<tr><td>" + monthArray[myMonth - 1] + "-"
								+ shortMonthArray[myMonth - 1] + '-' + myYear
								+ "</td><td>" + maturityValue.toFixed(2)
								+ "</td><td>&nbsp;</td><td>"
								+ Math.round(FDint).toFixed(2) + "</td></tr>");

				// withAccrual = true;

				if (myMonth >= 12) {
					myMonth = 0;
					myYear = myYear + 1;
				}
				// alert(myYear);
				leapYr = myYear % 4;
				if (leapYr == 0) {
					PAtotalDays = 366;
					monthArray[1] = 29;
				} else {
					PAtotalDays = 365;
					monthArray[1] = 28;
				}

			}
			// alert('aj'+eachIntAmt);
			// alert('my a value' + a);
		}
		// alert("M " + a);
		if (a == $('#monthsPeriod').val()) {
			flag = false;
		}
		if (myMonth) {
			if (myDate > monthArray[myMonth]) {
				// alert(11);
				myDate = monthArray[myMonth];
			} else {
				// alert(22);
				myDate = date.getDate();
			}
		}

		if (flag != false) {

			withAccrual = false;

			if (catchUpdate == false) {
				myDate = monthArray[myMonth];
			}
			maturityValue = ((myDate - 1) * rateOfInt * FDint)
					/ (PAtotalDays * 100);
			// console.log('Date-'+myDate + ' Month-'+shortMonthArray[myMonth] +
			// ' =' + maturityValue.toFixed(2));
			eachIntAmt = preciseRound((eachIntAmt + maturityValue), 2);
			// console.log('Date-'+myDate + ' Month-'+shortMonthArray[myMonth] +
			// ' =' + 'Interest Capitalized ' +
			// Math.round(eachIntAmt).toFixed(2));

			captchupAmt = Math.round(AmtValue + eachIntAmt);

			totalIntAmt = Math.round(totalIntAmt + eachIntAmt);
			// alert('aaaa' + totalIntAmt);
			FDint = preciseRound((totalIntAmt + AmtValue), 2);
			// console.log('Date-'+myDate + ' Month-'+shortMonthArray[myMonth] +
			// ' =' + 'FD Balance ' + Math.round(FDint).toFixed(2));
			// console.log('Total Interest ' + totalIntAmt.toFixed(2));

			$('.tabs1 table').append(
					"<tr class='totalInt'><td>" + myDate + '-'
							+ shortMonthArray[myMonth] + '-' + myYear
							+ "</td><td>" + maturityValue.toFixed(2)
							+ "</td><td>" + Math.round(eachIntAmt).toFixed(2)
							+ "</td><td>" + Math.round(FDint).toFixed(2)
							+ "</td></tr>");
			// console.log('Total FD Balance ' + (totalIntAmt +
			// AmtValue).toFixed(2));
			lastAdd = false;
		}
		myMonth = myMonth + 1;
	}

	if (plusMonth == 1) {
		lastAdd = true;
		thisMonthDays = (monthArray[myMonth - 1]) - myDate + 1; // +1 to add
		// means
		// including
		// start date

		if (withAccrual == false) {
			eachIntAmt = 0;
			maturityValue = preciseRound((thisMonthDays * rateOfInt * FDint)
					/ (PAtotalDays * 100), 2);
		} else {
			maturityValue = preciseRound(
					(monthArray[myMonth - 1] * rateOfInt * FDint)
							/ (PAtotalDays * 100), 2);
		}

		// maturityValue = preciseRound((thisMonthDays * rateOfInt * FDint) /
		// (PAtotalDays * 100), 2);
		eachIntAmt = eachIntAmt + maturityValue;
		// console.log('Date-1' + ' Month-'+shortMonthArray[myMonth] + ' =' +
		// maturityValue.toFixed(2));
		$('.tabs1 table').append(
				"<tr><td>" + monthArray[myMonth - 1] + "-"
						+ shortMonthArray[myMonth - 1] + '-' + myYear
						+ "</td><td>" + maturityValue.toFixed(2)
						+ "</td><td>&nbsp;</td><td>"
						+ Math.round(FDint).toFixed(2) + "</td></tr>");

		// myMonth = myMonth + 1;
		// alert(myMonth);
		addDateDays = monthArray[myMonth - 1] - myDate;
		// alert(addDateDays);
		if (catchUpdate == false) {
			myLastDay = inputDays;
		} else {
			myLastDay = inputDays - addDateDays;
		}
		// alert(myLastDay);
		lastCount = myLastDay;

		if (myLastDay < 0) {

			maturityValue = ((lastCount - 1) * rateOfInt * FDint)
					/ (PAtotalDays * 100);
			eachIntAmt = (parseFloat(eachIntAmt) + parseFloat(maturityValue))
					.toFixed(2);
			// console.log('Date-'+addDateDays + '
			// Month-'+shortMonthArray[myMonth] + ' =' +
			// maturityValue.toFixed(2));
			$('.tabs1 table').append(
					"<tr class='totalInt'><td>"
							+ (monthArray[myMonth - 1] - 1)
							+ '-'
							+ shortMonthArray[myMonth - 1]
							+ '-'
							+ myYear
							+ "</td><td>"
							+ maturityValue.toFixed(2)
							+ "</td><td>"
							+ Math.round(eachIntAmt).toFixed(2)
							+ "</td><td>"
							+ Math.round(
									parseFloat(FDint) + parseFloat(eachIntAmt))
									.toFixed(2) + "</td></tr>");

			$('.dueDate').text(
					(monthArray[myMonth - 1] - 1) + '-'
							+ shortMonthArray[myMonth - 1] + '-' + myYear);
			$('.resultWrap .ouputValue').text(
					addCommas(Math.round(
							parseFloat(FDint) + parseFloat(eachIntAmt))
							.toFixed(2)));
		} else if (myLastDay == 0) {

			maturityValue = ((lastCount - 1) * rateOfInt * FDint)
					/ (PAtotalDays * 100);
			eachIntAmt = (parseFloat(eachIntAmt) + parseFloat(maturityValue))
					.toFixed(2);
			// console.log('Date-'+addDateDays + '
			// Month-'+shortMonthArray[myMonth] + ' =' +
			// maturityValue.toFixed(2));
			$('.tabs1 table').append(
					"<tr class='totalInt'><td>"
							+ monthArray[myMonth - 1]
							+ '-'
							+ shortMonthArray[myMonth - 1]
							+ '-'
							+ myYear
							+ "</td><td>"
							+ maturityValue.toFixed(2)
							+ "</td><td>"
							+ Math.round(eachIntAmt).toFixed(2)
							+ "</td><td>"
							+ Math.round(
									parseFloat(FDint) + parseFloat(eachIntAmt))
									.toFixed(2) + "</td></tr>");

			$('.dueDate').text(
					monthArray[myMonth - 1] + '-'
							+ shortMonthArray[myMonth - 1] + '-' + myYear);
			$('.resultWrap .ouputValue').text(
					addCommas(Math.round(
							parseFloat(FDint) + parseFloat(eachIntAmt))
							.toFixed(2)));
		} else {
			// alert('myMonth ' + myMonth);

			if (myMonth >= 12) {
				myMonth = 0;
				myYear = myYear + 1;
			}
			// alert(myYear);
			leapYr = myYear % 4;
			if (leapYr == 0) {
				PAtotalDays = 366;
				monthArray[1] = 29;
			} else {
				PAtotalDays = 365;
				monthArray[1] = 28;
			}

			maturityValue = ((lastCount - 1) * rateOfInt * FDint)
					/ (PAtotalDays * 100);
			eachIntAmt = (parseFloat(eachIntAmt) + parseFloat(maturityValue))
					.toFixed(2);
			// console.log('Date-'+addDateDays + '
			// Month-'+shortMonthArray[myMonth] + ' =' +
			// maturityValue.toFixed(2));
			$('.tabs1 table').append(
					"<tr class='totalInt'><td>"
							+ parseInt(myLastDay)
							+ '-'
							+ shortMonthArray[myMonth]
							+ '-'
							+ myYear
							+ "</td><td>"
							+ maturityValue.toFixed(2)
							+ "</td><td>"
							+ Math.round(eachIntAmt).toFixed(2)
							+ "</td><td>"
							+ Math.round(
									parseFloat(FDint) + parseFloat(eachIntAmt))
									.toFixed(2) + "</td></tr>");

			$('.dueDate').text(
					myLastDay + '-' + shortMonthArray[myMonth] + '-' + myYear);
			$('.resultWrap .ouputValue').text(
					addCommas(Math.round(
							parseFloat(FDint) + parseFloat(eachIntAmt))
							.toFixed(2)));
		}
	} else {
		// alert(0);
		// maturityValue = (inputDays*rateOfInt*FDint)/(PAtotalDays*100);
		// myLastDay = myDate+inputDays;
		// myMonth = myMonth - 1;
		// alert('ajMonth' + myMonth);
		// var shortMonthArray =
		// ['Jan1','Feb','Mar1','Apr','May1','Jun','July1','Aug1','Sept','Oct1','Nov','Dec1'];
		// eachIntAmt = 0;
		// alert(addDateDays);

		if (myMonth == 0 || myMonth == 1 || myMonth == 3 || myMonth == 5
				|| myMonth == 7 || myMonth == 8 || myMonth == 10
				|| myMonth == 12) {
			if (addDateDays > 31) {
				addDateDays = addDateDays - myDate;
				myLastDay = addDateDays;
				lastCount = myLastDay;
			} else if (addDateDays == 31) {
				addDateDays = addDateDays - 31;
				myLastDay = 31;
				lastCount = 0;
				if (myMonth == 0) {
					myMonth = 11;
					myYear = myYear - 1;
				} else {
					myMonth = myMonth - 1;
					myMonth == shortMonthArray[myMonth];
				}
			} else {
				if (lastAdd == true) {
					myLastDay = inputDays + myDate;
					lastCount = myLastDay;
				} else if (lastAdd == false) {
					eachIntAmt = 0;
					myLastDay = inputDays + myDate;
					lastCount = myLastDay - myDate + 1;
				}
			}
		} else if (myMonth == 2) {
			if (addDateDays > monthArray[1]) {
				addDateDays = addDateDays - myDate;
				myLastDay = addDateDays;
				lastCount = myLastDay;
			} else if (addDateDays == monthArray[1]) {
				addDateDays = addDateDays - myDate;
				myLastDay = monthArray[1];
				lastCount = addDateDays;
				myMonth = myMonth - 1;
			} else {
				if (lastAdd == true) {
					myLastDay = inputDays + myDate;
					lastCount = myLastDay;
				} else if (lastAdd == false) {
					eachIntAmt = 0;
					myLastDay = inputDays + myDate;
					lastCount = myLastDay - myDate + 1;
				}
			}
		} else if (myMonth == 4 || myMonth == 6 || myMonth == 9
				|| myMonth == 11) {
			if (addDateDays > 30) {
				addDateDays = addDateDays - myDate;
				myLastDay = addDateDays;
				lastCount = myLastDay;
			} else if (addDateDays == 30) {
				addDateDays = addDateDays - 30;
				myLastDay = 30;
				lastCount = addDateDays;
				myMonth = myMonth - 1;
			} else {
				if (lastAdd == true) {
					myLastDay = inputDays + myDate;
					lastCount = myLastDay;
				} else if (lastAdd == false) {
					eachIntAmt = 0;
					myLastDay = inputDays + myDate;
					lastCount = myLastDay - myDate + 1;
				}
			}
		}

		if (myMonth >= 12) {
			myMonth = 0;
			myYear = myYear + 1;
		}
		// alert(myYear);
		leapYr = myYear % 4;
		if (leapYr == 0) {
			PAtotalDays = 366;
			monthArray[1] = 29;
		} else {
			PAtotalDays = 365;
			monthArray[1] = 28;
		}
		// myMonth = myMonth-1;
		// myLastDay = (myDate+inputDays);
		// alert('myMonth ' + myMonth);
		maturityValue = ((lastCount - 1) * rateOfInt * FDint)
				/ (PAtotalDays * 100);
		eachIntAmt = (parseFloat(eachIntAmt) + parseFloat(maturityValue))
				.toFixed(2);
		// console.log('Date-'+addDateDays + ' Month-'+shortMonthArray[myMonth] + '
		// =' + maturityValue.toFixed(2));
		// console.log('Date-'+addDateDays + ' Month-'+shortMonthArray[myMonth] + '
		// =' + 'Interest Capitalized ' + Math.round(maturityValue).toFixed(2));
		// console.log('Date-'+addDateDays + ' Month-'+shortMonthArray[myMonth] + '
		// =' + 'FD Balance ' + Math.round(FDint+maturityValue).toFixed(2));
		$('.tabs1 table').append(
				"<tr class='totalInt'><td>"
						+ parseInt(myLastDay)
						+ '-'
						+ shortMonthArray[myMonth - 1]
						+ '-'
						+ myYear
						+ "</td><td>"
						+ maturityValue.toFixed(2)
						+ "</td><td>"
						+ Math.round(eachIntAmt).toFixed(2)
						+ "</td><td>"
						+ Math
								.round(
										parseFloat(FDint)
												+ parseFloat(eachIntAmt))
								.toFixed(2) + "</td></tr>");
		// alert("fsdfdsgdg")

		$('.dueDate').text(
				myLastDay + '-' + shortMonthArray[myMonth - 1] + '-' + myYear);
		$('.resultWrap .ouputValue').text(
				addCommas(Math
						.round(parseFloat(FDint) + parseFloat(eachIntAmt))
						.toFixed(2)));

	}
}

function QuarterlyPayout() {
	$('.tabs1 table').find('td').parent('tr').remove();
	PAtotalDays = 365;
	eachIntAmt = 0;
	eachTotalAmt = 0;
	totalIntAmt = 0;
	flag = true;

	var date = $("#dateOfDeposit").datepicker('getDate');
	myDate = date.getDate(); // Day of the month
	myMonth = date.getMonth() + 1; // Month with a zero index
	myDay = date.getDay(); // Day of the week
	myYear = date.getFullYear(); // The "full" year, e.g. 2011

	leapYr = myYear % 4;

	if (leapYr == 0) {
		PAtotalDays = 366;
		monthArray[1] = 29;
	} else {
		PAtotalDays = 365;
		monthArray[1] = 28;
	}

	// alert(myMonth);
	AmtValue = parseInt($('#principalAmt').val());
	// alert(thisMonthDays);
	inputMonth = parseInt($('#monthsPeriod').val());
	inputDays = parseInt($('#daysPeriod').val());
	// alert(inputMonth);
	addMonth = parseInt((myMonth - 1) + inputMonth);
	// alert(shortMonthArray[addMonth]);
	addDateDays = myDate + inputDays;
	addDays = myDate + addDateDays;

	// alert(addDateDays);
	if (myMonth == 1 || myMonth == 3 || myMonth == 5 || myMonth == 7
			|| myMonth == 8 || myMonth == 10 || myMonth == 12) {
		if (addDateDays >= 31) {
			// inputMonth = inputMonth + 1;
			plusMonth = 1;
		} else {
			plusMonth = 0;
		}
	} else if (myMonth == 2) {
		if (addDateDays >= 28) {
			// inputMonth = inputMonth + 1;
			plusMonth = 1;
		} else {
			plusMonth = 0;
		}
	} else {
		if (addDateDays >= 30) {
			// inputMonth = inputMonth + 1;
			plusMonth = 1;
		} else {
			plusMonth = 0;
		}
	}

	if (myMonth == 0 || myMonth == 1 || myMonth == 3 || myMonth == 5
			|| myMonth == 7 || myMonth == 8 || myMonth == 10 || myMonth == 12) {
		if (myDate == monthArray[myMonth - 1]) {
			// myDate = monthArray[myMonth];
			catchUpdate = false;
		} else {
			catchUpdate = true;
		}
	} else if (myMonth == 4 || myMonth == 6 || myMonth == 9 || myMonth == 11) {
		if (myDate == monthArray[myMonth - 1]) {
			// myDate = monthArray[myMonth];
			catchUpdate = false;
		} else {
			catchUpdate = true;
		}
	} else if (myMonth == 2) {
		if (myDate == monthArray[myMonth - 1]) {
			// myDate = monthArray[myMonth];
			catchUpdate = false;
		} else {
			catchUpdate = true;
		}
	}

	// alert(catchUpdate);

	$('.tabs1 table').append(
			"<tr><td>" + myDate + '-' + shortMonthArray[myMonth - 1] + '-'
					+ myYear + "</td><td>&nbsp;</td><td>&nbsp;</td><td>"
					+ AmtValue.toFixed(2) + "</td></tr>");
	captchupAmt = AmtValue;
	// FDint = totalIntAmt+AmtValue;

	for (var a = 0; a < inputMonth; a++) {
		eachIntAmt = 0;
		lastAdd = true;
		thisMonthDays = (monthArray[myMonth - 1]) - myDate + 1; // +1 to add
		// means
		// including
		// start date
		maturityValue = preciseRound((thisMonthDays * rateOfInt * AmtValue)
				/ (PAtotalDays * 100), 2);

		// console.log('Date-1' + ' Month-'+shortMonthArray[myMonth] + ' =' +
		// maturityValue.toFixed(2));
		$('.tabs1 table').append(
				"<tr><td>" + monthArray[myMonth - 1] + "-"
						+ shortMonthArray[myMonth - 1] + '-' + myYear
						+ "</td><td>" + maturityValue.toFixed(2)
						+ "</td><td>&nbsp;</td><td>" + AmtValue.toFixed(2)
						+ "</td></tr>");

		if (myMonth >= 12) {
			myMonth = 0;
			myYear = myYear + 1;
		}

		leapYr = myYear % 4;
		if (leapYr == 0) {
			PAtotalDays = 366;
			monthArray[1] = 29;
		} else {
			PAtotalDays = 365;
			monthArray[1] = 28;
		}

		eachIntAmt = eachIntAmt + maturityValue;
		// count++;
		// alert('count' + count);
		for (var i = 0; i < 2; i++) {
			a++;
			if (a == inputMonth) {
				i = 2;
				flag = false;
			} else {
				myMonth = myMonth + 1;
				maturityValue = (monthArray[myMonth - 1] * rateOfInt * AmtValue)
						/ (PAtotalDays * 100);
				eachIntAmt = preciseRound((eachIntAmt + maturityValue), 2);

				// console.log('Date-1' + ' Month-'+shortMonthArray[myMonth] + '
				// =' + maturityValue.toFixed(2));
				$('.tabs1 table').append(
						"<tr><td>" + monthArray[myMonth - 1] + "-"
								+ shortMonthArray[myMonth - 1] + '-' + myYear
								+ "</td><td>" + maturityValue.toFixed(2)
								+ "</td><td>&nbsp;</td><td>"
								+ AmtValue.toFixed(2) + "</td></tr>");
			}
			if (myMonth >= 12) {
				myMonth = 0;
				myYear = myYear + 1;
			}
			// alert(myYear);
			leapYr = myYear % 4;
			if (leapYr == 0) {
				PAtotalDays = 366;
				monthArray[1] = 29;
			} else {
				PAtotalDays = 365;
				monthArray[1] = 28;
			}
			// alert('aj'+eachIntAmt);
			// alert('my a value' + a);
		}
		// alert("M " + a);
		if (a == $('#monthsPeriod').val()) {
			flag = false;
			withAccrual = true;
		}
		if (myMonth) {
			if (myDate > monthArray[myMonth]) {
				// alert(11);
				myDate = monthArray[myMonth];
			} else {
				// alert(22);
				myDate = date.getDate();
			}
		}

		if (flag != false) {

			withAccrual = false;

			if (catchUpdate == false) {
				myDate = monthArray[myMonth];
			}
			maturityValue = ((myDate - 1) * rateOfInt * AmtValue)
					/ (PAtotalDays * 100);
			// console.log('Date-'+myDate + ' Month-'+shortMonthArray[myMonth] +
			// ' =' + maturityValue.toFixed(2));
			eachIntAmt = preciseRound((eachIntAmt + maturityValue), 2);
			// console.log('Date-'+myDate + ' Month-'+shortMonthArray[myMonth] +
			// ' =' + 'Interest Capitalized ' +
			// Math.round(eachIntAmt).toFixed(2));

			captchupAmt = Math.round(AmtValue + eachIntAmt);

			totalIntAmt = Math.round(totalIntAmt + eachIntAmt);
			// alert('aaaa' + totalIntAmt);
			// FDint = preciseRound((totalIntAmt+AmtValue),2);
			// console.log('Date-'+myDate + ' Month-'+shortMonthArray[myMonth] +
			// ' =' + 'FD Balance ' + Math.round(FDint).toFixed(2));
			// console.log('Total Interest ' + totalIntAmt.toFixed(2));

			$('.tabs1 table').append(
					"<tr class='totalInt'><td>" + myDate + '-'
							+ shortMonthArray[myMonth] + '-' + myYear
							+ "</td><td>" + maturityValue.toFixed(2)
							+ "</td><td>" + Math.round(eachIntAmt).toFixed(2)
							+ "</td><td>" + AmtValue.toFixed(2) + "</td></tr>");
			// console.log('Total FD Balance ' + (totalIntAmt +
			// AmtValue).toFixed(2));
			lastAdd = false;
		}
		myMonth = myMonth + 1;
	}
	if (plusMonth == 1) {
		lastAdd = true;
		thisMonthDays = (monthArray[myMonth - 1]) - myDate + 1; // +1 to add
		// means
		// including
		// start date

		if (withAccrual == false) {
			eachIntAmt = 0;
			maturityValue = preciseRound((thisMonthDays * rateOfInt * AmtValue)
					/ (PAtotalDays * 100), 2);
		} else {
			maturityValue = preciseRound(
					(monthArray[myMonth - 1] * rateOfInt * AmtValue)
							/ (PAtotalDays * 100), 2);
		}

		// maturityValue = preciseRound((thisMonthDays * rateOfInt * AmtValue) /
		// (PAtotalDays * 100), 2);
		eachIntAmt = eachIntAmt + maturityValue;
		// console.log('Date-1' + ' Month-'+shortMonthArray[myMonth] + ' =' +
		// maturityValue.toFixed(2));
		$('.tabs1 table').append(
				"<tr><td>" + monthArray[myMonth - 1] + "-"
						+ shortMonthArray[myMonth - 1] + '-' + myYear
						+ "</td><td>" + maturityValue.toFixed(2)
						+ "</td><td>&nbsp;</td><td>" + AmtValue.toFixed(2)
						+ "</td></tr>");

		// myMonth = myMonth + 1;
		// alert(myMonth);
		addDateDays = monthArray[myMonth - 1] - myDate;
		// alert(addDateDays);
		if (catchUpdate == false) {
			myLastDay = inputDays;
		} else {
			myLastDay = inputDays - addDateDays;
		}
		// alert(myLastDay);
		lastCount = myLastDay;

		if (myLastDay < 0) {

			maturityValue = ((lastCount - 1) * rateOfInt * AmtValue)
					/ (PAtotalDays * 100);
			eachIntAmt = (parseFloat(eachIntAmt) + parseFloat(maturityValue))
					.toFixed(2);
			// console.log('Date-'+addDateDays + '
			// Month-'+shortMonthArray[myMonth] + ' =' +
			// maturityValue.toFixed(2));
			$('.tabs1 table').append(
					"<tr class='totalInt'><td>" + (monthArray[myMonth - 1] - 1)
							+ '-' + shortMonthArray[myMonth - 1] + '-' + myYear
							+ "</td><td>" + maturityValue.toFixed(2)
							+ "</td><td>" + Math.round(eachIntAmt).toFixed(2)
							+ "</td><td>" + AmtValue.toFixed(2) + "</td></tr>");

			$('.dueDate').text(
					(monthArray[myMonth - 1] - 1) + '-'
							+ shortMonthArray[myMonth - 1] + '-' + myYear);
			$('.resultWrap .ouputValue').text(addCommas(AmtValue.toFixed(2)));
			$('.InterestWrap').show();
			$('.InterestWrap .ouputValue').text(
					addCommas(Math.round(FinTotalInt).toFixed(2)));

		} else if (myLastDay == 0) {

			maturityValue = ((lastCount - 1) * rateOfInt * AmtValue)
					/ (PAtotalDays * 100);
			eachIntAmt = (parseFloat(eachIntAmt) + parseFloat(maturityValue))
					.toFixed(2);
			// console.log('Date-'+addDateDays + '
			// Month-'+shortMonthArray[myMonth] + ' =' +
			// maturityValue.toFixed(2));
			$('.tabs1 table').append(
					"<tr class='totalInt'><td>" + monthArray[myMonth - 1] + '-'
							+ shortMonthArray[myMonth - 1] + '-' + myYear
							+ "</td><td>" + maturityValue.toFixed(2)
							+ "</td><td>" + Math.round(eachIntAmt).toFixed(2)
							+ "</td><td>" + AmtValue.toFixed(2) + "</td></tr>");

			$('.dueDate').text(
					monthArray[myMonth - 1] + '-'
							+ shortMonthArray[myMonth - 1] + '-' + myYear);
			$('.resultWrap .ouputValue').text(addCommas(AmtValue.toFixed(2)));
			$('.InterestWrap').show();
			$('.InterestWrap .ouputValue').text(
					addCommas(Math.round(FinTotalInt).toFixed(2)));

		} else {
			// alert('myMonth ' + myMonth);

			if (myMonth >= 12) {
				myMonth = 0;
				myYear = myYear + 1;
			}
			// alert(myYear);
			leapYr = myYear % 4;
			if (leapYr == 0) {
				PAtotalDays = 366;
				monthArray[1] = 29;
			} else {
				PAtotalDays = 365;
				monthArray[1] = 28;
			}

			maturityValue = ((lastCount - 1) * rateOfInt * AmtValue)
					/ (PAtotalDays * 100);
			eachIntAmt = (parseFloat(eachIntAmt) + parseFloat(maturityValue))
					.toFixed(2);
			// console.log('Date-'+addDateDays + '
			// Month-'+shortMonthArray[myMonth] + ' =' +
			// maturityValue.toFixed(2));
			$('.tabs1 table').append(
					"<tr class='totalInt'><td>" + parseInt(myLastDay) + '-'
							+ shortMonthArray[myMonth] + '-' + myYear
							+ "</td><td>" + maturityValue.toFixed(2)
							+ "</td><td>" + Math.round(eachIntAmt).toFixed(2)
							+ "</td><td>" + AmtValue.toFixed(2) + "</td></tr>");

			$('.dueDate').text(
					myLastDay + '-' + shortMonthArray[myMonth] + '-' + myYear);
			$('.resultWrap .ouputValue').text(addCommas(AmtValue.toFixed(2)));
			$('.InterestWrap').show();
			$('.InterestWrap .ouputValue').text(
					addCommas(Math.round(FinTotalInt).toFixed(2)));
		}
	} else {
		// maturityValue = (inputDays*rateOfInt*FDint)/(PAtotalDays*100);
		// myLastDay = myDate+inputDays;
		// myMonth = myMonth - 1;
		// alert('ajMonth' + myMonth);
		// var shortMonthArray =
		// ['Jan1','Feb','Mar1','Apr','May1','Jun','July1','Aug1','Sept','Oct1','Nov','Dec1'];
		// eachIntAmt = 0;
		// alert(addDateDays);
		// alert(lastAdd);
		if (myMonth == 0 || myMonth == 1 || myMonth == 3 || myMonth == 5
				|| myMonth == 7 || myMonth == 8 || myMonth == 10
				|| myMonth == 12) {
			if (addDateDays > 31) {
				addDateDays = addDateDays - 31;
				myLastDay = addDateDays;
				lastCount = myLastDay;
			} else if (addDateDays == 31) {
				addDateDays = addDateDays - 31;
				myLastDay = 31;
				lastCount = 0;
				if (myMonth == 0) {
					myMonth = 11;
					myYear = myYear - 1;
				} else {
					myMonth = myMonth - 1;
					myMonth == shortMonthArray[myMonth];
				}
			} else {
				if (lastAdd == true) {
					myLastDay = inputDays + myDate;
					lastCount = myLastDay;
				} else if (lastAdd == false) {
					eachIntAmt = 0;
					myLastDay = inputDays + myDate;
					lastCount = myLastDay - myDate + 1;
				}
			}
		} else if (myMonth == 2) {
			if (addDateDays > monthArray[1]) {
				addDateDays = addDateDays - myDate;
				myLastDay = addDateDays;
				lastCount = myLastDay;
			} else if (addDateDays == monthArray[1]) {
				addDateDays = addDateDays - myDate;
				myLastDay = monthArray[1];
				lastCount = addDateDays;
				myMonth = myMonth - 1;
			} else {
				if (lastAdd == true) {
					myLastDay = inputDays + myDate;
					lastCount = myLastDay;
				} else if (lastAdd == false) {
					eachIntAmt = 0;
					myLastDay = inputDays + myDate;
					lastCount = myLastDay - myDate + 1;
				}
			}
		} else if (myMonth == 4 || myMonth == 6 || myMonth == 9
				|| myMonth == 11) {
			if (addDateDays > 30) {
				addDateDays = addDateDays - myDate;
				myLastDay = addDateDays;
				lastCount = myLastDay;
			} else if (addDateDays == 30) {
				addDateDays = addDateDays - 30;
				myLastDay = 30;
				lastCount = addDateDays;
				myMonth = myMonth - 1;
			} else {
				if (lastAdd == true) {
					myLastDay = inputDays + myDate;
					lastCount = myLastDay;
				} else if (lastAdd == false) {
					eachIntAmt = 0;
					myLastDay = inputDays + myDate;
					lastCount = myLastDay - myDate + 1;
				}
			}
		}

		if (myMonth >= 12) {
			myMonth = 0;
			myYear = myYear + 1;
		}
		// alert(myYear);
		leapYr = myYear % 4;
		if (leapYr == 0) {
			PAtotalDays = 366;
			monthArray[1] = 29;
		} else {
			PAtotalDays = 365;
			monthArray[1] = 28;
		}
		// myMonth = myMonth-1;
		// myLastDay = (myDate+inputDays);
		// alert('myLastDay' + myLastDay);
		maturityValue = ((lastCount - 1) * rateOfInt * AmtValue)
				/ (PAtotalDays * 100);
		eachIntAmt = (parseFloat(eachIntAmt) + parseFloat(maturityValue))
				.toFixed(2);
		// console.log('Date-'+addDateDays + ' Month-'+shortMonthArray[myMonth] + '
		// =' + maturityValue.toFixed(2));
		// console.log('Date-'+addDateDays + ' Month-'+shortMonthArray[myMonth] + '
		// =' + 'Interest Capitalized ' + Math.round(maturityValue).toFixed(2));
		// console.log('Date-'+addDateDays + ' Month-'+shortMonthArray[myMonth] + '
		// =' + 'FD Balance ' + Math.round(FDint+maturityValue).toFixed(2));
		$('.tabs1 table').append(
				"<tr class='totalInt'><td>" + parseInt(myLastDay) + '-'
						+ shortMonthArray[myMonth - 1] + '-' + myYear
						+ "</td><td>" + maturityValue.toFixed(2) + "</td><td>"
						+ Math.round(eachIntAmt).toFixed(2) + "</td><td>"
						+ AmtValue.toFixed(2) + "</td></tr>");
		// alert("fsdfdsgdg")

		$('.dueDate').text(
				myLastDay + '-' + shortMonthArray[myMonth - 1] + '-' + myYear);
		$('.resultWrap .ouputValue').text(addCommas(AmtValue.toFixed(2)));
		$('.InterestWrap').show();
		$('.InterestWrap .ouputValue').text(
				addCommas(Math.round(FinTotalInt).toFixed(2)));

	}
}

function MonthlyPayout() {
	$('.tabs1 table').find('td').parent('tr').remove();
	PAtotalDays = 365;
	eachIntAmt = 0;
	eachTotalAmt = 0;
	totalIntAmt = 0;
	flag = true;

	var date = $("#dateOfDeposit").datepicker('getDate');
	myDate = date.getDate(); // Day of the month
	myMonth = date.getMonth() + 1; // Month with a zero index
	myDay = date.getDay(); // Day of the week
	myYear = date.getFullYear(); // The "full" year, e.g. 2011

	leapYr = myYear % 4;

	if (leapYr == 0) {
		PAtotalDays = 366;
		monthArray[1] = 29;
	} else {
		PAtotalDays = 365;
		monthArray[1] = 28;
	}

	// alert(myMonth);
	AmtValue = parseInt($('#principalAmt').val());
	// alert(thisMonthDays);
	inputMonth = parseInt($('#monthsPeriod').val());
	inputDays = parseInt($('#daysPeriod').val());
	// alert(inputMonth);
	addMonth = parseInt((myMonth - 1) + inputMonth);
	// alert(shortMonthArray[addMonth]);
	addDateDays = myDate + inputDays;
	addDays = myDate + addDateDays;

	// alert(addDateDays);
	if (myMonth == 1 || myMonth == 3 || myMonth == 5 || myMonth == 7
			|| myMonth == 8 || myMonth == 10 || myMonth == 12) {
		if (addDateDays >= 31) {
			// inputMonth = inputMonth + 1;
			plusMonth = 1;
		} else {
			plusMonth = 0;
		}
	} else if (myMonth == 2) {
		if (addDateDays >= 28) {
			// inputMonth = inputMonth + 1;
			plusMonth = 1;
		} else {
			plusMonth = 0;
		}
	} else {
		if (addDateDays >= 30) {
			// inputMonth = inputMonth + 1;
			plusMonth = 1;
		} else {
			plusMonth = 0;
		}
	}

	// alert('months' + myMonth);
	// if(catchUpdate==true){
	if (myMonth == 0 || myMonth == 1 || myMonth == 3 || myMonth == 5
			|| myMonth == 7 || myMonth == 8 || myMonth == 10 || myMonth == 12) {
		if (myDate == monthArray[myMonth - 1]) {
			// myDate = monthArray[myMonth];
			catchUpdate = false;
		} else {
			catchUpdate = true;
		}
	} else if (myMonth == 4 || myMonth == 6 || myMonth == 9 || myMonth == 11) {
		if (myDate == monthArray[myMonth - 1]) {
			// myDate = monthArray[myMonth];
			catchUpdate = false;
		} else {
			catchUpdate = true;
		}
	} else if (myMonth == 2) {
		if (myDate == monthArray[myMonth - 1]) {
			// myDate = monthArray[myMonth];
			catchUpdate = false;
		} else {
			catchUpdate = true;
		}
	}
	// }
	// alert(catchUpdate);

	$('.tabs1 table').append(
			"<tr><td>" + myDate + '-' + shortMonthArray[myMonth - 1] + '-'
					+ myYear + "</td><td>&nbsp;</td><td>&nbsp;</td><td>"
					+ AmtValue.toFixed(2) + "</td></tr>");

	captchupAmt = AmtValue;
	// FDint = totalIntAmt+AmtValue;

	for (var a = 0; a < inputMonth; a++) {
		eachIntAmt = 0;
		lastAdd = true;
		thisMonthDays = (monthArray[myMonth - 1]) - myDate + 1; // +1 to add
		// means
		// including
		// start date
		maturityValue = preciseRound((thisMonthDays * DisInt * AmtValue)
				/ (PAtotalDays * 100), 2);

		// console.log('Date-1' + ' Month-'+shortMonthArray[myMonth] + ' =' +
		// maturityValue.toFixed(2));
		$('.tabs1 table').append(
				"<tr><td>" + monthArray[myMonth - 1] + "-"
						+ shortMonthArray[myMonth - 1] + '-' + myYear
						+ "</td><td>" + maturityValue.toFixed(2)
						+ "</td><td>&nbsp;</td><td>" + AmtValue.toFixed(2)
						+ "</td></tr>");

		if (myMonth >= 12) {
			myMonth = 0;
			myYear = myYear + 1;
		}

		leapYr = myYear % 4;
		if (leapYr == 0) {
			PAtotalDays = 366;
			monthArray[1] = 29;
		} else {
			PAtotalDays = 365;
			monthArray[1] = 28;
		}
		eachIntAmt = eachIntAmt + maturityValue;
		// count++;
		// alert('count' + count);
		/*
		 * for(var i=0; i<2; i++) { a++; if(a==inputMonth){ i=2; flag = false; }
		 * else { myMonth = myMonth+1; maturityValue =
		 * (monthArray[myMonth-1]*DisInt*AmtValue)/(PAtotalDays*100); eachIntAmt =
		 * preciseRound((eachIntAmt + maturityValue),2); if( myMonth>=12) {
		 * myMonth = 0; myYear = myYear+1; } //alert(myYear); leapYr = myYear %
		 * 4; if(leapYr==0){ PAtotalDays = 366; monthArray[1]=29; } else {
		 * PAtotalDays = 365; monthArray[1]=28; } //console.log('Date-1' + '
		 * Month-'+shortMonthArray[myMonth] + ' =' + maturityValue.toFixed(2));
		 * $('.tabs1 table').append("<tr><td>1-"+shortMonthArray[myMonth]+'-'+myYear + "</td><td>" +
		 * maturityValue.toFixed(2) +"</td><td>&nbsp;</td><td>"+
		 * AmtValue.toFixed(2) +"</td></tr>"); } //alert('aj'+eachIntAmt);
		 * //alert('my a value' + a); }
		 */
		// alert("M " + a);
		if (a == $('#monthsPeriod').val()) {
			flag = false;
		}
		if (myMonth) {
			if (myDate > monthArray[myMonth]) {
				// alert(11);
				myDate = monthArray[myMonth];
			} else {
				// alert(22);
				myDate = date.getDate();
			}
		}

		if (flag != false) {

			withAccrual = false;

			if (catchUpdate == false) {
				myDate = monthArray[myMonth];
			}
			maturityValue = ((myDate - 1) * DisInt * AmtValue)
					/ (PAtotalDays * 100);
			// console.log('Date-'+myDate + ' Month-'+shortMonthArray[myMonth] +
			// ' =' + maturityValue.toFixed(2));
			eachIntAmt = preciseRound((eachIntAmt + maturityValue), 2);
			// console.log('Date-'+myDate + ' Month-'+shortMonthArray[myMonth] +
			// ' =' + 'Interest Capitalized ' +
			// Math.round(eachIntAmt).toFixed(2));

			captchupAmt = Math.round(AmtValue + eachIntAmt);

			totalIntAmt = Math.round(totalIntAmt + eachIntAmt);
			// alert('aaaa' + totalIntAmt);
			// FDint = preciseRound((totalIntAmt+AmtValue),2);
			// console.log('Date-'+myDate + ' Month-'+shortMonthArray[myMonth] +
			// ' =' + 'FD Balance ' + Math.round(FDint).toFixed(2));
			// console.log('Total Interest ' + totalIntAmt.toFixed(2));

			$('.tabs1 table').append(
					"<tr class='totalInt'><td>" + myDate + '-'
							+ shortMonthArray[myMonth] + '-' + myYear
							+ "</td><td>" + maturityValue.toFixed(2)
							+ "</td><td>" + Math.round(eachIntAmt).toFixed(2)
							+ "</td><td>" + AmtValue.toFixed(2) + "</td></tr>");
			// console.log('Total FD Balance ' + (totalIntAmt +
			// AmtValue).toFixed(2));
			lastAdd = false;
		}
		myMonth = myMonth + 1;
	}

	if (plusMonth == 1) {
		lastAdd = true;
		thisMonthDays = (monthArray[myMonth - 1]) - myDate + 1; // +1 to add
		// means
		// including
		// start date

		if (withAccrual == false) {
			eachIntAmt = 0;
			maturityValue = preciseRound((thisMonthDays * DisInt * AmtValue)
					/ (PAtotalDays * 100), 2);
		} else {
			maturityValue = preciseRound(
					(monthArray[myMonth - 1] * DisInt * AmtValue)
							/ (PAtotalDays * 100), 2);
		}

		// maturityValue = preciseRound((thisMonthDays * rateOfInt * FDint) /
		// (PAtotalDays * 100), 2);
		eachIntAmt = eachIntAmt + maturityValue;
		// console.log('Date-1' + ' Month-'+shortMonthArray[myMonth] + ' =' +
		// maturityValue.toFixed(2));
		$('.tabs1 table').append(
				"<tr><td>" + monthArray[myMonth - 1] + "-"
						+ shortMonthArray[myMonth - 1] + '-' + myYear
						+ "</td><td>" + maturityValue.toFixed(2)
						+ "</td><td>&nbsp;</td><td>" + AmtValue.toFixed(2)
						+ "</td></tr>");

		// myMonth = myMonth + 1;
		// alert(myMonth);
		addDateDays = monthArray[myMonth - 1] - myDate;
		// alert(addDateDays);
		if (catchUpdate == false) {
			myLastDay = inputDays;
		} else {
			myLastDay = inputDays - addDateDays;
		}
		// alert(myLastDay);
		lastCount = myLastDay;

		if (myLastDay < 0) {

			maturityValue = ((lastCount - 1) * DisInt * AmtValue)
					/ (PAtotalDays * 100);
			eachIntAmt = (parseFloat(eachIntAmt) + parseFloat(maturityValue))
					.toFixed(2);
			// console.log('Date-'+addDateDays + '
			// Month-'+shortMonthArray[myMonth] + ' =' +
			// maturityValue.toFixed(2));
			$('.tabs1 table').append(
					"<tr class='totalInt'><td>" + (monthArray[myMonth - 1] - 1)
							+ '-' + shortMonthArray[myMonth - 1] + '-' + myYear
							+ "</td><td>" + maturityValue.toFixed(2)
							+ "</td><td>" + Math.round(eachIntAmt).toFixed(2)
							+ "</td><td>" + AmtValue.toFixed(2) + "</td></tr>");

			$('.dueDate').text(
					(monthArray[myMonth - 1] - 1) + '-'
							+ shortMonthArray[myMonth - 1] + '-' + myYear);
			$('.resultWrap .ouputValue').text(addCommas(AmtValue.toFixed(2)));
			$('.InterestWrap').show();
			$('.InterestWrap .ouputValue').text(
					addCommas(Math.round(FinTotalInt).toFixed(2)));
		} else if (myLastDay == 0) {

			maturityValue = ((lastCount - 1) * DisInt * AmtValue)
					/ (PAtotalDays * 100);
			eachIntAmt = (parseFloat(eachIntAmt) + parseFloat(maturityValue))
					.toFixed(2);
			// console.log('Date-'+addDateDays + '
			// Month-'+shortMonthArray[myMonth] + ' =' +
			// maturityValue.toFixed(2));
			$('.tabs1 table').append(
					"<tr class='totalInt'><td>" + monthArray[myMonth - 1] + '-'
							+ shortMonthArray[myMonth - 1] + '-' + myYear
							+ "</td><td>" + maturityValue.toFixed(2)
							+ "</td><td>" + Math.round(eachIntAmt).toFixed(2)
							+ "</td><td>" + AmtValue.toFixed(2) + "</td></tr>");

			$('.dueDate').text(
					monthArray[myMonth - 1] + '-'
							+ shortMonthArray[myMonth - 1] + '-' + myYear);
			$('.resultWrap .ouputValue').text(addCommas(AmtValue.toFixed(2)));
			$('.InterestWrap').show();
			$('.InterestWrap .ouputValue').text(
					addCommas(Math.round(FinTotalInt).toFixed(2)));
		} else {
			// alert('myMonth ' + myMonth);

			if (myMonth >= 12) {
				myMonth = 0;
				myYear = myYear + 1;
			}
			// alert(myYear);
			leapYr = myYear % 4;
			if (leapYr == 0) {
				PAtotalDays = 366;
				monthArray[1] = 29;
			} else {
				PAtotalDays = 365;
				monthArray[1] = 28;
			}

			maturityValue = ((lastCount - 1) * DisInt * AmtValue)
					/ (PAtotalDays * 100);
			eachIntAmt = (parseFloat(eachIntAmt) + parseFloat(maturityValue))
					.toFixed(2);
			// console.log('Date-'+addDateDays + '
			// Month-'+shortMonthArray[myMonth] + ' =' +
			// maturityValue.toFixed(2));
			$('.tabs1 table').append(
					"<tr class='totalInt'><td>" + parseInt(myLastDay) + '-'
							+ shortMonthArray[myMonth] + '-' + myYear
							+ "</td><td>" + maturityValue.toFixed(2)
							+ "</td><td>" + Math.round(eachIntAmt).toFixed(2)
							+ "</td><td>" + AmtValue.toFixed(2) + "</td></tr>");

			$('.dueDate').text(
					myLastDay + '-' + shortMonthArray[myMonth] + '-' + myYear);
			$('.resultWrap .ouputValue').text(addCommas(AmtValue.toFixed(2)));
			$('.InterestWrap').show();
			$('.InterestWrap .ouputValue').text(
					addCommas(Math.round(FinTotalInt).toFixed(2)));
		}
	} else {
		// maturityValue = (inputDays*DisInt*FDint)/(PAtotalDays*100);
		// myLastDay = myDate+inputDays;
		// myMonth = myMonth - 1;
		// alert('ajMonth' + myMonth);
		// var shortMonthArray =
		// ['Jan1','Feb','Mar1','Apr','May1','Jun','July1','Aug1','Sept','Oct1','Nov','Dec1'];
		// eachIntAmt = 0;
		// alert(addDateDays);
		// alert(lastAdd);
		if (myMonth == 0 || myMonth == 1 || myMonth == 3 || myMonth == 5
				|| myMonth == 7 || myMonth == 8 || myMonth == 10
				|| myMonth == 12) {
			if (addDateDays > 31) {
				addDateDays = addDateDays - myDate;
				myLastDay = addDateDays;
				lastCount = myLastDay;
			} else if (addDateDays == 31) {
				addDateDays = addDateDays - 31;
				myLastDay = 31;
				lastCount = 0;
				if (myMonth == 0) {
					myMonth = 11;
					myYear = myYear - 1;
				} else {
					myMonth = myMonth - 1;
					myMonth == shortMonthArray[myMonth];
				}
			} else {
				if (lastAdd == true) {
					myLastDay = inputDays + myDate;
					lastCount = myLastDay;
				} else if (lastAdd == false) {
					eachIntAmt = 0;
					myLastDay = inputDays + myDate;
					lastCount = myLastDay - myDate + 1;
				}
			}
		} else if (myMonth == 2) {
			if (addDateDays > monthArray[1]) {
				addDateDays = addDateDays - myDate;
				myLastDay = addDateDays;
				lastCount = myLastDay;
			} else if (addDateDays == monthArray[1]) {
				addDateDays = addDateDays - myDate;
				myLastDay = monthArray[1];
				lastCount = addDateDays;
				myMonth = myMonth - 1;
			} else {
				if (lastAdd == true) {
					myLastDay = inputDays + myDate;
					lastCount = myLastDay;
				} else if (lastAdd == false) {
					eachIntAmt = 0;
					myLastDay = inputDays + myDate;
					lastCount = myLastDay - myDate + 1;
				}
			}
		} else if (myMonth == 4 || myMonth == 6 || myMonth == 9
				|| myMonth == 11) {
			if (addDateDays > 30) {
				addDateDays = addDateDays - myDate;
				myLastDay = addDateDays;
				lastCount = myLastDay;
			} else if (addDateDays == 30) {
				addDateDays = addDateDays - 30;
				myLastDay = 30;
				lastCount = addDateDays;
				myMonth = myMonth - 1;
			} else {
				if (lastAdd == true) {
					myLastDay = inputDays + myDate;
					lastCount = myLastDay;
				} else if (lastAdd == false) {
					eachIntAmt = 0;
					myLastDay = inputDays + myDate;
					lastCount = myLastDay - myDate + 1;
				}
			}
		}

		if (myMonth >= 12) {
			myMonth = 0;
			myYear = myYear + 1;
		}
		// alert(myYear);
		leapYr = myYear % 4;
		if (leapYr == 0) {
			PAtotalDays = 366;
			monthArray[1] = 29;
		} else {
			PAtotalDays = 365;
			monthArray[1] = 28;
		}
		// myMonth = myMonth-1;
		// myLastDay = (myDate+inputDays);
		// alert('myLastDay' + myLastDay);
		maturityValue = ((lastCount - 1) * DisInt * AmtValue)
				/ (PAtotalDays * 100);
		eachIntAmt = (parseFloat(eachIntAmt) + parseFloat(maturityValue))
				.toFixed(2);
		// console.log('Date-'+addDateDays + ' Month-'+shortMonthArray[myMonth] + '
		// =' + maturityValue.toFixed(2));
		// console.log('Date-'+addDateDays + ' Month-'+shortMonthArray[myMonth] + '
		// =' + 'Interest Capitalized ' + Math.round(maturityValue).toFixed(2));
		// console.log('Date-'+addDateDays + ' Month-'+shortMonthArray[myMonth] + '
		// =' + 'FD Balance ' + Math.round(FDint+maturityValue).toFixed(2));
		$('.tabs1 table').append(
				"<tr class='totalInt'><td>" + parseInt(myLastDay) + '-'
						+ shortMonthArray[myMonth - 1] + '-' + myYear
						+ "</td><td>" + maturityValue.toFixed(2) + "</td><td>"
						+ Math.round(eachIntAmt).toFixed(2) + "</td><td>"
						+ AmtValue.toFixed(2) + "</td></tr>");
		// alert("fsdfdsgdg")

		$('.dueDate').text(
				myLastDay + '-' + shortMonthArray[myMonth - 1] + '-' + myYear);
		$('.resultWrap .ouputValue').text(addCommas(AmtValue.toFixed(2)));
		$('.InterestWrap').show();
		$('.InterestWrap .ouputValue').text(
				addCommas(Math.round(FinTotalInt).toFixed(2)));

	}
}

function ShortTermFD() {
	$('.tabs1 table').find('td').parent('tr').remove();
	PAtotalDays = 365;
	eachIntAmt = 0;
	eachTotalAmt = 0;
	totalIntAmt = 0;
	flag = true;

	var date = $("#dateOfDeposit").datepicker('getDate');
	myDate = date.getDate(); // Day of the month
	myMonth = date.getMonth() + 1; // Month with a zero index
	myDay = date.getDay(); // Day of the week
	myYear = date.getFullYear(); // The "full" year, e.g. 2011

	leapYr = myYear % 4;

	if (leapYr == 0) {
		PAtotalDays = 366;
		monthArray[1] = 29;
	} else {
		PAtotalDays = 365;
		monthArray[1] = 28;
	}

	// alert(myMonth);
	AmtValue = parseInt($('#principalAmt').val());
	inputDays = parseInt($('#daysPeriod').val());

	var sameMonthDay = monthArray[myMonth - 1] - (myDate + inputDays);
	// alert(sameMonthDay);

	addDateDays = myDate + inputDays;
	// console.log('Date-'+myDate + ' Month-'+shortMonthArray[myMonth-1]);
	$('.tabs1 table').append(
			"<tr><td>" + myDate + '-' + shortMonthArray[myMonth - 1] + '-'
					+ myYear + "</td><td>&nbsp;</td><td>&nbsp;</td><td>"
					+ AmtValue.toFixed(2) + "</td></tr>");

	// alert(sameMonthDay);

	if (sameMonthDay >= 0) {
		maturityValue = preciseRound((inputDays * rateOfInt * AmtValue)
				/ (PAtotalDays * 100), 2);
		eachIntAmt = preciseRound((eachIntAmt + maturityValue), 2);
		$('.tabs1 table').append(
				"<tr><td>" + addDateDays + "-" + shortMonthArray[myMonth - 1]
						+ '-' + myYear + "</td><td>" + maturityValue.toFixed(2)
						+ "</td><td>" + Math.round(eachIntAmt).toFixed(2)
						+ "</td><td>"
						+ Math.round(eachIntAmt + AmtValue).toFixed(2)
						+ "</td></tr>");
		/*
		 * if (myMonth >= 12) { myMonth = myMonth - 1; //myYear = myYear+1; }
		 */
		myMonth = myMonth - 1;
		lastShortTermCount = addDateDays - 1;
	} else {
		for (var a = 0; a < 1; a++) {
			eachIntAmt = 0;
			lastAdd = true;
			thisMonthDays = (monthArray[myMonth - 1]) - myDate + 1; // +1 to add
			// means
			// including
			// start
			// date
			maturityValue = preciseRound((thisMonthDays * rateOfInt * AmtValue)
					/ (PAtotalDays * 100), 2);
			eachIntAmt = preciseRound((eachIntAmt + maturityValue), 2);
			if (myMonth > 12) {
				myMonth = 1;
				myYear = myYear + 1;
			}

			leapYr = myYear % 4;
			if (leapYr == 0) {
				PAtotalDays = 366;
				monthArray[1] = 29;
			} else {
				PAtotalDays = 365;
				monthArray[1] = 28;
			}

			// console.log('Date-1' + ' Month-'+shortMonthArray[myMonth-1] + '
			// =' + maturityValue.toFixed(2));
			$('.tabs1 table').append(
					"<tr><td>" + monthArray[myMonth - 1] + '-'
							+ shortMonthArray[myMonth - 1] + '-' + myYear
							+ "</td><td>" + maturityValue.toFixed(2)
							+ "</td><td>&nbsp;</td><td>" + AmtValue.toFixed(2)
							+ "</td></tr>");

			// alert('a Before - '+a);
			a = a + thisMonthDays;
			// alert('a After - '+a);

			for (var i = a; i <= inputDays; i++) {

				myMonth = myMonth + 1;
				if (myMonth > 12) {
					myMonth = 1;
					myYear = myYear + 1;
				}

				leapYr = myYear % 4;
				if (leapYr == 0) {
					PAtotalDays = 366;
					monthArray[1] = 29;
				} else {
					PAtotalDays = 365;
					monthArray[1] = 28;
				}
				// console.log('month ' + myMonth);
				// console.log('i ' + i);
				if (myMonth == 0 || myMonth == 1 || myMonth == 3
						|| myMonth == 5 || myMonth == 7 || myMonth == 8
						|| myMonth == 10 || myMonth == 12) {

					i = (i + 31) - 1;
					if (i < inputDays) {

						maturityValue = (monthArray[myMonth - 1] * rateOfInt * AmtValue)
								/ (PAtotalDays * 100);
						eachIntAmt = preciseRound((eachIntAmt + maturityValue),
								2);
						if (myMonth > 12) {
							myMonth = 1;
							myYear = myYear + 1;
						}

						leapYr = myYear % 4;
						if (leapYr == 0) {
							PAtotalDays = 366;
							monthArray[1] = 29;
						} else {
							PAtotalDays = 365;
							monthArray[1] = 28;
						}
						// console.log('eachIntAmt ' + eachIntAmt);
						// console.log('Date-1' + '
						// Month-'+shortMonthArray[myMonth-1] + ' =' +
						// maturityValue.toFixed(2));
						$('.tabs1 table').append(
								"<tr><td>" + monthArray[myMonth - 1] + '-'
										+ shortMonthArray[myMonth - 1] + '-'
										+ myYear + "</td><td>"
										+ maturityValue.toFixed(2)
										+ "</td><td>&nbsp;</td><td>"
										+ AmtValue.toFixed(2) + "</td></tr>");
					} else {
						lastShortTermCount = inputDays - ((i - 31) + 1);
						// myMonth = myMonth - 1;
						// console.log('lastShortTermCount ' +
						// lastShortTermCount);

						i = inputDays;
					}
				} else if (myMonth == 2) {
					i = (i + monthArray[1]) - 1;
					if (i < inputDays) {

						maturityValue = (monthArray[myMonth - 1] * rateOfInt * AmtValue)
								/ (PAtotalDays * 100);
						eachIntAmt = preciseRound((eachIntAmt + maturityValue),
								2);

						// console.log('eachIntAmt ' + eachIntAmt);
						// console.log('Date-1' + '
						// Month-'+shortMonthArray[myMonth-1] + ' =' +
						// maturityValue.toFixed(2));
						$('.tabs1 table').append(
								"<tr><td>" + monthArray[myMonth - 1] + '-'
										+ shortMonthArray[myMonth - 1] + '-'
										+ myYear + "</td><td>"
										+ maturityValue.toFixed(2)
										+ "</td><td>&nbsp;</td><td>"
										+ AmtValue.toFixed(2) + "</td></tr>");
					} else {
						// alert('i ' +i);
						lastShortTermCount = inputDays
								- ((i - monthArray[1]) + 1);
						// alert('lastShortTermCount ' +lastShortTermCount);
						// myMonth = myMonth - 1;
						// console.log('i ' + i);

						i = inputDays;
					}
				} else if (myMonth == 4 || myMonth == 6 || myMonth == 9
						|| myMonth == 11) {
					i = (i + 30) - 1;
					if (i < inputDays) {

						maturityValue = (monthArray[myMonth - 1] * rateOfInt * AmtValue)
								/ (PAtotalDays * 100);
						eachIntAmt = preciseRound((eachIntAmt + maturityValue),
								2);

						// console.log('eachIntAmt ' + eachIntAmt);
						// console.log('Date-1' + '
						// Month-'+shortMonthArray[myMonth-1] + ' =' +
						// maturityValue.toFixed(2));
						$('.tabs1 table').append(
								"<tr><td>" + monthArray[myMonth - 1] + '-'
										+ shortMonthArray[myMonth - 1] + '-'
										+ myYear + "</td><td>"
										+ maturityValue.toFixed(2)
										+ "</td><td>&nbsp;</td><td>"
										+ AmtValue.toFixed(2) + "</td></tr>");
					} else {
						lastShortTermCount = inputDays - ((i - 30) + 1);
						// myMonth = myMonth - 1;
						// console.log('i ' + i);
						// console.log('lastShortTermCount ' +
						// lastShortTermCount);

						i = inputDays;
					}
				}
			}

			if (lastShortTermCount < 0) {
				myMonth = myMonth - 1;
				var lastDate = monthArray[myMonth] - 1;

				maturityValue = (lastShortTermCount * rateOfInt * AmtValue)
						/ (PAtotalDays * 100);
				eachIntAmt = preciseRound((eachIntAmt + maturityValue), 2);
				// console.log('Date-1' + ' Month-'+shortMonthArray[myMonth] + '
				// =' + maturityValue.toFixed(2));
				$('.tabs1 table').append(
						"<tr><td>" + (lastDate + 1) + "-"
								+ shortMonthArray[myMonth - 1] + '-' + myYear
								+ "</td><td>" + maturityValue.toFixed(2)
								+ "</td><td>"
								+ Math.round(eachIntAmt).toFixed(2)
								+ "</td><td>"
								+ Math.round(eachIntAmt + AmtValue).toFixed(2)
								+ "</td></tr>");

				flag = false;
			}

			if (flag != false) {
				maturityValue = (lastShortTermCount * rateOfInt * AmtValue)
						/ (PAtotalDays * 100);
				eachIntAmt = preciseRound((eachIntAmt + maturityValue), 2);
				// console.log('Date-1' + ' Month-'+myMonth + ' =' +
				// maturityValue.toFixed(2));
				$('.tabs1 table').append(
						"<tr><td>" + (lastShortTermCount + 1) + "-"
								+ shortMonthArray[myMonth - 1] + '-' + myYear
								+ "</td><td>" + maturityValue.toFixed(2)
								+ "</td><td>"
								+ Math.round(eachIntAmt).toFixed(2)
								+ "</td><td>"
								+ Math.round(eachIntAmt + AmtValue).toFixed(2)
								+ "</td></tr>");
			}

		}
	}

	$('.dueDate').text(
			(lastShortTermCount + 1) + '-' + shortMonthArray[myMonth - 1] + '-'
					+ myYear);
	$('.resultWrap label').eq(0).text('Principal + Interest');
	$('.resultWrap .ouputValue').text(
			addCommas(Math.round(eachIntAmt + AmtValue).toFixed(2)));
	$('.InterestWrap').show();
	$('.InterestWrap .ouputValue').text(
			addCommas(Math.round(FinTotalInt).toFixed(2)));

}

var thisInt, thisMonth, startYear, thisYear, totalYearInt, prevMonth;
var FinTotalInt = 0;
var count = 0;

/* Only for Number */
function validateNumber(event) {
	var charCode = event.which;
	if (charCode > 47 && charCode < 58 || charCode == 0 || charCode == 8) {
		return true;
	} else {
		return false;
	}
};

/* Only for Number with dot */
function validateNumber1(event) {
	var charCode = event.which;
	if (charCode == 46) {
		return true
	}
	if (charCode > 47 && charCode < 58 || charCode == 0 || charCode == 8) {
		return true;
	} else {
		return false;
	}
};
// Method to format numbers
function addCommas(nStr) {
	nStr += '';
	x = nStr.split('.');
	x1 = x[0];
	x2 = x.length > 1 ? '.' + x[1] : '';
	var rgx = /(\d+)(\d{3})/;
	while (rgx.test(x1)) {
		x1 = x1.replace(rgx, '$1' + ',' + '$2');
	}
	return x1 + x2;
}
// Method to round value upto 2 decimal
function preciseRound(num, decimals) {
	//alert ('Inside preciseRound');
	//alert ('num:'+num);
	//alert ('decimals:'+decimals);
	return Math.round(num * Math.pow(10, decimals)) / Math.pow(10, decimals);
}

$(window).load(function() {
	$(".custRadio span").eq(1).removeClass('uncheked').addClass('cheked');

});