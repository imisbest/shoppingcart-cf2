<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<!DOCTYPE HTML>
<html>
<head>

</head>
<body>

<!-- Title -->
<img src="${path}/image/zgc_px.jpg" align="middle" class="f"/>
<span>欢迎访问我的购物网站</span>
<hr/>
<a href="${path }/user/SafeOut"><input type="button" value="安全退出"></a>
<%
    String username = (String) session.getAttribute("username");
%>

<%
    System.out.println("username" + username);
%>
<div class="c2">
    欢迎<%=username%>
</div>

<!--  Menu Bar  -->
<center>
    <div class="d">
        <a href="${path}/product/FirstPageAction"><img
                src="${path}/image/index.gif"/></a> <a
            href="${path }/UserManageView.jsp"><img
            src="${path}/image/reg.gif"/></a> <a href="${path }/ShopCarView.jsp"><img
            src="${path}/image/cart.gif"/></a> <a href=""><img
            src="${path}/image/order.gif"/></a> <a href="${path }/LoginView.jsp"><img
            src="${path}/image/exit.gif"/></a>
    </div>
</center>


</body>
</html>