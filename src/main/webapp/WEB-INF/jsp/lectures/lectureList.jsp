<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="dataList" scope="request" type="java.util.List<com.conferenceManagement.data.model.Lecture >"/>

<tag:pageModel title="Lectures">
    <div class="container">
        <table id="lectures" class="table table-striped">
            <thead>
            <tr>
                <th>Topic</th>
                <th>Speaker</th>
                <th>Place</th>
                <th>Date</th>
            </tr>
            </thead>

            <c:forEach var="item" items="${dataList}">
                <tr>
                    <td>${item.topic}</td>
                    <td>${item.speaker.name}</td>
                    <td>${item.place}</td>
                    <td><fmt:formatDate value="${item.date}" pattern="MM/dd/yyyy HH:mm"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</tag:pageModel>
