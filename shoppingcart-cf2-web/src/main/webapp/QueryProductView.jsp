<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>

<html>
<head>
    <style type="text/css">
        .c1 {
            text-align: right;
            margin-right: 50px
        }

        .c2 {
            text-align: right;
            margin-right: 50px;
            color: blue;
            font-size: 150%
        }

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

        .b {
            background-color: yellow;
            background-image: url("${path}/image/button12.gif");
            width: 60px;
            height: 30px;
            border: none
        }
    </style>
</head>
<body>
&nbsp;

<jsp:include page="head.jsp"></jsp:include>

<!--  按条件搜索表单 -->


<table border="1" bordercolor="blue" cellspacing=0 align="center"
       width="70%">
    <tr align="center" bgcolor="lightblue">
        <td><b>Id</b></td>
        <td><b>Name</b></td>
        <td><b>图片</b></td>
        <td><b>Price</b></td>
        <td><b><img src="${path}/image/car_new.gif"/></b></td>
    </tr>
    <!-- private Integer id;
private String productName;
private Double price;
private String picpath;
private String discription;
     -->

    <c:forEach items="${list}" var="p">

        <tr align="center">
            <td>${p.id }</td>
            <td>${p.productName }</td>
            <td><img src="${path }${p.picpath}"/></td>
            <td>${p.price }</td>
            <td align="center"><a
                    href="${path }/product/MapSelectAction?nameid=${p.id }"><img
                    src="${path}/image/car_new.gif"/></a></td>
        </tr>

    </c:forEach>

</table>
<p>&nbsp;</p>
<%
    Integer currPage = (Integer) request.getAttribute("currPage");
    Integer countPage = (Integer) session.getAttribute("countPage");
    System.out.print("{main countPage}" + countPage);
    System.out.print("{main currPage}" + currPage);
%>
<!-- 分页 -->
<c:if test="${judge!=null }">
<c:if test="${countPage==1 }">
<center>
    <c:forEach begin="1" end="${countPage}" var="i">
    <a href="${path }/product/CurrentPageAction?currPage=${i }">${i }</a> &nbsp;&nbsp;
    </c:forEach>
    </c:if>
    <c:if test="${countPage>1 }">
    <center>
        <c:if test="${currPage>1&&currPage<countPage}">
            <a href="${path }/product/FirstPageAction">首页</a>&nbsp;&nbsp;
            <a
                    href="${path }/product/PreviousPageAction?currPage=${ currPage - 1}">上一页</a>&nbsp;&nbsp;
            <c:forEach begin="1" end="${countPage}" var="i">
                <a href="${path }/product/CurrentPageAction?currPage=${i }">${i }</a> &nbsp;&nbsp;
            </c:forEach>
            <a href="${path }/product/NextPageAction?currPage=${ currPage + 1}">下一页</a>&nbsp;&nbsp;
            <a href="${path }/product/LastPageAction">尾页</a>&nbsp;&nbsp;
        </c:if>

        <c:if test="${currPage==1 }">

            <c:forEach begin="1" end="${countPage}" var="i">
                <a href="${path }/product/CurrentPageAction?currPage=${i }">${i }</a> &nbsp;&nbsp;
            </c:forEach>
            <a href="${path }/product/NextPageAction?currPage=${currPage + 1}">下一页</a>&nbsp;&nbsp;
            <a href="${path }/product/LastPageAction?currPage=${countPage}">尾页</a>&nbsp;&nbsp;
        </c:if>


        <c:if test="${currPage==countPage }">
            <a href="${path }/product/FirstPageAction">首页</a>&nbsp;&nbsp;
            <a
                    href="${path }/product/PreviousPageAction?currPage=${currPage - 1}">上一页</a>&nbsp;&nbsp;
            <c:forEach begin="1" end="${countPage}" var="i">
                <a href="${path }/product/CurrentPageAction?currPage=${i }">${i }</a> &nbsp;&nbsp;
            </c:forEach>

        </c:if>

    </center>
    </c:if>
    </c:if>


</body>
</html>