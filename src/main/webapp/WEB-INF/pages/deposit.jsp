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
</head>

<body class="nav-md" id="funding-dahsboard">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="#" class="site_title bg-primary"><img src="/resources/dashboard/bcs2.png" style="width: 43px; height: 43px; margin-right: 5px;"><span></span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile clearfix">
						<div class="profile_pic">
							<img src="/resources/dashboard/images/img.jpg" alt="..." class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>Welcome,</span>
							<h2>
								<c:out value="${baseCommandForm.pacsPortalUser.fullName}" />
							</h2>
						</div>
					</div>
					<!-- /menu profile quick info -->

					<br>

					<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
						<div class="menu_section active">
							<ul class="nav side-menu">
								<li><a href="#"> <i class="fa fa-money"></i> Membership
								</a></li>

								<li class="vplist-menu"><a><i class="fa fa-group"></i> Deposit <span class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="deposit">Account opening</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
					<!-- /sidebar menu -->
					<!-- /sidebar menu -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav bg-primary">
				<span style="font-size: 20px; cursor: pointer"><i class="fa fa-university" aria-hidden="true"></i> Bank of Cooperative Society </span>
				<div class="nav_menu">
					<nav>
						<div class="nav toggle">
							<a id="menu_toggle" class="btn btn-primary toggle-btn"><i class="fa fa-backward"></i></a>
						</div>

						<ul class="nav navbar-nav navbar-right">
							<li class=""><a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> <img src="/resources/dashboard/images/img.jpg" alt="">Marc Gordon <span class=" fa fa-angle-down"></span>
							</a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">
									<li><a href="#">Help</a></li>
									<li><a href="#"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
								</ul></li>

						</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->

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
																		<form:input path="membershipId" name="membershipId" type="search" placeholder="Enter name or membership ID" class="form-control input-md" />
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
																				<label class="col-md-4 control-label" for="searchinput">Membership Name</label>
																				<label class="col-md-4 control-label" for="searchinput">Member Account Number</label>
																				<label class="col-md-4 control-label" for="searchinput">Membership ID</label>
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
																	<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
																		<div class="panel-body">Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
																			eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan
																			excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.</div>
																	</div>
																</div>
																<div class="panel panel-primary">
																	<div class="panel-heading" role="tab" id="headingThree">
																		<h4 class="panel-title">
																			<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree"> Deposit / installment Details </a>
																		</h4>
																	</div>
																	<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
																		<div class="panel-body">Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
																			eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan
																			excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.</div>
																	</div>
																</div>
																<div class="panel panel-primary">
																	<div class="panel-heading" role="tab" id="headingFour">
																		<h4 class="panel-title">
																			<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour"> Transaction Details </a>
																		</h4>
																	</div>
																	<div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
																		<div class="panel-body">Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
																			eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan
																			excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.</div>
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
	<!-- echart Theme Scripts -->


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
</style>


</body>
</html>