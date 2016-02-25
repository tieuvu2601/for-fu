<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="contractor.title.management"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%--<style>--%>
    <%--td {--%>
    <%--text-align: center !important;--%>
    <%--vertical-align: middle !important;--%>
    <%--}--%>
    <%--</style>--%>
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin"></c:set>
</security:authorize>

<c:url var="homeUrl" value="/index.html"/>
<c:url var="formlUrl" value="${prefix}/hosoluutru/list.html"/>
<c:url var="editUrl" value="${prefix}/goithau/edit.html"/>
<c:url var="addUrl" value="${prefix}/hosoluutru/edit.html"/>
<c:url var="backUrl" value="${prefix}/goithau/list.html"/>
<c:url var="tienDoUrl" value="${prefix}/tiendo/edit.html"/>
<c:url var="nhaThauUrl" value="${prefix}/hosoluutru/capnhatnhathau.html"/>


<fmt:message var="allText" key="label.all" />
<body>
<div class="content-wrapper">
<div class="container">
<form:form commandName="item" action="${formlUrl}" id="listForm" method="post" autocomplete="off" name="listForm" cssClass="form-horizontal">
<section class="content-header">
    <h4>
        <fmt:message key="contractor.brief"/>
            <%--<small><fmt:message key="user.manager.list"/></small>--%>
    </h4>
    <ol class="breadcrumb">
        <li><a href="${homeUrl}"><i class="fa fa-fw fa-home"></i>&nbsp;<fmt:message key="label.home.title"/></a></li>
        <li class="active"><fmt:message key="contractor.brief"/></li>

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
                        <form:select path="pojo.nguonvon.msnguonvon" cssClass="form-control select3 nohtml" data-trigger="focus">
                            <form:option value=""><fmt:message key="label.select" /> </form:option>
                            <form:options items="${nguonvons}" itemLabel="tennguonvon" itemValue="msnguonvon"/>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label class="col-sm-4 control-label"><fmt:message key="bid.pada.loaidautu"/></label>
                    <div class="col-sm-8">
                        <form:select path="pojo.loai.msloai" cssClass="form-control select3 nohtml" data-trigger="focus">
                            <form:option value=""><fmt:message key="label.select" /> </form:option>
                            <form:options items="${loais}" itemLabel="tenloai" itemValue="msloai"/>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label class="col-sm-4 control-label"><fmt:message key="bid.pada.department"/></label>
                    <div class="col-sm-8">
                        <form:select path="pojo.department.departmentId" cssClass="form-control select3 nohtml" data-trigger="focus">
                            <form:option value=""><fmt:message key="label.select" /> </form:option>
                            <form:options items="${departments}" itemLabel="name" itemValue="departmentId"/>
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
                        <form:select path="idChuTri" cssClass="form-control select3  nohtml" data-trigger="focus">
                            <form:option value=""><fmt:message key="label.select" /> </form:option>
                            <c:forEach items="${userXetThau}" var="xetThau">
                                <option <c:if test="${xetThau.userId eq item.idChuTri}">selected="true" </c:if> value="${xetThau.userId}" >
                                        ${xetThau.hoNhanVien} ${xetThau.tenNhanVien}
                                    <c:if test="${empty xetThau.hoNhanVien && empty xetThau.tenNhanVien}">
                                        ${xetThau.userName}
                                    </c:if>
                                    <c:if test="${not empty xetThau.chuyenNganh}">
                                        (${xetThau.chuyenNganh})
                                    </c:if>
                                </option>
                            </c:forEach>
                            <%--<form:options items="${userXetThau}" itemLabel="displayName" itemValue="userId"/>--%>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.tochuyengia.thanhvien"/></label>
                    <div class="col-sm-8">
                        <form:select path="idThanhVien" cssClass="form-control select3  nohtml" data-trigger="focus">
                            <form:option value=""><fmt:message key="label.select" /> </form:option>
                            <c:forEach items="${listNhanVien}" var="nhanVien">
                                <option <c:if test="${nhanVien.userId eq item.idThanhVien}">selected="true" </c:if> value="${nhanVien.userId}" >
                                        ${nhanVien.hoNhanVien} ${nhanVien.tenNhanVien}
                                    <c:if test="${empty nhanVien.hoNhanVien && empty nhanVien.tenNhanVien}">
                                        ${nhanVien.userName}
                                    </c:if>
                                    <c:if test="${not empty nhanVien.chuyenNganh}">
                                        (${nhanVien.chuyenNganh})
                                    </c:if>
                                </option>
                            </c:forEach>
                            <%--<form:options items="${userThamDinh}" itemLabel="displayName" itemValue="userId"/>--%>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.quimo"/></label>
                    <div class="col-sm-8">
                        <form:select path="pojo.quimo.msquimo" cssClass="form-control select3 nohtml" data-trigger="focus">
                            <form:option value=""><fmt:message key="label.select" /> </form:option>
                            <form:options items="${quimos}" itemLabel="tenquimo" itemValue="msquimo"/>
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
                        <form:input path="pojo.soqd" cssClass="form-control input-xs nohtml" data-trigger="focus" />
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.code"/></label>
                    <div class="col-sm-8">
                        <form:input path="pojo.magoithau" cssClass="form-control input-xs nohtml" data-trigger="focus" />
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.ten"/></label>
                    <div class="col-sm-8">
                        <form:input path="pojo.tengoithau" cssClass="form-control input-xs nohtml" data-trigger="focus" />
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
                            <span class="input-group-addon"> <fmt:message key="label.den"/> </span>
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
                        <form:select path="mapTinhTrangs" cssStyle="width: 100%;">
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
                        <form:select path="mapHinhThucs" cssStyle="width: 100%;">
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
<div id="content" class="box box-solid box-primary">
    <div class="box-header">
        <h3 class="box-title"><fmt:message key="contractor.list"/></h3>
    </div>
    <div class="box-body">
        <display:table name="items.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                       partialList="true" sort="external" size="${items.totalItems}" defaultsort="0"
                       id="tableList" pagesize="${Constants.MAXPAGEITEMS}" export="false" class="table table_vms table-bordered table-hover table-striped" style="margin: 1em 0 1.5em; width: 100%;">

            <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center" style="width: 1%;">
                ${tableList_rowNum + (page * Constants.MAXPAGEITEMS)}
            </display:column>
            <display:column headerClass="table_header_center" sortable="true" titleKey="bid.goithau.code" style="width: 1%;">
                <security:authorize ifAnyGranted="TP,ADMIN">
                    <a href="${editUrl}?pojo.msgoithau=${tableList.msgoithau}">
                </security:authorize>
                ${tableList.magoithau}
                <security:authorize ifAnyGranted="TP,ADMIN">
                    </a>
                </security:authorize>
            </display:column>
            <display:column headerClass="table_header_center nowrap" sortable="true" property="tengoithau" sortName="tengoithau" escapeXml="true" titleKey="bid.goithau.ten"  style="width: 38%;" />
            <display:column headerClass="table_header_center nowrap" sortable="true" property="nguonvon.tennguonvon" sortName="nguonvon.tennguonvon" escapeXml="true" titleKey="bid.pada.nguonvon"  style="width: 5%;" />
            <display:column headerClass="table_header_center nowrap" sortable="true" property="loai.tenloai" sortName="loai.tenloai" escapeXml="true" titleKey="bid.pada.loaidautu" style="width: 5%;" />
            <display:column headerClass="table_header_center nowrap" sortable="true" property="department.name" sortName="department.name" escapeXml="true" titleKey="bid.pada.department"  style="width: 5%;" />
            <display:column headerClass="table_header_center nowrap" sortable="true" property="hinhthucgt.tenhinhthuc" sortName="hinhthucgt.tenhinhthuc" escapeXml="true" titleKey="bid.pada.hinhthuc"  style="width: 5%;" />
            <display:column headerClass="table_header_center nowrap" sortable="true" titleKey="bid.hoso.tu" class="nowrap" style="width: 10%;">
                <c:set var="tu" value="" />
                <c:set var="msluutru" value="" />
                <c:if test="${tableList.hoSoLuuTrus ne null && fn:length(tableList.hoSoLuuTrus) > 0}">
                    <c:set var="tu" value="${tableList.hoSoLuuTrus[0].sotu}" />
                    <c:set var="msluutru" value="${tableList.hoSoLuuTrus[0].msluutru}" />
                </c:if>
                <input name="mapBidSave[${tableList.msgoithau}].sotu" class="form-control input-xs onlyNumberInput nohtml" value="${tu}"/>
                <input name="mapBidSave[${tableList.msgoithau}].msluutru" type="hidden" class="form-control input-xs onlyNumberInput nohtml" value="${msluutru}"/>
            </display:column>
            <display:column headerClass="table_header_center nowrap" sortable="true" titleKey="bid.hoso.ke" class="nowrap" style="width: 10%;">
                <c:set var="ke" value="" />
                <c:if test="${tableList.hoSoLuuTrus ne null && fn:length(tableList.hoSoLuuTrus) > 0}">
                    <c:set var="ke" value="${tableList.hoSoLuuTrus[0].soke}" />
                </c:if>
                <input name="mapBidSave[${tableList.msgoithau}].soke" class="form-control input-xs onlyNumberInput nohtml" value="${ke}"/>
            </display:column>
            <display:column headerClass="table_header_center nowrap" sortable="true" titleKey="bid.hoso.ghichu" class="nowrap" style="width: 20%;">
                <c:set var="ghichu" value="" />
                <c:if test="${tableList.hoSoLuuTrus ne null && fn:length(tableList.hoSoLuuTrus) > 0}">
                    <c:set var="ghichu" value="${tableList.hoSoLuuTrus[0].ghichu}" />
                </c:if>
                <input name="mapBidSave[${tableList.msgoithau}].ghichu" class="form-control input-xs nohtml" value="${ghichu}"/>
            </display:column>
            <display:setProperty name="paging.banner.item_name"><fmt:message key="contractor.title.management"/></display:setProperty>
            <display:setProperty name="paging.banner.items_name"><fmt:message key="contractor.title.management"/></display:setProperty>

        </display:table>
    </div>
</div>
</div>
</div>
<form:hidden path="crudaction" id="crudaction"/>
</section>
</form:form>
</div>
</div>
<script>
    $(document).ready(function(){
        setActiveMenu4Admin('#contractor_menu', '#hosolutru_menu');

        $(".deleteLink").click(function(){
            var id = $(this).attr("id");
            if (id != null && id != undefined){
                bootbox.confirm('<fmt:message key="database.delete.confirm.message.title"/>','<fmt:message key="bid.manager.form_delete_content"/>', function(r) {
                    if(r){
                        $("<input type='hidden' name='checkList' value='" + id + "'>").appendTo($("#listForm"));
                        $("#crudaction").val("delete");
                        $("#listForm").submit();
                    }
                });
            }
        });

        $("#btnFilter").click(function(){
            $("#listForm").submit();
        });
        $("#btnSave").click(function(){
            $("#crudaction").val("insert-update");
            $("#listForm").submit();
        });
        $("#btnExport").click(function(){
            $("#crudaction").val("export");
            $("#listForm").submit();
        });
        validateSelect2Select($('#mapTinhTrangs'));
        validateSelect2Select($('#mapHinhThucs'));

    });
</script>
</body>
</html>