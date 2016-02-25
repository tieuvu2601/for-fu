package com.banvien.vmsreport.webapp.command;

import com.banvien.vmsreport.common.dto.QuyMoDTO;

public class QuyMoCommand extends AbstractCommand<QuyMoDTO> {
    public QuyMoCommand(){
        this.pojo = new QuyMoDTO();
    }
}
