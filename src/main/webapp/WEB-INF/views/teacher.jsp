<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page session="true"%>
<html xmlns:c="http://www.w3.org/1999/XSL/Transform" xmlns:jsp="http://java.sun.com/JSP/Page">
    <body>
        <h1><spring:message code="${context.welcomeMessage.key}" arguments="${context.welcomeMessage.args.get(0)}" text="" /></h1>
        <br>

        <c:url value="/j_spring_security_logout" var="logoutUrl" />

        <!-- csrt for log out-->
        <form action="${logoutUrl}" method="post" id="logoutForm">
            <jsp:include page="modules/security-check.jsp" />
        </form>
        <a href="javascript:formSubmit()"> Logout</a>
        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
        </script>

    </body>
</html>