
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calvin Klein - Preferred Program</title>

<!-- <link href="./styles/global.css" rel="stylesheet" type="text/css"
	media="all" /> -->
<link href="${pageContext.request.contextPath}/styles/custom.css" rel="stylesheet" type="text/css"
	media="all" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom.js"></script>
<script>

</script>

</head>
<body>
	<div id="wrapper">
		<div class="rel" id="content">
			<header>
				<div id="topHeader">
					<div class="leftHeader">
						<img src="${pageContext.request.contextPath}/images/logo.gif"
							alt="" />
					</div>
					
					<div class="rightHeader">
						<a id="signout" href="${pageContext.request.contextPath}/index.jsp">SignOut</a><%--  | <a href="${pageContext.request.contextPath}/jsp/signup.jsp">Home</a> --%>
					</div>
				</div>
				<div id="subheader">
					<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
					&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp; <a
						href="${pageContext.request.contextPath}/jsp/about.jsp">About</a>
				</div>
<div class="line"></div>
			</header>
			
			<div id="contents">

			<div id="welcomeContent">
			
				<div class ="newId"> Your New Member Id is : <%= session.getAttribute("memberId") %> </div>
				<br /> <br />
				<img src="${pageContext.request.contextPath}/images/welcome.jpg">
			</div>

		</div>
	</div>

	<%@include file="../jsp/fragments/footer.jsp"%>
