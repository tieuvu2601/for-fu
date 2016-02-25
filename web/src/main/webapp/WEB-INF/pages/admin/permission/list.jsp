<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="permission.manager"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<c:url var="dashboardUrl" value="/admin/index.html"/>
<c:url var="formlUrl" value="/admin/permission/list.html"/>
<c:url var="editUrl" value="/admin/permission/edit.html"/>
<c:url var="addUrl" value="/admin/permission/add.html"/>
<c:url var="backUrl" value="/admin/index.html"/>
<body>
<div class="content-wrapper">
<form:form commandName="items" action="${formlUrl}" id="listForm" method="post" autocomplete="off" name="listForm" cssClass="form-horizontal">
    <section class="content-header">
        <c:if test="${not empty messageResponse}">
            <div class="alert alert-message alert-${alertType}">
                <a class="close" data-dismiss="alert" href="#">&times;</a> ${messageResponse}
            </div>
        </c:if>
    </section>

    <section class="content-header">
        <h1><fmt:message key="permission.manager"/></h1>
        <ol class="breadcrumb">
            <li><a href="${dashboardUrl}"><i class="fa fa-dashboard"></i> <fmt:message key="home.title"/></a></li>
            <li class="active"><fmt:message key="permission.manager"/></li>
        </ol>
    </section>

    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box box-solid box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title"><fmt:message key="label.filter"/></h3>
                    </div>
                    <div class="box-body">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="col-sm-5 control-label"><fmt:message key="permission.manager.code"/></label>
                                <div class="col-sm-7">
                                    <form:input path="pojo.code" cssClass="form-control"/>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="col-sm-5 control-label"><fmt:message key="permission.manager.featuregroup"/></label>
                                <div class="col-sm-7">
                                    <form:select path="pojo.featureGroup.featureGroupId" cssClass="form-control">
                                        <form:option value=""><fmt:message key="label.select"/></form:option>
                                        <form:options items="${featureGroups}" itemLabel="name" itemValue="featureGroupId"/>
                                    </form:select>
                                    <form:errors path="pojo.featureGroup.featureGroupId" cssClass="error-inline-validate"/>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="col-sm-5 control-label"><fmt:message key="permission.manager.name"/></label>
                                <div class="col-sm-7">
                                    <form:input  path="pojo.name" cssClass="form-control"/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="box-footer text-center">
                        <a id="btnFilter" type="submit" class="btn btn-primary"><i class="fa fa-fw fa-search"></i><fmt:message key="label.search"/></a>
                    </div>
                </div>

                <div class="box box-solid box-primary">
                    <div class="box-header">
                        <h3 class="box-title"><fmt:message key="permission.manager.list"/></h3>
                        <div class="form-actions text-right">
                            <a class="btn btn-primary" href="${editUrl}"><i class="fa fa-fw fa-plus"></i> <fmt:message key="button.add"/></a>
                            <a class="btn" href="${backUrl}" class="cancel-link"><fmt:message key="button.back"/></a>
                        </div>
                    </div>

                    <div class="box-body">
                        <display:table name="items.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                       partialList="true" sort="external" size="${items.totalItems}" defaultsort="0"
                                       id="tableList" pagesize="${items.maxPageItems}" export="false" class="table table_permission table-bordered table-hover table-striped" style="margin: 1em 0 1.5em; width: 100%;">
                            <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center" style="width: 5%;">${tableList_rowNum + (page * Constants.MAXPAGEITEMS)}</display:column>
                            <display:column headerClass="table_header_center nowrap" sortable="true" property="code" sortName="code" escapeXml="true" titleKey="permission.manager.code" class="nowrap" style="width: 25%;" />
                            <display:column headerClass="table_header_center nowrap" sortable="true" property="name" sortName="name" escapeXml="true" titleKey="permission.manager.name" class="nowrap" style="width: 30%;" />
                            <display:column headerClass="table_header_center nowrap" sortable="true" property="featureGroup.name" sortName="featureGroup.name" escapeXml="true" titleKey="permission.manager.featuregroup" class="nowrap" style="width: 30%;" />
                            <display:column headerClass="table_header_center nowrap" titleKey="label.action" class="text-center" style="width:10%;">
                                <a href="${editUrl}?pojo.permissionId=${tableList.permissionId}" class="tip-top"><i class="fa fa-pencil-square-o"></i></a> |
                                <a class="tip-top deleteLink" id="${tableList.permissionId}"><i class="fa fa-times"></i></a>
                            </display:column>
                            <display:setProperty name="paging.banner.item_name"><fmt:message key="permission.manager.title"/></display:setProperty>
                            <display:setProperty name="paging.banner.items_name"><fmt:message key="permission.manager.title"/></display:setProperty>
                        </display:table>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <form:hidden path="crudaction" id="crudaction"/>
</form:form>
    </div>
<script>
    $(document).ready(function(){
        setActiveMenu4Admin('#adminManagerTab', '#permissionManagerTab');

        $(".deleteLink").click(function(){
            var id = $(this).attr("id");
            if (id != null && id != undefined){
                bootbox.confirm('<fmt:message key="delete.confirm.message.content"/>', function(r) {
                    if(r){
                        $("<input type='hidden' name='checkList' value='" + id + "'>").appendTo($("#listForm"));
                        $("#crudaction").val("delete");
                        $("#listForm").submit();
                    }
                });
            }
        });

        $("#btnFilter").click(function(){
            $("#crudaction").val("");
            $("#listForm").submit();
        });
    });
</script>
</body>
</html>