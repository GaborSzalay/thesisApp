<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<table class="thesis-popup-page table table-hover">
    <thead>
        <tr>
            <th><spring:message code="messages.table.list.thesis" text="" arguments="${teacher.thesisUser.email}"/></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="thesis" items="${teacher.thesises}" varStatus="counter">
            <tr>
                <td>${thesis.titleEn}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>