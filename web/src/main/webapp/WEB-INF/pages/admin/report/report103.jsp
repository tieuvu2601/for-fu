<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: vovanphuc0810
  Date: 12/22/15
  Time: 2:44 PM
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
<c:url var="formlUrl" value="${prefix}/report/report103.html"/>

<fmt:message var="allText" key="label.all" />
<body>
<div class="content-wrapper">
    <div class="container">
        <form:form commandName="item" action="${formlUrl}" id="listForm" method="post" autocomplete="off" name="listForm" cssClass="form-horizontal">
            <section class="content-header">
                <h4>
                    <fmt:message key="label.report103.title"/>
                        <%--<small><fmt:message key="user.manager.list"/></small>--%>
                </h4>
                <ol class="breadcrumb">
                    <li><a href="${homeUrl}"><i class="fa fa-fw fa-home"></i>&nbsp;<fmt:message key="label.home.title"/></a></li>
                    <li><fmt:message key="menu.report"/></li>
                    <li class="active"><fmt:message key="label.report103.title"/></li>
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
                                    <label class="col-sm-1 control-label col-label-filter"><fmt:message key="label.report105.nguonVon"/></label>
                                    <div class="col-sm-2">
                                        <from:select id="nguonVonId" path="nguonVon.msnguonvon" cssClass="form-control">
                                            <from:option value=""><fmt:message key="label.select"/></from:option>
                                            <from:options items="${listNguonVon}" itemLabel="tennguonvon" itemValue="msnguonvon"/>
                                        </from:select>
                                    </div>
                                    <label class="col-sm-1 control-label col-label-filter" ><fmt:message key="bid.pada.loaidautu"/></label>
                                    <div class="col-md-3">
                                        <from:select id="loaiDauTuId" path="loai.msloai" cssClass="form-control">
                                            <from:option value=""><fmt:message key="label.select"/></from:option>
                                            <from:options items="${listLoai}" itemLabel="tenloai" itemValue="msloai"/>
                                        </from:select>
                                    </div>
                                    <label class="col-sm-1 control-label col-label-filter"><fmt:message key="bid.pada.department"/></label>
                                    <div class="col-md-2">
                                        <from:select id="departmentId" path="department.departmentId" cssClass="form-control">
                                            <from:option value=""><fmt:message key="label.select"/></from:option>
                                            <from:options items="${listDepartment}" itemLabel="name" itemValue="departmentId"/>
                                        </from:select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-1 control-label col-label-filter"><fmt:message key="bid.goithau.quimo"/></label>
                                    <div class="col-sm-2">
                                        <from:select id="quiMoId" path="quiMo.msquimo" cssClass="form-control">
                                            <from:option value=""><fmt:message key="label.select"/></from:option>
                                            <from:options items="${listQuiMo}" itemLabel="tenquimo" itemValue="msquimo"/>
                                        </from:select>
                                    </div>
                                    <label class="col-sm-1 control-label col-label-filter"><fmt:message key="label.from_date"/></label>
                                    <div class="col-sm-3">
                                        <div class="input-daterange input-group input-group-xs" id="datepicker">
                                            <fmt:formatDate value="${item.fromDate}" pattern="${datePattern}" var="fromDate" />
                                            <input id="fromYearId" type="text" name="fromDate" value="${fromDate}"  class="form-control input-xs datePlaceHolder datepicker nohtml" data-trigger="focus">
                                            <span class="input-group-addon"> <fmt:message key="label.den"/> </span>
                                            <fmt:formatDate value="${item.toDate}" pattern="${datePattern}" var="toDate" />
                                            <input id="toYearId" type="text" name="toDate" value="${toDate}" class="form-control input-xs datePlaceHolder datepicker nohtml" data-trigger="focus"/>
                                        </div>
                                    </div>
                                    <%--<label class="col-sm-1 control-label col-label-filter"><fmt:message key="label.year"/></label>--%>
                                    <%--<div class="col-sm-3">--%>
                                        <%--<input id="fromYearId" name="fromYear" value="${item.fromYear}"  class="form-control input-xs datepicker-years input-sm nohtml">--%>
                                    <%--</div>--%>
                                    <%--<label class="col-sm-1 control-label col-label-filter"><fmt:message key="label.den"/></label>--%>
                                    <%--<div class="col-sm-2">--%>
                                        <%--<input id="toYearId" name="toYear" value="${item.toYear}"  class="form-control input-xs datepicker-years input-sm nohtml">--%>
                                    <%--</div>--%>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-1 control-label col-label-filter"><fmt:message key="bid.pada.tinhtrang"/></label>
                                    <div class="col-sm-7">
                                        <form:select path="checkListTinhTrang" cssStyle="width: 100%;">
                                            <form:option value="-1">${allText}</form:option>
                                            <form:options items="${tinhtrangs}" itemLabel="tentinhtrang" itemValue="mstinhtrang"/>
                                        </form:select>
                                    </div>
                                </div>
                                <%--<div class="form-group">--%>
                                    <%--<label class="col-sm-1 control-label col-label-filter"><fmt:message key="bid.pada.tinhtrang"/></label>--%>
                                    <%--<div class="col-sm-10">--%>
                                        <%--<div class="row">--%>
                                            <%--<c:forEach items="${tinhtrangs}" var="item">--%>
                                                <%--<div class="checkbox col-sm-4">--%>
                                                    <%--<label>--%>
                                                        <%--<form:checkbox value="${item.mstinhtrang}" path="checkListTinhTrang" cssClass="nohtml checkListTinhTrang" onclick="checkAllIfOne('listForm', 'checkListTinhTrang', this, 'allCheckTinhTrang')"/>--%>
                                                            <%--${item.tentinhtrang}--%>
                                                    <%--</label>--%>
                                                <%--</div>--%>
                                            <%--</c:forEach>--%>
                                            <%--<div class="checkbox col-sm-4">--%>
                                                <%--<label>--%>
                                                    <%--<form:checkbox value="-1" path="checkListTinhTrang" id="allCheckTinhTrang" cssClass="nohtml checkListTinhTrang"  onclick="checkAll('listForm', 'checkListTinhTrang', this);"/>--%>
                                                        <%--${allText}--%>
                                                <%--</label>--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                                <div class=" with-border">
                                    <div class="col-sm-12 text-center">
                                        <a class="btn btn-primary btn-sm" id="btnFilter"><i class="fa fa-search"></i> <fmt:message key="label.search"/></a>
                                        <a class="btn btn-primary btn-sm" id="btnReset"><i class="fa fa-refresh"></i> <fmt:message key="label.reset" /></a>
                                        <a class="btn btn-primary btn-sm " id="btnExport"><i class="fa fa-file-excel-o"></i> <fmt:message key="label.export"/></a>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="col-xs-12">
                        <div id="content" class="box box-solid box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title"><fmt:message key="label.report103.title"/></h3>
                            </div>

                            <div class="box-body">
                                <table class="table table_vms table-bordered table-hover table-striped  text_center">
                                    <thead>
                                    <tr>
                                        <th rowspan="2"><fmt:message key="label.report103.nhiemVu"/></th>
                                        <th rowspan="2"><fmt:message key="label.report103.cv"/> </th>
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
                                            <td>
                                                <c:choose>
                                                    <c:when test="${dto.goithaunhanvien.ischutri eq 1}">
                                                        <fmt:message key="label.report103.chuTri"/>
                                                    </c:when>
                                                    <c:when test="${dto.goithaunhanvien.ischutri eq 0}">
                                                        <fmt:message key="label.report103.phoiHop"/>
                                                    </c:when>
                                                    <c:when test="${dto.goithaunhanvien.ischutri eq 2}">
                                                        <fmt:message key="label.report103.chuTri"/> - <fmt:message key="label.report103.phoiHop"/>
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                            <td>${dto.user.userName}</td>
                                            <td>${dto.CDT[0]}</td>
                                            <td>${dto.CHCT[0]}</td>
                                            <td>${dto.DTRR[0]}</td>
                                            <td>${dto.MSTT[0]}</td>
                                            <td>${dto.CGCT[0]}</td>
                                            <td style="text-align: center">${dto.total[0]}</td>
                                            <td>${dto.CDT[1]}</td>
                                            <td>${dto.CHCT[1]}</td>
                                            <td>${dto.DTRR[1]}</td>
                                            <td>${dto.MSTT[1]}</td>
                                            <td>${dto.CGCT[1]}</td>
                                            <td style="text-align: center">${dto.total[1]}</td>
                                            <td style="text-align: center">${dto.totalPlug}</td>
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
        setActiveMenu4Admin('#report_menu', '#report103_menu');
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
            setSelectedValueForSelectMenu($("#userId"));
        });
        validateSelect2Select($('#checkListTinhTrang'));
        $('.datepicker-years').datepicker({
            format: "yyyy",
            autoclose: true,
            minViewMode: "years"
        });
    });
</script>
</body>
</html>