<%--
  Created by IntelliJ IDEA.
  User: vovanphuc0810
  Date: 12/16/15
  Time: 1:42 PM
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
<c:url var="nhathauUrl" value="${prefix}/nhathau/nhathau.html"/>

<body>
<div class="content-wrapper" style="margin-left:0px!important">
    <form:form commandName="item" action="${nhathauUrl}" id="nhaThauForm" method="post" autocomplete="off" name="nhaThauForm" cssClass="form-horizontal">
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title"><fmt:message key="label.nhathau.goithau"/></h3>
                        </div>
                        <div class="box-body">
                            <div class="form-group">
                                <label class="control-label col-sm-2"><fmt:message key="label.nhathau.msthue"/></label>
                                <div class="col-sm-4">
                                    <form:input path="pojo.masothue" cssClass="form-control"/>
                                </div>
                                <label class="control-label col-sm-2"><fmt:message key="label.nhathau.ten"/></label>
                                <div class="col-sm-4">
                                    <form:input path="pojo.tennhathau" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-group text-center">
                                <a class="btn btn-primary btn-sm" id="btnFilter"><i class="fa fa-search"></i> <fmt:message key="label.search"/></a>
                                <a class="btn btn-primary btn-sm" id="btnReset"><i class="fa fa-refresh"></i> <fmt:message key="label.reset" /></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12">
                    <div id="content" class="box box-warning">
                        <div class="box-header with-border">
                            <h3 class="box-title"><fmt:message key="label.nhathau.list"/></h3>
                        </div>
                        <div class="box-body">
                            <div id="reportTableContainer" style="width: 100%;">
                                <display:table name="items.listResult" cellspacing="0" cellpadding="0" requestURI="${nhathauUrl}"
                                               partialList="true" sort="external" size="${items.totalItems}" defaultsort="0"
                                               id="tableList" pagesize="${Constants.MAXPAGEITEMS}" export="false" class="table table_vms table-bordered table-hover table-striped" style="margin: 1em 0 1.5em; width: 850px;">
                                    <display:column>
                                        <a href="javascript:void(0);" onclick="changeInforNhauThau('${tableList.msnhathau}','${tableList.tennhathau}','${tableList.masothue}','${tableList.diachi}','${tableList.dienthoai}','${tableList.fax}');" class="tip-top" title="<fmt:message key="label.choice" />"><i class="fa fa-globe"></i></a>
                                    </display:column>
                                    <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center" style="width: 5%;">
                                        ${tableList_rowNum + (page * Constants.MAXPAGEITEMS)}
                                    </display:column>
                                    <display:column headerClass="table_header_center" sortable="false" sortName="tennhathau" escapeXml="true" titleKey="label.nhathau.ten" class="nowrap" >
                                        <str:truncateNicely upper="25">${tableList.tennhathau}</str:truncateNicely>
                                    </display:column>
                                    <display:column headerClass="table_header_center nowrap" sortable="false" sortName="diachi" escapeXml="true" titleKey="label.nhathau.diachi" class="nowrap">
                                        <str:truncateNicely upper="25">${tableList.diachi}</str:truncateNicely>
                                    </display:column>
                                    <display:column headerClass="table_header_center" sortable="false" property="dienthoai" sortName="dienthoai" escapeXml="true" titleKey="label.nhathau.dienthoai" class="nowrap" />
                                    <display:column headerClass="table_header_center nowrap" sortable="false" property="fax" sortName="fax" escapeXml="true" titleKey="label.nhathau.fax" class="nowrap"/>
                                    <display:column headerClass="table_header_center nowrap" sortable="false" property="masothue" sortName="masothue" escapeXml="true" titleKey="label.nhathau.msthue" class="nowrap"/>


                                    <display:setProperty name="paging.banner.item_name"><fmt:message key="packageGroup.manager.packagegroup.item"/></display:setProperty>
                                    <display:setProperty name="paging.banner.items_name"><fmt:message key="packageGroup.manager.packagegroup.item"/></display:setProperty>
                                </display:table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <form:hidden path="crudaction" id="crudaction"/>
    </form:form>
</div>
<script type="text/javascript" src="<c:url value="/themes/vmsreport/plugins/CustomScrollbar/jquery.mCustomScrollbar.concat.min.js"/>"></script>

<script type="text/javascript">
    $(document).ready(function(){
        setActiveMenu4Admin('#nhathau_menu', '#danhsachnhathau_menu');
//        $("#btnReset").click(function () {
//            $("#maGoiThau").val("");
//            $("#tenGoiThau").val("")
//            $("#tenNhaThau").val("");
//            setSelectedValueForSelectMenu($("#ketQuaTrungThau"));
//        });

        $('#reportTableContainer').mCustomScrollbar({axis:"x"});
        checkMovePageLinks();
    });

    function checkMovePageLinks(){
        if(${not empty items.listResult}){
            $('#reportTableContainer .pagebanner').appendTo('#linksContainer');
            $('#reportTableContainer .pagelinks').appendTo('#linksContainer');
        }
    }

</script>
</body>
</html>
