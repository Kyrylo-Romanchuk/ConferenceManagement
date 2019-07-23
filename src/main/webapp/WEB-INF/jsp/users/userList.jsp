<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="dataList" scope="request" type="java.util.List<com.conferenceManagement.data.model.User >"/>

<tag:page title="Users">
    <div class="container">
        <table id="users" class="table table-striped">
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
    </div>
</tag:page>
