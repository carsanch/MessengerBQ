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
	<h1>Messages</h1>
	<form:form modelAttribute="myform" method="POST" action="">
	      <table>
	          <tr>
	              <td>User:</td>
	              <td>
	              	<form:select path="id">
	                <form:option value="0">--Please Select</form:option>
	                <form:options items="${userList}" itemValue="id" itemLabel="id" /><
	                </form:select>
	              </td>
	          </tr>
	          <tr>
	              <td colspan="2">
	                  <input type="submit" value="Apply Filter" />
	              </td>
	          </tr>
	      </table>
	</form:form>
	<div class="mytable">
		<display:table name="${messageList}" export="true" defaultorder="ascending" defaultsort="1" pagesize="30" sort="list" requestURI="/message/list">
			  <display:caption title="Messages" />	
			  <display:column property="userId" title="User" sortable="true" defaultorder="ascending"/>
			  <display:column property="body" title="Message"/>
		</display:table>
	</div>
	<p><a href="../">Home</a></p>
</body>