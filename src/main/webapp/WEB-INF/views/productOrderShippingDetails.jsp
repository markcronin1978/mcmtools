<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


	<jsp:include page="header.jsp" />				

		<jsp:include page="linkDisplay.jsp" />
			
					<p>Please Verify Name And Shipping Address</p>
					
					<c:url value="/saleorderController/payment" var="form_url"/>
						<form:form action="${form_url}" commandName="customer">	
							<table cellpadding = '10' align="center">														
								<tr>
									<td>First name:</td><td><form:input path="firstName" size="30" /></td>
								</tr>
								<tr>
									<td>Last name: </td><td><form:input path="lastName" size="30" /></td>
								</tr>
								<tr>
									<td>Address 1: </td><td><form:input path="address1" size="30" /></td>
								</tr>
								<tr>
									<td>Address 2: </td><td><form:input path="address2" size="30" /></td>
								</tr>
								<tr>
									<td>Address 3: </td><td><form:input path="address3" size="30" /></td>
								</tr>							
								<tr>				 		
									<form:hidden path="id" />
									<form:hidden path="email" />
									<input type="submit" value="Save" />
								</tr>
							</table>
						</form:form>
					
					
	<jsp:include page="footer.jsp" />