<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ page language="java" import="javax.servlet.jsp.PageContext"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>  --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<section class="container">

	<form:form modelAttribute="starRating">
		<fieldset>
			<legend>Star rating</legend>
			<div>Current star rating: ${product.avgStarRating}</div>
			<form:errors path="*" cssClass="text-danger" element="div" />
			<div class="form-group">
				<label class="control-label col-lg-2" for="condition">Star
					Rating</label>
				<div class="col-lg-10">
					<form:radiobutton path="starRatingValue" value="1" />
					1
					<form:radiobutton path="starRatingValue" value="2" />
					2
					<form:radiobutton path="starRatingValue" value="3" />
					3
					<form:radiobutton path="starRatingValue" value="4" />
					4
					<form:radiobutton path="starRatingValue" value="5" />
					5
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="add star rating" />
				</div>
			</div>
		</fieldset>
	</form:form>
</section>
