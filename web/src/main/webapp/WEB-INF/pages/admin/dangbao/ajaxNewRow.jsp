<%@ include file="/common/taglibs.jsp"%>
<tr class="rownndb${num}in_list rowndb">
    <td><span class="stt_kp">${num  +1}</span></td>
    <td><form:input path="item.listndb[${num}].socongvan" cssClass="input_ndb form-control input-xs"/></td>
    <td><form:input path="item.listndb[${num}].ngaycongvan" cssClass="input_ndb datePlaceHolder datepicker form-control input-xs"/></td>
    <td>
        <form:select path="item.listndb[${num}].noidung.msnoidung" cssClass="form-control">
            <c:forEach items="${listnd}" var="item">
                <form:option value="${item.msnoidung}">${item.tennoidung}</form:option>
            </c:forEach>
        </form:select>
    </td>
    <td>
        <form:select path="item.listndb[${num}].loaibao.msloaibao" cssClass="form-control">
            <c:forEach items="${listlb}" var="item">
                <form:option value="${item.msloaibao}">${item.tenloaibao}</form:option>
            </c:forEach>
        </form:select>
    </td>
    <td><form:input path="item.listndb[${num}].ngaydangbao" cssClass="input_ndb datePlaceHolder datepicker form-control input-xs"/></td>
    <td><form:input path="item.listndb[${num}].sobaobatdau" cssClass="input_ndb input_number form-control input-xs"/></td>
    <td><form:input path="item.listndb[${num}].sokydangbao" cssClass="input_ndb input_number form-control input-xs"/></td>
    <td><form:input path="item.listndb[${num}].ghichu" cssClass="input_ndb form-control input-xs"/></td>
    <td><input type="checkbox" class="checkBox_ndb"/></td>
</tr>