<!-- This is the opening view of the application. -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="header.jsp" />			

	<p>Welcome to MCMTools LTD. We are currrently the largest supplier of Motorsport tools and equipment.</p>
	<p>We can supply all tools and equipment required for car restoration and maintenance.</p>
	<p>If you are a existing Customer than <a href='<c:url value="/saleorderController/"/>'>Login</a> here</p>
    	
<jsp:include page="footer.jsp" />