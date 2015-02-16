<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>People</title>
    <META content="text/html; charset=utf-8" http-equiv="Content-Type">
</head>
<body>

<c:if test="${!empty peopleList}">
    <table class="data" cellspacing="5" cellpadding="10" rules="rows"
           border="1">
        <tr>
            <th>ID</th>
            <th>Last Name</th>
            <th>First Name</th>
            <th>Age</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${peopleList}" var="people">
            <tr>
                <td>${people.id}</td>
                <td>${people.lastName}</td>
                <td>${peopleId}</td>
                <td>${people.age}</td>
                <td><a href="/edit/?peopleId=4">edit</a></td>
                <td><a href="delete/${people.id}">delete</a></td>
            </tr>
        </c:forEach>
        <tr>
            <form:form method="post" action="/add" commandName="people">
                <td>&nbsp;</td>
                <td><form:input path="lastName"/></td>
                <td><form:input path="firstName"/></td>
                <td><form:input path="age"/></td>
                <td><input type="submit" value="add"/></td>
                <td>&nbsp;</td>
            </form:form>
        </tr>
    </table>
</c:if>


</body>
</html>