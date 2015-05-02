<!-- this is the login.jsp page -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="header.jsp" />
			
<div id="content" style="text-align:center">
	<h3>Please Log In</h3>
 		<c:if test="${not empty errorMsg}">
			<div style="color:red;font-weight:bold;">
				Login attempt unsuccessful.<br />
			</div>
			</c:if>
 
			<form action="<c:url value='j_spring_security_check' />" method='POST'>
				<table align="center">
					<tr>
						<td>username:</td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td colspan='2'><input name="login" type="submit" value="Login" /></td>
					</tr>
				</table>
 			</form>
	</div>
 <jsp:include page="footer.jsp" />