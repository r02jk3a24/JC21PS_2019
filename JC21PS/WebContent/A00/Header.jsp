<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="messageBean" class="jp.co.jcps.Bean.MessageBean" scope="request" />
<link rel="stylesheet" type="text/css" href="/JC21PS/css/common.css" />
<html>
<head>
<meta charset="UTF-8">
<title>出席登録システム</title>
</head>
<body>
<%
	// メッセージがある場合は表示
	for(int i = 0; i < messageBean.getMessageList().size(); i++){
		out.println("<p>" + messageBean.getMessageList().get(i) + "</p>");
	}
%>
<div class="login">
  <h2 class="student-header">出席登録システム</h2>
  <form class="login-container" action="/JC21PS/Student" method="post">
    <p><input type="text" placeholder="ログイン名" name="loginNm"></p>
    <p><input type="password" placeholder="パスワード" name="password"></p>
    <p><input type="submit" value="Log in" style="background: #ff7f50"></p>
  </form>
</div>

</body>
</html>