<!-- this is the header.jsp page. I have created this JSP view once. 
then using the JSP include tag i can call it as mainly times as i want -->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<link rel="stylesheet" type="text/css" href='<c:url value ="/stylesheet/main.css"/>'/>
		
	<title>MCM Tools Ltd.</title>

</head>
	<body>
 			<div id='title' style="text-align:center">
				<h1>MCM Tools LTD</h1>				
			</div>
			
			<div id="content" style="text-align:center">