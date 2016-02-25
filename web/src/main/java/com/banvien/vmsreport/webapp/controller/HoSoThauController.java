package com.banvien.vmsreport.webapp.controller;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.BidDTO;
import com.banvien.vmsreport.common.dto.GoithaunhathauDTO;
import com.banvien.vmsreport.common.dto.HoSoThauDTO;
import com.banvien.vmsreport.core.business.BidManagementLocalBean;
import com.banvien.vmsreport.core.business.GoiThauNhaThauManagementLocalBean;
import com.banvien.vmsreport.core.business.HoSoThauManagementLocalBean;
import com.banvien.vmsreport.core.business.NoiDungHoSoManagementLocalBean;
import com.banvien.vmsreport.editor.CustomDateEditorSQL;
import com.banvien.vmsreport.editor.PojoEditor;
import com.banvien.vmsreport.webapp.command.HoSoThauCommand;
import com.banvien.vmsreport.webapp.validator.HoSoThauValidator;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.ejb.DuplicateKeyException;
import javax.ejb.ObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/18/15
 * Time: 8:52 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HoSoThauController extends ApplicationObjectSupport{
    @Autowired
    private HoSoThauManagementLocalBean hoSoThauManagementLocalBean;
    @Autowired
    private GoiThauNhaThauManagementLocalBean goiThauNhaThauManagementLocalBean;
    @Autowired
    private BidManagementLocalBean bidManagementLocalBean;
    @Autowired
    private NoiDungHoSoManagementLocalBean noiDungHoSoManagementLocalBean;
    @Autowired
    private HoSoThauValidator validator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Timestamp.class, new CustomDateEditorSQL("dd/MM/yyyy"));
        binder.registerCustomEditor(HoSoThauDTO.class, new PojoEditor(HoSoThauDTO.class, "mshosothau", Long.class));
    }

    @RequestMapping(value = "/hosonhathau/edit.html")
    public ModelAndView hosonhathau(@ModelAttribute(Constants.FORM_MODEL_KEY)HoSoThauCommand command, HttpServletRequest request) throws ObjectNotFoundException, DuplicateKeyException {
        ModelAndView modelAndView = new ModelAndView("/admin/hosonhathau/edit");
        HoSoThauDTO pojo = command.getPojo();
        String crudaction = command.getCrudaction();
        if(StringUtils.isNotBlank(crudaction) && crudaction.equals("insert-update")){
            if(pojo.getMshosothau() == null){
                pojo = this.hoSoThauManagementLocalBean.insert(pojo);
            }else{
                pojo = this.hoSoThauManagementLocalBean.update(pojo);
            }
            modelAndView.addObject("", "");
        }
        if(pojo.getGoithau_nhathau()!= null && pojo.getGoithau_nhathau().getGoithau() != null && pojo.getGoithau_nhathau().getGoithau().getMsgoithau() != null){
            BidDTO goithau = this.bidManagementLocalBean.findId(pojo.getGoithau_nhathau().getGoithau().getMsgoithau());
            pojo.getGoithau_nhathau().setGoithau(goithau);
            List<GoithaunhathauDTO> listgtnt = this.goiThauNhaThauManagementLocalBean.findByGoiThau(goithau.getMsgoithau());
            modelAndView.addObject("dsnt", listgtnt);
            try{
                if(pojo.getGoithau_nhathau() != null && pojo.getGoithau_nhathau().getMsgoithauNt() != null){
                    pojo.setNoiDungHoSo(this.hoSoThauManagementLocalBean.findByGoiThauNhaThau(pojo.getGoithau_nhathau().getMsgoithauNt()).getNoiDungHoSo());
                }
            }catch (Exception e){

            }
            command.setPojo(pojo);
        }

        modelAndView.addObject(Constants.FORM_MODEL_KEY, command);
        return modelAndView;
    }

    @RequestMapping(value="/ajax/hosonhathau/change_nhathau.html")
    public void changeNhaThau(@ModelAttribute(value="gtnt")Long gt_nt, HttpServletResponse response) throws JSONException, IOException {
        response.setContentType("text/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject obj = new JSONObject();
        try{
            JSONObject hstJSon = new JSONObject();
            HoSoThauDTO hoSoThau = null ;
            try{
                hoSoThau = this.hoSoThauManagementLocalBean.findByGoiThauNhaThau(gt_nt);
            }catch (Exception e){

            }
            if(hoSoThau != null){
                hstJSon.put("tinhTrangNiemPhong", hoSoThau.getNoiDungHoSo().getTinhTrangNiemPhong()) ;
                hstJSon.put("soluongbangoc", hoSoThau.getNoiDungHoSo().getSoLuongBanGoc()) ;
                hstJSon.put("soluongbanchup", hoSoThau.getNoiDungHoSo().getSoLuongBanChup()) ;
                hstJSon.put("thoigiancohieuluc", hoSoThau.getNoiDungHoSo().getThoiGianCoHieuLuc()) ;
                hstJSon.put("giaduthau", hoSoThau.getNoiDungHoSo().getGiaDuThau()) ;
                hstJSon.put("giaduthausauthue", hoSoThau.getNoiDungHoSo().getGiaDuThauSauThue()) ;
                hstJSon.put("giamgia", hoSoThau.getNoiDungHoSo().getGiamGia()) ;
                hstJSon.put("hinhthucgiatrithoihan", hoSoThau.getNoiDungHoSo().getHinhThucGiaTriThoiHan()) ;
                hstJSon.put("thoigianthuchien", hoSoThau.getNoiDungHoSo().getThoiGianThucHien()) ;
                hstJSon.put("dieukienthanhtoan", hoSoThau.getNoiDungHoSo().getDieuKienThanhToan()) ;
                hstJSon.put("giayphepbanhang", hoSoThau.getNoiDungHoSo().getGiayPhepBanHang()) ;
                hstJSon.put("baohanh", hoSoThau.getNoiDungHoSo().getBaoHanh()) ;
                hstJSon.put("nhanhieu", hoSoThau.getNoiDungHoSo().getNhanHieu()) ;
                hstJSon.put("noidunghosoid", hoSoThau.getNoiDungHoSo().getMsnoidunghs()) ;
                hstJSon.put("hosothauid", hoSoThau.getMshosothau()) ;
                obj.put("hsnt", hstJSon);
            }
        }
        catch (Exception e) {
            obj.put("error", getMessageSourceAccessor().getMessage("general.exception.msg"));
            logger.error(e.getMessage(), e);
        }finally {
            out.print(obj);
            out.flush();
            out.close();
        }
    }
}
