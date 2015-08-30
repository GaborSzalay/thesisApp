<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:popup>
    <form id="create-thesis-form" action="/teacher/create_thesis.html" method="POST" accept-charset="UTF-8">
        <h2><spring:message code="messages.table.admin.title" text=""/></h2>
        <jsp:include page="modules/security-check.jsp"/>
    </form>
</t:popup>