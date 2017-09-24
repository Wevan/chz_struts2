<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.opensymphony.xwork2.util.ValueStack" %>
<%@ page import="bean.Book" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="service.ChzBookService" %>
<%@ page import="java.util.Arrays" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  bean.User: Wean
  Date: 2017/9/11
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${user.chzuname}

<%--<table>--%>

    <%--<c:forEach var="l" items="${sessionScope.books}">--%>
        <%--<tr>--%>
            <%--<td>书名</td>--%>
            <%--<td>${l.bookname}</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>作者</td>--%>
            <%--<td>${l.chzwriter}</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>

<%--</table>--%>
<%
    //获取封装输出信息的ValueStack对象
    ValueStack vs=(ValueStack)request.getAttribute("struts.valueStack");
    ChzBookService bs=(ChzBookService)vs.findValue("bookService");
    List<Book> books=bs.getBookList();
    System.out.println(Arrays.toString(books.toArray()));
    Iterator<Book> iter=books.iterator();
%>
<table border="1">
    <caption>全部书籍列表</caption>
    <tr>
        <td>书名</td>
        <td>作者</td>
        <td>价格</td>
    </tr>
    <%
        while(iter.hasNext()){
            Book book=iter.next();//取出每一个Book对象
    %>
    <tr>
        <td><%=book.getBookname()%></td>
        <td><%=book.getChzwriter()%></td>

    </tr>
    <%
        }
    %>
</table>

</body>
</html>
