<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tag:pageModel title="Users" >
    <table id="users" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
        </tr>
        </thead>

        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.getName()}</td>
                <td>${user.getRole()}</td>
            </tr>
        </c:forEach>
    </table>
</tag:pageModel>
