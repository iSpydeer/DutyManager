<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Duty Page</title>
    <meta charset="utf-8">
    <%@include file="common/header.jspf" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/create-duty.css">
</head>
<body>
<%@include file="common/navigation.jspf" %>
<div class="container d-grid justify-content-center ">
    <div class="card new-duty-card">
        <div class="card-body">
            <h4 class="card-title">Fill in Duty data</h4>
            <form:form method="post" modelAttribute="dutyCommand" class="form-group">
                <div class="row">
                    <div class="col">
                        <form:textarea cssClass="w-100 input-description" type="text" path="description"
                                       required="required"
                                       placeholder="Description" rows="3" maxLength="100"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <form:input autocomplete="off" cssClass="w-100 input-executor" type="text" path="executor"
                                    required="required"
                                    placeholder="Executor"/>
                    </div>
                </div>
                <div class="row my-3">
                    <div class="col">
                        <form:input autocomplete="off" cssClass="w-100 input-supervisor" type="text" path="supervisor"
                                    placeholder="Supervisor (optional)"/>
                    </div>
                </div>
                <div class="row mt-4">
                    <div class="col">
                        <h5>Target Date:</h5>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col">
                        <form:input autocomplete="off" cssClass="w-100 input-target-date" type="text" path="targetDate"
                                    required="required" placeholder="Select date..."/>
                    </div>
                </div>
                <div class="row mt-4">
                    <div class="col">
                        <h5>Priority:</h5>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <form:radiobutton class="btn-check btn-low" path="priority" id="low" value="LOW"
                                          required="required"/>
                        <label class="btn w-100 " for="low">Low</label>
                    </div>
                    <div class="col">
                        <form:radiobutton class="btn-check btn-medium" path="priority" id="medium" value="MEDIUM"
                                          required="required"/>
                        <label class="btn w-100 " for="medium">Medium</label>
                    </div>
                    <div class="col">
                        <form:radiobutton class="btn-check btn-high" path="priority" id="high" value="HIGH"
                                          required="required"/>
                        <label class="btn w-100 " for="high">High</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col d-flex justify-content-center mt-4">
                        <input value="Submit" type="submit" class="btn btn-primary confirm-button"
                               style="width: 200px"/>
                    </div>
                </div>
                <form:input type="hidden" path="id"/>
                <form:input type="hidden" path="assigner"/>
                <form:input type="hidden" path="isDone"/>
                <form:input type="hidden" path="startDate"/>
            </form:form>
        </div>
    </div>
</div>
<%@include file="common/footer.jspf" %>
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd',
    });
</script>
</body>
</html>