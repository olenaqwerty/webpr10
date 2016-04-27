<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js">
	
</script>
<script src="/webstore/resource/js/controllers.js"></script>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<tiles:insertDefinition name="products">
	<tiles:putAttribute name="body">
		<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
			</div>
		</div>
		</section>
		<div class="pull-right" style="padding-right: 50px">
			<!-- here the name like en, or nl should correspond to names in message.properties files. _en, _nl -->
			<a href="?language=en">English</a>| <a href="?language=nl">Dutch</a>
		</div>
		<section class="container">
		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${product.name}</h3>
							<img src="<c:url value="/resources/images/1.jpg"></c:url>"
								alt="image" />
							<p>${product.productDescription}</p>
							<p>Available in Stock: ${product.qtyInStock}</p>
							<p>
								<a href="<c:url value='/products/${product.productId}'/>">
									Details </a>
							</p>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		</section>
	</tiles:putAttribute>
</tiles:insertDefinition>