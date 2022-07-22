<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="App.Title"></spring:message> </title>
<script type="text/javascript">
if(typeof String.prototype.trim !== 'function') {
  String.prototype.trim = function() {
    return this.replace(/^\s+|\s+$/g, ''); 
  };
}
</script>
<%@ include file="links.jsp"%>
</head>
<body>
<div class="container_12">
<div class="container_12 headeroutercontainer" >
<div style="float:left; margin:10px; width:380px;"><img src="images/logo.png" />
<div><small>Claims Application</small></div>
<div><small>Electronic Submission of Medical Documentation System (esMD)</small></div></div>
</div>
<div class="container_12 menuoutercontainer" >
<a href="home.do"><div class="menutab brleft brright brbottom"><div style="padding:3px;">Home</div></div></a>

<c:choose>
	<c:when test="${not empty LOGGEDINUSER}">
		<a href="viewAllClaimRequests.do"><div class="menutab brright brbottom"><div style="padding:3px;">Claim Requests List</div></div></a>
		<a href="saveRequest.do"><div class="menutab brright brbottom"><div style="padding:3px;">Claim Requests Form</div></div></a>
		<a href="logoutAdmin.do">
			<div style="float: right; width: auto; display: block; height: 25px;">
				<div style="padding: 3px;">Sign out</div>
			</div>
		</a>
		<div style="float: right; width: auto; display: block; height: 25px;"><div style="padding:3px; font-weight: bold;">${LOGGEDINUSER.esmdUserName}</div></div>
	</c:when>
	<c:otherwise>
		<a href="loginAdmin.do">
				<div style="float: right; width: auto; display: block; height: 25px;">
					<div style="padding: 3px;">Sign in</div>
				</div>
		</a>

	</c:otherwise>
</c:choose>
</div>