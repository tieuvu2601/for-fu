<%--
  Created by IntelliJ IDEA.
  User: vovanphuc0810
  Date: 9/3/15
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="employee.title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin" />
</security:authorize>
<c:url var="listUrl" value="${prefix}/team/list.html"/>
<c:url var="formUrl" value="${prefix}/team/empcodelist.html"/>
<c:url var="dashboardUrl" value="/home.html"/>
<body>
<div class="content-wrapper">
    <form:form commandName="item" id="formItem" action="${formUrl}" method="post" cssClass="form-horizontal" novalidate="novalidate">
        <section class="content-header">
            <ol class="breadcrumb">
                <li><a href="${dashboardUrl}"><i class="fa fa-home"></i>Home</a></li>
                <li><a href="${listUrl}"><fmt:message key="team.manager.title"/></a></li>
                <li class="active"><fmt:message key="employee.title"/></li>
            </ol>
            <c:if test="${not empty messageResponse}">
                <div class="alert alert-message  alert-${alertType}">
                    <a class="close" data-dismiss="alert" href="#">&times;</a> ${messageResponse}
                </div>
            </c:if>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-sm-12">
                    <div class="box box-solid box-primary">
                        <div class="box-header">
                            <h3 class="box-title"><fmt:message key="employee.title"/></h3>
                            <div class="filter-group">
                                <div class="btn-filter filter">
                                    <i class="fa fa-search"></i>&nbsp;<fmt:message key="label.search"/>
                                </div>
                                <div class="filter-form">
                                    <div class="filter-content">
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
                            <display:table name="items.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                           partialList="true" sort="external" size="${items.totalItems}" defaultsort="0"
                                           id="tableList" pagesize="${items.maxPageItems}" export="false" class="table table_vms table-hover table-bordered" style="margin: 1em 0 1.5em; width: 100%;">
                                <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center" style="width: 5%;">
                                    ${tableList_rowNum + (page * Constants.MAXPAGEITEMS)}
                                </display:column>
                                <display:column headerClass="table_header nowrap"  property="provinceName" titleKey="team.manager.province_name" class="nowrap" style="width: 20%;" />
                                <display:column headerClass="table_header nowrap"  property="branchName" titleKey="team.manager.branch_name" class="nowrap" style="width: 20%;" />
                                <display:column headerClass="table_header nowrap"  property="districtName" titleKey="team.manager.district_name" class="nowrap" style="width: 20%;" />
                                <display:column headerClass="table_header_center nowrap" sortable="true" property="empCode" sortName="emp_Code" escapeXml="true" titleKey="employee.empCode" class="nowrap text-center" style="width: 15%;" />
                                <display:column headerClass="table_header nowrap" sortable="true" property="empName" sortName="emp_Name" escapeXml="true" titleKey="employee.empName" class="nowrap" style="width: 20%;" />


                                <display:setProperty name="paging.banner.item_name"><fmt:message key="employee.employee"/></display:setProperty>
                                <display:setProperty name="paging.banner.items_name"><fmt:message key="employee.employee"/></display:setProperty>
                            </display:table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <form:hidden path="crudaction" id="crudaction"/>
        <form:hidden path="pojo.team.teamId" />
    </form:form>
</div>

<script type="text/javascript">
    $(document).ready(function(){
        // active tab
        setActiveMenu4Admin('#administration_menu', '#team_menu');

        $('#btnFilterTeamManager').click(function(){
            $("#formItem").submit();
        });
    });
</script>
</body>
</html>