<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:popup>

    <form class="thesis-popup-page registration-form" action="/create_account.html" method="POST" accept-charset="UTF-8">
        <spring:message code="messages.login.email" text="" var="emailMessage"/>
        <spring:message code="messages.login.password" text="" var="passwordMessage"/>
        <spring:message code="messages.table.major" text="" var="majorMessage"/>
        <spring:message code="messages.table.course" text="" var="courseMessage"/>
        <spring:message code="messages.table.name" text="" var="nameMessage"/>
        <div class="form-group">
            <label for="nameInput">${nameMessage}</label>
            <input type="text" id="nameInput" class="form-control" placeholder="${nameMessage}" name="name" value=""/>
        </div>
        <div class="form-group">
            <label for="emailInput">${emailMessage}</label>
            <input type="text" id="emailInput" class="form-control" placeholder="${emailMessage}" name="email" value=""/>
        </div>
        <div class="form-group">
            <label for="passwordInput">${passwordMessage}</label>
            <input type="password" id="passwordInput" class="form-control" placeholder="${passwordMessage}" name="password" value=""/>
        </div>
        <div class="form-group">
            <label for="majorInput">${majorMessage}</label>
            <select id="majorInput" class="form-control" name="majorId">
                <c:forEach var="major" items="${majors}">
                    <option value="${major.majorId}">${major.majorName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="courseInput">${courseMessage}</label>
            <select id="courseInput" class="form-control" name="courseId">
                <c:forEach var="course" items="${courses}">
                    <option value="${course.courseId}">${course.courseName}</option>
                </c:forEach>
            </select>
        </div>
        <button id="submit-button" type="submit" class="btn btn-primary">
            <spring:message code="message.registration.register" text=""/>
        </button>
        <jsp:include page="modules/security-check.jsp"/>
    </form>
</t:popup>