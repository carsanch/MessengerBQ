<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page session="false"%>
<html>
<head>
	<title>User List</title>
    <style type="text/css">
    <%@ include file="/resources/css/displaytag.css" %>
    </style>
    </head>
</head>
<body>
	<h1>User List</h1>
	<div class="mytable">
		<display:table name="${userList}" defaultorder="ascending" defaultsort="1" pagesize="30" sort="list" requestURI="/user/list">
			  <display:caption title="User list" />	
			  <display:column property="id" title="Id" sortable="true" defaultorder="ascending"/>
			  <display:column property="name" title="Name" sortable="true" defaultorder="ascending"/>
			  <display:column property="email" title="E-mail" sortable="true" defaultorder="ascending"/>
		</display:table>
	</div>
	<p><a href="../">Home</a></p>
</body>