<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<table class="thesis-popup-page table table-hover">
    <thead>
        <tr>
            <th><spring:message code="messages.table.list.thesis" text="" arguments="${teacher.thesisUser.name}"/></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="thesis" items="${teacher.thesises}" varStatus="counter">
            <tr>
                <td>
                    <c:choose>
                        <c:when test="${pageContext.response.locale == 'en'}">
                            ${thesis.titleEn}
                        </c:when>
                        <c:otherwise>
                            ${thesis.titleHu}
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>