<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="department.manager.title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin"></c:set>
</security:authorize>

<c:url var="homeUrl" value="/index.html"/>
<c:url var="formlUrl" value="${prefix}/department/list.html"/>
<c:url var="editUrl" value="${prefix}/department/edit.html"/>
<c:url var="addUrl" value="${prefix}/department/add.html"/>
<c:url var="backUrl" value="${prefix}/index.html"/>
<body>
<div class="content-wrapper">
    <div class="container">
        <form:form commandName="item" action="${formlUrl}" id="listForm" method="post" autocomplete="off" name="listForm" cssClass="form-horizontal">
            <section class="content-header">
                <h4>
                    <fmt:message key="department.manager.title"/>
                        <%--<small><fmt:message key="user.manager.list"/></small>--%>
                </h4>
                <ol class="breadcrumb">
                    <li><a href="${homeUrl}"><i class="fa fa-fw fa-home"></i>&nbsp;<fmt:message key="label.home.title"/></a></li>
                    <li class="active"><fmt:message key="department.manager.title"/></li>
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
                                <h3 class="box-title"><fmt:message key="department.manager.form_list.title"/></h3>
                                <div class="filter-group">
                                    <div class="btn-filter filter">
                                        <i class="fa fa-search"></i>&nbsp;<fmt:message key="label.search"/>
                                    </div>

                                    <div class="filter-form">
                                        <div class="filter-content">
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label"><fmt:message key="label.department.code"/></label>
                                                <div class="col-sm-7">
                                                    <form:input path="pojo.code" cssClass="form-control input-xs"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label"><fmt:message key="label.department.name"/></label>
                                                <div class="col-sm-7">
                                                    <form:input path="pojo.name" cssClass="form-control input-xs"/>
                                                </div>
                                            </div>
                                            <div class="box-footer text-center">
                                                <a id="btnFilter" type="submit" class="btn btn-sm btn-primary"><i class="fa fa-fw fa-search"></i><fmt:message key="label.search"/></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="box-body">
                                <div class="form-actions text-right">
                                    <security:authorize ifAnyGranted="ADMIN,MANAGE_DEPARTMENT_FULL,MANAGE_DEPARTMENT_ADD">
                                        <a class="btn btn-primary btn-sm" href="${addUrl}"><i class="fa fa-fw fa-plus"></i> <fmt:message key="button.add"/></a>
                                    </security:authorize>
                                </div>
                                <display:table name="items.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                               partialList="true" sort="external" size="${items.totalItems}" defaultsort="0"
                                               id="tableList" pagesize="${Constants.MAXPAGEITEMS}" export="false" class="table table_vms table-bordered table-hover table-striped" style="margin: 1em 0 1.5em; width: 100%;">

                                    <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center" style="width: 10%;">
                                        ${tableList_rowNum + (page * Constants.MAXPAGEITEMS)}
                                    </display:column>
                                    <display:column headerClass="table_header nowrap" sortable="true" property="code" sortName="code" escapeXml="true" titleKey="label.department.code" class="nowrap" style="width: 20%;" />
                                    <display:column headerClass="table_header nowrap" sortable="true" property="name" sortName="name" escapeXml="true" titleKey="label.department.name" class="nowrap" style="width: 60%;" />

                                    <security:authorize ifAnyGranted="ADMIN,MANAGE_DEPARTMENT_FULL,MANAGE_DEPARTMENT_EDIT,MANAGE_DEPARTMENT_DELETE">
                                        <display:column headerClass="table_header_center nowrap" titleKey="label.action" class="text-center nowrap" style="width:10%;">
                                            <c:set var="linkCounter" value="1" />
                                            <security:authorize ifAnyGranted="ADMIN,MANAGE_DEPARTMENT_FULL,MANAGE_DEPARTMENT_EDIT">
                                                <c:set var="linkCounter" value="${linkCounter +  1}" />
                                                <a href="${editUrl}?pojo.departmentId=${tableList.departmentId}" class="tip-top" title="<fmt:message key="label.edit" />"><i class="fa fa-pencil-square-o"></i></a>
                                            </security:authorize>
                                            <security:authorize ifAnyGranted="ADMIN,MANAGE_DEPARTMENT_FULL,MANAGE_DEPARTMENT_DELETE">
                                                <c:set var="linkCounter" value="${linkCounter +  1}" />
                                                <c:if test="${linkCounter gt 1}">
                                                    &nbsp;|&nbsp;
                                                </c:if>
                                                <a class="tip-top deleteLink" id="${tableList.departmentId}" title="<fmt:message key="label.delete" />"><i class="fa fa-times"></i></a>
                                            </security:authorize>
                                        </display:column>
                                    </security:authorize>
                                    <display:setProperty name="paging.banner.item_name"><fmt:message key="label.department.item"/></display:setProperty>
                                    <display:setProperty name="paging.banner.items_name"><fmt:message key="label.department.item"/></display:setProperty>
                                </display:table>
                            </div>
                        </div>
                    </div>
                </div>
                <form:hidden path="crudaction" id="crudaction"/>
            </section>
        </form:form>
    </div>
</div>
<script>
    $(document).ready(function(){
        setActiveMenu4Admin('#Category_menu', '#department_menu');

        $(".deleteLink").click(function(){
            var id = $(this).attr("id");
            if (id != null && id != undefined){
                bootbox.confirm('<fmt:message key="database.delete.confirm.message.title"/>','<fmt:message key="department.manager.form_delete_content"/>', function(r) {
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