<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<t:teacherpage title="messages.header.title.teacher" currentPage="${currentMenu}">

    <table id="my-table" class="table table-hover">
        <thead>
            <tr>
                <th><spring:message code="messages.table.thesis" text=""/></th>
                <th><spring:message code="messages.header.title.student" text=""/></th>
                <th><spring:message code="messages.table.major" text=""/></th>
                <th><spring:message code="messages.table.creation_date" text=""/></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="studentRequest" items="${studentRequests}" varStatus="counter">
                <c:set var="studentPosition" value="${context.studentPositions.get(thesis.thesisId)}"/>
                <tr>
                    <td>${studentRequest.thesis.titleHu} <a class="thesis-popup" href="/teacher/show_thesis.html?thesis=${studentRequest.thesis.thesisId}"><i class="fa fa-book enabled"></i></a></td>
                    <td>${studentRequest.thesisStudent.thesisUser.email}</td>
                    <td>${studentRequest.thesisStudent.major.majorName} <a class="inline-popup" href="#student-position-info-${studentRequest.thesis.thesisId}"><i class="fa fa-info-circle"></i></a></td>
                    <td>${studentRequest.creationDate}</td>
                    <td>
                        <c:if test="${studentRequest.currentState eq 'SENT'}">
                            <a class="btn btn-primary" href="/teacher/accept_request.html?student-request=${studentRequest.studentRequestId}"><spring:message code="messages.table.teacher.request.accept" text=""/></a>
                            <a class="btn btn-danger" href="/teacher/decline_request.html?student-request=${studentRequest.studentRequestId}"><spring:message code="messages.table.teacher.request.decline" text=""/></a>
                        </c:if>
                        <c:if test="${studentRequest.currentState eq 'DECLINED'}">
                            <a class="btn btn-warning" href="/teacher/enable_request.html?student-request=${studentRequest.studentRequestId}"><spring:message code="messages.table.teacher.request.enable" text=""/></a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <c:forEach var="studentRequest" items="${studentRequests}" varStatus="counter">
        <c:set var="studentPosition" value="${studentPositions.get(studentRequest.thesis.thesisId)}"/>
        <div id="student-position-info-${studentRequest.thesis.thesisId}" class="thesis-popup-page white-popup-block mfp-hide">
            <div class="form-group">
                <label for="position-max"><spring:message code="messages.table.position.max" text=""/></label>
                <div id="position-max">${studentPosition.maxPositions}</div>
            </div>
            <div class="form-group">
                <label for="position-appointed"><spring:message code="messages.table.position.appointed" text=""/></label>
                <div id="position-appointed">${studentPosition.appointedPositions}</div>
            </div>
            <div class="form-group">
                <label for="position-open"><spring:message code="messages.table.position.open" text=""/></label>
                <div id="position-open">
                    <c:forEach var="openStudentPosition" items="${studentPosition.openStudentPositions}" varStatus="counter">
                        <c:if test="${openStudentPosition.value > 0}">
                            <div>${openStudentPosition.key} ${openStudentPosition.value}</div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
    </c:forEach>


</t:teacherpage>