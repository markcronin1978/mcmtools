<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


	<jsp:include page="header.jsp" />    <!-- I am including the Header.jsp page -->
	
		<jsp:include page="linkDisplay.jsp" />
			
			<p>Add Customer</p>
				<c:url value="/customer/" var="form_url"/>    
					<form:form action="${form_url}" commandName="customer">    <!-- This is the customer form.  -->
						<table align="center">
							<tr>
								<td>First name: </td>
								<td><form:input path="firstName" size="50" /></td>
							</tr>
							<tr>
								<td>Last name: </td>
								<td><form:input path="lastName" size="50" /></td>
							</tr>
							<tr>
								<td>Address 1:</td>
								<td><form:input path="address1" size="50" /></td>
							</tr>
							<tr>
								<td>Address 2:</td>
								<td><form:input path="address2" size="50" /></td>								
							</tr>
							<tr>
								<td>Address 3:</td>
								<td><form:input path="address3" size="50" /></td>								
							</tr>
							<tr>
								<td>Email Address</td>
								<td><form:input path="email" size="50" /></td>							
							</tr>
							<tr>
								<td>Password</td>
								<td><form:input path="password" size="50" /></td>								
							</tr>
							<tr>						
								<td><form:hidden path="id" /></td>
								<td><input type="submit" value="Save" /></td>
							</tr>
						</table>
					</form:form>
					
					<p>Igor i have added this link so that you can revert back to the <a href='<c:url value="/"/>'>the Content page</a></p>
					
	<jsp:include page="footer.jsp" />