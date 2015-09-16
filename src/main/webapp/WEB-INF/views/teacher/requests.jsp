<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<t:teacherpage title="messages.header.title.admin" currentPage="requests">

    <table id="my-table" class="table table-hover">
        <thead>
            <tr>
                <th><spring:message code="messages.table.thesis" text=""/></th>
                <th><spring:message code="messages.header.title.student" text=""/></th>
                <th><spring:message code="messages.table.creation_date" text=""/></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="studentRequest" items="${studentRequests}" varStatus="counter">
                <c:set var="studentPosition" value="${context.studentPositions.get(thesis.thesisId)}"/>
                <tr>
                    <td>${studentRequest.thesis.titleHu}</td>
                    <td>${studentRequest.thesisStudent.thesisUser.email}</td>
                    <td>${studentRequest.thesisStudent.major.majorName}</td>
                    <td>${studentRequest.creationDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</t:teacherpage>