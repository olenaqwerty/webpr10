<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<c:url value="/" var="homeUrl" />
	<ul class="clearfix">
		<li><a href="${homeUrl}"></a> <!-- how to do homeUrl? -->
		</li> 

		<c:forEach items="${breadcrumbs}" var="breadcrumb" varStatus="status">
			<li class="separator">&gt;</li>
			<li>
<%-- 				<c:if test="${not empty breadcrumb.linkClass}">class="${breadcrumb.linkClass}"</c:if>>
 --%>
				<c:choose>
					<c:when test="${breadcrumb.url eq '#'}">
						<a href="#" onclick="return false;"
							<c:if test="${status.last}">class="last"</c:if>>${breadcrumb.name}</a>
					</c:when>

					<c:otherwise>
						<c:url value="${breadcrumb.url}" var="breadcrumbUrl" />
						<a href="${breadcrumbUrl}"
							<c:if test="${status.last}">class="last"</c:if>>${breadcrumb.name}</a>
					</c:otherwise>

				</c:choose>
			</li>

		</c:forEach>
	</ul>
</body>
</html>