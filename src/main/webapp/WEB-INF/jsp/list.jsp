<%--
  Created by IntelliJ IDEA.
  User: kazuha
  Date: 2023/2/24
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Home page</title>
    <style>
        table, th, td {
            border: 1px black solid;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
    <p>图书列表</p>
    <table>
        <tr>
            <th>编号</th>
            <th>书名</th>
            <th>作者</th>
            <th>价格</th>
            <th>出版社</th>
            <th>操作</th>
        </tr>
        <c:forEach var="book" items="${books}" varStatus="idx">
            <tr>
                <td>${book.b_id}</td>
                <td>${book.b_name}</td>
                <td>${book.b_author}</td>
                <td>${book.b_price}</td>
                <td>${book.b_press}</td>
                <td>
                    <a href="#">删除</a>|
                    <a href="#">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <span>
        <c:if test="${bookPage.getPageNum() != 1}">上一页</c:if>&nbsp;
        <p>共${bookPage.getPages()}页，当前第${bookPage.getPageNum()}页</p>&nbsp;
        <c:if test="${bookPage.getPageNum() != bookPage.getPages()}">下一页</c:if>&nbsp;
    </span>
</body>
</html>
