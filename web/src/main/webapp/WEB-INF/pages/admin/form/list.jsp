<%--
  Created by IntelliJ IDEA.
  User: vovanphuc0810
  Date: 1/5/16
  Time: 9:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="packageGroup.manager"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin" />
</security:authorize>
<c:url var="dashboardUrl" value="/home.html"/>
<c:url var="formlUrl" value="${prefix}/form/list.html"/>

<fmt:message var="allText" key="label.all" />
<body>
<div class="content-wrapper">
    <form:form commandName="item" action="${formlUrl}" id="listForm" method="post" autocomplete="off" name="listForm" cssClass="form-horizontal">
        <section class="content-header">
            <h4>
                <fmt:message key="contractor.list"/>
                    <%--<small><fmt:message key="user.manager.list"/></small>--%>
            </h4>
            <ol class="breadcrumb">
                <li><a href="${dashboardUrl}"><i class="fa fa-home"></i>&nbsp;<fmt:message key="label.home.title"/></a></li>
                <li class="active"><fmt:message key="label.form"/></li>
                <li><fmt:message key="menu.form"/></li>
                <li class="active"><fmt:message key="packageGroup.manager.list"/></li>
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
                                                <form:options items="${listChuTri}" itemLabel="displayName" itemValue="userId"/>
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
                                                <form:options items="${listThanhVien}" itemLabel="displayName" itemValue="userId"/>
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
                                        <label class="col-sm-4 control-label"><fmt:message key="bid.pada.soquyetdinhpada"/></label>
                                        <div class="col-sm-8">
                                            <form:input path="pojo.qdPheDuyetSo" cssClass="form-control input-xs nohtml" data-trigger="focus" />
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.code"/></label>
                                        <div class="col-sm-8">
                                            <form:input path="pojo.maGoiThau" cssClass="form-control input-xs nohtml" data-trigger="focus" />
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.ten"/></label>
                                        <div class="col-sm-8">
                                            <form:input path="pojo.tenGoiThau" cssClass="form-control input-xs nohtml" data-trigger="focus" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
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
                            <div class="text-center">
                                <a id="btnFilter" type="submit" class="btn btn-xs btn-primary"><i class="fa fa-fw fa-search"></i><fmt:message key="label.search"/></a>
                                <a class="btn btn-xs cancel-link" href="${backUrl}"><fmt:message key="button.cancel"/></a>
                                <input type="hidden" value="1" id="stt" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title"><fmt:message key="label.form.title"/></h3>
                        </div>

                        <div class="box-body">
                            <div class="row">
                                <label class="control-label col-sm-2"><fmt:message key="label.form"/></label>
                                <div class="col-sm-7">
                                    <from:select id="formSelectId" path="pojo.bieuMau" cssStyle="width: 274px;">
                                        <from:options items="${listForm}" itemValue="bieuMau" itemLabel="tenBieuMau"/>
                                    </from:select>
                                </div>
                            </div>
                            <display:table name="items.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                           partialList="true" sort="external" size="${items.totalItems}" defaultsort="0"
                                           id="tableList" pagesize="${items.totalItems}" export="false" class="table table_vms table-bordered table-hover table-striped" style="margin: 1em 0 1.5em; width: 100%;">
                                <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center">${tableList_rowNum + (page * Constants.MAXPAGEITEMS)}</display:column>
                                <display:column headerClass="table_header_center" sortable="false" property="maGoiThau" sortName="maGoiThau" escapeXml="true" titleKey="label.nhathau.magoithau" class="nowrap" />
                                <display:column headerClass="table_header_center nowrap" sortable="false" sortName="tenGoiThau" titleKey="label.nhathau.tengoithau">
                                    ${tableList.tenGoiThau}
                                    <%--<p class="no-margin" title="${tableList.tenGoiThau}"><str:truncateNicely upper="49">${tableList.tenGoiThau}</str:truncateNicely></p>--%>
                                </display:column>
                                <display:column headerClass="table_header_center" sortable="false" property="tenNguonVon" sortName="tenNguonVon" escapeXml="true" titleKey="label.report105.nguonVon" class="nowrap" />
                                <display:column headerClass="table_header_center nowrap" sortable="false" property="tenLoai" sortName="tenLoai" escapeXml="true" titleKey="label.loai" class="nowrap"/>
                                <display:column headerClass="table_header_center nowrap" sortable="false" property="tenPhong" sortName="tenPhong" escapeXml="true" titleKey="bid.pada.department"/>
                                <display:column headerClass="table_header_center nowrap" sortable="false" property="toChuyenGia" sortName="toChuyenGia" escapeXml="true" titleKey="bid.goithau.tochuyengia"/>
                                <display:column headerClass="table_header_center" sortable="false" property="tenHinhThuc" sortName="tenHinhThuc" escapeXml="true" titleKey="label.hinhThuc"/>
                                <display:column headerClass="table_header_center" sortable="false" property="tenQuiMo" sortName="tenQuiMo" escapeXml="true" titleKey="bid.goithau.quimo" class="nowrap"/>
                                <display:column headerClass="table_header_center nowrap" sortable="false" property="tenNhaThau" sortName="tenNhaThau" escapeXml="true" titleKey="bid.goithau.nhathau.trungthau"/>
                                <display:column headerClass="table_header_center nowrap" sortable="false" property="tenTinhTrang" sortName="tenTinhTrang" escapeXml="true" titleKey="label.nhathau.tinhtrang"/>
                                <display:column headerClass="table_header_center " titleKey="label.action" class="text-center">
                                    <a href="javascript:void(0);" onclick="popupSelectForm('${tableList.maGoiThau}');" class="tip-top" title="<fmt:message key="menu.form" />"><i class="fa fa-file-word-o"></i></a>
                                </display:column>

                                <display:setProperty name="paging.banner.item_name"><fmt:message key="packageGroup.manager.packagegroup.item"/></display:setProperty>
                                <display:setProperty name="paging.banner.items_name"><fmt:message key="packageGroup.manager.packagegroup.item"/></display:setProperty>
                            </display:table>
                        </div>
                    </div>
                </div>
            </div>
            <form:hidden path="crudaction" id="crudaction"/>
            <input type="hidden" name="maGoiThau" id="maGoiThau"/>
    </form:form>
    </section>
</div>
<script>
    $(document).ready(function(){
        // active tab
        setActiveMenu4Admin('#form_menu', '#form101_menu');

        $("#btnFilter").click(function(){
            $("#crudaction").val("search");
            $("#listForm").submit();
        });

        validateSelect2Select($('#checkListTinhTrang'));
        validateSelect2Select($('#checkListHinhThuc'));
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
        $('.datepicker-years').datepicker({
            format: "yyyy",
            autoclose: true,
            minViewMode: "years"
        });
    });

    function popupSelectForm(maGoiThau){
        $('#maGoiThau').val(maGoiThau);
        $("#crudaction").val("export");
        $("#listForm").submit();
    }

</script>
</body>
</html>