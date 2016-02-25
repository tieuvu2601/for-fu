<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: vovanphuc0810
  Date: 12/28/15
  Time: 1:47 PM
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
    <link href="<c:url value="/themes/vmsreport/plugins/CustomScrollbar/jquery.mCustomScrollbar.min.css"/>" rel="stylesheet">
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin"/>
</security:authorize>

<c:url var="homeUrl" value="/index.html"/>
<c:url var="backUrl" value="${prefix}/index.html"/>
<c:url var="formlUrl" value="${prefix}/report/report106.html"/>

<fmt:message var="allText" key="label.all" />
<body>
<div class="content-wrapper">
    <div class="container">
    <form:form commandName="item" action="${formlUrl}" id="listForm" method="post" autocomplete="off" name="listForm" cssClass="form-horizontal">
    <section class="content-header">
        <h4>
            <fmt:message key="label.report106.title"/>
                <%--<small><fmt:message key="user.manager.list"/></small>--%>
        </h4>
        <ol class="breadcrumb">
            <li><a href="${homeUrl}"><i class="fa fa-fw fa-home"></i>&nbsp;<fmt:message key="label.home.title"/></a></li>
            <li><fmt:message key="menu.report"/></li>
            <li class="active"><fmt:message key="label.report106.title"/></li>
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
                    <div class="col-sm-4">
                        <label class="col-sm-4 control-label"><fmt:message key="label.report105.nguonVon"/></label>
                        <div class="col-sm-8">
                            <from:select id="nguonVonId" path="pojo.nguonvon.msnguonvon" cssClass="form-control">
                                <from:option value=""><fmt:message key="label.select"/></from:option>
                                <from:options items="${listNguonVon}" itemLabel="tennguonvon" itemValue="msnguonvon"/>
                            </from:select>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <label class="col-sm-4 control-label" ><fmt:message key="bid.pada.loaidautu"/></label>
                        <div class="col-md-8">
                            <from:select id="loaiDauTuId" path="loai.msloai" cssClass="form-control">
                                <from:option value=""><fmt:message key="label.select"/></from:option>
                                <from:options items="${listLoai}" itemLabel="tenloai" itemValue="msloai"/>
                            </from:select>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <label class="col-sm-4 control-label"><fmt:message key="bid.pada.department"/></label>
                        <div class="col-md-8">
                            <from:select id="departmentId" path="pojo.department.departmentId" cssClass="form-control">
                                <from:option value=""><fmt:message key="label.select"/></from:option>
                                <from:options items="${listDepartment}" itemLabel="name" itemValue="departmentId"/>
                            </from:select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label class="col-sm-4 control-label"><fmt:message key="label.report103.chuTri"/></label>
                        <div class="col-sm-8">
                            <from:select id="chairId" path="chair" cssClass="form-control">
                                <from:option value=""><fmt:message key="label.select"/></from:option>
                                <from:options items="${listChuTri}" itemLabel="userName" itemValue="userId"/>
                            </from:select>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.tochuyengia.thanhvien"/></label>
                        <div class="col-sm-8">
                            <from:select id="userId" path="pojo.user.userId" cssClass="form-control">
                                <from:option value=""><fmt:message key="label.select"/></from:option>
                                <from:options items="${listThanhVien}" itemLabel="userName" itemValue="userId"/>
                            </from:select>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.quimo"/></label>
                        <div class="col-sm-8">
                            <from:select id="quiMoId" path="pojo.quimo.msquimo" cssClass="form-control">
                                <from:option value=""><fmt:message key="label.select"/></from:option>
                                <from:options items="${listQuiMo}" itemLabel="tenquimo" itemValue="msquimo"/>
                            </from:select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label class="col-sm-4 control-label"><fmt:message key="tiendo.label.soQuyetDinhpada"/></label>
                        <div class="col-sm-8">
                            <form:input id="qdPheDuyetSoId" path="pojo.tienDo.qdPheDuyetSo" cssClass="form-control input-xs"/>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <label class="col-sm-4 control-label"><fmt:message key="label.nhathau.magoithau"/></label>
                        <div class="col-sm-8">
                            <form:input id="maGoiThauId" path="pojo.bid.magoithau" cssClass="form-control input-xs"/>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <label class="col-sm-4 control-label"><fmt:message key="label.nhathau.tengoithau"/></label>
                        <div class="col-sm-8">
                            <form:input id="tenGoiThauId" path="pojo.bid.tengoithau" cssClass="form-control input-xs"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-4">
                        <label class="col-sm-4 control-label"><fmt:message key="label.from_date"/></label>
                        <div class="col-sm-8">
                            <div class="input-daterange input-group input-group-xs" id="datepicker">
                                <fmt:formatDate value="${item.fromDate}" pattern="${datePattern}" var="fromDate" />
                                <input id="fromYearId" type="text" name="fromDate" value="${fromDate}"  class="form-control input-xs datePlaceHolder datepicker nohtml" data-trigger="focus">
                                <span class="input-group-addon "> <fmt:message key="label.den"/> </span>
                                <fmt:formatDate value="${item.toDate}" pattern="${datePattern}" var="toDate" />
                                <input id="toYearId" type="text" name="toDate" value="${toDate}" class="form-control input-xs datePlaceHolder datepicker nohtml" data-trigger="focus"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <label class="col-sm-2 control-label"><fmt:message key="bid.pada.tinhtrang"/></label>
                        <div class="col-sm-8">
                            <form:select path="checkListTinhTrang" cssStyle="width: 100%;">
                                <form:option value="-1">${allText}</form:option>
                                <form:options items="${tinhtrangs}" itemLabel="tentinhtrang" itemValue="mstinhtrang"/>
                            </form:select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-8">
                        <label class="col-sm-2 control-label"><fmt:message key="bid.pada.hinhthuc"/></label>
                        <div class="col-sm-8">
                            <form:select path="checkListHinhThuc" cssStyle="width: 100%;">
                                <form:option value="-1">${allText}</form:option>
                                <form:options items="${hinhthucs}" itemLabel="tenhinhthuc" itemValue="mshinhthuc"/>
                            </form:select>
                        </div>
                    </div>
                </div>
                <div class="with-border">
                    <div class="col-sm-12 text-center">
                        <a class="btn btn-primary btn-sm" id="btnFilter"><i class="fa fa-search"></i> <fmt:message key="label.search"/></a>
                        <a class="btn btn-primary btn-sm" id="btnReset"><i class="fa fa-refresh"></i> <fmt:message key="label.reset" /></a>
                        <a class="btn btn-primary btn-sm" id="btnExport"><i class="fa fa-file-excel-o"></i> <fmt:message key="label.export"/></a>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <div class="col-xs-12">
        <div id="content" class="box box-solid box-primary">
            <div class="box-header with-border">
                <h3 class="box-title"><fmt:message key="label.report106.title"/></h3>
            </div>

            <div class="box-body">
                <div id="reportTableContainer" style="width: 100%;">
                    <display:table name="items.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                   partialList="true" sort="external" size="${items.totalItems}" defaultsort="0"
                                   id="tableList" pagesize="${Constants.MAXPAGEITEMS}" export="false" class="table table_vms table-bordered table-hover table-striped text_center" style="margin: 1em 0 1.5em; width: 3500px;">

                        <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center" style="width: 5%;">
                            ${tableList_rowNum + (page * Constants.MAXPAGEITEMS)}
                        </display:column>
                        <display:column headerClass="table_header nowrap" sortable="false" property="nguonvon.tennguonvon" titleKey="label.report105.nguonVon" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" property="department.code" titleKey="label.report105.department" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" property="user.userName" titleKey="label.report103.chuTri" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" property="thanhVien" titleKey="bid.goithau.tochuyengia.thanhvien" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" property="hinhthucgt.mahinhthuc" titleKey="label.hinhThuc" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" property="quimo.tenquimo" titleKey="bid.goithau.quimo" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" property="bid.magoithau" titleKey="label.nhathau.magoithau" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" property="bid.tengoithau" titleKey="label.nhathau.tengoithau" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" property="tienDo.qdPheDuyetSo" titleKey="label.report106.so" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" titleKey="label.report106.ngay" class="nowrap"  >
                            <fmt:formatDate value="${tableList.tienDo.qdPheDuyetNgay}" pattern="${datePattern}"/>
                        </display:column>
                        <display:column headerClass="table_header nowrap" sortable="false" property="tienDo.trinhhsSo" titleKey="label.report106.so" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" titleKey="label.report106.ngay" class="nowrap" >
                            <fmt:formatDate value="${tableList.tienDo.trinhhsNgay}" pattern="${datePattern}"/>
                        </display:column>
                        <display:column headerClass="table_header " sortable="false" titleKey="label.report106.tongngaylapHSMT" class="nowrap"  />
                        <display:column headerClass="table_header " sortable="false" titleKey="label.report106.songaydenhan" class="nowrap"  />
                        <display:column headerClass="table_header " sortable="false" titleKey="label.report106.songaydachuyendautu" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" property="tienDo.duyethsSo" titleKey="label.report106.so" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" titleKey="label.report106.ngay" class="nowrap" >
                            <fmt:formatDate value="${tableList.tienDo.duyethsNgay}" pattern="${datePattern}"/>
                        </display:column>
                        <display:column headerClass="table_header nowrap" sortable="false" property="tienDo.trinhdangbaoSo" titleKey="label.report106.so" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" titleKey="label.report106.ngay" class="nowrap" >
                            <fmt:formatDate value="${tableList.tienDo.trinhdangbaoNgay}" pattern="${datePattern}"/>
                        </display:column>

                        <display:column headerClass="table_header nowrap" sortable="false" titleKey="label.report106.ngaydangbao" class="nowrap"  />

                        <display:column headerClass="table_header nowrap" sortable="false" titleKey="label.report106.ngayphatbanhs" class="nowrap" >
                            <c:choose>
                                <c:when test="${not empty tableList.tienDo.ngaybanhsL3}">
                                    <fmt:formatDate value="${tableList.tienDo.ngaybanhsL3}" pattern="${datePattern}"/>
                                </c:when>
                                <c:when test="${not empty tableList.tienDo.ngaybanhsL2}">
                                    <fmt:formatDate value="${tableList.tienDo.ngaybanhsL2}" pattern="${datePattern}"/>
                                </c:when>
                                <c:when test="${not empty tableList.tienDo.ngaybanhsL1}">

                                </c:when>
                            </c:choose>
                        </display:column>
                        <display:column headerClass="table_header nowrap" sortable="false" titleKey="label.report106.ngaymothau" class="nowrap" >
                            <c:choose>
                                <c:when test="${not empty tableList.tienDo.ngaymothauL3}">
                                    <fmt:formatDate value="${tableList.tienDo.ngaymothauL3}" pattern="${datePattern}"/>
                                </c:when>
                                <c:when test="${not empty tableList.tienDo.ngaymothauL2}">
                                    <fmt:formatDate value="${tableList.tienDo.ngaymothauL2}" pattern="${datePattern}"/>
                                </c:when>
                                <c:when test="${not empty tableList.tienDo.ngaymothauL1}">
                                    <fmt:formatDate value="${tableList.tienDo.ngaymothauL1}" pattern="${datePattern}"/>
                                </c:when>
                            </c:choose>
                        </display:column>

                        <display:column headerClass="table_header nowrap" sortable="false" property="tienDo.trinhkqSo" titleKey="label.report106.so" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" titleKey="label.report106.ngay" class="nowrap" >
                            <fmt:formatDate value="${tableList.tienDo.trinhkqNgay}" pattern="${datePattern}"/>
                        </display:column>
                        <display:column headerClass="table_header" sortable="false" titleKey="label.report106.tongngaylapHSMT" class="nowrap"  />
                        <display:column headerClass="table_header" sortable="false" titleKey="label.report106.songaydenhan" class="nowrap"  />
                        <display:column headerClass="table_header" sortable="false" titleKey="label.report106.songaydachuyendautu" class="nowrap"  />

                        <display:column headerClass="table_header nowrap" sortable="false" property="tienDo.pheduyetkqSo" titleKey="label.report106.so" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" titleKey="label.report106.ngay" class="nowrap" >
                            <fmt:formatDate value="${tableList.tienDo.pheduyetkqNgay}" pattern="${datePattern}"/>
                        </display:column>
                        <display:column headerClass="table_header" sortable="false" titleKey="label.report106.ngaydangketquabaodauthau" class="nowrap">
                            <fmt:formatDate value="${tableList.tienDo.dbkqLuaChonNhaThauNgay}" pattern="${datePattern}"/>
                        </display:column>
                        <display:column headerClass="table_header nowrap" sortable="false" titleKey="label.report106.giaduocduyet" class="nowrap" >
                            <fmt:formatNumber value="${tableList.noiDungHoSo.giaDuThau}" />
                        </display:column>
                        <display:column headerClass="table_header nowrap" sortable="false" titleKey="label.report106.giatrungthau" class="nowrap" >
                            <fmt:formatNumber value="${tableList.noiDungHoSo.giaDuThau}" />
                        </display:column>
                        <display:column headerClass="table_header nowrap" sortable="false" titleKey="label.report106.tietkiem" class="nowrap">
                            ${(tableList.noiDungHoSo.giaDuThau/tableList.noiDungHoSo.giaDuThau) * 100}
                        </display:column>
                        <display:column headerClass="table_header nowrap" sortable="false" property="bid.landauthau" titleKey="label.report106.landauthau" class="nowrap"  />
                        <display:column headerClass="table_header" sortable="false" property="slNhaThauMuaHS" titleKey="label.report106.soluongnhathaumuahs" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" property="danhSachNhaThauMuaHS" titleKey="label.report106.danhsachnhathaumuaHS"/>
                        <display:column headerClass="table_header" sortable="false" property="slNhaThauNopHS" titleKey="label.report106.soluongnhathaunophs" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" property="danhSachNhaThauNopHS" titleKey="label.report106.danhsachnhathaunopHS"/>
                        <display:column headerClass="table_header nowrap" sortable="false" property="nhaThau.tennhathau" titleKey="label.report106.tennhathau" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" property="nhaThau.diachi" titleKey="label.nhathau.diachi" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" property="tinhtrang.tentinhtrang" titleKey="label.report106.ketquavatiendo" class="nowrap"  />
                        <display:column headerClass="table_header nowrap" sortable="false" property="ghiChu" titleKey="label.report106.ghiChu" class="nowrap"  />


                        <display:setProperty name="paging.banner.item_name"><fmt:message key="tiendo.label.goithau"/></display:setProperty>
                        <display:setProperty name="paging.banner.items_name"><fmt:message key="tiendo.label.goithau"/></display:setProperty>
                    </display:table>
                </div>
                <div id="linksContainer">

                </div>
            </div>
        </div>
    </div>
    </div>
    <form:hidden path="crudaction" id="crudaction"/>
    </section>
    </form:form>

    </div>
</div>
<script type="text/javascript" src="<c:url value="/themes/vmsreport/plugins/CustomScrollbar/jquery.mCustomScrollbar.concat.min.js"/>"></script>
<script type="text/javascript">
    $(document).ready(function(){
        setActiveMenu4Admin('#report_menu', '#report106_menu');

        $("#btnFilter").click(function () {
            $("#crudaction").val("search");
            $("#listForm").submit();
        });
        $("#btnExport").click(function () {
            $("#crudaction").val("export");
            $("#listForm").submit();
        });
        $("#btnReset").click(function () {
            setSelectedValueForSelectMenu($("#nguonVonId"));
            setSelectedValueForSelectMenu($("#loaiDauTuId"));
            setSelectedValueForSelectMenu($("#departmentId"));
            setSelectedValueForSelectMenu($("#chairId"));
            setSelectedValueForSelectMenu($("#userId"));
            setSelectedValueForSelectMenu($("#quiMoId"));
            $("#qdPheDuyetSoId").val("");
            $("#maGoiThauId").val("");
            $("#tenGoiThauId").val("");
            $("#fromYearId").val("");
            $("#toYearId").val("");
            $(".checkListHinhThuc").prop('checked', false);
            $(".checkListTinhTrang").prop('checked', false);
        });
        validateSelect2Select($('#checkListTinhTrang'));
        validateSelect2Select($('#checkListHinhThuc'));

        $('#reportTableContainer').mCustomScrollbar({axis:"x"});

        rebuildTableHeaders();
        checkMovePageLinks();
    });

    function rebuildTableHeaders(){
        $('#tableList thead tr').remove();

        $('#tableList thead').html("<tr>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.stt'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report105.nguonVon'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report105.department'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report103.chuTri'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='bid.goithau.tochuyengia.thanhvien'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.hinhThuc'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='bid.goithau.quimo'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.nhathau.magoithau'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.nhathau.tengoithau'/></th>" +
                    "<th colspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.qdPheDuyet'/></th>" +
                    "<th colspan='2' class='table_header_center nowrap'><fmt:message key='tiendo.label.trinhhs.mtyc'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.tongngaylapHSMT'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.songaydenhan'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.songaydachuyendautu'/></th>" +
                    "<th colspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.qdpdHSMT.HSYC'/></th>" +
                    "<th colspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.congVanDangBao'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.ngaydangbao'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.ngayphatbanhs'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.ngaymothau'/></th>" +
                    "<th colspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.trinhketqua'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.tongngaylapHSMT'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.songaydenhan'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.songaydachuyendautu'/></th>" +
                    "<th colspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.quyetdinhpheduyetketqua'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.ngaydangketquabaodauthau'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.giaduocduyet'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.giatrungthau'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.tietkiem'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.landauthau'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.soluongnhathaumuahs'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.danhsachnhathaumuaHS'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.soluongnhathaunophs'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.danhsachnhathaunopHS'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.tennhathau'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.nhathau.diachi'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.ketquavatiendo'/></th>" +
                    "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.report106.ghiChu'/></th>" +
                "</tr>" +
                "<tr>" +
                    "<th class='table_header_center nowrap'><fmt:message key="tiendo.label.so"/></th>" +
                    "<th class='table_header_center nowrap'><fmt:message key="label.ngay"/></th>" +
                    "<th class='table_header_center nowrap'><fmt:message key="tiendo.label.so"/></th>" +
                    "<th class='table_header_center nowrap'><fmt:message key="label.ngay"/></th>" +
                    "<th class='table_header_center nowrap'><fmt:message key="tiendo.label.so"/></th>" +
                    "<th class='table_header_center nowrap'><fmt:message key="label.ngay"/></th>" +
                    "<th class='table_header_center nowrap'><fmt:message key="tiendo.label.so"/></th>" +
                    "<th class='table_header_center nowrap'><fmt:message key="label.ngay"/></th>" +
                    "<th class='table_header_center nowrap'><fmt:message key="tiendo.label.so"/></th>" +
                    "<th class='table_header_center nowrap'><fmt:message key="label.ngay"/></th>" +
                    "<th class='table_header_center nowrap'><fmt:message key="tiendo.label.so"/></th>" +
                    "<th class='table_header_center nowrap'><fmt:message key="label.ngay"/></th>" +
                "</tr>");
    }

    function checkMovePageLinks(){
        if(${not empty items.listResult}){
            $('#reportTableContainer .pagebanner').appendTo('#linksContainer');
            $('#reportTableContainer .pagelinks').appendTo('#linksContainer');
        }
    }
</script>
</body>
</html>