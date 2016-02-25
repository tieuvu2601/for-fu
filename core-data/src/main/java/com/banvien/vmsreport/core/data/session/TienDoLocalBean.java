package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.DmTinhtrangEntity;
import com.banvien.vmsreport.core.data.entity.TiendoEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TienDoLocalBean  extends GenericSessionBean<TiendoEntity, Long>{
    TiendoEntity findByGoiThauId(Long goiThauId);

    DmTinhtrangEntity getTinhTrangFromTienDoAndGoiThau(Long mstiendo, String magoithau);

    List<TiendoEntity> findByTinhTrangGoiThau(List<String> listTinhTrang);

    List<TiendoEntity> findListTienDoNotComplete(String tinhTrangHoanThanh);

    void deteteByGoiThauId(Long goiThauId);
}
