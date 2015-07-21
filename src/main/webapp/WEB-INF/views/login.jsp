<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false" %>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Thesis App | HomePage</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="/resources/css/normalize.css">
        <link rel="stylesheet" href="/resources/css/main.css">
        <script src="/resources/js/vendor/modernizr-2.8.3.min.js"></script>
    </head>
    <body onload='document.loginForm.username.focus();'>

        <!--[if lt IE 8]>
        <p class="browserupgrade">You are using an
            <strong>outdated</strong>
            browser. Please
            <a href="http://browsehappy.com/">upgrade your browser</a>
            to improve your experience.
        </p>
        <![endif]-->

        <div id="login-box">

            <h2>Login with Username and Password</h2>

            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <form name='loginForm'
                  action="<c:url value='j_spring_security_check' />" method='POST'>

                <table>
                    <tr>
                        <td>User:</td>
                        <td>
                            <input type='text' name='username' value=''>
                        </td>
                    </tr>
                    <tr>
                        <td>Password:</td>
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

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.3.min.js"><\/script>')</script>
        <script src="/resources/js/plugins.js"></script>
        <script src="/resources/js/main.js"></script>
    </body>
</html>