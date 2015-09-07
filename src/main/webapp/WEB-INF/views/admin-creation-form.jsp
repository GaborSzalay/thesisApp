<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:popup>
    <form class="thesis-popup-page" action="/admin/create_admin.html" method="POST" accept-charset="UTF-8">
        <h2><spring:message code="messages.table.admin.title" text=""/></h2>
        <div class="form-group">
            <spring:message code="messages.table.email" text="" var="emailMessage"/>
            <label for="emailInput">${emailMessage}</label>
            <input type="text" id="emailInput" class="form-control" placeholder="${emailMessage}" name="email" value=""/>
        </div>
        <div class="form-group">
            <spring:message code="messages.login.password" text="" var="passwordMessage"/>
            <label for="passwordInput">${passwordMessage}</label>
            <input type="password" id="passwordInput" class="form-control" placeholder="${passwordMessage}" name="password" value=""/>
        </div>
        <button id="submit-button" type="submit" class="btn btn-primary">
            <spring:message code="messages.table.admin.create" text=""/>
        </button>
        <jsp:include page="modules/security-check.jsp"/>
    </form>
</t:popup>