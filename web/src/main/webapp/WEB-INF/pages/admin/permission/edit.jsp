<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="permission.manager.title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<c:url var="backUrl" value="/admin/permission/list.html"/>
<c:url var="formUrl" value="/admin/permission/edit.html"/>
<body>
<div class="content-wrapper">
<form:form commandName="item" id="formItem" action="${formUrl}" method="post" cssClass="form-horizontal" novalidate="novalidate">
    <section class="content">
        <c:if test="${not empty messageResponse}">
            <div class="alert alert-message  alert-${alertType}">
                <a class="close" data-dismiss="alert" href="#">&times;</a> ${messageResponse}
            </div>
        </c:if>

        <div class="row">
            <div class="col-md-12">
                <div class="box box-solid box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title"><fmt:message key="permission.manager"/></h3>
                    </div>
                    <div class="box-body">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><fmt:message key="permission.manager.code"/></label>
                                <div class="col-sm-7">
                                    <form:input path="pojo.code" cssClass="form-control required"/>
                                    <form:errors path="pojo.code" cssClass="error-inline-validate"/>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-12">
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><fmt:message key="permission.manager.name"/></label>
                                <div class="col-sm-7">
                                    <form:input path="pojo.name" cssClass="form-control required"/>
                                    <form:errors path="pojo.name" cssClass="error-inline-validate"/>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-12">
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><fmt:message key="permission.manager.featuregroup"/></label>
                                <div class="col-sm-7">
                                    <form:select path="pojo.featureGroup.featureGroupId" cssClass="form-control">
                                        <form:option value=""><fmt:message key="label.select"/></form:option>
                                        <form:options items="${featureGroups}" itemLabel="name" itemValue="featureGroupId"/>
                                    </form:select>
                                    <form:errors path="pojo.featureGroup.featureGroupId" cssClass="error-inline-validate"/>
                                </div>
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
    <form:hidden path="pojo.permissionId"/>
</form:form>
    </div>
<script type="text/javascript">
    $(document).ready(function(){


        $("#btnSave").click(function(){
            $("#crudaction").val("insert-update");
            $("#formItem").submit();
        });
    });
</script>
</body>
</html>