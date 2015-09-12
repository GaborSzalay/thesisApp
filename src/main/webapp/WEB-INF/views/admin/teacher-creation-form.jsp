<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:popup>
    <form class="thesis-popup-page" action="/admin/teacher.html" method="POST" accept-charset="UTF-8">
        <h2><spring:message code="messages.table.teacher.title" text=""/></h2>

        <jsp:include page="user-creation-elements.jsp"/>

        <button id="submit-button" type="submit" class="btn btn-primary">
            <spring:message code="messages.table.teacher.create" text=""/>
        </button>
        <jsp:include page="../modules/security-check.jsp"/>
    </form>
</t:popup>