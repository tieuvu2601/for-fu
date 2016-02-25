<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="team.district_manager.title_page"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<c:url value="/themes/vmsreport/styles/nestable.css"/>" rel="stylesheet">
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin" />
</security:authorize>
<c:url var="listUrl" value="${prefix}/packagegroup/list.html"/>
<c:url var="formUrl" value="${prefix}/packagegroup/addpackage.html"/>
<c:url var="dashboardUrl" value="/home.html"/>
<body>
<div class="content-wrapper">
    <form:form commandName="item" id="formItem" action="${formUrl}" method="post" cssClass="form-horizontal" novalidate="novalidate">
        <section class="content-header">
            <ol class="breadcrumb">
                <li><a href="${dashboardUrl}"><i class="fa fa-home"></i> <fmt:message key="label.home.title"/></a></li>
                <li><a href="${listUrl}"><fmt:message key="packageGroup.manager"/></a></li>
                <li class="active"><fmt:message key="packageGroup.manager.add_package"/></li>
            </ol>
        </section>

        <section class="content">
            <c:if test="${not empty messageResponse}">
                <div class="clear"></div>
                <div class="alert alert-message alert-${alertType}">
                    <a class="close" data-dismiss="alert" href="#">&times;</a> ${messageResponse}
                </div>
            </c:if>

            <div class="row">
                <div class="col-md-12">
                    <div class="box box-solid box-primary">
                        <div class="box-header">
                            <h3 class="box-title"><fmt:message key="packageGroup.manager.list_package"/> </h3>
                            <div class="filter-group">
                                <div class="btn-filter filter">
                                    <i class="fa fa-search"></i>&nbsp;<fmt:message key="label.search"/>
                                </div>
                                <div class="filter-form">
                                    <div class="filter-content">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label"><fmt:message key="packageGroup.manager.package"/></label>
                                            <div class="col-sm-8">
                                                <select name="packageFilterType" class="form-control">
                                                    <option <c:if test="${item.packageFilterType eq Constants.IS_NOT_MANAGING}">selected="true"</c:if> value="${Constants.IS_NOT_MANAGING}"><fmt:message key="packageGroup.is_not_managing" /></option>
                                                    <option <c:if test="${item.packageFilterType eq Constants.IS_MANAGING}">selected="true"</c:if> value="${Constants.IS_MANAGING}"><fmt:message key="packageGroup.is_managing" /></option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label"><fmt:message key="packageGroup.manager.code"/></label>
                                            <div class="col-sm-8">
                                                <form:select path="pojo.packageCode" cssClass="form-control">
                                                    <option value=""><fmt:message key="label.all" /></option>
                                                    <c:forEach items="${listPackageCode2Filter}" var="packageCode">
                                                        <option value="${packageCode}" <c:if test="${item.pojo.packageCode eq packageCode}">selected="true"</c:if>>${packageCode}</option>
                                                    </c:forEach>
                                                </form:select>
                                            </div>
                                        </div>
                                        <div class="box-footer text-center">
                                            <a id="btnFilterPackageGroup" type="submit" class="btn btn-primary"><i class="fa fa-fw fa-search"></i><fmt:message key="label.filter"/></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="box-body">
                            <c:choose>
                                <c:when test="${item.packageFilterType eq Constants.IS_MANAGING}">
                                    <div id="nestable" class="dd">
                                        <ol class="dd-list level">
                                            <c:forEach items="${packageGroupPackageDTOs}" var="packageGroupPackageVar" varStatus="packageLevelCount">
                                                <c:if test="${packageLevelCount.count eq 1}">
                                                    <c:set var="packageLevelVar" value="${packageGroupPackageVar.packageLevel}" />
                                                </c:if>
                                                <c:if test="${packageLevelCount.count eq 1 || packageLevelVar.packageLevelId ne packageGroupPackageVar.packageLevel.packageLevelId}">
                                                    <c:set var="packageLevelVar" value="${packageGroupPackageVar.packageLevel}" />
                                                    <li class="dd-item packageLevel ${packageLevelCount.count}">
                                                        <input id="packageLevel_${packageGroupPackageVar.packageLevel.packageLevelId}" type="checkbox" class="packageLevel_cb" checked data-size="mini"/>
                                                        <div class="dd-handle">${packageGroupPackageVar.packageLevel.packageName}</div>
                                                        <ol class="dd-list group">
                                                            <c:set var="packageGroupVar" value="null" />
                                                            <c:set var="numberOfPackageGroup" value="${0}" />
                                                            <c:forEach items="${packageGroupPackageDTOs}" var="packageGroupPackage1Var" varStatus="packageGroupCount">
                                                                <c:if test="${packageGroupVar eq 'null' && packageGroupPackage1Var.packageLevel.packageLevelId eq packageLevelVar.packageLevelId}">
                                                                    <c:set var="packageGroupVar" value="${packageGroupPackage1Var.packageGroup}" />
                                                                </c:if>
                                                                <div class="clear"></div>
                                                                <c:if test="${packageGroupVar ne 'null'}">
                                                                    <c:if test="${(numberOfPackageGroup eq 0 &&
                                                                                    packageLevelVar.packageLevelId eq packageGroupPackage1Var.packageLevel.packageLevelId &&
                                                                                    packageGroupVar.packageGroupId eq packageGroupPackage1Var.packageGroup.packageGroupId) ||
                                                                                (numberOfPackageGroup gt 0 &&
                                                                                    packageLevelVar.packageLevelId eq packageGroupPackage1Var.packageLevel.packageLevelId &&
                                                                                    packageGroupVar.packageGroupId ne packageGroupPackage1Var.packageGroup.packageGroupId)}">
                                                                        <li class="dd-item packageGroup">
                                                                            <input id="packageGroup_${packageGroupPackage1Var.packageGroup.packageGroupId}" type="checkbox" class="packageGroup_cb" checked data-size="mini"/>
                                                                            <div class="dd-handle">${packageGroupPackage1Var.packageGroup.packageGroupName}</div>
                                                                            <ol class="dd-list package">
                                                                                <c:forEach items="${packageGroupPackageDTOs}" var="packageGroupPackage2Var" varStatus="packageCount">
                                                                                    <c:if test="${(packageLevelVar.packageLevelId eq packageGroupPackage2Var.packageLevel.packageLevelId &&
                                                                                                packageGroupVar.packageGroupId eq packageGroupPackage2Var.packageGroup.packageGroupId)}">
                                                                                        <li class="dd-item package">
                                                                                            <input id="package_${packageGroupPackage2Var.pgPackageId}" type="checkbox" name="pgPackageIds" value="${packageGroupPackage2Var.pgPackageId}" class="package_cb" checked data-size="mini"/>
                                                                                            <div class="dd-handle">${packageGroupPackage2Var.packageCode}</div>
                                                                                        </li>
                                                                                    </c:if>
                                                                                </c:forEach>
                                                                            </ol>
                                                                        </li>
                                                                        <c:set var="numberOfPackageGroup" value="${numberOfPackageGroup + 1}" />
                                                                    </c:if>
                                                                </c:if>
                                                                <c:set var="packageGroupVar" value="${packageGroupPackage1Var.packageGroup}" />
                                                            </c:forEach>
                                                        </ol>
                                                    </li>
                                                </c:if>
                                            </c:forEach>
                                        </ol>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label"><fmt:message key="label.package_level"/></label>
                                        <div class="col-sm-3">
                                            <select name="pojo.packageLevel.packageLevelId" class="form-control required nohtml">
                                                <c:forEach items="${packageLevelList}" var="packageLevel">
                                                    <c:choose>
                                                        <c:when test="${not empty item.pojo.packageLevel.packageLevelId}">
                                                            <option value="${packageLevel.packageLevelId}" <c:if test="${item.pojo.packageLevel.packageLevelId eq packageLevel.packageLevelId}">selected="true"</c:if>>${packageLevel.packageName}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${packageLevel.packageLevelId}" <c:if test="${Constants.PACKAGE_LEVEL_EMPTY eq packageLevel.packageCode}">selected="true"</c:if>>${packageLevel.packageName}</option>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <table border="1" class="center">
                                        <tr>
                                            <td>
                                                 <input type="text" id="searchInput" autocomplete="off" onkeyup="javascript:searchPackage();" class="searchInput" placeholder="<fmt:message key="label.search_package" />"/>
                                            </td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <div class="limit_list">
                                                    <ul id="left_list">
                                                        <c:forEach items="${listPackageCode2Filter}" var="packageCode" varStatus="count">
                                                            <li class="on_add_item" index="${count.count - 1}">${packageCode}</li>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="limit_list text-center text-middle">
                                                    <div class="form-group no_margin">
                                                        <a style="width: 90%;" class="btn btn-primary" onclick="javascript: addItems();"><fmt:message key="button.add" />&nbsp;>></a>
                                                    </div>
                                                    <div style="height: 10px;"></div>
                                                    <div class="form-group no_margin">
                                                        <a style="width: 90%;" class="btn btn-primary" onclick="javascript: removeItems();"><<&nbsp;<fmt:message key="button.delete" /></a>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="limit_list">
                                                    <ul id="right_list">

                                                    </ul>
                                                </div>
                                            </td>
                                        </tr>
                                    </table>
                                </c:otherwise>
                            </c:choose>

                            <div class="clear"></div>
                            <div class="form-actions text-center pal" style="margin-top: 10px;">
                                <a id="btnSubmitForm" class="btn btn-primary"><fmt:message key="button.save"/></a>
                                <a href="${listUrl}" class="btn btn-primary cancel-link"><fmt:message key="button.cancel"/></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <input type="hidden" name="crudaction" id="crudaction"/>
        <input id="packageCodeList" type="hidden" name="checkList" />
        <form:hidden path="pojo.packageGroup.packageGroupId"/>

    </form:form>
</div>
<c:if test="${item.packageFilterType eq Constants.IS_MANAGING}">
    <script src="<c:url value="/themes/vmsreport/script/jquery.nestable.js" />"></script>
    <script src="<c:url value="/themes/vmsreport/script/ui-nestable-list_v1.0.js" />"></script>
</c:if>
<script type="text/javascript">
    $(document).ready(function(){
        // active tab
        setActiveMenu4Admin('#administration_menu', '#package_group_menu');


        $('#btnFilterPackage').click(function(){
            if($('#packageTypeMenu').val() === '${Constants.IS_NOT_MANAGING}'){
                $('#crudaction').val('search-package');
            } else {
                $('#crudaction').val('')
            }
            $("#formItem").submit();
        });

        $("#btnSubmitForm").click(function(){
            if($('#formItem').valid()){
                $('#crudaction').val('insert-update');
                var a = '${item.packageFilterType}';
                <c:if test="${item.packageFilterType eq Constants.IS_NOT_MANAGING}">
                buildCheckList();
                </c:if>
                $("#formItem").submit();
            }
        });

        function buildCheckList(){
            var checkList = new Array();
            $('#right_list').find('li').each(function(index, el){
                checkList.push($.trim($(el).html()));
            });
            $('#packageCodeList').val(checkList.join(','));
        }

        $('#btnFilterPackageGroup').click(function(){
            $("#formItem").submit();
        });

        triggerSelectedOnAddItems('.on_add_item');
        triggerSelectedOnRemoveItems('.on_remove_item');

        addTrigger4BS("input[type='checkbox']");
    });

    function triggerSelectedOnAddItems(onAddItemSelector){
        $(onAddItemSelector).on('click', function(){
            $(this).toggleClass('selected');
        });
    }

    function triggerSelectedOnRemoveItems(onRemoveItemSelecter){
        $(onRemoveItemSelecter).on('click', function(){
            $(this).toggleClass('selected');
        });
    }

    function addItems(){
        $('li.on_add_item.selected').filter(function(){return $(this).is(':visible')}).each(function(index, el){
            var onRemoveItem = $("<li class='on_remove_item' index='" + $.trim($(el).attr('index'))+ "'>" +$(el).html()+ "</li>");
            var higherIndex = findIndex2Insert('#right_list', $(el).attr('index'));
            if(higherIndex > 0){
                var higherEl = $('#right_list').find("li[index='" +higherIndex+ "']");
                $(onRemoveItem).insertBefore(higherEl);
            }else{
                $('#right_list').append(onRemoveItem);
            }
            triggerSelectedOnRemoveItems(onRemoveItem);
            $(this).remove();
        });
    }

    function removeItems(){
        $('li.on_remove_item.selected').filter(function(){return $(this).is(':visible')}).each(function(index, el){
            var onAddItem = $("<li class='on_add_item' index='" + $.trim($(el).attr('index'))+ "'>" +$(el).html()+ "</li>");
            var higherIndex = findIndex2Insert('#left_list', $(el).attr('index'));
            if(higherIndex > 0){
                var higherEl = $('#left_list').find("li[index='" +higherIndex+ "']");
                $(onAddItem).insertBefore(higherEl);
            }else{
                $('#left_list').append(onAddItem);
            }
            triggerSelectedOnAddItems(onAddItem);
            $(this).remove();
        });
    }

    function findIndex2Insert(containerEl, elIndex){
        var index2Insert = 0;
        $(containerEl).find('li').each(function(index, el){
            var _index = eval($.trim($(el).attr('index')));
            if(_index > elIndex && index2Insert == 0){
                index2Insert = _index;
            }
        });
        return index2Insert;
    }

    function addTrigger4BS(selector){
        $(selector).on('switchChange.bootstrapSwitch', function(e, state){
            var node = $(e.currentTarget).closest('li');
            if(typeof node != 'undefined'){
                if($(node).hasClass('package')){
                    // leaf (package) node
                    recursiveUpdateParentState(node, state);
                }else if($(node).hasClass('packageGroup')){
                    // package group node
                    updatePackageState(node, state);
                    recursiveUpdateParentState(node, state);
                }else if($(node).hasClass('packageLevel')){
                    // package level node
                    updatePackageGroupState(node, state);
                }
            }
        });
    }

    function recursiveUpdateParentState(node, state){
        var parentNode = $(node).closest('ol.dd-list').closest('li.dd-item');
        if(typeof parentNode != 'undefined' && $(parentNode).length){
            var parentState = checkParentState(parentNode);
            if(state){
                replaceNodeWithState(parentNode, parentState);
            }else{
                replaceNodeWithState(parentNode, false);
            }
            recursiveUpdateParentState(parentNode, state);
        }
    }

    function replaceNodeWithState(node, state){
        var currentBootstrapSwitchCb = $(node).find('div.bootstrap-switch.bootstrap-switch-wrapper').first(),
            currentCb = $(node).find("input[type='checkbox']").first(),
            newCb = $("<input type='checkbox'" + (typeof $(currentCb).attr('name') != 'undefined' && $.trim($(currentCb).attr('name')) != '' ? " name='" + $.trim($(currentCb).attr('name')) + "'" : "") + " id='" + $(currentCb).attr('id') + "'" + (typeof $(currentCb).attr('value') != 'undefined' && $.trim($(currentCb).attr('value')) != '' ? " value='" + $.trim($(currentCb).attr('value')) + "'" : "") + " class='" + $(currentCb).attr('class') + "' " + (state ? 'checked' : '') + " data-size='mini' />");
        $(currentBootstrapSwitchCb).remove();
        $(newCb).insertBefore($(node).find("div.dd-handle").first());
        $(newCb).bootstrapSwitch();
        addTrigger4BS(newCb);
    }

    function checkParentState(parentNode){
        var state = true,
            childrenSelector = '.packageGroup';
        if($(parentNode).hasClass('packageGroup')){
            childrenSelector = ".package";
        }
        $(parentNode).find('li' + childrenSelector).each(function(index, childNode){
            state = getNodeState(childNode) && state;
        });
        return state;
    }

    function updatePackageGroupState(levelNode, levelState){
        $(levelNode).find('li.dd-item.packageGroup').each(function(index, packageGroupNode){
            var childState = getNodeState(packageGroupNode);
            if(levelState != childState){
                replaceNodeWithState(packageGroupNode, levelState);
                updatePackageState(packageGroupNode, levelState);
            }
        });
    }

    function updatePackageState(packageGroupNode, packageGroupState){
        $(packageGroupNode).find('li.dd-item.package').each(function(index, leafNode){
            var childState = getNodeState(leafNode);
            if(packageGroupState != childState){
                replaceNodeWithState(leafNode, packageGroupState);
            }
        });
    }

    function getNodeState(node){
        var cb = $(node).find("input[type='checkbox']").first();
        if(typeof cb != 'undefined'){
            return $(cb).bootstrapSwitch('state');
        }
        return true;
    }

    function searchPackage(){
        var textSearch = $('#searchInput').val().toString().toLowerCase();
        if(textSearch == ''){
            $('#left_list').find('li').removeClass('hide');
        }else {
            $('#left_list').find('li').filter(function(){return $(this).html().toString().toLowerCase().indexOf(textSearch) > -1}).removeClass('hide');
            $('#left_list').find('li').filter(function(){return $(this).html().toString().toLowerCase().indexOf(textSearch) == -1}).addClass('hide');
        }
    }
</script>
</body>
</html>