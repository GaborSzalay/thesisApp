<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<t:adminpage title="messages.header.title.admin" currentPage="students">

    <table id="my-table" class="table table-hover">
        <thead>
            <tr>
                <th><spring:message code="messages.table.email" text=""/></th>
                <th><spring:message code="messages.table.major" text=""/></th>
                <th><spring:message code="messages.table.course" text=""/></th>
                <th><spring:message code="messages.table.regdate" text=""/></th>
                <th><spring:message code="messages.table.thesis" text=""/></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${context.students}" varStatus="counter">
                <tr>
                    <td>${student.thesisUser.email}</td>
                    <td>${student.major.majorName}</td>
                    <td>${student.course.courseName}</td>
                    <td>${student.thesisUser.registrationDate}</td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty student.thesis and not empty student.thesis.thesisId}">
                                    <a class="thesis-popup" href="/admin/show_thesis.html?thesis=${student.thesis.thesisId}"><i class="fa fa-book enabled"></i></a>
                            </c:when>
                            <c:otherwise>
                                <i class="fa fa-book disabled"></i>
                            </c:otherwise>
                        </c:choose>

                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</t:adminpage>