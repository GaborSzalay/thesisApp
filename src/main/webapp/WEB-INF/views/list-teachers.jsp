<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<t:adminpage title="Teacher List">

    <table id="my-table">
        <thead>
            <tr>
                <th><spring:message code="messages.table.email" text=""/></th>
                <th><spring:message code="messages.table.regdate" text=""/></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="teacher" items="${context.teachers}" varStatus="counter">
                <tr>
                    <td>${teacher.email}</td>
                    <td>${teacher.registrationDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</t:adminpage>