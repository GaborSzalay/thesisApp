<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:teacherpage title="messages.header.title.teacher" currentPage="admins">

    <c:set var="isThesisAlreadyExisting" value="${not empty thesis and not empty thesis.thesisId}"/>

    <form id="create-thesis-form" action="/teacher/create_thesis.html" method="POST" accept-charset="UTF-8">
        <c:if test="${isThesisAlreadyExisting}">
            <input type="hidden" name="thesisId" value="${thesis.thesisId}">
        </c:if>
        <h2>Thesis</h2>
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


                    <option value="${thesisType.thesisTypeId}">${thesisType.typeName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="btn-group" data-toggle="buttons" id="courses">
            <label class="courses-main-label" for="courses">Courses</label>
            <c:forEach var="course" items="${context.courses}" varStatus="counter">
                <label class="btn btn-default">
                    <input type="checkbox" id="courseIds" value="${course.courseId}" autocomplete="off" name="courseIds"/> ${course.courseName}
                </label>
            </c:forEach>
        </div>
        <div class="form-group">
            <label for="requiredSemestersInput">Required Semesters</label>
            <select id="requiredSemestersInput" class="form-control" name="requiredSemestersInput">
                <option>1</option>
                <option selected="selected">2</option>
                <option>3</option>
                <option>4</option>
            </select>
        </div>
        <div class="form-group">
            <label for="descriptionHuInput">Hungarian Description</label>
            <textarea id="descriptionHuInput" class="form-control" placeholder="Hungarian Description" rows="3" name="descriptionHuInput"></textarea>
        </div>
        <div class="form-group">
            <label for="descriptionEnInput">English Description</label>
            <textarea id="descriptionEnInput" class="form-control" placeholder="English Description" rows="3" name="descriptionEnInput"></textarea>
        </div>
        <button id="submit-button" type="submit" class="btn btn-primary">Create Thesis</button>
        <jsp:include page="modules/security-check.jsp"/>
    </form>

</t:teacherpage>