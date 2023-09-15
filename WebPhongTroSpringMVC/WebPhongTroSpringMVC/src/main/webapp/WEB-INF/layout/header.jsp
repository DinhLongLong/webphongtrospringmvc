<%-- 
    Document   : header
    Created on : Sep 2, 2023, 8:37:47 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="<c:url value="/"/>">WEB ICON</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="<c:url value="/"/>">Trang chủ</a>
        </li>
        <c:forEach var="cat" items="${categories}">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="<c:url value="/"/>">${cat.name}</a>
            </li>
        </c:forEach>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <li class="nav-item">
                <a class="active btn btn-primary" aria-current="page" href="<c:url value="/user/post"/>">Đăng bài</a>
            </li>
        </c:if>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li class="nav-item">
            <a class="nav-link active" href="<c:url value="/admin/products"/>">Quản lý sản phẩm</a>
        </li>
        </sec:authorize>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <li class="nav-item">
                <a class="nav-link active text-danger" aria-current="page" href="<c:url value="/login"/>">Đăng nhập</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active text-danger" aria-current="page" href="<c:url value="/register"/>">Đăng ký</a>
            </li>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <li class="nav-item">
                <a class="nav-link active text-danger" aria-current="page" href="<c:url value="/"/>">${pageContext.request.userPrincipal.name}</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active text-danger" aria-current="page" href="<c:url value="/logout"/>">Đăng xuất</a>
            </li>
        </c:if>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Nhập để tìm kiếm" aria-label="Nhập để tìm kiếm">
        <button class="btn btn-outline-success" type="submit">Tìm</button>
      </form>
    </div>
  </div>
</nav>
