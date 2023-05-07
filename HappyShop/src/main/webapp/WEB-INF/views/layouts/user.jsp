<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/assets/user" var="url" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title><decorator:title default="Master-layout"/></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap styles -->
<link href="${url}/css/bootstrap.css" rel="stylesheet" />
<!-- Customize styles -->
<link href="${url}/css/style.css" rel="stylesheet" />
<!-- font awesome styles -->
<link href="${url}/font-awesome/css/font-awesome.css" rel="stylesheet">
<!-- Favicons -->
<link rel="shortcut icon" href="${url}/ico/favicon.ico">
</head>

<body>
	
<!-- 
	Upper Header Section 
-->
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="topNav">
		<div class="container">
			<div class="alignR">
				<div class="pull-left socialNw">
					<a href="#"><span class="icon-twitter"></span></a> <a href="#"><span
						class="icon-facebook"></span></a> <a href="#"><span
						class="icon-youtube"></span></a> <a href="#"><span
						class="icon-tumblr"></span></a>
				</div>
				<a class="active" href="index.html"> <span class="icon-home"></span>
					Home
				</a> <a href="#"><span class="icon-user"></span> My Account</a> <a
					href="register.html"><span class="icon-edit"></span> Free
					Register </a> <a href="contact.html"><span class="icon-envelope"></span>
					Contact us</a> <a href="cart.html"><span class="icon-shopping-cart"></span>
					2 Item(s) - <span class="badge badge-warning"> $448.42</span></a>
			</div>
		</div>
	</div>
</div>

<!--
Lower Header Section 
-->
<div class="container">
	<div id="gototop"></div>
	<!-- header -->
	<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>
	
</div>
	
	<!-- Navigation Bar Section  -->
	<%@include file="/WEB-INF/views/layouts/user/navbar.jsp"%>
	<!-- Body -->
	<decorator:body />
	<!-- Footer -->
	<%@include file="/WEB-INF/views/layouts/user/footer.jsp"%>
</body>
</html>