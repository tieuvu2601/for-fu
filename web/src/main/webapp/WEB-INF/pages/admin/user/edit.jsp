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
<c:url var="backUrl" value="${prefix}/user/list.html"/>
<c:url var="formlUrl" value="${prefix}/user/add.html"/>
<c:if test="${not empty item.pojo.userId}">
    <c:url var="formlUrl" value="${prefix}/user/edit.html"/>
</c:if>
<c:url var="dashboardUrl" value="/home.html"/>

<body>
<div class="content-wrapper">
    <div class="container">
        <form:form commandName="item" id="formItem" action="${formUrl}" method="post" cssClass="form-horizontal" validate="validate" enctype="multipart/form-data">
        <section class="content-header">
            <h1>
                <fmt:message key="user.manager"/>
                <c:choose>
                    <c:when test="${not empty item.pojo.userId}">
                        <small><fmt:message key="user.edit"/></small>
                    </c:when>
                    <c:otherwise>
                        <small><fmt:message key="user.add"/></small>
                    </c:otherwise>
                </c:choose>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${dashboardUrl}"><i class="fa fa-fw fa-home"></i><fmt:message key="label.home.title"/></a></li>
                <%--<li><fmt:message key="menu.administration"/></li>--%>
                <li><a href="${backUrl}"><fmt:message key="user.manager"/></a></li>
                <li class="active">
                    <c:choose>
                        <c:when test="${not empty item.pojo.userId}">
                            <fmt:message key="user.edit"/>
                        </c:when>
                        <c:otherwise>
                            <fmt:message key="user.add"/>
                        </c:otherwise>
                    </c:choose>
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
                            <c:choose>
                                <c:when test="${not empty item.pojo.userId}">
                                    <h3 class="box-title"><strong><fmt:message key="user.edit"/></strong></h3>
                                </c:when>
                                <c:otherwise>
                                    <h3 class="box-title"><strong><fmt:message key="user.add"/></strong></h3>
                                </c:otherwise>
                            </c:choose>
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
                                                        <%--<form:password style="width: 213px;" path="pojo.password" id="password" autocomplete="true" cssClass="form-control required" />--%>
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
                                        <form:select path="pojo.userGroup.userGroupId" cssClass="form-control required">
                                            <form:options items="${userGroups}" itemLabel="name" itemValue="userGroupId"/>
                                        </form:select>
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
                                                <input type="checkbox" name="pojo.status" id="status" <c:if test="${item.pojo.status eq Constants.USER_ACTIVE}">checked</c:if> value="${Constants.USER_ACTIVE}" data-size="mini"/>
                                            </c:when>
                                            <c:otherwise>
                                                <input type="checkbox" name="pojo.status" id="status" checked value="${Constants.USER_ACTIVE}" data-size="mini"/>
                                            </c:otherwise>
                                        </c:choose>
                                        <spring:bind path="pojo.status">
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
                            <div class="clear"></div>

                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-5 control-label"><fmt:message key="user.manager.avatar"/></label>
                                    <div class="col-sm-7">
                                        <c:choose>
                                            <c:when test="${not empty item.pojo.userId}">
                                                <div id="avatar_form" class="nowrap">
                                                    <input id="avatarFileUpload" type="file" name="pojo.avatarFileItem" accept="image/x-png, image/gif, image/jpeg" />
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <input id="avatarFileUpload" type="file" name="pojo.avatarFileItem" />
                                            </c:otherwise>
                                        </c:choose>
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
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-5 control-label"><fmt:message key="user.manager.user_type"/></label>
                                    <div class="col-sm-7">
                                        <form:select path="pojo.LDAP" cssClass="form-control required">
                                            <option value="${Constants.USER_LOCAL}" <c:if test="${item.pojo.LDAP eq Constants.USER_LOCAL}">selected="true"</c:if>><fmt:message key="user.manager.ldap.local"/></option>
                                            <option value="${Constants.USER_LDAP}" <c:if test="${item.pojo.LDAP eq Constants.USER_LDAP}">selected="true"</c:if>><fmt:message key="user.manager.ldap.ldap"/></option>
                                        </form:select>
                                    </div>
                                </div>
                            </div>
                            <div class="clear"></div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-5 control-label"><fmt:message key="label.department.name"/></label>
                                    <div class="col-sm-7">
                                        <form:select path="pojo.department.departmentId" cssClass="form-control">
                                            <form:options items="${departmentList}" itemLabel="name" itemValue="departmentId"/>
                                        </form:select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-5 control-label"><fmt:message key="label.role.name"/></label>
                                    <div class="col-sm-7">
                                        <input type="checkbox" name="pojo.xt" <c:if test="${item.pojo.xt == true}">checked</c:if> /> <fmt:message key="role.xetthau"/>
                                        <div class="clear"></div>
                                        <input type="checkbox" name="pojo.td" <c:if test="${item.pojo.td == true}">checked</c:if>/> <fmt:message key="role.thamdinh"/>
                                    </div>
                                </div>
                            </div>
                            <div class="clear"></div>
                            <div class="text-center">
                                <a id="btnSave" class="btn btn-primary"><i class="fa fa-fw fa-save"></i> <fmt:message key="button.save"/></a>
                                <a class="btn cancel-link" href="${backUrl}"><fmt:message key="button.cancel"/></a>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
        </section>

        <form:hidden path="crudaction" id="crudaction"/>
        <form:hidden path="pojo.userId"/>
        <form:hidden path="pojo.LDAP"/>
        </form:form>
    </div>
</div>

<script>
    $(document).ready(function(){
        // active tab
        setActiveMenu4Admin('#administration_menu', '#user_menu');

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
