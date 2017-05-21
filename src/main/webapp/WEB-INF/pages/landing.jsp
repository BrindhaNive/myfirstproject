<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" class=" ">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Primary Agriculture Credit Society</title>
<!-- Bootstrap -->
<spring:url value="/resources/dashboard/css/bootstrap.min.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<!-- Font Awesome -->
<spring:url value="/resources/dashboard/css/font-awesome.min.css" var="awesomeCss" />
<link href="${awesomeCss}" rel="stylesheet" />
<!-- Custom Theme Style -->
<spring:url value="/resources/dashboard/css/custom.min.css" var="customCss" />
<link href="${customCss}" rel="stylesheet" />
<!-- Custom Theme Style -->
<spring:url value="/resources/dashboard/css/tiles-for-pacs.css" var="tilesCss" />
<link href="${tilesCss}" rel="stylesheet" />
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
							<h2>Marc Gordon</h2>
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
										<li><a href="dashboard.html">Fixed Account</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav bg-primary">
				<span style="font-size: 20px; cursor: pointer"><span class="glyphicon glyphicon-ruble" aria-hidden="true"></span>rimary Agriculture Credit Society</span>
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
				<div class="container">
					<div class="row">
						<div class="col-sm-3">
							<div class="tile-progress tile-primary">
								<div class="tile-header">
									<h3>Loans disbursed</h3>
									<span>Rs.2323224.00</span>
								</div>
								<div class="tile-progressbar">
									<span data-fill="35.5%" style="width: 35.5%;"></span>
								</div>
								<div class="tile-footer">
									<h4>
										<span class="pct-counter">35.5</span>% increase
									</h4>
									<span>than the previous financial year</span>
								</div>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="tile-progress tile-red">
								<div class="tile-header">
									<h3>Members</h3>
									<span>15678 members</span>
								</div>
								<div class="tile-progressbar">
									<span data-fill="23.2%" style="width: 23.2%;"></span>
								</div>
								<div class="tile-footer">
									<h4>
										<span class="pct-counter">23.2</span>% increase
									</h4>
									<span>than the previous financial year</span>
								</div>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="tile-progress tile-blue">
								<div class="tile-header">
									<h3>Loan Accounts</h3>
									<span>8765 accounts</span>
								</div>
								<div class="tile-progressbar">
									<span data-fill="78%" style="width: 78%;"></span>
								</div>
								<div class="tile-footer">
									<h4>
										<span class="pct-counter">78</span>% increase
									</h4>
									<span>than the previous financial year</span>
								</div>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="tile-progress tile-aqua">
								<div class="tile-header">
									<h3>Today's Closing bal</h3>
									<span>Rs.112300</span>
								</div>
								<div class="tile-progressbar">
									<span data-fill="22%" style="width: 22%;"></span>
								</div>
								<div class="tile-footer">
									<h4>
										<span class="pct-counter">22</span>% increase
									</h4>
									<span>Today's opening is Rs.90290</span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<div class="tile-progress tile-green">
								<div class="tile-header">
									<h3>Deposits</h3>
									<span>2345 new accounts</span>
								</div>
								<div class="tile-progressbar">
									<span data-fill="94%" style="width: 94%;"></span>
								</div>
								<div class="tile-footer">
									<h4>
										<span class="pct-counter">94</span>% increase
									</h4>
									<span>than the previous financial year</span>
								</div>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="tile-progress tile-cyan">
								<div class="tile-header">
									<h3>OD accounts</h3>
									<span>345 accounts</span>
								</div>
								<div class="tile-progressbar">
									<span data-fill="45.9%" style="width: 45.9%;"></span>
								</div>
								<div class="tile-footer">
									<h4>
										<span class="pct-counter">45.9</span>% decreased
									</h4>
									<span>click to see OD accounts</span>
								</div>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="tile-progress tile-purple">
								<div class="tile-header">
									<h3>Day book</h3>
									<span>154 transactions</span>
								</div>
								<div class="tile-progressbar">
									<span data-fill="27%" style="width: 27%;"></span>
								</div>
								<div class="tile-footer">
									<h4>
										<span class="pct-counter">27</span>% increased
									</h4>
									<span>click to see transactions</span>
								</div>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="tile-progress tile-pink">
								<div class="tile-header">
									<h3>KCC Accounts</h3>
									<span>456 accounts</span>
								</div>
								<div class="tile-progressbar">
									<span data-fill="3" style="width: 3%;"></span>
								</div>
								<div class="tile-footer">
									<h4>
										<span class="pct-counter">3</span>% increase
									</h4>
									<span>than the previous financial year</span>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<!-- /page content -->

			<!-- footer content 
        <footer>
          <div class="pull-right">
          </div>
          <div class="clearfix"></div>
        </footer>
         /footer content -->
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