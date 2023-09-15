<%-- 
    Document   : post
    Created on : Sep 7, 2023, 12:07:13 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<sec:authorize access="hasRole('ROLE_HOST')">
    <h1>Đăng bài cho thuê</h1>
    <c:url value="/user/post" var="action"/>
    <form:form method="POST" action="${action}" modelAttribute="user">        
        <div class="form-group">
            <label for="name">Tiêu đề</label>
            <form:input type="text" id="name" path="" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="price">Giá cho thuê</label>
            <form:input type="text" id="price" path="" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="acreage">Diện tích</label>
            <form:input type="text" id="acreage" path="" class="form-control"/>
        </div>
        <div class="form-group">
            <input type="submit" value="Đăng bài" class="btn btn-danger"/>
        </div>
    </form:form>
</sec:authorize>--%>
<h1>Ðang bài</h1>
