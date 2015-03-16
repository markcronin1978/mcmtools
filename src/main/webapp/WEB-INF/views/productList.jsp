<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	<jsp:include page="header.jsp" />
				

			<h2>Product List:</h2>
			<h3>To Edit Product Information, Click on Product Stock Keeping Unit Number</h3>

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