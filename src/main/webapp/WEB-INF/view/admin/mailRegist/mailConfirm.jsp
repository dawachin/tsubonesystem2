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
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<%@ include file="/WEB-INF/view/common/jumbotronMenu.jsp"%>
<div class="container">
	<h3 class="col-md-4">以下の内容でよろしいですか？</h3>
	<div class="col-sm-12">
		<table class="table">
			<tr>
				<th><h4>メールのタイトル</h4></th>
				<td><h5>${f:h(title)}</h5></td>
			</tr>
			<tr>
				<th><h4>メールの内容</h4></th>
				<td><pre>${f:h(content)}</pre></td>
			</tr>
		</table>
	</div>
	<div class="col-sm-12">
		<h4 class="col-md-4">メールを送る相手一覧</h4>
		<table class="table table-striped">
			<tr>
				<th><h4>ハンドルネーム</h4></th><th><h4>本名</h4></th>
			</tr>
			<c:forEach var="e" items="${tMemberSendList}">
				<tr>
					<td>${f:h(e.hname)}</td><td>${f:h(e.name)}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
<div class="col-sm-12">
	<s:form method="POST" >
		<input type="submit" value="送信" id="complete" name="complete" property="complete" class="btn btn-primary">
	</s:form>
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="${f:url('/js/bootstrap.min.js')}"></script>
</body>
</html>