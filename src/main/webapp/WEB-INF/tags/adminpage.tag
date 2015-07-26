<%@tag description="Signed-in User Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="title" required="true" %>
<t:signedinuserpage title="${title}">
    <jsp:attribute name="signed_in_header">
        <link rel="stylesheet" href="/resources/css/jquery.dynatable.css">
    </jsp:attribute>
    <jsp:attribute name="signed_in_footer">
        <script src="/resources/js/jquery.dynatable.js"></script>
        <script src="/resources/js/dynatable.basic.js"></script>
    </jsp:attribute>
    <jsp:body>

        <div>
            <a href="${menu.listAdminsLink}">
                <spring:message code="messages.admin.homepage.list.admins" text=""/>
            </a>
        </div>
        <div>
            <a href="${menu.listTeachersLink}">
                <spring:message code="messages.admin.homepage.list.teachers" text=""/>
            </a>
        </div>
        <div>
            <a href="">
                <spring:message code="messages.admin.homepage.list.students" text=""/>
            </a>
        </div>
        <div>
            <a href="${menu.listThesisTypesLink}">
                <spring:message code="messages.admin.homepage.list.thesis_types" text=""/>
            </a>
        </div>
        <div>
            <a href="${menu.listCoursesLink}">
                <spring:message code="messages.admin.homepage.list.courses" text=""/>
            </a>
        </div>
        <div>
            <a href="${menu.listMajorsLink}">
                <spring:message code="messages.admin.homepage.list.majors" text=""/>
            </a>
        </div>
        <jsp:doBody/>
    </jsp:body>
</t:signedinuserpage>