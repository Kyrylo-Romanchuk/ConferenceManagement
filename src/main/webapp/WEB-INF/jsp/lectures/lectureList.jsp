<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="dataList" scope="request" type="java.util.List<com.conferenceManagement.data.model.Lecture >"/>
<c:set var="dataTableName" value="lectures" scope="page"/>

<tag:page title="Lectures" dataTable="${dataTableName}">
    <table id="${dataTableName}" class="table table-striped">
        <thead>
        <tr>
            <th>Topic</th>
            <th>Place</th>
            <th>Speaker</th>
            <th>Date</th>
        </tr>
        </thead>

        <c:forEach var="item" items="${dataList}">
            <tr>
                <td>${item.topic}</td>
                <td>${item.place}</td>
                <td>${item.speaker.name}</td>
                <td><fmt:formatDate value="${item.date}" pattern="MM/dd/yyyy HH:mm"/></td>
            </tr>
        </c:forEach>
    </table>

    <div id="${dataTableName}-menu">
        <button class="btn navbar-light" data-toggle="dropdown" style="padding: .2rem;">
            <span class="navbar-toggler-icon"></span>
        </button>
        <tag:actionForTable name="Add" address="${base}/lectures/add"/>
    </div>
</tag:page>
