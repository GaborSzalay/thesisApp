<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<t:adminpage title="messages.header.title.admin" currentPage="teachers">

    <table id="my-table" class="table table-hover">
        <thead>
            <tr>
                <th><spring:message code="messages.table.email" text=""/></th>
                <th><spring:message code="messages.table.regdate" text=""/></th>
                <th><spring:message code="messages.table.Thesis" text=""/></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="teacher" items="${context.teachers}" varStatus="counter">
                <tr>
                    <td>${teacher.thesisUser.email}</td>
                    <td>${teacher.thesisUser.registrationDate}</td>
                    <td>
                        <a class="thesis-popup" href="/admin/list_thesises?teacher=${teacher.thesisTeacherId}"><i class="fa fa-list-ul"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</t:adminpage>