<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


	<jsp:include page="header.jsp" />
				
		<jsp:include page="linkDisplay.jsp" />
		
			<p style="color:black"><c:out value="${message}" /></p>
			
			<h2>Product List:</h2>

					<table align="center">
						<tr>
							<td>Stock Keeping Unit |</td><td>Name |</td><td>Description |</td><td>Price Per Unit |</td><td>Quantity |</td>
						</tr>
						<c:forEach var="prod" items="${products}">
							<tr>
								<td><p>${prod.SKU}</td><td>${prod.name}</td><td>${prod.description}</td><td>${prod.pricePerUnit}</td><td>${prod.stockLevel}</p></td>
							</tr>
						</c:forEach>
				
					</table>

	
	<jsp:include page="footer.jsp" />