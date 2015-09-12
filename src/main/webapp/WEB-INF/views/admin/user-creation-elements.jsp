<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="form-group">
    <spring:message code="messages.table.email" text="" var="emailMessage"/>
    <label for="emailInput">${emailMessage}</label>
    <input type="text" id="emailInput" class="form-control" placeholder="${emailMessage}" name="email" value=""/>
</div>
<div class="form-group">
    <spring:message code="messages.login.password" text="" var="passwordMessage"/>
    <label for="passwordInput">${passwordMessage}</label>
    <input type="password" id="passwordInput" class="form-control" placeholder="${passwordMessage}" name="password" value=""/>
</div>