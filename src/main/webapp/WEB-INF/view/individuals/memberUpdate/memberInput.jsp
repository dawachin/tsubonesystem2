<html>
<html lang="jp">
<%@ include file="/WEB-INF/view/common/headInclude.jsp"%>
<body>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<%@ include file="/WEB-INF/view/common/jumbotronMenu.jsp"%>
<div class="container">
<h3>メンバー情報を入力してください。</h3>
<h5 class="hissu">＊がついている項目は必須です</h5>
<c:if test="${sendErrorFlag}">
	<div class="alert alert-danger"><h4>メールが正常に届いていません。メールアドレスを確認して下さい。</h4></div>
</c:if>
<div class="col-sm-12">
<s:form method="POST" >
<%@ include file="/WEB-INF/view/common/memberUpdateFormInput.jsp"%>
</s:form>
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="${f:url('/js/bootstrap.min.js')}"></script>
</body>
</html>