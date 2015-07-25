<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:signedinuserpage title="Admin Home">
    <p>Hello admin! Do what you have to do.</p>

    <div>
        <a href="${context.listAdminsLink}">
            <spring:message code="messages.admin.homepage.list.admins" text=""/>
        </a>
    </div>
    <div>
        <a href="${context.listTeachersLink}">
            <spring:message code="messages.admin.homepage.list.teachers" text=""/>
        </a>
    </div>
    <div>
        <a href="">
            <spring:message code="messages.admin.homepage.list.students" text=""/>
        </a>
    </div>
    <div>
        <a href="${context.listThesisTypesLink}">
            <spring:message code="messages.admin.homepage.list.thesis_types" text=""/>
        </a>
    </div>
    <div>
        <a href="${context.listCoursesLink}">
            <spring:message code="messages.admin.homepage.list.courses" text=""/>
        </a>
    </div>
    <div>
        <a href="${context.listMajorsLink}">
            <spring:message code="messages.admin.homepage.list.majors" text=""/>
        </a>
    </div>


</t:signedinuserpage>