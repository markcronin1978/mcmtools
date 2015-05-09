<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


	<jsp:include page="header.jsp" />
	
		<jsp:include page="linkDisplay.jsp" />
                            
			
			<p>Add Product</p>
				<c:url value="/product/" var="form_url"/>
				 	<form:form method="post" action="${form_url}" commandName="product">
						<table align="center">
							<tr>
								<td>Stock Keeping Unit:</td>
								<td><form:input path="SKU" size="50" /></td>
							</tr>
							<tr>
								<td>Name:</td> 
								<td><form:input path="name" size="50" /></td>
								<td><form:errors path="name" style="color:red" cssclass="error" /></td>
							</tr>
							<tr>
								<td>Description:</td>
								<td><form:input path="description" size="50" /></td>
								<td><form:errors path="description" style="color:red" cssclass="error" /></td>
							</tr>
							<tr>
								<td>Price Per Unit:</td>
								<td><form:input path="pricePerUnit" size="50" /></td>
							</tr>
							<tr>
								<td>Stock Level:</td>
								<td><form:input path="stockLevel" size="50" /></td>
							</tr>
							<tr>
								<td><form:hidden path="id" /></td>
								<td><input type="submit" value="Save"/></td>
							</tr>
						</table>
					</form:form>
	
	<jsp:include page="footer.jsp" />