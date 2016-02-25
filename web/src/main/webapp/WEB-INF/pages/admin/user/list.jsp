<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="user.manager"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin"></c:set>
</security:authorize>

<c:url var="homeUrl" value="/index.html"/>
<c:url var="formlUrl" value="${prefix}/user/list.html"/>
<c:url var="editUrl" value="${prefix}/user/edit.html"/>
<c:url var="addUrl" value="${prefix}/user/add.html"/>
<c:url var="backUrl" value="${prefix}/index.html"/>
<c:url var="permissionUrl" value="${prefix}/user/permission.html"/>
<body>
<div class="content-wrapper">
    <div class="container">
        <form:form commandName="item" action="${formlUrl}" id="listForm" method="post" autocomplete="off" name="listForm" cssClass="form-horizontal">
            <section class="content-header">
                <h4>
                    <fmt:message key="user.manager"/>
                    <%--<small><fmt:message key="user.manager.list"/></small>--%>
                </h4>
                <ol class="breadcrumb">
                    <li><a href="${homeUrl}"><i class="fa fa-fw fa-home"></i>&nbsp;<fmt:message key="label.home.title"/></a></li>
                    <%--<li><fmt:message key="menu.administration"/></li>--%>
                    <li class="active"><fmt:message key="user.manager"/></li>
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
                            <div class="box-header with-border">
                                <h3 class="box-title"><strong><fmt:message key="user.manager.list"/></strong></h3>
                                <div class="filter-group">
                                    <div class="btn-filter filter">
                                        <i class="fa fa-search"></i>&nbsp;<fmt:message key="label.search"/>
                                    </div>
                                    <div class="filter-form">
                                        <div class="filter-content">
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label"><fmt:message key="user.manager.username"/></label>
                                                <div class="col-sm-7">
                                                    <form:input path="pojo.userName" cssClass="form-control input-xs"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label"><fmt:message key="user.manager.displayName"/></label>
                                                <div class="col-sm-7">
                                                    <form:input path="pojo.displayName" cssClass="form-control input-xs"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label"><fmt:message key="user.manager.usergroup"/></label>
                                                <div class="col-sm-7">
                                                    <form:select path="pojo.userGroup.userGroupId" cssClass="form-control input-xs select3 autocomplete" cssStyle="width: 100%">
                                                        <form:option value=""><fmt:message key="label.all"/></form:option>
                                                        <form:options items="${userGroups}" itemLabel="name" itemValue="userGroupId"/>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label"><fmt:message key="user.manager.email"/></label>
                                                <div class="col-sm-7">
                                                    <form:input path="pojo.email" cssClass="form-control input-xs"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label"><fmt:message key="user.manager.status"/></label>
                                                <div class="col-sm-7">
                                                    <form:select path="pojo.status" cssClass="form-control input-xs select3 autocomplete" cssStyle="width: 100%">
                                                        <form:option value=""><fmt:message key="label.all"/></form:option>
                                                        <form:option value="1"><fmt:message key="user.manager.status.active"/></form:option>
                                                        <form:option value="0"><fmt:message key="user.manager.status.disable"/></form:option>
                                                    </form:select>
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
                                <div class="text-right">
                                    <security:authorize ifAnyGranted="ADMIN,TP,MANAGE_USER_FULL,MANAGE_USER_ADD">
                                        <a class="btn btn-primary btn-sm daterange" href="${addUrl}"><i class="fa fa-fw fa-plus"></i> <fmt:message key="button.add"/></a>
                                    </security:authorize>
                                </div>
                                <display:table name="items.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                               partialList="true" sort="external" size="${items.totalItems}" defaultsort="0"
                                               id="tableList" pagesize="${Constants.MAXPAGEITEMS}" export="false" class="table table_vms table-bordered table-hover table-striped" style="margin: 1em 0 1.5em; width: 100%;">

                                    <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center" style="width: 5%;">
                                        ${tableList_rowNum + (page * Constants.MAXPAGEITEMS)}
                                    </display:column>
                                    <display:column headerClass="table_header nowrap" sortable="true" property="userName" sortName="userName" escapeXml="true" titleKey="user.manager.username" class="nowrap" style="width: 15%;" />
                                    <display:column headerClass="table_header nowrap" sortable="true" property="email" sortName="email" escapeXml="true" titleKey="user.manager.email" class="nowrap" style="width: 20%;" />
                                    <display:column headerClass="table_header nowrap" sortable="true" property="displayName" sortName="displayName" escapeXml="true" titleKey="user.manager.displayName" class="nowrap" style="width: 20%;"/>

                                    <display:column headerClass="table_header_center nowrap" sortable="true" property="userGroup.name" sortName="userGroup.name" escapeXml="true" titleKey="user.manager.usergroup" class="nowrap text-center" style="width: 10%;"/>

                                    <display:column headerClass="table_header_center nowrap" sortable="true" sortName="status" escapeXml="true" titleKey="user.manager.status" class="nowrap text-center" style="width: 10%;">
                                        <c:choose>
                                            <c:when test="${tableList.status eq 1}">
                                                <fmt:message key="user.manager.status.active"/>
                                            </c:when>
                                            <c:otherwise>
                                                <fmt:message key="user.manager.status.disable"/>
                                            </c:otherwise>
                                        </c:choose>
                                    </display:column>

                                    <display:column headerClass="table_header_center nowrap" sortable="true" sortName="createdDate" escapeXml="true" titleKey="user.manager.createddate" class="nowrap text-center" style="width: 10%;">
                                        <fmt:formatDate value="${tableList.createdDate}" pattern="${datePattern}"/>
                                    </display:column>

                                    <display:column headerClass="table_header_center nowrap" titleKey="label.action" class="text-center nowrap" style="width:10%;">
                                        <c:set var="linkCounter" value="1" />
                                        <%--<security:authorize ifAnyGranted="ADMIN,TP,MANAGE_USER_FULL,MANAGE_USER_PERMISSION">--%>
                                        <%--<c:set var="linkCounter" value="${linkCounter +  1}" />--%>
                                        <%--<a href="${permissionUrl}?pojo.users.userId=${tableList.userId}" class="tip-top" title="<fmt:message key="label.authorize" />"><i class="fa fa-key"></i></a>--%>
                                        <%--</security:authorize>--%>
                                        <security:authorize ifAnyGranted="ADMIN,MANAGE_USER_FULL,MANAGE_USER_EDIT,TP">
                                            <c:set var="linkCounter" value="${linkCounter +  1}" />
                                            <%--<c:if test="${linkCounter gt 1}">--%>
                                            <%--&nbsp;|&nbsp;--%>
                                            <%--</c:if>--%>
                                            <a href="${editUrl}?pojo.userId=${tableList.userId}" class="tip-top" title="<fmt:message key="label.edit" />"><i class="fa fa-pencil-square-o"></i></a>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="ADMIN,TP,MANAGE_USER_FULL,MANAGE_USER_DELETE,TP">
                                            <c:set var="linkCounter" value="${linkCounter +  1}" />
                                            <c:if test="${linkCounter gt 1}">
                                                &nbsp;|&nbsp;
                                            </c:if>
                                            <a class="tip-top deleteLink" id="${tableList.userId}" title="<fmt:message key="label.delete" />"><i class="fa fa-times"></i></a>
                                        </security:authorize>
                                    </display:column>
                                    <display:setProperty name="paging.banner.item_name"><fmt:message key="user.manager.title"/></display:setProperty>
                                    <display:setProperty name="paging.banner.items_name"><fmt:message key="user.manager.title"/></display:setProperty>
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
        setActiveMenu4Admin('#administration_menu', '#user_menu');
        $('.select3').select2();
        $(".deleteLink").click(function(){
            var id = $(this).attr("id");
            if (id != null && id != undefined){
                bootbox.confirm('<fmt:message key="database.delete.confirm.message.title"/>','<fmt:message key="user.confirm_delete"/>', function(r) {
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