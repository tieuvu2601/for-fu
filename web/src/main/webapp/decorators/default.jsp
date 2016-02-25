<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/common/meta.jsp" %>
    <title>MobiFone&trade;&nbsp;-&nbsp;<decorator:title/></title>

    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/styles/bootstrap.min.css"/>">
    <%--<link rel="stylesheet"shref="<c:url value="/themes/vmsreport/plugins/bootstrap-table-master/src/bootstrap-table.css"/>">--%>

    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/styles/jquery-ui-1.10.4.custom.min.css"/>">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/styles/ionicons/2.0.1/css/ionicons.min.css"/>">

    <%--<!-- iCheck -->--%>
    <%--<link rel="stylesheet" href="<c:url value="/themes/vmsreport/plugins/iCheck/flat/blue.css"/>">--%>
    <%--<!-- Morris chart -->--%>
    <%--<link rel="stylesheet" href="<c:url value="/themes/vmsreport/plugins/morris/morris.css"/>">--%>
    <%--<!-- jvectormap -->--%>
    <%--<link rel="stylesheet" href="<c:url value="/themes/vmsreport/plugins/jvectormap/jquery-jvectormap-1.2.2.css"/>">--%>
    <!-- Date Picker -->

    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/plugins/bootstrap-datetimepicker-master/css/bootstrap-datepicker3.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/plugins/daterangepicker/daterangepicker.css"/>">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/plugins/daterangepicker/daterangepicker-bs3.css"/>">
    <%--<link rel="stylesheet" href="<c:url value="/themes/vmsreport/plugins/datepicker/datepicker3.css"/>">--%>
<%--<!-- bootstrap wysihtml5 - text editor -->--%>
    <%--<link rel="stylesheet" href="<c:url value="/themes/vmsreport/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" />">--%>
    <!-- Select2 -->
    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/plugins/select2/select2.min.css"/>">
    <!-- Theme style -->
    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/dist/css/AdminLTE_v1.1.css"/>">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/dist/css/skins/_all-skins.min.css"/>">
    <link href="<c:url value="/themes/vmsreport/plugins/bootstrap-switch/bootstrap-switch.css"/>" rel="stylesheet">

    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/css/style_v1.14.css"/>">

    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/css/fixedHeaderTableStyle_v1.0.css"/>">
    <!-- jQuery 2.1.4 -->
    <script src="<c:url value="/themes/vmsreport/plugins/jQuery/jQuery-2.1.4.min.js" />"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="<c:url value='/themes/vmsreport/javascript/html5shiv/3.7.3/html5shiv.min.js'/>"></script>
    <script src="<c:url value='/themes/vmsreport/javascript/respond/1.4.2/respond.min.js'/>"></script>
    <![endif]-->

    <decorator:head/>
</head>

<body <decorator:getProperty property="body.id" writeEntireProperty="true"/> class='skin-blue layout-top-nav <decorator:getProperty property="body.class"
                                                                                                                                            writeEntireProperty="false"/>'>
<section>

    <div class="wrapper">

        <jsp:include page="/common/sidebar.jsp"/>

        <!-- body -->
        <decorator:body/>

        <!-- footer -->
        <div id="footer">
            <jsp:include page="/common/footer.jsp"></jsp:include>
        </div>
    </div>
    <!-- mainpanel -->


</section>

<!-- jQuery UI 1.11.4 -->
<%--<script src="<c:url value="/themes/vmsreport/plugins/jQueryUI/jquery-ui.min.js" />"></script>--%>
<script src="<c:url value="/themes/vmsreport/script/jquery-ui.js" />"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.5 -->
<script src="<c:url value="/themes/vmsreport/script/bootstrap.min.js" />"></script>
<!-- Morris.js charts -->
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="<c:url value="/themes/vmsreport/plugins/morris/morris.min.js" />"></script>--%>
<!-- Sparkline -->
<%--<script src="<c:url value="/themes/vmsreport/plugins/sparkline/jquery.sparkline.min.js" />"></script>--%>
<!-- jvectormap -->
<%--<script src="<c:url value="/themes/vmsreport/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" />"></script>--%>
<%--<script src="<c:url value="/themes/vmsreport/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" />"></script>--%>
<!-- jQuery Knob Chart -->
<%--<script src="<c:url value="/themes/vmsreport/plugins/knob/jquery.knob.js" />"></script>--%>
<!-- Bootbox -->
<script src="<c:url value="/scripts/bootbox.min.js" />"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="<c:url value="/themes/vmsreport/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" />"></script>
<!-- date-range-picker -->

<%--Use this version for vietnamese language--%>
<script src="<c:url value="/themes/vmsreport/plugins/daterangepicker/moment_vi.js" />"></script>

<%--Do not use below minimized version for moment JS. B/c above unminimized version has modified for the Vietnamese language.--%>
<script src="<c:url value="/themes/vmsreport/plugins/bootstrap-datetimepicker-master/js/bootstrap-datepicker.min.js" />"></script>
<script src="<c:url value="/themes/vmsreport/plugins/daterangepicker/daterangepicker_v1.0.js"/>"></script>
<script src="<c:url value="/themes/vmsreport/plugins/daterangepicker/jquery.daterangepicker_v1.0.js"/>"></script>
<script src="<c:url value="/themes/vmsreport/plugins/fixedTable/jquery.fixedheadertable.js"/>"></script>

<%--<script type="text/javascript" src="<c:url value="/themes/vmsreport/plugins/bootstrap-datetimepicker-master/js/bootstrap-datepicker.js"/>" charset="UTF-8"></script>--%>
<%--<script type="text/javascript" src="<c:url value="/themes/vmsreport/plugins/bootstrap-datetimepicker-master/js/bootstrap-datepicker.vi.js"/>" charset="UTF-8"></script>--%>
<!-- Slimscroll -->
<script src="<c:url value="/themes/vmsreport/plugins/slimScroll/jquery.slimscroll.min.js" />"></script>
<!-- FastClick -->
<script src="<c:url value="/themes/vmsreport/plugins/fastclick/fastclick.min.js" />"></script>
<!-- AdminLTE App -->
<script src="<c:url value="/themes/vmsreport/dist/js/app.min.js" />"></script>
<!-- Select2 -->
<script src="<c:url value="/themes/vmsreport/plugins/select2/select2.full.min.js"/>"></script>
<%--<!-- AdminLTE for demo purposes -->
<script src="<c:url value="/themes/vmsreport/dist/js/demo.js" />"></script>--%>
<%--<!-- fullCalendar 2.2.5 -->--%>
<%--<script src="<c:url value="/themes/vmsreport/plugins/daterangepicker/moment.min.js" />"></script>--%>
<%--<script src="<c:url value="/themes/vmsreport/plugins/fullcalendar/fullcalendar.min.js"/>"></script>--%>
<script src="<c:url value="/themes/vmsreport/plugins/bootstrap-switch/bootstrap-switch.js"/>"></script>
<%--<script src="<c:url value="/themes/vmsreport/plugins/bootstrap-table-master/src"/>"></script>--%>
<script src="<c:url value="/themes/vmsreport/script/jquery.validate.js"/>"></script>
<script src="<c:url value="/themes/vmsreport/script/jquery.validate.js"/>"></script>
<script src="<c:url value="/themes/vmsreport/javascript/ebid-admin.js"/>"></script>
<script src="<c:url value="/themes/vmsreport/script/jquery-validate.bootstrap-tooltip.js"/>"></script>
<script src="<c:url value="/scripts/global.source.v_1.9.js"/>"></script>
<script src="<c:url value="/scripts/global.source_v.1.0.js"/>"></script>
<script src="<c:url value="/themes/vmsreport/script/jquery.cookie.js"/>"></script>
<script src="<c:url value="/themes/vmsreport/plugins/iCheck/icheck.min.js"/>"></script>
<script src="<c:url value="/themes/vmsreport/plugins/input-mask/jquery.inputmask.js"/>"></script>
<script src="<c:url value="/themes/vmsreport/plugins/input-mask/jquery.inputmask.date.extensions.js"/>"></script>
<script src="<c:url value="/themes/vmsreport/plugins/input-mask/jquery.inputmask.extensions.js"/>"></script>
<%--<script src="<c:url value="/scripts/jquery/jquery.mask.js"/>"></script>--%>
</body>
</html>