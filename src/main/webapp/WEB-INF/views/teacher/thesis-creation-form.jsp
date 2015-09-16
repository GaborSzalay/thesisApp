<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:popup>

    <c:set var="isThesisAlreadyExisting" value="${not empty thesis and not empty thesis.thesisId}"/>

    <form class="thesis-popup-page" action="/teacher/create_thesis.html" method="POST" accept-charset="UTF-8">
        <c:if test="${isThesisAlreadyExisting}">
            <input type="hidden" name="thesisId" value="${thesis.thesisId}">
        </c:if>
        <h2><spring:message code="messages.table.thesis.title" text=""/></h2>
        <div class="form-group">
            <spring:message code="message.thesis.title.hu" text="" var="titleHuMessage"/>
            <label for="titleHuInput">${titleHuMessage}</label>
            <input type="text" id="titleHuInput" class="form-control" placeholder="${titleHuMessage}" name="titleHuInput" value="${thesis.titleHu}"/>
        </div>
        <div class="form-group">
            <spring:message code="message.thesis.title.en" text="" var="titleEnMessage"/>
            <label for="titleEnInput">${titleEnMessage}</label>
            <input id="titleEnInput" type="text" class="form-control" placeholder="${titleEnMessage}" name="titleEnInput" value="${thesis.titleEn}"/>
        </div>
        <spring:message code="message.thesis.courses" text="" var="coursesMessage"/>
        <label class="courses-main-label" for="courses">${coursesMessage}</label>
        <div class="btn-group" data-toggle="buttons" id="courses">
            <c:forEach var="course" items="${context.courses}" varStatus="counter">
                <c:if test="${isThesisAlreadyExisting}">
                    <c:forEach var="thesisCourse" items="${thesis.courses}">
                        <c:if test="${thesisCourse.courseId eq course.courseId}">
                            <c:set var="activeCourse" value="${course.courseId}" />
                        </c:if>
                    </c:forEach>
                </c:if>
                <label class="btn btn-default ${activeCourse eq course.courseId ? 'clicked' : ''}">
                    <input type="checkbox" id="courseIds" value="${course.courseId}" autocomplete="off" name="courseIds"/> ${course.courseName}
                </label>
            </c:forEach>
        </div>
        <div class="form-group">
            <c:choose>
                <c:when test="${isThesisAlreadyExisting}">
                    <c:set var="requiredSemesters" value="${thesis.requiredSemesters}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="requiredSemesters" value="2"/>
                </c:otherwise>
            </c:choose>
            <spring:message code="message.thesis.required_semesters" text="" var="requiredSemestersMessage"/>
            <label for="requiredSemestersInput">${requiredSemestersMessage}</label>
            <select id="requiredSemestersInput" class="form-control" name="requiredSemestersInput">
                <c:forEach var="requiredSemester" begin="1" end="4">
                    <c:choose>
                        <c:when test="${requiredSemesters == requiredSemester}">
                            <option selected="selected">${requiredSemester}</option>
                        </c:when>
                        <c:otherwise>
                            <option>${requiredSemester}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <div class="form-inline">
            <span class="custom-label"><spring:message code="message.table.thesis.maximum_students" text=""/></span>
            <spring:message code="message.table.thesis.maximum_students.number" text="" var="studentsNumber"/>
            <table>
                <c:forEach var="major" items="${context.majors}">
                    <c:if test="${isThesisAlreadyExisting}">
                        <c:forEach var="actualStudentLimit" items="${thesis.studentLimits}">
                            <c:if test="${actualStudentLimit.major.majorId eq major.majorId}">
                                <c:set var="studentLimitValue" value="${actualStudentLimit.limitOfStudents}"/>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <tr>
                        <td><label for="studentLimitNumber-${major.majorId}">${major.majorName}</label></td>
                        <td>
                            <select id="studentLimitNumber-${major.majorId}" class="form-control" name="studentLimitNumber-${major.majorId}">
                                <c:forEach var="studentLimit" begin="0" end="4">
                                    <c:choose>
                                        <c:when test="${(!isThesisAlreadyExisting and studentLimit == 0) or (isThesisAlreadyExisting and studentLimitValue == studentLimit)}">
                                            <option selected="selected">${studentLimit}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option>${studentLimit}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="form-group">
            <spring:message code="message.thesis.description.hu" text="" var="descriptionHuMessage"/>
            <label for="descriptionHuInput">${descriptionHuMessage}</label>
            <textarea id="descriptionHuInput" class="form-control" placeholder="${descriptionHuMessage}" rows="3" name="descriptionHuInput">${thesis.descriptionHu}</textarea>
        </div>
        <div class="form-group">
            <spring:message code="message.thesis.description.en" text="" var="descriptionEnMessage"/>
            <label for="descriptionEnInput">${descriptionEnMessage}</label>
            <textarea id="descriptionEnInput" class="form-control" placeholder="${descriptionEnMessage}" rows="3" name="descriptionEnInput">${thesis.descriptionEn}</textarea>
        </div>
        <button id="submit-button" type="submit" class="btn btn-primary">
            <spring:message code="${isThesisAlreadyExisting ? 'messages.table.thesis.update' : 'messages.table.thesis.create'}" text=""/>
        </button>
        <jsp:include page="../modules/security-check.jsp"/>
    </form>

</t:popup>
