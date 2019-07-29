<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--<jsp:useBean id="conference" scope="request" class="com.conferenceManagement.data.model.Conference"/>--%>
<jsp:useBean id="moderators" scope="request" type="java.util.List<com.conferenceManagement.data.model.User>"/>
<jsp:useBean id="lectures" scope="request" type="java.util.List<com.conferenceManagement.data.model.Lecture>"/>

<tag:page title="New conference" datePicker="true">
    <div class="text-center">
        <form class="justify-content-center" method="post" action="${base}/conferences/add">
            <div class="container col-md-6">
                <div class="form-group text-center">

                    <ul class="nav nav-tabs">
                        <li class="nav-item">
                            <a class="nav-link active" data-toggle="tab" href="#mainInfoTab">Main</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#lecturesTab">Lectures</a>
                        </li>
                    </ul>

                    <div class="tab-content">
                        <div class="tab-pane fade in active show" id="mainInfoTab">
                            <label for="name">Name</label>
                            <input type="text" id="name" name="name" class="form-control"
                                   placeholder="Enter topic"
                                   value="${conference.getName()}">

                            <label for="moderator">Moderator</label>
                            <select class="form-select-but;ton form-control" id="moderator" name="moderator">
                                <c:forEach var="moderator" items="${moderators}">
                                    <c:if test="${moderator.id.equals(conference.getModerator().getId())}">
                                        <option selected value=${moderator.name}>${moderator.name}</option>
                                    </c:if>
                                    <c:if test="${!moderator.id.equals(conference.getModerator().getId())}">
                                        <option value=${moderator.id}>${moderator.name}</option>
                                    </c:if>
                                </c:forEach>
                            </select>

                            <label for="seats">Seats</label>
                            <input type="text" id="seats" name="seats" class="form-control"
                                   placeholder="Enter number of seats"
                                   value="${conference.getSeats()}">

                            <label for="date">Date</label>
                            <input id="date" name="date" class="form-control date-picker" placeholder="dd/MM/yyyy HH:mm"
                                   value="<fmt:formatDate value="${conference.gatDate()}" pattern="MM/dd/yyyy HH:mm"/>">
                        </div>

                        <div class="tab-pane" id="lecturesTab">
                            <label for="lectures">Lectures</label>
                            <div class="form-check text-left">
                                <c:forEach var="lecture" items="${lectures}">
                                    <div class="form-check">
                                        <label class="form-check-label">
                                                <%--                                            <c:if test="${lecture.id.equals(conference.getLectureById(lecture.id))}">--%>
                                            <c:if test="${conference.getLectureById(lecture.id) == lecture.id}">
                                                <input id="lectures" name="lectures"
                                                       type="checkbox" class="form-check-input"
                                                       value="${lecture.id}" checked>${lecture.topic}
                                            </c:if>

                                            <c:if test="${conference.getLectureById(lecture.id) != lecture.id}">
                                                <input id="lectures" name="lectures"
                                                       type="checkbox" class="form-check-input"
                                                       value="${lecture.id}">${lecture.topic}
                                            </c:if>
                                        </label>
                                    </div>
                                </c:forEach>
                            </div>

                        </div>

                    </div>
                </div>

                    <tag:action name="Save"/>
        </form>
    </div>
</tag:page>