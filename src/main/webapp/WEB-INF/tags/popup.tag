<%@tag description="Popup template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:doBody/>

<script type="text/javascript">
    var clickedButtons = $(".btn-default.clicked");
    clickedButtons.click();
</script>