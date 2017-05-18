<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <title>Bank of Cooperative Societies</title>
    <!-- BOOTSTRAP CORE STYLE  -->
    <spring:url value="/resources/assets/css/bootstrap.min.css" var="mainCss" />
	<spring:url value="/resources/assets/css/font-awesome.css" var="fontawesomeCss" />
	<spring:url value="/resources/assets/css/style.css" var="styleCss" />

	<link href="${mainCss}" rel="stylesheet" />

    <!-- FONT AWESOME ICONS  -->
	<link href="${fontawesomeCss}" rel="stylesheet" />
    <!-- CUSTOM STYLE  -->
    <link href="${styleCss}" rel="stylesheet" />
     <!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
 
<script>
function login(){
	alert('Inside js');
	$('#addUser')
$('#loginForm').attr('method','post');
$('#loginForm').attr('action','/login');
$('#loginForm').submit();
}
</script>
</head>
<body>
<nav class="navbar fixed-top navbar-toggleable-md double-nav scrolling-navbar top-nav-collapse bg-primary">
  <h1 class="navbar-brand mb-0"><i class="fa fa-university" aria-hidden="true"></i>&nbsp; | Bank of Cooperative Society</h1>

</nav>
   
  
   
            <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h4 class="page-head-line">Please Login To Enter </h4>

                </div>

            </div>
            <div class="row">
              
                <div class="col-md-6">
                    <div class="alert alert-info">
                       The cooperative movement in Tamilnadu has grown and spread like a banyan tree and taken deep roots since 1904 when the first cooperative societies act was enacted in the country, and is closely linked with the day to day affairs of the people. In order to help the growth of cooperatives and spread the knowledge of its achievements among the people and shape their minds, 20 State Cooperative Unions were established in the country and Tamilnadu Cooperative Union is one among them. 
                        <br />
                         <strong> Tamilnadu Cooperative Union</strong>
                        <ul>
                            <li>
                                Hon'ble Minister for Cooperation : Thiru Sellur K Raju 
                            </li>
                            <li>
                                Addl.Registrar/Managing Director : Tmt. V. Devaki
                            </li>
                          
                        </ul>
                       
                    </div>
                   
                </div>
				<c:if test="${not empty error}">
						<div class="error">${error}</div>
					</c:if>
					<c:if test="${not empty msg}">
						<div class="msg">${msg}</div>
				</c:if>
				<form name='loginForm' id="loginForm" action="<c:url value='/login' />" method='POST'>
				  <div class="col-md-4">
					 
                     <label>Enter User ID : </label>
						<input type="text" id="username" name="username" class="form-control">
                        <label>Enter Password :  </label>
                        <input name="password" id="password" type="password" class="form-control" />
                        <hr />
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                       <!--  <a href="#" id="loginbtn" class="btn btn-primary" onclick="javascript:login()"><span class="glyphicon glyphicon-user"></span> &nbsp;Log Me In </a>&nbsp;
						 -->
						 <input name="submit" type="submit" value="submit" />
                </div>
				</form>

            </div>
			
        </div>
    
    <footer class="footer bg-primary">
      <div class="float-left">
        <p>&nbsp Epyloc Limited | +44 744-22-20-20</p>
      </div>
    </footer>
    <!-- JAVASCRIPT AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
    <!-- CORE JQUERY SCRIPTS -->
    <spring:url value="/resources/assets/js/jquery-1.11.1.js" var="jqueryJs" />
	<spring:url value="/resources/assets/js/bootstrap.js" var="mainJs" />
    <script src="${jqueryJs}"></script>
    <!-- BOOTSTRAP SCRIPTS  -->
    <script src="${bootstrap}"></script>
</body>
</html>
