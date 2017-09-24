<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  bean.User: Wean
  Date: 2017/9/11
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script>
      function doLogin() {
         var role=document.getElementById("role").value;
         var loginForm=document.getElementById("chzlogin");
         if (role==2){
             loginForm.action="admin/login";
         }
         loginForm.submit();
      }
      function doRegist() {
          var role=document.getElementById("role").value;
          var targetForm=document.forms[0];
          if (role==1){
              targetForm.action="normal/login!regist";
          }else {
              targetForm.action="admin/login!regist";
          }
          targetForm.submit();
      }
    </script>
  </head>
  <body>
  <form action="normal/login" method="post" id="chzlogin">
    User: <input type="text" name="user.chzuname"><br>
    Pass: <input type="password" name="user.chzupwd"><br>
    <select name="user.role" id="role">
      <option value="1">普通用户</option>
      <option value="2">管理员</option>
    </select>
    <input type="submit" value="Login" onclick="doLogin();">&nbsp;&nbsp;
    <input type="submit" value="Regist" onclick="doRegist();">
  </form>
  <s:fielderror> </s:fielderror>
  </body>
</html>
