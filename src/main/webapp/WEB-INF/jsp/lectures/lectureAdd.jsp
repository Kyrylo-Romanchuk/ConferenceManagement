<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="lecture" scope="request" type="com.conferenceManagement.data.model.Lecture"/>
<jsp:useBean id="speakers" scope="request" type="java.util.List<com.conferenceManagement.data.model.User>"/>
<jsp:useBean id="places" scope="request" type="java.util.List<com.conferenceManagement.data.Place>"/>

<tag:page title="New lecture" datePicker="true">
    <div class="text-center">
        <form class="justify-content-center" method="post" action="${base}/lectures/add">
            <div class="container col-md-6">
                <div class="form-group text-center">
                    <label for="topic">Topic</label>
                    <input type="text" id="topic" name="topic" class="form-control"
                           placeholder="Enter topic"
                           value="${lecture.topic}">

                    <label for="speaker">Speaker</label>
                    <select class="form-select-but;ton form-control" id="speaker" name="speaker">
                        <c:forEach var="speaker" items="${speakers}">
                            <c:if test="${speaker.id.equals(lecture.speaker.id)}">
                                <option selected value=${speaker.name}>${speaker.name}</option>
                            </c:if>
                            <c:if test="${!speaker.id.equals(lecture.speaker.id)}">
                                <option value=${speaker.id}>${speaker.name}</option>
                            </c:if>
                        </c:forEach>
                    </select>

                    <label for="place">Place</label>
                    <select class="form-select-button form-control" id="place" name="place">
                        <c:forEach var="place" items="${places}">
                            <c:if test="${place.equals(lecture.topic)}">
                                <option selected value=${place.name()}>${place.name()}</option>
                            </c:if>
                            <c:if test="${!place.equals(lecture.topic)}">
                                <option value=${place.name()}>${place.name()}</option>
                            </c:if>
                        </c:forEach>
                    </select>

                    <label for="dateLecture">Date</label>
                    <input id="dateLecture" name="date" class="form-control date-picker" placeholder="dd/MM/yyyy HH:mm"
                           value="<fmt:formatDate value="${lecture.date}" pattern="MM/dd/yyyy HH:mm"/>">
                </div>
            </div>

            <tag:action name="Save"/>
        </form>
    </div>
</tag:page>