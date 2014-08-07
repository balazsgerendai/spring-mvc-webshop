<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home</title>
</head>
<body>
	<div id="mainContent">

		<section>
			<h1>
				Hello world!
				<sec:authentication property="name" />
			</h1>
		</section>

	</div>
</body>
</html>
