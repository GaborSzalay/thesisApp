<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:studentpage title="messages.header.title.student" currentPage="${currentPage}" menutype="beforethesis">

    <table id="my-table" class="table table-hover">
        <thead>
            <tr>
                <th><spring:message code="messages.table.name" text=""/></th>
                <th><spring:message code="messages.table.description" text=""/></th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="thesis" items="${theses}" varStatus="counter">
                <tr>
                    <td>${thesis.titleEn}</td>
                    <td>${thesis.descriptionEn}</td>
                    <td><a class="thesis-popup" href="/student/show_thesis.html?thesis=${thesis.thesisId}"><i class="fa fa-book enabled"></i></a></td>
                    <td>
                        <c:set var="currentStudentRequestState" value="NEW"/>
                        <c:forEach var="studentRequest" items="${thesis.studentRequests}" varStatus="counter">
                            <c:if test="${studentRequest.thesisStudent.thesisStudentId eq thesisStudentId}">
                                <c:if test="${studentRequest.currentState == 'NEW'}">
                                    <c:set var="currentStudentRequestState" value="NEW"/>
                                </c:if>
                                <c:if test="${studentRequest.currentState == 'SENT'}">
                                    <c:set var="currentStudentRequestState" value="SENT"/>
                                </c:if>
                                <c:if test="${studentRequest.currentState == 'CANCELED'}">
                                    <c:set var="currentStudentRequestState" value="CANCELED"/>
                                </c:if>
                                <c:if test="${studentRequest.currentState == 'DECLINED'}">
                                    <c:set var="currentStudentRequestState" value="DECLINED"/>
                                </c:if>
                                <c:if test="${studentRequest.currentState == 'ACCEPTED'}">
                                    <c:set var="currentStudentRequestState" value="ACCEPTED"/>
                                </c:if>
                            </c:if>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${currentStudentRequestState == 'NEW' or currentStudentRequestState == 'CANCELED'}">
                                <a class="btn btn-primary" href="/student/student_request.html?thesis=${thesis.thesisId}"><spring:message code="messages.table.student.request.send" text=""/></a>
                            </c:when>
                            <c:when test="${currentStudentRequestState == 'SENT'}">
                                <a class="btn btn-warning" href="/student/cancel_request.html?thesis=${thesis.thesisId}"><spring:message code="messages.table.student.request.cancel" text=""/></a>
                            </c:when>
                            <c:when test="${currentStudentRequestState == 'DECLINED'}">
                                <a class="btn btn-danger" href="#" disabled="disabled"><spring:message code="messages.table.student.request.declined" text=""/></a>
                            </c:when>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</t:studentpage>