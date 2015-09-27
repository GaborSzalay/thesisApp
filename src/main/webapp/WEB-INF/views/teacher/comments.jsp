<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:teacherpage title="messages.header.title.teacher" currentPage="home">
    <table class="table comment-page">
        <tr>
            <th><spring:message code="messages.table.name" text=""/></th>
            <th><spring:message code="messages.table.neptun" text=""/></th>
            <th><spring:message code="messages.table.major" text=""/></th>
        </tr>
        <c:forEach var="student" items="${thesis.thesisStudents}" varStatus="counter">
            <tr>
                <td>${student.thesisUser.name}</td>
                <td>${student.neptunCode}</td>
                <td>${student.major.majorName}</td>
            </tr>
        </c:forEach>
    </table>

    <jsp:include page="../shared/comments_form.jsp"/>
</t:teacherpage>