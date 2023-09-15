<%-- 
    Document   : product
    Created on : Sep 2, 2023, 12:43:42 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Quản lý sản phẩm</h1>

<c:url value="/admin/products" var="action"/>
<form:form method="POST" action="${action}" modelAttribute="product" enctype="multipart/form-data">
    <div class="form-group">
        <label for="name">Tiêu đề</label>
        <form:input type="text" id="name" path="name" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="price">Giá cho thuê</label>
        <form:input type="text" id="price" path="price" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="acreage">Diện tích</label>
        <form:input type="text" id="acreage" path="acreage" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="img">Link hình</label>
        <form:input type="text" id="img" path="img" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="category">Chọn danh mục</label>
        <select class="form-select" id="category">
            <c:forEach var="cat" items="${categories}">
                <option value="${cat.id}">${cat.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="location">Chọn khu vực  trọ</label>
        <select class="form-select" id="location">
            <c:forEach var="loc" items="${locations}">
                <option value="${loc.id}">${loc.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="file">Thêm ảnh</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Thêm sản phẩm" class="btn btn-danger"/>
    </div>
</form:form>
<%--<c:if test="${errorMessage!=null}">
    <div class="alert alert-danger">
        ${errorMessage}
    </div>
</c:if>

<c:url value="/admin/products" var="action"/>
<form:form method="POST" action="${action}" modelAttribute="product" enctype="multipart/form-data">
    <div class="form-group">
        <label for="name">Tiêu đề</label>
        <form:input type="text" id="name" path="name" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="price">Giá cho thuê</label>
        <form:input type="text" id="price" path="price" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="acreage">Diện tích</label>
        <form:input type="text" id="acreage" path="acreage" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="img">Link hình</label>
        <form:input type="text" id="img" path="img" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="location_id">location_id</label>
        <form:input type="text" id="location_id" path="locationId" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="category_id">category_id</label>
        <form:input type="text" id="category_id" path="categoryId" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="file">Thêm ảnh</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Thêm sản phẩm" class="btn btn-danger"/>
    </div>
</form:form>--%>
