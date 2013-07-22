<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%@include file="../common/prefix.jsp" %>

</head>

<script>

$(document).ready(function () {
	$('body').layout({ applyDefaultStyles: true });
	$( "#mainMenu" ).accordion();
});

</script>
<body>

<div class="ui-layout-west">
	<div id="mainMenu">
		<h3>预约管理</h3>
		<div>
			<ul>
				<li>婚庆预约</li>
				<li>聚餐预约</li>
			</ul>
		</div>
		<h3>消息推送</h3>
		<div>
			<ul>
				<li>about us</li>
				<li>消息推送</li>
			</ul>
		</div>
		<h3>菜品管理</h3>
		<div>
			<ul>
				<li>菜系管理</li>
				<li>菜式管理</li>
				<li>推荐管理</li>
				<li>宴会场地管理</li>
			</ul>
		</div>
		<h3>评论管理</h3>
		<div>
		</div>
		<h3>账户管理</h3>
		<div></div>
	</div>
</div>

<div class="ui-layout-center">center</div>

</body>
</html>