<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  bean.User: Wean
  Date: 2017/9/13
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath(); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
管理员${user.chzuname}
<a href="/admin/ChzBookchange" name="add">add</a>
<a href="/admin/ChzBook_del" name="del">del</a>
<a href="/admin/ChzBook_find" name="find">find</a>
<a href="/admin/ChzBook_chg" name="chg">chg</a><br>

<table>

    <c:forEach var="l" items="${sessionScope.books}">
        <tr>
            <td>书名</td>
            <td>${l.bookname}</td>
        </tr>
        <tr>
            <td>作者</td>
            <td>${l.chzwriter}</td>
        </tr>
    </c:forEach>

</table>

<iframe>

</iframe>
</body>
</html>
