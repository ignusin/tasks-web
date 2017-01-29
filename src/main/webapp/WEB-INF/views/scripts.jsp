<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="<c:url value="/static/libs/jquery-3.1.1.min.js" />"></script>
<script src="<c:url value="/static/libs/bootstrap-3.3.7-dist/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/static/libs/angular.min.js" />"></script>
<script src="<c:url value="/static/libs/ui-bootstrap-tpls-2.5.0.min.js" />"></script>

<link rel="stylesheet" href="<c:url value="/static/libs/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" />
<link rel="stylesheet" href="<c:url value="/static/libs/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />" />

<script src="<c:url value="/static/app.js" />"></script>
<link rel="stylesheet" href="<c:url value="/static/app.css" />" />

<script>
	(function () {
		var rootUrl = '<c:url value="/" />';
		rootUrl = rootUrl.substr(0, rootUrl.length - 1);
		
		angular.module('app').constant('rootUrl', rootUrl);
	}) ();
</script>