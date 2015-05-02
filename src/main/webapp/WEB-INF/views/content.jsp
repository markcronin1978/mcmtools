<!-- This is the opening view of the application. -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="header.jsp" />			

	<p>Welcome to MCMTools LTD. We are currrently the largest supplier of Motorsport tools and equipment.</p>
	<p>We can supply all tools and equipment required for car restoration and maintenance.</p>
	<p>If you are a existing Customer than <a href='<c:url value="/login"/>'>Login</a> here</p>
	</br>
	</br>
	<p>Hi Igor, what i have done so far is as followings:</p>
	<p><a href='<c:url value="/customer/"/>'>List All Customers</a></p>
	<p><a href='<c:url value="/customer/add"/>'>Add A Customer</a></p>
	<p><a href='<c:url value="/product/"/>'>List all Products</a></p>
    <p><a href='<c:url value="/product/add"/>'>Add A product</a></p>
    <p>if you click on the login link a above it will start the purchasing process but thats not finished yet.</p>
    <p>Some of it is hard coded and it just returns to the list of product views at the payment stage</p>	
<jsp:include page="footer.jsp" />