<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>

<title>Пиздецометр</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta id="metaTitle" property="og:title" content="Пиздецометр" />
<meta id="metaDescription"
      property="og:description" content="Легкий и веселый способ поделиться со всем миром информацией, о том, что у вас все плохо. Или хорошо." />
<meta id="metaUrl" property="og:url" content="http://www.pizdecometr.com" />
<meta id="metaImage" property="og:image" content="http://www.pizdecometr.com/resources/img/voltmeter_7.png" />

<meta id="metaTitle1" name="title" content="Пиздецометр" />
<meta id="metaDescription1" name="description" content="Легкий и веселый способ поделиться со всем миром информацией, о том, что у вас все плохо. Или хорошо." />
<link id="metaImage1" rel="image_src" href="http://www.pizdecometr.com/resources/img/voltmeter_7.png" />


<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico" />

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->


<!-- theme -->
<link href="${pageContext.request.contextPath}/resources/css/theme-dark.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/resources/css/theme-alizarin.css" rel="stylesheet" media="screen">

<!-- My custom stylesheet -->
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/resources/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/resources/js/notify.min.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/resources/js/lazyload.js" type="text/javascript"></script>

<!-- Main logic -->
<script src="${pageContext.request.contextPath}/resources/js/pizdec.js" type="text/javascript"></script>

<label id="realPath" style="display: none;">
    <%= request.getScheme()+"://"
            + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>
</label>
<label id="realPort" style="display: none;"><%= request.getServerPort() %> </label>
<label id="realPathWithoutPort" style="display: none;">
    <%= request.getScheme()+"://" + request.getServerName() + request.getContextPath() %>
</label>