<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/common/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <%@ include file="/common/meta.jsp" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title><fmt:message key="webapp.name"/>&trade;&nbsp;-&nbsp;<decorator:title/></title>
    <script type="text/javascript" language="javascript">
        var contextPath = '${vms:getAppURL(pageContext.request)}';
    </script>

    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/styles/bootstrap.min.css"/> ">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/styles/font-awesome.min.css"/> ">
    <!-- Ionicons -->
    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/styles/ionicons/2.0.1/css/ionicons.min.css"/> ">
    <!-- Theme style -->
    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/styles/AdminLTE.min.css"/> ">
    <!-- iCheck -->
    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/plugins/iCheck/square/blue.css"/> ">

    <link rel="stylesheet" href="<c:url value="/sc-content/css/login.css"/> ">
    <decorator:head/>
</head>
<body <decorator:getProperty property="body.id" writeEntireProperty="true"/> class='signin hold-transition login-page <decorator:getProperty property="body.class"
                                                                                                                  writeEntireProperty="true"/>'>
<%--<!-- Preloader -->--%>
<%--<div id="preloader">--%>
    <%--<div id="status"><i class="fa fa-spinner fa-spin"></i></div>--%>
<%--</div>--%>

<section>
    <div class="signinpanel">
        <decorator:body/>
        <div id="footer" class="signup-footer">
            <jsp:include page="/common/login_footer.jsp"/>
        </div>
    </div>
</section>

<!-- jQuery 2.1.4 -->
<script src="<c:url value="/themes/vmsreport/plugins/jQuery/jQuery-2.1.4.min.js"/>"></script>
<!-- Bootstrap 3.3.5 -->
<script src="<c:url value="/themes/vmsreport/script/bootstrap.min.js"/>"></script>
<!-- iCheck -->
<script src="<c:url value="/themes/vmsreport/plugins/iCheck/icheck.min.js"/>"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>
</body>
</html>
