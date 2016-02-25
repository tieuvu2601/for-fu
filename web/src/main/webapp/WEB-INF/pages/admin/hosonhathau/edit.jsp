<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="hosonhathau.title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .modal-dialogBid {
            width: 90%;
        }
    </style>
</head>
<c:set var="prefix" value="/normal" />
<security:authorize ifAnyGranted="ADMIN">
    <c:set var="prefix" value="/admin"></c:set>
</security:authorize>
<c:url var="homeUrl" value="/home.html"/>
<c:url var="formUrl" value="/hosonhathau/edit.html"/>
<c:url var="backUrl" value="${prefix}/nhathau/capnhatnhathau.html"/>
<body>
<div class="content-wrapper">
 <div class="container">
     <form:form commandName="item" id="formItem" action="${formUrl}" method="post" cssClass="form-horizontal" novalidate="novalidate">
         <section class="content-header">
             <ol class="breadcrumb">
                 <li><a href="${homeUrl}"><i class="fa fa-home"></i> <fmt:message key="label.home.title"/></a></li>
                 <li><fmt:message key="menu.nhathau"/></li>
                 <li class="active"><fmt:message key="hosonhathau.title"/></li>
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
                             <h3 class="box-title"><fmt:message key="hosonhathau.title"/></h3>
                         </div>
                         <div class="box-body">
                             <div class="col-sm-12">
                                 <div class="form-group">
                                     <div class="col-sm-2">
                                         <label class="control-label"><fmt:message key="tiendo.label.goithau"/><span style="color:red;">(*)</span></label>
                                     </div>
                                     <div class="col-sm-10">
                                         <div class="input-group input-group-xs">
                                             <textarea disabled="disabled" rows="1" class="form-control input-xs" style="resize: none;"><c:if test="${!empty item.pojo.goithau_nhathau.goithau}">${item.pojo.goithau_nhathau.goithau.tengoithau}</c:if></textarea>
                                            <span class="input-group-btn">
                                                 <a onclick="listenForGetGoiThau()" href="javascript: void(0);" class="btn btn-info" title="<fmt:message key="tiendo.label.chongoithau" />">
                                                     <i class="fa fa-search"></i>
                                                 </a>
                                            </span>
                                         </div>
                                     </div>
                                 </div>
                             </div>

                             <div class="col-sm-12">
                                 <div class="form-group">
                                     <div class="col-sm-2">
                                         <label class="control-label"><fmt:message key="tiendo.label.thuoc.pada"/></label>
                                     </div>
                                     <div class="col-sm-10">
                                         <textarea disabled="disabled" rows="1" class="form-control input-xs"><c:if test="${!empty item.pojo.goithau_nhathau.goithau}">${item.pojo.goithau_nhathau.goithau.hinhthucgt.tenhinhthuc}</c:if></textarea>
                                     </div>
                                 </div>
                             </div>

                             <div class="col-sm-12">
                                 <div class="form-group">
                                     <div class="col-sm-2">
                                         <label class="control-label"><fmt:message key="hosonhathau.label.nhathau"/><span style="color:red;">(*)</span></label>
                                     </div>
                                     <div class="col-sm-10">
                                         <form:select id="nhathau_goithau" path="pojo.goithau_nhathau.msgoithauNt" cssClass="form-control" onchange="changeNhaThau(this.value);">
                                             <form:option value="-1"><fmt:message key="hosonhathau.label.chonnhathau"/></form:option>
                                             <c:forEach items="${dsnt}" var="nt">
                                                 <c:if test="${!empty item.pojo.goithau_nhathau.msgoithauNt && item.pojo.goithau_nhathau.msgoithauNt == nt.msgoithauNt}">
                                                     <form:option value="${nt.msgoithauNt}" selected="selected">${nt.nhathau.tennhathau}</form:option>
                                                 </c:if>
                                                 <c:if test="${empty item.pojo.goithau_nhathau.msgoithauNt || item.pojo.goithau_nhathau.msgoithauNt != nt.msgoithauNt}">
                                                     <form:option value="${nt.msgoithauNt}">${nt.nhathau.tennhathau}</form:option>
                                                 </c:if>
                                             </c:forEach>
                                         </form:select>

                                     </div>
                                 </div>
                             </div>
                         </div>

                     </div>
                 </div>
             </div>

             <div class="row">
                 <div class="col-md-12">
                     <div class="box box-solid box-primary">
                         <table class="tableAdd table" style="width: 100%;">
                             <thead>
                             <th class="text_center" style="width: 5%;"><fmt:message key="hosonhathau.label.stt"/></th>
                             <th class="text_center" style="width: 35%;"><fmt:message key="hosonhathau.label.tennoidunghoso"/></th>
                             <th class="text_center" style="width: 60%;"><fmt:message key="hosonhathau.label.ghichu"/></th>
                             </thead>
                             <tbody>
                             <tr>
                                 <td class="text_center"><span>1</span>
                                 </td>
                                 <td><fmt:message key="hosonhathau.label.tinhtrangniemphong"/></td>
                                 <td><form:input id="tinhtrangniemphong" path="pojo.noiDungHoSo.tinhTrangNiemPhong" cssClass="form-control input-xs"/></td>
                             </tr>
                             <tr>
                                 <td class="text_center"><span>2</span></td>
                                 <td><fmt:message key="hosonhathau.label.soluongbangoc"/></td>
                                 <td><form:input id="soLuongBanGoc" path="pojo.noiDungHoSo.soLuongBanGoc" cssClass="form-control input_number input-xs"/></td>
                             </tr>
                             <tr>
                                 <td class="text_center"><span>3</span></td>
                                 <td><fmt:message key="hosonhathau.label.soluongbanchup"/></td>
                                 <td><form:input id="soLuongBanChup" path="pojo.noiDungHoSo.soLuongBanChup" cssClass="form-control input_number input-xs"/></td>
                             </tr>
                             <tr>
                                 <td class="text_center"><span>4</span></td>
                                 <td><fmt:message key="hosonhathau.label.thoigiancohieuluc"/></td>
                                 <td><form:input id="thoiGianCoHieuLuc" path="pojo.noiDungHoSo.thoiGianCoHieuLuc" cssClass="form-control input-xs"/></td>
                             </tr>
                             <tr>
                                 <td class="text_center"><span>5</span></td>
                                 <td><fmt:message key="hosonhathau.label.giaduthau"/></td>
                                 <td><form:input id="giaDuThau" path="pojo.noiDungHoSo.giaDuThau" cssClass="form-control input_number input-xs"/></td>
                             </tr>
                             <tr>
                                 <td class="text_center"><span>5</span></td>
                                 <td><fmt:message key="hosonhathau.label.giaduthau.sauthue"/></td>
                                 <td><form:input id="giaDuThauSauThue" path="pojo.noiDungHoSo.giaDuThauSauThue" cssClass="form-control input_number input-xs"/></td>
                             </tr>
                             <tr>
                                 <td class="text_center"><span>6</span></td>
                                 <td><fmt:message key="hosonhathau.label.giamgia"/></td>
                                 <td><form:input id="giamGia" path="pojo.noiDungHoSo.giamGia" cssClass="form-control input_number input-xs"/></td>
                             </tr>
                             <tr>
                                 <td class="text_center"><span>7</span></td>
                                 <td><fmt:message key="hosonhathau.label.hinhthuc_giatri"/></td>
                                 <td><form:input id="hinhThucGiaTriThoiHan" path="pojo.noiDungHoSo.hinhThucGiaTriThoiHan" cssClass="form-control input-xs"/></td>
                             </tr>
                             <tr>
                                 <td class="text_center"><span>8</span></td>
                                 <td><fmt:message key="hosonhathau.label.thoigianthuchienhopdong"/></td>
                                 <td><form:input id="thoiGianThucHien" path="pojo.noiDungHoSo.thoiGianThucHien" cssClass="form-control input-xs"/></td>
                             </tr>
                             <tr>
                                 <td class="text_center"><span>9</span></td>
                                 <td><fmt:message key="hosonhathau.label.dieukienthanhtoan"/></td>
                                 <td><form:input id="dieuKienThanhToan" path="pojo.noiDungHoSo.dieuKienThanhToan" cssClass="form-control input-xs"/></td>
                             </tr>
                             <tr>
                                 <td class="text_center"><span>10</span></td>
                                 <td><fmt:message key="hosonhathau.label.giayphepbanhang"/></td>
                                 <td><form:input id="giayPhepBanHang" path="pojo.noiDungHoSo.giayPhepBanHang" cssClass="form-control input-xs"/></td>
                             </tr>
                             <tr>
                                 <td class="text_center"><span>11</span></td>
                                 <td><fmt:message key="hosonhathau.label.baohanh"/></td>
                                 <td><form:input id="baoHanh" path="pojo.noiDungHoSo.baoHanh" cssClass="form-control input-xs"/></td>
                             </tr>
                             <tr>
                                 <td class="text_center"><span>12</span></td>
                                 <td><fmt:message key="hosonhathau.label.nhanhieu"/></td>
                                 <td><form:input id="nhanHieu" path="pojo.noiDungHoSo.nhanHieu" cssClass="form-control input-xs"/></td>
                             </tr>
                             </tbody>
                         </table>
                         <div class="text-center" style="padding-bottom: 6px;">
                             <form:hidden path="crudaction"/>
                             <form:hidden id="idNoidunghoso" path="pojo.noiDungHoSo.msnoidunghs"/>
                             <form:hidden id="idHoSoThau" path="pojo.mshosothau"/>
                             <form:hidden path="pojo.goithau_nhathau.goithau.msgoithau"/>
                             <a id="btnSaveNhaThau" class="btn btn-sm btn-primary"><fmt:message key="button.save"/></a>
                             <a href="${backUrl}?pojo.goithau.msgoithau=${item.pojo.goithau_nhathau.goithau.msgoithau}" class="tip-top" title="<fmt:message key="la" />"><fmt:message key="la" /></a>
                         </div>
                     </div>
                 </div>
             </div>
         </section>

     </form:form>
 </div>
</div>
<div class="modal fade bvModel" role="dialog" id="addModel"></div>

<script type="text/javascript">
    $(document).ready(function(){
        setActiveMenu4Admin('#nhathau_menu', '#hosonhathau_menu');
        $("#btnSaveNhaThau").click(function(){
           var nhathaugoithauid = $("#nhathau_goithau").val();
           if(nhathaugoithauid != undefined && nhathaugoithauid != ''&& nhathaugoithauid != '-1'){
            $("#crudaction").val("insert-update");
            $("#formItem").submit();
           }
        });
    });

    function changeNhaThau(gtnt){
        $.ajax({
            url: '<c:url value="/ajax/hosonhathau/change_nhathau.html"/>',
            dateType: "json",
            data: {gtnt : gtnt},
            success: function (data) {
                if(data.hsnt != null){
                    $("#tinhtrangniemphong").val(data.hsnt.tinhTrangNiemPhong);
                    $("#soLuongBanGoc").val(data.hsnt.soluongbangoc);
                    $("#soLuongBanChup").val(data.hsnt.soluongbanchup);
                    $("#thoiGianCoHieuLuc").val(data.hsnt.thoigiancohieuluc);
                    $("#giaDuThau").val(data.hsnt.giaduthau);
                    $("#giaDuThauSauThue").val(data.hsnt.giaduthausauthue);
                    $("#giamGia").val(data.hsnt.giamgia);
                    $("#hinhThucGiaTriThoiHan").val(data.hsnt.hinhthucgiatrithoihan);
                    $("#thoiGianThucHien").val(data.hsnt.thoigianthuchien);
                    $("#dieuKienThanhToan").val(data.hsnt.dieukienthanhtoan);
                    $("#giayPhepBanHang").val(data.hsnt.giayphepbanhang);
                    $("#baoHanh").val(data.hsnt.baohanh);
                    $("#nhanHieu").val(data.hsnt.nhanhieu);
                    $("#idNoidunghoso").val(data.hsnt.noidunghosoid);
                    $("#idHoSoThau").val(data.hsnt.hosothauid);
                }else{
                    $("#tinhtrangniemphong").val("");
                    $("#soLuongBanGoc").val("");
                    $("#soLuongBanChup").val("");
                    $("#thoiGianCoHieuLuc").val("");
                    $("#giaDuThau").val("");
                    $("#giaDuThauSauThue").val("");
                    $("#giamGia").val("");
                    $("#hinhThucGiaTriThoiHan").val("");
                    $("#thoiGianThucHien").val("");
                    $("#dieuKienThanhToan").val("");
                    $("#giayPhepBanHang").val("");
                    $("#baoHanh").val("");
                    $("#nhanHieu").val("");
                    $("#idNoidunghoso").val("");
                    $("#idHoSoThau").val("");
                }
            }
        });
    }
    function listenForGetGoiThau(){
        var $modal = $('#addModel');
        $modal.load('<c:url value="/ajax/admin/goithau/list.html"/>', {'_': new Date().getTime()}, function(){
            $modal.modal();
            registerSubmitPopup1();
        });
    }

    function registerSubmitPopup1(){
        var page = 1;
        $("#listFormAjax #btnFilter").click(function(){
            $('#listFormAjax #crudaction').val('search')
            $("#listFormAjax").submit();
        });

        $(".pagelinks a").click(function(){
            page = parseInt(this.href.split('?')[1].split('p=')[1].charAt(0));
            $("#listFormAjax").submit();
            return false;
        });
        $('#mapTinhTrangs').select2();
        $('#mapHinhThucs').select2();
        $('.select3').select2();
        validateSelect2Select($('#mapTinhTrangs'));
        validateSelect2Select($('#mapHinhThucs'));

        $("#listFormAjax").submit(function(e){
            e.preventDefault();
            var formData = new FormData($(this)[0]);
            formData.append('page', page);
            var url = '<c:url value="/ajax/admin/goithau/list.html"/>?d-3677046-p='+page;
            $.ajax({
                cache: false,
                type: "POST",
                dataType: 'html',
                mimeType:"multipart/form-data",
                contentType: false,
                processData:false,
                data: formData,
                url : url,
                success:function(data){
                    var error = data.error;
                    if (error != null) {
                        alert(error);
                    }else if (data != null) {
                        $("#addModel").html(data);
                        registerSubmitPopup1();
//                            $('.pagelinks a').each(function(e){
//                                var index = parseInt(this.href.split('?')[1].split('p=')[1].charAt(0));
//                                if(index == page){
//                                    $(this).css("cssText", "font-size : 25px");
//                                }
//                            });
                    }
                },
                error:function(e){
                }
            });
            return false;
        });
    }
    function chooseBid(msGoiThau){
        $('#formItem').attr('action', '${formUrl}?pojo.goithau_nhathau.goithau.msgoithau=' + msGoiThau);
        $("#formItem").submit();
        e.preventDefault();
    }
</script>
</body>
</html>