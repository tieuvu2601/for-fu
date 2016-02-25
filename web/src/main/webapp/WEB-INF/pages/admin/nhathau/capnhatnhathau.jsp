<%--
  Created by IntelliJ IDEA.
  User: vovanphuc0810
  Date: 12/8/15
  Time: 2:03 PM
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
    <style>
        .modal-dialogBid {
            width: 90%;
        }
    </style>
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin"/>
</security:authorize>

<c:url var="homeUrl" value="/index.html"/>
<c:url var="backUrl" value="${prefix}/index.html"/>
<c:url var="formlUrl" value="${prefix}/nhathau/capnhatnhathau.html?pojo.goithau.msgoithau=${item.pojo.goithau.msgoithau}"/>
<c:url var="editUrl" value="${prefix}/nhathau/edit.html"/>
<c:url var="addUrl" value="${prefix}/nhathau/add.html"/>
<c:url var="listNhaThauUrl" value="${prefix}/nhathau/danhsachnhathau.html"/>
<c:url var="listGoiThauUrl" value="${prefix}/goithau/list.html"/>
<c:url var="hoSoUrl" value="/hosonhathau/edit.html?pojo.goithau_nhathau.goithau.msgoithau=${item.pojo.goithau.msgoithau}"/>
<body>
<div class="content-wrapper">
    <div class="container">
        <form:form commandName="item" action="${formlUrl}" id="listForm" method="post" autocomplete="off" name="listForm" cssClass="form-horizontal">
            <section class="content-header">
                <h4>
                    <fmt:message key="menu.nhathau.capnhatnhathau"/>
                        <%--<small><fmt:message key="user.manager.list"/></small>--%>
                </h4>
                <ol class="breadcrumb">
                    <li><a href="${homeUrl}"><i class="fa fa-fw fa-home"></i>&nbsp;<fmt:message key="label.home.title"/></a></li>
                    <li><fmt:message key="menu.nhathau"/></li>
                    <li class="active"><fmt:message key="menu.nhathau.capnhatnhathau"/></li>
                </ol>
                <div id="alert-message"></div>
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
                                <h3 class="box-title"><fmt:message key="label.nhathau.goithau"/></h3>
                            </div>
                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><fmt:message key="label.nhathau.goithau"/></label>
                                    <div class="col-sm-9">
                                        <div class="input-group input-group-xs">
                                            <input id="msgoithau" name="pojo.goithau.msgoithau" class="form-control input-xs" readonly="readonly" type="text" value="${item.pojo.goithau.tengoithau}" onclick="listenForGetGoiThau()">
                                            <span class="input-group-btn">
                                                 <a onclick="listenForGetGoiThau()" href="javascript: void(0);"  class="btn btn-info" title="<fmt:message key="tiendo.label.chongoithau" />">
                                                     <i class="fa fa-search"></i>
                                                 </a>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><fmt:message key="label.nhathau.tenPADA"/></label>
                                    <div class="col-sm-9">
                                        <input id="goiThauPADA" name="pojo.goithau.tenpada" class="form-control input-xs" readonly="readonly" type="text" value="${item.pojo.goithau.tenpada}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12">
                        <div id="content" class="box box-solid box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title"><fmt:message key="label.nhathau.list"/></h3>
                            </div>

                            <div class="box-body">

                                <display:table name="items.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                               partialList="true" sort="external" size="${fn:length(items.listResult)}" defaultsort="0"
                                               id="tableList" pagesize="${fn:length(items.listResult)}" export="false" class="table table_vms table-bordered table-hover table-striped" style="margin: 1em 0 1.5em; width: 100%;">

                                    <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center">
                                        ${tableList_rowNum + (page * Constants.MAXPAGEITEMS)}
                                    </display:column>
                                    <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.nhathau.ten" class="nowrap" style="width:20%;">
                                        <input class="id_msNhaThau" type="hidden" name="lazyList[${tableList_rowNum + (page * Constants.MAXPAGEITEMS) - 1}].nhathau.msnhathau" value="${tableList.nhathau.msnhathau}">
                                        <div class="input-group input-group-xs">
                                            <input name="lazyList[${tableList_rowNum + (page * Constants.MAXPAGEITEMS) - 1}].tennhathau" value="${tableList.nhathau.tennhathau}" class="form-control input-xs">
                                        <span class="input-group-btn">
                                               <a class="btn btn-primary btn-xs" href="javascript:void(0);" onclick="chooseContractors(this);" >...</a>
                                        </span>
                                        </div>
                                    </display:column>
                                    <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.nhathau.masothue" class="nowrap">
                                        <input name="lazyList[${tableList_rowNum + (page * Constants.MAXPAGEITEMS) - 1}].nhathau.masothue" value="${tableList.nhathau.masothue}" class="form-control input-xs required">
                                    </display:column>
                                    <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.nhathau.diachi" class="nowrap">
                                        <input name="lazyList[${tableList_rowNum + (page * Constants.MAXPAGEITEMS) - 1}].diachi" value="${tableList.nhathau.diachi}" class="form-control input-xs">
                                    </display:column>
                                    <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.nhathau.dienthoai" class="nowrap" >
                                        <input name="lazyList[${tableList_rowNum + (page * Constants.MAXPAGEITEMS) - 1}].dienthoai" value="${tableList.nhathau.dienthoai}" class="form-control input-xs">
                                    </display:column>
                                    <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.nhathau.fax" class="nowrap" >
                                        <input name="lazyList[${tableList_rowNum + (page * Constants.MAXPAGEITEMS) - 1}].fax" value="${tableList.nhathau.fax}" class="form-control input-xs">
                                    </display:column>
                                    <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.nhathau.ngaymuahs" class="nowrap">
                                        <input id="ngaymuahs_${tableList.nhathau.msnhathau}" name="lazyList[${tableList_rowNum + (page * Constants.MAXPAGEITEMS) - 1}].ngaymuahs" type="text" value="<fmt:formatDate value="${tableList.ngaymuahs}" pattern="${datePattern}"/>" class="form-control input-xs datePlaceHolder datepicker nohtml">
                                    </display:column>
                                    <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.nhathau.ngaynophs" class="nowrap">
                                        <input id="ngaynophs_${tableList.nhathau.msnhathau}" name="lazyList[${tableList_rowNum + (page * Constants.MAXPAGEITEMS) - 1}].ngaynophs" type="text" value="<fmt:formatDate value="${tableList.ngaynophs}" pattern="${datePattern}"/>" class="form-control input-xs datePlaceHolder datepicker nohtml">
                                    </display:column>
                                    <display:column  title="<input data-switch-no-init type=\"checkbox\" name=\"allCheck\" id=\"allCheck\" onclick=\"checkAll('listForm', 'checkList', this)\" >" >
                                        <input data-switch-no-init type="checkbox" name="checkList" class="checkList"  value="${tableList.msgoithauNt}" onclick="checkAllIfOne('listForm', 'checkList', this, 'allCheck')"/>
                                        <input class="id_msgoithauNt" type="hidden" name="lazyList[${tableList_rowNum + (page * Constants.MAXPAGEITEMS) - 1}].msgoithauNt" value="${tableList.msgoithauNt}">
                                    </display:column>

                                    <display:setProperty name="paging.banner.item_name"><fmt:message key="label.nhathau"/></display:setProperty>
                                    <display:setProperty name="paging.banner.items_name"><fmt:message key="label.nhathau"/></display:setProperty>
                                </display:table>
                                <div class="form-actions text-right">
                                    <c:if test="${not empty item.pojo.goithau.msgoithau}">
                                        <a class="btn btn-primary btn-xs" onclick="addConstructorRow()"><i class="fa fa-fw fa-plus"></i> <fmt:message key="button.add"/></a>
                                        <a class="btn btn-primary btn-xs removeRow"><i class="fa fa-times"></i> <fmt:message key="label.delete" /></a>
                                    </c:if>
                                </div>

                                <div class="form-actions text-center">
                                    <c:if test="${not empty item.pojo.goithau.msgoithau}">
                                        <a class="btn btn-primary btn-sm" id="btnSave"><i class="fa fa-fw fa-plus"></i> <fmt:message key="button.nhathau.luu"/></a>
                                    </c:if>
                                    <a class="btn btn-primary btn-sm" href="${hoSoUrl}"><i class="fa fa-file"></i> <fmt:message key="button.nhathau.hoso" /></a>
                                    <a class="btn btn-primary btn-sm" href="${listNhaThauUrl}"><i class="fa fa-home"></i> <fmt:message key="button.nhathau.danhsach" /></a>
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
<div class="modal fade" id="getCodeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div id="getCode"></div>
        </div>
    </div>
</div>
<div class="modal fade bvModel" role="dialog" id="addModel"></div>
<script type="text/javascript">
    var mapConstructorRowIndex = new Array(),
        arrLazyList = $("#tableList").find("tr").length,
        newRowConstructor;
    $(document).ready(function(){
        setActiveMenu4Admin('#nhathau_menu', '#capnhatnhathau_menu');
        <c:forEach items="${items.listResult}" var="gtnt">
            mapConstructorRowIndex.push('${gtnt.nhathau.msnhathau}');
        </c:forEach>

        $("#btnFilter").click(function(){
            $("#crudaction").val("");
            $("#listForm").submit();
        });
        $("#btnSave").click(function(){
            $("#crudaction").val("insert-update");
            $("#listForm").submit();
        });
        $(".removeRow").click(function(){
            var pagelinks = $('.pagelinks').parents('p');
            if(typeof pagelinks != undefined && pagelinks != ''){
                pagelinks.remove();
            }
            $(".checkList:checked").each(function(){
                var rowNum = eval($.trim($(this).parents('tr').find('td:first').html()));
                mapConstructorRowIndex.splice(rowNum - 1, 1);
                var id_nt = $(this).closest("tr").find(".id_msgoithauNt").val();
                if(id_nt != undefined && id_nt != ''){
                    $(this).closest("#tableList").append('<input name="deleteList" type="hidden" value="'+id_nt+'"/>');
                }
                $(this).parents("tr").remove();
            });
            sortSTT();
        });
    });

    function addConstructorRow(){
        var  empty = $('.empty').html();
        if(typeof empty != undefined && empty != ''){
            $('.empty').remove();
        }
        var rowNum = $("#tableList").find("tr").length,
            pagelinks = $('.pagelinks').parents('p');
        if(typeof pagelinks != undefined && pagelinks != ''){
            pagelinks.remove();
        }

        $('#tableList').append($('<tr/>')
                .append($('<td class="text-center"/>').html(rowNum))
                .append('<input type="hidden" name="lazyList['+arrLazyList+'].nhathau.msnhathau" type="text" class="form-control input-xs nohtml">')
                .append($('<td style="width:20%;"/>').append($('<div class="input-group"/>')
                        .html($('<input name="lazyList['+arrLazyList+'].tennhathau" type="text" class="form-control input-xs nohtml"/>'))
                        .append($('<span class="input-group-btn"/>')
                                .html('<a class="btn btn-primary btn-xs" href="javascript:void(0);" onclick="chooseContractors(this);" >...</a>'))))
                .append($('<td/>').html('<input name="lazyList['+arrLazyList+'].nhathau.masothue" type="text" class="form-control input-xs nohtml required">'))
                .append($('<td/>').html('<input name="lazyList['+arrLazyList+'].diachi" type="text" class="form-control input-xs nohtml">'))
                .append($('<td/>').html('<input name="lazyList['+arrLazyList+'].dienthoai" type="text" class="form-control input-xs nohtml">'))
                .append($('<td/>').html('<input name="lazyList['+arrLazyList+'].fax" type="text" class="form-control input-xs nohtml">'))
                .append($('<td/>').html('<input name="lazyList['+arrLazyList+'].ngaymuahs" type="text" class="form-control input-xs datePlaceHolder datepicker nohtml">'))
                .append($('<td/>').html('<input name="lazyList['+arrLazyList+'].ngaynophs" type="text" class="form-control input-xs datePlaceHolder datepicker nohtml">'))
                .append($('<td/>').html('<input data-switch-no-init type="checkbox" name="checkList" class="checkList"  value="${tableList.msgoithauNt}"/>'))
        );
        initPlugin4Row(arrLazyList);
        arrLazyList ++;
    }

    function sortSTT(){
        var stt = 0,
            selectStartId;
        $('#tableList').find('tr').each(function(e){
            $(this).find('td:first').html(stt++);
        });
    }

    function changeInforNhauThau(constructorId, constructorName, constructorThue, constructorAddress, constructorPhone, constructorfax) {
        var rowNum = eval($.trim(newRowConstructor.find('td:first').text())),
            isExisted = false;
        if(constructorId.trim() != ''){
            $.each(mapConstructorRowIndex, function (index, constructorIdInMap) {
                if (typeof constructorIdInMap != 'undefined' && constructorIdInMap === constructorId) {
                    isExisted = true;
                }
            });
            if (isExisted) {
                alert("<fmt:message key="label.nhathau.duplicated"/>");
            } else{
                $(newRowConstructor).find('input').eq(0).val(constructorId);
                $(newRowConstructor).find('input').eq(1).val(constructorName);
                $(newRowConstructor).find('input').eq(2).val(constructorThue);
                $(newRowConstructor).find('input').eq(3).val(constructorAddress);
                $(newRowConstructor).find('input').eq(4).val(constructorPhone);
                $(newRowConstructor).find('input').eq(5).val(constructorfax);
                $(newRowConstructor).find('input').eq(6).val('');
                $(newRowConstructor).find('input').eq(7).val('');

                mapConstructorRowIndex.splice(rowNum - 1, 1);
                mapConstructorRowIndex.push(rowNum);
                jQuery("#getCodeModal").modal('hide');

            }
        }
    }

    function initPlugin4Row(rowNum){
        $('.datePlaceHolder').inputmask("dd/mm/yyyy", {placeholder: "__/__/____"});
        initDateTimePicker();
    }

    function chooseContractors(e){
        var url = '<c:url value="/ajax/NhaThau/danhSachNhaThau.html"/>';
        newRowConstructor = $(e).parents("tr");
        $.ajax({
            dataType : "html",
            url : url,
            data : {},
            success:function(data){
                var error = data.error;
                if (error != null) {
                    alert(error);
                }else if (data != null) {
                    $("#getCode").html(data);
                    jQuery("#getCodeModal").modal('show');
                    registerSubmitPopup();
                }
            },
            error:function(e){
            }
        });
    }

    function registerSubmitPopup(){
        var page = 1;
        $("#nhaThauForm #btnFilter").click(function(){
            $("#nhaThauForm").submit();
        });

        $(".pagelinks a").click(function(){
            page = parseInt(this.href.split('?')[1].split('p=')[1].charAt(0));
            $("#nhaThauForm").submit();
            return false;
        });

        $("#nhaThauForm").submit(function(e){
            e.preventDefault();
            var formData = new FormData($(this)[0]);
            formData.append('page', page);
            var url = '<c:url value="/ajax/NhaThau/danhSachNhaThau.html"/>?d-3677046-p='+page;
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
                        $("#getCode").html(data);
                        registerSubmitPopup();
                        $('.pagelinks a').each(function(e){
                            var index = parseInt(this.href.split('?')[1].split('p=')[1].charAt(0));
                            if(index == page){
                                $(this).css("cssText", "font-size : 25px");
                            }
                        });
                    }
                },
                error:function(e){
                }
            });
            return false;
        });
    }

    function listenForGetGoiThau(){
        var $modal = $('#addModel');
        $modal.load('<c:url value="/ajax/admin/goithau/list.html"/>', {'_': new Date().getTime()}, function(){
            $modal.modal();
            registerSubmitPopup1();
        });
    }

    function registerSubmitPopup1(){
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
                        registerSubmitPopup1();
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
        $('#listForm').attr('action', '${formUrl}?pojo.goithau.msgoithau=' + msGoiThau);
        $("#listForm").submit();
        e.preventDefault();
    }
</script>
</body>
</html>