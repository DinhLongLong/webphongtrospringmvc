<%-- 
    Document   : register
    Created on : Sep 5, 2023, 2:59:09 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Đăng ký tài khoản</h1>

<c:if test="${errorMessage!=null}">
    <div class="alert alert-danger">
        ${errorMessage}
    </div>
</c:if>

<c:url value="/register" var="action"/>
<form:form method="POST" action="${action}" modelAttribute="user">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <div class="form-group">
        <label for="username">Tên đăng nhập</label>
        <form:input type="text" id="username" path="username" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="password">Mật khẩu</label>
        <form:input type="password" id="password" path="password" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="confirm-password">Nhập lại mật khẩu</label>
        <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Đăng ký" class="btn btn-danger"/>
    </div>
</form:form>
