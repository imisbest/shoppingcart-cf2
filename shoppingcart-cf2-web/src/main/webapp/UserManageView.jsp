<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>

<html>
<head>
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

        .tableBorder1 {
            width: 97%;
            border: 1px;
            background-color: #AFB2C4;
        }

        td.TableBody2 {
            background-color: #E4F3FF;
            line-height: normal;
        }
    </style>
</head>
<body>
&nbsp;

<jsp:include page="head.jsp"></jsp:include>
<!-- 正文 -->
<table width="100%" height="300" align="center" cellpadding="3"
       cellspacing="1" class="tableborder1">
    <tr>
        <td width="100%" height="25" align="center" valign="middle"
            bgcolor="lightblue"><font color="#ffffff"><b>用户管理</b></font></td>
    </tr>
    <tr>

        <td class="tablebody2" valign="middle" align="center">
            <table width="163" border="0" align="center">
                <tr>
                    <td height="30" align="center"><a href="${path }/CreateUserView.jsp">用户注册</a></td>
                </tr>
                <tr>
                    <td height="30" align="center"><a href="${path }/LoginView.jsp">用户登录</a></td>
                </tr>

            </table>

        </td>
    </tr>
</table>
</body>
</html>