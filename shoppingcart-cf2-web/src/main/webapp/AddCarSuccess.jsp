<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<%
    request.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <style type="text/css">
        body {
            background-image: url("${path}/image/2.jpg");
            background-repeat: repeat
        }
    </style>
</head>
<body>
&nbsp;
<center>
    <img src="${path }/image/success.gif"/>
    <h1>已成功将XXX商品添加至购物车</h1>
    <h1>
        <a href="${path }/product/FirstPageAction">继续购物</a>&nbsp;&nbsp; <a
            href="${path }/ShopCarView.jsp">去购物车结算</a>
    </h1>
</center>
</body>
</html>