package com.banvien.vmsreport.webapp.command;

import com.banvien.vmsreport.common.dto.DangBaoDTO;
import com.banvien.vmsreport.common.dto.KinhphiDTO;
import com.banvien.vmsreport.common.dto.TienDoDTO;
import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class TienDoCommand extends AbstractCommand<TienDoDTO>{
    public TienDoCommand(){
        this.pojo = new TienDoDTO();
    }

    private List<KinhphiDTO> listkp = LazyList.decorate(new ArrayList(), FactoryUtils.instantiateFactory(KinhphiDTO.class));
    private List<DangBaoDTO> listndb = LazyList.decorate(new ArrayList(), FactoryUtils.instantiateFactory(DangBaoDTO.class));
    private String bieuMau;

    public List<DangBaoDTO> getListndb() {
        return listndb;
    }

    public void setListndb(List<DangBaoDTO> listndb) {
        this.listndb = listndb;
    }

    public List<KinhphiDTO> getListkp() {
        return listkp;
    }

    public void setListkp(List<KinhphiDTO> listkp) {
        this.listkp = listkp;
    }

    public String getBieuMau() {
        return bieuMau;
    }

    public void setBieuMau(String bieuMau) {
        this.bieuMau = bieuMau;
    }
}
