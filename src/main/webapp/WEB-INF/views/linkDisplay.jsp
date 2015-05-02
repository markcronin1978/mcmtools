<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

 

	<div id = nav>
	<ul>   <!-- here i am declaring that any view of link with /customer/ in the url has to be sent through the security checks in the spring-infrastructure.xml file -->
		<sec:authorize access="hasRole('ROLE_ADMIN')">	
		
				<a href='<c:url value="/customer/"/>'> Customer List |</a>			
				<a href='<c:url value="/customer/add"/>'> Add Customer |</a>
				<a href='<c:url value="/product/"/>'> Product List  |</a>				
				<a href='<c:url value="/product/add"/>'> Add Product |</a>			
				<a href='<c:url value="/adminController/"/>'> Order List |</a>
			
		</sec:authorize>
		
		<sec:authorize access="hasRole('ROLE_USER')">		
			<sec:authentication property="principal" var ="user" />
			<p>Welcome <c:out value="${user.username}" /></p>
		</sec:authorize>
			<a href="../logout"> Logout</a>
	</ul>
	</div>

