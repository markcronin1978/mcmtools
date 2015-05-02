<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



	<jsp:include page="header.jsp" />
	
		<jsp:include page="linkDisplay.jsp" />
				
			<p style="color:red"><c:out value="${Error_msg}" /></p>
				<h3>Item Selected For Purchase</h3>
					<table cellpadding='10' align="center">	
						<tr>					
							<td>Stock Keeping Unit</td><td>Name</td><td>Description</td><td>Price Per Unit</td>			
						</tr>
						<tr>
							<td><input type="text" style="background-color:lightgrey" name="skuSelected" path="skuSelected" value="${productSelected.SKU}" size="5" readonly /></td><td>${productSelected.name}</td><td>${productSelected.description}</td><td>${productSelected.pricePerUnit}</td>
						</tr>
										
					</table>
					<br><br>
					
					<table align="center">
						<c:url value="/saleorderController/quantity" var="form_url" />					
						<form:form method="post" action="${form_url}">
							<tr>
								<td>Please Enter Quantity:</td><td><input name="quantity" path="quantity" size="5" value="0" /></td><td><input type="submit" value="submit"/></td>							
							</tr>
						</form:form>
					</table>
					
	<jsp:include page="footer.jsp" />