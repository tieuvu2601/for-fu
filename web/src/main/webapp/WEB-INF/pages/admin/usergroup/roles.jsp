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
    <title><fmt:message key="role.manager.title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin"></c:set>
</security:authorize>
<c:url var="backUrl" value="${prefix}/usergroup/list.html"/>
<c:url var="formlUrl" value="${prefix}/usergroup/role.html"/>
<c:url var="dashboardUrl" value="/home.html"/>

<body>
<div class="content-wrapper">
    <form:form commandName="item" id="formItem" action="${formUrl}" method="post" cssClass="form-horizontal" novalidate="novalidate">
        <section class="content-header">
            <ol class="breadcrumb">
                <li><a href="${dashboardUrl}"><i class="fa fa-home"></i><fmt:message key="label.home.title" /></a></li>
                <li><fmt:message key="menu.administration"/></li>
                <li><a href="${backUrl}"><fmt:message key="usergroup.manager"/></a></li>
                <li class="active"><fmt:message key="usergroup.manager.permission"/></li>
            </ol>
        </section>
        <section class="content">
            <c:if test="${not empty messageResponse}">
                <div class="clear"></div>
                <div class="alert alert-message  alert-${alertType}">
                    <a class="close" data-dismiss="alert" href="#">&times;</a> ${messageResponse}
                </div>
            </c:if>
            <div class="clear"></div>
            <div class="callout callout-danger"><fmt:message key="user.permission.authorize_for_user" />:&nbsp;<b>${userGroupInfo.name}</b></div>
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-solid box-primary">
                        <div class="box-header">
                            <h3 class="box-title"><fmt:message key="user.manager.authorize_by_role"/></h3>
                            <div class="filter-group">
                                <div class="btn-filter filter">
                                    <i class="fa fa-search"></i>&nbsp;<fmt:message key="label.search"/>
                                </div>
                                <div class="filter-form">
                                    <div class="filter-content">
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label"><fmt:message key="label.roles"/></label>
                                            <div class="col-sm-7">
                                                <form:select id="roleTypeMenu" path="roleFilterType" cssClass="form-control">
                                                    <option <c:if test="${item.roleFilterType eq Constants.IS_NOT_MANAGING}"> selected="true"</c:if> value="${Constants.IS_NOT_MANAGING}"><fmt:message key="label.is_not_managing" /></option>
                                                    <option <c:if test="${item.roleFilterType eq Constants.IS_MANAGING}"> selected="true"</c:if> value="${Constants.IS_MANAGING}"><fmt:message key="label.is_managing" /></option>
                                                </form:select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label"><fmt:message key="role.manager.code" /></label>
                                            <div class="col-sm-7">
                                                <form:input path="roleFilterCode" cssClass="form-control" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label"><fmt:message key="role.manager.name" /></label>
                                            <div class="col-sm-7">
                                                <form:input path="roleFilterName" cssClass="form-control" />
                                            </div>
                                        </div>
                                        <div class="box-footer text-center">
                                            <a id="btnFilterUserGroupRoleACL" type="submit" class="btn btn-primary"><i class="fa fa-fw fa-search"></i><fmt:message key="label.filter"/></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="box-body">
                            <c:choose>
                                <c:when test="${item.crudaction eq 'search-role'}">
                                    <display:table name="roleNotInUserGroup" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                                   partialList="true" sort="external" size="${fn:length(roleNotInUserGroup)}" defaultsort="0"
                                                   id="tableList" pagesize="${fn:length(roleNotInUserGroup)}" export="false" class="table table_vms table-hover table-bordered" style="margin: 1em 0 1.5em; width: 100%;">
                                        <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center" style="width: 5%;">${tableList_rowNum}</display:column>
                                        <display:column headerClass="table_header nowrap" titleKey="role.manager.code" property="code" class="nowrap" style="width: 20%;" />
                                        <display:column headerClass="table_header nowrap" titleKey="role.manager.name" property="name" class="nowrap" style="width: 60%;" />
                                        <display:column headerClass="table_header_center nowrap" titleKey="label.action" class="text-center" style="width:15%;">
                                            <input type="checkbox" name="roleIds" value='${tableList.roleId}' data-size="mini" />
                                        </display:column>
                                        <display:setProperty name="paging.banner.item_name"><fmt:message key="role.manager.role"/></display:setProperty>
                                        <display:setProperty name="paging.banner.items_name"><fmt:message key="role.manager.role"/></display:setProperty>
                                    </display:table>
                                </c:when>
                                <c:otherwise>
                                    <display:table name="roleInUserGroup" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                                   partialList="true" sort="external" size="${fn:length(roleInUserGroup)}" defaultsort="0"
                                                   id="tableList" pagesize="${fn:length(roleInUserGroup)}" export="false" class="table table_vms table-hover table-bordered" style="margin: 1em 0 1.5em; width: 100%;">
                                        <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center" style="width: 5%;">${tableList_rowNum}</display:column>
                                        <display:column headerClass="table_header nowrap" titleKey="role.manager.code" property="code" class="nowrap" style="width: 20%;" />
                                        <display:column headerClass="table_header nowrap" titleKey="role.manager.name" property="name" class="nowrap" style="width: 60%;" />
                                        <display:column headerClass="table_header_center nowrap" titleKey="label.action" class="text-center" style="width:15%;">
                                            <input type="checkbox" name="userGroupRoleACLIds" checked value='${tableList.roleId}' data-size="mini" />
                                        </display:column>
                                        <display:setProperty name="paging.banner.item_name"><fmt:message key="role.manager.role"/></display:setProperty>
                                        <display:setProperty name="paging.banner.items_name"><fmt:message key="role.manager.role"/></display:setProperty>
                                    </display:table>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="box box-solid box-primary">
                        <div class="box-body text-center">
                            <a id="btnSave" class="btn btn-primary"><i class="fa fa-fw fa-save"></i> <fmt:message key="button.save"/></a>
                            <a class="btn cancel-link" href="${backUrl}"><fmt:message key="button.cancel"/></a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <input type="hidden" name="crudaction" id="crudaction"/>
        <form:hidden path="pojo.userGroup.userGroupId"/>
    </form:form>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        // active tab
        setActiveMenu4Admin('#administration_menu', '#usergroup_menu');

        $("#btnSave").click(function(){
            $('#crudaction').val('update');
            $("#formItem").submit();
        });

        $('#btnFilterUserGroupRoleACL').click(function(){
            if($('#roleTypeMenu').val() === '${Constants.IS_NOT_MANAGING}'){
                $('#crudaction').val('search-role');
            }
            $("#formItem").submit();
        });

    });
</script>
</body>
</html>