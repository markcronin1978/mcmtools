<!-- This is the customer list page. The owner can call this jsp page to view what customers are registered -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

			
	<jsp:include page="header.jsp" /> <!-- Include the header.jsp page on build -->
	

			
			<h2>Customer List:</h2>
				<c:forEach var="cust" items="${customers}">
					<p>${cust.firstName} ${cust.lastName}</a></p> 
				</c:forEach>     
	
	<jsp:include page="footer.jsp" />