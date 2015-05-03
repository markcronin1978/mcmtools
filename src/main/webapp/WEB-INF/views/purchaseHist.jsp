<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

	<jsp:include page="header.jsp" />
	
	<jsp:include page="linkDisplay.jsp" />
	
		<h2>Sales Order List:</h2>
			<table cellpadding='10' align="center">
				<tr>
					<td> Customer Email </td><td> Product ID </td><td>Quantity</td><td> cost </td>
				</tr>
		
				<c:forEach var="ph" items="${purchaseHist}">
					<tr>
						<td>${ph.customerEmail}</td><td>${ph.productSKU}</td><td>${ph.quantity}</td><td>${ph.cost}</td>
					</tr>
					</c:forEach>
			</table>
			
	<jsp:include page="footer.jsp" />