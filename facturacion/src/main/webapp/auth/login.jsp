<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<form action="<c:url value='/j_spring_security_check'/>" method="POST">
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
	        		<td>Password:</td>
	        		<td><input type='password' name='j_password'></td>
	        	</tr>
	        	<tr>
	        		<td colspan='2'>
	        			<input name="submit" type="submit" value="Login">
					</td>
				</tr>
	      </table>
	    </form>
	</body>
</html>