<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jp.co.jcps.A05.JoinRequestBean"%>
<jsp:useBean id="messageBean" class="jp.co.jcps.Bean.MessageBean" scope="request" />
<jsp:useBean id="bean" class="jp.co.jcps.A05.JoinRequestBean" scope="request" />

<link rel="stylesheet" type="text/css" href="/JC21PS/css/common.css" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部活動管理システム</title>
<style type="text/css">
	th {
		background-color: #add8e6;
	}
</style>
</head>
<body>
  <div class="container"></div>
  <h2 class="teacher-header">部員登録申請</h2>
  <jsp:include page="/A00/Header.jsp"></jsp:include>

  <%
	// メッセージがある場合は表示
	for(int i = 0; i < messageBean.getMessageList().size(); i++){
		out.println("<p>" + messageBean.getMessageList().get(i) + "</p>");
	}
  %>
  <form action="/JC21PS/JoinRequestSave" method="POST">
  	<table class='table table-bordered'>
  		<tbody>
  		<tr>
  			<th colspan="1">部活名</th>
  			<th colspan="1"></th>
  		</tr>
  		<tr>
  			<th colspan="2">部活説明</th>
  		</tr>
  		<% for(int i = 0; i < bean.getJoinRequestList().size(); i++){ %>
  		<tr>
  			<td colspan="1"><%= bean.getJoinRequestList().get(i).getClubName() %></td>
  			<td colspan="1"><button type='submit' name='registClubId'  value='<%= bean.getJoinRequestList().get(i).getClubId() %>' onclick="return confirm('申請しますか？')">部員登録申請</button></td>
  		</tr>
  		<tr>
  			<td colspan ="2"><%= bean.getJoinRequestList().get(i).getClubDescription() %></td>
  		<%} %>
  		</tbody>
  	</table>
  	<div align="center">
  	<input type='button' value='戻る' onclick="location.href='/JC21PS/TopController'" class="btn btn-primary"/>
  	</div>
</form>
</body>
</html>