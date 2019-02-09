<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="nts" uri="http://nts.com"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Session Tracker View Example</title>
</head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script  src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script  src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
<script type="text/javascript">
$(document).ready(function() {
    $('#sessionTracker').DataTable();
} );
</script>

<body>

<h1 align="left" ><img alt="NTS" src="/WEB-INF/download.jpg"></h1>
<h2></h2>
<h3></h3>
	<%
		request.setAttribute("sessionIDList", request.getSession().getAttribute("sessionTrackerList"));
	%>
	<table id="sessionTracker" class="display compact sdxDataTable"
		border=0 cellspacing="0" width="100%">
		<thead>
			<tr>
				<th style="width: 18%">Serial No</th>
				<th style="width: 18%">Session Id</th>
			</tr>
		</thead>
		
		<tbody>
			<c:set var="counter" value="1" />
			<c:forEach items="${sessionIDList}" var="item">
				<tr>
					<td style="padding-left: 2px; text-align: center">${counter}</td>
					<td style="padding-left: 2px; text-align: center">${item}</td>
				</tr>
				<c:set var="counter" value="${counter + 1}" />
			</c:forEach>
		</tbody>
		
		<tfoot>
			<tr>
				<nts:nav totalPageCount='10' viewPageCount="5" action="index.jsp" /><!-- this is the custom tag created by me-->
			</tr>
		</tfoot>
	</table>

</body>
</html>