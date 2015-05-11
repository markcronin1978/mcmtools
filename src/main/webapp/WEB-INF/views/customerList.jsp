<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

			
	<jsp:include page="header.jsp" /> <!-- Include the header.jsp page on build -->
	
		<jsp:include page="linkDisplay.jsp" />
			
			<h2>Customer List:</h2>
				<c:forEach var="cust" items="${customers}">
					<p>${cust.firstName} ${cust.lastName}</p> 
				</c:forEach>     
	
	<jsp:include page="footer.jsp" />
