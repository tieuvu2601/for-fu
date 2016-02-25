<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="team.manager.title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .bootbox.modal.fade.in {
            max-height: 210px;
        }
    </style>
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin" />
</security:authorize>
<c:url var="dashboardUrl" value="/home.html"/>
<c:url var="formlUrl" value="${prefix}/team/list.html"/>
<c:url var="editUrl" value="${prefix}/team/edit.html"/>
<c:url var="addUrl" value="${prefix}/team/add.html"/>
<c:url var="backUrl" value="${prefix}/index.html"/>
<c:url var="districtUrl" value="${prefix}/team/listdistrict.html"/>
<c:url var="employeeUrl" value="${prefix}/team/empcodelist.html"/>

<body>
<div class="content-wrapper">
    <form:form commandName="item" action="${formlUrl}" id="listForm" method="post" autocomplete="off" name="listForm" cssClass="form-horizontal">
        <section class="content-header">
            <ol class="breadcrumb">
                <li><a href="${dashboardUrl}"><i class="fa fa-home"></i>&nbsp;<fmt:message key="label.home.title"/></a></li>
                <li class="active"><fmt:message key="team.table.title"/></li>
            </ol>
            <c:if test="${not empty messageResponse}">
                <div class="clear"></div>
                <div class="alert alert-message alert-${alertType}">
                    <a class="close" data-dismiss="alert" href="#">&times;</a> ${messageResponse}
                </div>
            </c:if>
        </section>

        <section class="content">
            <div class="row ">
                <div class="col-xs-12">

                    <div class="box box-solid box-primary">
                        <div class="box-header">
                            <h3 class="box-title"><fmt:message key="team.table.title"/></h3>
                            <div class="filter-group">
                                <div class="btn-filter filter">
                                    <i class="fa fa-search"></i>&nbsp;<fmt:message key="label.search"/>
                                </div>

                                <div class="filter-form">
                                    <div class="filter-content">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label"><fmt:message key="team.manager.code"/></label>
                                            <div class="col-sm-8">
                                                <form:input path="pojo.teamCode" cssClass="form-control"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label"><fmt:message key="team.manager.name"/></label>
                                            <div class="col-sm-8">
                                                <form:input  path="pojo.teamName" cssClass="form-control"/>
                                            </div>
                                        </div>
                                        <div class="box-footer text-center">
                                            <a id="btnFilter" type="submit" class="btn btn-primary"><i class="fa fa-fw fa-search"></i><fmt:message key="label.search"/></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="box-body">
                            <security:authorize ifAnyGranted = "ADMIN,MANAGE_TEAM_FULL,MANAGE_TEAM_ADD">
                                <div class="form-actions text-right">
                                    <a class="btn btn-primary" href="${addUrl}"><i class="fa fa-fw fa-plus"></i> <fmt:message key="button.add"/></a>
                                </div>
                            </security:authorize>
                            <display:table name="items.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                           partialList="true" sort="external" size="${items.totalItems}" defaultsort="0"
                                           id="tableList" pagesize="${Constants.MAXPAGEITEMS}" export="false" class="table table_vms table-bordered table-hover table-striped" style="margin: 1em 0 1.5em; width: 100%;">
                                <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center" style="width: 5%;">${tableList_rowNum + (page * Constants.MAXPAGEITEMS)}</display:column>
                                <display:column headerClass="table_header nowrap" sortable="true" property="teamCode" sortName="teamCode" escapeXml="true" titleKey="team.manager.code" class="nowrap" style="width: 20%;" />
                                <display:column headerClass="table_header nowrap" sortable="true" property="teamName" sortName="teamName" escapeXml="true" titleKey="team.manager.name" class="nowrap" style="width: 35%;" />
                                <display:column headerClass="table_header_center nowrap" titleKey="label.action" class="text-center" style="width:10%;">
                                    <c:set var="linkCounter" value="1" />
                                    <security:authorize ifAnyGranted="ADMIN,MANAGE_TEAM_FULL,MANAGE_TEAM_EMPCODE">
                                        <c:set var="linkCounter" value="${linkCounter + 1}" />
                                        <a href="${employeeUrl}?pojo.team.teamId=${tableList.teamId}" class="tip-top" title="<fmt:message key="label.view_empcode_list"/>"><i class="fa fa-street-view"></i></a>
                                    </security:authorize>
                                    <security:authorize ifAnyGranted="ADMIN,MANAGE_TEAM_FULL,MANAGE_TEAM_DISTRICT">
                                        <c:set var="linkCounter" value="${linkCounter + 1}" />
                                        <c:if test="${linkCounter gt 1}">
                                            &nbsp;|&nbsp;
                                        </c:if>
                                        <a href="${districtUrl}?pojo.team.teamId=${tableList.teamId}" class="tip-top" title="<fmt:message key="team.manager.manager_permission_authorization"/>"><i class="fa fa-key"></i></a>
                                    </security:authorize>
                                    <security:authorize ifAnyGranted="ADMIN,MANAGE_TEAM_FULL,MANAGE_TEAM_EDIT">
                                        <c:set var="linkCounter" value="${linkCounter + 1}" />
                                        <c:if test="${linkCounter gt 1}">
                                            &nbsp;|&nbsp;
                                        </c:if>
                                        <a href="${editUrl}?pojo.teamId=${tableList.teamId}" class="tip-top" title="<fmt:message key="label.edit"/>"><i class="fa fa-pencil-square-o"></i></a>
                                    </security:authorize>
                                    <security:authorize ifAnyGranted="ADMIN,MANAGE_TEAM_FULL">
                                        <c:set var="linkCounter" value="${linkCounter + 1}" />
                                        <c:if test="${linkCounter gt 1}">
                                            &nbsp;|&nbsp;
                                        </c:if>
                                        <a class="tip-top" title="<fmt:message key="label.disable"/>" onclick="javascript: disableTeam('${tableList.teamId}');"><i class="fa fa-times"></i></a>
                                    </security:authorize>
                                </display:column>
                                <display:setProperty name="paging.banner.item_name"><fmt:message key="team.manager.team"/></display:setProperty>
                                <display:setProperty name="paging.banner.items_name"><fmt:message key="team.manager.team"/></display:setProperty>
                            </display:table>
                        </div>
                    </div>
                    </div>
                </div>

        <form:hidden path="crudaction" id="crudaction"/>
        <form:hidden path="pojo.teamId" id="teamId"/>
    </form:form>
    </section>
</div>
<script>
    $(document).ready(function(){
        // active tab
        setActiveMenu4Admin('#administration_menu', '#team_menu');

        $("#btnFilter").click(function(){
            $("#crudaction").val("");
            $("#listForm").submit();
        });
    });

    function disableTeam(teamId){
        bootbox.confirm('<fmt:message key="database.disable.confirm.message.title"/>','<fmt:message key="team.disable.confirm.message.content"/>', function(r) {
            if(r){
                $("#crudaction").val("disable");
                $("#teamId").val(teamId);
                $("#listForm").submit();
            }
        });
    }
</script>
</body>
</html>