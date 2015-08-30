<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<t:adminpage title="messages.header.title.admin" currentPage="admins">

    <a class="thesis-popup btn btn-primary create-button" href="/admin/create_admin.html"><spring:message code="messages.admin.menu.create_admin" text=""/></a>

    <table id="my-table" class="table table-hover">
        <thead>
            <tr>
                <th><spring:message code="messages.table.email" text=""/></th>
                <th><spring:message code="messages.table.regdate" text=""/></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="admin" items="${context.admins}" varStatus="counter">
                <tr>
                    <td>${admin.email}</td>
                    <td>${admin.registrationDate}</td>
                    <td>
                        <a href="/admin/delete_admin.html?admin=${admin.thesisUserId}"><i class="fa fa-trash-o"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</t:adminpage>