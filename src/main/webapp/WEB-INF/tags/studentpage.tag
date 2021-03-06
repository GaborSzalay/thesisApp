<%@tag description="Student Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="title" required="true" %>
<%@attribute name="currentPage" required="true" %>
<%@attribute name="menutype" required="true" %>

<t:genericpage title="${title}">
    <jsp:attribute name="header">
        <link rel="stylesheet" href="/resources/css/jquery.dynatable.css">
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
                    <c:choose>
                        <c:when test="${menutype == 'thesis_menu'}">
                            <a class="navbar-brand" href="/student_thesis/">Thesis App</a>
                        </c:when>
                        <c:otherwise>
                            <a class="navbar-brand" href="/student/">Thesis App</a>
                        </c:otherwise>
                    </c:choose>

                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <c:choose>
                            <c:when test="${menutype == 'thesis_menu'}">
                                <li class="${currentPage == 'comments' ? 'active' : ''}"><a href="/student_thesis/comments.html"><spring:message code="messages.student.menu.thesis.comments" text=""/></a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="${currentPage == 'recommendedThesises' ? 'active' : ''}"><a href="/student/recommended_theses.html"><spring:message code="messages.student.menu.thesis.recommended" text=""/></a></li>
                                <li class="${currentPage == 'allThesises' ? 'active' : ''}"><a href="/student/all_theses.html"><spring:message code="messages.student.menu.thesis.all" text=""/></a></li>
                            </c:otherwise>
                        </c:choose>
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