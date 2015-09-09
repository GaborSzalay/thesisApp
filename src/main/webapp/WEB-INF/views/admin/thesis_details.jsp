<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="thesis-popup-page">
    <div class="form-group">
        <label for="titleHuInput"><spring:message code="message.thesis.title.hu" text=""/></label>
        <div id="titleHuInput">${thesis.titleHu}</div>
    </div>
    <div class="form-group">
        <label for="titleEnInput"><spring:message code="message.thesis.title.en" text=""/></label>
        <div id="titleEnInput">${thesis.titleEn}</div>
    </div>
    <div class="form-group">
        <label for="courses"><spring:message code="message.thesis.courses" text=""/></label>
        <div id="courses">
            <c:forEach var="course" items="${thesis.courses}">
                <div>${course.courseName}</div>
            </c:forEach>
        </div>
    </div>
</div>