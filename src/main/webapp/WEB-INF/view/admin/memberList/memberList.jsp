<html>
<html lang="jp">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TsuboneSystem</title>
    <link href="${f:url('/css/bootstrap.min.css')}" type="text/css" rel="stylesheet">
    <link href="${f:url('/css/bootstrap-glyphicons.css')}" type="text/css" rel="stylesheet">
    <link href="${f:url('/css/layout.css')}" type="text/css" rel="stylesheet">
    <link href="${f:url('/css/signin.css')}" type="text/css" rel="stylesheet">
  </head>
<body>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<%@ include file="/WEB-INF/view/common/jumbotronMenu.jsp"%>
<div class="container">
<div class="col-sm-12">
<s:form method="POST">
<a class="btn btn-primary" href="<c:url value="/admin/memberRegist/index"/>">新規登録</a>
<a class="btn btn-primary" href="<c:url value="/admin/memberUpload/index"/>">CSV一括登録</a>
<div class="table-responsive">
	<table class="table table-bordered">
		<tr class="info">
		<th></th><th>名前</th><th>ハンドルネーム</th><th>入学年度</th>
				<tr>
					<td align="center">
						<a href="<c:url value="/admin/memberDetail/detail"/>/${loginMember.id}"><span class="glyphicon glyphicon-user"></span></a>
					</td>
					<td>
						${f:h(loginMember.name) }
					</td>
					<td>
						<a href="<c:url value="/admin/memberDetail/detail"/>/${loginMember.id}">${f:h(loginMember.hname) }</a>
					</td>
					<td>
						${f:h(loginMember.entrance) }
					</td>
				</tr>
	</table>
</div>
<div class="table-responsive">

	<%@ include file="/WEB-INF/view/common/pager.jsp"%>
	<table class="table">
		<tr class="info">
			<th></th><th>名前</th><th>ハンドルネーム</th><th>入学年度</th>
			<c:forEach var="e" items="${memberItems}">
				<tr>
					<td>
						<span class="glyphicon glyphicon-user" style="visibility:hidden"></span>
					<td>
						${f:h(e.name) }
					</td>
					<td>
						<a href="<c:url value="/admin/memberDetail/detail"/>/${e.id}">${f:h(e.hname) }</a>
					</td>
					<td>
						${f:h(e.entrance) }
					</td>
				</tr>
			</c:forEach>
	</table>
	<%@ include file="/WEB-INF/view/common/pager.jsp"%>
</div>

</s:form>
</div>
<%@ include file="/WEB-INF/view/common/search.jsp"%>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="${f:url('/js/bootstrap.min.js')}"></script>
</body>
</html>