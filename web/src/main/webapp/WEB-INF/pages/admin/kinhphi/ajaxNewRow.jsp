<%@ include file="/common/taglibs.jsp"%>
<tr class="rowkp${num}in_list rowkp">
    <td><span class="stt_kp">${num +1}</span></td>
    <td>
        <form:select path="item.listkp[${num}].loaibao.msloaibao" cssClass="form-control">
            <c:forEach items="${listlb}" var="item">
                <form:option value="${item.msloaibao}">${item.tenloaibao}</form:option>
            </c:forEach>
        </form:select>
    </td>
    <td>
        <form:select path="item.listkp[${num}].noidung.msnoidung" cssClass="form-control">
            <c:forEach items="${listnd}" var="item">
                <form:option value="${item.msnoidung}">${item.tennoidung}</form:option>
            </c:forEach>
        </form:select>
    </td>
    <td><form:input path="item.listkp[${num}].khobao" cssClass="input_kp form-control input-xs" /></td>
    <td class="so-ki-dang-bao"><form:input path="item.listkp[${num}].soky" cssClass="input_kp input_number onlyNumberInput form-control input-xs"/></td>
    <td class="chi-phi-dang-bao"><form:input path="item.listkp[${num}].chiphi" cssClass="input_kp input_number onlyNumberInput form-control input-xs"/></td>
    <td class="tong-tien-dang-bao">
        <form:input path="item.listkp[${num}].thanhtien" cssClass="input_kp input_number form-control input-xs"/>
    </td>
    <td><input type="checkbox" class="checkBox_kp"/></td>
</tr>