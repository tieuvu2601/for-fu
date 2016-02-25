<%--
  Created by IntelliJ IDEA.
  User: Huy
  Date: 9/3/15
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="team.district_manager.title_page"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .modal-lg {
            width: 40%;
        }
        .modal-content{
            border-radius: 5px;
        }
    </style>
    <link rel="stylesheet" href="<c:url value="/themes/vmsreport/plugins/jquery-ui-1.11.4.custom/jquery-ui.theme.css"/>">
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin" />
</security:authorize>
<c:url var="listUrl" value="${prefix}/team/list.html"/>
<c:url var="formUrl" value="${prefix}/team/listdistrict.html"/>
<c:url var="dashboardUrl" value="/home.html"/>
<body>
<div class="content-wrapper">
    <form:form commandName="item" id="formItem" action="${formUrl}" method="post" cssClass="form-horizontal" novalidate="novalidate">
        <section class="content-header">
            <ol class="breadcrumb">
                <li><a href="${dashboardUrl}"><i class="fa fa-home"></i> <fmt:message key="label.home.title"/></a></li>
                <li><a href="${listUrl}"><fmt:message key="team.manager.title"/></a></li>
                <li class="active"><fmt:message key="team.district_manager.title_page"/></li>
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
                            <h3 class="box-title"><fmt:message key="team.district_list_manager"/> </h3>
                            <div class="filter-group">
                                <div class="btn-filter filter">
                                    <i class="fa fa-search"></i>&nbsp;<fmt:message key="label.search"/>
                                </div>
                                <div class="filter-form">
                                    <div class="filter-content">
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label"><fmt:message key="label.district"/></label>
                                            <div class="col-sm-7">
                                                <select id="districtTypeMenu" name="districtFilterType" class="form-control">
                                                    <option <c:if test="${item.districtFilterType eq Constants.IS_NOT_MANAGING}">selected="true"</c:if> value="${Constants.IS_NOT_MANAGING}"><fmt:message key="label.is_not_managing" /></option>
                                                    <option <c:if test="${item.districtFilterType eq Constants.IS_MANAGING}">selected="true"</c:if> value="${Constants.IS_MANAGING}"><fmt:message key="label.is_managing" /></option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label"><fmt:message key="team.manager.province_name" /></label>
                                            <div class="col-sm-7">
                                                <form:select path="provinceFilterCode" cssClass="form-control">
                                                    <option value=""><fmt:message key="label.all" /></option>
                                                    <c:forEach items="${provinceList}" var="provinceInfo">
                                                        <option <c:if test="${item.provinceFilterCode eq provinceInfo.provinceCode}">selected="true"</c:if> value="${provinceInfo.provinceCode}">${provinceInfo.provinceName}</option>
                                                    </c:forEach>
                                                </form:select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label"><fmt:message key="team.manager.branch_name" /></label>
                                            <div class="col-sm-7">
                                                <form:select path="branchFilterCode" cssClass="form-control">
                                                    <option value=""><fmt:message key="label.all" /></option>
                                                    <c:forEach items="${branchList}" var="branchInfo">
                                                        <option <c:if test="${item.branchFilterCode eq branchInfo.branchCode}">selected="true"</c:if> value="${branchInfo.branchCode}">${branchInfo.branchName}</option>
                                                    </c:forEach>
                                                </form:select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label"><fmt:message key="team.manager.district_name" /></label>
                                            <div class="col-sm-7">
                                                <form:select path="districtFilterCode" cssClass="form-control">
                                                    <option value=""><fmt:message key="label.all" /></option>
                                                    <c:forEach items="${districtList}" var="districtInfo">
                                                        <option <c:if test="${item.districtFilterCode eq districtInfo.districtCode}">selected="true"</c:if> value="${districtInfo.districtCode}">${districtInfo.districtName}</option>
                                                    </c:forEach>
                                                </form:select>
                                            </div>
                                        </div>
                                        <div class="box-footer text-center">
                                            <a id="btnFilterTeamManager" type="submit" class="btn btn-primary"><i class="fa fa-fw fa-search"></i><fmt:message key="label.filter"/></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="box-body">
                            <c:choose>
                            <c:when test="${item.districtFilterType eq Constants.IS_NOT_MANAGING}">
                                <display:table name="districtNotInManagerList" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                               partialList="true" sort="external"  defaultsort="0" size="${districtNotInManagerTotal}"
                                               id="tableList" pagesize="${districtNotInManagerTotal}" export="false" class="table table_vms table-hover table-bordered" style="margin: 1em 0 1.5em; width: 100%;">
                                    <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center" style="width: 3%;" >
                                        ${tableList_rowNum}
                                    </display:column>
                                    <display:column headerClass="table_header nowrap"  property="provinceName" titleKey="team.manager.province_name" class="nowrap" style="width: 15%;" />
                                    <display:column headerClass="table_header nowrap"  property="branchName" titleKey="team.manager.branch_name" class="nowrap" style="width: 15%;" />
                                    <display:column headerClass="table_header nowrap"  property="districtName" titleKey="team.manager.district_name" class="nowrap" style="width: 15%;" />
                                    <display:column headerClass="table_header" titleKey="team.manager.team_name_current" class="nowrap" style="width: 15%;" >
                                        <c:choose>
                                            <c:when test="${not empty tableList.managedByTeamName}">
                                                ${tableList.managedByTeamName}
                                            </c:when>
                                            <c:otherwise>-</c:otherwise>
                                        </c:choose>
                                    </display:column>
                                    <display:column headerClass="table_header_center" titleKey="label.start_date" class="nowrap text-center" style="width: 15%;" >
                                        <c:choose>
                                            <c:when test="${not empty tableList.startDate}">
                                                <fmt:formatDate value="${tableList.startDate}" pattern="${datePattern}" />
                                            </c:when>
                                            <c:otherwise>-</c:otherwise>
                                        </c:choose>
                                    </display:column>
                                    <display:column headerClass="table_header_center" titleKey="label.end_date" class="nowrap text-center" style="width: 15%;" >
                                        <c:choose>
                                            <c:when test="${not empty tableList.endDate}">
                                                <fmt:formatDate value="${tableList.endDate}" pattern="${datePattern}" />
                                            </c:when>
                                            <c:otherwise>-</c:otherwise>
                                        </c:choose>
                                    </display:column>
                                    <display:column headerClass="table_header_center nowrap" titleKey="label.action" class="text-center nowrap" style="width:8%;">
                                        <c:if test="${empty tableList.startDate && empty tableList.managedByTeamName}">
                                            <input type="checkbox" name="checkList" value='${tableList.districtCode}'  data-size="mini" >
                                        </c:if>
                                    </display:column>
                                    <display:setProperty name="paging.banner.item_name"><fmt:message key="team.manager.district"/></display:setProperty>
                                    <display:setProperty name="paging.banner.items_name"><fmt:message key="team.manager.district"/></display:setProperty>
                                </display:table>
                            </c:when>
                            <c:otherwise>
                                <display:table name="items.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                               partialList="true" sort="external"  defaultsort="0" size="${items.totalItems}"
                                               id="tableList" pagesize="${items.totalItems}" export="false" class="table table_vms table-hover table-bordered" style="margin: 1em 0 1.5em; width: 100%;">
                                    <display:column headerClass="table_header_center nowrap" sortable="false" class="text-center text-middle" titleKey="label.stt"  style="width: 5%;" >
                                        ${tableList_rowNum}
                                    </display:column>
                                    <display:column headerClass="table_header nowrap"  property="provinceName" titleKey="team.manager.province_name" class="nowrap text-middle" style="width: 23%;" />
                                    <display:column headerClass="table_header nowrap"  property="branchName" titleKey="team.manager.branch_name" class="nowrap text-middle" style="width: 20%;" />
                                    <display:column headerClass="table_header nowrap"  property="districtName" titleKey="team.manager.district_name" class="nowrap text-middle" style="width: 20%;" />
                                    <display:column headerClass="table_header nowrap" titleKey="label.start_date" class="nowrap text-center text-middle" style="width: 10%;" >
                                        <span id="startDateByTeamManagerId_${tableList.teamManagerId}"><fmt:formatDate value="${tableList.startDate}" pattern="${datePattern}" /></span>
                                    </display:column>
                                    <display:column headerClass="table_header nowrap" titleKey="label.end_date" class="nowrap text-center text-middle" style="width: 12%;" >
                                        <c:choose>
                                            <c:when test="${not empty tableList.endDate}">
                                                <fmt:formatDate value="${tableList.endDate}" pattern="${datePattern}"/>
                                            </c:when>
                                            <c:otherwise>
                                               <a class="btn btn-primary" data-toggle="modal" data-target=".updateEndDateModal" onclick="javascript: updateTeamManagerId(${tableList.teamManagerId});"><fmt:message key="button.update_endDate"/></a>
                                            </c:otherwise>
                                        </c:choose>
                                    </display:column>
                                    <display:column headerClass="table_header_center nowrap" titleKey="label.action" class="text-center nowrap text-middle" style="width:10%;">
                                        <input type="checkbox" name="teamManagerIds" checked value='${tableList.teamManagerId}'  data-size="mini" >
                                    </display:column>
                                    <display:setProperty name="paging.banner.item_name"><fmt:message key="team.manager.district"/></display:setProperty>
                                    <display:setProperty name="paging.banner.items_name"><fmt:message key="team.manager.district"/></display:setProperty>
                                </display:table>
                            </c:otherwise>
                            </c:choose>
                            <div class="clear"></div>
                            <div class="form-actions text-center pal">
                                <c:choose>
                                    <c:when test="${item.districtFilterType eq Constants.IS_MANAGING}">
                                        <a class="btn btn-primary" onclick="javascript: check2UpdateBeforeSubmit();"><fmt:message key="button.save"/></a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="btn btn-primary" data-toggle="modal" data-target=".confirm2ManageDistrictModal"><fmt:message key="button.save"/></a>
                                    </c:otherwise>
                                </c:choose>
                                <a href="${listUrl}" class="btn btn-primary"><fmt:message key="button.back"/></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <input type="hidden" name="crudaction" id="crudaction"/>
        <form:hidden path="pojo.team.teamId"/>
        <form:hidden id="teamManagerId" path="pojo.teamManagerId"/>

        <!-- Modal to manage district-->
        <div class="modal fade confirm2ManageDistrictModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div style="" class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button aria-hidden="true" data-dismiss="modal" class="close" type="button">&times;</button>
                        <h4 class="modal-title"><span id="confirm2ManageDistrictModalTitle"><fmt:message key="teammanager.msg.confirm_2_manage_district_tile" /></span></h4>
                    </div>
                    <div class="modal-body">
                        <div class="panel-body">
                            <div id="infoDiv" class="form-group">
                                <label class="col-sm-3 control-label"></label>
                                <div class="col-sm-8">
                                    <span id="msgInfo" class="text-note"></span>
                                </div>
                            </div>
                            <div id="confirmModalContent">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><fmt:message key="label.start_date" /></label>
                                    <div class="col-sm-8">
                                        <div class="input-append date" >
                                            <input name="startDate2Manage" id="startDate2ManageDate" class="prevent_type text-center form-control" type="text" placeholder="${symbolDateEmpty}"/>
                                            <span class="add-on" id="startDate2ManageDateIcon"><i class="icon-calendar"></i></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><fmt:message key="label.end_date" /></label>
                                    <div class="col-sm-8">
                                        <div class="input-append date" >
                                            <input name="endDate2Manage" id="endDate2ManageDate" class="prevent_type text-center form-control" type="text" placeholder="${symbolDateEmpty}"/>
                                            <span class="add-on" id="endDate2ManageDateIcon"><i class="icon-calendar"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body">
                            <div class="form-group">
                                <label class="col-sm-3 control-label"></label>
                                <div class="col-sm-8">
                                    <a id="submitUpdate2ManagingBtn" class="btn btn-success btnSubmit" onclick="javascript: validateModalManageDistrict(this);"><fmt:message key="button.save" /></a>&nbsp;
                                    <a class="btn btn-danger" onclick="javascript: hideModalManageDistrict(this);"><fmt:message key="label.cancel" /></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%--Modal to update endDate for team--%>
        <div class="modal fade updateEndDateModal" tabindex="-1" role="dialog" aria-labelledby="endDateModalLabel" aria-hidden="true">
            <div style="" class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button aria-hidden="true" data-dismiss="modal" class="close" type="button">&times;</button>
                        <h4 class="modal-title"><span id="updateEndDate4TeamTitle"><fmt:message key="teammanager.msg.update_endDate_4_team_tile" /></span></h4>
                    </div>
                    <div class="modal-body">
                        <div class="panel-body">
                            <div id="updateModalInfo" class="form-group hide">
                                <label class="col-sm-4 control-label"></label>
                                <div class="col-sm-8">
                                    <span id="updateModalInfoText" class="text-note"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label"><fmt:message key="label.choose_end_date" /></label>
                                <div class="col-sm-8">
                                    <div class="input-append date" >
                                        <input name="endDate2Update" id="endDate2UpdateDate" class="prevent_type text-center form-control" type="text" placeholder="${symbolDateEmpty}"/>
                                        <span class="add-on" id="endDate2UpdateDateIcon"><i class="icon-calendar"></i></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body">
                            <div class="form-group">
                                <label class="col-sm-3 control-label"></label>
                                <div class="col-sm-8">
                                    <a id="updateEndDate4TeamBtn" class="btn btn-success btnSubmit" onclick="javascript: validateModalUpdatingEndDate(this);"><fmt:message key="button.save" /></a>&nbsp;
                                    <a class="btn btn-danger" onclick="javascript: hideUpdatingEndDateModal(this);"><fmt:message key="label.cancel" /></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>
<script type="text/javascript">
    var allow_save_managing = false;
    $(document).ready(function(){
        // active tab
        setActiveMenu4Admin('#administration_menu', '#team_menu');

        $('#btnFilterTeamManager').click(function(){
            if($('#districtTypeMenu').val() === '${Constants.IS_NOT_MANAGING}'){
                $('#crudaction').val('search-district');
            } else {
                $('#crudaction').val('')
            }
            $("#formItem").submit();
        });
    });

    <c:choose>
        <c:when test="${item.districtFilterType eq Constants.IS_MANAGING}">
            function check2UpdateBeforeSubmit(){
                if(checkIfHasOneDistrictInRemove()){
                    bootbox.confirm('<fmt:message key="teammanager.msg.confirm_disclaim_district.title"/>','<fmt:message key="teammanager.msg.confirm_disclaim_district.content"/>', function(r) {
                        if(r){
                            $("#crudaction").val("insert-update");
                            $("#formItem").submit();
                        }
                    });
                }else{
                    $("#crudaction").val("insert-update");
                    $("#formItem").submit();
                }
            }

            function checkIfHasOneDistrictInRemove(){
                var hasAtLeastOneInRemove = false;
                $("input[name='checkList']").each(function(index, el){
                    if(!$(el).bootstrapSwitch('state')){
                        hasAtLeastOneInRemove = true;
                    }
                });
                return hasAtLeastOneInRemove;
            }

            function updateTeamManagerId(teamManagerId){
                $('#teamManagerId').val(teamManagerId);
            }

            $('.updateEndDateModal').on('show.bs.modal', function (e) {
                initializeEndDate2Update();
                $('#updateModalInfo').addClass('hide');
            });

            function initializeEndDate2Update(){
                var endDate2UpdateVar = $("#endDate2UpdateDate").datepicker({
                    dateFormat: 'dd/mm/yy',
                    minDate: 0,
                    onRender: function (date) {
                    }}).on('changeDate',function (ev) {
                            endDate2UpdateVar.hide();
                        }).data('datepicker');

                $('#endDate2UpdateDateIcon').click(function () {
                    $('#endDate2UpdateDate').focus();
                    return true;
                });
            }

            function validateModalUpdatingEndDate(btnSubmitEl){
                var modal = $(btnSubmitEl).closest('.updateEndDateModal'),
                    teamManagerId = $('#teamManagerId').val(),
                    startDateVal = $.trim($('#startDateByTeamManagerId_' + teamManagerId).html()),
                    endDateVal = $.trim($(modal).find('#endDate2UpdateDate').val());
                if(endDateVal != ''){
                    if(startDateVal != null){
                        var startDate = new Date(startDateVal.split('/')[2], eval(startDateVal.split('/')[1]) - 1, startDateVal.split('/')[0]),
                            endDate = new Date(endDateVal.split('/')[2], eval(endDateVal.split('/')[1]) - 1, endDateVal.split('/')[0]);
                        if(endDate < startDate){
                            $(modal).find('#updateModalInfo').removeClass('hide');
                            $(modal).find('#updateModalInfoText').html('<fmt:message key="teammanager.msg.confirm_2_manage_district_content.end_date_must_be_less_than_start_date" />');
                            return false;
                        }else{
                            $('#crudaction').val('insert-update');
                            $('#formItem').submit();
                        }
                    }else{
                        $(modal).find('#updateModalInfo').removeClass('hide');
                        $(modal).find('#updateModalInfoText').html('<fmt:message key="teammanager.msg.confirm_2_manage_district_content.start_date_must_not_empty" />');
                        return false;
                    }
                }else{
                    $(modal).find('#updateModalInfo').removeClass('hide');
                    $(modal).find('#updateModalInfoText').html('<fmt:message key="teammanager.msg.update_endDate_modal.not_empty_endDate" />');
                    return false;
                }
            }

            function hideUpdatingEndDateModal(fromEl){
                $(fromEl).closest('.updateEndDateModal').modal('hide');
                updateTeamManagerId('');
                $("#updateEndDate4TeamDate").datepicker('destroy');
            }
        </c:when>
        <c:otherwise>
            function hideModalManageDistrict(fromEl){
                $(fromEl).closest('.confirm2ManageDistrictModal').modal('hide');
            }

            $('.confirm2ManageDistrictModal').on('show.bs.modal', function (e) {
                if(checkIfNoCheckedDistrict2Manage()){
                    $('#msgInfo').html('<fmt:message key="teammanager.msg.confirm_2_manage_district_content.no_items" />');
                    $('#infoDiv').removeClass('hide');
                    $('#confirmModalContent').addClass('hide');
                    allow_save_managing = false;
                }else{
                    allow_save_managing = true;
                    $('#confirmModalContent').removeClass('hide');
                    $('#infoDiv').addClass('hide');
                }
                initializeStartAndEndDate2Manage();
            });

            function initializeStartAndEndDate2Manage(){
                if(allow_save_managing){
                    var startDate2ManageDateVar = $("#startDate2ManageDate").datepicker({
                        dateFormat: 'dd/mm/yy',
                        minDate: 0,
                        onRender: function (date) {
                        }}).on('changeDate',function (ev) {
                                startDate2ManageDateVar.hide();
                            }).data('datepicker');

                    $('#startDate2ManageDateIcon').click(function () {
                        $('#startDate2ManageDate').focus();
                        return true;
                    });

                    var endDate2ManageDateVar = $("#endDate2ManageDate").datepicker({
                        dateFormat: 'dd/mm/yy',
                        minDate: 0,
                        onRender: function (date) {
                        }}).on('changeDate',function (ev) {
                                endDate2ManageDateVar.hide();
                            }).data('datepicker');

                    $('#endDate2ManageDateIcon').click(function () {
                        $('#endDate2ManageDate').focus();
                        return true;
                    });
                }else{
                    $("#startDate2ManageDate").datepicker('destroy');
                    $("#endDate2ManageDate").datepicker('destroy');
                }
            }

            function validateModalManageDistrict(btnEl){
                var modal = $(btnEl).closest('.confirm2ManageDistrictModal');
                if(checkIfNoCheckedDistrict2Manage()){
                    $('#msgInfo').html('<fmt:message key="teammanager.msg.confirm_2_manage_district_content.no_items" />');
                    $('#infoDiv').removeClass('hide');
                }else{
                    $('#msgInfo').html('');
                    $('#infoDiv').addClass('hide');
                    if(checkStartAndEndDateNotEmpty()){
                        if(checkIfEndDateGreaterThanStartDate()){
                            $('#msgInfo').html('<fmt:message key="teammanager.msg.confirm_2_manage_district_content.end_date_must_be_less_than_start_date" />');
                            $('#infoDiv').removeClass('hide');
                        }else{
                            if(allow_save_managing){
                                $(btnEl).addClass('hide');
                                $('#crudaction').val('insert-update');
                                $('#formItem').submit();
                            }
                        }
                    }else{
                        $('#msgInfo').html('<fmt:message key="teammanager.msg.confirm_2_manage_district_content.start_date_must_not_empty" />');
                        $('#infoDiv').removeClass('hide');
                    }
                }
            }

            function checkStartAndEndDateNotEmpty(){
                if($('#startDate2ManageDate').val().trim() == ''){
                    return false;
                }
                return true;
            }

            function checkIfEndDateGreaterThanStartDate(){
                var startDateVar = $('#startDate2ManageDate').val(),
                    endDateVar = $('#endDate2ManageDate').val();
                if(typeof startDateVar != 'undefined' && typeof endDateVar != 'undefined'){
                    var startDate = new Date(startDateVar.split('/')[2], eval(startDateVar.split('/')[1]) -1, startDateVar.split('/')[0]),
                        endDate = new Date(endDateVar.split('/')[2], eval(endDateVar.split('/')[1]) - 1, endDateVar.split('/')[0]);
                    if(endDate < startDate){
                        return true;
                    }
                    return false;
                }
                return true;
            }

            function checkIfNoCheckedDistrict2Manage(){
                var result = true;
                $("input[name='checkList']").each(function(index, el){
                    if($(el).bootstrapSwitch('state')){
                        result = false;
                    }
                });
                return result;
            }
        </c:otherwise>
    </c:choose>
</script>
</body>
</html>