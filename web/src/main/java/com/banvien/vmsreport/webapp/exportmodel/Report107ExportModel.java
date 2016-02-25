package com.banvien.vmsreport.webapp.exportmodel;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.util.ReportCsvInfo;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 9/26/15
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Report107ExportModel implements ReportCsvInfo{
    @Override
    public String[] getHeaders() {
        ArrayList<String> result = new ArrayList<String>();
        result.add("STT");
        result.add("SUB_ID");
        result.add("ISDN");
        result.add("MST");
        result.add("GPKD");
        result.add("NAME");
        result.add("NGAYHD");
        result.add("SUB_TYPE");
        result.add("BUS_TYPE");
        result.add("LOAI_HM");
        result.add("LOAI_TB");
        result.add("TINH_TRANG_TB");
        result.add("TINH_TRANG_CHAN_CAT");
        result.add("STA_DATE");
        result.add("DCTB");
        result.add("QUAN_DCTB");
        result.add("DCTT");
        result.add("QUAN_DCTT");
        result.add("CN_DCTT");
        result.add("TT_DCTT");
        result.add("TT_DS");
        result.add("MA_NVPT");
        result.add("CH_DAU_NOI");
        result.add("QUAN_DAU_NOI");
        result.add("CN_DAU_NOI");
        result.add("TT_DAU_NOI");
        result.add("KENH");
        result.add("GC");
        result.add("NGAY_DK");
        // more columns
        String[] stringResult = new String[result.size()];
        stringResult = result.toArray(stringResult);
        return stringResult;
    }

    @Override
    public String[] getCsvFields() {
        ArrayList<String> result = new ArrayList<String>();
        result.add("stt");
        result.add("subId");
        result.add("dn");
        result.add("mst");
        result.add("gpkd");
        result.add("tenKHDN");
        result.add("ngayhopdong");
        result.add("subType");
        result.add("busType");
        result.add("loaihoamang");
        result.add("nhomLoaiTB");
        result.add("tinhtrangTB");
        result.add("tinhtrangchancat");
        result.add("staDate");
        result.add("dctb");
        result.add("districtDctb");
        result.add("dctt");
        result.add("districtDctt");
        result.add("branchDctt");
        result.add("centerDctt");
        result.add("centerDauSo");
        result.add("maNvpt");
        result.add("shopCode");
        result.add("districtDVPT");
        result.add("branchDVPT");
        result.add("centerDVPT");
        result.add("kenh");
        result.add("goicuocdautien");
        result.add("ndkGoiCuoc");
        String[] stringResult = new String[result.size()];
        stringResult = result.toArray(stringResult);
        return stringResult;
    }

    @Override
    public int getCsvFieldDecimalRound(String field) {
        return -1;
    }

    @Override
    public int getFactor(String field) {
        return 1;
    }

    @Override
    public String getSymbol(String field) {
        return "";
    }
}
