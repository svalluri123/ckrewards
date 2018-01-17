
<!-- ALL THE HEADER -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calvin Klein - ${title}</title>

<!-- <link href="./styles/global.css" rel="stylesheet" type="text/css"
	media="all" /> -->
<link href="<c:url value="/resources/css/custom.css" />"
	rel="stylesheet" type="text/css" media="all" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/custom.js" />"></script>


</head>

<body>
	<div id="wrapper">
		<header>
			<div id="topHeader">
				<div class="leftHeader">
					<img src="<c:url value="/resources/imgs/logo.gif" />"
						alt="Logo" />
				</div>

				<div class="rightHeader">
					<a href="<c:url value="/signin" />" />SignIn</a>
					| <a href="<c:url value="/signup" />" />SignUp</a>
				</div>
			</div>
			<div id="subheader">
				<a href="<c:url value="/" />">Home</a>
				&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp; <a
					href="about">About</a>
			</div>
			<div class="line"></div>
		</header>