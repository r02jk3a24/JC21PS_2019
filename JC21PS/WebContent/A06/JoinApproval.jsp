<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="messageBean" class="jp.co.jcps.Bean.MessageBean" scope="request" />
<jsp:useBean id="bean" class="jp.co.jcps.A06.JoinApprovalBean" scope="request" />

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
  <h2 class="teacher-header">部員登録承認</h2>
  <jsp:include page="/A00/Header.jsp"></jsp:include>

  <%
	// メッセージがある場合は表示
	for(int i = 0; i < messageBean.getMessageList().size(); i++){
		out.println("<p>" + messageBean.getMessageList().get(i) + "</p>");
	}
  %>
  <h2><%= bean.getClubName() %></h2>
  <form name="form" action="/JC21PS/JoinApprovalSave" method="POST">
  	<table class='table table-bordered'>
  		<tbody>
  		<tr>
  			<th>部員登録申請者</th>
  			<th></th>
  		</tr>
  		<% for(int i = 0; i < bean.getUserIdList().size(); i++){ %>
  		<tr>
  			<td><%= bean.getUserIdList().get(i) %></td>
  			<td><input type="button"  value="承認" onclick="joinApproval('<%= bean.getUserIdList().get(i) %>')"/></td>
  			<td><input type="button"  value="否認" onclick="joinDisapproval('<%= bean.getUserIdList().get(i) %>')"/></td>
  		</tr>
  		<% } %>
  		</tbody>
  	</table>
  	<div align="center">
  	<input type='button' value='戻る' onclick="location.href='/JC21PS/TopController'" class="btn btn-primary"/>
  	</div>
  	<script>
  		function joinApproval(userId){
			var result = window.confirm('承認しますか？');
			if(result){
				var userElement = document.createElement('input');
				userElement.setAttribute('type','hidden');
				userElement.setAttribute('name','userId');
				userElement.setAttribute('value',userId);
				document.form.appendChild(userElement);
				var approvalElement = document.createElement('input');
				approvalElement.setAttribute('type','hidden');
				approvalElement.setAttribute('name','approval');
				approvalElement.setAttribute('value',true);
				document.form.appendChild(approvalElement);
				document.form.submit();
			}else{
				return false;
			}
  		}

  		function joinDisapproval(userId){
			var result = window.confirm('否認しますか？');
			if(result){
				var userElement = document.createElement('input');
				userElement.setAttribute('type','hidden');
				userElement.setAttribute('name','userId');
				userElement.setAttribute('value',userId);
				document.form.appendChild(userElement);
				var approvalElement = document.createElement('input');
				approvalElement.setAttribute('type','hidden');
				approvalElement.setAttribute('name','approval');
				approvalElement.setAttribute('value',false);
				document.form.appendChild(approvalElement);
				document.form.submit();
			}else{
				return false;
			}
  		}
  	</script>
  	</form>
</body>
</html>