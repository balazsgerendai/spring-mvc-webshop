<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Sell</title>
</head>
<body>
	<div id="mainContent">
		<section>
		<c:if test="${not empty save and save}">
			<p class="bg-success">
				Save successfull. <br /> 
			</p>
		</c:if>

			<form:form class="form-horizontal" role="form" action="" method="post" commandName="itemForm" >
				<form:errors path="*" cssClass="bg-danger" element="p" />
					
				<div class="form-group ${not empty status.getFieldError('name') ? 'has-error has-feedback' : ''}" >
					<label class="col-sm-2 control-label">Item name</label>
					<div class="col-sm-10">
							<form:input path="name"  type="text" class="form-control" id="inputPassword"
							placeholder="Name" />
							<c:if test="${not empty status.getFieldError('name') }">
								 <span class="glyphicon glyphicon-remove form-control-feedback"></span>
							</c:if>
							
					</div>
				</div>
				<div class="form-group ${not empty status.getFieldError('description') ? 'has-error has-feedback' : ''}">
					<label class="col-sm-2 control-label">Description</label>
					<div class="col-sm-10">
							<form:textarea path="description" class="form-control" rows="3" placeholder="Description"></form:textarea>
							<c:if test="${not empty status.getFieldError('description') }">
								 <span class="glyphicon glyphicon-remove form-control-feedback"></span>
							</c:if>
					</div>
				</div>
				<div class="form-group ${not empty status.getFieldError('price') ? 'has-error has-feedback' : ''}">
					<label class="col-sm-2 control-label">Price</label>
					<div class="col-sm-10">
							<form:input path="price"  type="number" class="form-control" placeholder="Price"/>
							<c:if test="${not empty status.getFieldError('price') }">
								 <span class="glyphicon glyphicon-remove form-control-feedback"></span>
							</c:if>
					</div>
				</div>
				<div class="form-group ${not empty status.getFieldError('expirationDate') ? 'has-error has-feedback' : ''}">
					<label class="col-sm-2 control-label">Expiration Date</label>
					<div class="col-sm-10">
							<form:input path="expirationDate" type="date" class="form-control" id="datepicker" />
							<c:if test="${not empty status.getFieldError('expirationDate') }">
								 <span class="glyphicon glyphicon-remove form-control-feedback"></span>
							</c:if>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-10">
							<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</div>
				
			</form:form>
		</section>

	</div>
</body>
</html>
