package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.DangbaoEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/16/15
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
public interface DangBaoLocalBean extends GenericSessionBean<DangbaoEntity, Long> {
    List<DangbaoEntity> findByGoiThau(Long msgoithau);
    void deteteByGoiThauId(Long goiThauId);
}
