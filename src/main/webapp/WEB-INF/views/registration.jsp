<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage title="Registration">

    <form action="/create_account.html" method="POST" accept-charset="UTF-8">
        Username:
        <br>
        <input type="text" name="email">
        <br>
        Password:
        <br>
        <input type="text" name="password">
        <br>
        <br>
        <input type="radio" name="authority" value="ROLE_ADMIN" checked>
        ADMIN
        <input type="radio" name="authority" value="ROLE_TEACHER" checked>
        TEACHER
        <input type="radio" name="authority" value="ROLE_STUDENT" checked>
        STUDENT
        <input type="submit" value="Submit">
        <jsp:include page="modules/security-check.jsp"/>
    </form>
</t:genericpage>