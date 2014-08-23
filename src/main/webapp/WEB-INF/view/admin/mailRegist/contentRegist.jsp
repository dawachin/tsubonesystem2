<html>
<html lang="jp">
<%@ include file="/WEB-INF/view/common/headInclude.jsp"%>
<body>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<%@ include file="/WEB-INF/view/common/jumbotronMenu.jsp"%>
<div class="container">
<h3>メールの内容を入力してください。</h3>
<h5 class="hissu">＊がついている項目は必須です</h5>
<div class="col-sm-12">
<table class="table">
<s:form method="POST" >
<form class="form-horizontal">
	<div class="form-group">
		<label class="control-label col-sm-4" for="Title">メールのタイトル&nbsp;<span class="hissu">＊</span></label>
		<div class="col-sm-8 memberF" >
			<input type="text" id="title" name="title" property="title" class="form-control" placeholder="Title">
			<html:errors property="title"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="Content">メールの内容&nbsp;<span class="hissu">＊</span></label>
		<div class="col-sm-8 memberF">
			<textarea class="form-control" name="content" rows="10" property="content" placeholder="Content"></textarea>
			<html:errors property="content"/>
		</div>
	</div>
	<div class="form-group">
		
			<input type="submit" value="戻る" id="index" name="index" property="index" class="col-md-3 col-md-offset-3 col-sm-5 col-sm-offset-1 col-xs-12  btn btn-primary btnYOKO btnMRC ">
			<input type="submit" value="確認" id="confirm" name="confirm" property="confirm" class="col-md-3 col-sm-5 col-xs-12 btn btn-primary">
	</div>
</form>
</s:form>
</table>
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="${f:url('/js/bootstrap.min.js')}"></script>
</body>
</html>