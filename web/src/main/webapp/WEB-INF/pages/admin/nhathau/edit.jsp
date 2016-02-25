<%--
  Created by IntelliJ IDEA.
  User: vovanphuc0810
  Date: 12/11/15
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="label.nhathau.title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin"/>
</security:authorize>

<c:url var="homeUrl" value="/index.html"/>
<c:url var="listUrl" value="${prefix}/nhathau/danhsachnhathau.html"/>
<c:url var="editUrl" value="${prefix}/nhathau/edit.html"/>
<body>
<div class="content-wrapper">
    <form:form commandName="item" action="${editUrl}" id="editForm" method="post" autocomplete="off" name="listForm" cssClass="form-horizontal">
        <section class="content-header">
            <ol class="breadcrumb">
                <li><a href="${homeUrl}"><i class="fa fa-fw fa-home"></i>&nbsp;<fmt:message key="label.home.title"/></a></li>
                <li><fmt:message key="menu.nhathau"/></li>
                <li class="active">
                    <c:choose>
                        <c:when test="${not empty item.pojo.msnhathau}">
                            <fmt:message key="label.nhathau.edit"/>
                        </c:when>
                        <c:otherwise>
                            <fmt:message key="label.nhathau.them"/>
                        </c:otherwise>
                    </c:choose>
                </li>
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
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">
                                <c:choose>
                                    <c:when test="${not empty item.pojo.msnhathau}">
                                        <fmt:message key="label.nhathau.edit"/>
                                    </c:when>
                                    <c:otherwise>
                                        <fmt:message key="label.nhathau.them"/>
                                    </c:otherwise>
                                </c:choose>
                           </h3>
                        </div>
                        <div class="box-body">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><fmt:message key="label.nhathau.ten"/><span style="color:red;">(*)</span></label>
                                    <div class="col-sm-9">
                                        <form:input path="pojo.tennhathau" cssClass="form-control required" data-trigger="focus"/>
                                        <spring:bind path="pojo.tennhathau">
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
                                    <label class="col-sm-3 control-label"><fmt:message key="label.nhathau.diachi"/></label>
                                    <div class="col-sm-9">
                                        <form:input path="pojo.diachi" cssClass="form-control" data-trigger="focus"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><fmt:message key="label.nhathau.dienthoai"/></label>
                                    <div class="col-sm-9">
                                        <%--<input type="number" name="pojo.dienthoai" value="${item.pojo.dienthoai}" class="form-control required">--%>
                                        <form:input path="pojo.dienthoai" cssClass="form-control" type="number"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><fmt:message key="label.nhathau.fax"/></label>
                                    <div class="col-sm-9">
                                        <form:input path="pojo.fax" cssClass="form-control" type="number"/>
                                        <%--<input type="number" name="pojo.fax" value="${item.pojo.fax}" class="form-control">--%>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><fmt:message key="label.nhathau.ghichu"/></label>
                                    <div class="col-sm-9">
                                        <form:input path="pojo.ghichu" cssClass="form-control" data-trigger="focus"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><fmt:message key="label.nhathau.msthue"/><span style="color:red;">(*)</span></label>
                                    <div class="col-sm-9">
                                        <form:input path="pojo.masothue" cssClass="form-control required" data-trigger="focus"/>
                                        <spring:bind path="pojo.masothue">
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
                                    <label class="col-sm-3 control-label"><fmt:message key="label.nhathau.giayphepkinhdoanh"/></label>
                                    <div class="checkbox col-sm-9">
                                        <label>
                                            <form:input path="pojo.giayPhepKinhDoanh" cssClass="form-control" data-trigger="focus"/>
                                        </label>
                                    </div>
                                </div>



                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><fmt:message key="label.nhathau.tinhtrang"/></label>
                                    <div class="checkbox col-sm-9">
                                        <label>
                                            <input type="checkbox" name="pojo.active" id="status" <c:if test="${item.pojo.active eq Constants.ACTIVE}">checked</c:if> value="${Constants.ACTIVE}" data-size="mini"/> <fmt:message key="user.manager.status.active"/>
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="box-footer text-center">
                            <a id="btnSave" class="btn btn-primary"><i class="fa fa-fw fa-save"></i> <fmt:message key="button.save"/></a>
                            <a class="btn cancel-link" href="${listUrl}"><fmt:message key="button.cancel"/></a>
                        </div>
                    </div>
                </div>
            </div>
            <form:hidden path="crudaction" id="crudaction"/>
        </section>
    </form:form>
</div>
<script type="text/javascript">
    $(document).ready(function(){
       setActiveMenu4Admin('#nhathau_menu, #danhsachnhathau_menu');
        $('#btnSave').click(function(){
            $('#crudaction').val('insert-update');
            $('#editForm').submit();
        });
    });
</script>

</body>
</html>