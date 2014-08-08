<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Sales</title>
</head>
<body>
	<div id="mainContent">
		<section>

			<div class="panel panel-default">
				<div class="panel-body">
					<h1>Please choose from our wide stock</h1>
				</div>

				<table class="table">
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Description</th>
						<th>Price</th>
						<th>Expiration Date</th>
						<th>Seller Name</th>
						<th>Buy</th>
					</tr>
					<c:forEach var="item" items="${content}">
						<tr>
							<td><c:out value="${item.id}"></c:out></td>
							<td><c:out value="${item.name}"></c:out></td>
							<td><c:out value="${item.description}"></c:out></td>
							<td class="item_price"><c:out value="${item.price}"></c:out></td>
							<td><c:out value="${item.expirationDate}"></c:out></td>
							<td><c:out value="${item.sellerUsername}"></c:out></td>
							<td>
								<c:choose>
									<c:when test="${not item.sold}">
										<button id="buy_${item.id}" type="submit"
											class="btn btn-default">
											<i class="glyphicon glyphicon-shopping-cart"></i>
										</button>
									</c:when>
									<c:otherwise>
										<c:out value="SOLD"></c:out>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>

			<c:url var="firstUrl" value="/sales/pages/1" />
			<c:url var="lastUrl" value="/sales/pages/${deploymentLog.totalPages}" />
			<c:url var="prevUrl" value="/sales/pages/${currentIndex - 1}" />
			<c:url var="nextUrl" value="/sales/pages/${currentIndex + 1}" />

			<div>
				<ul class="pagination">
					<c:choose>
						<c:when test="${currentIndex == 1}">
							<li class="disabled"><a href="#">&lt;&lt;</a></li>
							<li class="disabled"><a href="#">&lt;</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${firstUrl}">&lt;&lt;</a></li>
							<li><a href="${prevUrl}">&lt;</a></li>
						</c:otherwise>
					</c:choose>
					<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
						<c:url var="pageUrl" value="/sales/pages/${i}" />
						<c:choose>
							<c:when test="${i == currentIndex}">
								<li class="active"><a href="${pageUrl}"><c:out
											value="${i}" /></a></li>
							</c:when>
							<c:otherwise>
								<li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${currentIndex == deploymentLog.totalPages}">
							<li class="disabled"><a href="#">&gt;</a></li>
							<li class="disabled"><a href="#">&gt;&gt;</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${nextUrl}">&gt;</a></li>
							<li><a href="${lastUrl}">&gt;&gt;</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</section>

	</div>

</body>
</html>
