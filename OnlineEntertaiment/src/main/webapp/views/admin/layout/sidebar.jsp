<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<c:set var="uri" scope="session"
	value="${pageContext.request.requestURI}" />

<nav id="sidebarMenu"
	class="collapse d-lg-block sidebar collapse bg-white">
	<div class="position-sticky">
		<div class="list-group list-group-flush mx-3 mt-4">
			<a href="<c:url value = "/dashboard/homepage"/>"
				class="list-group-item list-group-item-action py-2 ripple"
				aria-current="true"> <i class="fas fa-tachometer-alt fa-fw me-3"></i>
				<span>Main dashboard</span>
			</a> 

			<c:if test="${fn:contains(uri, 'video')}">
				<a href="<c:url value = "/dashboard/video"/>"
					class="list-group-item list-group-item-action py-2 ripple active">
					<i class="fab fa-youtube fa-fw me-3"></i> <span>Video</span>
				</a>
			</c:if>

			<c:if test="${! fn:contains(uri, 'video')}">
				<a href="<c:url value = "/dashboard/video"/>"
					class="list-group-item list-group-item-action py-2 ripple"> <i
					class="fab fa-youtube fa-fw me-3"></i> <span>Video</span>
				</a>
			</c:if>
			
			<c:if test="${fn:contains(uri, 'analytics')}">
				<a href="<c:url value = "/dashboard/analytics"/>"
					class="list-group-item list-group-item-action py-2 ripple active"> <i
					class="fas fa-chart-line fa-fw me-3"></i> <span>Analytics</span>
				</a>
			</c:if>

			<c:if test="${! fn:contains(uri, 'analytics')}">
				<a href="<c:url value = "/dashboard/analytics"/>"
					class="list-group-item list-group-item-action py-2 ripple"> <i
					class="fas fa-chart-line fa-fw me-3"></i> <span>Analytics</span>
				</a>
			</c:if>
			
			
			<c:if test="${fn:contains(uri, 'members')}">
				<a href="<c:url value = "/dashboard/members"/>"
					class="list-group-item list-group-item-action py-2 ripple active"> <i
					class="fas fa-users fa-fw me-3"></i> <span>Users</span>
				</a>
			</c:if>
			
			<c:if test="${!fn:contains(uri, 'members')}">
				<a href="<c:url value = "/dashboard/members"/>"
					class="list-group-item list-group-item-action py-2 ripple"> <i
					class="fas fa-users fa-fw me-3"></i> <span>Users</span>
				</a>
			</c:if>
			
			
			 
		</div>
	</div>
</nav>