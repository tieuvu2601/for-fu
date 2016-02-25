<%--
  Created by IntelliJ IDEA.
  User: vovanphuc0810
  Date: 12/10/15
  Time: 9:11 AM
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
<c:url var="formlUrl" value="${prefix}/nhathau/danhsachnhathau.html"/>
<c:url var="editUrl" value="${prefix}/nhathau/edit.html"/>
<c:url var="addUrl" value="${prefix}/nhathau/add.html"/>
<c:url var="ajaxUrl" value="/ajax/nhathau/listNhaThau.html"/>
<c:url var="capNhatGoiThauUrl" value="${prefix}/nhathau/capnhatnhathau.html"/>
<c:url var="hoSoUrl" value="/hosonhathau/edit.html"/>

<body>
<div class="content-wrapper">
    <div class="container">
        <form:form commandName="item" action="${formlUrl}" id="listForm" method="post" autocomplete="off" name="listForm" cssClass="form-horizontal">
            <section class="content-header">
                <ol class="breadcrumb">
                    <li><a href="${homeUrl}"><i class="fa fa-fw fa-home"></i>&nbsp;<fmt:message key="label.home.title"/></a></li>
                    <li><fmt:message key="menu.nhathau"/></li>
                    <li class="active"><fmt:message key="label.nhathau.list"/></li>
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
                                <h3 class="box-title"><fmt:message key="label.nhathau.goithau"/></h3>
                            </div>
                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><fmt:message key="label.nhathau.magoithau"/></label>
                                    <div class="col-sm-3">
                                        <input id="maGoiThau" name="pojo.goithau.magoithau" class="form-control input-xs" type="text" value="${item.pojo.goithau.magoithau}">
                                    </div>
                                    <label class="col-sm-2 control-label"><fmt:message key="label.nhathau.tengoithau"/></label>
                                    <div class="col-sm-4">
                                        <input id="tenGoiThau" name="pojo.goithau.tengoithau" class="form-control input-xs" type="text" value="${item.pojo.goithau.tengoithau}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><fmt:message key="label.nhathau.ketQuaTrungThau"/></label>
                                    <div class="col-sm-3">
                                        <form:select id="ketQuaTrungThau" path="pojo.istrungthau" cssClass="form-control">
                                            <form:option value=""><fmt:message key="label.select"/></form:option>
                                            <form:option value="${Constants.ACTIVE}"><fmt:message key="label.nhathau.trungthau"/></form:option>
                                            <form:option value="${Constants.INACTIVE}"><fmt:message key="label.nhathau.khongtrungthau"/></form:option>
                                        </form:select>
                                    </div>
                                    <label class="col-sm-2 control-label"><fmt:message key="label.nhathau.ten"/></label>
                                    <div class="col-sm-4">
                                        <input id="tenNhaThau" name="pojo.nhathau.tennhathau" class="form-control input-xs" type="text" value="${item.pojo.nhathau.tennhathau}">
                                    </div>
                                </div>
                                <div class="form-group text-center">
                                    <a class="btn btn-primary btn-sm" id="btnFilter"><i class="fa fa-search"></i> <fmt:message key="label.search"/></a>
                                    <a class="btn btn-primary btn-sm" href="${addUrl}"><i class="fa fa-fw fa-plus"></i> <fmt:message key="button.add" /></a>
                                    <a class="btn btn-primary btn-sm" id="deleteNhaThau" onclick="deleteNhaThau();"><i class="fa fa-times"></i> <fmt:message key="label.delete" /></a>
                                    <a class="btn btn-primary btn-sm" id="btnReset"><i class="fa fa-refresh"></i> <fmt:message key="label.reset" /></a>
                                    <a class="btn btn-primary btn-sm" id="btnExport"><i class="fa fa-file-excel-o"></i> <fmt:message key="label.export"/></a>
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
                                <table id="tableList" class="table table_vms table-bordered table-hover table-striped" data-page-size="${Constants.MAXPAGEITEMS}" data-size="${items.totalItems}"  style="margin-bottom: 15px;">
                                    <thead>
                                    <tr>

                                        <th class="table_header_center"><fmt:message key="label.stt"/></th>
                                        <th class="table_header_center"><fmt:message key="label.nhathau.ten"/> </th>
                                        <th class="table_header_center"><fmt:message key="label.nhathau.diachi"/> </th>
                                        <th class="table_header_center"><fmt:message key="label.nhathau.dienthoai"/> </th>
                                        <th class="table_header_center"><fmt:message key="label.nhathau.fax"/> </th>
                                        <th class="table_header_center"><fmt:message key="label.nhathau.ngaymuahs"/> </th>
                                        <th class="table_header_center"><fmt:message key="label.nhathau.ngaynophs"/> </th>
                                        <th class="table_header_center"><fmt:message key="label.nhathau.ketQuaTrungThau"/> </th>
                                        <th class="table_header_center"><fmt:message key="label.nhathau.hoso"/></th>
                                        <th class="table_header_center"><input data-switch-no-init type="checkbox" name="allCheck" id="allCheck" onclick="checkAll('listForm', 'checkList', this)"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="varMaGoiThauOld"/>
                                    <c:set var="stt" value="${1}"/>
                                    <c:forEach items="${items.listResult}" var="goithaunhathau" >
                                        <c:if test="${varMaGoiThauOld ne goithaunhathau.goithau.magoithau}">
                                            <tr>
                                                <td colspan="10">
                                                    <a href="${capNhatGoiThauUrl}?pojo.goithau.msgoithau=${goithaunhathau.goithau.msgoithau}">${goithaunhathau.goithau.tengoithau}</a>
                                                </td>
                                            </tr>
                                        </c:if>
                                        <tr id="collapse_${goithaunhathau.nhathau.msnhathau}" class="panel-collapse collapse in">
                                            <td>${stt}</td>
                                            <td>${goithaunhathau.nhathau.tennhathau}</td>
                                            <td>${goithaunhathau.nhathau.diachi}</td>
                                            <td>${goithaunhathau.nhathau.dienthoai}</td>
                                            <td>${goithaunhathau.nhathau.fax}</td>
                                            <td><fmt:formatDate value="${goithaunhathau.ngaymuahs}" pattern="${datePattern}"/></td>
                                            <td><fmt:formatDate value="${goithaunhathau.ngaynophs}" pattern="${datePattern}"/></td>
                                            <td class="text-center">
                                                <c:if test="${goithaunhathau.istrungthau eq 1}">
                                                    x
                                                </c:if>
                                            </td>
                                            <td class="text-center" ><a href="${hoSoUrl}?pojo.goithau_nhathau.msgoithauNt=${goithaunhathau.msgoithauNt}&pojo.goithau_nhathau.goithau.msgoithau=${goithaunhathau.goithau.msgoithau}" class="tip-top" title="<fmt:message key="label.nhathau.hoso" />"><i class="fa fa-archive"></i></a></td>
                                            <td class="text-center"><input data-switch-no-init type="checkbox" class="checkList" name="checkList"  value="${goithaunhathau.msgoithauNt}" onclick="checkAllIfOne('listForm', 'checkList', this, 'allCheck')"/></td>
                                        </tr>
                                        <c:set var="varMaGoiThauOld" value="${goithaunhathau.goithau.magoithau}"/>
                                        <c:set var="stt" value="${stt + 1}"/>
                                    </c:forEach>
                                    </tbody>
                                </table>

                                <display:table name="items.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                               partialList="true" sort="external" size="${items.totalItems}" defaultsort="0"
                                               id="tableList" pagesize="${Constants.MAXPAGEITEMS}" export="false" class="table table_vms table-bordered table-hover table-striped empty-table" style="margin: 1em 0 1.5em; width: 100%; display: none;">
                                    <display:column headerClass="table_header_center empty-header" titleKey="label.action" class="text-center" style="width:10%;"></display:column>
                                </display:table>

                                    <%--<div id="loadButton" class="loadButton"></div>--%>

                            </div>
                        </div>
                    </div>
                </div>
                <form:hidden path="crudaction" id="crudaction"/>
                <form:hidden path="page" id="page"/>
                <input type="hidden" value="${varMaGoiThauOld}" id="varMaGoiThauOld">
            </section>
        </form:form>
    </div>
</div>
<script type="text/javascript">
    var stt;
    $(document).ready(function(){
        setActiveMenu4Admin('#nhathau_menu', '#danhsachnhathau_menu');
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
            $("#maGoiThau").val("");
            $("#tenGoiThau").val("")
            $("#tenNhaThau").val("");
            setSelectedValueForSelectMenu($("#ketQuaTrungThau"));
        });

        var defaultBtnText = "";
        $.ajaxSetup({cache: false}); // disabling cache, omit if u dont need
        var buttonLoadingText = "<img src='<c:url value="/images/loader.gif"/>' alt='' /> Loading..";
//        $(document).scroll(function(){
//            if ($(window).scrollTop() + $(window).height() >= $(document).height())
//            {
//                if(!isSearchString){
//                    isSearchString = true;
//                    loadMore();
//                }
//            }
//        });

        function loadMore()
        {
            $("#loadButton").html(buttonLoadingText);
            if (stt === undefined){
                stt = '${stt}';
            }
            var page = eval($("#page").val()) + 1
                x = '',
                varMaGoiThauOld = '${varMaGoiThauOld}';

            $.ajax({
                url: '${ajaxUrl}?d-3677046-p=' + page + '&d-3677046-s=goithau.magoithau',
                type: 'POST',
                dataType: 'json',
                data: {page:page},
                success: function(data){
                    if(data.length > 0){
                        $.each(data, function (index, gtnt) {
                            if (gtnt.istrungthau == 1) {x = 'x'}
                            if(varMaGoiThauOld != gtnt.goithau.magoithau){
                                $("#tableList").append($('<tr/>')
                                        .append($('<td colspan="10"/>').html("<a href=\"${capNhatGoiThauUrl}?pojo.goithau.msgoithau="+ gtnt.goithau.msgoithau +"\">"+ gtnt.goithau.tengoithau +"</a>"))
                                );
                            }
                            $("#tableList").append($('<tr/>')
                                    .append($('<td/>').html(stt++))
                                    .append($('<td/>').html(gtnt.nhathau.tennhathau))
                                    .append($('<td/>').html(gtnt.nhathau.diachi))
                                    .append($('<td/>').html(gtnt.nhathau.dienthoai))
                                    .append($('<td/>').html(gtnt.nhathau.fax))
                                    .append($('<td/>').html(gtnt.strngaymuahs))
                                    .append($('<td/>').html(gtnt.strngaynophs))
                                    .append($('<td class="text-center"/>').html(x))
                                    .append($('<td class="text-center"/>').html("<a href=\"${editUrl}?pojo.msnhathau="+ gtnt.nhathau.msnhathau +"\" class=\"tip-top\" title=\"<fmt:message key="label.nhathau.hoso" />\"><i class=\"fa fa-archive\"></i></a>"))
                                    .append($('<td class="text-center"/>').html("<input data-switch-no-init type=\"checkbox\" class=\"checkList\" name=\"checkList\"  value=\""+ gtnt.msgoithauNt +"\" onclick=\"checkAllIfOne('listForm', 'checkList', this, 'allCheck')\"/>"))
                            );
                            varMaGoiThauOld = gtnt.goithau.magoithau;
                            isSearchString = false;
                        });
                        $('#page').val(page);
                    }
                    $("#loadButton").html(defaultBtnText);
                }
            });
        }
    });

    function deleteNhaThau()
    {
        bootbox.confirm('<fmt:message key="database.delete.confirm.message.title"/>','<fmt:message key="label.nhathau.delete.message"/>', function(r) {
            if(r){
                var flag = false;
                $(".checkList:checked").each(function(){
                    flag = true;
                });

                if(flag)
                {
                    $("#crudaction").val("delete");
                    $("#listForm").submit();
                }
            }
        });
    }
</script>
</body>
</html>