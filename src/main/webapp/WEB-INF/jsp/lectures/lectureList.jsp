<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="lectureList" scope="request" type="java.util.List<com.conferenceManagement.data.model.User >"/>

<tag:pageModel title="Lectures" >
    <table id="lectures" class="table table-striped">
        <thead>
        <tr>
            <th>Topic</th>
            <th>Speaker</th>
            <th>Place</th>
            <th>Date</th>
            <th>Time</th>
        </tr>
        </thead>

        <c:forEach var="lecture" items="${lectureList}">
            <tr>
                <td>${lecture.getTopic()}</td>
                <td>${lecture.getSpeaker().getName()}</td>
                <td>${lecture.getPlace()}</td>
                <td><fmt:formatDate value="${lecture.getDate()}" pattern="MM/dd/yyyy"/></td>
                <td>${lecture.getTime()}</td>
            </tr>
        </c:forEach>
    </table>
</tag:pageModel>
