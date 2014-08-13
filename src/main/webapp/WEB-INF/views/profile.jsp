<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Profile - <sec:authentication property="name"/></title>
</head>
<body>
	<div id="mainContent">
		<h1>Items Bought</h1>
			<table class="table table-striped">
				<tr>
					<th>Sale Id</th>
					<th>Buyer username</th>
					<th>Seller username</th>
					<th>Item Id</th>
				</tr>
				<c:forEach var="sale" items="${ sales }">
					<tr>
						<td><c:out value="${sale.id }"/></td>
						<td><c:out value="${sale.customer.username }"/></td>
						<td><c:out value="${sale.sellerUsername }"/></td>
						<td><c:out value="${sale.itemId }"/></td>
					</tr>
				</c:forEach>
			</table>
	</div>
</body>
</html>
