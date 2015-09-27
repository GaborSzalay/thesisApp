<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="thesis-popup-page">
    <div class="form-group">
        <label for="titleInput"><spring:message code="message.thesis.title" text=""/></label>
        <div id="titleInput">
            <c:choose>
                <c:when test="${pageContext.response.locale == 'en'}">
                    ${thesis.titleEn}
                </c:when>
                <c:otherwise>
                    ${thesis.titleHu}
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="form-group">
        <label for="courses"><spring:message code="message.thesis.courses" text=""/></label>
        <div id="courses">
            <c:forEach var="course" items="${thesis.courses}">
                <div>${course.courseName}</div>
            </c:forEach>
        </div>
    </div>
    <div class="form-group">
        <label for="requiredSemestersInput"><spring:message code="message.thesis.required_semesters" text=""/></label>
        <div id="requiredSemestersInput">
            ${thesis.requiredSemesters}
        </div>
    </div>
    <div class="form-group">
        <label for="actualStudentLimit"><spring:message code="message.table.thesis.maximum_students" text=""/></label>
        <div id="actualStudentLimit">
            <c:forEach var="actualStudentLimit" items="${thesis.studentLimits}">
                <div>${actualStudentLimit.major.majorName} ${actualStudentLimit.limitOfStudents}</div>
            </c:forEach>
        </div>
    </div>
    <div class="form-group">
        <label for="descriptionHuInput"><spring:message code="message.thesis.description.hu" text=""/></label>
        <div id="descriptionHuInput">${thesis.descriptionHu}</div>
    </div>
    <div class="form-group">
        <label for="descriptionEnInput"><spring:message code="message.thesis.description.en" text=""/></label>
        <div id="descriptionEnInput">${thesis.descriptionEn}</div>
    </div>
</div>