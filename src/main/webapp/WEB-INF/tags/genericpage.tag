<!doctype html>
<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@attribute name="title" required="true" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Thesis App | ${title}</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="/resources/css/normalize.css">
        <link rel="stylesheet" href="/resources/css/main.css">
        <script src="/resources/js/vendor/modernizr-2.8.3.min.js"></script>
        <jsp:invoke fragment="header"/>
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
        <div id="body">
            <jsp:doBody/>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="resources/js/vendor/jquery-1.11.3.min.js"><\/script>')
        </script>
        <script src="/resources/js/plugins.js"></script>
        <script src="/resources/js/main.js"></script>
        <div id="pagefooter">
            <jsp:invoke fragment="footer"/>
        </div>
    </body>
</html>