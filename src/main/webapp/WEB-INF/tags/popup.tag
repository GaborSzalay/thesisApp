<%@tag description="Popup template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:doBody/>

<script type="text/javascript">
    var clickedButtons = $(".btn-default.clicked");
    clickedButtons.click();

    var addNewStudentButton = $(".add-new-student-limit");
    addNewStudentButton.click(
      function( event ) {
        event.preventDefault();
        var studentLimit = $(".studentLimitLine:last");
        var container = $(".studentLimitContainer");
        var cloneStudentLimit = studentLimit.clone();
        cloneStudentLimit.find(".add-new-student-limit").remove();
        cloneStudentLimit.prependTo(container);
      }
    );
</script>