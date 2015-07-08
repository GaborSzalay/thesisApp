<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>