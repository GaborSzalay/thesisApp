<%@tag description="Signed-in User Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="title" required="true" %>
<%@attribute name="signed_in_header" fragment="true" %>
<%@attribute name="signed_in_footer" fragment="true" %>
<t:genericpage title="${title}">
    <jsp:attribute name="header">
        <jsp:invoke fragment="signed_in_header"/>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <jsp:invoke fragment="signed_in_footer"/>
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody/>

    </jsp:body>
</t:genericpage>