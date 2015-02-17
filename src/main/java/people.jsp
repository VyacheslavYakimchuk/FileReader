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
            <th>Country</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${peopleList}" var="people">
            <c:choose>
                <c:when test="${peopleId!=people.id}">
                    <tr>
                        <td>${people.id}</td>
                        <td>${people.lastName}</td>
                        <td>${people.firstName}</td>
                        <td>${people.age}</td>
                        <td>${people.country}</td>
                        <td><a href="/?peopleId=${people.id}">edit</a></td>
                        <td><a href="delete/${people.id}">delete</a></td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <form:form method="post" action="/add" commandName="people">
                            <td><form:input path="id" readonly="true" value="${people.id}"/></td>
                            <td><form:input path="lastName" value="${people.lastName}"/></td>
                            <td><form:input path="firstName" value="${people.firstName}"/></td>
                            <td><form:input path="age" value="${people.age}"/></td>
                            <td>
                                <form:select path="country">
                                    <form:option value="NONE" label="--- Select ---"/>
                                    <form:options items="${countryList}"/>
                                </form:select>
                            </td>
                            <td>
                                <input type="submit" value="save"/>

                                <form action="/">
                                    <input type="submit" value="cancel"/>
                                </form>
                            </td>
                        </form:form>
                    </tr>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <tr>
            <form:form method="post" action="/add" commandName="people">
                <td>&nbsp;</td>
                <td><form:input path="lastName"/></td>
                <td><form:input path="firstName"/></td>
                <td><form:input path="age"/></td>
                <td>
                    <form:select path="country">
                        <form:option value="NONE" label="--- Select ---"/>
                        <form:options items="${countryList}"/>
                    </form:select>
                </td>
                <td><input type="submit" value="add"/></td>
                <td>&nbsp;</td>
            </form:form>
        </tr>
    </table>
</c:if>
<br><br><br>
<!PETS>
<c:if test="${!empty petList}">
    <table class="data" cellspacing="5" cellpadding="10" rules="rows"
           border="1">
        <tr>
            <th>ID</th>
            <th>Nick Name</th>
            <th>Species</th>
            <th>Age</th>
            <th>People</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${petList}" var="pet">
            <c:choose>
                <c:when test="${pet.id!=petId}">
                    <tr>
                        <td>${pet.id}</td>
                        <td>${pet.nickName}</td>
                        <td>${pet.species}</td>
                        <td>${pet.age}</td>
                        <td>${pet.people}</td>
                        <td><a href="/?petId=${pet.id}">edit</a></td>
                        <td><a href="deletePet/${pet.id}">delete</a></td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <form:form method="post" action="/addPet" commandName="pet">
                            <td><form:input path="id" readonly="true" value="${pet.id}"/></td>
                            <td><form:input path="nickName" value="${pet.nickName}"/></td>
                            <td><form:input path="species" value="${pet.species}"/></td>
                            <td><form:input path="age" value="${pet.age}"/></td>
                            <td>
                                <form:select path="people">
                                    <form:option value="NONE" label="--- Select ---"/>
                                    <form:options items="${peopleList}"/>
                                </form:select>
                            </td>
                            <td>
                                <input type="submit" value="save"/>
                                <form action="/">
                                    <input type="submit" value="cancel"/>
                                </form>
                            </td>
                        </form:form>
                    </tr>
                </c:otherwise>
            </c:choose>

        </c:forEach>
        <tr>
            <form:form method="post" action="/addPet/${people.id}" commandName="pet">
                <td>&nbsp;</td>
                <td><form:input path="nickName"/></td>
                <td><form:input path="species"/></td>
                <td><form:input path="age"/></td>
                <td>
                    <form:select path="people">
                        <form:option value="NONE" label="--- Select ---"/>
                        <form:options items="${peopleList}"/>
                    </form:select>
                </td>
                <td><input type="submit" value="add"/></td>
                <td>&nbsp;</td>
            </form:form>
        </tr>
    </table>
</c:if>

</body>
</html>