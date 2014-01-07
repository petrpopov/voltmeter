<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <t:insertAttribute name="head"/>
</head>

<body>

<div class="container">

    <t:insertAttribute name="content"/>
    <t:insertAttribute name="footer"/>

</div>
</body>
</html>
