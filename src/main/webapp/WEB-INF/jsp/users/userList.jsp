<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="dataList" scope="request" type="java.util.List<com.conferenceManagement.data.model.User >"/>
<c:set var="dataTableName" value="users" scope="page"/>

<tag:page title="Users" dataTable="users">
    <table id="${dataTableName}" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
        </tr>
        </thead>

        <c:forEach var="item" items="${dataList}">
            <tr>
                <td>${item.name}</td>
                <td>${item.role}</td>
            </tr>
        </c:forEach>
    </table>

    <div id="${dataTableName}-menu">
        <button class="btn navbar-light" data-toggle="dropdown" style="padding: .2rem;">
            <span class="navbar-toggler-icon"></span>
        </button>
        <tag:actionForTable name="Add" address="${base}/users/add"/>
    </div>
</tag:page>
