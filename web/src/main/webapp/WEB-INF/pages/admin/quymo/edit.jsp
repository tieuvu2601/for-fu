<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="quymo.manager.title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin" />
</security:authorize>

<c:url var="backUrl" value="${prefix}/quymo/list.html"/>
<c:url var="formUrl" value="${prefix}/quymo/edit.html"/>
<c:url var="dashboardUrl" value="home.html"/>
<body>
<div class="content-wrapper">
    <div class="container">
        <form:form commandName="item" id="formItem" action="${formUrl}" method="post" cssClass="form-horizontal" novalidate="novalidate">
            <section class="content-header">
                <h4>
                    <fmt:message key="quymo.manager"/>
                        <%--<small><fmt:message key="user.manager.list"/></small>--%>
                </h4>
                <ol class="breadcrumb">
                    <li><a href="${dashboardUrl}"><i class="fa fa-home"></i> <fmt:message key="label.home.title"/></a></li>
                    <li><a href="${backUrl}"><fmt:message key="quymo.manager"/></a></li>
                    <li class="active">
                        <c:choose>
                            <c:when test="${not empty item.pojo.msquimo}">
                                <fmt:message key="quymo.manager.edit_quymo"/>
                            </c:when>
                            <c:otherwise>
                                <fmt:message key="quymo.manager.add_new_quymo"/>
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
                                    <c:when test="${not empty item.pojo.msquimo}">
                                        <h3 class="box-title"><fmt:message key="quymo.manager.edit_quymo"/></h3>
                                    </c:when>
                                    <c:otherwise>
                                        <h3 class="box-title"><fmt:message key="quymo.manager.add_new_quymo"/></h3>
                                    </c:otherwise>
                                </c:choose>
                            </div>

                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><fmt:message key="quymo.manager.stt"/></label>
                                    <div class="col-sm-7">
                                        <form:input path="pojo.stt" cssClass="form-control required input-sm"/>
                                        <spring:bind path="pojo.stt">
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
                                    <label class="col-sm-3 control-label"><fmt:message key="quymo.manager.tenquymo"/></label>
                                    <div class="col-sm-7">
                                        <form:input path="pojo.tenquimo" cssClass="form-control required input-sm"/>
                                        <spring:bind path="pojo.tenquimo">
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
                                    <label class="col-sm-3 control-label"><fmt:message key="quymo.manager.value.from"/></label>
                                    <div class="col-sm-2">
                                        <fmt:formatNumber var="fromValue" value="${item.pojo.fromValue}" pattern="###,###" />
                                        <input name="pojo.fromValue" value="${fromValue}" id="fromValue" class="form-control input-sm required nohtml onlyNumberInput inputNumber" style="width: 148px;" data-trigger="focus" />
                                    </div>
                                    <label class="col-sm-2 control-label"><fmt:message key="quymo.manager.value.to"/></label>
                                    <div class="col-sm-2">
                                        <fmt:formatNumber var="toValue" value="${item.pojo.toValue}" pattern="###,###" />
                                        <input name="pojo.toValue" value="${toValue}" id="toValue" class="form-control required input-sm nohtml onlyNumberInput inputNumber" style="width: 148px;" data-trigger="focus" />
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><fmt:message key="quymo.manager.ghichu"/></label>
                                    <div class="col-sm-7">
                                        <form:textarea path="pojo.ghichu" cssClass="form-control"/>
                                        <spring:bind path="pojo.ghichu">
                                            <c:if test="${status.error}">
                                                <div class="tooltip fade top in" onclick="javascript: $(this).remove();" style="display: block; top: -37px; left: 80px;">
                                                    <div class="tooltip-arrow"></div>
                                                    <div class="tooltip-inner">${status.errorMessage}</div>
                                                </div>
                                            </c:if>
                                        </spring:bind>
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
            <form:hidden path="pojo.msquimo"/>
        </form:form>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function(){
        // active tab
        setActiveMenu4Admin('#Category_menu', '#quymo_menu');

        $("#btnSave").click(function(){
            if($('#formItem').valid()){
                $("#crudaction").val("insert-update");
                transform();
                $("#formItem").submit();
            }
        });
    });

    function transform() {
        var fromValue = eval($.trim($('#fromValue').val()).replace(/,+/g, ''));
        $('#fromValue').val(fromValue);
        var toValue = eval($.trim($('#toValue').val()).replace(/,+/g, ''));
        $('#toValue').val(toValue);
    }
</script>
</body>
</html>