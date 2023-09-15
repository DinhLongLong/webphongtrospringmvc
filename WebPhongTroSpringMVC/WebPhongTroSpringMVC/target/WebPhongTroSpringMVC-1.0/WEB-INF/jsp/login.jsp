<%-- 
    Document   : login
    Created on : Aug 29, 2023, 8:58:32 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">Trang đăng nhập</h1>
<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Lỗi đăng nhập!
    </div>
</c:if>
<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        Bạn không có quyên truy cập!
    </div>
</c:if>
<c:url value="/login" var="action"/>
<form method="POST" action="${action}">
    <div class="form-group">
        <label for="username">Tên đăng nhập</label>
        <input type="text" id="username" name="username" class="form-control">
        <label for="password">Mật khẩu</label>
        <input type="password" id="password" name="password" class="form-control">
    </div>
    <div class="form-group">
        <input type="submit" value="Đăng nhập" class="btn btn-danger"/>
    </div>
</form>
