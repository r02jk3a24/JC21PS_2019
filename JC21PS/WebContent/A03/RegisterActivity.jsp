<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="messageBean" class="jp.co.jcps.Bean.MessageBean" scope="request" />
<jsp:useBean id="bean" class="jp.co.jcps.Bean.RegisterActivityBean" scope="request" />

<link rel="stylesheet" type="text/css" href="/JC21PS/css/common.css" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
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
  <h2 class="teacher-header">活動登録</h2>
  <jsp:include page="/A00/Header.jsp"></jsp:include>

  <%
	// メッセージがある場合は表示
	for(int i = 0; i < messageBean.getMessageList().size(); i++){
		out.println("<p>" + messageBean.getMessageList().get(i) + "</p>");
	}
  %>
  <form action="/JC21PS/SaveParticipationServlet" method="POST">
  	<table class='table table-bordered'>
  		<tbody>
  		<tr>
  			<th colspan="1">部活名</th>
  			<td colspan="3"><%= bean.getClubName() %></td>
  		</tr>
  		<tr>
  			<th colspan="1">活動名</th>
  			<td colspan="3"><input type="text" name="registActivityName" maxlength="30"/></td>
  		</tr>
  		<tr>
  			<th colspan="1">活動日</th>
  			<td colspan="1"><input type="date" name="registActivityDate" maxlength="10"/></td>
  			<th colspan="1">活動時間</th>
  			<td colspan="1"><input type="time" name="registActivityStartTime" maxlength="30"/>～
  			<input type="time" name="registActivityEndTime" maxlength="30"/></td>
  		</tr>
  		<tr>
  			<th colspan="1">募集人数</th>
  			<td colspan="3"><input type="text" name="registMaxParticipant" maxlength="10"/></td>
  		</tr>
  		<tr>
  			<th colspan="1">活動説明</th>
  			<td colspan="3"><textarea name="registMaxParticipant"  rows="5" cols="80"></textarea></td>
  		</tr>
  		</tbody>
  	</table>
  	<div  align="center">
  		<input type="button" name="save" value="登録" onclick="saveLecture()" class="btn btn-primary">
  		<input type="button" name="save" value="戻る" onclick="saveLecture()" class="btn btn-primary">
  	</div>
</form>

</body>
</html>