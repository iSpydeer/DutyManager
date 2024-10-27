<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="pl">
<head>
    <title>Manage Your Duties</title>
    <meta charset="utf-8">
    <%@include file="common/header.jspf" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manage-duties.css">
</head>
<body>
<%@include file="common/navigation.jspf" %>
<div class="container">
    <div class="card duty-main-card">
        <div class="card-body">
            <div class="d-flex overflow-auto" style="white-space: nowrap;">
                <c:forEach items="${duties}" var="duty">
                    <div class="align-content-center align-items-center mx-2">
                        <div class="card duty-card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col d-flex justify-content-center">
                                        <textarea rows="3" disabled>${duty.description}</textarea>
                                    </div>
                                </div>
                                <div class="row label">
                                    <div class="col">
                                        Start date:
                                    </div>
                                    <div class="col">
                                        Target date:
                                    </div>
                                </div>
                                <div class="row info-row">
                                    <div class="col">
                                            ${duty.startDate}
                                    </div>
                                    <div class="col">
                                            ${duty.targetDate}
                                    </div>
                                </div>
                                <div class="row label">
                                    <div class="col">
                                        Assigner:
                                    </div>
                                    <div class="col">
                                        Supervisor:
                                    </div>
                                </div>
                                <div class="row info-row">
                                    <div class="col">
                                            ${duty.assigner}
                                    </div>
                                    <div class="col">
                                            ${duty.supervisor}
                                    </div>
                                </div>
                                <div class="row label">
                                    <div class="col">
                                        Executor:
                                    </div>
                                    <div class="col">
                                        Priority:
                                    </div>
                                </div>
                                <div class="row info-row">
                                    <div class="col">
                                            ${duty.executor}
                                    </div>
                                    <c:choose>
                                        <c:when test="${duty.priority eq 'LOW'}">
                                            <div class="col priority-low-sign">
                                                !
                                            </div>
                                        </c:when>

                                        <c:when test="${duty.priority eq 'MEDIUM'}">
                                            <div class="col priority-medium-sign">
                                                !!
                                            </div>
                                        </c:when>
                                        <c:when test="${duty.priority eq 'HIGH'}">
                                            <div class="col priority-high-sign">
                                                !!!
                                            </div>
                                        </c:when>
                                    </c:choose>
                                </div>
                                <div class="row mt-2">
                                    <div class="col d-flex justify-content-center">
                                        <a class="btn btn-modify w-100" href="update-duty?id=${duty.id}">Modify</a>
                                    </div>
                                    <div class="col d-flex justify-content-center">
                                        <a class="btn btn-delete w-100" href="delete-duty?id=${duty.id}">Delete</a>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-12 d-flex justify-content-center ">
                                        <c:choose>
                                            <c:when test="${duty.isDone eq true}">
                                                <div class="text-body my-2 text-done w-100">
                                                    Done
                                                </div>
                                            </c:when>

                                            <c:otherwise>
                                                <div class="w-100">
                                                    <form method="post" action="finish-duty?id=${duty.id}">
                                                        <input type="hidden" name="${_csrf.parameterName}"
                                                               value="${_csrf.token}"/>
                                                        <button class="btn my-2 btn-done w-100" formmethod="post">
                                                            <img src="../../../done-icon.png" width="15"/>
                                                        </button>
                                                    </form>
                                                </div>
                                            </c:otherwise>
                                        </c:choose>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <%@include file="common/footer.jspf" %>
</div>
</body>
</html>