<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage title="Admin Home">
    <p>Hello admin! Do what you have to do.</p>

    <div>
        <a href="${context.listAdminsLink.url}">
            <spring:message code="${context.listAdminsLink.message.key}" text=""/>
        </a>
    </div>
    <div>
        <a href="${context.listTeachersLink.url}">
            <spring:message code="${context.listTeachersLink.message.key}" text=""/>
        </a>
    </div>
    <div>
        <a href="${context.listThesisTypesLink.url}">
            <spring:message code="${context.listThesisTypesLink.message.key}" text=""/>
        </a>
    </div>
    <div>
        <a href="${context.listCoursesLink.url}">
            <spring:message code="${context.listCoursesLink.message.key}" text=""/>
        </a>
    </div>
    <div>
        <a href="${context.listMajorsLink.url}">
            <spring:message code="${context.listMajorsLink.message.key}" text=""/>
        </a>
    </div>

    <jsp:include page="modules/logout-form.jsp"/>
</t:genericpage>