<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<t:adminpage title="Student List">

    <table id="my-table">
        <thead>
            <tr>
                <th><spring:message code="messages.table.username" text=""/></th>
                <th><spring:message code="messages.table.major" text=""/></th>
                <th><spring:message code="messages.table.thesis_type" text=""/></th>
                <th><spring:message code="messages.table.course" text=""/></th>
                <th><spring:message code="messages.table.regdate" text=""/></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${context.students}" varStatus="counter">
                <tr>
                    <td>${student.thesisUser.userName}</td>
                    <td>${student.major.majorName}</td>
                    <td>${student.thesisType.typeName}</td>
                    <td>${student.course.courseName}</td>
                    <td>${student.thesisUser.registrationDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</t:adminpage>