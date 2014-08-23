<html>
<html lang="jp">
<%@ include file="/WEB-INF/view/common/headInclude.jsp"%>
<body>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<%@ include file="/WEB-INF/view/common/jumbotronMenu.jsp"%>
<div class="container CENTER">
	<h3>${f:h(mailMsg)}</h3>
	<a href="<c:url value="/leaders/clubList"/>"><button type="button" class="col-md-4 col-md-offset-1 col-sm-5 col-xs-12 btn btn-default btn-lg btnYOKO30 btnMRC">Back.ClubList </button></a>
	<a href="<c:url value="/leaders/clubDetail/${id}"/>"><button type="button" class="col-md-4 col-md-offset-1 col-sm-5  col-xs-12 btn btn-default btn-lg">Show.MemberDetail</button></a>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="${f:url('/js/bootstrap.min.js')}"></script>
</body>
</html>