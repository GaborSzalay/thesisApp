<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<t:teacherpage title="messages.header.title.teacher" currentPage="admins">

    <form id="create-thesis-form">
        <h2>Thesis</h2>
        <div class="form-group">
            <label for="titleHuInput">Hungarian Title</label>
            <input type="text" class="form-control" id="titleHuInput" placeholder="Hungarian Title">
        </div>
        <div class="form-group">
            <label for="titleEnInput">English Title</label>
            <input type="text" class="form-control" id="titleEnInput" placeholder="English Title">
        </div>
        <div class="form-group">
            <label for="thesisTypeInput">Thesis Type</label>
            <select id="thesisTypeInput" class="form-control">
                <option>Diplomadolgozat</option>
                <option>Szakdolgozat</option>
            </select>
        </div>
        <div class="form-group">
            <label for="coursesInput">Courses</label>
            <select multiple id="coursesInput" class="form-control">
                <option>Mérnöki tervezés</option>
                <option>Szakdolgozat</option>
            </select>
        </div>
        <div class="form-group">
            <label for="requiredSemestersInput">Required Semesters</label>
            <select id="requiredSemestersInput" class="form-control">
                <option>1</option>
                <option selected="selected">2</option>
                <option>3</option>
                <option>4</option>
            </select>
        </div>
        <div class="form-group">
            <label for="descriptionHuInput">Hungarian Description</label>
            <textarea id="descriptionHuInput" class="form-control" placeholder="Hungarian Description" rows="3"></textarea>
        </div>
        <div class="form-group">
            <label for="descriptionEnInput">English Description</label>
            <textarea id="descriptionEnInput" class="form-control" placeholder="English Description" rows="3"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Create Thesis</button>
    </form>

</t:teacherpage>