<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="repository" uri="http://banvien.com/tags/repository" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="contractor.title.management"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/plugins/kartik-v-bootstrap-fileinput-cde7292/css/fileinput.min.css"/>">
    <style>
        .modal-dialog {
            width: 90%;
        }
        .select2-container{
            width: 100% !important;
        }
    </style>
</head>

<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin"></c:set>
</security:authorize>
<c:url var="backUrl" value="${prefix}/goithau/list.html"/>
<c:url var="formlUrl" value="${prefix}/goithau/edit.html"/>
<c:url var="BidUrl" value="${prefix}/goithau/list.html"/>
<c:url var="dashboardUrl" value="/home.html"/>

<c:set var="keyLabel" value="contractor.pada"/>
<c:if test="${not empty item.pojo.msgoithau}">
    <c:set var="keyLabel" value="contractor.pada.edit"/>
</c:if>
<body>
<div class="content-wrapper">
    <div class="container">
        <form:form commandName="item" id="formItem" action="${formlUrl}" method="post" cssClass="form-horizontal" validate="validate" enctype="multipart/form-data">
        <section class="content-header">
            <h4>
                <fmt:message key="${keyLabel}"/>
                <%--<small><fmt:message key="user.manager.list"/></small>--%>
            </h4>
            <ol class="breadcrumb">
                <li><a href="${dashboardUrl}"><i class="fa fa-fw fa-home"></i><fmt:message key="label.home.title"/></a></li>
                <li><a href="${BidUrl}"><fmt:message key="contractor.title.management"/></a></li>
                <li class="active"><fmt:message key="${keyLabel}"/></li>
            </ol>
        </section>
        <section class="content">
        <c:if test="${not empty messageResponse}">
            <div class="clear"></div>
            <div class="alert alert-message  alert-${alertType}">
                <a class="close" data-dismiss="alert" href="#">&times;</a> ${messageResponse}
            </div>
        </c:if>

        <div class="row">
        <div class="col-md-12">
        <div class="box box-solid box-primary">
            <div class="box-header with-border">
                <h3 class="box-title"><fmt:message key="bid.pada.imfomation"/></h3>
            </div>

            <div class="box-body">
                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="bid.pada.nguonvon"/><span style="color:red;">(*)</span></label>
                    <c:forEach items="${nguonvons}" var="item">
                        <div class="col-sm-2">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="pojo.nguonvon.msnguonvon" value="${item.msnguonvon}"  cssClass="required nohtml"  data-trigger="focus"/> ${item.tennguonvon}
                                </label>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="bid.pada.ten"/><span style="color:red;">(*)</span></label>
                    <div class="col-sm-10">
                        <form:input path="pojo.tenpada" cssClass="form-control input-xs required nohtml" data-trigger="focus" />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="bid.pada.department"/></label>
                    <div class="col-sm-3">
                        <form:select path="pojo.department.departmentId" cssClass="form-control select2 select2-hidden-accessible nohtml" data-trigger="focus" >
                            <form:option value=""><fmt:message key="label.select" /> </form:option>
                            <form:options items="${departments}" itemLabel="name" itemValue="departmentId"/>
                        </form:select>
                    </div>

                    <label class="col-sm-2 control-label"><fmt:message key="bid.pada.loaidautu"/></label>
                    <div class="col-sm-5">
                        <form:select path="pojo.loai.msloai" cssClass="form-control input-xs select3 nohtml" data-trigger="focus" >
                            <form:option value=""><fmt:message key="label.select" /> </form:option>
                            <form:options items="${loais}" itemLabel="tenloai" itemValue="msloai"/>
                        </form:select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="bid.pada.socv.pa"/></label>
                    <div class="col-sm-3">
                        <form:input path="pojo.socvTrinhpd" cssClass="form-control nohtml input-xs" data-trigger="focus" />
                    </div>
                    <label class="col-sm-2 control-label"><fmt:message key="bid.pada.ngaycv"/></label>
                    <div class="col-sm-2">
                        <div class="input-group input-group-xs">
                            <fmt:formatDate value="${item.pojo.ngaycvTrinhpd}" pattern="dd/MM/yyyy" var="ngayCV" />
                            <input id="ngayCV" name="pojo.ngaycvTrinhpd" value="${ngayCV}" class="form-control input-xs datePlaceHolder datepicker nohtml" data-trigger="focus" />
                            <div class="input-group-addon input-xs">
                                <i class="fa fa-calendar"></i>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="input-group input-group-xs" style="width: 100%">
                            <input id="fileCongVanPheDuyetPA" name="fileCongVanPheDuyetPA" type="file" class="file-input input-xs" />
                        </div>
                    </div>

                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="bid.pada.lanhdao"/><span style="color:red;">(*)</span></label>
                    <div class="col-sm-3">
                        <form:select path="pojo.lanhdao.mslanhdao" cssClass="form-control select3 required nohtml" data-trigger="focus" >
                            <form:option value=""><fmt:message key="label.select" /> </form:option>
                            <form:options items="${lanhdaos}" itemLabel="tenlanhdao" itemValue="mslanhdao"/>
                        </form:select>
                    </div>

                    <label class="col-sm-2 control-label"><fmt:message key="bid.pada.soquyetdinh"/><span style="color:red;">(*)</span></label>
                    <div class="col-sm-2">
                        <form:input path="pojo.soqd" cssClass="form-control input-xs required nohtml" data-trigger="focus" />
                    </div>
                    <label class="col-sm-1 control-label"><fmt:message key="bid.pada.ngayquyetdinh"/><span style="color:red;">(*)</span></label>
                    <div class="col-sm-2">
                        <fmt:formatDate value="${item.pojo.ngayqd}" pattern="dd/MM/yyyy" var="ngayQD" />
                        <input id="ngayQD" name="pojo.ngayqd" value="${ngayQD}" class="form-control input-xs datepicker datePlaceHolder required nohtml" data-trigger="focus"  />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="bid.pada.hinhthuc"/><span style="color:red;">(*)</span></label>
                    <div class="col-sm-3">
                        <form:select path="pojo.hinhthucgt.mshinhthuc" cssClass="form-control select3 input-xs required nohtml" data-trigger="focus" id="hinhthucgoithau" onchange="warningGiaTriGoiThau();" >
                            <form:option value=""><fmt:message key="label.select" /> </form:option>
                            <c:forEach var="hinhthuc" items="${hinhthucs}">
                                <%--<fmt:formatNumber var="fromValueLabel" value="${hinhthuc.fromValue}" pattern="###,###" />--%>
                                <%--<fmt:formatNumber var="toValueLabel" value="${hinhthuc.toValue}" pattern="###,###" />--%>
                                <option value="${hinhthuc.mshinhthuc}" <c:if test="${item.pojo.hinhthucgt.mshinhthuc eq hinhthuc.mshinhthuc}">selected</c:if>>${hinhthuc.tenhinhthuc}</option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <label class="col-sm-2 control-label"><fmt:message key="bid.pada.tinhchat"/><span style="color:red;">(*)</span></label>
                    <div class="col-sm-5">
                        <form:select path="pojo.tinhchat.mstinhchat" cssClass="form-control input-xs select3 required nohtml" data-trigger="focus" >
                            <form:option value=""><fmt:message key="label.select" /> </form:option>
                            <form:options items="${tinhchats}" itemLabel="tentinhchat" itemValue="mstinhchat"/>
                        </form:select>
                    </div>
                </div>
            </div>
                <%--<div class="form-group">--%>
                <%--<label class="col-sm-2 control-label"><fmt:message key="bid.uploadFileCV"/></label>--%>
                <%--<div class="col-sm-3">--%>
                <%--<div id="avatar_form" class="nowrap">--%>
                <%--<input id="cvFileUpload" type="file" name="pojo.cvFileItem" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document"/>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
        </div>

        <div class="box box-solid box-primary">
            <div class="box-header with-border">
                <h3 class="box-title"><fmt:message key="bid.goithau.imfomation"/></h3>
            </div>

            <div class="box-body">
                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="bid.goithau.code"/></label>
                    <div class="col-sm-10">
                        <c:if test="${maxId ne null}">
                            <fmt:formatNumber value="${maxId}" var="max" pattern="##" maxFractionDigits="2" />
                            <input  class="form-control input-xs nohtml" readonly="readonly" data-trigger="focus" value="${max}" />
                            <input type="hidden" name="pojo.magoithau" value="${max}"/>
                        </c:if>
                        <c:if test="${maxId eq null}">
                            <input  class="form-control nohtml" readonly="readonly" data-trigger="focus" value="${item.pojo.magoithau}" />
                            <input type="hidden" name="pojo.magoithau" value="${item.pojo.magoithau}"/>
                        </c:if>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="bid.goithau.ten"/><span style="color:red;">(*)</span></label>
                    <div class="col-sm-10">
                        <form:input path="pojo.tengoithau" cssClass="form-control input-xs required nohtml" data-trigger="focus" />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="bid.goithau.noidung"/></label>
                    <div class="col-sm-10">
                        <form:textarea path="pojo.noidung" cssClass="form-control nohtml" data-trigger="focus" />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="bid.goithau.landauthau"/></label>
                    <div class="col-sm-2">
                        <form:input path="pojo.landauthau" cssClass="form-control input-xs nohtml input_number" data-trigger="focus" id="landauthau" />
                    </div>

                    <label class="col-sm-2 control-label"><fmt:message key="bid.pada.cuagoithau"/></label>
                    <c:choose>
                        <c:when test="${empty item.pojo.landauthau || item.pojo.landauthau <= 1}">
                            <div class="col-sm-6" style="display: none;" id="cuagoithaucontainer">
                                <div class="input-group input-group-xs">
                                    <%--<form:input id="eBid" path="pojo.msgoithauref.magoithau" cssClass="form-control input-xs nohtml" data-trigger="focus" disabled="true"/>--%>
                                    <select id="eBid" name="pojo.msgoithauref.magoithau" class="autocomplete" style="height: 22px; width: 100%" disabled="true" ></select>
                                                        <span class="input-group-btn" >
                                                             <a class="btn btn-info" title="<fmt:message key="label.search"/>" id="eRef">
                                                                 <i class="fa fa-search"></i>
                                                             </a>
                                                        </span>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="col-sm-6" style="display: none;" id="cuagoithaucontainer">
                                <form:input id="eBid" path="pojo.msgoithauref.magoithau" cssClass="form-control input-xs nohtml" data-trigger="focus" disabled="true"/>
                            </div>
                        </c:otherwise>

                    </c:choose>

                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="bid.goithau.giatrigoithautruocthue"/></label>
                    <div class="col-sm-2">
                        <fmt:formatNumber var="giatrigoithautruocthue" value="${item.pojo.giatrigoithautruocthue}" pattern="###,###" />
                        <input name="pojo.giatrigoithautruocthue" value="${giatrigoithautruocthue}" id="giaTriGoiThauTruocThue" class="form-control input-xs nohtml onlyNumberInput inputNumber" data-trigger="focus" />
                    </div>

                    <label class="col-sm-2 control-label"><fmt:message key="bid.goithau.giatrigoithau"/></label>
                    <div class="col-sm-2">
                        <fmt:formatNumber var="giatrigoithau" value="${item.pojo.giatrigoithau}" pattern="###,###" />
                        <input name="pojo.giatrigoithau" value="${giatrigoithau}" id="giaTriGoiThau" class="form-control input-xs nohtml onlyNumberInput inputNumber" data-trigger="focus" />
                    </div>

                    <label class="col-sm-2 control-label"><fmt:message key="bid.goithau.quimo"/></label>
                    <div class="col-sm-2">
                        <form:select path="pojo.quimo.msquimo" cssClass="form-control input-xs select3 nohtml autocomplete" data-trigger="focus" id="quyMo" >
                            <form:option value=""><fmt:message key="label.select" /> </form:option>
                            <c:forEach var="quymo" items="${quimos}">
                                <fmt:formatNumber var="fromValueLabel" value="${quymo.fromValue}" pattern="###,###" />
                                <fmt:formatNumber var="toValueLabel" value="${quymo.toValue}" pattern="###,###" />
                                <option value="${quymo.msquimo}" fromValue="${quymo.fromValue}" fromValueLabel="${fromValueLabel}"
                                        toValue="${quymo.toValue}"  toValueLabel="${toValueLabel}" <c:if test="${item.pojo.quimo.msquimo eq quymo.msquimo}">selected</c:if>>${quymo.tenquimo}</option>
                            </c:forEach>
                        </form:select>
                        <form:hidden path="pojo.quimo.msquimo" id="msQuyMo"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="bid.goithau.giabanhsmt"/></label>
                    <div class="col-sm-2">
                        <fmt:formatNumber var="giabanhsmt" value="${item.pojo.giabanhsmt}" pattern="###,###" />
                        <input name="pojo.giabanhsmt" value="${giabanhsmt}" id="hoSoMoThau" class="form-control input-xs nohtml onlyNumberInput inputNumber" data-trigger="focus" />
                    </div>
                    <label class="col-sm-2 control-label"><fmt:message key="bid.goithau.baodamduthau"/></label>
                    <div class="col-sm-2">
                        <fmt:formatNumber var="baodamduthau" value="${item.pojo.baodamduthau}" pattern="###,###" />
                        <input name="pojo.baodamduthau" value="${baodamduthau}" id="baoDamDuThau" class="form-control input-xs nohtml onlyNumberInput inputNumber" data-trigger="focus" />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="bid.goithau.thoigianhopdong"/></label>
                    <div class="col-sm-4">
                        <div class="input-group input-group-xs" id="datepicker">
                            <form:input path="pojo.sonamhd" id="sonamhd" cssClass="form-control input-xs text-center nohtml onlyNumberInput" data-trigger="focus" />
                            <span class="input-group-addon input-xs"> <fmt:message key="bid.pada.nam" /> </span>
                            <form:input path="pojo.sothanghd" id="sothanghd" cssClass="form-control input-xs text-center nohtml onlyNumberInput" data-trigger="focus" />
                            <span class="input-group-addon input-xs"> <fmt:message key="bid.pada.thang" /> </span>
                            <form:input path="pojo.songayhd" id="songayhd" cssClass="form-control input-xs text-center nohtml onlyNumberInput" data-trigger="focus" />
                            <span class="input-group-addon input-xs"> <fmt:message key="bid.pada.ngay" /></span>

                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="bid.goithau.tochuyengia"/></label>
                    <div class="col-sm-10">
                        <table style="width: 100%;" class="tableAdd table table-bordered table-hover dataTable">
                            <thead>
                            <th style="width: 5%; text-align: center;"><fmt:message key="bid.goithau.tochuyengia.stt"/></th>
                            <th style="width: 75%; text-align: center;"><fmt:message key="bid.goithau.tochuyengia.nhanvienchuyennganh"/></th>
                            <th style="width: 10%; text-align: center;"><fmt:message key="bid.goithau.tochuyengia.chutri"/></th>
                            <th style="width: 10%; text-align: center;"><input type="checkbox" value="1" id="checkAll"/> </th>
                            </thead>
                            <tbody id="rownv">
                            <c:forEach items="${nhanviens}" var="item1" varStatus="iDex">
                                <tr>
                                    <td style="padding-left: 3px;">${iDex.index + 1}</td>
                                    <td style="text-align: left;">
                                        <select name="mapnvs[${iDex.index}]" class="form-control select3" data-trigger="focus" >
                                            <c:forEach items="${userXetThau}" var="item">
                                                <option <c:if test="${item.userId eq item1.user.userId}">selected="true" </c:if> value="${item.userId}">
                                                        ${item.hoNhanVien} ${item.tenNhanVien} (${item.chuyenNganh})
                                                            <c:if test="${empty item.hoNhanVien && empty item.tenNhanVien}">
                                                                ${item.userName}
                                                            </c:if>
                                                            <c:if test="${not empty item.chuyenNganh}">
                                                                (${item.chuyenNganh})
                                                            </c:if>
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td style="text-align: center;">
                                        <input <c:if test="${item1.ischutri == 1}">checked="true"</c:if> type="radio" name="idChuTri" value="${iDex.index}" />
                                    </td>
                                    <td style="text-align: center;">
                                        <input type="checkbox" class="rcheckBox" />
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="class_button">
                            <a class="btn btn-primary btn-xs" onclick="row();"><fmt:message key="bid.goithau.tochuyengia.themnhanvien"/></a>
                            <a class="btn btn-primary btn-xs" onclick="drow();"><fmt:message key="bid.goithau.tochuyengia.xoanhanvien"/></a>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="bid.goithau.chuyengiathamdinh"/><span style="color:red;">(*)</span></label>
                    <div class="col-sm-3">
                        <form:select path="pojo.msnhanvienCvtd.userId" cssClass="form-control select3 required nohtml" data-trigger="focus" >
                            <form:option value=""><fmt:message key="label.select" /> </form:option>
                            <c:forEach items="${userThamDinh}" var="thamDinh">
                                <option <c:if test="${thamDinh.userId eq item.pojo.msnhanvienCvtd.userId}">selected="true" </c:if> value="${thamDinh.userId}" >
                                    ${thamDinh.hoNhanVien} ${thamDinh.tenNhanVien}
                                    <c:if test="${empty thamDinh.hoNhanVien && empty thamDinh.tenNhanVien}">
                                        ${thamDinh.userName}
                                    </c:if>
                                    <c:if test="${not empty thamDinh.chuyenNganh}">
                                        (${thamDinh.chuyenNganh})
                                    </c:if>
                                </option>
                            </c:forEach>
                            <%--<form:options items="${userThamDinh}" itemLabel="displayName" itemValue="userId" />--%>
                        </form:select>
                    </div>
                </div>
            </div>


        </div>
        </div>
        <div class="col-md-12">
            <div class="box box-solid box-primary collapsed-box">
                <div class="box-header with-border">
                    <!-- tools box -->
                    <div class="pull-right box-tools">
                        <button id="collapseFormStore" class="btn btn-primary btn-xs pull-right" data-widget="collapse" data-toggle="tooltip" title="<fmt:message key="label.nhathau.hoso"/>" style="margin-right: 5px;"><i class="fa fa-plus"></i></button>
                    </div><!-- /. tools -->
                    <h3 class="box-title"><fmt:message key="bid.goithau.formStore"/></h3>
                </div>
                <div class="box-body">
                    <display:table name="listForm" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                   partialList="true" sort="external" size="${fn:length(listForm)}" defaultsort="0"
                                   id="tableList" pagesize="${fn:length(listForm)}" export="false" class="table table_vms table-bordered table-hover dataTable" style="margin: 1em 0 1.5em; width: 100%;">

                        <display:column headerClass="table_header_center " sortable="false" titleKey="label.stt" class="text-center" style="width: 5% !important;">
                            ${tableList_rowNum + (page * Constants.MAXPAGEITEMS)}
                        </display:column>
                        <display:column headerClass="table_header " sortable="true" property="tenBieuMau" sortName="tenBieuMau" escapeXml="true" titleKey="label.form.name" style="width: 40% !important;"/>
                        <display:column headerClass="table_header " sortable="true" property="bieuMau" sortName="bieuMau" escapeXml="true" titleKey="label.form" style="width: 30% !important;"/>
                        <display:column headerClass="table_header " sortable="false" titleKey="label.action" style="width: 25% !important;">
                            <input id="${tableList.bieuMau}" name="${tableList.bieuMau}" type="file" class="file-input" >
                        </display:column>
                        <display:setProperty name="paging.banner.item_name"><fmt:message key="label.form"/></display:setProperty>
                        <display:setProperty name="paging.banner.items_name"><fmt:message key="label.form"/></display:setProperty>
                    </display:table>
                </div>
            </div>
            <div class="box box-footer text-center">
                <a id="btnSave" class="btn btn-sm btn-primary"><i class="fa fa-fw fa-save"></i> <fmt:message key="button.save"/></a>
                <a class="btn btn-sm cancel-link" href="${backUrl}"><fmt:message key="button.cancel"/></a>
                <input type="hidden" value="1" id="stt" />
            </div>
        </div>
        </div>
        </section>

        <form:hidden path="pojo.msgoithauref.msgoithau" id="eBidId" />
        <form:hidden path="pojo.msgoithauref.tengoithau" id="eBidName"/>
        <form:hidden path="crudaction" id="crudaction"/>
        <form:hidden path="pojo.creater"/>
        <form:hidden path="pojo.createtime"/>
        <form:hidden path="pojo.msgoithau"/>
        <form:hidden path="pojo.tinhtrang.mstinhtrang"/>
        </form:form>

    </div>

</div>
<div class="modal fade bvModel" role="dialog" id="addModel"></div>
<script src="<c:url value="/themes/vmsreport/plugins/kartik-v-bootstrap-fileinput-cde7292/js/fileinput.min.js"/> "></script>
<script>
    $(document).ready(function(){
        $(".select3").select2();
        // active tab
        setActiveMenu4Admin('#contractor_menu', '#pada_menu');
        <%--<security:authorize ifAnyGranted = "NVPBK">--%>
            <%--$("input[type!='hidden']").attr('disabled','disabled');--%>
            <%--$("select").attr('disabled','disabled');--%>
            <%--$("textarea").attr('disabled','disabled');--%>
        <%--</security:authorize>--%>
        $('#collapseFormStore')
        $("#btnSave").click(function(){
            if($('#formItem').valid()){
                $('#crudaction').val('insert-update');
                transform();

                if(validateThoiGianHopDong()){
                    $("#formItem").submit();
                } else {
                    bootbox.confirm('<fmt:message key="warning.label"/>', "<fmt:message key="tghd.warning.message.tip"/>" + "<br /> <fmt:message key="hinhthuc.warning.message.tip"/>", function(r) {
                        if(!r){
                            $("#formItem").submit();
                        }
                    });
                }
            }
        });

        $("#checkAll").on('change', function(){
            if(this.checked){
                $(".rcheckBox").prop('checked', true);
            }else{
                $(".rcheckBox").prop('checked', false);
            }
        });

        initSelect2();

        $('#giaTriGoiThau').blur(function(){
            warningGiaTriGoiThau();
        });

//        $("#quyMo").prop("disabled", true);

        $('#landauthau').blur(function(){
            var lanDauThau = $('#landauthau').val();
            if(lanDauThau > 1){
                $('#cuagoithaucontainer').show();
                listenForGetGoiThau();
            } else {
                $('#cuagoithaucontainer').hide();
                $("#eBidId").val("");
                $("#eBidName").val("");
                $("#eBid").val("");

            }
        });

        initInputFile("fileCongVanPheDuyetPA", '${fileCongVanPheDuyetPA}', '${fn:split(fileCongVanPheDuyetPA, "/")[fn:length(fn:split(fileCongVanPheDuyetPA, "/"))-1]}');
        <c:forEach items="${listForm}" var="form">
            initInputFile('${form.bieuMau}', '${mapUrl[form.bieuMau]}', '${fn:split(mapUrl[form.bieuMau], "/")[fn:length(fn:split(mapUrl[form.bieuMau], "/"))-1]}');
        </c:forEach>


        listenForGetGoiThau();

        initThoiGianHopDongValue();

        warningThoiGianHopDongListener();
    });

    function initThoiGianHopDongValue(){
        if($('#sonamhd').val() == null || $('#sonamhd').val().trim() == ""){
            $('#sonamhd').val(0);
        }
        if($('#sothanghd').val() == null || $('#sothanghd').val().trim() == ""){
            $('#sothanghd').val(0);
        }
        if($('#songayhd').val() == null || $('#songayhd').val().trim() == ""){
            $('#songayhd').val(0);
        }
    }

    function autoSelectQuyMo(){
        var giaTriGoiThau = eval($.trim($('#giaTriGoiThau').val()).replace(/,+/g, ''));
        var newValue = "";
        $('#quyMo').find('option').each(function(){
            var fromValue = $(this).attr("fromValue");
            var toValue = $(this).attr("toValue");

            if(fromValue < giaTriGoiThau && giaTriGoiThau <= toValue){
                newValue = $(this).attr("value");
            }
        });
        $('#quyMo').select2("val", newValue);
        $('#msQuyMo').val(newValue);
    }

    function warningGiaTriGoiThau(){
        <%--var giaTriGoiThau = eval($.trim($('#giaTriGoiThau').val()).replace(/,+/g, ''));--%>
        <%--var hinhthucgoithau = $('#hinhthucgoithau').val();--%>
        autoSelectQuyMo();
        <%--if(giaTriGoiThau >= 0 && hinhthucgoithau != null && hinhthucgoithau != undefined && hinhthucgoithau > 0){--%>
            <%--var option = $('#hinhthucgoithau').find(":selected");--%>
            <%--var fromValue = $(option).attr("fromValue");--%>
            <%--var toValue = $(option).attr("toValue");--%>
            <%--var fromValueLabel = $(option).attr("fromValueLabel");--%>
            <%--var toValueLabel = $(option).attr("toValueLabel");--%>

            <%--var errorMessage = "";--%>
            <%--if(giaTriGoiThau < fromValue || giaTriGoiThau > toValue){--%>
                <%--errorMessage = "<fmt:message key="hinhthuc.warning.message"/> " + fromValueLabel + " <fmt:message key="hinhthuc.warning.message.to"/> " + toValueLabel + ".";--%>
            <%--}--%>

            <%--if($.trim(errorMessage) != ''){--%>
                <%--bootbox.confirm('<fmt:message key="warning.label"/>', errorMessage + "<br /> <fmt:message key="hinhthuc.warning.message.tip"/>", function(r) {--%>
                    <%--if(r){--%>
                        <%--$('#giaTriGoiThau').val("");--%>
                        <%--$('#quyMo').select2("val", "");--%>
                        <%--$('#msQuyMo').val("");--%>
                    <%--}--%>
                <%--});--%>
            <%--}--%>
        <%--}--%>
    }

    function listenForGetGoiThau(){
        $("#eRef").click(function(){
            var $modal = $('#addModel');
            $modal.load('<c:url value="/ajax/admin/goithau/list.html"/>', {'_': new Date().getTime()}, function(){
                $modal.modal();
                registerSubmitPopup();
            });
        });
    }

    function transform() {
        var giaTriGoiThauTruocThue = eval($.trim($('#giaTriGoiThauTruocThue').val()).replace(/,+/g, ''));
        $('#giaTriGoiThauTruocThue').val(giaTriGoiThauTruocThue);
        var costGoiThau = eval($.trim($('#giaTriGoiThau').val()).replace(/,+/g, ''));
        $('#giaTriGoiThau').val(costGoiThau);
        var hoSoMoThau = eval($.trim($('#hoSoMoThau').val()).replace(/,+/g, ''));
        $('#hoSoMoThau').val(hoSoMoThau);
        var baoDamDuThau = eval($.trim($('#baoDamDuThau').val()).replace(/,+/g, ''));
        $('#baoDamDuThau').val(baoDamDuThau);
    }

    function innitEventESpotSelection(element, callback){
        var id = $("#eBidId").val();
        var text = $("#eBidName").val()!=""?$("#eBidName").val():null;
        var select = [
            {
                id:id,
                text:text
            }];

        callback(select);
    }

    function changeAvatar(){
        $('#avatar_text').remove();
        $('#linkChangeAvatar').remove();
        $('.tooltip').remove();
        $("<input id='avatarFileUpload' type='file' name='pojo.avatarFileItem'  accept='image/x-png, image/gif, image/jpeg' />").appendTo('#avatar_form');
    }

    function row(){
        var dataUrl = '<c:url value="/api/goithau/addtochuyengia.html" />';
        var stt = $("#stt").val();
        $.ajax({
            url: dataUrl,
            cache: false,
            async: false,
            type: 'GET',
            dataType: 'html',
            data: {stt: stt},
            success: function (res) {
                $("#rownv").append(res);
                $("#stt").val(parseInt(stt) + 1);
                $(".select3").select2();
                $('#checkAll').attr("checked", false);
            }.bind(this),
            error: function (xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    }

    function drow(){
        $(".rcheckBox:checked").each(function( index ) {
            $(this).closest("tr").remove();
            $('#checkAll').attr("checked", false);
        });
    }

    function registerSubmitPopup(){
        var page = 1;
        $("#btnFilter").click(function(){
            $('#listFormAjax #crudaction').val('search')
            $("#listFormAjax").submit();
        });

        $(".pagelinks a").click(function(){
            page = parseInt(this.href.split('?')[1].split('p=')[1].charAt(0));
            $("#listFormAjax").submit();
            return false;
        });
        $('#mapTinhTrangs').select2();
        $('#mapHinhThucs').select2();
        $('.select3').select2();
        validateSelect2Select($('#mapTinhTrangs'));
        validateSelect2Select($('#mapHinhThucs'));

        $("#listFormAjax").submit(function(e){
            e.preventDefault();
            var formData = new FormData($(this)[0]);
            formData.append('page', page);
            $.ajax({
                cache: false,
                type: "POST",
                dataType: 'html',
                mimeType:"multipart/form-data",
                contentType: false,
                processData:false,
                data: formData,
                url:  "<c:url value="/ajax/admin/goithau/list.html"/>",
                success: function(res){
                    if(res.trim() == "success"){
                        document.location = "<c:url value="/ajax/admin/goithau/list.html"/>";
                    }else{
                        $("#addModel").html(res);
                        registerSubmitPopup();
                        $('.pagelinks a').each(function(e){
                            var index = parseInt(this.href.split('?')[1].split('p=')[1].charAt(0));
                            if(index == page){
                                $(this).css("cssText", "font-size : 25px");
                            }
                        });
                    }
                }
            });

            return false;
        });
    }
    function chooseBid(msGoiThau, magoithau, tengoithau){
        $("#eBidId").val(msGoiThau);
        $("#eBidName").val(tengoithau);
        $("#eBid").append('<option value="'+magoithau+'">'+tengoithau+' ('+magoithau+')</option>')
                .val(magoithau)
                .attr("title", tengoithau+' ('+magoithau+')');
        jQuery("#addModel").modal('hide');
    }

    function warningThoiGianHopDongListener(){
        $('#sonamhd').blur(function(){
            warningThoiGianHopDong();
        });
        $('#sothanghd').blur(function(){
            warningThoiGianHopDong();
        });
        $('#songayhd').blur(function(){
            warningThoiGianHopDong();
        });
    }

    function validateThoiGianHopDong(){
        var isValid = true;
        var sonamhd =  eval($.trim($('#sonamhd').val()).replace(/,+/g, ''));
        var sothanghd =  eval($.trim($('#sothanghd').val()).replace(/,+/g, ''));
        var songayhd =  eval($.trim($('#songayhd').val()).replace(/,+/g, ''));

        if((sonamhd == 0 || sonamhd == '')  && (sothanghd == 0  || sothanghd == '') && (songayhd == 0 || songayhd == '')){
            isValid = false;
        }
        return isValid;
    }

    function warningThoiGianHopDong(){
        if(!validateThoiGianHopDong()){
            bootbox.confirm('<fmt:message key="warning.label"/>', "<fmt:message key="tghd.warning.message.tip"/>" + "<br /> <fmt:message key="hinhthuc.warning.message.tip"/>", function(r) {
                if(r){

                }
            });
        }
    }

    function initInputFile(id, path, name){
        $('#'+id).fileinput({
            showUpload: false,
            showRemove: false,
            showPreview: false,
            browseLabel: "",
            mainClass: "input-group-xs",
            title: "Upload file",
            layoutTemplates: {
                main1: "{preview}\n" +
                        "<div class=\'input-group {class}\'>\n" +
                        "   <div class=\'input-group-btn\'>\n" +
                        "       {browse}\n" +
                        "       {upload}\n" +
                        "       {remove}\n" +
                        "   </div>\n" +
                        "   {caption}\n" +
                        "</div>",
                caption:
                        '<div tabindex="-1" class="form-control file-caption {class}" style="border: 0px solid #ccc;" title="">\n' +
                                '   <div class="file-caption-name">\n' +
                                '       <a href="/repository'+path+'">\n' +
                                '           '+name+'\n' +
                                '       </a>\n' +
                                '   </div>\n' +
                                '</div>'
            }
        });
    }

</script>
</body>
</html>
