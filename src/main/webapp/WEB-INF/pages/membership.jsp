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
<%@ include file="/WEB-INF/pages/includecss.jsp"%>
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
														<h4 class="panel-title">Membership</h4>
													</div>
													<div class="panel-body">
														<!-- TO DO : Replace with Spring form -->
														<form:form class="form-horizontal" id="addMemberCommandForm" modelAttribute="addMemberCommandForm" commandName="addMemberCommandForm" method="post" name="addMemberCommandForm" action="register">

															<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
																<div class="panel panel-primary">
																	<div class="panel-heading" role="tab" id="headingOne">
																		<h4 class="panel-title">
																			<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne"> Personal Details </a>
																		</h4>
																	</div>
																	<div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
																		<div class="panel-body">
																			<div class="col-md-12 col-sm-12">
																				<div class="form-group col-md-6 col-sm-6">
																					<label class="control-label">Membership Type</label>
																					<form:select path="membershipType" class="form-control dropdown" id="membershipType">
																						<form:option value="0" label="--- Select ---" />
																						<form:options items="${memberTypeMap}" />
																					</form:select>
																				</div>
																				<div class="form-group col-md-6 col-sm-6">
																					<label class="control-label">Salutation</label>
																					<form:select path="salutation" class="form-control dropdown" id="salutation">
																						<form:option value="0" label="--- Select ---" />
																						<form:options items="${salutationMap}" />
																					</form:select>
																				</div>

																				<div class="form-group col-md-6 col-sm-6">
																					<label for="membername">Member Name*</label>
																					<form:input type="text" class="form-control" path="memberName" id="memberName" />
																					<div class="has-error">
																						<form:errors path="memberName" class="help-inline" />
																					</div>
																				</div>

																				<div class="form-group col-md-6 col-sm-6">
																					<label for="surname">Member SurName*</label>
																					<form:input type="text" class="form-control" path="surName" id="surName" />
																					<div class="has-error">
																						<form:errors path="surName" class="help-inline" />
																					</div>
																				</div>

																				<div class="form-group col-md-6 col-sm-6">
																					<label class="control-label">Gender</label>
																					<form:select path="gender" class="form-control dropdown input-sm" id="gender">
																						<form:option value="0" label="--- Select ---" />
																						<form:options items="${genderMap}" />
																					</form:select>
																				</div>

																				<div class="form-group col-md-6 col-sm-6">
																					<label for="fatherOrHusbandName">Father/Husband Name*</label>
																					<form:input type="text" class="form-control" path="fatherOrHusbandName" id="fatherOrHusbandName" />
																					<div class="has-error">
																						<form:errors path="fatherOrHusbandName" class="help-inline" />
																					</div>
																				</div>

																				<div class="form-group col-md-6 col-sm-6">
																					<label for="yearsPicker">Date of Birth</label>
																					<form:input type="text" class="form-control" path="dateOfBirth" id="datepicker" />
																				</div>

																				<div class="form-group col-md-6 col-sm-6">
																					<label class="control-label">Staff</label>
																					<form:select path="staff" class="form-control dropdown" id="staff">
																						<form:option value="0" label="--- Select ---" />
																						<form:option value="1" label="YES" />
																						<form:option value="2" label="NO" />
																					</form:select>
																				</div>

																				<div class="form-group col-md-6 col-sm-6">
																					<label for="employeeNumber">Employee number*</label>
																					<form:input type="text" path="employeeNumber" class="form-control" id="employeeNumber" />
																				</div>

																				<div class="form-group col-md-6 col-sm-6">
																					<label class="control-label">Senior citizen</label>
																					<form:select path="seniorCitizen" class="form-control dropdown" id="seniorCitizen">
																						<form:option value="0" label="--- Select ---" />
																						<form:option value="1" label="YES" />
																						<form:option value="2" label="NO" />
																					</form:select>
																				</div>

																				<div class="form-group col-md-6 col-sm-6">
																					<label class="control-label">Senior citizen proof</label>
																					<form:select path="seniorCitizenProof" class="form-control dropdown" id="seniorCitizenProof">
																						<form:option value="0" label="--- Select ---" />
																						<form:options items="${genderMap}" />
																					</form:select>
																				</div>

																				<div class="form-group col-md-6 col-sm-6">
																					<label class="control-label">Occupation</label>
																					<form:select path="occupation" class="form-control dropdown" id="occupation">
																						<form:option value="0" label="--- Select ---" />
																						<form:options items="${occupationMap}" />
																					</form:select>
																				</div>

																				<div class="form-group col-md-6 col-sm-6">
																					<label class="control-label">Religion</label>
																					<form:select path="religion" class="form-control dropdown" id="religion">
																						<form:option value="0" label="--- Select ---" />
																						<form:options items="${religionMap}" />
																					</form:select>
																				</div>

																				<div class="form-group col-md-6 col-sm-6">
																					<label class="control-label">Category</label>
																					<form:select path="category" class="form-control dropdown" id="category">
																						<form:option value="0" label="--- Select ---" />
																						<form:options items="${categoryMap}" />
																					</form:select>
																				</div>

																				<div class="form-group col-md-6 col-sm-6">
																					<label for="noOfAcres">Total Acres*</label>
																					<form:input type="text" path="acres" class="form-control" id="acres" />
																					<div class="has-error">
																						<form:errors path="acres" class="help-inline" />
																					</div>
																				</div>

																				<div class="form-group col-md-6 col-sm-6">
																					<label class="control-label">Type of farmer</label>
																					<form:select path="typeOfFarmer" class="form-control dropdown" id="typeOfFarmer">
																						<form:option value="0" label="--- Select ---" />
																						<form:options items="${genderMap}" />
																					</form:select>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="panel panel-primary">
																	<div class="panel-heading" role="tab" id="headingTwo">
																		<h4 class="panel-title">
																			<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo"> Share holder Details </a>
																		</h4>
																	</div>
																	<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
																		<div class="panel-body">hjvjvjv</div>
																	</div>
																</div>
																<div class="panel panel-primary">
																	<div class="panel-heading" role="tab" id="headingThree">
																		<h4 class="panel-title">
																			<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree"> Address </a>
																		</h4>
																	</div>
																	<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
																		<div class="panel-body">hvvjvjvj</div>
																	</div>
																</div>
																<div class="panel panel-primary">
																	<div class="panel-heading" role="tab" id="headingFour">
																		<h4 class="panel-title">
																			<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour"> KYM Details </a>
																		</h4>
																	</div>
																	<div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
																		<div class="panel-body">Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
																			eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan
																			excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.</div>
																	</div>
																</div>
																<div class="panel panel-primary">
																	<div class="panel-heading" role="tab" id="headingFive">
																		<h4 class="panel-title">
																			<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="false" aria-controls="collapseFive"> Legal Heir Details </a>
																		</h4>
																	</div>
																	<div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
																		<div class="panel-body">Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
																			eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan
																			excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.</div>
																	</div>
																</div>
																<div class="panel panel-primary">
																	<div class="panel-heading" role="tab" id="headingSix">
																		<h4 class="panel-title">
																			<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseSix" aria-expanded="false" aria-controls="collapseSix"> Other Details </a>
																		</h4>
																	</div>
																	<div id="collapseSix" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSix">
																		<div class="panel-body">Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
																			eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan
																			excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.</div>
																	</div>
																</div>
															</div>
															<input type="submit" value="Submit" />
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
			<footer class="customfooter">
				<div class="pull-right"></div>
				<div class="clearfix"></div>
			</footer>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/essentialscripts.jsp"%>
	<%@ include file="/WEB-INF/pages/manipulateSelects.jsp"%>
</body>
</html>