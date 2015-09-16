<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<t:teacherpage title="messages.header.title.admin" currentPage="requests">

    <table id="my-table" class="table table-hover">
        <thead>
            <tr>
                <th><spring:message code="messages.table.name" text=""/></th>
                <th><spring:message code="messages.table.description" text=""/></th>
                <th><spring:message code="messages.table.position" text=""/></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="thesis" items="${context.thesises}" varStatus="counter">
                <c:set var="studentPosition" value="${context.studentPositions.get(thesis.thesisId)}"/>
                <tr>
                    <td>${thesis.titleEn}</td>
                    <td>${thesis.descriptionEn}</td>
                    <td>
                        ${studentPosition.maxPositions} / ${studentPosition.appointedPositions} / ${studentPosition.openPositions}
                    </td>
                    <td>
                        <a class="thesis-popup" href="/teacher/create_thesis.html?editThesis=${thesis.thesisId}"><i class="fa fa-pencil"></i></a>
                        <i class="fa fa-trash-o"></i>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</t:teacherpage>