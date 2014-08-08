<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="/resources/css/main.css">

<title><sitemesh:write property='title' /></title>
<sitemesh:write property='head' />
</head>

<body>
	<header>
		<h1>Cool WebShop</h1>
	</header>
	<nav>
		<ul>
			<li class="selected"><a href="/">Home</a></li>
			<li><a href="/sales/">Sales</a></li>
			<li><a href="#">Sell</a></li>
			<sec:authorize access="isAuthenticated()">
				<li><a href="#">Budget(<sec:authentication property="principal.budget" />$)</a></li>
				<li>
					<a href="/j_spring_security_logout">
						<button type="submit" class="btn btn-default">
			 					 <i class="glyphicon glyphicon-log-out"></i> Log out
						</button>
					</a>
				</li>
			</sec:authorize>
		</ul>
	</nav>

	<div id="content">
	
	<sitemesh:write property='body' />
	
	</div>
	<footer>
		<div>
			<section id="about">
				<header>
					<h3>About</h3>
				</header>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco <a href="#">laboris nisi ut aliquip</a> ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
			</section>
			<section id="popular">
				<header>
					<h3>Popular</h3>
				</header>
				<ul>
					<li><a href="#">Lorem ipsum dolor sit amet</a></li>
					<li><a href="#">Consectetur adipisicing elit, sed do eiusmod</a></li>
					<li><a href="#">Duis aute irure dolor</a></li>
					<li><a href="#">Excepteur sint occaecat cupidatat</a></li>
					<li><a href="#">Reprehenderit in voluptate velit</a></li>
					<li><a href="#">Officia deserunt mollit anim id est laborum</a></li>
					<li><a href="#">Lorem ipsum dolor sit amet</a></li>
				</ul>
			</section>
		</div>
	</footer>
	
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/resources/js/buyer.js"></script>
</body>
</html>