<%@tag description="List Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="title" required="true" %>
<t:genericpage title="${title}">
    <jsp:attribute name="header">
        <link rel="stylesheet" href="/resources/css/jquery.dynatable.css">
    </jsp:attribute>
    <jsp:attribute name="footer">
        <script src="/resources/js/jquery.dynatable.js"></script>
        <script src="/resources/js/dynatable.basic.js"></script>
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody/>
    </jsp:body>
</t:genericpage>