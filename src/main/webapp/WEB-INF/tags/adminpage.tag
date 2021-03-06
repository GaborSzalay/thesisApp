<%@tag description="Admin User Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="title" required="true" %>
<%@attribute name="currentPage" required="true" %>

<t:genericpage title="${title}">
    <jsp:attribute name="header">
        <link rel="stylesheet" href="/resources/css/jquery.dynatable.css">
        <link rel="stylesheet" href="/resources/css/admin.css">
    </jsp:attribute>
    <jsp:attribute name="footer">
        <script src="/resources/js/jquery.dynatable.js"></script>
        <script src="/resources/js/dynatable.basic.js"></script>
    </jsp:attribute>
    <jsp:body>

        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/admin/">Thesis App</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="${currentPage == 'admins' ? 'active' : ''}"><a href="${menu.listAdminsLink}"><spring:message code="messages.admin.homepage.list.admins" text=""/></a></li>
                        <li class="${currentPage == 'teachers' ? 'active' : ''}"><a href="${menu.listTeachersLink}"><spring:message code="messages.admin.homepage.list.teachers" text=""/></a></li>
                        <li class="${currentPage == 'students' ? 'active' : ''}"><a href="${menu.listStudentsLink}"><spring:message code="messages.admin.homepage.list.students" text=""/></a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="messages.admin.homepage.list.more" text=""/> <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="${currentPage == 'courses' ? 'active' : ''}"><a href="${menu.listCoursesLink}"><spring:message code="messages.admin.homepage.list.courses" text=""/></a></li>
                                <li class="${currentPage == 'majors' ? 'active' : ''}"><a href="${menu.listMajorsLink}"><spring:message code="messages.admin.homepage.list.majors" text=""/></a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><jsp:include page="../modules/logout-form.jsp"/></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        <div class="container list-container">
            <jsp:doBody/>
        </div>
    </jsp:body>
</t:genericpage>