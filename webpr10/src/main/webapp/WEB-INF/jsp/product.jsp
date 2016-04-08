<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" href="jquery.rating.css">
<script src="jquery.js"></script>
<script src="jquery.rating.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<tiles:insertDefinition name="product">
	<tiles:putAttribute name="body">
		<section>
		<!-- <div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
			</div>
		</div> -->
		</section>
		<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>${product.productName}</h3>
				<p>${product.productDescription}</p>
				<p>
					<strong>Item Code : </strong><span class="label labelwarning">${product.productId}</span>
				</p>
				<%-- <p>
					<strong>manufacturer</strong> : ${product.manufacturer}
				</p> --%>
				<p>
					<strong>category</strong> : ${product.category.categoryName}
				</p>
				<p>
					<strong>Availble units in stock </strong> : ${product.qtyInStock}
				</p>
				<h4>${product.productPrice}USD</h4>

				<!-- star rating  -->
				<%@ include file='starRating.jsp'%>

				<p>
					<a href="#" class="btn btn-warning btn-large"> <span
						class="glyphicon-shopping-cart glyphicon"></span> Order Now
					</a>
				</p>

			</div>
		</div>
		</section>

	</tiles:putAttribute>
</tiles:insertDefinition>