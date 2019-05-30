<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="messageBean" class="jp.co.jcps.Bean.MessageBean" scope="request" />
<jsp:useBean id="bean" class="jp.co.jcps.Bean.TopBean" scope="request" />

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
  <h2 class="teacher-header">トップ</h2>
  <%
	// メッセージがある場合は表示
	for(int i = 0; i < messageBean.getMessageList().size(); i++){
		out.println("<p>" + messageBean.getMessageList().get(i) + "</p>");
	}
  %>
  <%
 	for(int i = 0; i < bean.getClubActivityList().size(); i++){
 		out.println("<h2>" + bean.getClubNameList().get(i) + "</h2>");
 		out.println("<table class='table table-bordered'>");
 		out.println("<tbody>");
 		out.println("<tr>");
 		out.println("<th rowspan=3 colspan=1>No</th>");
 		out.println("<th colspan=4>活動名</th>");
 		out.println("<th rowspan=3 colspan=1>参加ステータス</th>");
 		out.println("</tr>");
 		out.println("<tr>");
 		out.println("<th>活動日</th>");
 		out.println("<th>活動時間</th>");
 		out.println("<th>活動場所</th>");
 		out.println("<th>参加予定人数/募集人数</th>");
 		out.println("</tr>");
 		out.println("<tr>");
 		out.println("<th colspan=4>活動説明</th>");
 		out.println("</tr>");
 		for(int j = 0; j <bean.getClubActivityList().get(i).size(); j++){
 			int no = j+1;
 			out.println("<tr>");
 			out.println("<td rowspan=3 colspan=1>" + no + "</td>");
     		out.println("<td colspan=4>" + bean.getClubActivityList().get(i).get(j).getActivityName() + "</td>");
     		if(bean.getClubActivityList().get(i).get(j).getIsParticipationFlg()){
     			out.println("<td rowspan=3>参加</br></br></br></br><input type=button value='不参加にする' onclick='location.href='/></td>");
     		}else{
     			out.println("<td rowspan=3>不参加</br></br></br></br><input type=button value='参加にする' onclick='location.href='/></td>");
     		}

     		out.println("</tr>");
     		out.println("<tr>");
     		out.println("<td>" + bean.getClubActivityList().get(i).get(j).getDispActivityDate() + "</td>");
     		out.println("<td>" + bean.getClubActivityList().get(i).get(j).getDispActivityTime() + "</td>");
     		out.println("<td>" + bean.getClubActivityList().get(i).get(j).getActivityPlace() + "</td>");
     		out.println("<td>" + bean.getClubActivityList().get(i).get(j).getParticipantsCount()+ "/" +bean.getClubActivityList().get(i).get(j).getMaxParticipants()+ "</td>");
     		out.println("</tr>");
     		out.println("<tr>");
     		out.println("<td colspan=4>" + bean.getClubActivityList().get(i).get(j).getActivityDescription() + "</td>");
     		out.println("</tr>");
 		}
 		out.println("<tbody>");
 		out.println("</table>");
 		out.println("</br></br>");
 	}
 %>


</body>
</html>