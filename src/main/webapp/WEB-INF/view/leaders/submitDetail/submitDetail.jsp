<html>
<html lang="jp">
	<%@ include file="/WEB-INF/view/common/headInclude.jsp"%>
	<body>
		<%@ include file="/WEB-INF/view/common/header.jsp"%>
		<%@ include file="/WEB-INF/view/common/jumbotronMenu.jsp"%>
		<div class="container">
			<h3>${submitForm.submitName}の詳細情報</h3>
			<%@ include file="/WEB-INF/view/common/submitFormConfirm.jsp"%>
		</div>
		<div class="container">
			<div class="col-md-12">
				<c:if test="${tImageUpload != null}">
					<div class="col-md-4">
						<h3>caption</h3>
					</div>
					<div class="col-md-8">
						<img src="${f:url('/api/displyImage')}${tImageUpload.id}" width="240" height="180" style="display:block;width:60%;height:auto;"/>
					</div>
				</c:if>
			</div>
		</div>
		<c:if test="${isEdit}">
			<div class="container marginUP">
				<a class="col-md-10 col-sm-10 col-sm-offset-1 col-xs-12  btn btn-danger" href="<c:url value="/${loginMemberDto.actorKind}/submitDelete/${id}"/>" role="button">削除</a>
			</div>
		</c:if>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="${f:url('/js/bootstrap.min.js')}"></script>
	</body>
</html>