<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="user" scope="request" type="com.conferenceManagement.data.model.User"/>
<jsp:useBean id="roles" scope="request" type="java.util.List<com.conferenceManagement.data.Role>"/>

<tag:page title="New user">
    <div class="text-center">
        <form class="justify-content-center" method="post" action="${base}/users/add">
            <div class="container col-md-6">
                <div class="form-group text-center">
                    <label for="name">Name</label>
                    <input type="text" id="name" name="name" class="form-control"
                           placeholder="Enter name"
                           value="${user.name}">
                    <label for="role">Role</label>
                    <select class="form-select-button form-control" id="role" name="role">
                        <c:forEach var="role" items="${roles}">
                            <c:if test="${role.equals(user.role)}">
                                <option selected value=${role.name()}>${role.name()}</option>
                            </c:if>
                            <c:if test="${!role.equals(user.role)}">
                                <option value=${role.name()}>${role.name()}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <tag:action name="Save"/>
        </form>
    </div>
</tag:page>