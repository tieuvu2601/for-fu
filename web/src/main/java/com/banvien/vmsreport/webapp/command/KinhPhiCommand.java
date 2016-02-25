package com.banvien.vmsreport.webapp.command;

import com.banvien.vmsreport.common.dto.KinhphiDTO;
import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/10/15
 * Time: 6:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class KinhPhiCommand extends AbstractCommand<KinhphiDTO>{
    public KinhPhiCommand(){
        this.pojo = new KinhphiDTO();
    }
    private List<KinhphiDTO> listkp = LazyList.decorate(new ArrayList(), FactoryUtils.instantiateFactory(KinhphiDTO.class));

    public List<KinhphiDTO> getListkp() {
        return listkp;
    }

    public void setListkp(List<KinhphiDTO> listkp) {
        this.listkp = listkp;
    }
}
