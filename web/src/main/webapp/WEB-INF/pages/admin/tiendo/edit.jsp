<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="tiendo.title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/plugins/kartik-v-bootstrap-fileinput-cde7292/css/fileinput.min.css"/>">
    <style>
        .select2-container{
            width: 100% !important;
        }
        .modal-dialog {
            width: 90%;
        }
        label.default-label.text-center{
            font-weight: normal !important;
            width: 100%;
            text-align: center !important;
        }
        table.table-padding input.form-control,
        table.table-padding .select2-container{
            width: 100% !important;
            /*margin-left: 5% !important;*/
            /*margin-right: 5% !important;*/
        }

        .tong-tien-dang-bao-label{
            text-align: left !important;
            font-weight: bold;
            width: 100%;
            display: inline-block;
        }
    </style>
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin"></c:set>
</security:authorize>
<c:url var="dashboardUrl" value="/home.html"/>
<c:url var="backUrl" value="/home.html"/>
<c:url var="formUrl" value="${prefix}/tiendo/edit.html"/>
<c:url var="listUrl" value="${prefix}/goithau/list.html"/>
<c:url var="capnhatnhathauUrl" value="${prefix}/nhathau/capnhatnhathau.html"/>
<c:url var="hosonhathauUrl" value="/hosonhathau/edit.html"/>
<c:url var="BidUrl" value="${prefix}/goithau/list.html"/>
<c:set var="aXT" value="true"/>
<c:set var="aTD" value="true"/>
<c:if test="${!empty allowXT && allowXT == true}">
    <c:set var="aXT" value="false"/>
</c:if>
<c:if test="${!empty allowTD && allowTD == true}">
    <c:set var="aTD" value="false"/>
</c:if>
<body>

<div class="content-wrapper">

    <div class="container">
    <form:form commandName="item" id="formItem" action="${formUrl}" method="post" cssClass="form-horizontal" novalidate="novalidate" enctype="multipart/form-data">
    <section class="content-header">
        <h4>
            <fmt:message key="contractor.pada.progress"/>
                <%--<small><fmt:message key="user.manager.list"/></small>--%>
        </h4>
        <ol class="breadcrumb">
            <li><a href="${dashboardUrl}"><i class="fa fa-home"></i> <fmt:message key="label.home.title"/></a></li>
            <li><a href="${BidUrl}"><fmt:message key="contractor.title.management"/></a></li>
            <li class="active"><fmt:message key="contractor.pada.progress"/></li>
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
        <h3 class="box-title"><fmt:message key="tiendo.title"/></h3>
    </div>
    <div class="box-body">
    <div class="form-group">
        <label class="control-label col-sm-3"><fmt:message key="tiendo.label.goithau"/><label style="color:red;">(*)</label></label>
        <div class="col-sm-9">
            <div class="col-sm-10 col-sm-offset-1 ">
                <div class="input-group input-group-xs">
                    <textarea disabled="disabled" class="form-control input-xs" rows="1" style="resize: none;"><c:if test="${!empty item.pojo.goithau}">${item.pojo.goithau.tengoithau}</c:if></textarea>
                                            <span class="input-group-btn">
                                                 <a onclick="listenForGetGoiThau()" href="javascript: void(0);" class="btn btn-info" title="<fmt:message key="tiendo.label.chongoithau"/>">
                                                     <i class="fa fa-search"></i>
                                                 </a>
                                            </span>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-3"><fmt:message key="tiendo.label.thuoc.pada"/></label>
        <div class="col-sm-9">
            <div class="col-sm-10 col-sm-offset-1">
                <textarea disabled="disabled" rows="1" style="resize: vertical" class="form-control input-xs"><c:if test="${!empty item.pojo.goithau}">${item.pojo.goithau.tenpada}</c:if></textarea>
            </div>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-3" ><fmt:message key="tiendo.label.tinhtrang"/></label>
        <div class="col-sm-9">
            <div class="col-sm-10 col-sm-offset-1">
                <label class="control-label default-label"><c:if test="${!empty item.pojo.goithau}">${item.pojo.goithau.tinhtrang.tentinhtrang}</c:if></label>
            </div>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-3"><fmt:message key="tiendo.label.thamdinh.pa"/></label>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.thamDinhPASo" disabled="${aTD}" cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input type="text" name="pojo.thamDinhPANgay" <c:if test="${aTD}">disabled="true"</c:if>  class="form-control input-xs pull-right datePlaceHolder datepicker" id="thamDinhPANgay" value="<fmt:formatDate value="${item.pojo.thamDinhPANgay}" pattern="dd/MM/yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="thamDinhPA" name="thamDinhPA" type="file" class="file-input" <c:if test="${aTD}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.quyetdinhpheduyetpa"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.qdPheDuyetSo" disabled="${aTD}" cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.qdPheDuyetNgay" <c:if test="${aTD}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="qdPheDuyetNgay" value="<fmt:formatDate value="${item.pojo.qdPheDuyetNgay}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="qdPheDuyetPA" name="qdPheDuyetPA" type="file" class="file-input" <c:if test="${aTD}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.dangbaokehoachthau"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.dbKeHoachThauSo" disabled="${aTD}" cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.dbKeHoachThauNgay"  <c:if test="${aTD}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="dbKeHoachThauNgay" value="<fmt:formatDate value="${item.pojo.dbKeHoachThauNgay}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="dbKeHoachThau" name="dbKeHoachThau" type="file" class="file-input" <c:if test="${aTD}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.totrinhdstochuyengia"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.trinhtcgSo" disabled="${aXT}" cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.trinhtcgNgay" <c:if test="${aXT}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="trinhtcgNgay" value="<fmt:formatDate value="${item.pojo.trinhtcgNgay}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="toTrinhDSTCG" name="toTrinhDSTCG" type="file" class="file-input" <c:if test="${aXT}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.qdthanhlaptochuyengia"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.tcgSo" disabled="${aXT}" cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.tcgNgay" <c:if test="${aXT}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="tcgNgay" value="<fmt:formatDate value="${item.pojo.tcgNgay}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="qdThanhLapTCG" name="qdThanhLapTCG" type="file" class="file-input" <c:if test="${aXT}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.trinhhs.mtyc"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.trinhhsSo" disabled="${aXT}" cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.trinhhsNgay" <c:if test="${aXT}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="trinhhsNgay" value="<fmt:formatDate value="${item.pojo.trinhhsNgay}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="trinhHSMTHSYC" name="trinhHSMTHSYC" type="file" class="file-input" <c:if test="${aXT}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.baocaothamdinh"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.baoCaoThamDinhSo" disabled="${aTD}" cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.baoCaoThamDinhNgay" <c:if test="${aTD}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="baoCaoThamDinhNgay" value="<fmt:formatDate value="${item.pojo.baoCaoThamDinhNgay}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="baoCaoThamDinh" name="baoCaoThamDinh" type="file" class="file-input" <c:if test="${aTD}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.quyetdinhpheduyet.mtyc"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.duyethsSo" disabled="${aTD}" cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.duyethsNgay" <c:if test="${aTD}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="duyethsNgay" value="<fmt:formatDate value="${item.pojo.duyethsNgay}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="qdPheDuyetHSMTHSYC" name="qdPheDuyetHSMTHSYC" type="file" class="file-input" <c:if test="${aTD}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>


    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.quyetdinhtennhathauthamgia"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.cdtSo" disabled="${aXT}" cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.cdtNgay" <c:if test="${aXT}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="cdtNgay" value="<fmt:formatDate value="${item.pojo.cdtNgay}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="qdTenNhaThauThamGia" name="qdTenNhaThauThamGia" type="file" class="file-input" <c:if test="${aXT}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.trinhpheduyetkinhphidangbao"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.trinhdangbaoSo" disabled="${aXT}" cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.trinhdangbaoNgay" <c:if test="${aXT}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="trinhdangbaoNgay" value="<fmt:formatDate value="${item.pojo.trinhdangbaoNgay}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="trinhPheDuyetKPDB" name="trinhPheDuyetKPDB" type="file" class="file-input" <c:if test="${aXT}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.kinhphidangbao"/></label>
        </div>
        <div class="col-sm-9">
            <table style="width: 100%;" class="tableAdd table-padding table table-striped">
                <thead>
                <th class="nowrap" style="width: 5%"><fmt:message key="tiendo.label.kpdb.stt"/></th>
                <th class="nowrap" style="width: 20%"><fmt:message key="tiendo.label.kpdb.loaibao"/></th>
                <th class="nowrap" style="width: 25%"><fmt:message key="tiendo.label.kpdb.noidung"/></th>
                <th class="nowrap" style="width: 10%"><fmt:message key="tiendo.label.kpdb.khobao"/></th>
                <th class="nowrap" style="width: 5%"><fmt:message key="tiendo.label.kpdb.soky"/></th>
                <th class="nowrap" style="width: 15%"><fmt:message key="tiendo.label.kpdb.chiphi"/></th>
                <th class="nowrap" style="width: 15%"><fmt:message key="tiendo.label.kpdb.thanhtien"/></th>
                <th class="nowrap" style="width: 5%"><input type="checkbox" id="checkAll_kp"/> </th>
                </thead>
                <tbody class="body_tableAdd_kp">
                <c:forEach items="${item.listkp}" var="kp" varStatus="kinhphi">
                    <tr class="rowkp">
                        <td>${kinhphi.index + 1}<form:hidden path="listkp[${kinhphi.index}].mskinhphi" value="${kp.mskinhphi}"/></td>
                        <td>
                            <form:select path="listkp[${kinhphi.index}].loaibao.msloaibao">
                                <c:forEach items="${listlb}" var="lb">
                                    <c:if test="${lb.msloaibao == kp.loaibao.msloaibao}">
                                        <form:option value="${lb.msloaibao}" selected="selected">${lb.tenloaibao}</form:option>
                                    </c:if>
                                    <c:if test="${lb.msloaibao != kp.loaibao.msloaibao}">
                                        <form:option value="${lb.msloaibao}">${lb.tenloaibao}</form:option>
                                    </c:if>
                                </c:forEach>
                            </form:select>
                        </td>
                        <td>
                            <form:select path="listkp[${kinhphi.index}].noidung.msnoidung">
                                <c:forEach items="${listnd}" var="nd">
                                    <c:if test="${nd.msnoidung == kp.noidung.msnoidung}">
                                        <form:option value="${nd.msnoidung}" selected="selected">${nd.tennoidung}</form:option>
                                    </c:if>
                                    <c:if test="${nd.msnoidung != kp.noidung.msnoidung}">
                                        <form:option value="${nd.msnoidung}">${nd.tennoidung}</form:option>
                                    </c:if>
                                </c:forEach>
                            </form:select>
                        </td>
                        <td><form:input path="listkp[${kinhphi.index}].khobao" value="${kp.khobao}" cssClass="input_kp form-control input-xs"/></td>
                        <td class="so-ki-dang-bao"><form:input path="listkp[${kinhphi.index}].soky" value="${kp.soky}" cssClass="input_kp input_number onlyNumberInput form-control input-xs"/></td>
                        <td class="chi-phi-dang-bao">
                            <fmt:formatNumber var="chiphidb" value="${kp.chiphi}" pattern="###,###" />
                            <input name="item.listkp[${kinhphi.index}].chiphi" value="${chiphidb}" class="form-control input-xs nohtml onlyNumberInput inputNumber" data-trigger="focus" />
                        </td>
                        <td class="tong-tien-dang-bao">
                            <span class="tong-tien-dang-bao-label">${kp.thanhtien}</span>
                            <form:hidden path="listkp[${kinhphi.index}].thanhtien" value="${kp.thanhtien}" cssClass="input_kp input_number form-control input-xs"/>
                        </td>
                        <td><input type="checkbox" class="checkBox_kp"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="text-right">
                <c:if test="${!aXT}">
                    <a id="addNew_kpdb" class="btn btn-xs btn-success"><fmt:message key="tiendo.label.themdong"/></a>
                    <a id="removeRow_kpdb" class="btn btn-xs btn-danger"><fmt:message key="tiendo.label.xoadong"/></a>
                </c:if>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.ngaydangbao"/></label>
        </div>
        <div class="col-sm-9">
            <table style="width: 100%;" class="tableAdd table-padding table table-striped">
                <thead>
                <th class="nowrap" style="width: 5%"><fmt:message key="tiendo.label.ndb.stt"/></th>
                <th class="nowrap"><fmt:message key="tiendo.label.ndb.socv"/></th>
                <th class="nowrap"><fmt:message key="tiendo.label.ndb.ngaycv"/></th>
                <th class="nowrap"><fmt:message key="tiendo.label.ndb.noidung"/></th>
                <th class="nowrap"><fmt:message key="tiendo.label.ndb.loaibao"/></th>
                <th class="nowrap"><fmt:message key="tiendo.label.ndb.ngaydang"/></th>
                <th class="nowrap"><fmt:message key="tiendo.label.ndb.sobaobatdau"/></th>
                <th class="nowrap"><fmt:message key="tiendo.label.ndb.sokydang"/></th>
                <th class="nowrap"><fmt:message key="tiendo.label.ndb.ghichu"/></th>
                <th class="nowrap" style="width: 5%"><input type="checkbox" id="checkAll_ndb"/> </th>
                </thead>
                <tbody class="body_tableAdd_ndb">
                <c:forEach items="${item.listndb}" var="ndb" varStatus="ngaydangbao">
                    <tr class="rowndb">
                        <td>${ngaydangbao.index + 1}<form:hidden path="listndb[${ngaydangbao.index}].msdangbao" value="${ndb.msdangbao}"/></td>
                        <td><form:input path="listndb[${ngaydangbao.index}].socongvan" value="${ndb.socongvan}" cssClass="input_ndb"/></td>
                        <td><form:input path="listndb[${ngaydangbao.index}].ngaycongvan" value="${ndb.ngaycongvan}" cssClass="input_ndb datePlaceHolder"/></td>
                        <td>
                            <form:select path="listndb[${ngaydangbao.index}].noidung.msnoidung">
                                <c:forEach items="${listnd}" var="nd">
                                    <c:if test="${nd.msnoidung == ndb.noidung.msnoidung}">
                                        <form:option value="${nd.msnoidung}" selected="selected">${nd.tennoidung}</form:option>
                                    </c:if>
                                    <c:if test="${nd.msnoidung != kp.noidung.msnoidung}">
                                        <form:option value="${nd.msnoidung}">${nd.tennoidung}</form:option>
                                    </c:if>
                                </c:forEach>
                            </form:select>
                        </td>
                        <td>
                            <form:select path="listndb[${ngaydangbao.index}].loaibao.msloaibao">
                                <c:forEach items="${listlb}" var="lb">
                                    <c:if test="${lb.msloaibao == ndb.loaibao.msloaibao}">
                                        <form:option value="${lb.msloaibao}" selected="selected">${lb.tenloaibao}</form:option>
                                    </c:if>
                                    <c:if test="${lb.msloaibao != ndb.loaibao.msloaibao}">
                                        <form:option value="${lb.msloaibao}">${lb.tenloaibao}</form:option>
                                    </c:if>
                                </c:forEach>
                            </form:select>
                        </td>
                        <td><form:input path="listndb[${ngaydangbao.index}].ngaydangbao" value="${ndb.ngaydangbao}" cssClass="input_ndb datePlaceHolder form-control input-xs"/></td>
                        <td><form:input path="listndb[${ngaydangbao.index}].sobaobatdau" value="${ndb.sobaobatdau}" cssClass="input_ndb input_number form-control input-xs"/></td>
                        <td><form:input path="listndb[${ngaydangbao.index}].sokydangbao" value="${ndb.sokydangbao}" cssClass="input_ndb input_numbers form-control input-xs"/></td>
                        <td><form:input path="listndb[${ngaydangbao.index}].ghichu" value="${ndb.ghichu}" cssClass="input_ndb form-control input-xs"/></td>
                        <td><input type="checkbox" class="checkBox_ndb"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="text-right">
                <c:if test="${!aXT}">
                    <a id="addNew_ndb" class="btn btn-xs btn-success"><fmt:message key="tiendo.label.themdong"/></a>
                    <a id="removeRow_ndb" class="btn btn-xs btn-danger"><fmt:message key="tiendo.label.xoadong"/></a>
                </c:if>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.ngayban-phat.hs"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.lan1"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.ngaybanhsL1" <c:if test="${aXT}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="ngaybanhsL1" value="<fmt:formatDate value="${item.pojo.ngaybanhsL1}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.lan2"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.ngaybanhsL2" <c:if test="${aXT}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="ngaybanhsL2" value="<fmt:formatDate value="${item.pojo.ngaybanhsL2}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.lan3"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.ngaybanhsL3" <c:if test="${aXT}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="ngaybanhsL3" value="<fmt:formatDate value="${item.pojo.ngaybanhsL3}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.ngaymothau"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.lan1"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.ngaymothauL1" <c:if test="${aXT}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="ngaymothauL1" value="<fmt:formatDate value="${item.pojo.ngaymothauL1}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.lan2"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.ngaymothauL2" <c:if test="${aXT}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="ngaymothauL2" value="<fmt:formatDate value="${item.pojo.ngaymothauL2}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.lan3"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.ngaymothauL3" <c:if test="${aXT}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="ngaymothauL3" value="<fmt:formatDate value="${item.pojo.ngaymothauL3}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label"><fmt:message key="tiendo.label.nhathau.trungthau"/></label>
        <div class="col-sm-6">
            <select name="pojo.hoSoThau.mshosothau" class="form-control input-xs" onchange="changenhathau(this.value);" <c:if test="${aXT}">disabled="true"</c:if>>
                <option value="-1"><fmt:message key="tiendo.label.chonnhathautrungthau"/> </option>
                <c:forEach items="${listHST}" var="hst">
                    <c:if test="${!empty item.pojo.hoSoThau && hst.mshosothau == item.pojo.hoSoThau.mshosothau}">
                        <option id="nhathau_${hst.mshosothau}" value="${hst.mshosothau}" selected="selected" giatrungthau="<fmt:formatNumber value="${hst.noiDungHoSo.giaDuThau}"/>" giatrungthausauthue="<fmt:formatNumber value="${hst.noiDungHoSo.giaDuThauSauThue}"/>" tennhathau="${hst.goithau_nhathau.nhathau.tennhathau}">${hst.goithau_nhathau.nhathau.tennhathau}</option>
                    </c:if>
                    <c:if test="${empty item.pojo.hoSoThau || hst.mshosothau != item.pojo.hoSoThau.mshosothau}">
                        <option id="nhathau_${hst.mshosothau}" value="${hst.mshosothau}" giatrungthau="<fmt:formatNumber value="${hst.noiDungHoSo.giaDuThau}"/>" giatrungthausauthue="<fmt:formatNumber value="${hst.noiDungHoSo.giaDuThauSauThue}"/>" tennhathau="${hst.goithau_nhathau.nhathau.tennhathau}">${hst.goithau_nhathau.nhathau.tennhathau}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label"><fmt:message key="tiendo.label.giaduyet"/></label>
        <div class="col-sm-2">
            <input id="giaduyet_nt" class="form-control input-xs" type="text" disabled="disabled" <c:if test="${!empty item.pojo.goithau}">value="<fmt:formatNumber value="${item.pojo.goithau.giatrigoithau}"/>"</c:if>>
        </div>
        <label class="col-sm-2 control-label"><fmt:message key="tiendo.label.giaduyet.sauthue"/></label>
        <div class="col-sm-2">
            <input id="giaduyet_nt_sauthue" type="text" class="form-control input-xs" disabled="disabled" <c:if test="${!empty item.pojo.goithau}">value="<fmt:formatNumber value="${item.pojo.goithau.giatrigoithautruocthue}"/>"</c:if>>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label"><fmt:message key="tiendo.label.giatrungthau"/></label>
        <div class="col-sm-2">
            <input id="giatrungthau_nt" class="form-control input-xs" type="text" disabled="disabled" <c:if test="${!empty item.pojo.hoSoThau}">value="<fmt:formatNumber value="${item.pojo.hoSoThau.noiDungHoSo.giaDuThau}"/>"</c:if>>
        </div>
        <label class="col-sm-2 control-label"><fmt:message key="tiendo.label.giatrungthau.sauthue"/></label>
        <div class="col-sm-2">
            <input id="giatrungthau_nt_sauthue" type="text" class="form-control input-xs" disabled="disabled" <c:if test="${!empty item.pojo.hoSoThau}">value="<fmt:formatNumber value="${item.pojo.hoSoThau.noiDungHoSo.giaDuThau}"/>"</c:if>>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.huythau"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
            </div>
            <div class="col-sm-3">
                <form:checkbox path="pojo.ishuythau" disabled="${aXT}" cssClass="data-switch-no-init"/>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.thumoithuongthao"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.thuMoiThuongThaoSo" disabled="${aXT}" cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.thuMoiThuongThaoNgay" <c:if test="${aXT}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="thuMoiThuongThaoNgay" value="<fmt:formatDate value="${item.pojo.thuMoiThuongThaoNgay}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="thuMoiThuongThao" name="thuMoiThuongThao" type="file" class="file-input" <c:if test="${aXT}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.bc.danhgiahoso"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.baocaodgSo" disabled="${aXT}" cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.baocaodgNgay" <c:if test="${aXT}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="baocaodgNgay" value="<fmt:formatDate value="${item.pojo.baocaodgNgay}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="bcDanhGiaHoSo" name="bcDanhGiaHoSo" type="file" class="file-input" <c:if test="${aXT}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.bienbanthuongthao"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.bienBanThuongThaoSo" disabled="${aXT}" cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.bienBanThuongThaoNgay" <c:if test="${aXT}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="bienBanThuongThaoNgay" value="<fmt:formatDate value="${item.pojo.bienBanThuongThaoNgay}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="bienBanThuongThao" name="bienBanThuongThao" type="file" class="file-input" <c:if test="${aXT}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.trinhketqua"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.trinhkqSo" disabled="${aXT}" cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.trinhkqNgay" <c:if test="${aXT}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="trinhkqNgay" value="<fmt:formatDate value="${item.pojo.trinhkqNgay}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="trinhKetQua" name="trinhKetQua" type="file" class="file-input" <c:if test="${aXT}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.bc.thamdinhketqua"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.bcThamDinhKetQuaSo" disabled="${aTD}" cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.bcThamDinhKetQuaNgay" <c:if test="${aTD}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="bcThamDinhKetQuaNgay" value="<fmt:formatDate value="${item.pojo.bcThamDinhKetQuaNgay}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="bcThamDinhKetQua" name="bcThamDinhKetQua" type="file" class="file-input" <c:if test="${aTD}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.qd.pheduyetketqua"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.pheduyetkqSo" disabled="${aTD}" cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.pheduyetkqNgay"  <c:if test="${aTD}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="pheduyetkqNgay" value="<fmt:formatDate value="${item.pojo.pheduyetkqNgay}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="pheDuyetKetQua" name="pheDuyetKetQua" type="file" class="file-input" <c:if test="${aTD}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.dangbaoketqualuachonnhathau"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.dbkqLuaChonNhaThauSo" disabled="${aTD}" cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.dbkqLuaChonNhaThauNgay" <c:if test="${aTD}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="dbkqLuaChonNhaThauNgay" value="<fmt:formatDate value="${item.pojo.dbkqLuaChonNhaThauNgay}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="danhGiaLuaChonNhaThau" name="danhGiaLuaChonNhaThau" type="file" class="file-input" <c:if test="${aTD}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.thongbaoketqua"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-3">
                <form:input path="pojo.thongbaokqSo" disabled="${aXT}"  cssClass="form-control input-xs"/>
            </div>
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.ngay"/></label>
            </div>
            <div class="col-sm-3">
                <div class="input-group input-group-xs">
                    <input name="pojo.thongbaokqNgay" <c:if test="${aXT}">disabled="true"</c:if> class="form-control input-xs pull-right datePlaceHolder datepicker" id="thongbaokqNgay" value="<fmt:formatDate value="${item.pojo.thongbaokqNgay}" pattern="dd-MM-yyyy"/>"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group input-group-xs" style="width: 100%">
                    <input id="thongBaoKet" name="thongBaoKet" type="file" class="file-input" <c:if test="${aXT}">disabled="true"</c:if>>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text_right">
            <label class="control-label"><fmt:message key="tiendo.label.ghichu"/></label>
        </div>
        <div class="col-sm-9">
            <div class="col-sm-1">
                <label class="control-label default-label text-center"><fmt:message key="tiendo.label.so"/></label>
            </div>
            <div class="col-sm-7">
                <form:input path="pojo.ghichu" disabled="${aXT}" cssClass="form-control input-xs"/>
            </div>
        </div>
    </div>

    <form:hidden path="pojo.editer"/>
    <c:if test="${!empty allowAction && allowAction == true}">
        <form:hidden id="varGoiThau" path="pojo.goithau.msgoithau"/>
        <form:hidden path="pojo.mstiendo"/>
        <form:hidden path="crudaction"/>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-9">
                <div class="col-sm-offset-1 col-sm-11">
                    <a id="btnSaveTienDo" class="btn btn-primary btn-sm"><fmt:message key="button.save"/></a>
                    <a class="btn btn-primary btn-sm" href="${listUrl}"><fmt:message key="tiendo.label.button.danhsach"/></a>
                    <a class="btn btn-primary btn-sm" href="${capnhatnhathauUrl}?pojo.goithau.msgoithau=${item.pojo.goithau.msgoithau}"><fmt:message key="tiendo.label.button.capnhatnhathau"/></a>
                    <a class="btn btn-primary btn-sm" href="${hosonhathauUrl}?pojo.goithau_nhathau.goithau.msgoithau=${item.pojo.goithau.msgoithau}"><fmt:message key="tiendo.label.button.hosothau"/></a>
                </div>
            </div>
        </div>
    </c:if>
    </div>
    </div>
    </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="box box-solid box-primary">
                <div class="box-body">
                    <div class="col-sm-12">
                        <div class="form-group">
                            <div class="col-sm-3 text_right">
                                <label class="control-label"><fmt:message key="label.form"/></label>
                            </div>
                            <div class="col-sm-3">
                                <form:select id="bieumau" path="bieuMau" class="form-control input-xs" onchange="loadSelectMenu($(this))">
                                    <form:option value=""><fmt:message key="tiendo.label.bieumau.chonbieumau"/></form:option>
                                    <form:options items="${listForm}" itemValue="bieuMau" itemLabel="tenBieuMau"/>
                                </form:select>
                            </div>
                            <div id="NhaThau" class="col-sm-2" style="display: none;">
                                <form:select id="NhaThauId" path="bieuMau" class="form-control input-xs">
                                    <form:option value=""><fmt:message key="tiendo.label.nhaThau.selecter"/></form:option>
                                    <form:options items="${nhaThaus}" itemValue="nhathau.msnhathau" itemLabel="nhathau.tennhathau"/>
                                </form:select>
                            </div>
                            <%--<div class="col-sm-2">--%>
                                <%--<select id="loaibaoex" style="width: 100%;">--%>
                                    <%--<option value=""><fmt:message key="tiendo.label.kpdb.loaibao"/></option>--%>
                                <%--</select>--%>
                            <%--</div>--%>
                            <a id="btnXuatBieuMau" class="btn btn-xs btn-primary"><fmt:message key="button.xuatbieumau"/></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    </section>
    </form:form>
    </div>
</div>
<div class="modal fade bvModel" role="dialog" id="addModel"></div>

<script src="<c:url value="/themes/vmsreport/plugins/kartik-v-bootstrap-fileinput-cde7292/js/fileinput.min.js"/> "></script>
<script type="text/javascript">
    $(document).ready(function(){
        setActiveMenu4Admin('#contractor_menu', '#tiendo_menu');

        <c:if test="${!empty item.pojo.goithau}">
        $("#btnXuatBieuMau").click(function(){
            var bieuMau = $("#bieumau").val(),
                loaiBao = $('#loaibaoex').val(),
                msNhaThau = $('#NhaThauId').val();

            if(bieuMau != undefined && bieuMau != ''){
                if(msNhaThau != undefined && msNhaThau != '' || bieuMau != '18.MauCGCT-ToTrinhPDKQCGCT'){
                    var url = '<c:url value="/ajax/bieumau/export.html"/>';
                    $.ajax({
                        type: 'post',
                        dataType: 'text',
                        cache: false,
                        //                    contentType: "application/json",
                        url : url,
                        data : {'bieuMau' : bieuMau,
                            'goithauid' : ${item.pojo.goithau.msgoithau},
                            'loaiBao' : loaiBao,
                            'msNhaThau' : msNhaThau},
                        success: function(data){
                            console.log(data);
                            window.location.href = '${pageContext.request.contextPath}'
                                    + data;
                        }
                    });
                }else{
                    $('#select2-NhaThauId-container').attr( 'title', '<fmt:message key="label.nhathau.notselct"/>')
                            .tooltip('show');
                }
            }

        });
        </c:if>

        var countkp = $(".rowkp").length;
        var countndb = $(".rowndb").length;
        <c:if test="${!empty allowAction && allowAction == true}">
            $("#btnSaveTienDo").click(function(){
                $("#crudaction").val("update");
                $("#formItem").submit();
            });
        </c:if>

        $("#checkAll_kp").on('change', function(){
            if(this.checked){
                $(".checkBox_kp").prop('checked', true);
            }else{
                $(".checkBox_kp").prop('checked', false);
            }
        });

        $("#checkAll_ndb").on('change', function(){
            if(this.checked){
                $(".checkBox_ndb").prop('checked', true);
            }else{
                $(".checkBox_ndb").prop('checked', false);
            }
        });

        $("#removeRow_kpdb").click(function(){
            $(".checkBox_kp").each(function(){
                if($(this).is(':checked') == true){
                    $(this).closest(".rowkp").remove() ;
                }
            });
        });

        $("#removeRow_ndb").click(function(){
            $(".checkBox_ndb").each(function(){
                if($(this).is(':checked') == true){
                    $(this).closest(".rowndb").remove() ;
                }
            });
        });

        initInputNumberByParent($('.tableAdd'));

        autoCalculatorThanhTienInit();
        initInputFile("thamDinhPA", '${thamDinhPA}', '${fn:split(thamDinhPA, "/")[fn:length(fn:split(thamDinhPA, "/"))-1]}');
        initInputFile("qdPheDuyetPA", '${qdPheDuyetPA}', '${fn:split(qdPheDuyetPA, "/")[fn:length(fn:split(qdPheDuyetPA, "/"))-1]}');
        initInputFile("dbKeHoachThau", '${dbKeHoachThau}', '${fn:split(dbKeHoachThau, "/")[fn:length(fn:split(dbKeHoachThau, "/"))-1]}');
        initInputFile("toTrinhDSTCG", '${toTrinhDSTCG}', '${fn:split(toTrinhDSTCG, "/")[fn:length(fn:split(toTrinhDSTCG, "/"))-1]}');
        initInputFile("qdThanhLapTCG", '${qdThanhLapTCG}', '${fn:split(qdThanhLapTCG, "/")[fn:length(fn:split(qdThanhLapTCG, "/"))-1]}');
        initInputFile("trinhHSMTHSYC", '${trinhHSMTHSYC}', '${fn:split(trinhHSMTHSYC, "/")[fn:length(fn:split(trinhHSMTHSYC, "/"))-1]}');
        initInputFile("baoCaoThamDinh", '${baoCaoThamDinh}', '${fn:split(baoCaoThamDinh, "/")[fn:length(fn:split(baoCaoThamDinh, "/"))-1]}');
        initInputFile("qdPheDuyetHSMTHSYC", '${qdPheDuyetHSMTHSYC}', '${fn:split(qdPheDuyetHSMTHSYC, "/")[fn:length(fn:split(qdPheDuyetHSMTHSYC, "/"))-1]}');
        initInputFile("qdTenNhaThauThamGia", '${qdTenNhaThauThamGia}', '${fn:split(qdTenNhaThauThamGia, "/")[fn:length(fn:split(qdTenNhaThauThamGia, "/"))-1]}');
        initInputFile("trinhPheDuyetKPDB", '${trinhPheDuyetKPDB}', '${fn:split(trinhPheDuyetKPDB, "/")[fn:length(fn:split(trinhPheDuyetKPDB, "/"))-1]}');
        initInputFile("thuMoiThuongThao", '${thuMoiThuongThao}', '${fn:split(thuMoiThuongThao, "/")[fn:length(fn:split(thuMoiThuongThao, "/"))-1]}');
        initInputFile("bcDanhGiaHoSo", '${bcDanhGiaHoSo}', '${fn:split(bcDanhGiaHoSo, "/")[fn:length(fn:split(bcDanhGiaHoSo, "/"))-1]}');
        initInputFile("bienBanThuongThao", '${bienBanThuongThao}', '${fn:split(bienBanThuongThao, "/")[fn:length(fn:split(bienBanThuongThao, "/"))-1]}');
        initInputFile("trinhKetQua", '${trinhKetQua}', '${fn:split(trinhKetQua, "/")[fn:length(fn:split(trinhKetQua, "/"))-1]}');
        initInputFile("bcThamDinhKetQua", '${bcThamDinhKetQua}', '${fn:split(bcThamDinhKetQua, "/")[fn:length(fn:split(bcThamDinhKetQua, "/"))-1]}');
        initInputFile("pheDuyetKetQua", '${pheDuyetKetQua}', '${fn:split(pheDuyetKetQua, "/")[fn:length(fn:split(pheDuyetKetQua, "/"))-1]}');
        initInputFile("danhGiaLuaChonNhaThau", '${danhGiaLuaChonNhaThau}', '${fn:split(danhGiaLuaChonNhaThau, "/")[fn:length(fn:split(danhGiaLuaChonNhaThau, "/"))-1]}');
        initInputFile("thongBaoKet", '${thongBaoKet}', '${fn:split(thongBaoKet, "/")[fn:length(fn:split(thongBaoKet, "/"))-1]}');

        $("#addNew_kpdb").click(function(){
            try{
                $.ajax({
                    url : '<c:url value="/ajax/tiendo/newKPDB.html" />',
                    dateType: "html",
                    data : {'num': countkp},
                    success: function(res){
                        var newRow = $(res);
                        $(".body_tableAdd_kp").append($(newRow));
                        $(".body_tableAdd_kp").find("select.form-control").select2();
//                        initInputNumber();
                        formatInputNumber($(newRow));
//                        initInputNumberByParent($(newRow));
                        autoCalculatorThanhTien($(newRow));
                        countkp++;

                    },
                    error: function(e){
                        console.log(e);
                    }
                });
            }catch(e){
                console.log(e);
            }
        });

        $("#addNew_ndb").click(function(){
            try{
                $.ajax({
                    url : '<c:url value="/ajax/tiendo/newNDB.html" />',
                    dateType: "html",
                    data : {'num': countndb},
                    success: function(res){
                        $(".body_tableAdd_ndb").append(res);
                        $(".body_tableAdd_ndb").find("select.form-control").select2();
                        $(".body_tableAdd_ndb").find(".rownndb"+countndb+"in_list").find(".datePlaceHolder").inputmask("dd/mm/yyyy", {placeholder: "__/__/____"});
                        $(".body_tableAdd_ndb").find('.datepicker').daterangepicker({
                            format: "DD/MM/YYYY",
                            singleDatePicker : true,
                            showDropdowns: true
                        });
                        countndb++;
                    },
                    error: function(e){
                        console.log(e);
                    }
                });
            }catch(e){
                console.log(e);
            }
        });
    });


    function initInputNumberByParent(element){
        $(element).find('.input_number').on('keyup', function(e) {
            $(this).val($(this).val().replace(/[^0-9]/g, ''));
        });
    }


    function autoCalculatorThanhTienInit(){
        $('table.tableAdd').find('.rowkp').each(function(){
            autoCalculatorThanhTien($(this));
        });
    }

    function autoCalculatorThanhTien(element){
        $(element).find('.so-ki-dang-bao').find('input').blur(function(){
            updateTongTien($(element));
        });
        $(element).find('.chi-phi-dang-bao').find('input').blur(function(){
            updateTongTien($(element));
        });
    }

    function updateTongTien(element){
        if($.trim($(element).find('.so-ki-dang-bao').find('input').val())  != "" && $.trim($(element).find('.chi-phi-dang-bao').find('input').val() != "")){
            var soKyDangBao =  parseFloat(eval($.trim($(element).find('.so-ki-dang-bao').find('input').val()).replace(/,+/g, '')));
            var chiPhiDangBao =   parseFloat(eval($.trim($(element).find('.chi-phi-dang-bao').find('input').val()).replace(/,+/g, '')));
            if(soKyDangBao != null && soKyDangBao > 0 && chiPhiDangBao != null && chiPhiDangBao > 0){
                var total = soKyDangBao * chiPhiDangBao;
                $(element).find('.tong-tien-dang-bao').find('input').val(total);
                $(element).find('.tong-tien-dang-bao').find('.tong-tien-dang-bao-label').text(formatNumber(total));
            } else {
                $(element).find('.tong-tien-dang-bao').find('input').val("");
                $(element).find('.tong-tien-dang-bao').find('.tong-tien-dang-bao-label').text("");
            }
        }
    }

    function changenhathau(nt){
        if(nt != undefined && nt != '-1'){
            $("#giatrungthau_nt").val($("#nhathau_"+nt).attr("giatrungthau"));
            $("#giatrungthau_nt_sauthue").val($("#nhathau_"+nt).attr("giatrungthausauthue"));
        }else{
            $("#giaduyet_nt").val("");
            $("#giatrungthau_nt_sauthue").val("");
        }
    }

    function formatInputNumber(element){
        $(element).find('.onlyNumberInput').keyup(function(){
            $(this).val(formatNumber(eval($.trim($(this).val()).replace(/,+/g, ''))));
        });
    }


    function formatNumber(number){
        var number = number.toFixed(0) + '';
        var x = number.split('.');
        var x1 = x[0];
        var x2 = x.length > 1 ? '.' + x[1] : '';
        var rgx = /(\d+)(\d{3})/;
        while (rgx.test(x1)) {
            x1 = x1.replace(rgx, '$1' + ',' + '$2');
        }
        return x1 + x2;
    }
    function initInputFile(id, path, name){
        $('#'+id).fileinput({
            showUpload: false,
            showRemove: false,
            showPreview: false,
            mainClass: "input-group-xs",
            title: "Upload file",
            browseLabel: "",
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

    function listenForGetGoiThau(){
        var $modal = $('#addModel');
        $modal.load('<c:url value="/ajax/admin/goithau/list.html"/>', {'_': new Date().getTime()}, function(){
            $modal.modal();
            registerSubmitPopup();
        });
    }

    function registerSubmitPopup(){
        var page = 1;
        $("#listFormAjax #btnFilter").click(function(){
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
            var url = '<c:url value="/ajax/admin/goithau/list.html"/>?d-3677046-p='+page;
            $.ajax({
                cache: false,
                type: "POST",
                dataType: 'html',
                mimeType:"multipart/form-data",
                contentType: false,
                processData:false,
                data: formData,
                url : url,
                success:function(data){
                    var error = data.error;
                    if (error != null) {
                        alert(error);
                    }else if (data != null) {
                        $("#addModel").html(data);
                        registerSubmitPopup();
//                            $('.pagelinks a').each(function(e){
//                                var index = parseInt(this.href.split('?')[1].split('p=')[1].charAt(0));
//                                if(index == page){
//                                    $(this).css("cssText", "font-size : 25px");
//                                }
//                            });
                    }
                },
                error:function(e){
                }
            });
            return false;
        });
    }
    function chooseBid(msGoiThau){
        $('#formItem').attr('action', '${formUrl}?pojo.goithau.msgoithau=' + msGoiThau);
        $('#varGoiThau').val(msGoiThau);
        $("#formItem").submit();
//        e.preventDefault();
    }
    function loadSelectMenu(t){
        if(t.val() == '18.MauCGCT-ToTrinhPDKQCGCT' || t.val() == '20.MauCGCT-QDKQCGCT' || t.val() == '17.MauCHCT-ToTrinhPDKQCHCT'){
            $("#NhaThau").show();
        }else{
            $("#NhaThau").hide();
        }
    }

</script>
</body>
</html>