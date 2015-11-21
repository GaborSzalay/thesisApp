<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:popup>
    <form class="thesis-popup-page" action="/admin/major.html" method="POST" accept-charset="UTF-8">
        <h2><spring:message code="messages.table.major" text=""/></h2>

        <c:if test="${not empty major}">
            <input type="hidden" name="majorId" value="${major.majorId}">
        </c:if>

        <div class="form-group">
            <spring:message code="messages.table.name" text="" var="nameMessage"/>
            <label for="nameInput">${nameMessage}</label>
            <input type="text" id="nameInput" class="form-control" placeholder="${nameMessage}" name="name" value="${major.majorName}"/>
        </div>

        <button id="submit-button" type="submit" class="btn btn-primary">
            <c:choose>
                <c:when test="${not empty major}">
                    <c:set var="submitButtunText" value="messages.table.major.edit"/>
                </c:when>
                <c:otherwise>
                    <c:set var="submitButtunText" value="messages.table.major.create"/>
                </c:otherwise>
            </c:choose>
            <spring:message code="${submitButtunText}" text=""/>
        </button>
        <jsp:include page="../modules/security-check.jsp"/>
    </form>
</t:popup>