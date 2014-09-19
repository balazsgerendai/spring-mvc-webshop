<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login screen</title>

</head>
<body>
	<c:if test="${not empty error }">
		<div class="bg-danger">
			Your login was unsuccessful. <br /> Caused:
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
		</div>
	</c:if>
	
<div class="panel panel-default ">
   <div class="panel-body">
<form action="j_spring_security_check" name="f" method="post"
		class="form-horizontal">
		<div class="form-group">
			<label for="user" class="col-sm-2 control-label">Username </label>
			<div class="col-sm-10">
				<input type="text" name="j_username" class="form-control"
					id="user" placeholder="Enter username">
			</div>
		</div>
		<div class="form-group">
			<label for="passsword" class="col-sm-2 control-label">Password </label>
			<div class="col-sm-10">
				<input type="password" name="j_password" class="form-control"
					id="password" placeholder="Enter Password">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label> <input type="checkbox" name="_spring_security_remember_me"> Remember me </label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" name="submit" id="submit" class="btn btn-default">Sign in</button>
			</div>
			<div class="col-sm-offset-8 col-sm-10">
				Don't have an account yet? <a href="/user/register.html">Register</a>
			</div>
		</div>

	</form>
   </div>
</div>
	

</body>
</html>