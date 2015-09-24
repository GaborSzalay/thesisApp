<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:studentpage title="messages.header.title.student" currentPage="home" menutype="thesis_menu">
    <form class="comment-page" action="/student_thesis/create_comment.html" method="GET" accept-charset="UTF-8">
        <input type="hidden" name="thesisId" value="${thesis.thesisId}">
        <c:forEach var="comment" items="${comments}">
            <div class="form-group">
                <label for="comment-${comment.commentId}">${comment.thesisUser.email}</label>
                <div id="comment-${comment.commentId}">${comment.commentMessage}</div>
            </div>
        </c:forEach>
        <div class="form-group">
            <spring:message code="message.student.comment" text="" var="commentInputMessage"/>
            <label for="commentInput">${commentInputMessage}</label>
            <textarea id="commentInput" class="form-control" placeholder="${commentInputMessage}" rows="3" name="commentMessage"></textarea>
        </div>
        <button id="submit-button" type="submit" class="btn btn-primary">
            <spring:message code="message.student.comment.send" text=""/>
        </button>
    </form>
</t:studentpage>