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
    <body>
        <!--[if lt IE 8]>
        <p class="browserupgrade">You are using an
            <strong>outdated</strong>
            browser. Please
            <a href="http://browsehappy.com/">upgrade your browser</a>
            to improve your experience.
        </p>
        <![endif]-->

        <p>Hello admin! Do what you have to do.</p>

        <div>
            <a href="${context.listAdminsLink.url}">
                <spring:message code="${context.listAdminsLink.message.key}" text=""/>
            </a>
        </div>
        <div>
            <a href="${context.listTeachersLink.url}">
                <spring:message code="${context.listTeachersLink.message.key}" text=""/>
            </a>
        </div>
        <div>
            <a href="${context.listThesisTypesLink.url}">
                <spring:message code="${context.listThesisTypesLink.message.key}" text=""/>
            </a>
        </div>
        <div>
            <a href="${context.listCoursesLink.url}">
                <spring:message code="${context.listCoursesLink.message.key}" text=""/>
            </a>
        </div>
        <div>
            <a href="${context.listMajorsLink.url}">
                <spring:message code="${context.listMajorsLink.message.key}" text=""/>
            </a>
        </div>


        <jsp:include page="modules/logout-form.jsp"/>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.3.min.js"><\/script>')</script>
        <script src="/resources/js/plugins.js"></script>
        <script src="/resources/js/main.js"></script>
    </body>
</html>
