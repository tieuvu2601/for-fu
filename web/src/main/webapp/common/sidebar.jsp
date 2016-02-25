<%@ page import="com.banvien.vmsreport.security.util.SecurityUtils" %>
<%@page trimDirectiveWhitespaces="true"%>
<%@ include file="/common/taglibs.jsp" %>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin" />
</security:authorize>

<c:set var="avatar" value="/themes/vmsreport/dist/img/avatar.png" />
<c:set var="logo" value="/images/logo/logo.png" />
<security:authentication var="principal" property="principal" />

<c:if test="${not empty principal.avatar}">
    <c:set var="avatar" value="/repository${principal.avatar}" />
</c:if>

<header class="main-header">
    <nav class="navbar navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <a href="../../home.html" class="navbar-brand">MobiFone</a>
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                    <i class="fa fa-bars"></i>
                </button>
            </div>
            <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
                <ul class="nav navbar-nav">
                    <security:authorize ifAnyGranted = "TP,XT,NVPBK,ADMIN">
                        <security:authorize ifAnyGranted = "TP,XT,NVPBK,ADMIN">
                            <li id="contractor_menu" class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <%--<i class="glyphicon glyphicon-oil"></i>--%>
                                    <fmt:message key="contractor.title.management"/>
                                    <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu" role="menu">
                                    <security:authorize ifAnyGranted = "TP,NVPBK,ADMIN">
                                        <li id="pada_menu"><a href="<c:url value="${prefix}/goithau/add.html"/>"> <fmt:message key="contractor.pada"/></a></li>
                                    </security:authorize>
                                    <li id="tiendo_menu"><a href="<c:url value="${prefix}/tiendo/edit.html"/>"> <fmt:message key="contractor.pada.progress"/></a></li>
                                    <li id="goithau_menu"><a href="<c:url value="${prefix}/goithau/list.html"/>"> <fmt:message key="contractor.list"/></a></li>
                                    <security:authorize ifAnyGranted = "TP,XT,ADMIN">
                                        <li id="hosolutru_menu"><a href="<c:url value="${prefix}/hosoluutru/list.html"/>"> <fmt:message key="contractor.brief"/></a></li>
                                        <%--<li id="notification_menu"><a href="<c:url value="${prefix}/notification/list.html"/>"> <fmt:message key="contractor.notification"/></a></li>--%>
                                    </security:authorize>
                                </ul>
                            </li>
                        </security:authorize>
                        <security:authorize ifAnyGranted = "TP,XT,ADMIN">
                            <li id="nhathau_menu" class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <%--<i class="fa fa-university"></i>--%>
                                    <fmt:message key="menu.nhathau"/>
                                    <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu" role="menu">
                                    <li id="capnhatnhathau_menu"><a href="<c:url value="${prefix}/nhathau/capnhatnhathau.html"/>"> <fmt:message key="menu.nhathau.capnhatnhathau"/></a></li>
                                    <li id="hosonhathau_menu"><a href="<c:url value="/hosonhathau/edit.html"/>"> <fmt:message key="menu.nhathau.hosonhathau"/></a></li>
                                    <li id="danhsachnhathau_menu"><a href="<c:url value="${prefix}/nhathau/danhsachnhathau.html"/>"> <fmt:message key="menu.nhathau.danhsachnhathau"/></a></li>
                                        <%--<li id="dangkyhosonhathau_menu"><a href="<c:url value="${prefix}/nhathau/dangkyhosonhathau.html"/>"> <fmt:message key="menu.nhathau.dangkyhosonhathau"/></a></li>--%>
                                </ul>
                            </li>
                        </security:authorize>
                        <security:authorize ifAnyGranted = "TP,ADMIN">
                            <li id="Category_menu" class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                        <%--<i class="fa fa-navicon"></i>--%>
                                    <fmt:message key="menu.Category"/>
                                    <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu" role="menu">
                                    <li id="department_menu"><a href="<c:url value="${prefix}/department/list.html"/>"> <fmt:message key="qlxt.menu.manage.department"/></a></li>
                                    <li id="quymo_menu"><a href="<c:url value="${prefix}/quymo/list.html"/>"> <fmt:message key="qlxt.menu.manage.quimo"/></a></li>
                                    <li id="hinhthuc_menu"><a href="<c:url value="${prefix}/hinhthuc/list.html"/>"> <fmt:message key="qlxt.menu.manage.hinhthuc"/></a></li>
                                    <li id="lanhdao_menu"><a href="<c:url value="${prefix}/lanhdao/list.html"/>"> <fmt:message key="qlxt.menu.manage.lanhdao"/></a></li>
                                    <li id="cancu_menu"><a href="<c:url value="${prefix}/cancu/list.html"/>"> <fmt:message key="qlxt.menu.manage.cancu"/></a></li>
                                </ul>
                            </li>
                        </security:authorize>
                        <security:authorize ifAnyGranted = "TP,XT,ADMIN">
                            <li id="report_menu" class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <%--<i class="fa fa-bar-chart"></i>--%>
                                    <fmt:message key="menu.report"/>
                                    <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li id="report102_menu"><a href="<c:url value="${prefix}/report/report102.html"/>"> <fmt:message key="menu.report102"/></a></li>
                                    <li id="report103_menu"><a href="<c:url value="${prefix}/report/report103.html"/>"> <fmt:message key="menu.report103"/></a></li>
                                    <li id="report104_menu"><a href="<c:url value="${prefix}/report/report104.html"/>"> <fmt:message key="menu.report104"/></a></li>
                                    <li id="report105_menu"><a href="<c:url value="${prefix}/report/report105.html"/>"> <fmt:message key="menu.report105"/></a></li>
                                    <li id="report106_menu"><a href="<c:url value="${prefix}/report/report106.html"/>"> <fmt:message key="menu.report106"/></a></li>
                                    <li id="report107_menu"><a href="<c:url value="${prefix}/report/report107.html"/>"> <fmt:message key="menu.report107"/></a></li>
                                    <li id="report108_menu"><a href="<c:url value="${prefix}/report/report108.html"/>"> <fmt:message key="menu.report108"/></a></li>
                                    <li id="report109_menu"><a href="<c:url value="${prefix}/report/report109.html"/>"> <fmt:message key="menu.report109"/></a></li>
                                </ul>
                            </li>
                        </security:authorize>
                        <security:authorize ifAnyGranted = "TP,XT,ADMIN">
                            <li id="form_menu" class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <%--<i class="fa fa-folder-open-o"></i>--%>
                                    <fmt:message key="menu.form"/>
                                    <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li id="form101_menu"><a href="<c:url value="${prefix}/form/list.html"/>"> <fmt:message key="menu.form.list"/></a></li>
                                </ul>
                            </li>
                        </security:authorize>
                        <security:authorize ifAnyGranted = "TP,ADMIN">
                            <li id="administration_menu" class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                        <%--<i class="fa fa-navicon"></i>--%>
                                    <fmt:message key="menu.administration"/>
                                    <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu" role="menu">
                                    <li id="user_menu"><a href="<c:url value="${prefix}/user/list.html"/>"> <fmt:message key="qlxt.menu.manage.user"/></a></li>
                                </ul>
                            </li>
                        </security:authorize>
                    </security:authorize>
                </ul>
            </div>
            <div class="navbar-custom-menu">
                <div class="nav navbar-nav">
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="<c:url value="${avatar}" />" class="user-image" alt="User Image">
                            <span class="hidden-xs"><%=SecurityUtils.getPrincipal().getDisplayName()%></span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="<c:url value="${avatar}" />" class="img-circle" alt="Avatar">

                                <%--<p>--%>
                                <%--<fmt:message key="user.manager.last_login" />:&nbsp;<%=SecurityUtils.getPrincipal().getLastLoginDateTime()%>--%>
                                <%--</p>--%>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <c:set var="prefix" value="/normal" />
                                <security:authorize ifAnyGranted="ADMIN">
                                    <c:set var="prefix" value="/admin"></c:set>
                                </security:authorize>
                                <div class="pull-left">
                                    <a href="<c:url value="${prefix}/user/profileedit.html?pojo.userId=${principal.userId}"/>" class="btn btn-default btn-flat"><fmt:message key="editprofile" /></a>
                                </div>
                                <div class="pull-right">
                                    <a href="<c:url value="/logout.jsp"/>" class="btn btn-default btn-flat"><fmt:message key="logout" /></a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </div>
            </div>
        </div>
    </nav>
</header>