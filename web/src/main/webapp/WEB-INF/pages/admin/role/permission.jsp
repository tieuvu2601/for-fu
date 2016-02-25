<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="role.manager.title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<c:url value="/themes/vmsreport/styles/nestable.css"/>" rel="stylesheet">
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin" />
</security:authorize>
<c:url var="listUrl" value="${prefix}/role/list.html"/>
<c:url var="formUrl" value="${prefix}/role/permission.html"/>
<c:url var="dashboardUrl" value="/index.html"/>
<body>
<div class="content-wrapper">
<form:form commandName="item" id="formItem" action="${formUrl}" method="post" cssClass="form-horizontal" novalidate="novalidate">

    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="${dashboardUrl}"><i class="fa fa-home"></i> <fmt:message key="label.home.title"/></a></li>
            <li><a href="${listUrl}"><fmt:message key="role.manager.title"/></a></li>
            <li class="active"><fmt:message key="role.manager.permission_for_role"/></li>
        </ol>
    </section>

    <section class="content">
        <c:if test="${not empty messageResponse}">
            <div class="clear"></div>
            <div class="alert alert-message  alert-${alertType}">
                <a class="close" data-dismiss="alert" href="#">&times;</a> ${messageResponse}
            </div>
        </c:if>

        <div class="row">
            <div class="col-md-12">
                <div class="box box-solid box-primary">
                    <div class="box-header">
                        <h3 class="box-title"><fmt:message key="role.manager.list_permissions_for_role"/>:&nbsp;<b>${item.pojo.name}</b></h3>
                        <div class="filter-group">
                            <div class="btn-filter filter">
                                <i class="fa fa-search"></i>&nbsp;<fmt:message key="label.search"/>
                            </div>

                            <div class="filter-form">
                                <div class="filter-content">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label"><fmt:message key="role.permission.permissions"/></label>
                                        <div class="col-sm-8">
                                            <form:select id="roleTypeMenu" path="roleFilterType" cssClass="form-control">
                                                <option <c:if test="${item.roleFilterType eq Constants.IS_NOT_MANAGING}">selected="true"</c:if> value="${Constants.IS_NOT_MANAGING}"><fmt:message key="label.is_not_managing" /></option>
                                                <option <c:if test="${item.roleFilterType eq Constants.IS_MANAGING}">selected="true"</c:if> value="${Constants.IS_MANAGING}"><fmt:message key="label.is_managing" /></option>
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label"><fmt:message key="permissionGroup.label.group"/></label>
                                        <div class="col-sm-8">
                                            <form:select id="permissionGroupMenu" path="permissionGroupId" cssClass="form-control">
                                                <option value=""><fmt:message key="label.all" /></option>
                                                <c:forEach items="${permissionGroups}" var="packageLevelVar">
                                                    <option <c:if test="${packageLevelVar.permissionGroupId eq item.permissionGroupId}">selected="true"</c:if> value="${packageLevelVar.permissionGroupId}">${packageLevelVar.description}</option>
                                                </c:forEach>
                                            </form:select>
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
                        <c:choose>
                            <c:when test="${fn:length(permissionList) gt 0}">
                                <div id="nestable" class="dd">
                                    <ol class="dd-list parent">
                                        <c:set var="packageLevelVar" value="null" />
                                        <c:forEach items="${permissionList}" var="packageGroupPackageVar">
                                            <c:if test="${packageLevelVar eq 'null' || (packageLevelVar ne 'null' && packageLevelVar.code ne packageGroupPackageVar.permissionGroup.code)}">
                                                <li class="dd-item permissionGroup">
                                                    <input id="permisionGroup_${packageGroupPackageVar.permissionGroup.permissionGroupId}" type="checkbox" class="permissionGroup_cb" <c:if test="${item.roleFilterType eq Constants.IS_MANAGING}">checked</c:if> data-size="mini"/>
                                                    <div class="dd-handle">${packageGroupPackageVar.permissionGroup.description}</div>
                                                    <ol class="dd-list children">
                                                    <c:forEach items="${permissionList}" var="packageGroupVar">
                                                        <c:if test="${packageGroupVar.permissionGroup.permissionGroupId eq packageGroupPackageVar.permissionGroup.permissionGroupId}">
                                                            <li class="dd-item permission">
                                                                <input id="permission_${packageGroupVar.permissionId}" type="checkbox" name="permissionIds" class="permission_cb" <c:if test="${item.roleFilterType eq Constants.IS_MANAGING}">checked</c:if> value="${packageGroupVar.permissionId}" data-size="mini"/>
                                                                <div class="dd-handle">${packageGroupVar.name}</div>
                                                            </li>
                                                        </c:if>
                                                    </c:forEach>
                                                    </ol>
                                                </li>
                                            </c:if>
                                            <c:set var="packageLevelVar" value="${packageGroupPackageVar.permissionGroup}" />
                                        </c:forEach>
                                    </ol>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${item.roleFilterType eq Constants.IS_MANAGING}">
                                        <fmt:message key="role.is_managing.no_records"/>
                                    </c:when>
                                    <c:otherwise>
                                        <fmt:message key="role.is_not_managing.full_permission" />
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="box-footer text-center">
                        <a id="btnSave" class="btn btn-primary"><fmt:message key="button.save"/></a>
                        <a href="${listUrl}" class="btn btn-primary cancel-link"><fmt:message key="button.cancel"/></a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <input type="hidden" name="crudaction" id="crudaction"/>
    <form:hidden path="pojo.roleId"/>
</form:form>
</div>
<c:if test="${fn:length(permissionList) gt 0}">
    <script src="<c:url value="/themes/vmsreport/script/jquery.nestable.js" />"></script>
    <script src="<c:url value="/themes/vmsreport/script/ui-nestable-list_v1.0.js" />"></script>
</c:if>
<script type="text/javascript">
    $(document).ready(function(){
        // active tab
        setActiveMenu4Admin('#administration_menu', '#role_menu');

        $("#btnSave").click(function(){
            $("#crudaction").val("insert-update");
            $("#formItem").submit();
        });

        $('#btnFilter').click(function(){
            $("#crudaction").val("search-permission");
            $("#formItem").submit();
        });

        addTrigger4BS("input[type='checkbox']");
    });

    function addTrigger4BS(selector){
        $(selector).on('switchChange.bootstrapSwitch', function(e, state){
            var node = $(e.currentTarget).closest('li');
            if(typeof node != 'undefined'){
                if($(node).hasClass('permission')){
                    // leaf node
                    updateParentStateFromChild(node, state);
                }else if($(node).hasClass('permissionGroup')){
                    // parent node
                    updateChildrenState(node, state);
                }
            }
        });
    }

    function updateParentStateFromChild(childNode, childState){
        var parentNode = $(childNode).closest('ol.dd-list').closest('li.dd-item');
        if(typeof parentNode != 'undefined'){
            var parentState = checkParentState(parentNode);
            if(childState){
                replaceParentNodeWithState(parentNode, parentState);
            }else{
                replaceParentNodeWithState(parentNode, false);
            }
        }
    }

    function replaceParentNodeWithState(parentNode, parentState){
        var currentParentCb = $(parentNode).find('div.bootstrap-switch.bootstrap-switch-wrapper').first(),
                parentInputCb = $(parentNode).find("input[type='checkbox']").first();
        if(typeof currentParentCb != 'undefined' && typeof parentInputCb != 'undefined'){
            var newParentCb = $("<input type='checkbox' id='" +$(parentInputCb).attr('id')+ "' class='permissionGroup_cb' " +(parentState ? 'checked' : '')+ " data-size='mini' />");
            $(currentParentCb).remove();
            $(newParentCb).insertBefore($(parentNode).find("div.dd-handle").first());
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
        var permission_cb = $(node).find("input[type='checkbox']");
        if(typeof permission_cb != 'undefined'){
            $(permission_cb).bootstrapSwitch('state', state, false);
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