<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>

<html>
<head>
    <script src="${path}/js/shopcar.js"></script>
    <style type="text/css">
        body {
            background-image: url("${path}/image/2.jpg");
            background-repeat: repeat
        }

        span {
            font-size: 30px;
            color: red;
            font-weight: bolder;
            margin-left: 200px
        }

        .f {
            width: 150px;
            height: 70px
        }

        .d {
            text-align: center;
            word-spacing: 20px;
            width: 70%
        }

        img {
            border: none
        }
    </style>
</head>
<body>
&nbsp;

<jsp:include page="head.jsp"></jsp:include>

<form action="${path }/product/SubmitChangeAction" method="post">
    <table border="1" bordercolor="blue" cellspacing="0" align="center"
           width="80%">
        <tbody id="tbody">
        <tr bgcolor="lightblue" align="center">
            <td><b>&nbsp;</b></td>
            <td><b>商品编号</b></td>
            <td><b>商品名称</b></td>
            <td><b>图片</b></td>
            <td><b>商品单价</b></td>
            <td><b>数量</b></td>
            <td><b>总价</b></td>
            <td><b>删除</b></td>
        </tr>
        <!-- private Integer id;
            private String productName;
            private Double price;
            private String picpath;
            private String discription;
         -->

        <c:forEach items="${map}" var="p">
            <tr onmouseover="over(this);" onmouseout="out(this);" align="center">
                <td><input type="checkbox" name="ids" value="${p.key.id }"/></td>
                <td>${p.key.id }</td>
                <td>${p.key. productName}</td>
                <td><img src="${path}${p.key.picpath}"/></td>
                <td>${p.key.price }</td>
                <td><input type="button" value="-" onclick="sub(this);"/><input
                        type="text" value="${p.value }" size="1" maxlength="1" name="1"/><input
                        type="button" value="+" onclick="add(this)"/>
                </td>
                <td>${p.key.price*p.value }</td>
                <td><input type="button" value="delete"
                           onclick="delRow(this);"/></td>
            </tr>
        </c:forEach>

        <tr align="center">
            <td colspan="7"><input type="button" value="选中所有行"
                                   onclick="selectAll();"/> <input type="button" value="取消选中"
                                                                   onclick="quxiao();"/> <input type="button"
                                                                                                value="删除选中的行"
                                                                                                onclick="deleteSelected();"/>
            </td>
        </tr>
        </tbody>
    </table>
    <center>
        <p>
            <input type="submit" value="提交修改"/>
        </p>
    </center>
</form>
<a href="${path }/product/Cancle">【撤销】</a>
<a href="${path }/product/CompleteSubmission">【彻底提交】</a>
<center>
    <hr/>
    <a href="">提交订单</a>
</center>
</body>
</html>