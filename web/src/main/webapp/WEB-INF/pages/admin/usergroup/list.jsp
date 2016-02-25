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
    <title><fmt:message key="usergroup.manager.title"/></title>
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
<c:url var="formlUrl" value="${prefix}/usergroup/list.html"/>
<c:url var="addUrl" value="${prefix}/usergroup/add.html"/>
<c:url var="editUrl" value="${prefix}/usergroup/edit.html"/>
<c:url var="roleUrl" value="${prefix}/usergroup/role.html"/>

<body>
<div class="content-wrapper">
    <form:form commandName="item" action="${formlUrl}" id="listForm" method="post" autocomplete="off" name="listForm" cssClass="form-horizontal">
        <section class="content-header">
            <ol class="breadcrumb">
                <li><a href="${dashboardUrl}"><i class="fa fa-home"></i>&nbsp;<fmt:message key="label.home.title"/></a></li>
                <li><fmt:message key="menu.administration"/></li>
                <li class="active"><fmt:message key="usergroup.manager"/></li>
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
                            <div class="pull-right box-tools">
                                <security:authorize ifAnyGranted = "ADMIN,MANAGE_USERGROUP_FULL,MANAGE_USERGROUP_ADD">
                                    <a class="btn btn-primary btn-sm daterange pull-right" href="${addUrl}"><i class="fa fa-fw fa-plus"></i> <fmt:message key="button.add"/></a>
                                </security:authorize>
                                <a class="btn btn-primary btn-sm pull-right" id="btn-filter"><i class="fa fa-search"></i> <fmt:message key="label.search"/></a>
                            </div>
                            <h3 class="box-title"><fmt:message key="usergroup.table.title"/></h3>

                            <div class="filter-form">
                                <div class="filter-content">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label"><fmt:message key="usergroup.manager.code"/></label>
                                        <div class="col-sm-8">
                                            <form:input path="pojo.code" cssClass="form-control"/>
                                            <spring:bind path="pojo.code">
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
                                        <label class="col-sm-3 control-label"><fmt:message key="usergroup.manager.name"/></label>
                                        <div class="col-sm-8">
                                            <form:input  path="pojo.name" cssClass="form-control"/>
                                        </div>
                                    </div>
                                    <div class="box-footer text-center">
                                        <a id="btnFilter" type="submit" class="btn btn-primary"><i class="fa fa-fw fa-search"></i><fmt:message key="label.search"/></a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="box-body">
                            <display:table name="items.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                           partialList="true" sort="external" size="${items.totalItems}" defaultsort="0"
                                           id="tableList" pagesize="${Constants.MAXPAGEITEMS}" export="false" class="table table_vms table-bordered table-hover table-striped" style="margin: 1em 0 1.5em; width: 100%;">
                                <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center" style="width: 5%;">${tableList_rowNum + (page * Constants.MAXPAGEITEMS)}</display:column>
                                <display:column headerClass="table_header nowrap" sortable="true" property="code" sortName="code" escapeXml="true" titleKey="usergroup.manager.code" class="nowrap" style="width: 20%;" />
                                <display:column headerClass="table_header nowrap" sortable="true" property="name" sortName="name" escapeXml="true" titleKey="usergroup.manager.name" class="nowrap" style="width: 35%;" />
                                <display:column headerClass="table_header_center nowrap" titleKey="label.action" class="text-center" style="width:10%;">
                                    <c:if test="${tableList.code ne Constants.ADMIN_ROLE}">
                                        <c:set var="linkCounter" value="1" />
                                        <security:authorize ifAnyGranted = "ADMIN,MANAGE_USERGROUP_PERMISSION,MANAGE_USERGROUP_FULL">
                                            <c:set var="linkCounter" value="${linkCounter + 1}" />
                                            <a href="${roleUrl}?pojo.userGroup.userGroupId=${tableList.userGroupId}" class="tip-top" title="<fmt:message key ="label.authorize"/>"><i class="fa fa-key"></i></a>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted = "ADMIN,MANAGE_USERGROUP_EDIT,MANAGE_USERGROUP_FULL">
                                            <c:set var="linkCounter" value="${linkCounter + 1}" />
                                            <c:if test="${linkCounter gt 1}">
                                                &nbsp;|&nbsp;
                                            </c:if>
                                            <a href="${editUrl}?pojo.userGroupId=${tableList.userGroupId}" class="tip-top" title="<fmt:message key="label.edit"/>"><i class="fa fa-pencil-square-o"></i></a>
                                        </security:authorize>
                                    </c:if>
                                </display:column>
                                <display:setProperty name="paging.banner.item_name"><fmt:message key="usergroup.manager.usergroup"/></display:setProperty>
                                <display:setProperty name="paging.banner.items_name"><fmt:message key="usergroup.manager.usergroup"/></display:setProperty>
                            </display:table>
                        </div>
                    </div>
                </div>
            </div>
            <form:hidden path="crudaction" id="crudaction"/>
    </form:form>
    </section>
</div>
<script>
    $(document).ready(function(){
        // active tab
        setActiveMenu4Admin('#administration_menu', '#usergroup_menu');

        $("#btnFilter").click(function(){
            $("#crudaction").val("");
            $("#listForm").submit();
        });

        $('body').click(function() {
            $('.filter-form').hide();
        });

        $('.filter-form').click(function(){
            event.stopPropagation();
        });

        $('#btn-filter').click(function(){
            event.stopPropagation();
            if($('.filter-form').is(":visible")){
                $('.filter-form').hide();
            } else {
                $('.filter-form').show();
            }

        });
    });

</script>
</body>
</html>