<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><decorator:title/></title>

    <!--Loading bootstrap css-->
    <link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,700">
    <link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,700,300">
    <link type="text/css" rel="stylesheet" href="/themes/admin/css/jquery-ui-1.10.4.custom.min.css">
    <link type="text/css" rel="stylesheet" href="/themes/admin/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="/themes/admin/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="/themes/admin/css/animate.css">
    <link type="text/css" rel="stylesheet" href="/themes/admin/css/all.css">
    <link type="text/css" rel="stylesheet" href="/themes/admin/css/main.css">
    <link type="text/css" rel="stylesheet" href="/themes/admin/css/style-responsive.css">
    <link type="text/css" rel="stylesheet" href="/themes/admin/css/zabuto_calendar.min.css">
    <link type="text/css" rel="stylesheet" href="/themes/admin/css/pace.css">
    <link type="text/css" rel="stylesheet" href="/themes/admin/css/jquery.news-ticker.css">

    <decorator:head/>
</head>
<body>
<!-- Preloader -->
<div id="preloader">
    <div id="status"><i class="fa fa-spinner fa-spin"></i></div>
</div>


<section>
    <div class="headerbar">

        <jsp:include page="/common/admin_header.jsp"/>

    </div><!-- headerbar -->




    <div class="mainpanel">
        <div class="leftpanel">

            <jsp:include page="/common/admin_nav.jsp"></jsp:include>

        </div><!-- leftpanel -->

        <jsp:include page="/common/chat_form.jsp"></jsp:include>

        <decorator:body/>
    </div><!-- mainpanel -->



</section>

<script src="<c:url value="/themes/admin/js/jquery-migrate-1.2.1.min.js"/>"></script>
<script src="<c:url value="/themes/admin/js/jquery-ui-1.10.3.min.js"/>"></script>
<script src="<c:url value="/themes/admin/js/bootstrap.min.js"/>"></script>

<script src="<c:url value="/themes/admin/js/select2.min.js"/>"></script>

<script src="<c:url value="/themes/admin/js/custom.js"/>"></script>
</script><script src='<c:url value="/scripts/global.source.v_1.4.js"/>'></script>
<script>
    jQuery(document).ready(function(){
    });
</script>


</body>
</html>
