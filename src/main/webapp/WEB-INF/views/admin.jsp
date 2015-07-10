<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html xmlns:c="http://www.w3.org/1999/XSL/Transform" xmlns:jsp="http://java.sun.com/JSP/Page">
<body>
<h1>Title : ${title}</h1>
<h1>Message : ${message}</h1>
<br>
<c:if test="${sharedPageEnabled}">
    <h1><a href="/${user}/shared.html">Shared page</a></h1>
</c:if>
<c:url value="/j_spring_security_logout" var="logoutUrl" />

<!-- csrt for log out-->
<form action="${logoutUrl}" method="post" id="logoutForm">
    <jsp:include page="modules/security-check.jsp" />
</form>

<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>
        Welcome : ${pageContext.request.userPrincipal.name} | <a
            href="javascript:formSubmit()"> Logout</a>
    </h2>
</c:if>

</body>
</html>