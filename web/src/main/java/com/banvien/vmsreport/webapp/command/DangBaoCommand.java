package com.banvien.vmsreport.webapp.command;

import com.banvien.vmsreport.common.dto.DangBaoDTO;
import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/16/15
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class DangBaoCommand extends AbstractCommand<DangBaoDTO>{
    public DangBaoCommand(){
        this.pojo = new DangBaoDTO();
    }
    private List<DangBaoDTO> listndb = LazyList.decorate(new ArrayList(), FactoryUtils.instantiateFactory(DangBaoDTO.class));

    public List<DangBaoDTO> getListndb() {
        return listndb;
    }

    public void setListndb(List<DangBaoDTO> listndb) {
        this.listndb = listndb;
    }
}
