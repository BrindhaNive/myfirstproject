<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en" class=" ">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bank Of Co-operative Society</title>
<!-- Bootstrap -->
<spring:url value="/resources/dashboard/css/bootstrap.min.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<!-- Font Awesome -->
<spring:url value="/resources/dashboard/css/font-awesome.min.css" var="awesomeCss" />
<link href="${awesomeCss}" rel="stylesheet" />
<!-- Custom Theme Style -->
<spring:url value="/resources/dashboard/css/custom.min.css" var="customCss" />
<link href="${customCss}" rel="stylesheet" />
<spring:url value="/resources/dashboard/css/jquery-ui.min.css" var="jqueryui" />
<link href="${jqueryui}" rel="stylesheet" />
<spring:url value="/resources/dashboard/css/jquery-ui.structure.min.css" var="jqueryuistruc" />
<link href="${jqueryuistruc}" rel="stylesheet" />
<spring:url value="/resources/dashboard/css/jquery-ui.theme.min.css" var="jquerytheme" />
<link href="${jquerytheme}" rel="stylesheet" />
</head>
<body class="nav-md" id="funding-dahsboard">
	<div class="container body">
		<div class="main_container">
			<%@ include file="/WEB-INF/pages/generic.jsp"%>
			<!-- page content -->
			<div class="right_col" role="main" style="min-height: 1642.8px;">
				<!-- top tiles -->
				<div class="row clearfix">
					<div class="clearfix workforce-table">
						<ul class="nav nav-tabs" id="myTabs">
							<li class="active"><a href="#fte" id="fte-tab" role="tab" data-toggle="tab">Add Account</a></li>
							<li><a href="#workforce" role="tab" id="workforce-tab" data-toggle="tab">View/Edit Account</a></li>
							<li><a href="#leadership" role="tab" id="leadership-tab" data-toggle="tab">Disable Account</a></li>
						</ul>
						<div class="tab-content" id="myTabContent">
							<div class="tab-pane fade in active" id="fte">
								<div class="employee-block">
									<div class="container">
										<div class="row">
											<div class="col-md-12" id="main">
												<!-- Selects -->
												<div class="panel panel-primary">
													<div class="panel-heading" id="basepanel">
														<h4 class="panel-title">Fixed Deposits</h4>
													</div>
													<div class="panel-body">
														<!-- TO DO : Replace with Spring form -->
														<form:form class="form-horizontal" id="fixedDepositAdd" modelAttribute="fdCommandForm" commandName="fdCommandForm" method="post" name="fixedDepositAdd" action="">
															<fieldset>
																<!-- Search input-->
																<div class="form-group">
																	<label class="col-md-4 control-label" for="searchinput">Membership ID</label>
																	<div class="col-md-5">
																		<form:hidden path="membershipId" name="membershipId"/>
																			<input type="text"  id="membershipIdsug" name="membershipIdsug" value="">
																	</div>
																</div>

																<div class="form-group">
																	<label class="col-md-4 control-label" for="schemeType">Scheme Type</label>
																	<div class="col-md-5">
																		<form:select path="selectedFdSchemeTypeId">
																			<form:option value="0" label="--- Select ---" />
																			<form:options items="${schemeTypeMap}" />
																		</form:select>
																	</div>
																</div>

															</fieldset>
															<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
																<div class="panel panel-primary">
																	<div class="panel-heading" role="tab" id="headingOne">
																		<h4 class="panel-title">
																			<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne"> Member General Details </a>
																		</h4>
																	</div>
																	<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
																		<div class="panel-body">
																			<div class="form-group">
																				<label id="memName" class="col-md-4 control-label" for="searchinput">Membership Name</label> <label id="memAccNo" class="col-md-4 control-label" for="searchinput">Member Account Number</label> <label id="memid" class="col-md-4 control-label" for="searchinput">Membership
																					ID</label>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="panel panel-primary">
																	<div class="panel-heading" role="tab" id="headingTwo">
																		<h4 class="panel-title">
																			<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo"> Nominee Details </a>
																		</h4>
																	</div>
																	<div id="collapseTwo" class="panel-collapse in" role="tabpanel" aria-labelledby="headingTwo">
																		<div class="panel-body">
																			<table class="table table-bordered headcount-table">
																				<tbody>
																					<tr>
																						<td class="col-md-1">First Name</td>
																						<td class="col-md-1"><form:input path="firstName" name="firstName" placeholder="Enter First name" class="form-control input-md" /></td>
																						<td class="col-md-1">Last Name</td>
																						<td class="col-md-1"><form:input path="lastName" name="lastName" placeholder="Enter Last name" class="form-control input-md" /></td>
																					</tr>
																					<tr>
																						<td class="col-md-1">Nominee Relationship</td>
																						<td class="col-md-1"><form:select path="relationship">
																								<form:option value="0" label="--- Select ---" />
																								<form:options items="${nomineeMap}" />
																							</form:select></td>
																						<td class="col-md-1">Aadhaar ID</td>
																						<td class="col-md-1"><form:input path="aadharId" name="aadharId" placeholder="Enter Aadhar Id" class="form-control input-md" /></td>
																					</tr>
																					<tr>
																						<td class="col-md-1">Address One</td>
																						<td class="col-md-1"><form:input path="addressOne" name="addressOne" placeholder="Enter Address One" class="form-control input-md" /></td>
																						<td class="col-md-1">Address Two</td>
																						<td class="col-md-1"><form:input path="addressTwo" name="addressTwo" placeholder="Enter Address Two" class="form-control input-md" /></td>
																					</tr>
																					<tr>
																						<td class="col-md-1">City</td>
																						<td class="col-md-1"><form:input path="city" name="city" placeholder="Enter city" class="form-control input-md" /></td>
																						<td class="col-md-1">State</td>
																						<td class="col-md-1"><form:input path="state" name="state" placeholder="Enter state" class="form-control input-md" /></td>
																					</tr>
																					<tr>
																						<td class="col-md-1">Pincode</td>
																						<td class="col-md-1"><form:input path="pincode" name="pincode" placeholder="Enter pincode" class="form-control input-md" /></td>
																					</tr>
																				</tbody>
																			</table>

																		</div>
																	</div>
																</div>
																<div class="panel panel-primary">
																	<div class="panel-heading" role="tab" id="headingThree">
																		<h4 class="panel-title">
																			<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree"> Deposit / installment Details </a>
																		</h4>
																	</div>
																	<div id="collapseThree" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingThree">
																		<div class="panel-body">

																			<table class="table table-bordered headcount-table">
																				<tbody>
																					<tr>
																						<td class="col-md-1">Principal / Amount</td>
																						<td class="col-md-1"><form:input path="principalAmt" name="principalAmt" placeholder="Amount" class="form-control input-md" /></td>
																						<td class="col-md-1">Account open Date</td>
																						<td class="col-md-1"><form:input path="acctOpenDate" name="acctOpenDate" class="form-control input-md" /></td>
																					</tr>
																					<tr>
																						<td class="col-md-1">Date of Deposit</td>
																						<td class="col-md-1"><form:input path="dateOfDeposit" name="dateOfDeposit" placeholder="Select Date" class="form-control input-md" /></td>
																						<td class="col-md-1">Deposit Period</td>

																						<td class="count-bg col-md-1">days <form:input path="daysPeriod" name="daysPeriod" value="0" class="form-control input-md" /> month <form:input path="monthsPeriod" name="monthsPeriod" value="0"
																								class="form-control input-md" /></td>
																					<tr>
																						<td class="col-md-1">Maturity Date</td>
																						<td class="col-md-1"><form:input path="maturityDate" name="maturityDate" class="form-control input-md" /></td>
																						<td class="col-md-1">Rate of interest</td>
																						<td class="col-md-1"><form:input style="border:none;" id="ROI" path="rateOfInterest" tabindex="0" readonly="true" /></td>
																					</tr>
																				</tbody>
																			</table>
																			<a href="javascript:;" class="btn btn-primary" id="calculateBtn" title="Calculate"> <span class="glyphicon"></span> &nbsp;Calculate FD
																			</a>
																		</div>
																	</div>
																</div>
																<div class="panel panel-primary">
																	<div class="panel-heading" role="tab" id="headingFour">
																		<h4 class="panel-title">
																			<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">FD Calculation Details </a>
																		</h4>
																	</div>
																	<div id="collapseFour" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingFour">
																		<div class="panel-body">
																			<div class="tableWrapper">
																				<div class="tableOutputWrap">
																					<div class="resultWrap">
																						<div class="innerBox">
																							<label> Maturity Value</label><span class="ouputValue"></span>
																						</div>
																						<div class="innerBox">
																							<label> Due Date</label><span class="dueDate"></span>
																						</div>
																					</div>
																					<div class="InterestWrap">
																						<div class="innerBox">
																							<label> Aggregate Interest Amount</label><span class="ouputValue"></span>
																						</div>
																					</div>

																					<div class="tableWrap">
																						<div class="tabs1">
																							<table width="100%" border="0" cellspacing="0" cellpadding="0">
																								<tr>
																									<th>Date</th>
																									<th>Interest Amount</th>
																									<th>Interest Capitalized</th>
																									<th>FD Balance</th>
																									<th>Transaction Type</th>
																								</tr>
																							</table>
																						</div>
																					</div>

																					<a onclick="javascript:fdSubmit()" class="btn btn-primary" id="submitFD" title="submitFD"> <span class="glyphicon"></span> &nbsp;Submit FD
																					</a>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>

														</form:form>

													</div>

												</div>

												<!-- End of Selects -->

											</div>

										</div>
									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="workforce">
								<div class="employee-block">Tab2</div>
							</div>
							<div class="tab-pane fade" id="leadership">
								<div class="employee-block">Tab3</div>
							</div>
						</div>
					</div>


				</div>


			</div>
			<!-- /page content -->

			<!-- footer content -->
			<footer>
				<div class="pull-right"></div>
				<div class="clearfix"></div>
			</footer>
			<!-- /footer content -->
		</div>
	</div>

	<!-- jQuery -->
	<spring:url value="/resources/dashboard/js/jquery.min.js" var="jqueryJs" />
	<script src="${jqueryJs}"></script>
	<!-- Bootstrap -->
	<spring:url value="/resources/dashboard/js/bootstrap.min.js" var="bootstrapJs" />
	<script src="${bootstrapJs}"></script>
	<!-- Custom Theme Scripts -->
	<spring:url value="/resources/dashboard/js/custom.min.js" var="customJs" />
	<script src="${customJs}"></script>
	<spring:url value="/resources/dashboard/js/calendar.js" var="calenderJs" />
	<script src="${calenderJs}"></script>
	<spring:url value="/resources/dashboard/js/jquery-ui.min.js" var="jqueryui" />
	<script src="${jqueryui}"></script>

	<spring:url value="/resources/dashboard/js/moments.js" var="moments" />
	<script src="${moments}"></script>

	<spring:url value="/resources/dashboard/js/fixed-deposit.js" var="fixeddeposit" />
	<script src="${fixeddeposit}"></script>
	
	<spring:url value="/resources/dashboard/js/jquery.autocomplete.min.js" var="autocmplete" />
	<script src="${autocmplete}"></script>
	
	
	<!-- echart Theme Scripts -->
	<script type="text/javascript">
	$(function() {
		$('#acctOpenDate')
				.datepicker(
						{
							dateFormat : 'yy-mm-dd',
							minDate : 0,
							showAnim : 'slideDown',
							showOn : "both",
							buttonImage : "/resources/dashboard/images/icon-calendar.png",
							buttonImageOnly : true,
							buttonText : ""
						}).datepicker("setDate", new Date());
	});
		$(function() {
			$('#dateOfDeposit')
					.datepicker(
							{
								dateFormat : 'yy-mm-dd',
								minDate : 0,
								showAnim : 'slideDown',
								showOn : "both",
								buttonImage : "/resources/dashboard/images/icon-calendar.png",
								buttonImageOnly : true,
								buttonText : "",
								onSelect : function() {
									var date = new Date($("#dateOfDeposit")
											.val()), days = parseInt($(
											"#daysPeriod").val(), 10);
									var momentDate = moment(date);
									momentDate.add(days, 'days');
									var monthperiod = $("#monthsPeriod").val();
									momentDate.add(monthperiod, 'months');
									var maturityDatemom = momentDate
											.format('YYYY-MM-DD');
									$("#maturityDate").val(maturityDatemom);
								}
							}).datepicker("setDate", new Date());
		});
		;
		(function($, window, document, undefined) {
			$("#daysPeriod")
					.on(
							"change",
							function() {
								var date = new Date($("#dateOfDeposit").val()), days = parseInt(
										$("#daysPeriod").val(), 10);
								var momentDate = moment(date);
								momentDate.add(days, 'days');
								var monthperiod = $("#monthsPeriod").val();
								momentDate.add(monthperiod, 'months');
								var maturityDatemom = momentDate
										.format('YYYY-MM-DD');
								$("#maturityDate").val(maturityDatemom);
							});
			$("#monthsPeriod")
					.on(
							"change",
							function() {
								var date = new Date($("#dateOfDeposit").val()), days = parseInt(
										$("#daysPeriod").val(), 10);
								var momentDate = moment(date);
								momentDate.add(days, 'days');
								var monthperiod = $("#monthsPeriod").val();
								momentDate.add(monthperiod, 'months');
								var maturityDatemom = momentDate
										.format('YYYY-MM-DD');
								$("#maturityDate").val(maturityDatemom);
							});
		})(jQuery, this, document);
		
		$(document).ready(function() {
			$('#membershipIdsug').autocomplete({
				serviceUrl: '${pageContext.request.contextPath}/getmembershipsuggestion',
				paramName: "searchValue",
				delimiter: ",",
				onSelect: function(suggestion) {
		            memId = suggestion.data;
		            memname = suggestion.name;
		            memaccno = suggestion.accno;
		            $("#membershipId").val(memId);
		            $("#memid").append("  :  ").append(memId);
		            $("#memAccNo").append("  :  ").append(memaccno);
		            $("#memName").append("  :  ").append(memname);
		            return false;
		        },
			    transformResult: function(response) {
			        return {
			            suggestions: $.map($.parseJSON(response), function(item) {
			            	
			                return { value: item.memDispName, data: item.membershipId, name: item.membershipName , accno: item.membershipAcctNum };
			            })
			            
			        };
			        
			    }
			    
			});
			
			
		});
	</script>

	<style type="text/css">
#accordion .panel-heading {
	padding: 0;
}

#accordion .panel-title>a {
	display: block;
	padding: 0.4em 0.6em;
	outline: none;
	font-weight: bold;
	text-decoration: none;
}

#accordion .panel-title>a.accordion-toggle::before, #accordion a[data-toggle="collapse"]::before
	{
	content: "\e113";
	float: left;
	font-family: 'Glyphicons Halflings';
	margin-right: 1em;
}

#accordion .panel-title>a.accordion-toggle.collapsed::before, #accordion a.collapsed[data-toggle="collapse"]::before
	{
	content: "\e114";
}

/* Nav */
.workforce-table .nav {
	border-bottom: 0px;
	margin-left: -1px;
}

.workforce-table .nav li {
	position: relative;
	z-index: 1;
	display: block;
	margin: 0;
	text-align: center;
	-webkit-flex: 1;
	-moz-flex: 1;
	-ms-flex: 1;
	flex: 1;
}

.workforce-table .nav a {
	position: relative;
	display: block;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	line-height: 2.5;
	padding: 10px 45px 10px 36px;
	font-size: 15px;
}

.workforce-table .nav li.active a {
	color: #74777b;
}

.workforce-table .nav li {
	-webkit-backface-visibility: hidden;
	backface-visibility: hidden;
	margin-left: -8px;
}

.workforce-table .nav li:first-child {
	margin-left: 0px;
}

.workforce-table .nav li a {
	color: #fff;
	-webkit-transition: color 0.2s;
	transition: color 0.2s;
}

.workforce-table .nav li a:hover, .workforce-table .nav li a:focus {
	color: #fff;
	background: transparent;
	border-color: transparent;
}

.workforce-table .nav li.active a, .workforce-table .nav li.active a:hover
	{
	color: #2889c5;
	background: transparent;
	border-color: transparent;
}

.workforce-table .nav li a::after {
	position: absolute;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	z-index: -1;
	outline: none;
	border: 1px solid #ddd;
	border-bottom: 0px;
	border-radius: 10px 10px 0 0;
	background: #2889c5;
	box-shadow: inset 0 -3px 3px rgba(0, 0, 0, 0.05);
	content: '';
	-webkit-transform: perspective(5px) rotateX(0.93deg) translateZ(-1px);
	transform: perspective(5px) rotateX(0.93deg) translateZ(-1px);
	-webkit-transform-origin: 0 0;
	transform-origin: 0 0;
	-webkit-backface-visibility: hidden;
	backface-visibility: hidden;
}

.workforce-table .nav li.active a::after, .workforce-table .tab-content
	{
	background: #fff;
	box-shadow: none;
}

.workforce-table .tab-content {
	border: 1px solid #ddd;
	margin-top: -4px;
}

.tab-content .employee-block {
	padding: 15px;
}

.headcount-table>thead>tr>th.head-block {
	background: #48a6e0;
	color: #fff;
}

.headcount-table>thead>tr>th {
	background: #eae7e7;
}

.headcount-table>tbody>tr>td.count-bg, .headcount-table tr th.count-bg {
	background: #dce6f1;
}

.headcount-table>thead>tr>th, .headcount-table>tbody>tr>td {
	padding: 5px;
}

.headcount-table>tbody>tr>td, .headcount-table>tbody>tr>th,
	.headcount-table>tfoot>tr>td, .headcount-table>tfoot>tr>th,
	.headcount-table>thead>tr>td, .headcount-table>thead>tr>th {
	border-color: #c3c1c1;
}

.headcount-table .text-muted {
	color: #bbb;
}

.headcount-table .col-md-3 {
	width: 70px;
}

.headcount-table .col-md-1 {
	width: 50px;
	text-align: center;
}

select {
	background-color: #7dc8ec;
	border: thin solid #4d9ec5;
	color: #fff;
	border-radius: 4px;
	display: inline-block;
	font: inherit;
	line-height: 1.5em;
	padding: 0.5em 3.5em 0.5em 1em;
	margin: 0;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	-webkit-appearance: none;
	-moz-appearance: none;
}
/* arrows */
select.classic {
	background-image: linear-gradient(45deg, transparent 50%, white 50%),
		linear-gradient(135deg, white 50%, transparent 50%),
		linear-gradient(to right, #48a8d6, #48a8d6);
	background-position: calc(100% - 20px) calc(1em + 2px),
		calc(100% - 15px) calc(1em + 2px), 100% 0;
	background-size: 5px 5px, 5px 5px, 2.5em 2.5em;
	background-repeat: no-repeat;
}

select.classic option {
	background: #fff;
	border-color: #fff;
	color: #73879C;
}

select.classic:focus {
	background-image: linear-gradient(45deg, white 50%, transparent 50%),
		linear-gradient(135deg, transparent 50%, white 50%),
		linear-gradient(to right, #48a8d6, #48a8d6);
	background-position: calc(100% - 15px) 1em, calc(100% - 20px) 1em, 100%
		0;
	background-size: 5px 5px, 5px 5px, 2.5em 2.5em;
	background-repeat: no-repeat;
	border-color: grey;
	outline: 0;
}

select:-moz-focusring {
	color: transparent;
	text-shadow: 0 0 0 #000;
}
</style>




	<style type="text/css">
.nav.side-menu>li.active, .nav.side-menu>li.current-page {
	border-color: #41b2e1;
}

.nav-md .vplist-menu ul.nav.child_menu li:before {
	background: #337ab7;
}

.nav-md .vplist-menu ul.nav.child_menu li:after {
	border-color: #337ab7;
}

.toggle a.toggle-btn {
	margin-top: -16px;
	height: 57px;
	border: none;
	border-radius: 0px;
	background-color: #EDEDED
}

.toggle a.toggle-btn i {
	font-size: 20px;
	line-height: 27px;
	color: #333
}

.nav-sm .toggle a.toggle-btn i {
	transform: rotate(180deg);
	-webkit-transform: rotate(180deg);
	-moz-transform: rotate(180deg);
	-mz-transform: rotate(180deg);
}

.headcount-table>thead>tr>th, .headcount-table>thead>tr>th {
	border-bottom-width: 1px;
}

.headcount-table thead tr th, .headcount-table thead tr td {
	text-align: center;
}
.autocomplete-suggestions { border: 1px solid #999; background: #FFF; overflow: auto; }
.autocomplete-suggestion { padding: 5px 5px; white-space: nowrap; overflow: hidden; font-size:22px}
.autocomplete-selected { background: #F0F0F0; }
.autocomplete-suggestions strong { font-weight: bold; color: #3399FF; }
</style>


</body>
</html>