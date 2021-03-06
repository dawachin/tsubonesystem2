<html>
<html lang="jp">
<%@ include file="/WEB-INF/view/common/headInclude.jsp"%>
<body>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<%@ include file="/WEB-INF/view/common/jumbotronMenu.jsp"%>
<div class="container">
<h3>以下の内容で登録します。よろしいですか？</h3>
<div class="col-sm-12">
	<%@ include file="/WEB-INF/view/common/partyFormConfirm.jsp"%>
<c:if test="${mailSendFlag}">
	<h3 class="col-md-4">メール</h3>
	<table class="table">
		<tr>
			<th><h4>メールのタイトル</h4></th>
			<td><h5>${f:h(title)}</h5></td>
		</tr>
		<tr>
			<th><h4>メールの内容</h4></th>
			<td><h5>${f:h(content)}</h5></td>
		</tr>
	</table>
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
</c:if>
<s:form method="POST" >
	<%@ include file="/WEB-INF/view/common/confirmButton.jsp"%>
</s:form>
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="${f:url('/js/bootstrap.min.js')}"></script>
</body>
</html>