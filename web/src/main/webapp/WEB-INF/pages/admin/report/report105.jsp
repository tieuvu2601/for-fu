<%--
  Created by IntelliJ IDEA.
  User: vovanphuc0810
  Date: 12/24/15
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="label.nhathau.title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin"/>
</security:authorize>

<c:url var="homeUrl" value="/index.html"/>
<c:url var="backUrl" value="${prefix}/index.html"/>
<c:url var="formlUrl" value="${prefix}/report/report105.html"/>

<fmt:message var="allText" key="label.all" />
<body>
<div class="content-wrapper">
    <div class="container">
        <form:form commandName="item" action="${formlUrl}" id="listForm" method="post" autocomplete="off" name="listForm" cssClass="form-horizontal">
            <section class="content-header">
                <h4>
                    <fmt:message key="label.report105.title"/>
                        <%--<small><fmt:message key="user.manager.list"/></small>--%>
                </h4>
                <ol class="breadcrumb">
                    <li><a href="${homeUrl}"><i class="fa fa-fw fa-home"></i>&nbsp;<fmt:message key="label.home.title"/></a></li>
                    <li><fmt:message key="menu.report"/></li>
                    <li class="active"><fmt:message key="label.report105.title"/></li>
                </ol>
                <c:if test="${not empty messageResponse}">
                    <div class="clear"></div>
                    <div class="alert alert-message alert-${alertType}">
                        <a class="close" data-dismiss="alert" href="#">&times;</a> ${messageResponse}
                    </div>
                </c:if>
            </section>

            <section class="content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="box box-solid box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title"><fmt:message key="label.filter"/></h3>
                            </div>
                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><fmt:message key="label.from_date"/></label>
                                    <div class="col-sm-2">
                                        <div class="input-daterange input-group input-group-xs" id="datepicker">
                                            <fmt:formatDate value="${item.fromDate}" pattern="${datePattern}" var="fromDate" />
                                            <input id="fromYearId" type="text" name="fromDate" value="${fromDate}"  class="form-control input-xs datePlaceHolder datepicker nohtml" data-trigger="focus">
                                            <span class="input-group-addon "> <fmt:message key="label.den"/> </span>
                                            <fmt:formatDate value="${item.toDate}" pattern="${datePattern}" var="toDate" />
                                            <input id="toYearId" type="text" name="toDate" value="${toDate}" class="form-control input-xs datePlaceHolder datepicker nohtml" data-trigger="focus"/>
                                        </div>
                                    </div>
                                    <label class="col-sm-2 control-label"><fmt:message key="bid.pada.tinhtrang"/></label>
                                    <div class="col-sm-6">
                                        <form:select path="checkListTinhTrang" cssStyle="width: 100%;">
                                            <form:option value="-1">${allText}</form:option>
                                            <form:options items="${tinhtrangs}" itemLabel="tentinhtrang" itemValue="mstinhtrang"/>
                                        </form:select>
                                    </div>
                                </div>
                                <div class="with-border">
                                    <div class="col-sm-12 text-center">
                                        <a class="btn btn-sm btn-primary btn-sm" id="btnFilter"><i class="fa fa-search"></i> <fmt:message key="label.search"/></a>
                                        <a class="btn btn-sm btn-primary btn-sm" id="btnReset"><i class="fa fa-refresh"></i> <fmt:message key="label.reset" /></a>
                                        <a class="btn btn-sm btn-primary btn-sm" id="btnExport"><i class="fa fa-file-excel-o"></i> <fmt:message key="label.export"/></a>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="col-xs-12">
                        <div id="content" class="box box-solid box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title"><fmt:message key="label.report105.title"/></h3>
                            </div>

                            <div class="box-body">
                                <table class="table table_vms table-bordered table-hover table-striped  text_center">
                                    <thead>
                                    <tr>
                                        <th rowspan="2"><fmt:message key="label.report105.nguonVon"/></th>
                                        <th rowspan="2"><fmt:message key="label.report105.department"/> </th>
                                        <th colspan="6"><fmt:message key="label.report103.dangThucHien"/> </th>
                                        <th colspan="6"><fmt:message key="label.report103.daHoanTat"/> </th>
                                        <th rowspan="2"><fmt:message key="label.report103.totalPlug"/> </th>
                                    </tr>
                                    <tr>
                                        <th><fmt:message key="label.report103.CDT"/></th>
                                        <th><fmt:message key="label.report103.CHCT"/> </th>
                                        <th><fmt:message key="label.report103.DTRR"/> </th>
                                        <th><fmt:message key="label.report103.MSTT"/> </th>
                                        <th><fmt:message key="label.report103.CGCT"/> </th>
                                        <th><fmt:message key="label.report103.total"/> </th>
                                        <th><fmt:message key="label.report103.CDT"/></th>
                                        <th ><fmt:message key="label.report103.CHCT"/> </th>
                                        <th><fmt:message key="label.report103.DTRR"/> </th>
                                        <th><fmt:message key="label.report103.MSTT"/> </th>
                                        <th><fmt:message key="label.report103.CGCT"/> </th>
                                        <th><fmt:message key="label.report103.total"/> </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${items.listResult}" var="dto">
                                        <tr>
                                            <td>${dto.nguonvon.tennguonvon}</td>
                                            <td>${dto.department.code}</td>
                                            <td>${dto.CDT[0]}</td>
                                            <td>${dto.CHCT[0]}</td>
                                            <td>${dto.DTRR[0]}</td>
                                            <td>${dto.MSTT[0]}</td>
                                            <td>${dto.CGCT[0]}</td>
                                            <td>${dto.total[0]}</td>
                                            <td>${dto.CDT[1]}</td>
                                            <td>${dto.CHCT[1]}</td>
                                            <td>${dto.DTRR[1]}</td>
                                            <td>${dto.MSTT[1]}</td>
                                            <td>${dto.CGCT[1]}</td>
                                            <td>${dto.total[1]}</td>
                                            <td>${dto.totalPlug}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <form:hidden path="crudaction" id="crudaction"/>
                    <%--<form:hidden path="fromDate" id="fromDate"/>--%>
                    <%--<form:hidden path="toDate" id="toDate"/>--%>
            </section>
        </form:form>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        setActiveMenu4Admin('#report_menu', '#report105_menu');
        var isSearchString = false;

        $("#btnFilter").click(function () {
            $("#crudaction").val("search");
            $("#listForm").submit();
        });
        $("#btnExport").click(function () {
            $("#crudaction").val("export");
            $("#listForm").submit();
        });
        $("#btnReset").click(function () {
            $("#fromYear").val("");
            $("#toYear").val("");
//            setSelectedValueForSelectMenu($("#userId"));
        });
        validateSelect2Select($('#checkListTinhTrang'));
    });
</script>
</body>
</html>