<html>
<html lang="jp">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TsuboneSystem</title>
    <link href="${f:url('/css/bootstrap.min.css')}" type="text/css" rel="stylesheet">
    <link href="${f:url('/css/layout.css')}" type="text/css" rel="stylesheet">
    <link href="${f:url('/css/signin.css')}" type="text/css" rel="stylesheet">
  </head>
<body>
<%@ include file="/WEB-INF/view/common/indeividualsHeader.jsp"%>
<%@ include file="/WEB-INF/view/common/jumbotronMenu.jsp"%>
<div class="container">
<h3 class="col-md-6 col-xs-12">${f:h(meetingName)}たんの詳細情報</h3>
<div class="col-sm-12">
<table class="table">
	<tr>
		<th><h4>会議の名前</h4></th>
		<td><h5>${f:h(meetingName)}</h5></td>
	</tr>
	<tr>
		<th><h4>必須判定</h4></th>
	　	<td>
			<c:if test="${meetingNecessaryFlag}">
				<h5>出席を必須とする</h5>
			</c:if>
		</td>
	</tr>
	<tr>
		<th><h4>会議の開催日時</h4></th>
		<td><h5>${f:h(meetingDay)}</h5></td>
	</tr>
	<tr>
		<th><h4>開催時間</h4></th>
		<td><h5>${f:h(meetingTime)}</h5></td>
	</tr>
	<tr>
		<th><h4>会議の開催場所</h4></th>
		<td><h5>${f:h(meetingRoom)}</h5></td>
	</tr>
	<tr>
		<th><h4>会議の内容</h4></th>
		<td><h5>${f:h(meetingMemo)}</h5></td>
	</tr>
	<tr>
		<th><h4>OB出席</h4></th>
		<td>
			<c:if test="${ObAttendFlag}">
				<h5>OBを出席対象とする</h5>
			</c:if>
		</td>
	</tr>
	<tr>
		<th><h4>会議の締切時間</h4></th>
		<td><h5>${f:h(meetingDeadlineDay)}</h5></td>
	</tr>
	<c:if test="${deadFlag}">
		<tr>
			<th><h4>審議の結果</h4></th>
			<td><h5><pre>${f:h(meetingResult)}</pre></h5></td>
		</tr>
	</c:if>
</table>
<c:if test="${!deadFlag}">
	<div class="row CENTER">
		<a class="col-md-3 col-md-offset-3 col-sm-5 col-sm-offset-1 col-xs-12  btn btn-primary btnYOKO btnMRC" href="<c:url value="/individuals/attend/yes"/>">出席する</a>
		<a class="col-md-3 col-sm-5 col-xs-12 btn btn-primary" href="<c:url value="/individuals/attend/no"/>">欠席する</a>
	</div>
</c:if>
<c:if test="${deadFlag}">
	<div class="alert alert-danger"><h4>この会議は締め切り時間を過ぎています</h4></div>
</c:if>
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="${f:url('/js/bootstrap.min.js')}"></script>
</body>
</html>