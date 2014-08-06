<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home</title>
</head>
<body>
	<div id="mainContent">
		<section id="intro">
			<header>
				<h2>Look at us in pictures</h2>
			</header>

			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
				do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
				enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
				ut.</p>
		</section>
		<section>
			<h1>
				Hello world!
				<sec:authentication property="name" />
			</h1>
			
		</section>

	</div>
	<aside>
		<section>
			<header>
				<h3>Categories</h3>
			</header>
			<ul>
				<li><a href="#">Lorem ipsum dolor</a></li>
				<li><a href="#">Sit amet consectetur</a></li>
				<li><a href="#">Adipisicing elit sed</a></li>
				<li><a href="#">Do eiusmod tempor</a></li>
				<li><a href="#">Incididunt ut labore</a></li>
			</ul>
		</section>
	</aside>
</body>
</html>
