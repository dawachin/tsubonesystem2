<html>
<html lang="jp">
<%@ include file="/WEB-INF/view/common/headInclude.jsp"%>
<body>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<%@ include file="/WEB-INF/view/common/jumbotronMenu.jsp"%>
<div class="container CENTER">
	<h3>登録が完了しました。</h3>
	<a href="<c:url value="/${loginMemberDto.actorKind}/partyList"/>"><button type="button" class="col-md-4 col-md-offset-4 col-sm-4 col-sm-offset-4 col-xs-12 btn btn-default btn-lg btnYOKO30 btnMRC">Back.PartyList </button></a>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="${f:url('/js/bootstrap.min.js')}"></script>
</body>
</html>