<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  <sec:authentication property="name"/>
</h1>
<a href="j_spring_security_logout">Logout</a>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
