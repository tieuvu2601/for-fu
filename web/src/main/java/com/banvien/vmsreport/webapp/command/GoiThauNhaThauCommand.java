package com.banvien.vmsreport.webapp.command;

import com.banvien.vmsreport.common.dto.GoithaunhathauDTO;
import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/8/15
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class GoiThauNhaThauCommand extends AbstractCommand<GoithaunhathauDTO> {
    public GoiThauNhaThauCommand(){
        this.pojo = new GoithaunhathauDTO();
    }

    private List lazyList = LazyList.decorate(new ArrayList(), FactoryUtils.instantiateFactory(GoithaunhathauDTO.class));
    private String[] deleteList;

    public List getLazyList() {
        return lazyList;
    }

    public void setLazyList(List lazyList) {
        this.lazyList = lazyList;
    }

    public String[] getDeleteList() {
        return deleteList;
    }

    public void setDeleteList(String[] deleteList) {
        this.deleteList = deleteList;
    }
}
