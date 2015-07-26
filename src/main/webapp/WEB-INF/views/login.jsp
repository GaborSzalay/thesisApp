<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage title="messages.header.title.login">
    <div id="login-box">

        <h2><spring:message code="messages.login.title" text=""/></h2>

        <c:if test="${context.showErrorMessage}">
            <div class="error"><spring:message code="messages.login.error" text=""/></div>
        </c:if>
        <c:if test="${context.showLogoutMessage}">
            <div class="msg"><spring:message code="messages.login.logout" text=""/></div>
        </c:if>

        <form name='loginForm'
              action="<c:url value='j_spring_security_check' />" method='POST'>

            <table>
                <tr>
                    <td><spring:message code="messages.login.user" text=""/></td>
                    <td>
                        <input type='text' name='username' value=''>
                    </td>
                </tr>
                <tr>
                    <td><spring:message code="messages.login.password" text=""/></td>
                    <td>
                        <input type='password' name='password'/>
                    </td>
                </tr>
                <tr>
                    <td colspan='2'>
                        <input name="submit" type="submit"
                               value="submit"/>
                    </td>
                </tr>
            </table>

            <jsp:include page="modules/security-check.jsp"/>

        </form>
    </div>
    <a href="${context.registrationLink.url}">
        <spring:message code="${context.registrationLink.message.key}" text=""/>
    </a>
</t:genericpage>