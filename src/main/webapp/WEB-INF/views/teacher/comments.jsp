<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:teacherpage title="messages.header.title.teacher" currentPage="home">
    <jsp:include page="../shared/comments_form.jsp"/>
</t:teacherpage>