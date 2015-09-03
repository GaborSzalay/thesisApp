<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage title="Registration">

    <form action="/create_account.html" method="POST" accept-charset="UTF-8">
        Username:
        <input type="text" name="email">
        Password:
        <input type="text" name="password">
        <input type="submit" value="Submit">
        <jsp:include page="modules/security-check.jsp"/>
    </form>
</t:genericpage>