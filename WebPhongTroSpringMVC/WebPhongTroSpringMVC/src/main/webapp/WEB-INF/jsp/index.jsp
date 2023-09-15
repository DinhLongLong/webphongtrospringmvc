<%-- 
    Document   : index
    Created on : Aug 25, 2023, 9:19:43 AM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>web thuê phòng trọ</h1>
<ul>
    <c:forEach var="pro" items="${products}">
        <li>${pro.name}</li>
    </c:forEach>
</ul>
