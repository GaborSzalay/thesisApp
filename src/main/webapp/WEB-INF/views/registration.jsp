<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html class="no-js" lang="" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:c="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Thesis App | Registration</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <!-- Place favicon.ico in the root directory -->

    <link rel="stylesheet" href="/resources/css/normalize.css">
    <link rel="stylesheet" href="/resources/css/main.css">
    <script src="/resources/js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<body>
    <!--[if lt IE 8]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
        your browser</a> to improve your experience.</p>
    <![endif]-->

    <form action="/create_account.html" method="POST" accept-charset="UTF-8">
        Username:<br>
        <input type="text" name="username">
        <br>
        Password:<br>
        <input type="text" name="password">
        <br><br>
        <input type="radio" name="authority" value="ROLE_ADMIN" checked>ADMIN
        <input type="radio" name="authority" value="ROLE_TEACHER" checked>TEACHER
        <input type="radio" name="authority" value="ROLE_STUDENT" checked>STUDENT
        <input type="submit" value="Submit">
        <jsp:include page="modules/security-check.jsp" />
    </form>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.3.min.js"><\/script>')</script>
    <script src="/resources/js/plugins.js"></script>
    <script src="/resources/js/main.js"></script>
</body>
</html>