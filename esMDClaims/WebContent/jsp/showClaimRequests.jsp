<%@page import="com.hnexus.esmd.admins.domain.Admin"%>
<%@include file="taglib_includes.jsp" %>
<%@include file="includes/header.jsp" %>
 <script type="text/javascript">
   /* function OnDropDownChange(dropDown) {
        var selectedValue = dropDown.options[dropDown.selectedIndex].value;
        go('viewAllClaimRequests.do?page=currentPage&pageNumber='+selectedValue);
    }*/

    function OnDropDownChange(dropDown) {
        var selectedValue = dropDown.options[dropDown.selectedIndex].value;
        //go('viewAllClaimRequests.do?page=currentPage&pageNumber='+selectedValue);
        doAjax("currentPage", selectedValue, 'viewPaginationClaimRequest.do', 'pagination');
    }
 </script>
<div class="container_12">
<form:form method="post" id="showClaimRequests">

<c:choose>
<c:when test="${not empty CLAIM_REQUEST_LIST}">
<table width="100%" cellpadding="0" cellspacing="0">
<tr class="trmain" >
<td class="tdmain brleft brright brtop brbottom">Org Name</td>
<td class="tdmain brright brtop brbottom">Submition date</td>
<td class="tdmain brright brtop brbottom">Status</td>
<td class="tdmain brright brtop brbottom">Location</td>
<td class="tdmain brright brtop brbottom">User Name</td>
<td class="tdmain brright brtop brbottom">User Id</td>
</tr>
</table>
<table id="pagination"  width="100%" cellpadding="0" cellspacing="0">
<c:forEach var="claimreq" items="${CLAIM_REQUEST_LIST}">
<tr>
<td class="tdmain brleft brright brtop brbottom"><c:out value="${claimreq.orgnization.esmdOrgName}"></c:out></td>
<td class="tdmain brright brtop brbottom"><c:out value="${claimreq.esmdSubmissionTime}"></c:out></td>
<td class="tdmain brright brtop brbottom">Status</td>
<td class="tdmain brright brtop brbottom">Location</td>
<td class="tdmain brright brtop brbottom"><c:out value="${claimreq.esmdEnteredBy.esmdUserName}"></c:out></td>
<td class="tdmain brright brtop brbottom"><c:out value="${claimreq.esmdEnteredBy.esmdAdminId}"></c:out></td>
<td class="tdmain brright brtop brbottom"><a href="updateRequest.do?esmdRequestId=${claimreq.esmdRequestId}">Edit</a></td>
<td class="tdmain brright brtop brbottom"><a href="deleteRequest.do?esmdRequestId=${claimreq.esmdRequestId}">Delete</a></td>
</tr>
</c:forEach>

<tr>
<td class="tdmain brright brtop brbottom">
	<c:choose>
		<c:when test="${CURRENTPAGE != '0'}">
			<a href="#" onclick="doAjax('firstpage','0', 'viewPaginationClaimRequest.do', 'pagination');">First</a> / <a href="#" onclick="doAjax('previous','${CURRENTPAGE}', 'viewPaginationClaimRequest.do', 'pagination');">Previous</a>
		</c:when>
		<c:otherwise>
			<span>First</span> / <span>Previous</span>
		</c:otherwise>
	</c:choose>
</td>
<td class="tdmain brright brtop brbottom">
<!-- <select name="pageNo" onchange="OnDropDownChange(this)"> -->
<select name="pageNo" onchange="doAjax('currentPage', this.value, 'viewPaginationClaimRequest.do', 'pagination');">
	<c:forEach var="pageNo" begin="0" end="${TOTALPAGES-1}">
		<option value="${pageNo}" <c:if test="${pageNo eq CURRENTPAGE}" >selected</c:if>>${pageNo+1}</option>
	</c:forEach>
</select> / ${TOTALPAGES}
</td>
<!-- <td class="tdmain brright brtop brbottom"><a href="viewAllClaimRequests.do?page=currentPage&pageNumber=${CURRENTPAGE}">${CURRENTPAGE+1}</a> </td> -->

<td class="tdmain brright brtop brbottom">
<c:choose>
	<c:when test="${CURRENTPAGE != TOTALPAGES-1}">
		<a href="#" onclick="doAjax('next','${CURRENTPAGE}', 'viewPaginationClaimRequest.do', 'pagination');">Next</a> / <a href="#" onclick="doAjax('lastpage','${TOTALPAGES-1}', 'viewPaginationClaimRequest.do', 'pagination');">Last</a>
	</c:when>
	<c:otherwise>
		<span>Next</span> / <span>Last</span>
	</c:otherwise>
</c:choose>
</td>
</tr>
</table>
</c:when>
<c:otherwise>
<table>
	<tr class="trmain">
		<td>No Records found</td>
	</tr>
</table>
</c:otherwise>
</c:choose>

</form:form>
</div>
<%@include file="includes/footer.jsp" %>