<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


	<jsp:include page="header.jsp" />
				
		<jsp:include page="linkDisplay.jsp" />
			
					<h3>Please Enter Payment Details:</h3>
					
				
				<c:url value="/saleorderController/pay" var="form_url"/>
					<form:form action="${form_url}" commandName="creditCard">
						<table cellpadding='10' align="center">
							<tr>
								<td>Customer Email Address: </td><td><form:input path="email" value="${email}" size="30" readonly="true" /></td>
							</tr>
							<tr>
								<td>Please Enter Card Holders Name </td><td><form:input path="name" size="30" /></td>
								<td><form:errors path="name" style="color:red" cssclass="error" ></form:errors></td>								
							</tr>
							<tr>
								<td>Please Enter Card Number: </td><td><form:input path="number"  size="30" /></td>
								<td><form:errors path="number" style="color:red" cssclass="error" ></form:errors></td>							
							</tr>
							<tr>
								<td>Please Enter Expiry Month</td><td><form:input path="expMonth" size="30" /></td>
								<td><form:errors path="expMonth" style="color:red" cssclass="error" ></form:errors></td>							
							</tr>
							<tr>
								<td>Please Enter Expiry year</td><td><form:input path="expYear" size="30" /></td>
								<td><form:errors path="expYear" style="color:red" cssclass="error" ></form:errors></td>							
							</tr>
							<tr>
								<td>PLease Enter Security Code</td><td><form:input path="securityCode" size="30" /></td>
								<td><form:errors path="securityCode" style="color:red" cssclass="error" ></form:errors></td>								
							</tr>
							<tr>
								<td>PLease Enter Card Type</td><td><form:input path="cardType" size="30" /></td>
								<td><form:errors path="cardType" style="color:red" cssclass="error" ></form:errors></td>							
							</tr>
							<tr>
								<form:hidden path="id" />
								<p><input type="submit" value="Save"/></p>
							</tr>
						</table>
					</form:form>

					
					
	<jsp:include page="footer.jsp" />
