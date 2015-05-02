<!-- this is the productDisplay.jsp page. It displays the entire order to the customer before they commit to buy. -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

	<jsp:include page="header.jsp" />
				
	<jsp:include page="linkDisplay.jsp" />
		
					<h2>Please Verify Delivery Details:</h2>
					
				<c:url value="/saleorderController/confirm" var="form_url"/>
					<form:form action="${form_url}" commandName="saleOrder">
						<table cellpadding='10' align="center">
							<tr>
								<td>Customer Email Address:</td><td><form:input path="customerEmail" size="30" /></td>
							</tr>
							<tr>
								<td>Product SKU Number:</td><td><form:input path="productSKU" size="30" /></td>
							</tr>
							<tr>
								<td>Quantity:</td><td><form:input path="quantity" size="30" /></td>
							</tr>
							<tr>
								<td>Total Cost:</td><td><form:input path="cost" size="30" /></td>
							</tr>				
							<tr>
								<form:hidden path="id" />
								<p><input type="submit" value="Confirm"/></p>
							</tr>
					</table>
				</form:form>