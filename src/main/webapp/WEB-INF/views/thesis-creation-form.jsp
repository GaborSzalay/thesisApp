<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:popup>

    <c:set var="isThesisAlreadyExisting" value="${not empty thesis and not empty thesis.thesisId}"/>

    <form id="create-form" action="/teacher/create_thesis.html" method="POST" accept-charset="UTF-8">
        <c:if test="${isThesisAlreadyExisting}">
            <input type="hidden" name="thesisId" value="${thesis.thesisId}">
        </c:if>
        <h2><spring:message code="messages.table.thesis.title" text=""/></h2>
        <div class="form-group">
            <label for="titleHuInput">Hungarian Title</label>
            <input type="text" id="titleHuInput" class="form-control" placeholder="Hungarian Title" name="titleHuInput" value="${thesis.titleHu}"/>
        </div>
        <div class="form-group">
            <label for="titleEnInput">English Title</label>
            <input id="titleEnInput" type="text" class="form-control" placeholder="English Title" name="titleEnInput" value="${thesis.titleEn}"/>
        </div>
        <div class="form-group">
            <label for="thesisTypeInput">Thesis Type</label>
            <select id="thesisTypeInput" class="form-control" name="thesisTypeInput">
                <c:forEach var="thesisType" items="${context.thesisTypes}" varStatus="counter">
                    <c:choose>
                        <c:when test="${isThesisAlreadyExisting and thesisType.thesisTypeId == thesis.thesisType.thesisTypeId}">
                            <option value="${thesisType.thesisTypeId}" selected="selected">${thesisType.typeName}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${thesisType.thesisTypeId}">${thesisType.typeName}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <div class="btn-group" data-toggle="buttons" id="courses">
            <label class="courses-main-label" for="courses">Courses</label>
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
            <label for="requiredSemestersInput">Required Semesters</label>
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
            <div class="studentLimitContainer">
                <div class="studentLimitLine">
                    <a class="add-new-student-limit" href="#"><i class="fa fa-plus"></i></a>
                    <div class="form-group">
                        <select id="studentLimitMajor0" class="form-control" name="studentLimitMajor0">
                            <c:forEach var="major" items="${context.majors}">
                                <option value="${major.majorId}">${major.majorName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <spring:message code="message.table.thesis.maximum_students.number" text="" var="studentsNumber"/>
                        <label for="studentLimitNumber0">${studentsNumber}</label>
                        <input type="text" id="studentLimitNumber0" class="form-control" placeholder="${studentsNumber}" name="studentLimitNumber0" value=""/>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="descriptionHuInput">Hungarian Description</label>
            <textarea id="descriptionHuInput" class="form-control" placeholder="Hungarian Description" rows="3" name="descriptionHuInput">${thesis.descriptionHu}</textarea>
        </div>
        <div class="form-group">
            <label for="descriptionEnInput">English Description</label>
            <textarea id="descriptionEnInput" class="form-control" placeholder="English Description" rows="3" name="descriptionEnInput">${thesis.descriptionEn}</textarea>
        </div>
        <button id="submit-button" type="submit" class="btn btn-primary">
            <spring:message code="${isThesisAlreadyExisting ? 'messages.table.thesis.update' : 'messages.table.thesis.create'}" text=""/>
        </button>
        <jsp:include page="modules/security-check.jsp"/>
    </form>

</t:popup>
