<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<t:adminpage title="messages.header.title.admin" currentPage="teachers">

    <a class="thesis-popup btn btn-primary create-button" href="/admin/course.html"><spring:message code="messages.table.course.create" text=""/></a>

    <table id="my-table" class="table table-hover">
        <thead>
            <tr>
                <th><spring:message code="messages.table.name" text=""/></th>
                <th><spring:message code="messages.table.course.code" text=""/></th>
                <th><spring:message code="messages.table.date.update" text=""/></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="course" items="${courses}" varStatus="counter">
                <tr>
                    <td>${course.courseName}</td>
                    <td>${course.courseCode}</td>
                    <td>${course.lastModifiedDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</t:adminpage>