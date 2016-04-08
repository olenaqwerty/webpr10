<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- Carousel with promotions -->
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<c:forEach var="promotionDto" items="${promotionDtos}"
			varStatus="iterationStatus">
			<li data-target="#myCarousel"
				data-slide-to="<c:out value='${iterationStatus.index}'/>"
				<c:if test='${iterationStatus.first}'>class="active"</c:if>></li>
		</c:forEach>
	</ol>
	<div class="carousel-inner">
		<c:forEach var="promotionDto" items="${promotionDtos}"
			varStatus="iterationStatus">
			<div class="item <c:if test='${iterationStatus.first}'>active</c:if>">
				<img src="<c:url value='${promotionDto.imageUrl}' />">
				<div class="container">
					<div class="carousel-caption">
						<h1>
							<c:out value="${promotionDto.titleText1}" />
						</h1>
						<p>
							<c:out value="${promotionDto.titleText2}" escapeXml="false" />
						</p>
						<p>
							<a class="btn btn-default btn-success"
								href="<c:url value='${promotionDto.locationPath}' />"
								role="button"> <c:out value="${promotionDto.locationText}" />
							</a>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<a class="left carousel-control" href="#myCarousel" role="button"
		data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"></span>
	</a> <a class="right carousel-control" href="#myCarousel" role="button"
		data-slide="next"> <span class="glyphicon glyphicon-chevron-right"></span>
	</a>
</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>