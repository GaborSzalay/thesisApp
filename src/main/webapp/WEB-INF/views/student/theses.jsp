<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:studentpage title="messages.header.title.student" currentPage="${currentPage}">

    <table id="my-table" class="table table-hover">
        <thead>
            <tr>
                <th><spring:message code="messages.table.name" text=""/></th>
                <th><spring:message code="messages.table.description" text=""/></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="thesis" items="${theses}" varStatus="counter">
                <tr>
                    <td>${thesis.titleEn}</td>
                    <td>${thesis.descriptionEn}</td>
                    <td><a class="thesis-popup" href="/student/show_thesis.html?thesis=${thesis.thesisId}"><i class="fa fa-book enabled"></i></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</t:studentpage>