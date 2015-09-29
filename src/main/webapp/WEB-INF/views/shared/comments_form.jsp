<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<form class="comment-page" action="/${commentTarget}/create_comment.html" method="GET" accept-charset="UTF-8">
    <input type="hidden" name="thesisId" value="${thesis.thesisId}">
    <c:choose>
        <c:when test="${thesis.status == 'IN_PROGRESS'}">
            <div class="form-group">
                <spring:message code="message.student.comment" text="" var="commentInputMessage"/>
                <label for="commentInput">${commentInputMessage}</label>
                <textarea id="commentInput" class="form-control" placeholder="${commentInputMessage}" rows="3" name="commentMessage"></textarea>
            </div>
            <button id="submit-button" type="submit" class="btn btn-primary comment-submit-button">
                <spring:message code="message.student.comment.send" text=""/>
            </button>
        </c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="${pageContext.response.locale == 'en'}">
                    <c:set var="title" value="${thesis.titleEn}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="title" value="${thesis.titleHu}"/>
                </c:otherwise>
            </c:choose>
            <span id="status-report">
                <c:choose>
                    <c:when test="${thesis.status == 'ACCEPTED'}">
                        ${title} <span class="label label-success"><spring:message code="messages.table.teacher.thesis.status.accepted" text=""/></span>
                        <spring:message code="messages.table.teacher.thesis.status.ending" text="" arguments="${thesis.thesisTeacher.thesisUser.name}"/>
                    </c:when>
                    <c:otherwise>
                        ${title} <span class="label label-danger"><spring:message code="messages.table.teacher.thesis.status.declined" text=""/></span>
                        <spring:message code="messages.table.teacher.thesis.status.ending" text="" arguments="${thesis.thesisTeacher.thesisUser.name}"/>
                    </c:otherwise>
                </c:choose>
            </span>
        </c:otherwise>
    </c:choose>
    <c:forEach var="comment" items="${comments}">
        <div class="form-group">
            <label for="comment-${comment.commentId}">${comment.thesisUser.name}</label>
            <span class="comment-date">${comment.creationDate}</span>
            <div id="comment-${comment.commentId}"><pre>${comment.commentMessage}</pre></div>
        </div>
    </c:forEach>
</form>