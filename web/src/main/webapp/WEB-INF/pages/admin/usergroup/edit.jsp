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
    <title><fmt:message key="usergroup.manager.title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin" />
</security:authorize>

<c:url var="backUrl" value="${prefix}/usergroup/list.html"/>
<c:url var="formUrl" value="${prefix}/usergroup/edit.html"/>
<c:url var="dashboardUrl" value="home.html"/>
<body>
<div class="content-wrapper">
    <form:form commandName="item" id="formItem" action="${formUrl}" method="post" cssClass="form-horizontal" novalidate="novalidate">
    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="${dashboardUrl}"><i class="fa fa-home"></i> <fmt:message key="label.home.title"/></a></li>
            <li><fmt:message key="menu.administration"/></li>
            <li><a href="${backUrl}"><fmt:message key="usergroup.manager"/></a></li>
            <li class="active">
                <c:choose>
                    <c:when test="${not empty item.pojo.userGroupId}">
                        <fmt:message key="usergroup.manager.edit_usergroup"/>
                    </c:when>
                    <c:otherwise>
                        <fmt:message key="usergroup.manager.add_new_usergroup"/>
                    </c:otherwise>
                </c:choose>
            </li>
        </ol>
    </section>


    <!-- Main content -->
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
                    <div class="box-header with-border">
                        <c:choose>
                            <c:when test="${not empty item.pojo.userGroupId}">
                                <h3 class="box-title"><fmt:message key="usergroup.manager.edit_usergroup"/></h3>
                            </c:when>
                            <c:otherwise>
                                <h3 class="box-title"><fmt:message key="usergroup.manager.add_new_usergroup"/></h3>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div class="box-body">
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><fmt:message key="usergroup.manager.code"/></label>
                            <div class="col-sm-7">
                                <form:input path="pojo.code" cssClass="form-control required"/>
                                <spring:bind path="pojo.code">
                                    <c:if test="${status.error}">
                                        <div class="tooltip fade top in" onclick="javascript: $(this).remove();" style="display: block; top: -37px; left: 80px;">
                                            <div class="tooltip-arrow"></div>
                                            <div class="tooltip-inner">${status.errorMessage}</div>
                                        </div>
                                    </c:if>
                                </spring:bind>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><fmt:message key="usergroup.manager.name"/></label>
                            <div class="col-sm-7">
                                <form:input path="pojo.name" cssClass="form-control required"/>
                                <spring:bind path="pojo.name">
                                    <c:if test="${status.error}">
                                        <div class="tooltip fade top in" onclick="javascript: $(this).remove();" style="display: block; top: -37px; left: 80px;">
                                            <div class="tooltip-arrow"></div>
                                            <div class="tooltip-inner">${status.errorMessage}</div>
                                        </div>
                                    </c:if>
                                </spring:bind>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><fmt:message key="label.is_center"/></label>
                            <div class="col-sm-7 bootstrap_switch">
                                <input type="checkbox" name="pojo.center" id="idCenter" <c:if test="${item.pojo.center eq Constants.USER_ACTIVE}">checked</c:if> value="${Constants.USER_ACTIVE}" data-size="mini"/>
                            </div>
                        </div>
                    </div>

                    <div class="box-footer text-center">
                        <a id="btnSave" class="btn btn-primary"><i class="fa fa-fw fa-save"></i> <fmt:message key="button.save"/></a>
                        <a class="btn cancel-link" href="${backUrl}"><fmt:message key="button.cancel"/></a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <form:hidden path="crudaction" id="crudaction"/>
    <form:hidden path="pojo.userGroupId"/>
</div>
</form:form>
<script type="text/javascript">
    $(document).ready(function(){
        // active tab
        setActiveMenu4Admin('#administration_menu', '#usergroup_menu');

        $("#btnSave").click(function(){
            if($('#formItem').valid()){
                $("#crudaction").val("insert-update");
                $("#formItem").submit();
            }
        });
    });
</script>
</body>
</html>