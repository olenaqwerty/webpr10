<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<tiles:insertDefinition name="welcome">
	<tiles:putAttribute name="body">
		<div class="wrapper">
			<div class="categoryName">
				<h1>Mobile Phones</h1>
				<span class="categoryCount">${phonesNum} Items</span><span
					class="viewallCsf fnt-15 marL14 "> <a
					href="<c:url value='/products/phones'/>" class="btn btn-primary">
						<span class="glyphicon-info-sign glyphicon" /></span> View All
				</a>
				</span>
			</div>

		</div>
				<%-- <%@ include file='promotionsCarousel.jsp'%> --%>
		<!--Shop by Price ===================================================================  -->

		<div class="widgetShopByPrice">
			<div class="widgetShopByStyleInner  marB30">
				<div class="widgetName">Shop By Price</div>
				<div
					class="csf-style-widget-wrapper pull-left col-xs-6  marTopBtm20 ">
					<a
						href="<c:url value='/products/price;low=1;high=50'/>">
						<div class="csf-style-widget-image">
							<img
								src="http://i2.sdlcdn.com/img/storeFrontFeaturedProductAdmin/01/Below4000.jpg"
								data-pin-nopin="true">
						</div>
<!-- 						<div class="csf-style-widget-name"></div>
 -->					</a>
				</div>
			</div>
		</div>
<%-- 	TODO:	<%@ include file='productsList.jsp'%>
 --%>	</tiles:putAttribute>
</tiles:insertDefinition>
