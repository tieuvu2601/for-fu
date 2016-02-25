<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="role.manager.title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<c:url value="/themes/vmsreport/styles/nestable.css"/>" rel="stylesheet">
    <link href="<c:url value="/themes/vmsreport/plugins/CustomScrollbar/jquery.mCustomScrollbar.min.css"/>" rel="stylesheet">
</head>

<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin"></c:set>
</security:authorize>
<c:url var="backUrl" value="${prefix}/user/list.html"/>
<c:url var="formlUrl" value="${prefix}/user/permission.html"/>
<c:url var="dashboardUrl" value="/home.html"/>

<body>
<div class="content-wrapper">
<form:form commandName="item" id="formItem" action="${formUrl}" method="post" cssClass="form-horizontal" novalidate="novalidate">
<section class="content-header">
    <ol class="breadcrumb">
        <li><a href="${dashboardUrl}"><i class="fa fa-home"></i><fmt:message key="label.home.title" /></a></li>
        <li><a href="${backUrl}"><fmt:message key="user.manager"/></a></li>
        <li class="active"><fmt:message key="user.manager.permissions"/></li>
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
<div class="callout callout-danger"><fmt:message key="user.permission.authorize_for_user" />:&nbsp;<b>${userInfo.displayName}</b><br/>
    <fmt:message key="user.manager.usergroup" />:&nbsp;<b>${userInfo.userGroup.name}</b></div>
<div class="row">
<div class="col-md-12">
<div class="box box-solid box-primary">
    <div class="box-header">
        <h3 class="box-title"><fmt:message key="team.district_manager.title_page"/> </h3>
        <div class="filter-group">
            <div class="btn-filter filter">
                <i class="fa fa-search"></i>&nbsp;<fmt:message key="label.search"/>
            </div>
            <div class="filter-form">
                <div class="filter-content">
                    <div class="form-group">
                        <label class="col-sm-3 control-label"><fmt:message key="team.manager.district_name"/></label>
                        <div class="col-sm-8">
                            <select id="districtTypeMenu" name="districtFilterType" class="form-control">
                                <option <c:if test="${item.districtFilterType eq Constants.IS_NOT_MANAGING}">selected="true"</c:if> value="${Constants.IS_NOT_MANAGING}"><fmt:message key="label.is_not_managing" /></option>
                                <option <c:if test="${item.districtFilterType eq Constants.IS_MANAGING}">selected="true"</c:if> value="${Constants.IS_MANAGING}"><fmt:message key="label.is_managing" /></option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label"><fmt:message key="team.manager.code"/></label>
                        <div class="col-sm-8">
                            <form:select id="districtMenu" path="districtCode" cssClass="form-control">
                                <option value=""><fmt:message key="label.all" /></option>
                                <c:forEach items="${listDistricts}" var="listDistricts">
                                    <option value="${districtCode}" <c:if test="${item.districtCode eq listDistricts.districtCode}">selected="true"</c:if>>${listDistricts.districtName}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <div class="box-footer text-center">
                        <a id="btnFilterDistrict" type="submit" class="btn btn-primary"><i class="fa fa-fw fa-search"></i><fmt:message key="label.filter"/></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="box-body">
        <c:choose>
            <c:when test="${item.districtFilterType eq Constants.IS_MANAGING}">
                <div class="panel">
                    <div class="panel-body">
                        <div id="nestable" class="dd">
                            <ol class="dd-list">
                                <c:forEach items="${listBranchInUser}" var="branchVar" varStatus="branchVarCount">
                                    <li data-id="2" class="dd-item branchNode">
                                        <div class="dd-handle">${branchVar.branchName}</div>
                                        <input id="district_${branchVar.branchCode}" type="checkbox" name="districtCodes" value="${branchVar.branchCode}_1" class="branchList" checked data-size="mini"/>
                                        <c:set var="branchCodeVar" value="${branchVar.branchCode}" />
                                        <c:forEach items="${listDistrictsInUser}" var="districtVar" varStatus="districtVarCount">
                                            <c:if test="${branchCodeVar eq districtVar.branchCode}">
                                                <ol class="dd-list">
                                                    <li data-id="3" class="dd-item districtNode">
                                                        <div class="dd-handle">${districtVar.districtName}</div>
                                                        <input id="district_${districtVar.districtCode}" type="checkbox" name="districtCodes" value="${districtVar.districtCode}_0" class="districtList" checked data-size="mini"/>

                                                    </li>
                                                </ol>
                                            </c:if>
                                        </c:forEach>
                                    </li>
                                </c:forEach>
                            </ol>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="panel">
                    <div class="panel-body">
                        <div id="nestable" class="dd">
                            <ol class="dd-list">
                                <c:forEach items="${listBranchNotInUser}" var="branchVar" varStatus="branchVarCount">
                                    <li data-id="2" class="dd-item branchNode">
                                        <div class="dd-handle">${branchVar.branchName}</div>
                                        <input id="district_${branchVar.branchCode}" type="checkbox" name="districtCodes" value="${branchVar.branchCode}_1" class="branchList"  data-size="mini"/>
                                        <c:set var="branchCodeVar" value="${branchVar.branchCode}" />
                                        <c:forEach items="${listDistrictsNotInUser}" var="districtVar" varStatus="districtVarCount">
                                            <c:if test="${branchCodeVar eq districtVar.branchCode}">
                                                <ol class="dd-list">
                                                    <li data-id="3" class="dd-item districtNode">
                                                        <div class="dd-handle">${districtVar.districtName}</div>
                                                        <input id="district_${districtVar.districtCode}" type="checkbox" name="districtCodes" value="${districtVar.districtCode}_0" class="districtList"  data-size="mini"/>
                                                    </li>
                                                </ol>
                                            </c:if>
                                        </c:forEach>
                                    </li>
                                </c:forEach>
                            </ol>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>

    </div>
</div>
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
                                <option <c:if test="${item.roleFilterType eq Constants.IS_NOT_MANAGING}">selected="true"</c:if> value="${Constants.IS_NOT_MANAGING}"><fmt:message key="label.is_not_managing" /></option>
                                <option <c:if test="${item.roleFilterType eq Constants.IS_MANAGING}">selected="true"</c:if> value="${Constants.IS_MANAGING}"><fmt:message key="label.is_managing" /></option>
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
                        <a id="btnFilterUserRoleACL" type="submit" class="btn btn-primary"><i class="fa fa-fw fa-search"></i><fmt:message key="label.filter"/></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="box-body">
        <c:choose>
            <c:when test="${item.crudaction eq 'search-role'}">
                <display:table name="rolesNotInUser" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                               partialList="true" sort="external" size="${fn:length(rolesNotInUser)}" defaultsort="0"
                               id="tableList" pagesize="${fn:length(rolesNotInUser)}" export="false" class="table table_vms table-hover table-bordered" style="margin: 1em 0 1.5em; width: 100%;">
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
                <display:table name="userRoleACLs" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                               partialList="true" sort="external" size="${fn:length(userRoleACLs)}" defaultsort="0"
                               id="tableList" pagesize="${fn:length(userRoleACLs)}" export="false" class="table table_vms table-hover table-bordered" style="margin: 1em 0 1.5em; width: 100%;">
                    <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center" style="width: 5%;">${tableList_rowNum}</display:column>
                    <display:column headerClass="table_header nowrap" titleKey="role.manager.code" property="code" class="nowrap" style="width: 20%;" />
                    <display:column headerClass="table_header nowrap" titleKey="role.manager.name" property="name" class="nowrap" style="width: 60%;" />
                    <display:column headerClass="table_header_center nowrap" titleKey="label.action" class="text-center" style="width:15%;">
                        <input type="checkbox" name="userRoleACLIds" checked value='${tableList.roleId}' data-size="mini" />
                    </display:column>
                    <display:setProperty name="paging.banner.item_name"><fmt:message key="role.manager.role"/></display:setProperty>
                    <display:setProperty name="paging.banner.items_name"><fmt:message key="role.manager.role"/></display:setProperty>
                </display:table>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<div class="box box-solid box-primary">
    <div class="box-header">
        <h3 class="box-title"><fmt:message key="user.manager.authorize_more"/></h3>
        <div class="filter-group">
            <div class="btn-filter filter">
                <i class="fa fa-search"></i>&nbsp;<fmt:message key="label.search"/>
            </div>
            <div class="filter-form">
                <div class="filter-content">
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="label.permissions"/></label>
                        <div class="col-sm-7">
                            <select id="permissionTypeMenu" name="permissionFilterType" class="form-control">
                                <option <c:if test="${item.permissionFilterType eq Constants.IS_NOT_MANAGING}">selected="true"</c:if> value="${Constants.IS_NOT_MANAGING}"><fmt:message key="label.is_not_managing" /></option>
                                <option <c:if test="${item.permissionFilterType eq Constants.IS_MANAGING}">selected="true"</c:if> value="${Constants.IS_MANAGING}"><fmt:message key="label.is_managing" /></option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="permission.manager.code" /></label>
                        <div class="col-sm-7">
                            <form:input path="permissionFilterCode" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="permission.manager.name" /></label>
                        <div class="col-sm-7">
                            <form:input path="permissionFilterName" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="box-footer text-center">
                        <a id="btnFilterUserACL" type="submit" class="btn btn-primary"><i class="fa fa-fw fa-search"></i><fmt:message key="label.filter"/></a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="box-body">
        <div id="reportTableContainer" class="scroll_table_container">
            <c:choose>
                <c:when test="${item.crudaction eq 'search-permission'}">
                    <display:table name="permissionsNotInUser" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                   partialList="true" sort="external" size="${fn:length(permissionsNotInUser)}" defaultsort="0"
                                   id="tableList" pagesize="${fn:length(permissionsNotInUser)}" export="false" class="table table_vms table-hover table-bordered" style="margin: 1em 0 1.5em; width: 100%;">
                        <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center" style="width: 5%;">${tableList_rowNum}</display:column>
                        <display:column headerClass="table_header nowrap" titleKey="permission.manager.code" property="code" class="nowrap" style="width: 20%;" />
                        <display:column headerClass="table_header nowrap"  titleKey="permission.manager.name" property="name" class="nowrap" style="width: 60%;" />
                        <display:column headerClass="table_header_center nowrap" titleKey="label.action" class="text-center" style="width:15%;">
                            <input type="checkbox" name="permissionIds" value='${tableList.permissionId}' data-size="mini" >
                        </display:column>
                        <display:setProperty name="paging.banner.item_name"><fmt:message key="role.manager.permission"/></display:setProperty>
                        <display:setProperty name="paging.banner.items_name"><fmt:message key="role.manager.permission"/></display:setProperty>
                    </display:table>
                </c:when>
                <c:otherwise>
                    <display:table name="userACLs" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                   partialList="true" sort="external" size="${fn:length(userACLs)}" defaultsort="0"
                                   id="tableList" pagesize="${fn:length(userACLs)}" export="false" class="table table_vms table-hover table-bordered" style="margin: 1em 0 1.5em; width: 100%;">
                        <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center" style="width: 5%;">${tableList_rowNum}</display:column>
                        <display:column headerClass="table_header nowrap" titleKey="permission.manager.code" property="code" class="nowrap" style="width: 20%;" />
                        <display:column headerClass="table_header nowrap"  titleKey="permission.manager.name" property="name" class="nowrap" style="width: 60%;" />
                        <display:column headerClass="table_header_center nowrap" titleKey="label.action" class="text-center" style="width:15%;">
                            <input type="checkbox" name="userACLIds" checked value='${tableList.permissionId}' data-size="mini" >
                        </display:column>
                        <display:setProperty name="paging.banner.item_name"><fmt:message key="role.manager.permission"/></display:setProperty>
                        <display:setProperty name="paging.banner.items_name"><fmt:message key="role.manager.permission"/></display:setProperty>
                    </display:table>
                </c:otherwise>
            </c:choose>
        </div>
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
<form:hidden path="pojo.users.userId"/>
</form:form>
</div>
<script src="<c:url value="/themes/vmsreport/script/jquery.nestable.js" />"></script>
<script src="<c:url value="/themes/vmsreport/script/ui-nestable-list_v1.0.js" />"></script>
<script type="text/javascript" src="<c:url value="/scripts/jquery/jquery.mCustomScrollbar.concat.min.js"/>"></script>
<script type="text/javascript">
    $(document).ready(function(){
        // active tab
        setActiveMenu4Admin('#administration_menu', '#user_menu');

        $("#btnSave").click(function(){
            $('#crudaction').val('update');
            if($('#districtTypeMenu').val() === '${Constants.IS_NOT_MANAGING}'){
                regatherChecklist();
            }
            $("#formItem").submit();
        });

        $('#btnFilterUserRoleACL').click(function(){
            if($('#roleTypeMenu').val() === '${Constants.IS_NOT_MANAGING}'){
                $('#crudaction').val('search-role');
            }
            $("#formItem").submit();
        });

        $('#btnFilterUserACL').click(function(){
            if($('#permissionTypeMenu').val() === '${Constants.IS_NOT_MANAGING}'){
                $('#crudaction').val('search-permission');
            }
            $("#formItem").submit();
        });

        $('#btnFilterDistrict').click(function(){
            if($('#districtTypeMenu').val() === '${Constants.IS_NOT_MANAGING}'){
                $('#crudaction').val('search-district');
            }
            $("#formItem").submit();
        });

        addTrigger4BS("input[type='checkbox']");
        $('#reportTableContainer').mCustomScrollbar({axis:"y"});
    });



    function regatherChecklist(){
        $('li.branchNode').each(function(index, branchNodeEl){
            if(checkParentState(branchNodeEl)){
                $('.districtNode', branchNodeEl).each(function(index1, districtNodeEl){
                    replaceParentNodeWithState(districtNodeEl, false);
                });
            }
        });
    }

    // check state parent and children
    function addTrigger4BS(selector){
        $(selector).on('switchChange.bootstrapSwitch', function(e, state){
            var node = $(e.currentTarget).closest('li');
            if(typeof node != 'undefined'){
                if($(node).hasClass('districtNode')){
                    // leaf district node
                    updateParentStateFromChild(node, state);
                }else if($(node).hasClass('branchNode')){
                    // parent node
                    updateChildrenState(node, state);
                }
            }
        });
    }

    function updateParentStateFromChild(childNode, childState){
        var parentNode = $(childNode).closest('ol.dd-list').closest('li.dd-item');
        if(typeof parentNode != 'undefined'){
//            var parentInput = $(parentNode).find("input[type='checkbox']").first();
//            var parentState = $(parentInput).bootstrapSwitch('state');
            var parentState = checkParentState(parentNode);
            if(childState){
                replaceParentNodeWithState(parentNode, parentState);
            }else{
                replaceParentNodeWithState(parentNode, false);
            }
        }
    }

    function replaceParentNodeWithState(node, state){
        var currentParentCb = $(node).find('div.bootstrap-switch.bootstrap-switch-wrapper').first(),
                parentInputCb = $(node).find("input[type='checkbox']").first();
        if(typeof currentParentCb != 'undefined' && typeof parentInputCb != 'undefined'){
            var newParentCb = $("<input type='checkbox' name ='"+$(parentInputCb).attr('name')+"'  id='" +$(parentInputCb).attr('id')+ "' value = "+ $(parentInputCb).attr('value')+ " class='branchList' " +(state ? 'checked' : '')+ " data-size='mini' />");
            $(currentParentCb).remove();
            $(newParentCb).insertBefore($(node).find("div.dd-handle").first());
            $(newParentCb).bootstrapSwitch();
            addTrigger4BS(newParentCb);
        }
    }

    function checkParentState(parentNode){
        var state = true;
        $(parentNode).find('li').each(function(index, leafNode){
            state = getNodeState(leafNode) && state;
        });
        return state;
    }

    function updateChildrenState(parentNode, parentState){
        $(parentNode).find('li.dd-item').each(function(index, leafNode){
            var childState = getNodeState(leafNode);
            if(parentState != childState){
                updateNodeState(leafNode, parentState);
            }
        });
    }

    function updateNodeState(node, state){
        var districtList = $(node).find("input[type='checkbox']");
        if(typeof districtList != 'undefined'){
            $(districtList).bootstrapSwitch('state', state, false);
        }
    }

    function getNodeState(node){
        var cb = $(node).find("input[type='checkbox']");
        if(typeof cb != 'undefined'){
            return $(cb).bootstrapSwitch('state');
        }
        return true;
    }
</script>
</body>
</html>