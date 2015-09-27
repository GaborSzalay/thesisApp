<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<t:teacherpage title="messages.header.title.teacher" currentPage="ownThesises">
    <a class="thesis-popup btn btn-primary create-button" href="/teacher/create_thesis.html"><spring:message code="messages.teacher.menu.create_thesis" text=""/></a>
    <table id="my-table" class="table table-hover">
        <thead>
            <tr>
                <th><spring:message code="messages.table.name" text=""/></th>
                <th><spring:message code="messages.table.description" text=""/></th>
                <th><spring:message code="messages.table.position" text=""/></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="thesis" items="${context.thesises}" varStatus="counter">
                <c:set var="studentPosition" value="${context.studentPositions.get(thesis.thesisId)}"/>
                <tr>
                    <td>
                        <c:choose>
                            <c:when test="${fn:length(thesis.thesisStudents) > 0}">
                                <a href="/teacher/comments.html?thesisId=${thesis.thesisId}">
                                    <c:choose>
                                        <c:when test="${pageContext.response.locale == 'en'}">
                                            ${thesis.titleEn}
                                        </c:when>
                                        <c:otherwise>
                                            ${thesis.titleHu}
                                        </c:otherwise>
                                    </c:choose>
                                </a>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${pageContext.response.locale == 'en'}">
                                        ${thesis.titleEn}
                                    </c:when>
                                    <c:otherwise>
                                        ${thesis.titleHu}
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${pageContext.response.locale == 'en'}">
                                ${thesis.descriptionEn}
                            </c:when>
                            <c:otherwise>
                                ${thesis.descriptionHu}
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        ${studentPosition.maxPositions} / ${studentPosition.appointedPositions} / ${studentPosition.openPositions}  <a class="inline-popup" href="#student-position-info-${thesis.thesisId}"><i class="fa fa-info-circle"></i></a>
                    </td>
                    <td>
                        <a class="thesis-popup" href="/teacher/create_thesis.html?editThesis=${thesis.thesisId}"><i class="fa fa-pencil"></i></a>
                        <i class="fa fa-trash-o"></i>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <c:forEach var="thesis" items="${context.thesises}" varStatus="counter">
        <c:set var="studentPosition" value="${context.studentPositions.get(thesis.thesisId)}"/>
        <div id="student-position-info-${thesis.thesisId}" class="thesis-popup-page white-popup-block mfp-hide">
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