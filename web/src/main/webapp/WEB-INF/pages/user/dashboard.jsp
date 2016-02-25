<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="user.dashboard"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                <c:otherwise>
                    <%--<c:set var="hasGrantedDistrict" value="false" />--%>
                    <c:set var="noPermissionGranted" value="false" />
                    <%--<security:authorize ifAnyGranted="ADMIN,HAS_GRANTED_DISTRICTS">--%>
                        <%--<c:set var="hasGrantedDistrict" value="true" />--%>
                    <%--</security:authorize>--%>
                    <security:authorize ifAllGranted="NO_PERMISSION_GRANTED">
                        <c:set var="noPermissionGranted" value="true" />
                    </security:authorize>
                    <c:choose>
                        <%--<c:when test="${hasGrantedDistrict eq 'false'}">--%>
                            <%--<div class="callout callout-danger"><fmt:message key="user.dashboard.content.no_district_granted" /></div>--%>
                        <%--</c:when>--%>
                        <c:when test="${noPermissionGranted eq 'true'}">
                            <div class="callout callout-danger"><fmt:message key="user.dashboard.content.no_permission_granted" /></div>
                        </c:when>
                    </c:choose>
                    <c:if test="${not empty firstLogin}">
                        <%--<div class="clear"></div>--%>
                        <%--<div class="alert alert-message alert-success">--%>
                            <%--<fmt:message key="label.welcome" />--%>
                        <%--</div>--%>
                    </c:if>
                </c:otherwise>
            </c:choose>

        </section>
    </div>
</body>
</html>