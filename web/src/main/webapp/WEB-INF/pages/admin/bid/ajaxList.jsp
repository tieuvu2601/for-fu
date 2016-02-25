<%@ include file="/common/taglibs.jsp" %>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin"></c:set>
</security:authorize>

<c:url var="homeUrl" value="/index.html"/>
<c:url var="formlUrl" value="/ajax/${prefix}/goithau/list.html"/>
<c:url var="editUrl" value="/ajax/${prefix}/goithau/edit.html"/>
<c:url var="addUrl" value="${prefix}/goithau/edit.html"/>
<c:url var="backUrl" value="${prefix}/index.html"/>
<c:url var="tienDoUrl" value="${prefix}/tiendo/edit.html"/>
<c:url var="nhaThauUrl" value="${prefix}/nhathau/capnhatnhathau.html"/>


<fmt:message var="allText" key="label.all" />
<form:form commandName="item" action="${formlUrl}" id="listFormAjax" method="post" autocomplete="off" name="listForm" cssClass="form-horizontal">
<c:choose>
    <c:when test="${!empty messageResponse}">${messageResponse}</c:when>
    <c:otherwise>
        <div class="modal-dialog modal-dialogBid" role="document">
            <div class="modal-content">
                <div class="modal-header bg-blue">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title"> <fmt:message key="contractor.title.management"/> </h4>
                </div>
                <div class="modal-body">
                    <div class="box box-solid box-primary">
                        <div class="box-header">
                            <h3 class="box-title"><fmt:message key="label.search"/></h3>
                        </div>
                        <div class="box-body">
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label"><fmt:message key="bid.pada.nguonvon"/></label>
                                        <div class="col-sm-8">
                                            <form:select path="pojo.nguonvon.msnguonvon" cssClass="form-control select3 nohtml input-xs" data-trigger="focus" cssStyle="width: 100%">
                                                <form:option value=""><fmt:message key="label.select" /> </form:option>
                                                <form:options items="${nguonvons}" itemLabel="tennguonvon" itemValue="msnguonvon"/>
                                            </form:select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label"><fmt:message key="bid.pada.loaidautu"/></label>
                                        <div class="col-sm-8">
                                            <form:select path="pojo.loai.msloai" cssClass="form-control select3 nohtml input-xs" data-trigger="focus" cssStyle="width: 100%">
                                                <form:option value=""><fmt:message key="label.select" /> </form:option>
                                                <form:options items="${loais}" itemLabel="tenloai" itemValue="msloai"/>
                                            </form:select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label"><fmt:message key="bid.pada.department"/></label>
                                        <div class="col-sm-8">
                                            <form:select path="pojo.department.departmentId" cssClass="form-control select3 nohtml input-xs" data-trigger="focus" cssStyle="width: 100%">
                                                <form:option value=""><fmt:message key="label.select" /> </form:option>
                                                <form:options items="${departments}" itemLabel="name" itemValue="departmentId"/>
                                            </form:select>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.tochuyengia.chutri"/></label>
                                        <div class="col-sm-8">
                                            <form:select path="idChuTri" cssClass="form-control select3  nohtml input-xs" data-trigger="focus" cssStyle="width: 100%">
                                                <form:option value=""><fmt:message key="label.select" /> </form:option>
                                                <c:forEach items="${userXetThau}" var="xetThau">
                                                    <option <c:if test="${xetThau.userId eq item.idChuTri}">selected="true" </c:if> value="${xetThau.userId}" >
                                                            ${xetThau.hoNhanVien} ${xetThau.tenNhanVien}
                                                        <c:if test="${empty xetThau.hoNhanVien && empty xetThau.tenNhanVien}">
                                                            ${xetThau.userName}
                                                        </c:if>
                                                        <c:if test="${not empty xetThau.chuyenNganh}">
                                                            (${xetThau.chuyenNganh})
                                                        </c:if>
                                                    </option>
                                                </c:forEach>
                                                <%--<form:options items="${userXetThau}" itemLabel="displayName" itemValue="userId"/>--%>
                                            </form:select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.tochuyengia.thanhvien"/></label>
                                        <div class="col-sm-8">
                                            <form:select path="idThanhVien" cssClass="form-control select3 input-xs  nohtml" data-trigger="focus" cssStyle="width: 100%">
                                                <form:option value=""><fmt:message key="label.select" /> </form:option>
                                                <c:forEach items="${listNhanVien}" var="nhanVien">
                                                    <option <c:if test="${nhanVien.userId eq item.idThanhVien}">selected="true" </c:if> value="${nhanVien.userId}" >
                                                            ${nhanVien.hoNhanVien} ${nhanVien.tenNhanVien}
                                                        <c:if test="${empty nhanVien.hoNhanVien && empty nhanVien.tenNhanVien}">
                                                            ${nhanVien.userName}
                                                        </c:if>
                                                        <c:if test="${not empty nhanVien.chuyenNganh}">
                                                            (${nhanVien.chuyenNganh})
                                                        </c:if>
                                                    </option>
                                                </c:forEach>
                                                <%--<form:options items="${userThamDinh}" itemLabel="displayName" itemValue="userId"/>--%>
                                            </form:select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.quimo"/></label>
                                        <div class="col-sm-8">
                                            <form:select path="pojo.quimo.msquimo" cssClass="form-control select3 nohtml input-xs" data-trigger="focus" cssStyle="width: 100%">
                                                <form:option value=""><fmt:message key="label.select" /> </form:option>
                                                <form:options items="${quimos}" itemLabel="tenquimo" itemValue="msquimo"/>
                                            </form:select>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label"><fmt:message key="bid.pada.soquyetdinhpada"/></label>
                                        <div class="col-sm-8">
                                            <form:input path="pojo.soqd" cssClass="form-control input-xs nohtml" data-trigger="focus" />
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.code"/></label>
                                        <div class="col-sm-8">
                                            <form:input path="pojo.magoithau" cssClass="form-control input-xs nohtml" data-trigger="focus" />
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label"><fmt:message key="bid.goithau.ten"/></label>
                                        <div class="col-sm-8">
                                            <form:input path="pojo.tengoithau" cssClass="form-control input-xs nohtml" data-trigger="focus" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label"><fmt:message key="label.from_date"/></label>
                                        <div class="col-sm-8">
                                            <div class="input-daterange input-group input-group-xs" id="datepicker">
                                                <fmt:formatDate value="${item.fromDate}" pattern="${datePattern}" var="fromDate" />
                                                <input id="fromYearId" type="text" name="fromDate" value="${fromDate}"  class="form-control input-xs datePlaceHolder datepicker nohtml" data-trigger="focus">
                                                <span class="input-group-addon"> <fmt:message key="label.den"/> </span>
                                                <fmt:formatDate value="${item.toDate}" pattern="${datePattern}" var="toDate" />
                                                <input id="toYearId" type="text" name="toDate" value="${toDate}" class="form-control input-xs datePlaceHolder datepicker nohtml" data-trigger="focus"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-8">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label"><fmt:message key="bid.pada.tinhtrang"/></label>
                                        <div class="col-sm-10">
                                            <form:select path="mapTinhTrangs" cssStyle="width: 100%;" cssClass="form-control input-xs select3 nohtml autocomplete">
                                                <form:option value="-1">${allText}</form:option>
                                                <form:options items="${tinhtrangs}" itemLabel="tentinhtrang" itemValue="mstinhtrang"/>
                                            </form:select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-8">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label"><fmt:message key="bid.pada.hinhthuc"/></label>
                                        <div class="col-sm-10">
                                            <form:select path="mapHinhThucs" cssStyle="width: 100%;" cssClass="form-control input-xs select3 nohtml autocomplete">
                                                <form:option value="-1">${allText}</form:option>
                                                <form:options items="${hinhthucs}" itemLabel="tenhinhthuc" itemValue="mshinhthuc"/>
                                            </form:select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="text-center">
                                <a id="btnFilter" type="submit" class="btn btn-xs btn-primary"><i class="fa fa-fw fa-search"></i><fmt:message key="label.search"/></a>
                                <button type="button" class="btn btn-xs btn-default" data-dismiss="modal"><fmt:message key="label.cancel"/> </button>
                                <input type="hidden" value="1" id="stt" />
                            </div>
                        </div>

                    </div>

                    <div id="content" class="box box-solid box-primary">
                        <div class="box-body">
                            <display:table name="items.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}"
                                           partialList="true" sort="external" size="${items.totalItems}" defaultsort="0"
                                           id="tableList" pagesize="${Constants.MAXPAGEITEMS}" export="false" class="table table_vms table-bordered table-hover table-striped" style="margin: 1em 0 1.5em; width: 100%;">
                                <display:column style="width: 2% !important;">
                                    <a href="javascript:void(0);" onclick="chooseBid(${tableList.msgoithau}, '${tableList.magoithau}', '${tableList.tengoithau}')" class="tip-top" title="<fmt:message key="label.choice" />"><i class="fa fa-globe"></i></a>
                                </display:column>
                                <display:column headerClass="table_header_center " sortable="false" titleKey="label.stt" class="text-center" style="width: 1% !important;">
                                    ${tableList_rowNum + (page * Constants.MAXPAGEITEMS)}
                                </display:column>
                                <display:column headerClass="table_header_center " sortable="false" titleKey="bid.goithau.code" class="" style="width: 1% !important;">
                                    ${tableList.magoithau}
                                </display:column>
                                <display:column headerClass="table_header_center " sortable="false" property="tengoithau" sortName="tengoithau" escapeXml="true" titleKey="bid.goithau.ten" class="" style="width: 35% !important;" />
                                <display:column headerClass="table_header_center " sortable="false" property="soqd" sortName="soqd" escapeXml="true" titleKey="bid.pada.soquyetdinh" class="" style="width: 5% !important;" />
                                <display:column headerClass="table_header_center " sortable="false" property="nguonvon.tennguonvon" sortName="nguonvon.tennguonvon" escapeXml="true" titleKey="bid.pada.nguonvon" class="" style="width: 5% !important;" />
                                <display:column headerClass="table_header_center " sortable="false" property="loai.tenloai" sortName="loai.tenloai" escapeXml="true" titleKey="bid.pada.loai" class="" style="width: 5% !important;" />
                                <display:column headerClass="table_header_center " sortable="false" property="department.name" sortName="department.name" escapeXml="true" titleKey="bid.pada.department" class="" style="width: 5% !important;" />
                                <display:column headerClass="table_header_center " sortable="false" titleKey="bid.goithau.tochuyengia" class="" style="width: 17% !important;">
                                    <c:forEach items="${tableList.toChuyenGias}" var="item">
                                        ${item.user.hoNhanVien} ${item.user.tenNhanVien}
                                        <br>
                                    </c:forEach>
                                </display:column>
                                <display:column headerClass="table_header_center " sortable="false" property="hinhthucgt.mahinhthuc" sortName="hinhthucgt.mahinhthuc" escapeXml="true" titleKey="bid.pada.hinhthuc" class="" style="width: 1% !important;" />
                                <display:column headerClass="table_header_center " sortable="false" property="quimo.tenquimo" sortName="quimo.tenquimo" escapeXml="true" titleKey="quymo.table.title" class="" style="width: 1% !important;" />

                                <display:column headerClass="table_header_center " sortable="false" titleKey="bid.goithau.nhathau.trungthau" class="" style="width: 15% !important;" >
                                    <c:forEach items="${tableList.goiThauNhaThaus}" var="item">
                                        <c:if test="${item.istrungthau == 1}">
                                            ${item.nhathau.tennhathau}
                                            <br>
                                        </c:if>
                                    </c:forEach>
                                </display:column>
                                <display:column headerClass="table_header_center " sortable="false" property="tinhtrang.tentinhtrang" sortName="tinhtrang.tentinhtrang" escapeXml="true" titleKey="bid.pada.tinhtrang" class="" style="width: 7% !important;" />

                                <display:setProperty name="paging.banner.item_name"><fmt:message key="contractor.title.management"/></display:setProperty>
                                <display:setProperty name="paging.banner.items_name"><fmt:message key="contractor.title.management"/></display:setProperty>

                            </display:table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>
    <form:hidden path="crudaction" id="crudaction"/>
</form:form>
<script type="text/javascript">
    $(document).ready(function(){
        initDateTimePicker();
    });
    $('.datePlaceHolder').inputmask("dd/mm/yyyy", {placeholder: "__/__/____"});

</script>


