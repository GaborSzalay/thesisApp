<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage title="messages.header.title.login">

    <link rel="stylesheet" href="/resources/css/login.css">

    <div class="container">
        <form name='loginForm'
              action="<c:url value='j_spring_security_check' />" method='POST' class="form-signin">

            <h2 class="form-signin-heading">
                <spring:message code="messages.login.title" text=""/>
            </h2>

            <c:if test="${context.showErrorMessage}">
                <div class="bg-danger">
                    <spring:message code="messages.login.error.invalid_user" text=""/>
                </div>
            </c:if>
            <c:if test="${context.showAccessDeniedMessage}">
                <div class="bg-danger">
                    <spring:message code="messages.login.error.access_denied" text=""/>
                </div>
            </c:if>
            <c:if test="${context.showExpiredSessionMessage}">
                <div class="bg-danger">
                    <spring:message code="messages.login.error.expired_session" text=""/>
                </div>
            </c:if>
            <c:if test="${context.showLogoutMessage}">
                <div class="bg-success">
                    <spring:message code="messages.login.logout" text=""/>
                </div>
            </c:if>
            <c:if test="${not empty context.createdEmail}">
                <div id="created-account" class="bg-success">
                    <spring:message code="messages.login.created" text="" arguments="${context.createdEmail}"/>
                </div>
            </c:if>
            <spring:message code="messages.login.email" text="" var="emailLabel"/>
            <spring:message code="messages.login.password" text="" var="passwordLabel"/>
            <label for="inputEmail" class="sr-only">${emailLabel}</label>
            <input type="email" id="inputEmail" name="email" class="form-control" placeholder="${emailLabel}" required
                   autofocus>
            <label for="inputPassword" class="sr-only">${passwordLabel}</label>
            <input type="password" id="inputPassword" name="password" class="form-control"
                   placeholder="${passwordLabel}" required>
            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me">
                    <spring:message code="messages.login.rememberme" text=""/>
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">
                <spring:message code="messages.login.signin" text=""/>
            </button>

            <jsp:include page="modules/security-check.jsp"/>
            <a href="${context.registrationLink}" class="thesis-popup">
                <spring:message code="messages.homepage.register" text=""/>
            </a>
        </form>
    </div>
</t:genericpage>