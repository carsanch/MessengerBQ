<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Add user</title>
</head>
<body>

<h2>User data</h2>
<form:form modelAttribute="userForm" method="post" action="${userActionUrl}" >
   <table>
    <tr>
        <td><form:label path="id">Id</form:label></td>
        <td><form:input path="id" /></td>
        <td><form:errors path="id" /></td>
    </tr>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
        <td><form:errors path="name" /></td>
        
    </tr>
    <tr>
        <td><form:label path="email">E-mail</form:label></td>
        <td><form:input path="email" /></td>
        <td><form:errors path="email" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>