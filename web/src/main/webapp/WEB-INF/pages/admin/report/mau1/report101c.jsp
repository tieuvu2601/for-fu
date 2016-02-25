<%--
  Created by IntelliJ IDEA.
  User: vovanphuc0810
  Date: 9/10/15
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="report101B.title_page"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .freezeTableHeader .container-fixed-table-header,
        .container-scroll-body .container-fixed-column{
            width: 450px;
        }

        .freezeTableHeader .container-scroll-table-header,
        .container-scroll-body .container-scroll-content{
            width: calc(100% - 450px);
        }
    </style>
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin"></c:set>
</security:authorize>

<c:url var="homeUrl" value="/home.html"/>
<c:url var="formlUrl" value="${prefix}/report/report101C.html"/>
<c:url var="dvdnUrl" value="${prefix}/report/report101A.html"/>
<c:url var="tbcUrl" value="${prefix}/report/report101B.html"/>

<body>
<div class="content-wrapper">
<form:form commandName="item" action="${formlUrl}" id="listForm" method="post" autocomplete="off" name="listForm" cssClass="form-horizontal">
<section class="content-header">
    <ol class="breadcrumb">
        <li><a href="${homeUrl}"><i class="fa fa-fw fa-home"></i>&nbsp;<fmt:message key="label.home.title"/></a></li>
        <li class="active"><fmt:message key="report101C.title_page"/></li>
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
<div id="content" class="box box-solid box-primary">
<div class="box-header">
    <h3 class="box-title"><fmt:message key="report101C.title_page"/></h3>
    <div class="filter-group">
        <div class="btn-filter filter">
            <i class="fa fa-search"></i>&nbsp;<fmt:message key="label.search"/>
        </div>

        <div class="filter-form large">
            <div class="filter-content">
                <div class="form-group">
                    <label class="col-sm-4 control-label"><fmt:message key="label.ngay"/></label>
                    <div class="col-sm-7 input-group date-filter-input">
                        <table class="tblMonthRange two_input">
                            <tbody>
                            <tr>
                                <td>
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                </td>
                                <td><input id="startDateTimePicker" name="startDate" readonly="true" type="text" class="form-control pull-right required nohtml"
                                           value="<fmt:formatDate value="${item.startDate}" pattern="${dateTimePickerPattern}" />"></td>
                                <td>
                                    <div class="form-control no-border-left-right system-background"><fmt:message key="label.den" /></div>
                                </td>
                                <td>
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                </td>
                                <td><input id="endDateTimePicker" name="endDate" readonly="true" type="text" class="form-control pull-right required nohtml"
                                           value="<fmt:formatDate value="${item.endDate}" pattern="${dateTimePickerPattern}" />"></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label"><fmt:message key="label.subType"/></label>
                    <div class="col-sm-7">
                        <form:select id="subTypeMenu" path="pojo.subType" class="form-control">
                            <option value=""><fmt:message key="label.all" /></option>
                            <option <c:if test="${item.pojo.subType eq 'DATA'}">selected="true"</c:if> value="DATA"><fmt:message key="label.data"/></option>
                            <option <c:if test="${item.pojo.subType eq 'GOLD'}">selected="true"</c:if> value="GOLD"><fmt:message key="label.gold"/></option>
                        </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label"><fmt:message key="label.reportStyle"/></label>
                    <div class="col-sm-7">
                        <form:select id="reportStyleMenu" path="reportStyle" class="form-control">
                            <option <c:if test="${item.reportStyle eq 'DVDN'}">selected="true"</c:if> value="DVDN"><fmt:message key="menu.report101A"/></option>
                            <option <c:if test="${item.reportStyle eq 'TBC'}">selected="true"</c:if> value="TBC"><fmt:message key="menu.report101B"/></option>
                            <option <c:if test="${item.reportStyle eq 'TCTY'}">selected="true"</c:if> value="TCTY"><fmt:message key="menu.report101C"/></option>
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
<div class="form-actions text-right">
    <security:authorize ifAnyGranted="ADMIN,MANAGE_REPORT_101_FULL,MANAGE_REPORT_101_EXPORT">
        <a class="btn btn-primary" id="btnExport" type="submit"><i class="fa fa-file-excel-o"></i>&nbsp;<fmt:message key="button.export"/></a>
    </security:authorize>
</div>
    <c:if test="${not empty items.listResult && fn:length(items.listResult) gt 0}">
        <div id="reportTableContainer" style="margin-top: 10px;">
            <c:choose>
                <c:when test="${item.pojo.subType eq 'DATA'}">
                    <c:set var="monthColspan" value="${3}"/>
                    <c:set var="goldStype" value="hidden"/>
                </c:when>
                <c:when test="${item.pojo.subType eq 'GOLD'}">
                    <c:set var="monthColspan" value="${1}"/>
                    <c:set var="dataStype" value="hidden"/>
                </c:when>
                <c:otherwise>
                    <c:set var="monthColspan" value="${4}"/>
                </c:otherwise>
            </c:choose>
            <div class="freezeTableHeader">
                <div class="table-left container-fixed-table-header">
                    <table class="table table_vms table_report table-hover">
                        <thead>
                            <tr>
                                <th class="table_header_center nowrap rowspan2"><fmt:message key="label.tong_cong_ty" /></th>
                            </tr>
                        </thead>
                    </table>
                </div>
                <div class="table-left container-scroll-table-header">
                    <div class="container-scroll">
                        <table class="table table_vms table_report table-hover">
                            <thead>
                            <tr>
                                <c:set var="valColspan" value="${0}"/>
                                <c:if test="${not empty totalItems.yearFDN}">
                                    <c:set var="valColspan" value="${valColspan + 1}"/>
                                </c:if>
                                <c:if test="${not empty totalItems.yearDATA}">
                                    <c:set var="valColspan" value="${valColspan + 1}"/>
                                </c:if>
                                <c:if test="${not empty totalItems.yearGOLD}">
                                    <c:set var="valColspan" value="${valColspan + 1}"/>
                                </c:if>
                                <c:if test="${(not empty totalItems.yearFDN || not empty totalItems.yearDATA || not empty totalItems.yearGOLD) && (item.pojo.subType ne Constants.GOLD_TYPE)}">
                                    <c:set var="valColspan" value="${valColspan + 1}"/>
                                </c:if>
                                <c:if test="${valColspan > 0}">
                                    <th colspan="${monthColspan}" class="table_header_center nowrap"><fmt:message key="label.year" />&nbsp;${item.startDate.getYear() + 1900}</th>
                                </c:if>

                                <c:forEach begin="${item.startDate.getMonth() + 1}" end="${item.endDate.getMonth() + 1}" var="month">
                                    <c:set var="valColspan" value="${0}"/>
                                    <c:if test="${not empty totalItems.monthFDN[month - 1]}">
                                        <c:set var="valColspan" value="${valColspan + 1}"/>
                                    </c:if>
                                    <c:if test="${not empty totalItems.monthDATA[month - 1]}">
                                        <c:set var="valColspan" value="${valColspan + 1}"/>
                                    </c:if>
                                    <c:if test="${not empty totalItems.monthGOLD[month - 1]}">
                                        <c:set var="valColspan" value="${valColspan + 1}"/>
                                    </c:if>
                                    <c:if test="${(not empty totalItems.monthFDN[month - 1] || not empty totalItems.monthDATA[month - 1] || not empty totalItems.monthGOLD[month - 1]) && (item.pojo.subType ne Constants.GOLD_TYPE)}">
                                        <c:set var="valColspan" value="${valColspan + 1}"/>
                                    </c:if>
                                    <c:if test="${valColspan > 0}">
                                        <th colspan="${monthColspan}" class="table_header_center nowrap no_border_bottom"><fmt:message key="label.month" />&nbsp;${month}</th>
                                    </c:if>
                                </c:forEach>

                            </tr>
                            <tr>
                                <c:if test="${not empty totalItems.yearFDN}">
                                    <th class="table_header_center nowrap no_border_bottom "><fmt:message key="label.fdn" /></th>
                                </c:if>
                                <c:if test="${not empty totalItems.yearDATA}">
                                    <th class="table_header_center nowrap "><fmt:message key="label.data" /></th>
                                </c:if>
                                <c:if test="${not empty totalItems.yearGOLD}">
                                    <th class="table_header_center nowrap "><fmt:message key="label.gold" /></th>
                                </c:if>
                                <c:if test="${(not empty totalItems.yearFDN || not empty totalItems.yearDATA || not empty totalItems.yearGOLD) && (item.pojo.subType ne Constants.GOLD_TYPE)}">
                                    <th class="table_header_center nowrap "><fmt:message key="label.total" /></th>
                                </c:if>
                                <c:forEach begin="${item.startDate.getMonth() + 1}" end="${item.endDate.getMonth() + 1}" var="month">
                                    <c:if test="${not empty totalItems.monthFDN[month - 1]}">
                                        <th class="table_header_center nowrap "><fmt:message key="label.fdn" /></th>
                                    </c:if>
                                    <c:if test="${not empty totalItems.monthDATA[month - 1]}">
                                        <th class="table_header_center nowrap "><fmt:message key="label.data" /></th>
                                    </c:if>
                                    <c:if test="${not empty totalItems.monthGOLD[month - 1]}">
                                        <th class="table_header_center nowrap "><fmt:message key="label.gold" /></th>
                                    </c:if>
                                    <c:if test="${(not empty totalItems.monthFDN[month - 1] || not empty totalItems.monthDATA[month - 1] || not empty totalItems.monthGOLD[month - 1]) && (item.pojo.subType ne Constants.GOLD_TYPE)}">
                                        <th class="table_header_center nowrap "><fmt:message key="label.total" /></th>
                                    </c:if>
                                </c:forEach>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
            <div class="container-scroll-body">
                <div class="table-left container-fixed-column">
                    <table class="table table_vms table_report table-hover">
                        <tbody>
                        <c:choose>
                            <c:when test="${not empty items.listResult && fn:length(items.listResult) gt 0}">
                                <c:forEach items="${items.listResult}" var="dto" varStatus="count">
                                    <c:if test="${count.count eq fn:length(items.listResult)}">
                                        <c:set var="trClass" value="total_row text-center" />
                                    </c:if>
                                    <tr class="${trClass}">
                                        <td class="nowrap text-bold">
                                            <c:if test="${dto.cenCode ne Constants.TOTAL}">
                                                <fmt:message key="label.cong_ty"/>
                                            </c:if>
                                                ${dto.cenCode}
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="5"><fmt:message key="label.msg_no_item_found"/></td>
                                    <c:forEach begin="${item.startDate.getMonth() + 1}" end="${item.endDate.getMonth() + 1}" var="month">
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </c:forEach>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                    </table>
                </div>
                <div class="table-left container-scroll-content">
                    <table class="table table_vms table_report table-hover">
                        <tbody>
                        <c:choose>
                            <c:when test="${not empty items.listResult && fn:length(items.listResult) gt 0}">
                                <c:forEach items="${items.listResult}" var="dto1" varStatus="count1">
                                    <c:if test="${count1.count == fn:length(items.listResult)}">
                                        <c:set var="trClass1" value="total_row text-center " />
                                    </c:if>
                                    <tr class="${trClass1}">
                                        <c:if test="${not empty totalItems.yearFDN}">
                                            <td class="nowrap" align="right">
                                                <c:choose>
                                                    <c:when test="${not empty dto1.yearFDN}">
                                                        <fmt:formatNumber type="number" value="${dto1.yearFDN}" maxFractionDigits="1" />
                                                    </c:when>
                                                    <c:when test="${empty dto1.branchName}">
                                                        -
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                        </c:if>
                                        <c:if test="${not empty totalItems.yearDATA}">
                                            <td class="nowrap"  align="right">
                                                <c:choose>
                                                    <c:when test="${not empty dto1.yearDATA}">
                                                        <fmt:formatNumber type="number" value="${dto1.yearDATA}" maxFractionDigits="1" />
                                                    </c:when>
                                                    <c:when test="${empty dto1.branchName}">
                                                        -
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                        </c:if>
                                        <c:if test="${not empty totalItems.yearGOLD}">
                                            <td class="nowrap" align="right">
                                                <c:choose>
                                                    <c:when test="${not empty dto1.yearGOLD}">
                                                        <fmt:formatNumber type="number" value="${dto1.yearGOLD}" maxFractionDigits="1" />
                                                    </c:when>
                                                    <c:when test="${empty dto1.branchName}">
                                                        -
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                        </c:if>
                                        <c:if test="${(not empty totalItems.yearFDN || not empty totalItems.yearDATA || not empty totalItems.yearGOLD) && (item.pojo.subType ne Constants.GOLD_TYPE)}">
                                            <td class="nowrap " align="right">
                                                <c:choose>
                                                    <c:when test="${not empty dto1.yearFDN || not empty dto1.yearDATA || not empty dto1.yearGOLD}">
                                                        <fmt:formatNumber type="number" value="${dto1.yearFDN + dto1.yearDATA + dto1.yearGOLD}" maxFractionDigits="1" />
                                                    </c:when>
                                                    <c:when test="${empty dto1.branchName}">
                                                        -
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                        </c:if>
                                        <c:forEach begin="${item.startDate.getMonth()}" end="${item.endDate.getMonth()}" var="month">
                                            <c:if test="${not empty totalItems.monthFDN[month]}">
                                                <td class="nowrap" align="right">
                                                    <c:choose>
                                                        <c:when test="${not empty dto1.monthFDN[month]}">
                                                            <fmt:formatNumber type="number" value="${dto1.monthFDN[month]}" maxFractionDigits="1" />
                                                        </c:when>
                                                        <c:when test="${empty dto1.branchName}">
                                                            -
                                                        </c:when>
                                                    </c:choose>
                                                </td>
                                            </c:if>
                                            <c:if test="${not empty totalItems.monthDATA[month]}">
                                                <td class="nowrap" align="right">
                                                    <c:choose>
                                                        <c:when test="${not empty dto1.monthDATA[month]}">
                                                            <fmt:formatNumber type="number" value="${dto1.monthDATA[month]}" maxFractionDigits="1" />
                                                        </c:when>
                                                        <c:when test="${empty dto1.branchName}">
                                                            -
                                                        </c:when>
                                                    </c:choose>
                                                </td>
                                            </c:if>
                                            <c:if test="${not empty totalItems.monthGOLD[month]}">
                                                <td class="nowrap" align="right">
                                                    <c:choose>
                                                        <c:when test="${not empty dto1.monthGOLD[month]}">
                                                            <fmt:formatNumber type="number" value="${dto1.monthGOLD[month]}" maxFractionDigits="1" />
                                                        </c:when>
                                                        <c:when test="${empty dto1.branchName}">
                                                            -
                                                        </c:when>
                                                    </c:choose>
                                                </td>
                                            </c:if>
                                            <c:if test="${(not empty totalItems.monthFDN[month] || not empty totalItems.monthDATA[month] || not empty totalItems.monthGOLD[month]) && (item.pojo.subType ne Constants.GOLD_TYPE)}">
                                                <td class="nowrap " align="right">
                                                    <c:choose>
                                                        <c:when test="${not empty dto1.monthFDN[month] || not empty dto1.monthDATA[month] || not empty dto1.monthGOLD[month]}">
                                                            <fmt:formatNumber type="number" value="${dto1.monthFDN[month] + dto1.monthDATA[month] + dto1.monthGOLD[month]}" maxFractionDigits="1" />
                                                        </c:when>
                                                        <c:when test="${empty dto1.branchName}">
                                                            -
                                                        </c:when>
                                                    </c:choose>
                                                </td>
                                            </c:if>
                                        </c:forEach>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="5"></td>
                                    <c:forEach begin="${item.startDate.getMonth() + 1}" end="${item.endDate.getMonth() + 1}" var="month">
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </c:forEach>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                    </table>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </c:if>

</div>
</div>
</div>
</div>
</div>
</section>
<input type="hidden" name="crudaction" id="crudaction"/>
</form:form>
</div>

<script>
    $(document).ready(function(){
        setActiveMenu4Admin('#report_menu', '#report101_menu');

        $("#btnFilter").click(function(){
            $("#crudaction").val("search");
            var lbc = $('#reportStyleMenu').val();
            if (lbc == 'DVDN') {
                document.getElementById("listForm").action = "${dvdnUrl}";
            } else if(lbc == 'TBC') {
                document.getElementById("listForm").action = "${tbcUrl}";
            }
            $("#listForm").submit();
        });
        $("#btnExport").click(function(){
            $("#crudaction").val("export");
            $("#listForm").submit();
        });
        //Date range picker
        initStartDateTimePicker();
        initEndDateTimePicker();

        <c:if test="${empty item.crudaction}">
        $('.btn-filter').first().closest('.filter-group').find('.filter-form').toggle('slide', {direction: 'right'});
        </c:if>

        $('.container-scroll-content').scroll(function(event){
            $('.container-scroll-table-header table', '.freezeTableHeader').css('margin-left', (0 - event.target.scrollLeft));
        });

        collapseSideBarMenu();
        updateWidth4TableReport('last-child');
    });

    function initStartDateTimePicker(){
        $('#startDateTimePicker').datetimepicker({
            startView: 3,
            format: 'mm/yyyy',
            language: 'vi',
            todayBtn: true,
            todayHighlight: true,
            autoclose: true,
            minView: 3      // force only shoe Month and Year to select without selecting date and hour.
        }).on('hide', function(ev){
                    updateMinAndMaxRange4EndDateTimePicker();
                });
    }

    function initEndDateTimePicker(){
        $('#endDateTimePicker').datetimepicker({
            startView: 3,
            format: 'mm/yyyy',
            language: 'vi',
            todayBtn: true,
            todayHighlight: true,
            autoclose: true,
            minView: 3      // force only shoe Month and Year to select without selecting date and hour.
        });

        updateMinAndMaxRange4EndDateTimePicker();
    }

    function updateMinAndMaxRange4EndDateTimePicker(){
        var selectedStartDateVal = $('#startDateTimePicker').val(),
                selectedEndDateVal = $('#endDateTimePicker').val(),
                yearStartDateVal = eval(selectedStartDateVal.split('/')[1]),
                monthStartDateVal = eval(selectedStartDateVal.split('/')[0]),
                yearEndDateVal = eval(selectedEndDateVal.split('/')[1]),
                monthEndDateVal = eval(selectedEndDateVal.split('/')[0]),
                min_endDate = new Date(yearStartDateVal, monthStartDateVal - 1, 1),
                max_endDate = new Date(yearStartDateVal + 1, 1, 0),
                selectedStartDateObj = new Date(yearStartDateVal, monthStartDateVal, 1),
                selectedEndDateObj = new Date(yearEndDateVal, monthEndDateVal, 1);

        $('#endDateTimePicker').datetimepicker('setStartDate', min_endDate);
        $('#endDateTimePicker').datetimepicker('setEndDate', max_endDate);

        if(selectedStartDateObj > selectedEndDateObj){
            $('#endDateTimePicker').val((monthStartDateVal > 9 ? monthStartDateVal : '0' + monthStartDateVal) + '/' + yearStartDateVal);
            $('#endDateTimePicker').datetimepicker('update');
        }else if(yearStartDateVal < yearEndDateVal){
            $('#endDateTimePicker').val('12/' + yearStartDateVal);
            $('#endDateTimePicker').datetimepicker('update');
        }
    }
</script>
</body>
</html>