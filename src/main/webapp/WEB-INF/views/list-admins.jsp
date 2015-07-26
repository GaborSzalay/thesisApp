<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<t:adminpage title="Admin List">

    <table id="my-table">
        <thead>
            <tr>
                <th>User name</th>
                <th>Password</th>
                <th>Authority</th>
                <th>Reg date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="admin" items="${context.admins}" varStatus="counter">
                <tr>
                    <td>${admin.userName}</td>
                    <td>${admin.password}</td>
                    <td>${admin.authority}</td>
                    <td>${admin.registrationDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</t:adminpage>