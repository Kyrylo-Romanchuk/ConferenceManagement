<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="dataList" scope="request" type="java.util.List<com.conferenceManagement.data.model.Conference >"/>

<tag:page title="Conferences">
    <div class="container">
        <table id="conferences" class="table table-striped">
            <thead>
            <tr>
                <th>Topic</th>
                <th>Moderator</th>
                <th>Place</th>
                <th>Date</th>
                <th>Seats</th>
            </tr>
            </thead>

            <c:forEach var="item" items="${dataList}">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.moderator.name}</td>
                    <td>${item.place}</td>
                    <td><fmt:formatDate value="${item.date}" pattern="MM/dd/yyyy HH:mm"/></td>
                    <td>${item.seats}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</tag:page>
