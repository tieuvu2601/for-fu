package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.core.business.Report106ManagementLocalBean;
import com.banvien.vmsreport.core.data.session.Report106LocalBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/28/15
 * Time: 9:56 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "Report106ManagementSessionEJB")
public class Report106ManagementSessionBean implements Report106ManagementLocalBean {
    public Report106ManagementSessionBean() {
    }

    @EJB
    private Report106LocalBean report106LocalBean;

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        Object[] resultsObject = report106LocalBean.search(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<Report106DTO> dtoList = new ArrayList<>();
        Map<String, Integer> mapIndex = new HashMap<>();
        Map<Integer, Integer> mapThanhVien = new HashMap<>();
        Map<Integer, Integer> mapDangBao = new HashMap<>();
        Map<Integer, Integer> mapNhaThauMuaHS = new HashMap<>();
        Map<Integer, Integer> mapNhaThauNopHS = new HashMap<>();
        for (Object object : (List)resultsObject[1]){
            Object[] tmpArr = (Object[])object;
            Report106DTO dto = new Report106DTO();

            String tenNguonVon = tmpArr[0] != null ? tmpArr[0].toString().trim() : null;
            String departmentCode = tmpArr[1] != null ? tmpArr[1].toString().trim() : null;
            String mahinhthuc = tmpArr[2] != null ? tmpArr[2].toString().trim() : null;
            String maTinhTrang = tmpArr[3] != null ? tmpArr[3].toString().trim() : null;
            String tenThanhVien = tmpArr[4] != null ? tmpArr[4].toString().trim() : null;
            String tenQuiMo = tmpArr[5] != null ? tmpArr[5].toString().trim() : null;
            String maGoiThau = tmpArr[6] != null ? tmpArr[6].toString().trim() : null;
            String tenGoiThau = tmpArr[7] != null ? tmpArr[7].toString().trim() : null;
            String qdPheDuyet_so = tmpArr[8] != null ? tmpArr[8].toString().trim() : null;
            Timestamp qdPheDuyet_ngay = tmpArr[9] != null ? Timestamp.valueOf(tmpArr[9].toString().trim()) : null;
            String trinhHs_so = tmpArr[10] != null ? tmpArr[10].toString().trim() : null;
            Timestamp trinhHs_ngay = tmpArr[11] != null ? Timestamp.valueOf(tmpArr[11].toString().trim()) : null;
            String duyetHs_so = tmpArr[12] != null ? tmpArr[12].toString().trim() : null;
            Timestamp duyetHsngay = tmpArr[13] != null ? Timestamp.valueOf(tmpArr[13].toString().trim()) : null;
            String trinhDangBao_so = tmpArr[14] != null ? tmpArr[14].toString().trim() : null;
            Timestamp trinhDangBao_ngay = tmpArr[15] != null ? Timestamp.valueOf(tmpArr[15].toString().trim()) : null;
            Timestamp ngayBanHS_L1 = tmpArr[16] != null ? Timestamp.valueOf(tmpArr[16].toString().trim()) : null;
            Timestamp ngayBanHS_L2 = tmpArr[17] != null ? Timestamp.valueOf(tmpArr[17].toString().trim()) : null;
            Timestamp ngayBanHS_L3 = tmpArr[18] != null ? Timestamp.valueOf(tmpArr[18].toString().trim()) : null;
            Timestamp ngayMoThau_L1 = tmpArr[19] != null ? Timestamp.valueOf(tmpArr[19].toString().trim()) : null;
            Timestamp ngayMoThau_L2 = tmpArr[20] != null ? Timestamp.valueOf(tmpArr[20].toString().trim()) : null;
            Timestamp ngayMoThau_L3 = tmpArr[21] != null ? Timestamp.valueOf(tmpArr[21].toString().trim()) : null;
            String trinhKQ_so = tmpArr[22] != null ? tmpArr[22].toString().trim() : null;
            Timestamp trinhKQ_ngay = tmpArr[23] != null ? Timestamp.valueOf(tmpArr[23].toString().trim()) : null;
            String pheDuyetKQ_so = tmpArr[24] != null ? tmpArr[24].toString().trim() : null;
            Timestamp pheDuyetKQ_ngay = tmpArr[25] != null ? Timestamp.valueOf(tmpArr[25].toString().trim()) : null;
            Timestamp dbkqLuaChonNhaThau_ngay = tmpArr[26] != null ? Timestamp.valueOf(tmpArr[26].toString().trim()) : null;
            Double giaDuThau = tmpArr[27] != null ? Double.valueOf(tmpArr[27].toString().trim()) : null;
            BigDecimal lanDauThau = tmpArr[28] != null ? BigDecimal.valueOf(Long.parseLong(tmpArr[28].toString().trim())) : null;
            Integer sl_nhaThauMuaHS = tmpArr[29] != null ? Integer.valueOf(tmpArr[29].toString().trim()) : null;
            Integer sl_nhaThauNopHS = tmpArr[30] != null ? Integer.valueOf(tmpArr[30].toString().trim()) : null;
            String tenNhaThau = tmpArr[31] != null ? tmpArr[31].toString().trim() : null;
            String diaChi = tmpArr[32] != null ? tmpArr[32].toString().trim() : null;
            String tinhtrang = tmpArr[33] != null ? tmpArr[33].toString().trim() : null;
            BigInteger istrungthau = tmpArr[34] != null ? BigInteger.valueOf(Long.parseLong(tmpArr[34].toString().trim())) : null;
            BigInteger ischutri = tmpArr[35] != null ? BigInteger.valueOf(Long.parseLong(tmpArr[35].toString().trim())) : null;
            Timestamp ngayDangBao = tmpArr[36] != null ? Timestamp.valueOf(tmpArr[36].toString().trim()) : null;
            Timestamp ngayMuaHoSo = tmpArr[37] != null ? Timestamp.valueOf(tmpArr[37].toString().trim()) : null;
            Timestamp ngayNopHoSo = tmpArr[38] != null ? Timestamp.valueOf(tmpArr[38].toString().trim()) : null;
            Integer msNhaThau = tmpArr[39] != null ? Integer.valueOf(tmpArr[39].toString().trim()) : null;
            Integer userId = tmpArr[40] != null ? Integer.valueOf(tmpArr[40].toString().trim()) : null;
            Integer msDangBao = tmpArr[41] != null ? Integer.valueOf(tmpArr[41].toString().trim()) : null;

            Integer index = mapIndex.get(maGoiThau.toString());
            if (index != null){
                if (dtoList.size() > 0 && dtoList.get(index) != null){
                    if (ischutri.intValue() != 1 && mapThanhVien.get(userId) == null){
                        String thanhVienTmp = dtoList.get(index).getThanhVien();
                        thanhVienTmp = thanhVienTmp + " " + tenThanhVien;
                        dtoList.get(index).setThanhVien(thanhVienTmp.trim());
                        mapThanhVien.put(userId, 1);
                    }else if (ischutri.intValue() == 1){
                        if (tenThanhVien != null){
                            UserDTO userDTO = new UserDTO();
                            userDTO.setUserName(tenThanhVien);
                            dtoList.get(index).setUser(userDTO);
                        }
                    }
                    if (ngayDangBao != null && mapDangBao.get(msDangBao) == null){
                        List<Timestamp> ngayDangBaoTmp = dtoList.get(index).getNgayDangBao();
                        if (ngayDangBaoTmp == null){
                            ngayDangBaoTmp = new ArrayList<>();
                        }
                        ngayDangBaoTmp.add(ngayDangBao);
                        dtoList.get(index).setNgayDangBao(ngayDangBaoTmp);
                        mapDangBao.put(msDangBao, 1);
                    }

                    if (tenNhaThau != null || diaChi != null){
                        if (istrungthau.intValue() != 1 ){
                            if (ngayMuaHoSo != null && mapNhaThauMuaHS.get(msDangBao) == null){
                                String danhSachNhaThauMuaHSTmp = dtoList.get(index).getDanhSachNhaThauMuaHS();
                                danhSachNhaThauMuaHSTmp = danhSachNhaThauMuaHSTmp + " " + tenNhaThau;
                                dtoList.get(index).setDanhSachNhaThauMuaHS(danhSachNhaThauMuaHSTmp);
                                mapNhaThauMuaHS.put(msNhaThau, 1);
                            }
                            if (ngayNopHoSo != null && mapNhaThauNopHS.get(msDangBao) == null){
                                String danhSachNhaThauNopHSTmp = dtoList.get(index).getDanhSachNhaThauNopHS();
                                danhSachNhaThauNopHSTmp = danhSachNhaThauNopHSTmp + " " + tenNhaThau;
                                dtoList.get(index).setDanhSachNhaThauNopHS(danhSachNhaThauNopHSTmp);
                                mapNhaThauNopHS.put(msNhaThau, 1);
                            }
                        }else {
                            NhaThauDTO nhaThauDTO = new NhaThauDTO();
                            nhaThauDTO.setTennhathau(tenNhaThau);
                            nhaThauDTO.setDiachi(diaChi);
                            dtoList.get(index).setNhaThau(nhaThauDTO);
                        }
                    }
                }
            }else {
                if (tenNguonVon != null){
                    NguonvonDTO nguonvonDTO = new NguonvonDTO();
                    nguonvonDTO.setTennguonvon(tenNguonVon);
                    dto.setNguonvon(nguonvonDTO);
                }
                if (departmentCode != null){
                    DepartmentDTO departmentDTO = new DepartmentDTO();
                    departmentDTO.setCode(departmentCode);
                    dto.setDepartment(departmentDTO);
                }

                if (mahinhthuc != null){
                    HinhthucgtDTO hinhthucgtDTO = new HinhthucgtDTO();
                    hinhthucgtDTO.setMahinhthuc(maTinhTrang);
                    dto.setHinhthucgt(hinhthucgtDTO);
                }

                if (ischutri.intValue() != 1){
                    dto.setThanhVien(tenThanhVien);
                    mapThanhVien.put(userId, 1);
                }else if (ischutri.intValue() == 1){
                    if (tenThanhVien != null){
                        UserDTO userDTO = new UserDTO();
                        userDTO.setUserName(tenThanhVien);
                        dto.setUser(userDTO);
                    }
                }
                if (tenQuiMo != null){
                    QuyMoDTO quimoDTO = new QuyMoDTO();
                    quimoDTO.setTenquimo(tenQuiMo);
                    dto.setQuimo(quimoDTO);
                }

                if (maGoiThau != null || tenGoiThau != null || lanDauThau != null){
                    BidDTO bidDTO = new BidDTO();
                    bidDTO.setMagoithau(maGoiThau);
                    bidDTO.setTengoithau(tenGoiThau);
                    bidDTO.setLandauthau(lanDauThau);
                    dto.setBid(bidDTO);
                }

                TienDoDTO tienDoDTO = new TienDoDTO();
                tienDoDTO.setQdPheDuyetNgay(qdPheDuyet_ngay);
                tienDoDTO.setQdPheDuyetSo(qdPheDuyet_so);
                tienDoDTO.setTrinhhsSo(trinhHs_so);
                tienDoDTO.setTrinhhsNgay(trinhHs_ngay);
                tienDoDTO.setPheduyetkqSo(duyetHs_so);
                tienDoDTO.setPheduyetkqNgay(duyetHsngay);
                tienDoDTO.setTrinhdangbaoSo(trinhDangBao_so);
                tienDoDTO.setTrinhdangbaoNgay(trinhDangBao_ngay);
                tienDoDTO.setNgaybanhsL1(ngayBanHS_L1);
                tienDoDTO.setNgaybanhsL2(ngayBanHS_L2);
                tienDoDTO.setNgaybanhsL3(ngayBanHS_L3);
                tienDoDTO.setNgaymothauL1(ngayMoThau_L1);
                tienDoDTO.setNgaymothauL2(ngayMoThau_L2);
                tienDoDTO.setNgaymothauL3(ngayMoThau_L3);
                tienDoDTO.setTrinhkqSo(trinhKQ_so);
                tienDoDTO.setTrinhkqNgay(trinhKQ_ngay);
                tienDoDTO.setPheduyetkqSo(pheDuyetKQ_so);
                tienDoDTO.setPheduyetkqNgay(pheDuyetKQ_ngay);
                tienDoDTO.setDbkqLuaChonNhaThauNgay(dbkqLuaChonNhaThau_ngay);
                dto.setTienDo(tienDoDTO);

                if (giaDuThau != null){
                    NoiDungHoSoDTO noiDungHoSoDTO = new NoiDungHoSoDTO();
                    noiDungHoSoDTO.setGiaDuThau(giaDuThau);
                    dto.setNoiDungHoSo(noiDungHoSoDTO);
                }


                dto.setSlNhaThauMuaHS(sl_nhaThauMuaHS);
                dto.setSlNhaThauNopHS(sl_nhaThauNopHS);

                if (tenNhaThau != null || diaChi != null){
                    if (istrungthau.intValue() != 1){
                        if (ngayMuaHoSo != null){
                            dto.setDanhSachNhaThauMuaHS(tenNhaThau);
                            mapNhaThauMuaHS.put(msNhaThau, 1);
                        }
                        if (ngayNopHoSo != null){
                            dto.setDanhSachNhaThauNopHS(tenNhaThau);
                            mapNhaThauNopHS.put(msNhaThau, 1);
                        }
                    }else {
                        NhaThauDTO nhaThauDTO = new NhaThauDTO();
                        nhaThauDTO.setTennhathau(tenNhaThau);
                        nhaThauDTO.setDiachi(diaChi);
                        dto.setNhaThau(nhaThauDTO);
                    }
                }
                if (tinhtrang != null){
                    TinhtrangDTO tinhtrangDTO = new TinhtrangDTO();
                    tinhtrangDTO.setTentinhtrang(tinhtrang);
                    dto.setTinhtrang(tinhtrangDTO);
                }
                if (ngayDangBao != null){
                    List<Timestamp> ngayDangBaoTmp = new ArrayList<>();
                    ngayDangBaoTmp.add(ngayDangBao);
                    dto.setNgayDangBao(ngayDangBaoTmp);
                    mapDangBao.put(msDangBao, 1);
                }
                dtoList.add(dto);
                mapIndex.put(maGoiThau.toString(), dtoList.size() -1);
            }
        }
        resultsObject[1] = dtoList;
        return new Object[]{dtoList.size(), dtoList};
    }
}
