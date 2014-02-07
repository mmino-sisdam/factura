<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> 
<html lang="en">
<html>
	<head>
		<title>Loyal Admin</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- Bootstrap -->
		<link rel="stylesheet/less" type="text/css" href="../resources/css/styles.less" />
		<link rel="stylesheet" href="../resources/libs//bootstrap/css/bootstrap.css" />
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
		<![endif]-->
	</head>
	<body style="background: #dddddd;">

		<div class="main-login">

			<div class="form-login">
				<form action="<c:url value='/j_spring_security_check'/>" method="POST">

					<fieldset>

						<div class="col-md-12 clearfix col-top">
						<img src="../resources/images/logo.jpg"/>
						</div>
						<c:if test="${not empty param.login_error}">
							<div class="col-md-12 clearfix">
								<div class="form-group">
									<p class="alert alert-danger">Atenci&oacute;n, hubo un error</p>
								</div>
							</div>
						</c:if>

						<div class="col-md-12 clearfix">
							<div class="form-group">
							    <label for="">Usuario</label>
							    <div class="input-group">
							      <span class="input-group-addon">
							        <span class="glyphicon glyphicon-user"></span>
							      </span>
							      <input type="text" class="form-control" name='j_username'  placeholder="Ingesar usuario" value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'>
							    </div>
							</div>
						</div>	
						<div class="col-md-12 clearfix">
							<div class="form-group">
							    <label for="">Contrase&ntilde;a</label>
							    <div class="input-group">
							      <span class="input-group-addon">
							        <span class="glyphicon glyphicon-asterisk"></span>
							      </span>
							      <input type="password" class="form-control" name='j_password'/>
							    </div>
							</div>
						</div>
						<div class="col-md-12 clearfix">
							<input name="submit" type="submit" value="Login" class="btn btn-success btn-block" />
						</div>					
					</fieldset>
<!--
					<table>
						<tr>
							<td colspan='2'>
								<c:if test="${not empty param.login_error}">
									<font color="red">Error<br/><br/></font>
								</c:if>
							</td>
						</tr>
				    	<tr>
				    		<td>Usuario:</td>
				    		<td><input type='text' name='j_username' value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/>
				    		</td>
				    	</tr>
				    	<tr>
				    		<td>Clave:</td>
				    		<td><input type='password' name='j_password'></td>
				    	</tr>
				    	<tr>	        		<td colspan='2'>
				    			<input name="submit" type="submit" value="Login">
							</td>
						</tr>
				  </table>
				  -->
				</form>
			</div>
		</div>

	    <script type="text/javascript" src="../resources/libs/jquery-1.11.0.min.js"></script>
	    <script type="text/javascript" src="../resources/libs/less/less-1.6.1.min.js"></script>

	</body>
</html>