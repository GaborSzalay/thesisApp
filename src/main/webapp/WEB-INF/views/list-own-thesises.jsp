<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<t:teacherpage title="messages.header.title.admin" currentPage="admins">

    <table id="my-table">
        <thead>
            <tr>
                <th><spring:message code="messages.table.email" text=""/></th>
                <th><spring:message code="messages.table.regdate" text=""/></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="thesis" items="${context.thesises}" varStatus="counter">
                <tr>
                    <td>${thesis.titleEn}</td>
                    <td>${thesis.descriptionEn}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</t:teacherpage>