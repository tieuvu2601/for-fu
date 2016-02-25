<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="repository" uri="http://banvien.com/tags/repository" %>
<tr>
    <td>${stt}</td>
    <td style="text-align: left;">
        <select name="mapnvs[${stt - 1}]" class="form-control required select3" data-trigger="focus" >
            <option value=""><fmt:message key="label.select" /> </option>
            <c:forEach items="${users}" var="item">
                <option value="${item.userId}">
                    ${item.hoNhanVien} ${item.tenNhanVien}
                        <c:if test="${empty item.hoNhanVien && empty item.tenNhanVien}">
                            ${item.userName}
                        </c:if>
                        <c:if test="${not empty item.chuyenNganh}">
                            (${item.chuyenNganh})
                        </c:if>
                </option>
            </c:forEach>
        </select>
    </td>
    <td style="text-align: center;">
        <input type="radio" name="idChuTri" value="${stt - 1}" />
    </td>
    <td style="text-align: center;">
        <input type="checkbox" class="rcheckBox" />
    </td>
</tr>