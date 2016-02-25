<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="repository" uri="http://banvien.com/tags/repository" %>
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
<c:url var="backUrl" value="${prefix}/department/list.html"/>
<c:url var="formlUrl" value="${prefix}/department/add.html"/>
<c:if test="${not empty item.pojo.departmentId}">
    <c:url var="formlUrl" value="${prefix}/department/edit.html"/>
</c:if>
<c:url var="dashboardUrl" value="/home.html"/>

<body>
<div class="content-wrapper">
    <div class="container">
        <form:form commandName="item" id="formItem" action="${formUrl}" method="post" cssClass="form-horizontal" validate="validate" enctype="multipart/form-data">
            <section class="content-header">
                <h4>
                    <fmt:message key="department.manager.title"/>
                        <%--<small><fmt:message key="user.manager.list"/></small>--%>
                </h4>
                <ol class="breadcrumb">
                    <li><a href="${dashboardUrl}"><i class="fa fa-fw fa-home"></i><fmt:message key="label.home.title"/></a></li>
                    <li><a href="${backUrl}"><fmt:message key="user.manager"/></a></li>
                    <li class="active">
                        <c:choose>
                            <c:when test="${not empty item.pojo.departmentId}">
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
                                    <c:when test="${not empty item.pojo.departmentId}">
                                        <h3 class="box-title"><fmt:message key="department.manager.form_edit.title"/></h3>
                                    </c:when>
                                    <c:otherwise>
                                        <h3 class="box-title"><fmt:message key="department.manager.form_add.title"/></h3>
                                    </c:otherwise>
                                </c:choose>
                            </div>

                            <div class="box-body">
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label class="col-sm-5 control-label"><fmt:message key="label.department.code"/></label>
                                        <div class="col-sm-7">
                                            <form:input path="pojo.code" cssClass="form-control required nohtml input-sm" data-trigger="focus"/>
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
                                </div>

                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label class="col-sm-5 control-label"><fmt:message key="label.department.name"/></label>
                                        <div class="col-sm-7">
                                            <form:input path="pojo.name" cssClass="form-control required nohtml input-sm"/>
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
                                </div>
                                <div class="text-center">
                                    <a id="btnSave" class="btn btn-sm btn-primary"><i class="fa fa-fw fa-save"></i> <fmt:message key="button.save"/></a>
                                    <a class="btn btn-sm cancel-link" href="${backUrl}"><fmt:message key="button.cancel"/></a>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </section>

            <form:hidden path="crudaction" id="crudaction"/>
            <form:hidden path="pojo.departmentId"/>
        </form:form>
    </div>
</div>

<script>
    $(document).ready(function(){
        // active tab
        setActiveMenu4Admin('#Category_menu', '#department_menu');

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
