<%--
  Created by IntelliJ IDEA.
  User: vovanphuc0810
  Date: 10/28/15
  Time: 5:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="content-wrapper">
    <section class="content">
        <c:choose>
            <c:when test="${not empty messageResponse}">
                <div class="clear"></div>
                <div class="alert alert-message alert-${alertType}">
                    <a class="close" data-dismiss="alert" href="#">&times;</a> ${messageResponse}
                </div>
            </c:when>
        </c:choose>
    </section>
</div>
</body>
</html>