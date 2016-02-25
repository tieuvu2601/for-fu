<%--
  Created by IntelliJ IDEA.
  User: Huy
  Date: 9/30/15
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="repository" uri="http://banvien.com/tags/repository" %>
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
<c:url var="backUrl" value="/home.html"/>
<c:url var="formlUrl" value="${prefix}/user/profileedit.html"/>
<c:url var="dashboardUrl" value="/home.html"/>

<body>
<div class="content-wrapper">
    <form:form commandName="item" id="formItem" action="${formUrl}" method="post" cssClass="form-horizontal" validate="validate" enctype="multipart/form-data">
        <section class="content-header">
            <ol class="breadcrumb">
                <li><a href="${dashboardUrl}"><i class="fa fa-fw fa-home"></i><fmt:message key="label.home.title"/></a></li>
                <li class="active">
                    <fmt:message key="user.edit"/>
                </li>
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
                        <div class="box-header with-border">
                            <h3 class="box-title"><fmt:message key="user.edit"/></h3>
                        </div>
                        <div class="box-body">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-5 control-label"><fmt:message key="user.manager.username"/></label>
                                    <div class="col-sm-7">
                                        <form:input path="pojo.userName" cssClass="form-control required" data-trigger="focus"/>
                                        <spring:bind path="pojo.userName">
                                            <c:if test="${status.error}">
                                                <div class="tooltip fade top in" onclick="javascript: $(this).remove();" style="display: block; top: -37px; left: 80px;">
                                                    <div class="tooltip-arrow"></div>
                                                    <div class="tooltip-inner">${status.errorMessage}</div>
                                                </div>
                                            </c:if>
                                        </spring:bind>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-5 control-label"><fmt:message key="user.manager.email"/></label>
                                    <div class="col-sm-7">
                                        <form:input path="pojo.email" cssClass="form-control"/>
                                        <spring:bind path="pojo.email">
                                            <c:if test="${status.error}">
                                                <div class="tooltip fade top in" onclick="javascript: $(this).remove();" style="display: block; top: -37px; left: 80px;">
                                                    <div class="tooltip-arrow"></div>
                                                    <div class="tooltip-inner">${status.errorMessage}</div>
                                                </div>
                                            </c:if>
                                        </spring:bind>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-5 control-label"><fmt:message key="user.manager.password"/></label>
                                    <div class="col-sm-7">
                                        <div class="input-group">
                                                <span class="input-group-btn">
                                                    <%--<form:password style="width: 213px;" path="pojo.password" id="password" autocomplete="false" cssClass="form-control required" />--%>
                                                    <input type="password"  style="width: 213px;" name="pojo.password" id="password" autocomplete="off" class="form-control <c:if test="${!(item.pojo.LDAP eq Constants.USER_LDAP)}">required</c:if>" value="<c:out value='${item.pojo.password}' escapeXml="true"/>" />
                                                    <button class="btn btn-info btn-flat" type="button" id="btnShowHidePassword">Xem</button>
                                                    <spring:bind path="pojo.password">
                                                        <c:if test="${status.error}">
                                                            <div class="tooltip fade top in" onclick="javascript: $(this).remove();" style="display: block; top: -37px; left: 80px;">
                                                                <div class="tooltip-arrow"></div>
                                                                <div class="tooltip-inner">${status.errorMessage}</div>
                                                            </div>
                                                        </c:if>
                                                    </spring:bind>
                                                </span>
                                        </div>
                                    </div>
                                </div><!-- /input-group -->
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-5 control-label"><fmt:message key="user.manager.displayName"/></label>
                                    <div class="col-sm-7">
                                        <form:input path="pojo.displayName" cssClass="form-control required"/>
                                        <spring:bind path="pojo.displayName">
                                            <c:if test="${status.error}">
                                                <div class="tooltip fade top in" onclick="javascript: $(this).remove();" style="display: block; top: -37px; left: 80px;">
                                                    <div class="tooltip-arrow"></div>
                                                    <div class="tooltip-inner">${status.errorMessage}</div>
                                                </div>
                                            </c:if>
                                        </spring:bind>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-5 control-label"><fmt:message key="user.manager.usergroup"/></label>
                                    <div class="col-sm-7">
                                        <form:input path="pojo.userGroup.name" cssClass="form-control required" disabled="true"/>
                                        <spring:bind path="pojo.userGroup.userGroupId">
                                            <c:if test="${status.error}">
                                                <div class="tooltip fade top in" onclick="javascript: $(this).remove();" style="display: block; top: -37px; left: 80px;">
                                                    <div class="tooltip-arrow"></div>
                                                    <div class="tooltip-inner">${status.errorMessage}</div>
                                                </div>
                                            </c:if>
                                        </spring:bind>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-5 control-label"><fmt:message key="user.manager.status"/></label>
                                    <div class="col-sm-7 bootstrap_switch">
                                        <c:choose>
                                            <c:when test="${not empty item.pojo.userId}">
                                                <input type="checkbox" name="pojo.status" id="status" <c:if test="${item.pojo.status eq Constants.USER_ACTIVE}">checked</c:if> value="${Constants.USER_ACTIVE}" data-size="mini" disabled=""/>
                                            </c:when>
                                            <c:otherwise>
                                                <input type="checkbox" name="pojo.status" id="status" checked value="${Constants.USER_ACTIVE}" data-size="mini"/>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                            <div class="clear"></div>

                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-5 control-label"><fmt:message key="label.department.name"/></label>
                                    <div class="col-sm-7">
                                        <form:input path="pojo.department.name" cssClass="form-control required" disabled="true"/>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-5 control-label"><fmt:message key="user.manager.user_type"/></label>
                                    <div class="col-sm-7">
                                        <c:choose>
                                            <c:when test="${item.pojo.LDAP eq Constants.USER_LDAP}">
                                                <input type="text" class="form-control" placeholder="<fmt:message key="user.manager.ldap.ldap"/>" disabled="">
                                            </c:when>
                                            <c:when test="${item.pojo.LDAP eq Constants.USER_LOCAL}">
                                                <input type="text" class="form-control" placeholder="<fmt:message key="user.manager.ldap.local"/>" disabled="">
                                            </c:when>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                            <div class="clear"></div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-5 control-label"><fmt:message key="user.manager.avatar"/></label>
                                    <div class="col-sm-7">
                                        <input id="avatarFileUpload" type="file" name="pojo.avatarFileItem" accept="image/x-png, image/gif, image/jpeg" />
                                            <%--<c:choose>--%>
                                            <%--<c:when test="${not empty item.pojo.userId}">--%>
                                            <%--<div id="avatar_form" class="nowrap">--%>
                                            <%--<c:choose>--%>
                                            <%--<c:when test="${not empty item.pojo.avatar}">--%>
                                            <%--<span id="avatar_text">--%>
                                            <%--<repository:href value="${item.pojo.avatar}" displayName="${fn:replace(item.pojo.avatar, Constants.CONTENT_PATH_JCR_AVATAR, '')}"/>--%>
                                            <%--<input type="hidden" name="pojo.avatar" value="${item.pojo.avatar}" />--%>
                                            <%--</span>--%>
                                            <%--<a id="linkChangeAvatar" class="tip-top" title="<fmt:message key="label.change_avatar" />" onclick="javascript: changeAvatar();">&nbsp;&nbsp;<i class="fa fa-upload"></i></a>--%>
                                            <%--</c:when>--%>
                                            <%--<c:otherwise>--%>
                                            <%--<input id="avatarFileUpload" type="file" name="pojo.avatarFileItem" accept="image/x-png, image/gif, image/jpeg" />--%>
                                            <%--</c:otherwise>--%>
                                            <%--</c:choose>--%>
                                            <%--</div>--%>
                                            <%--</c:when>--%>
                                            <%--<c:otherwise>--%>
                                            <%--<input id="avatarFileUpload" type="file" name="pojo.avatarFileItem" />--%>
                                            <%--</c:otherwise>--%>
                                            <%--</c:choose>--%>
                                        <spring:bind path="pojo.avatarFileItem">
                                            <c:if test="${status.error}">
                                                <div class="tooltip fade top in" onclick="javascript: $(this).remove();" style="display: block; top: -37px; left: 80px;">
                                                    <div class="tooltip-arrow"></div>
                                                    <div class="tooltip-inner">${status.errorMessage}</div>
                                                </div>
                                            </c:if>
                                        </spring:bind>
                                    </div>
                                </div>
                            </div>


                        </div>

                        <div class="box-footer text-center">
                            <a id="btnSave" class="btn btn-primary"><i class="fa fa-fw fa-save"></i> <fmt:message key="button.save"/></a>
                            <a class="btn cancel-link" href="${backUrl}"><fmt:message key="button.cancel"/></a>
                        </div>
                    </div>

                        <%--Danh sach phan quyen Quan / Huyen cua user--%>
                    <div class="box box-solid box-primary">
                        <div class="box-header">
                            <h3 class="box-title"><fmt:message key="department.manager.district_list_permission"/></h3>
                        </div>

                        <div class="box-body">
                            <div id="reportTableContainer" class="scroll_table_container">
                                <display:table name="districtPermissionList" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                               partialList="true" sort="external" size="${fn:length(districtPermissionList)}" defaultsort="0"
                                               id="districtPermissionListTable" pagesize="${fn:length(districtPermissionList)}" export="false" class="table table_vms table-hover table-bordered" style="margin: 1em 0 1.5em; width: 100%;">
                                    <display:column headerClass="table_header_center nowrap" sortable="false" titleKey="label.stt" class="text-center" style="width: 10%;">${districtPermissionList_rowNum}</display:column>
                                    <display:column headerClass="table_header_center nowrap" titleKey="label.province" property="provinceName" class="nowrap" style="width: 30%;" />
                                    <display:column headerClass="table_header_center nowrap" titleKey="label.branch" property="branchName" class="nowrap" style="width: 30%;" />
                                    <display:column headerClass="table_header_center nowrap" titleKey="label.quan_huyen" property="districtName" class="nowrap" style="width: 30%;" />
                                    <display:setProperty name="paging.banner.item_name"><fmt:message key="label.phan_quyen.item"/></display:setProperty>
                                    <display:setProperty name="paging.banner.items_name"><fmt:message key="label.phan_quyen.item"/></display:setProperty>
                                </display:table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <input type="hidden" name="crudaction" id="crudaction" value=""/>
        <form:hidden path="pojo.userId"/>
        <form:hidden path="pojo.LDAP"/>
        <form:hidden path="pojo.userGroup.userGroupId"/>
        <form:hidden path="pojo.department.departmentId"/>
    </form:form>
</div>

<script>
    $(document).ready(function(){
        // active tab
//        setActiveMenu4Admin('#administration_menu', '#user_menu');

        $("#btnSave").click(function(){
            if($('#formItem').valid()){
                $('#crudaction').val('insert-update');
                $("#formItem").submit();
            }
        });
    });

    function changeAvatar(){
        $('#avatar_text').remove();
        $('#linkChangeAvatar').remove();
        $('.tooltip').remove();
        $("<input id='avatarFileUpload' type='file' name='pojo.avatarFileItem'  accept='image/x-png, image/gif, image/jpeg' />").appendTo('#avatar_form');
    }
</script>
</body>
</html>
