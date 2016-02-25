<%--
  Created by IntelliJ IDEA.
  User: Huy
  Date: 9/25/15
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="hinhthuc.manager.title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>
        .bootbox.modal{
            max-height: 190px;
        }
    </style>
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin" />
</security:authorize>
<c:url var="dashboardUrl" value="/home.html"/>
<c:url var="formlUrl" value="${prefix}/hinhthuc/list.html"/>
<c:url var="addUrl" value="${prefix}/hinhthuc/add.html"/>
<c:url var="editUrl" value="${prefix}/hinhthuc/edit.html"/>

<body>
<div class="content-wrapper">
    <div class="container">
        <form:form commandName="item" action="${formlUrl}" id="listForm" method="post" autocomplete="off" name="listForm" cssClass="form-horizontal">
            <section class="content-header">
                <h4>
                    <fmt:message key="hinhthuc.manager"/>
                        <%--<small><fmt:message key="user.manager.list"/></small>--%>
                </h4>
                <ol class="breadcrumb">
                    <li><a href="${dashboardUrl}"><i class="fa fa-home"></i>&nbsp;<fmt:message key="label.home.title"/></a></li>
                    <li class="active"><fmt:message key="hinhthuc.manager"/></li>
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
                                <h3 class="box-title"><fmt:message key="hinhthuc.table.title"/></h3>
                                <div class="filter-group">
                                    <div class="btn-filter filter">
                                        <i class="fa fa-search"></i>&nbsp;<fmt:message key="label.search"/>
                                    </div>
                                    <div class="filter-form">
                                        <div class="filter-content">
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label"><fmt:message key="hinhthuc.manager.mahinhthuc"/></label>
                                                <div class="col-sm-8">
                                                    <form:input path="pojo.mahinhthuc" cssClass="form-control input-xs"/>
                                                    <spring:bind path="pojo.mahinhthuc">
                                                        <c:if test="${status.error}">
                                                            <div class="tooltip fade top in" onclick="javascript: $(this).remove();" style="display: block; top: -37px; left: 80px;">
                                                                <div class="tooltip-arrow"></div>
                                                                <div class="tooltip-inner">${status.errorMessage}</div>
                                                            </div>
                                                        </c:if>
                                                    </spring:bind>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label"><fmt:message key="hinhthuc.manager.tenhinhthuc"/></label>
                                                <div class="col-sm-8">
                                                    <form:input  path="pojo.tenhinhthuc" cssClass="form-control input-xs"/>
                                                </div>
                                            </div>
                                            <div class="box-footer text-center">
                                                <a id="btnFilter" type="submit" class="btn btn-sm btn-primary"><i class="fa fa-fw fa-search"></i><fmt:message key="label.search"/></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="box-body">
                                <security:authorize ifAnyGranted = "ADMIN">
                                    <div class="form-actions text-right">
                                        <a class="btn btn-sm btn-primary" href="${addUrl}"><i class="fa fa-fw fa-plus"></i> <fmt:message key="button.add"/></a>
                                    </div>
                                </security:authorize>

                                <display:table name="items.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                               partialList="true" sort="external" size="${items.totalItems}" defaultsort="0"
                                               id="tableList" pagesize="${Constants.MAXPAGEITEMS}" export="false" class="table table_vms table-bordered table-hover table-striped" style="margin: 1em 0 1.5em; width: 100%;">
                                    <display:column headerClass="table_header nowrap" sortable="true" property="stt" sortName="stt" escapeXml="true" titleKey="label.stt" class="text-center" style="width: 5%;" />
                                    <display:column headerClass="table_header nowrap" sortable="true" property="mahinhthuc" sortName="mahinhthuc" escapeXml="true" titleKey="hinhthuc.manager.mahinhthuc" class="nowrap" style="width: 20%;" />
                                    <display:column headerClass="table_header nowrap" sortable="true" property="tenhinhthuc" sortName="tenhinhthuc" escapeXml="true" titleKey="hinhthuc.manager.tenhinhthuc" class="nowrap" style="width: 35%;" />
                                    <%--<display:column headerClass="table_header nowrap" sortable="true" escapeXml="true" titleKey="hinhthuc.manager.giatri" class="nowrap" style="width: 35%;">--%>
                                        <%--<fmt:formatNumber var="fromValueLabel" value="${tableList.fromValue}" pattern="###,###" />--%>
                                        <%--<fmt:formatNumber var="toValueLabel" value="${tableList.toValue}" pattern="###,###" />--%>

                                        <%--${fromValueLabel} <fmt:message key="hinhthuc.manager.value.to"/> ${toValueLabel}--%>
                                    <%--</display:column>--%>
                                    <display:column headerClass="table_header_center nowrap" titleKey="label.action" class="text-center" style="width:10%;">
                                        <a href="${editUrl}?pojo.mshinhthuc=${tableList.mshinhthuc}" class="tip-top" title="<fmt:message key="label.edit"/>"><i class="fa fa-pencil-square-o"></i></a> |
                                        <a class="tip-top deleteLink" onclick="javascript: deleteItems(${tableList.mshinhthuc});" title="<fmt:message key="label.delete" />"><i class="fa fa-times"></i></a>
                                    </display:column>
                                    <display:setProperty name="paging.banner.item_name"><fmt:message key="hinhthuc.manager.hinhthuc"/></display:setProperty>
                                    <display:setProperty name="paging.banner.items_name"><fmt:message key="hinhthuc.manager.hinhthuc"/></display:setProperty>
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
        // active tab
        setActiveMenu4Admin('#Category_menu', '#hinhthuc_menu');

        $("#btnFilter").click(function(){
            $("#crudaction").val("");
            $("#listForm").submit();
        });
    });

    function deleteItems(mshinhthuc){
        bootbox.confirm('<fmt:message key="database.delete.confirm.message.title"/>','<fmt:message key="database.delete.confirm.message.content"/>', function(r) {
            if(r){
                $('#listForm').append($('<input type="hidden" name="checkList" class="minimal" value="'+ mshinhthuc +'"/>'));
                $("#crudaction").val("delete");
                $("#listForm").submit();
            }
        });
    }

</script>
</body>
</html>