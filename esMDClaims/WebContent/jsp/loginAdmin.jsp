<%@include file="taglib_includes.jsp" %>
<%@include file="includes/header.jsp" %>

<div class="container_12">
<ul style="margin:auto; width:350px; height:150px;  border:1px solid #66991C; margin-bottom:30px;">
<li style="background-color: #66991C "><h3 style="font-family: Crete Round,Trebuchet MS,Sans-Serif; color:#ffffff; margin-left:5px;">Sign in</h3></li>

<form:form action="loginAdmin.do" method="post" commandName="loginAdmin">
<c:if test="${not empty ERROR}"><div align="center" style="color: red;"><c:out value="${ERROR}"></c:out></div></c:if>
<form:errors path="esmdUserName" cssStyle="color:red"></form:errors>
<form:errors path="esmdPassword" cssStyle="color:red"></form:errors> 
<li style="float:left;  width:80px; height:30px; padding:2px;"><spring:message code="label.adminusername"></spring:message></li>
<li style="float:left;  width:200px; height:30px; padding:2px;"><form:input type="text" path="esmdUserName" id="esmdUserName"/></li>
<li style="float:left;  width:80px; height:30px; padding:2px;"><spring:message code="label.adminpassword"></spring:message></li>
<li style="float:left;  width:200px; height:30px; padding:2px;"><form:password path="esmdPassword"/></li>
<li style="float:left;  width:80px; height:30px; padding:2px;"></li>
<li style="float:left;  width:200px; height:30px; padding:2px;"><input type="submit" name="" value="Submit"></li>
</form:form>
</ul>

</div>
<%@include file="includes/footer.jsp" %>
