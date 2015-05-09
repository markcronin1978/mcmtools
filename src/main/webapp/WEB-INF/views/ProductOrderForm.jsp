<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


	<jsp:include page="header.jsp" />

		<jsp:include page="linkDisplay.jsp" />
		
				<h3>Product List:</h3>																
					<table cellpadding='10' align="center">	
						<tr>					
							<td>Stock Keeping Unit</td><td>Name</td><td>Description</td><td>Price Per Unit</td><td>Select Item</td>
						</tr>
							
							<c:forEach var="prod" items="${productList}">
								<tr>									
									<form:form method="post" action="${prod.SKU}"> <br />
										<input type="hidden" name="_method" value="get">
											<td>${prod.SKU}</td><td>${prod.name}</td><td>${prod.description}</td><td>${prod.pricePerUnit}</td>
										<td><input name="Select" type="submit" value="Select"/></td>
									</form:form>
								</tr>
							</c:forEach>								
						
					</table>	
					
					
	<jsp:include page="footer.jsp" />