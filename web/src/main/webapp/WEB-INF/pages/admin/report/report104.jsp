<%--
  Created by IntelliJ IDEA.
  User: vovanphuc0810
  Date: 12/24/15
  Time: 9:35 AM
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
    <style>
        .table-responsive {
            min-height: .01%;
            overflow-x: auto;
        }
    </style>
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin"/>
</security:authorize>

<c:url var="homeUrl" value="/index.html"/>
<c:url var="backUrl" value="${prefix}/index.html"/>
<c:url var="formlUrl" value="${prefix}/report/report104.html"/>

<fmt:message var="allText" key="label.all" />
<body>
<div class="content-wrapper">
    <div class="container">
        <form:form commandName="item" action="${formlUrl}" id="listForm" method="post" autocomplete="off" name="listForm" cssClass="form-horizontal">
        <section class="content-header">
            <h4>
                <fmt:message key="label.report104.title"/>
                    <%--<small><fmt:message key="user.manager.list"/></small>--%>
            </h4>
            <ol class="breadcrumb">
                <li><a href="${homeUrl}"><i class="fa fa-fw fa-home"></i>&nbsp;<fmt:message key="label.home.title"/></a></li>
                <li><fmt:message key="menu.report"/></li>
                <li class="active"><fmt:message key="label.report104.title"/></li>
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
                <div class="box-header">
                    <h3 class="box-title"><fmt:message key="label.search"/></h3>
                </div>
                <div class="box-body">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-sm-4 control-label"><fmt:message key="bid.pada.nguonvon"/></label>
                                <div class="col-sm-8">
                                    <form:select path="pojo.msNguonVon" cssClass="form-control select3 nohtml" data-trigger="focus">
                                        <form:option value=""><fmt:message key="label.select" /> </form:option>
                                        <form:options items="${listNguonVon}" itemLabel="tennguonvon" itemValue="msnguonvon"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-sm-4 control-label"><fmt:message key="bid.pada.loaidautu"/></label>
                                <div class="col-sm-8">
                                    <form:select path="pojo.msLoai" cssClass="form-control select3 nohtml" data-trigger="focus">
                                        <form:option value=""><fmt:message key="label.select" /> </form:option>
                                        <form:options items="${listLoai}" itemLabel="tenloai" itemValue="msloai"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-sm-4 control-label"><fmt:message key="bid.pada.department"/></label>
                                <div class="col-sm-8">
                                    <form:select path="pojo.msPhong" cssClass="form-control select3 nohtml" data-trigger="focus">
                                        <form:option value=""><fmt:message key="label.select" /> </form:option>
                                        <form:options items="${listDepartment}" itemLabel="name" itemValue="departmentId"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.tochuyengia.chutri"/></label>
                                <div class="col-sm-8">
                                    <form:select path="pojo.msChuTri" cssClass="form-control select3  nohtml" data-trigger="focus">
                                        <form:option value=""><fmt:message key="label.select" /> </form:option>
                                        <c:forEach items="${listChuTri}" var="xetThau">
                                            <option <c:if test="${xetThau.userId eq item.pojo.msChuTri}">selected="true" </c:if> value="${xetThau.userId}" >
                                                    ${xetThau.hoNhanVien} ${xetThau.tenNhanVien}
                                                <c:if test="${empty xetThau.hoNhanVien && empty xetThau.tenNhanVien}">
                                                    ${xetThau.userName}
                                                </c:if>
                                                <c:if test="${not empty xetThau.chuyenNganh}">
                                                    (${xetThau.chuyenNganh})
                                                </c:if>
                                            </option>
                                        </c:forEach>
                                        <%--<form:options items="${listChuTri}" itemLabel="displayName" itemValue="userId"/>--%>
                                    </form:select>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.tochuyengia.thanhvien"/></label>
                                <div class="col-sm-8">
                                    <form:select path="pojo.msThanhVien" cssClass="form-control select3  nohtml" data-trigger="focus">
                                        <form:option value=""><fmt:message key="label.select" /> </form:option>
                                        <c:forEach items="${listThanhVien}" var="nhanVien">
                                            <option <c:if test="${nhanVien.userId eq item.pojo.msThanhVien}">selected="true" </c:if> value="${nhanVien.userId}" >
                                                    ${nhanVien.hoNhanVien} ${nhanVien.tenNhanVien}
                                                <c:if test="${empty nhanVien.hoNhanVien && empty nhanVien.tenNhanVien}">
                                                    ${nhanVien.userName}
                                                </c:if>
                                                <c:if test="${not empty nhanVien.chuyenNganh}">
                                                    (${nhanVien.chuyenNganh})
                                                </c:if>
                                            </option>
                                        </c:forEach>
                                        <%--<form:options items="${listThanhVien}" itemLabel="displayName" itemValue="userId"/>--%>
                                    </form:select>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.quimo"/></label>
                                <div class="col-sm-8">
                                    <form:select path="pojo.msQuiMo" cssClass="form-control select3 nohtml" data-trigger="focus">
                                        <form:option value=""><fmt:message key="label.select" /> </form:option>
                                        <form:options items="${listQuiMo}" itemLabel="tenquimo" itemValue="msquimo"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.code"/></label>
                                <div class="col-sm-8">
                                    <form:input path="pojo.goiThau.magoithau" cssClass="form-control input-xs nohtml" data-trigger="focus" />
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.ten"/></label>
                                <div class="col-sm-8">
                                    <form:input path="pojo.goiThau.tengoithau" cssClass="form-control input-xs nohtml" data-trigger="focus" />
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
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
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-8">
                            <div class="form-group">
                                <label class="col-sm-2 control-label"><fmt:message key="bid.pada.tinhtrang"/></label>
                                <div class="col-sm-10">
                                    <form:select path="checkListTinhTrang" cssStyle="width: 100%;">
                                        <form:option value="-1">${allText}</form:option>
                                        <form:options items="${tinhtrangs}" itemLabel="tentinhtrang" itemValue="mstinhtrang"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-8">
                            <div class="form-group">
                                <label class="col-sm-2 control-label"><fmt:message key="bid.pada.hinhthuc"/></label>
                                <div class="col-sm-10">
                                    <form:select path="checkListHinhThuc" cssStyle="width: 100%;">
                                        <form:option value="-1">${allText}</form:option>
                                        <form:options items="${hinhthucs}" itemLabel="tenhinhthuc" itemValue="mshinhthuc"/>
                                    </form:select>
                                </div>
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
                    <h3 class="box-title"><fmt:message key="label.report104.title"/></h3>
                </div>

                <div class="box-body">
                    <div id="reportTableContainer" style="width: 100%;">
                        <display:table name="items.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                       partialList="true" sort="external" size="${items.totalItems}" defaultsort="0"
                                       id="tableList" pagesize="${Constants.MAXPAGEITEMS}" export="false" class="table table_vms table-bordered table-hover table-striped" style="margin: 1em 0 1.5em; width: 100%;">

                            <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center" style="width: 5%;">
                                ${tableList_rowNum + (page * Constants.MAXPAGEITEMS)}
                            </display:column>
                            <display:column headerClass="table_header nowrap" sortable="false" property="goiThau.tengoithau" titleKey="label.nhathau.tengoithau" class="nowrap" style="width: 12%;" />
                            <display:column headerClass="table_header nowrap" sortable="false" property="hinhthucgt.tenhinhthuc" titleKey="label.hinhThuc.tenHinhThuc" class="nowrap" style="width: 12%;" />
                            <display:column headerClass="table_header nowrap" sortable="false" titleKey="label.tienDo.ngayQDDAPA" class="nowrap" style="width: 12%;" >
                                <fmt:formatDate value="${tableList.tienDo.qdPheDuyetNgay}" pattern="${datePattern}"/>
                            </display:column>
                            <display:column headerClass="table_header nowrap" sortable="false" titleKey="label.tienDo.ngayTrinhHs" class="nowrap" style="width: 12%;">
                                <fmt:formatDate value="${tableList.tienDo.trinhhsNgay}" pattern="${datePattern}"/>
                            </display:column>
                            <display:column headerClass="table_header nowrap" sortable="false" property="tienDo.trinhhsSo" titleKey="label.tienDo.ngayTrinhHs" class="nowrap" style="width: 12%;"/>
                            <display:column headerClass="table_header nowrap" sortable="false" property="thoiGianThucHien" titleKey="label.hinhThuc.thoiGianLap" class="text-center nowrap" style="width: 12%;" />
                            <display:column headerClass="table_header nowrap" sortable="false" property="user.userName" titleKey="label.hinhThuc.nvChuTri" class="nowrap" style="width: 12%;" />

                            <display:setProperty name="paging.banner.item_name"><fmt:message key="label.nhathau.goithau"/></display:setProperty>
                            <display:setProperty name="paging.banner.items_name"><fmt:message key="label.nhathau.goithau"/></display:setProperty>
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
        setActiveMenu4Admin('#report_menu', '#report104_menu');

        $("#btnFilter").click(function () {
            $("#crudaction").val("search");
            $("#listForm").submit();
        });
        $("#btnExport").click(function () {
            $("#crudaction").val("export");
            $("#listForm").submit();
        });
        $("#btnReset").click(function () {
            $("#tenGoiThauId").val("");
            $('#datepicker').find('input').each(function(){
                $(this).datepicker('setDate', null);
            });
        });
        validateSelect2Select($('#checkListTinhTrang'));
        validateSelect2Select($('#checkListHinhThuc'));

        rebuildTableHeaders();
        checkMovePageLinks();
        $('#reportTableContainer').mCustomScrollbar({axis:"x"});
    });

    function rebuildTableHeaders(){
        $('#tableList thead tr').remove();
        $('#tableList thead').html("<tr>" +
                "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.stt'/></th>" +
                "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.nhathau.tengoithau'/></th>" +
                "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.hinhThuc.tenHinhThuc'/></th>" +
                "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.tienDo.ngayQDDAPA'/></th>" +
                "<th colspan='2' class='table_header_center nowrap'><fmt:message key='label.tienDo.ngayTrinhHs'/></th>" +
                "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.hinhThuc.thoiGianLap'/></th>" +
                "<th rowspan='2' class='table_header_center nowrap'><fmt:message key='label.hinhThuc.nvChuTri'/></th>" +
                "</tr>" +
                "<tr>" +
                "<th class='table_header_center nowrap'><fmt:message key="label.ngay"/></th>" +
                "<th class='table_header_center nowrap'><fmt:message key="tiendo.label.so"/></th>" +
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