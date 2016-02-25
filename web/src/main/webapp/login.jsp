<%@ include file="/common/taglibs.jsp" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>LogIn</title>
</head>

<div class="login-box">
    <div class="login-logo">
        <a href="../../index2.html"><fmt:message key="qlxt.title"/></a>
    </div><!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg"><fmt:message key="login.start" /></p>
        <form action="<c:url value="/j_security_check"/>" method="post">
            <div class="form-group has-feedback">
                <input id="userName" name="j_username" type="text" class="form-control" placeholder="User name">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input id="inputPassword" name="j_password" type="password" class="form-control" placeholder="Password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <c:if test="${not empty param.error}">
                <div class="form-group has-feedback">
                    <small style="color: orangered">
                        <c:choose>
                            <c:when test="${param.error == 1}">
                                <fmt:message key="login.error.passwordmissedmatch"/>
                            </c:when>
                            <c:when test="${param.error == 2}">
                                <fmt:message key="login.error.sessionexpired"/>
                            </c:when>
                        </c:choose>
                    </small>
                </div>
            </c:if>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox"><fmt:message key="login.rememberme"/>
                        </label>
                    </div>
                </div><!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat"><fmt:message key="login.title"/></button>
                </div><!-- /.col -->
            </div>
        </form>
    </div><!-- /.login-box-body -->
</div><!-- /.login-box -->
</body>
</html>