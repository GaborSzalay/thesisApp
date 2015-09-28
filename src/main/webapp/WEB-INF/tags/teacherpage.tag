<%@tag description="Signed-in User Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="title" required="true" %>
<%@attribute name="currentPage" required="true" %>

<t:genericpage title="${title}">
    <jsp:attribute name="header">
        <link rel="stylesheet" href="/resources/css/jquery.dynatable.css">
        <link rel="stylesheet" href="/resources/css/teacher.css">
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
                    <a class="navbar-brand" href="/teacher/">Thesis App</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="messages.teacher.menu.own_thesises" text=""/> <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="${currentPage == 'newOwnThesises' ? 'active' : ''}"><a href="${menu.listOwnThesisesLink}"><spring:message code="messages.teacher.menu.thesis.new" text=""/></a></li>
                                <li class="${currentPage == 'inProgressThesises' ? 'active' : ''}"><a href="/teacher/list_in_progress_own_thesises.html"><spring:message code="messages.teacher.menu.thesis.in_progress" text=""/></a></li>
                                <li class="${currentPage == 'closedThesises' ? 'active' : ''}"><a href="/teacher/list_closed_own_thesises.html"><spring:message code="messages.teacher.menu.thesis.closed" text=""/></a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="messages.teacher.menu.requests" text=""/> <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="${currentPage == 'requests' ? 'active' : ''}"><a href="/teacher/requests.html"><spring:message code="messages.teacher.menu.requests.new" text=""/></a></li>
                                <li class="${currentPage == 'declined-requests' ? 'active' : ''}"><a href="/teacher/declined_requests.html"><spring:message code="messages.teacher.menu.requests.declined" text=""/></a></li>
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