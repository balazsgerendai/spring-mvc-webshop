<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login screen</title>

<style type="text/css">
	.errorBlock{
		color: #ff0000;
		background-color: #ffEEEE;
		border: 3px solid #ff0000;
		padding: 8px;
		margin: 16px;
	}
</style>
</head>
<body>
	<c:if test="${not empty error }">
		<div class="erroBlock">
			Your login was unsuccessful. <br />
			Caused: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
		</div>
	</c:if>
	
	<form action="j_spring_security_check" name="f" method="post" class="form">
		<table class="table">
			<tr>
				<td>User:</td>
				<td><input type="text" name="j_username"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="j_password"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="Submit" value="Submit"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" name="Reset" value="Reset"/></td>
			</tr>
		</table>
		
		
	</form>
</body>
</html>