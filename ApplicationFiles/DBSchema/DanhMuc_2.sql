Name           Data Type            Explain
-------------- -------------------- --------------------
SHOP_CODE      VARCHAR2(60 BYTE)    
SHOP_TYPE      VARCHAR2(3 BYTE)     
NAME           VARCHAR2(240 BYTE)   
ADDRESS        VARCHAR2(450 BYTE)   
CONTACT_NAME   VARCHAR2(450 BYTE)   
CONTACT_TITLE  VARCHAR2(150 BYTE)   
TEL_NUMBER     VARCHAR2(300 BYTE)   
FAX            VARCHAR2(300 BYTE)   
EMAIL          VARCHAR2(300 BYTE)   
STATUS         VARCHAR2(3 BYTE)     
DESCRIPTION    VARCHAR2(450 BYTE)   
PROVINCE       VARCHAR2(12 BYTE)    
PAR_SHOP_CODE  VARCHAR2(60 BYTE)    Shop cha
PARENT_SHOP    VARCHAR2(60 BYTE)    
CEN_CODE       VARCHAR2(9 BYTE)     
DISTRICT       VARCHAR2(15 BYTE)    Quận/huyện

INSERT INTO shop_vw 
VALUES('2HCM09839','0','Cửa Hàng Quận 12 (MobiFone HCM2)','46 Nguyễn Ảnh Thủ P.Tân Chánh Hiệp Q.12 TPHCM','Nguyễn Tường Vi Thủy',NULL,'0908167167',NULL,NULL,'1','Tạo mã ngày 23/12/2011','HCM','2HCM09881',NULL,'2','012');
INSERT INTO shop_vw 
VALUES('2HCM09770','2','Đại lý Thuận Tín 1368 (MobiFone HCM1)-Chuyên MF','54 Đường 154 KP3 P.Tân Phú Q.09 TPHCM','Lâm Thuận Hải',NULL,NULL,NULL,NULL,'1','Tạo mã 26/05/2011','HCM','2HCM20012',NULL,'2','009');
INSERT INTO shop_vw 
VALUES('2HCM09724','2','Đại lý Thành Thái (MobiFone HCM2)-Chuyên MF','B5/128 Ấp 2 Xã Phong Phú H.Bình Chánh TPHCM','Nguyễn Thị Kim Ngân',NULL,'37612908',NULL,NULL,'1','Tạo mã ngày 28/07/2010','HCM','2HCM30035',NULL,'2','BCH');
INSERT INTO shop_vw 
VALUES('2HCM09715','2','Đại lý Nhất Lộc Phát (MobiFone HCM2)-Chuyên MF','889 Lạc Long Quân P.11 Q.Tân Bình','Kiều Kiến Hưng',NULL,'35022082',NULL,NULL,'1','Tạo mã ngày 06/05/2010','HCM','2HCM00746',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM09744','0','Cửa Hàng Hóc Môn (MobiFone HCM2)','70/2A ấp Hưng Lân xã Bà Điểm huyện Hóc Môn TPHCM',NULL,NULL,NULL,NULL,NULL,'1','Tạo mã 14/01/2011','HCM','2HCM09881',NULL,'2','HMO');
INSERT INTO shop_vw 
VALUES('2HCM09832','0','Cửa Hàng Củ Chi (MobiFone HCM2)','Số 5A1 KP1 T.Trấn Củ Chi H.Củ Chi TPHCM','Nguyễn Thị Mỹ Hạnh',NULL,'8.37906666',NULL,NULL,'1',NULL,'HCM','2HCM09881',NULL,'2','CCH');
INSERT INTO shop_vw 
VALUES('2HCM09836','2','Đại Lý Sao Phương Đông (MobiFone HCM1)-Chuyên MF','Số 8 Đường Số 9 KP1 P.Linh Tây Q.Thủ Đức TPHCM','Nguyễn Thị Lệ Tuyền',NULL,NULL,NULL,NULL,'0','Tạo mã ngày 15/11/2011;25/11/2014 sửa tên ĐL','HCM','2HCM09473',NULL,'2','TDU');
INSERT INTO shop_vw 
VALUES('2HCM09817','2','Đại lý Sim số (MobiFone HCM1)-Chuyên MF','179A Hoàng Diệu 2 P.Linh Trung Q.Thủ Đức TPHCM','Lê Thanh Lan Vy',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 15/09/2011','HCM','2HCM09473',NULL,'2','TDU');
INSERT INTO shop_vw 
VALUES('2HCM09812','2','Đại lý Đồng Tâm (MobiFone HCM1)-Chuyên MF','289 QL1A KP5 P.Bình Chiểu Q.Thủ Đức TPHCM','Nguyễn Bảo Quốc',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 26/08/2011','HCM','2HCM09473',NULL,'2','TDU');
INSERT INTO shop_vw 
VALUES('2HCM09702','2','Đại lý Viễn Thông Tân Phát(MobiFone HCM2)-Chuyên MF','74 Bàu Cát, P.14, Q.Tân Bình','Đặng Hoàng Tuấn',NULL,NULL,NULL,NULL,'1','Tạo mã 09/09/2009','HCM','2HCM00746',NULL,'2','011');
INSERT INTO shop_vw 
VALUES('2HCM09793','1','Đại lý Thuận Thành (MobiFone HCM1)-Tổng đại lý MobiEZ','255 Lê Văn Lương P.Tân Kiểng Q.07 TPHCM','Nguyễn Thanh Hùng',NULL,'08.37753262',NULL,NULL,'1','Tạo mã 15/06/2011','HCM','2HCM09743',NULL,'2','007');
INSERT INTO shop_vw 
VALUES('2HCM09765','2','Đại Lý Tân Thành Danh-TTGD Q.Bình Chánh (MobiFone HCM2)-Chuyên MF','D7/8 Nguyễn Thị Tú Ấp 4 Xã Vĩnh Lộc B H.Bình Chánh TPHCM','Võ Khắc Khuyên',NULL,'38510990',NULL,NULL,'1','Tạo mã 18/05/2011','HCM','2HCM30035',NULL,'2','BCH');
INSERT INTO shop_vw 
VALUES('2HCM09840','2','Đại lý Long Trường (MobiFone HCM1)-Chuyên MF','1318B Nguyễn Duy Trinh P.Long Trường Q.09 TPHCM','Hồ Thái Bình',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 28/12/2011','HCM','2HCM09775',NULL,'2','009');
INSERT INTO shop_vw 
VALUES('2HCM09709','1','Đại Lý VNPAY (MobiFone HCM1)-Mobi Airtime','Phòng 804A số 22 Láng Hạ P.Láng Hạ Q.Đống Đa Hà Nội','Lê Tánh',NULL,'04. 37764668',NULL,NULL,'1','Tạo mã ngày 03/03/2010','HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM09726','2','Đại lý Phúc Thịnh-TTGD Huyện Hóc Môn (MobiFone HCM2)-Chuyên MF','140/2 Nguyễn Ảnh Thủ  xã Trung Chánh huyện Hóc Môn TPHCM','Lê Ngọc Hoàng Nam',NULL,NULL,NULL,NULL,'1','Tạo mã 17/08/2010 - dangth','HCM','2HCM09744',NULL,'2','HMO');
INSERT INTO shop_vw 
VALUES('2HCM09814','2','Đại lý Toàn Thắng (MobiFone HCM1)-Chuyên MF','401 Huỳnh Tấn Phát P.Tân Thuận Đông Q.07 TP.HCM','Đặng Ngọc Tuấn',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 31/08/2011;Sủa gán mã về NB 11/04/2013','HCM','2HCM09746',NULL,'2','007');
INSERT INTO shop_vw 
VALUES('2HCM09811','2','Đại lý Hồng Minh (MobiFone HCM1)-Chuyên MF','209 Hòa Bình P.Hiệp Tân Q.Tân Phú TPHCM','Lương Hồng Loan',NULL,'08.35099939',NULL,NULL,'1','Tạo mã ngày 22/08/2011','HCM','2HCM00746',NULL,'2','TPH');
INSERT INTO shop_vw 
VALUES('2HCM09822','2','Đại lý Thành Viễn (MobiFone HCM2)-Chuyên MF','785 Hồng Bàng P.09 Q.06 TPHCM','Nguyễn Công Hải',NULL,'903959059',NULL,NULL,'1','Tạo mã ngày 26/09/2011','HCM','2HCM00543',NULL,'2','006');
INSERT INTO shop_vw 
VALUES('2HCM09732','1','Đại lý SIM SỐ (TP HCM) - PP bộ trọn gói','198 Xô Viết Nghệ Tĩnh P.21 Q.Bình Thạnh TPHCM','Lê Thanh Lan Vy',NULL,'35180237',NULL,NULL,'1','Tạo mã ngày 27/09/2010','HCM','2HCM06130',NULL,'2','BTH');
INSERT INTO shop_vw 
VALUES('2HCM60004','2','Đại Lý Thái Sơn (MobiFone HCM2)-Chuyên MF','60/21H Trần Văn Mười Ấp 3 Xã Xuân Thới Thượng H.Hóc Môn TPHCM','Nguyễn Văn Bình',NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM09744',NULL,'2','CCH');
INSERT INTO shop_vw 
VALUES('2HCM09727','1','Đại lý VIỄN THÔNG PHÚC THỊNH (MobiFone HCM1) - PP bộ trọn gói','86/59 Phổ Quang P.02 Q.Tân Bình TPHCM','Lê Ngọc Hoàng Nam',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 19/08/2010','HCM','2HCM06130',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM09774','2','Đại lý Duy Nguyên-TTGD Q.Bình Thạnh (MobiFone HCM2)-Chuyên MF','258 Nơ Trang Long P.12 Q.Bình Thạnh TPHCM','Lê Ngọc Hoàng Nam',NULL,NULL,NULL,NULL,'1','Tạo mã 30/05/2011','HCM','2HCM08803',NULL,'2','BTH');
INSERT INTO shop_vw 
VALUES('2HCM09795','1','Đại lý Ghi Bình (MobiFone HCM1)-Tổng đại lý MobiEZ','35/3 Đường số 49 P.Hiệp Bình Chánh Q.Thủ Đức TPHCM','Nguyễn Thế Vĩnh',NULL,NULL,NULL,NULL,'1','Tạo mã 20/06/2011','HCM','2HCM09740',NULL,'2','TDU');
INSERT INTO shop_vw 
VALUES('2HCM09739','2','Đại lý Hoằng Phát (MobiFone HCM1) - Chuyên MF','274 Huỳnh Tấn Phát P. Tân Thuận Tây Q.7 TPHCM','Đặng Sĩ Thanh Bình',NULL,'37717171',NULL,NULL,'1','Tạo mã ngày 11/01/2011 - dangth','HCM','2HCM09746',NULL,'2','007');
INSERT INTO shop_vw 
VALUES('2HCM09823','1','Pháp nhân BHTT Phong Hà (MobiFone HCM1)-Đấu mới MF','146A1 Nguyễn Văn Hưởng Khu biệt thự Thảo Điền P.Thảo Điền Q.02 TPHCM','Phạm Thị Hồng Hà',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 05/10/2011','HCM','2HCM00749',NULL,'2','002');
INSERT INTO shop_vw 
VALUES('2HCM09826','2','Đại lý An Phú (MobiFone HCM2)-Chuyên MF','559A Đường 3/2 P.08 Q.10 TPHCM','Phạm Văn Khương',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 11/10/2011;06/12/2012 chuyển từ SNDU về STCH','HCM','2HCM00746',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM09712','2','Đại lý Kiến Hào (MobiFone HCM2)-Chuyên MF','437A Phạm Văn Chí P.07 Q.06 TPHCM','Võ Huy Trường',NULL,NULL,NULL,NULL,'1','Tạo mã 05/04/2010 - Dangth','HCM','2HCM00543',NULL,'2','006');
INSERT INTO shop_vw 
VALUES('2HCM09828','1','Đại Lý Ủy Quyền-Công Ty TNHH DV Viễn Thông Phúc Thịnh (TT2)_PPTG','25A Cao Thắng P.02 Q.03 TPHCM','Lê Ngọc Hoàng Nam',NULL,'08.39293057',NULL,NULL,'1',NULL,'HCM','2HCM00484',NULL,'2','003');
INSERT INTO shop_vw 
VALUES('2HCM09835','1','Đại lý Viễn Thông Ánh Dương (MobiFone HCM1)-Tổng đại lý MobiEZ','347 Nguyễn Thị Thập P.Tân Phong Q.07 TP.HCM','Nguyễn Thị Bé Hai',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 08/11/2011','HCM','2HCM09743',NULL,'2','007');
INSERT INTO shop_vw 
VALUES('2HCM09734','2','Đại lý Đức Minh (MobiFone HCM2)-Chuyên MF','2788 Phạm Thế Hiển P.07 Q.08 TPHCM','Nguyễn Thanh Minh',NULL,'918459595',NULL,NULL,'1','Tạo mã ngày 27/09/2010','HCM','2HCM00543',NULL,'2','008');
INSERT INTO shop_vw 
VALUES('2HCM09766','2','Đại lý Viễn Sơn (MobiFone HCM2)-Chuyên MF','80/9P Phan Huy Ích P.12 Q.Gò Vấp TPHCM','Trần Thị Bạch Tuyết',NULL,NULL,NULL,NULL,'1','Tạo mã 20/05/2011','HCM','2HCM00551',NULL,'2','GVA');
INSERT INTO shop_vw 
VALUES('2HCM09852','2','Đại lý Ngọc My (MobiFone HCM1)-Chuyên MF','279B Long Thuận P.Long Phước Q.09 TPHCM','Nguyễn ngọc Diễm',NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM20012',NULL,'2','009');
INSERT INTO shop_vw 
VALUES('2HCM09818','7','Tổ Phát triển thị trường (MobiFone HCM2-CN3 cũ)','489 An Dương Vương P.An Lạc A Q.Bình Tân TPHCM','Phan Hải Hưng',NULL,'908086789',NULL,NULL,'1','Tạo mã ngày 16/09/2011','HCM','2HCM09741',NULL,'2','BTA');
INSERT INTO shop_vw 
VALUES('3TTH00081','2','Đại lý Phú Lê Huy(Huế)-Chuyên MF','350/2 Nguyễn Trọng Tuyển Phường 2 Quận Tân Bình Hồ Chí Minh','Tống Thị Kim Liên','Giám Đốc','83.8448737',NULL,NULL,'1','Tạo mã ngày 08/09/2011','HCM','3TTH00037',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM09824','1','Đại lý Công Ty Cổ Phần Dịch Vụ Bồ Câu (CNHCM4)-PP Thẻ Cào','31 Phạm Phú Thứ P.11 Q.Tân Bình TPHCM','Lê Duy An',NULL,'08.35393939',NULL,NULL,'0','Tạo mã ngày 07/10/2011;khd 15/10/2013_VIETHOA','HCM','2HCM09742',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM09847','2','Đại Lý Khánh An Mobile (MobiFone HCM2)-Chuyên MF','64 Đường Số 5 KP3 P.Tân Tạo A Q.Bình Tân TPHCM','Nguyễn Hoài Nam',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 06/04/2012','HCM','2HCM09745',NULL,'2','BTA');
INSERT INTO shop_vw 
VALUES('2HCM60001','2','Đại Lý Đại Tín Phong (MobiFone HCM2)-Chuyên MF','D1 Nguyễn Tri Phương P.14  Q.10 TPHCM','Đinh Quý Thành',NULL,'08.38637303',NULL,NULL,'1',NULL,'HCM','2HCM09839',NULL,'2','HMO');
INSERT INTO shop_vw 
VALUES('2HCM09752','1','Pháp nhân Kiếm Phong (MobiFone HCM2)-PN Thu cước','166 Nguyễn Văn Bá P.Bình Thọ Q.Thủ Đức TPHCM','Nguyễn Văn Yến',NULL,'08 38683479',NULL,NULL,'1','Tạo mã ngày 23/02/2011 - dangth','HCM','2HCM09741',NULL,'2','TDU');
INSERT INTO shop_vw 
VALUES('2HCM09805','2','Đại lý Phúc Khang (MobiFone HCM1)-Chuyên MF','79 Đặng Văn Bi P.Trường Thọ Q.Thủ Đức TPHCM','Lê Văn Khanh',NULL,NULL,NULL,NULL,'1','Tạo mã 06/07/2011','HCM','2HCM09473',NULL,'2','TDU');
INSERT INTO shop_vw 
VALUES('2HCM09737','2','Đại lý Tây Bắc (MobiFone HCM2)-Chuyên MF (ĐGDPTTT)','847 Quốc Lộ 22 KP5 T.Trấn Củ Chi TPHCM','Nguyễn Hoàng Phi',NULL,'39738972',NULL,NULL,'1','Tạo mã ngày 24/11/2010','HCM','2HCM09832',NULL,'2','CCH');
INSERT INTO shop_vw 
VALUES('2HCM09837','2','Đại lý Bình Mỹ (MobiFone HCM2)-Chuyên MF','1991 Ấp 2 Tỉnh Lộ 8 Xã Bình Mỹ H.Củ Chi TPHCM','Lê Thị Kim Ngọc',NULL,'0949288588',NULL,NULL,'1','Tạo mã ngày 25/11/2011','HCM','2HCM09832',NULL,'2','CCH');
INSERT INTO shop_vw 
VALUES('2HCM09763','2','Đại Lý Viễn Thông Hoàng Kim (MobiFone HCM2)-Chuyên MF','977 Hương Lộ 2 P.Bình Trị Đông A Q.Bình Tân TPHCM','Phạm Khải Hoàng',NULL,'8.2655888',NULL,NULL,'1','Tạo mã 18/05/2011','HCM','2HCM09745',NULL,'2','BTA');
INSERT INTO shop_vw 
VALUES('2HCM09699','2','Đại Lý Đỗ Hoàng Tuấn(MobiFone HCM1)-Chuyên MF','Kiot 15C đường 22 chợ Phước Bình P.Phước Bình Q.09 TPHCM','Đỗ Hoàng Tuấn',NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM09473',NULL,'2','009');
INSERT INTO shop_vw 
VALUES('2HCM09710','1','Đại Lý VIETPAY (MobiFone HCM1)-Mobi Airtime','Số 2 G19 Thành Công P.Thành Công Q.Ba Đình Hà Nội','Nguyễn Duy Cường',NULL,'04. 37737319',NULL,NULL,'1','Tạo mã ngày 03/03/2010','HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM09833','2','Đại lý Tâm Tín Phát (MobiFone HCM1)-Chuyên MF','63 Lê Văn Lương Ấp 3 Xã Phước Kiểng H.Nhà Bè  TP.HCM','Hàn Quốc Huy',NULL,'08.37840378',NULL,NULL,'1','Tạo mã ngày 03/11/2011;Sủa gán mã về NB 11/04/2013','HCM','2HCM50011',NULL,'2','NBE');
INSERT INTO shop_vw 
VALUES('2HCM09749','1','Đại lý Trường An (MobiFone HCM2)-Pháp nhân thu cước','10 Tân Quý  P.Tân Quý  Q.Tân Phú','Lâm Thái Tân',NULL,'08.35265492',NULL,NULL,'1','Tạo mã 29/01/2011','HCM','2HCM09742',NULL,'2','TPH');
INSERT INTO shop_vw 
VALUES('2HCM09777','2','Đại lý Sáu Tám Tám-TTGD Quận 7 (MobiFone HCM1)-Chuyên MF','965B Huỳnh tấn Phát P.Phú Thuận Q.07 TPHCM','Nguyễn Hoàng Việt',NULL,'08.37734738',NULL,NULL,'1','Tạo mã 30/05/2011','HCM','2HCM09746',NULL,'2','007');
INSERT INTO shop_vw 
VALUES('2HCM09742','6','Chi Nhánh TPHCM 4','TPHCM',NULL,NULL,NULL,NULL,NULL,'1','Tạo mã 13/01/2011','HCM','2HCM09881',NULL,'2','012');
INSERT INTO shop_vw 
VALUES('2HCM09725','2','Đại lý Phúc Đại Lợi (MobiFone HCM1)-Chuyên MF','271 Nguyễn Thị Định P.Bình Trưng Tây Q.02 TPHCM','Lê Minh Nhựt',NULL,'0837432890',NULL,NULL,'1','Tạo mã ngày 03/08/2010 - Dangth','HCM','2HCM09775',NULL,'2','002');
INSERT INTO shop_vw 
VALUES('2HCM09816','7','Tổ Phát triển thị trường (MobiFone HCM2-CN4 cũ)','70/2A Ấp Hưng Lân Xã Bà Điểm H.Hóc Môn TPHCM','Phan Xuân Châu',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 09/09/2011','HCM','2HCM09744',NULL,'2','HMO');
INSERT INTO shop_vw 
VALUES('2HCM09721','2','Đại lý Phúc Thịnh_Q.Tân Phú (MobiFone HCM2)-Chuyên MF (ĐGDPTTT)','783 Lũy Bán Bích, P. Phú Thọ Hòa, Q. Tân Phú','Lê Ngọc Hoàng Nam',NULL,'39738972',NULL,NULL,'1','Tạo mã ngày 28/07/2010','HCM','2HCM00746',NULL,'2','TPH');
INSERT INTO shop_vw 
VALUES('2HCM09771','2','Đại lý Tín Phát Mobile (MobiFone HCM1)-Chuyên MF','24A Tây Hòa P.Phước Long A Q.09 TPHCM','Đào Tấn Phát',NULL,NULL,NULL,NULL,'1','Tạo mã 26/05/2011','HCM','2HCM09473',NULL,'2','009');
INSERT INTO shop_vw 
VALUES('2HCM09767','2','Đại lý Mobi Nhất Nhất Phát-TTGD Q.08 (MobiFone HCM2)-Chuyên MF','118A Dương Bá Trạc P.02 Q.08 TPHCM','Nguyễn Hồng Nhã',NULL,'38662371',NULL,NULL,'1','Tạo mã 24/05/2011','HCM','2HCM00543',NULL,'2','008');
INSERT INTO shop_vw 
VALUES('TDN','0','Tổ Đấu nối-P.CSKH','TP HCM',NULL,NULL,'088662446',NULL,NULL,'0',NULL,'HCM','2',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM09733','2','Đại lý Trần Vinh (MobiFone HCM2)-Chuyên MF','C9/29B Võ Văn Vân ấp 3 xã Vĩnh Lộc B H.Bình Chánh TPHCM','Trần Ngọc Vinh',NULL,'54282888',NULL,NULL,'1','Tạo mã ngày 27/09/2010','HCM','2HCM00543',NULL,'2','BCH');
INSERT INTO shop_vw 
VALUES('2HCM09775','0','Cửa Hàng Quận 2 (MobiFone HCM1)','191 Trần Não P.Bình An Q.02 TPHCM','Phùng Thị Kim Yến',NULL,NULL,NULL,NULL,'1','Tạo mã 30/05/2011','HCM','2HCM20014',NULL,'2','002');
INSERT INTO shop_vw 
VALUES('2HCM09787','2','Đại lý Ba Phúc (MobiFone HCM1)-Chuyên MF','663 Lã Xuân Oai KP Phước Lai P.Trường Thạnh Q.09 TPHCM','Vũ Trung Hiếu',NULL,NULL,NULL,NULL,'1','Tạo mã 15/06/2011','HCM','2HCM20012',NULL,'2','009');
INSERT INTO shop_vw 
VALUES('2HCM09800','2','Đại lý Thái Ngọc Linh (MobiFone HCM2)-Chuyên MF','426 Lê Thị Riêng P.Thới An Q.12 TPHCM','Nguyễn Thị Mỹ Linh',NULL,NULL,NULL,NULL,'1','Tạo mã 21/06/2011','HCM','2HCM09839',NULL,'2','012');
INSERT INTO shop_vw 
VALUES('2HCM09754','2','Đại lý Quang Anh (CN HCM1) - Chuyên MF','98 Trần Hưng Đạo P.Phạm Ngũ Lão Q1','Lã Thị Thanh',NULL,'36019318',NULL,NULL,'1','Tạo mã ngày 16/03/2011 - dangth','HCM','2HCM00749',NULL,'2','001');
INSERT INTO shop_vw 
VALUES('2HCM09755','2','Đại lý Bảo Phát (MobiFone HCM2)-Chuyên MF','130 Tây Thạnh P.Tây Thạnh Q.Tân Phú','Nguyễn Thị Ngọc Giàu',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 21/03/2011 - dangth','HCM','2HCM08803',NULL,'2','TPH');
INSERT INTO shop_vw 
VALUES('2HCM09723','2','Đại lý Phúc Thịnh_Q.09 (MobiFone HCM1)-Chuyên MF (ĐGDPTTT)','160 Lê Văn Việt P.Tăng Nhơn Phú B Q.09 TPHCM','Lê Ngọc Hoàng Nam',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 28/07/2010','HCM','2HCM09473',NULL,'2','009');
INSERT INTO shop_vw 
VALUES('2HCM09701','2','Đại lý Viễn Thông Tân Tạo(MobiFone HCM2)-Chuyên MF','10-12 Đường C Khu công nghiệp Tân Tạo Q.Bình Tân TPHCM','Lê Phương',NULL,NULL,NULL,NULL,'1','Tạo mã 09/09/2009','HCM','2HCM09745',NULL,'2','BTA');
INSERT INTO shop_vw 
VALUES('2HCM09764','2','Đại Lý Quỳnh Như (MobiFone HCM2)-Chuyên MF','496 Lê Văn Quới P.Bình Hưng Hòa A Q.Bình Tân TPHCM','Phan Minh Linh',NULL,'38762602',NULL,NULL,'1','Tạo mã 18/05/2011','HCM','2HCM09745',NULL,'2','BTA');
INSERT INTO shop_vw 
VALUES('2HCM09802','2','Đại lý Lương Trung-TTGD Q.Thủ Đức (MobiFone HCM1)-Chuyên MF','62 Hiệp Bình KP8 P.Hiệp Bình Chánh Q.Thủ Đức TPHCM','Nguyễn Trần Hoà',NULL,NULL,NULL,NULL,'1','Tạo mã 21/06/2011','HCM','2HCM09473',NULL,'2','TDU');
INSERT INTO shop_vw 
VALUES('2HCM09781','2','Đại lý Viễn Đạt (MobiFone HCM2)-Chuyên MF','89 Tỉnh lộ 8 ấp 1A xã Tân Thạnh Tây H.Củ Chi TPHCM','Nguyễn Văn Danh',NULL,'37950835',NULL,NULL,'1','Tạo mã 07/06/2011','HCM','2HCM09832',NULL,'2','CCH');
INSERT INTO shop_vw 
VALUES('2HCM09807','1','Đại lý Phúc Đại Lợi (MobiFone HCM1)-MobiEZ','31 Nguyễn Văn Bá P.Bình Thọ Q.Thủ Đức TPHCM','Lê Minh Nhựt',NULL,NULL,NULL,NULL,'1','Tạo mã 22/07/2011','HCM','2HCM09740',NULL,'2','TDU');
INSERT INTO shop_vw 
VALUES('2HCM09779','2','Đại lý Hoàng Nguyễn-TTGD Q.09 (MobiFone HCM1)-Chuyên MF','148 Nguyễn Văn Tăng P.Long Thạnh Mỹ Q.09 TPHCM','Nguyễn Văn Sơn',NULL,'08.22415677',NULL,NULL,'1','Tạo mã 07/06/2011','HCM','2HCM09775',NULL,'2','009');
INSERT INTO shop_vw 
VALUES('2HCM09808','2','Đại lý Long Hiệp Phước-TTGD Huyện Nhà Bè (MobiFone HCM1)-Chuyên MF','891 Nguyễn Văn Tạo Xã Hiệp Phước H.Nhà Bè TPHCM','Phạm Minh Tuấn',NULL,'08.38734313',NULL,NULL,'1','Tạo mã 25/07/2011; Sủa gán mã về NB 11/04/2013','HCM','2HCM50011',NULL,'2','NBE');
INSERT INTO shop_vw 
VALUES('2HCM09705','2','Đại lý Hoàng Nguyễn Huy (MobiFone HCM1)-Chuyên MF','632 Tổ 12 ấp Bình Thuận xã Bình Khánh huyện Cần Giờ TP.HCM','Phan Hữu Bình',NULL,'38742350',NULL,NULL,'1','Tạo mã ngày 02/12/2009','HCM','2HCM09743',NULL,'2','CGI');
INSERT INTO shop_vw 
VALUES('2HCM09718','2','Đại lý Phương Nam (TP HCM) - Chuyên MF','49 Hùng Vương P.04  Q.05 TP HCM','Trang Công Cường',NULL,NULL,NULL,NULL,'1','Ngưng ngày 30/06/2011;Tạo mã ngày 24/06/2010','HCM','2HCM06130',NULL,'2','005');
INSERT INTO shop_vw 
VALUES('2HCM09719','1','Đại lý Phát Lộc(MobiFone HCM1) - PP thẻ nạp','613 Nguyễn Đình Chiểu P.2 Q.3 TP.HCM','Nguyễn Hữu Tín',NULL,'38328296',NULL,NULL,'1','Tạo mã ngày 07/08/2010','HCM','2HCM06130',NULL,'2','003');
INSERT INTO shop_vw 
VALUES('2HCM09738','2','Đại lý Hải Hà (MobiFone HCM2)-Chuyên MF','61/676 Nguyễn Oanh phường 6 quận Gò Vấp','Nguyễn Hoàng Phi',NULL,'62530708',NULL,NULL,'1','Tạo mã ngày 24/11/2010','HCM','2HCM00551',NULL,'2','GVA');
INSERT INTO shop_vw 
VALUES('2HCM09821','2','Đại lý Song Nguyễn (MobiFone HCM2)-Chuyên MF','B12/4B Trần Đại Nghĩa Ấp 2 Xã Tân Kiên H.Bình Chánh TPHCM','Nguyễn Thanh Phong',NULL,'903333179',NULL,NULL,'1','Tạo mã ngày 26/09/2011','HCM','2HCM30035',NULL,'2','BCH');
INSERT INTO shop_vw 
VALUES('2HCM09838','2','Đại lý Bưu Điện TPHCM-CN TCT Bưu Chính VN (MobiFone HCM1)-Chuyên MF','125 Hai Bà Trưng P.Bến Nghé Q.01 TPHCM','Đặng Thị Nga',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 25/11/2011','HCM','2HCM00749',NULL,'2','001');
INSERT INTO shop_vw 
VALUES('2HCM09741','6','Chi Nhánh TPHCM 3','TPHCM',NULL,NULL,NULL,NULL,NULL,'1','Tạo mã 13/01/2011','HCM','2HCM09881',NULL,'2','006');
INSERT INTO shop_vw 
VALUES('2HCM09804','2','Đại lý Viễn Phát -TTGD Q.04 (MobiFone HCM1)-Chuyên MF','Số 5 Đường 41 P.06 Q.04 TPHCM','Phạm Thị Thu Thủy',NULL,'934100559',NULL,NULL,'1','Tạo mã 04/07/2011','HCM','2HCM10017',NULL,'2','004');
INSERT INTO shop_vw 
VALUES('2HCM09825','2','Đại lý Công Ty TNHH TM Viễn Phát (MobiFone HCM1)-Chuyên MF','29 Hoàng Diệu P.12 Q.04 TPHCM','Phạm Thị Thu Thủy',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 11/10/2011','HCM','2HCM09473',NULL,'2','004');
INSERT INTO shop_vw 
VALUES('2HCM09796','2','Đại lý Thuận Thành-TTGD Q.08 (MobiFone HCM2)-Chuyên MF','386 Phạm Hùng P.05 Q.08 TPHCM','Nguyễn Thanh Hùng',NULL,'909196879',NULL,NULL,'1','Tạo mã 21/06/2011','HCM','2HCM09745',NULL,'2','008');
INSERT INTO shop_vw 
VALUES('2HCM09716','2','Đại lý Toàn Thắng (MobiFone HCM2)-Chuyên MF','284 Gò Dầu P.Tân Quý Q.Tân Phú TP.HCM','Lê Mạnh Toàn',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 31/05/2010','HCM','2HCM00551',NULL,'2','TPH');
INSERT INTO shop_vw 
VALUES('2HCM60003','2','Đại Lý Vĩnh Hưng Phát (MobiFone HCM2)-Chuyên MF','181 Phan Văn Hớn P.Tân Thới Nhất Q.12 TPHCM','Nguyễn Quang Tấn',NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM09839',NULL,'2','012');
INSERT INTO shop_vw 
VALUES('2HCM09762','2','Đại lý Sao Hải Nam (MobiFone HCM1)-MobiEz','386 Nguyễn Thị Định P.Thạnh Mỹ Lợi Q.02 TPHCM','Nguyễn Văn Ngợi',NULL,'08.62856456',NULL,NULL,'1','Tạo mã 13/05/2011','HCM','2HCM09740',NULL,'2','002');
INSERT INTO shop_vw 
VALUES('2HCM09786','2','Đại lý Hoàng Nguyễn-TTGD Q.02 (MobiFone HCM1)-Chuyên MF','284-286 Nguyễn Duy Trinh P.Bình Trưng Tây Q.02 TPHCM','Nguyễn Văn Sơn',NULL,NULL,NULL,NULL,'1','Tạo mã 15/06/2011','HCM','2HCM09775',NULL,'2','002');
INSERT INTO shop_vw 
VALUES('2HCM09772','2','Đại lý Phú Sơn Trà (MobiFone HCM1)-Chuyên MF','126 Quốc Lộ 13 KP2 P.Hiệp Bình Chánh Q.Thủ Đức TPHCM','Trịnh Sơn',NULL,NULL,NULL,NULL,'1','Tạo mã 26/05/2011','HCM','2HCM09473',NULL,'2','TDU');
INSERT INTO shop_vw 
VALUES('2HCM09713','2','Đại lý Đăng Danh (MobiFone HCM1) - Chuyên MF','41 Trần Nhân Tông, P.9, Q.5','Vũ Văn Quân',NULL,'08.36086969',NULL,NULL,'1','Tạo mã 05/04/2010 - dangth','HCM','2HCM06130',NULL,'2','005');
INSERT INTO shop_vw 
VALUES('2HCM09799','2','Đại lý Lê Sinh (MobiFone HCM2)-Chuyên MF','27 Vườn Lài KP1 P.An Phú Đông Q.12 TPHCM','Lê Hoàng Sinh',NULL,NULL,NULL,NULL,'1','Tạo mã 21/06/2011','HCM','2HCM09839',NULL,'2','012');
INSERT INTO shop_vw 
VALUES('2HCM09720','1','Đại lý DV Viễn thông và In Bưu điện (TP HCM) - PP thẻ nạp','564 Nguyễn Văn Cừ Quận Long Biên Hà Nội','Nguyễn Trọng Thấn',NULL,'04. 36525550',NULL,NULL,'1','Tạo mã ngày 28/07/2010','HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM09851','2','Đại Lý Uyên Ương Khương Nguyên (MobiFone HCM2)-Chuyên MF','102 Tỉnh lộ 15 ấp Phú Lợi Xã Phú Hòa Đông H.Củ Chi TPHCM','Bùi Quang Khương',NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM09832',NULL,'2','CCH');
INSERT INTO shop_vw 
VALUES('2HCM09748','1','Đại lý Kiếm Phong (TP HCM) - Pháp nhân thu cước','240 Cao Thắng  P.12  Q.10','Nguyễn Văn Yến',NULL,'08.38683479',NULL,NULL,'1','Tạo mã 29/01/2011','HCM','2HCM00740',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM09791','2','Đại lý Phúc Hải (MobiFone HCM2)-Chuyên MF','813 Hưng Phú P.09 Q.08 TPHCM','Phạm Bích Thủy',NULL,'906702077',NULL,NULL,'1','Tạo mã 15/06/2011','HCM','2HCM00543',NULL,'2','008');
INSERT INTO shop_vw 
VALUES('2HCM09829','0','Đại Lý Ủy Quyền-Công Ty CP Thế Giới Di Động (TT2)-PPTG','112 Đinh Tiên Hoàng P.Đa Kao Q.01 TPHCM','Nguyễn Đức Tài',NULL,'08.38125960',NULL,NULL,'1',NULL,'HCM','2HCM00484',NULL,'2','001');
INSERT INTO shop_vw 
VALUES('2HCM09794','2','Đại lý Duy Nguyên-TTGD Q.Gò Vấp (MobiFone HCM2)-Chuyên MF','69A Nguyễn Thái Sơn P.04 Q.Gò Vấp','Ngô Anh Cường',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 20/06/2011 - dangth','HCM','2HCM08803',NULL,'2','GVA');
INSERT INTO shop_vw 
VALUES('2HCM09850','2','Đại Lý Khương Việt (MobiFone HCM2)-Chuyên MF','402A QL22 ấp Tân Lập Xã Tân Thông Hội H.Củ Chi TPHCM','Nguyễn Hoàng Tùng',NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM09832',NULL,'2','CCH');
INSERT INTO shop_vw 
VALUES('2HCM09773','2','Đại lý An Thông (MobiFone HCM2)-Chuyên MF','334 Bắc Hải P.06 Q.Tân Bình TPHCM','Nguyễn Văn Thanh',NULL,'08.35093999',NULL,NULL,'1','Tạo mã 30/05/2011; Sửa sang ĐLC 01/02/2013_VIETHOA','HCM','2HCM00746',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM09846','2','Đại Lý Thiên Minh Thịnh (MobiFone HCM2)-Chuyên MF','804/2 Lê Trọng Tấn P.Bình Hưng Hoà Q.Bình Tân TPHCM','Lữ Trọng Hưng',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 06/04/2012','HCM','2HCM09745',NULL,'2','BTA');
INSERT INTO shop_vw 
VALUES('2HCM09788','2','Đại lý Ngân Hồ (MobiFone HCM1)-Chuyên MF','54 Trần Hưng Đạo P.07 Q.05 TPHCM','Tạ Hớn Trung',NULL,NULL,NULL,NULL,'1','Tạo mã 15/06/2011','HCM','2HCM00740',NULL,'2','005');
INSERT INTO shop_vw 
VALUES('2HCM09831','2','Đại Lý CTY TNHH Viễn Thông Thanh (MobiFone HCM2)-Chuyên MF','2 Lương Văn Cang P.15 Q.08 TPHCM','Huỳnh Thị Lệ',NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM00543',NULL,'2','008');
INSERT INTO shop_vw 
VALUES('2HCM09707','1','Pháp Nhân Thu Cước Kiếm Phong','205 Kha Vạn Cân Phường Linh Tây Quận Thủ Đức TPHCM','Phan Thành Nhơn',NULL,'08 38338246',NULL,NULL,'1','Tạo mã 31/12/2009','HCM','2HCM06130',NULL,'2','TDU');
INSERT INTO shop_vw 
VALUES('2HCM09768','2','Đại lý Viễn Trang (MobiFone HCM2)-Chuyên MF','213/8 Tô Ký P.Tân Chánh Hiệp Q.12 TPHCM','Lê Thị Đài Trang',NULL,'08.37156590',NULL,NULL,'1','Tạo mã 26/05/2011','HCM','2HCM09839',NULL,'2','012');
INSERT INTO shop_vw 
VALUES('2HCM09848','2','Đại lý Hiệp Phan (MobiFone HCM1)-Chuyên MF','252A Dương Đình Hội P.Tăng Nhơn Phú B Q.09 TPHCM','Phan Thị Hiệp',NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM20012',NULL,'2','009');
INSERT INTO shop_vw 
VALUES('2HCM09745','0','Cửa Hàng Bình Tân (MobiFone HCM2)','489 An Dương Vương Q. Bình Tân',NULL,NULL,NULL,NULL,NULL,'1','Tạo mã ngày 26/01/2010 - dangth','HCM','2HCM00543',NULL,'2','BTA');
INSERT INTO shop_vw 
VALUES('2HCM09735','2','Đại lý Phương Ký (MobiFone HCM2)-Chuyên MF','187/3D Lê Lợi ấp Tân Thới 3 xã Tân Hiệp huyện Hóc Môn','Lê Văn Ký',NULL,'62568644',NULL,NULL,'0','Tạo mã ngày 08/10/2010 - dangth;Khd 15/10/2013_VIETHOA','HCM','2HCM09744',NULL,'2','HMO');
INSERT INTO shop_vw 
VALUES('2HCM09806','0','Cửa hàng Cần Giờ (MobiFone HCM1)','65/3 Duyên Hải KP Miễu Ba T.Trấn Cần Thạnh H.Cần Giờ TPHCM',NULL,NULL,'909566869',NULL,NULL,'1','Tạo mã 08/07/2011','HCM','2HCM50012',NULL,'2','CGI');
INSERT INTO shop_vw 
VALUES('2HCM09819','2','Tổ Phát triển thị trường (MobiFone HCM1)','379A Huỳnh Tấn Phát T.Trấn Nhà Bè H.Nhà Bè TPHCM','Đỗ Ngọc Tân',NULL,'38739806',NULL,NULL,'2','Tạo mã ngày 19/09/2011','HCM','2HCM09743',NULL,'2','NBE');
INSERT INTO shop_vw 
VALUES('2HCM09747','1','Đại lý Đại Chúng (TP HCM) - Pháp nhân thu cước','42 Xuân Diệu P.4 Q.Tân Bình','Trần Kiếm Hiệp',NULL,'08.38333525',NULL,NULL,'1','Tạo mã 29/01/2011','HCM','2HCM00740',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM09751','1','Đại Lý Đại Chúng (MobiFone HCM1)-PNTC','42 Xuân Diệu P.4 Q.Tân Bình','Trần Kiếm Hiệp',NULL,'08.38333525',NULL,NULL,'1','Tạo mã 29/01/2011','HCM','2HCM09775',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM09845','2','Đại Lý CTY TNHH TM Viễn Phát (MobiFone HCM2)-Chuyên MF','1077B Nguyễn Văn Qúa P.Đông Hưng Thuận Q.12 TPHCM','Phạm Thị Thu Thủy',NULL,NULL,NULL,NULL,'2','Tạo mã ngày 04/04/2012; Ngưng hđ 09/10/2013 do đã dùng mã mới','HCM','2HCM09839',NULL,'2','012');
INSERT INTO shop_vw 
VALUES('2HCM09729','2','Đại lý Phú Kim Điền (MobiFone HCM1)-Chuyên MF','797 Nguyễn Duy Trinh P.Phú Hữu Q.09 TPHCM','Đặng Tú Uyên',NULL,'0837317575',NULL,NULL,'1','Tạo mã 06/09/2010 - dangth','HCM','2HCM20012',NULL,'2','009');
INSERT INTO shop_vw 
VALUES('2HCM09834','1','Đại Lý Giao Nhận Vận Tải Quốc Tế (MobiFone HCM2)-Bộ Trọn Gói','308/44 Hoàng Văn Thụ P.04 Q.Tân Bình TPHCM','Nguyễn Hữu Công',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 07/11/2011','HCM','2HCM09741',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM60002','2','Đại Lý Hoàng Nhung (MobiFone HCM2)-Chuyên MF','460-462-464 QL22 Ấp Đình Xã Tân Phú Trung H.Củ Chi TPHCM','Võ Thị Linh',NULL,'08.37966868-08.37960149',NULL,NULL,'1',NULL,'HCM','2HCM09832',NULL,'2','CCH');
INSERT INTO shop_vw 
VALUES('2HCM09797','2','Đại lý Thìn Phát-TTGD Q.06 (MobiFone HCM2)-Chuyên MF','162-164 Minh Phụng P.06 Q.06 TPHCM','Trương Phú Cường',NULL,'908066486',NULL,NULL,'1','Tạo mã 21/06/2011','HCM','2HCM09745',NULL,'2','006');
INSERT INTO shop_vw 
VALUES('2HCM09783','2','Đại lý Công ty TNHH TM DV Nhất Lộc Phát (MobiFone HCM2)-Chuyên MF','793 Hà Huy Giáp P.Thạnh Xuân Q.12 TPHCM','Phạm Thị Thanh Tuyền',NULL,'908626238',NULL,NULL,'1','Tạo mã 07/06/2011','HCM','2HCM09839',NULL,'2','012');
INSERT INTO shop_vw 
VALUES('2HCM09784','2','Đại lý Nhuận Khang (MobiFone HCM2)-Chuyên MF','246B Đặng Thúc Vịnh ấp 7 Xã Đông Thạnh H.Hóc Môn TPHCM','Nguyễn Trường Thanh',NULL,NULL,NULL,NULL,'1','Tạo mã 07/06/2011','HCM','2HCM09744',NULL,'2','HMO');
INSERT INTO shop_vw 
VALUES('2HCM09827','2','Đại lý Khánh An (MobiFone HCM1)-Chuyên MF','757 Trần Xuân Soạn P.Tân Hưng Q.07 TPHCM',NULL,NULL,NULL,NULL,NULL,'1','Tạo mã ngày 11/10/2011;Sủa gán mã về NB 11/04/2013','HCM','2HCM09746',NULL,'2','007');
INSERT INTO shop_vw 
VALUES('2HCM09714','1','Đại lý INTECOM (MobiFone HCM1) - Phân phối thẻ nạp','65 Lạc Trung, Hai Bà Trng, Hà Nội','Bà Nguyễn Thị Khanh Lê',NULL,'04.44512468',NULL,NULL,'1','Tạo mã ngày 27/04/2010','HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM09843','2','Đại lý Hưng Thịnh Phát (MobiFone HCM1)-Chuyên MF','76 Nguyễn Văn Tạo ấp 2 Xã Long Thới H.Nhà Bè TPHCM','Nguyễn Thị Thanh Hương',NULL,'08.37801618',NULL,NULL,'1',NULL,'HCM','2HCM50011',NULL,'2','NBE');
INSERT INTO shop_vw 
VALUES('2HCM09789','2','Đại lý Tấn Phong (MobiFone HCM2)-Chuyên MF','E6/11 Thới Hòa Ấp 5 Xã Vĩnh Lộc A H.Bình Chánh TPHCM','Nguyễn Thị Nhung',NULL,'987311341',NULL,NULL,'1','Tạo mã 15/06/2011','HCM','2HCM00543',NULL,'2','BCH');
INSERT INTO shop_vw 
VALUES('2HCM09813','2','Đại lý Phi Long (MobiFone HCM1)-Chuyên MF','66 Lâm Văn Bền P.Tân Kiểng,Q.07,TP.HCM','Trần Nguyễn Tấn Quyền',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 31/08/2011;Sủa gán mã về NB 11/04/2013','HCM','2HCM09746',NULL,'2','007');
INSERT INTO shop_vw 
VALUES('2HCM06946','2','Đại Lý CTY Lê Lời (MobiFone HCM2)-Chuyên MF','905A QL1A KP1 P.An Lạc Q.Bình Tân TPHCM','Nguyễn Thị Tuyết Nga','GĐ','7560106',NULL,NULL,'1','Tạo Mã 15/09/2008','HCM','2HCM09745',NULL,'2','BTA');
INSERT INTO shop_vw 
VALUES('2HCM06947','0','Tổ Hỗ Trợ Dịch Vụ (MobiFone HCM1)','CNHCM1',NULL,NULL,NULL,NULL,NULL,'1','Tạo mã 28/08/2008;Sửa tên 01/06/2012','HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM09844','2','Đại Lý An Thy (MobiFone HCM2)-Chuyên MF','1991 Phạm Thế Hiển P.06 Q.08 TPHCM','Lê Thị Ngọc Phương',NULL,'08. 38501041',NULL,NULL,'1',NULL,'HCM','2HCM09745',NULL,'2','008');
INSERT INTO shop_vw 
VALUES('2HCM02617','0','Tổ Văn Phòng - Đài 1090','C30','A Dien','TP',NULL,NULL,NULL,'1','D1090','HCM','2HCM04440',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM07649','2','Đại Lý Phan Khang (MobiFone HCM2)-Chuyên MF','431 Hoàng Văn Thụ P.04 Q.Tân Bình TPHCM','Võ Thùy Lan Hương;Trần Đình Lưu Phong','Lê Hoàng Nguyên Vũ','8116216;0905105581 (Chinh);0935121277 (Hạnh)',NULL,NULL,'1','Tạo mã 27/08/2007','HCM','2HCM00746',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM08925','2','Đại Lý Ngân Giang (MobiFone HCM1)-Chuyên MF','727 Kha Vạn Cân P.Linh Tây Q.Thủ Đức TPHCM','Bùi Thị Kim Ngân','CHT','8970041-7202321',NULL,NULL,'1','Tạo Mã 06/01/2006','HCM','2HCM09473',NULL,'2','TDU');
INSERT INTO shop_vw 
VALUES('2HCM09730','2','Đại lý Mo Bi Phát (MobiFone HCM2)-Chuyên MF','39 Đường Số 10 Khu Trung Sơn Xã Bình Hưng H.Bình Chánh TPHCM','Nguyễn Thị Hồng Lam',NULL,'0903888181',NULL,NULL,'1','Tạo mã ngày 06/09/2010 - dangth','HCM','2HCM30035',NULL,'2','BCH');
INSERT INTO shop_vw 
VALUES('2HCM09746','0','Cửa Hàng Quận 7 (MobiFone HCM1)','279A Huỳnh Tấn Phát Thị trấn Nhà Bè Huyện Nhà Bè TPHCM',NULL,NULL,NULL,NULL,NULL,'1','Tạo mã 28/01/2011','HCM','2HCM50010',NULL,'2','007');
INSERT INTO shop_vw 
VALUES('2HCM09753','2','Đại lý Huệ Minh (MobiFone HCM2)-Chuyên MF','1004 Âu Cơ P.14 Q.Tân Bình TPHCM','Chung Thị Yến Uyên',NULL,'0836019318',NULL,NULL,'1','Tạo mã ngày 25/02/2011 - dangth','HCM','2HCM00746',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM09780','2','Đại lý Hồ Hoa (MobiFone HCM2)-Chuyên MF','260 Tỉnh lộ 15 ấp 11 xã Tân Thạnh Đông H.Củ Chi TPHCM','Hồ Hoa Cường',NULL,'62777779',NULL,NULL,'1','Tạo mã 07/06/2011','HCM','2HCM09832',NULL,'2','CCH');
INSERT INTO shop_vw 
VALUES('2HCM00499','2','Đại Lý Kim Anh (MobiFone HCM2)-Chuyên MF','410 Nguyễn Oanh P.17 Q.Gò Vấp TPHCM','Nguyễn Thị Kim Anh','GĐ','4462203-9845513',NULL,NULL,'1','Tạo Mã 30/06/2005','HCM','2HCM00551',NULL,'2','GVA');
INSERT INTO shop_vw 
VALUES('2HCM00497','1','DAI LY FPT','TP HCM',NULL,NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM04068','2','Đại Lý Vĩnh Thông (MobiFone HCM1)-Chuyên MFone','526 Nguyễn Chí Thanh P.07 Q.10 TPHCM','Ma Thế Toàn, Châu Vĩ Hùng','Giám Đốc','9171988',NULL,'HHPTTB','1','Tạo Mã 11/09/2006','HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM05633','2','Đại Lý Hoàng Hồng Lĩnh (MobiFone HCM1)-Chuyên MF','6/8 Huỳnh Tấn Phát KP5 Thị Trấn Nhà Bè H.Nhà Bè TPHCM','Lê Xuân Hồng Lĩnh;Dương Minh Thảo','CHT','8738739;0903197979',NULL,NULL,'1','Tạo Mã 26/10/2006','HCM','2HCM50011',NULL,'2','NBE');
INSERT INTO shop_vw 
VALUES('2HCM09750','1','Đại lý Thành Công (MobiFone HCM1)-Pháp nhân thu cước','382B B1 Nam Kỳ Khởi Nghĩa  P8  Q3','Nguyễn Quốc Bảo',NULL,'08.38908843',NULL,NULL,'1','Tạo mã 29/01/2011','HCM','2HCM10010',NULL,'2','003');
INSERT INTO shop_vw 
VALUES('2HCM60000','3','Trung tam II (TDN TT6)','Trung tam II (TDN TT6)','Hoang Kim Khoi',NULL,NULL,NULL,NULL,'1','TDN TT6','HCM','2DNI00754',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM09841','2','Đại Lý Bảo Cường (MobiFone HCM2)-Chuyên MF','D13/3 Đinh Đức Thiện ấp 4 xã Bình Chánh H.Bình Chánh TPHCM','Phạm Thị Mỹ Vân',NULL,'8.37605847',NULL,NULL,'1','Tạo mã ngày 16/02/2012','HCM','2HCM30035',NULL,'2','BCH');
INSERT INTO shop_vw 
VALUES('2HCM09743','6','Chi Nhánh TPHCM 5','TPHCM',NULL,NULL,NULL,NULL,NULL,'1','Tạo mã 13/01/2011','HCM','2HCM09876',NULL,'2','NBE');
INSERT INTO shop_vw 
VALUES('2HCM09798','2','Đại lý Phúc Đại Lợi (MobiFone HCM2)-Chuyên MF','D36/8 Hương Lộ 11 Xã Hưng Long H.Bình Chánh TPHCM','Lê Minh Nhựt',NULL,'908212512',NULL,NULL,'1','Tạo mã 21/06/2011','HCM','2HCM30035',NULL,'2','BCH');
INSERT INTO shop_vw 
VALUES('2HCM09731','2','Đại lý Phúc Thịnh_Củ Chi (MobiFone HCM1) - Chuyên MF (ĐGDPTTT)','837 quốc lộ 22 thị trấn Củ Chi tp HCM','Lê Ngọc Hoàng Nam',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 06/09/2010 - dangth','HCM','2HCM06130',NULL,'2','CCH');
INSERT INTO shop_vw 
VALUES('2HCM09849','2','Đại Lý Song Ngọc (MobiFone HCM2)-Chuyên MF','214 Tân Hoà Đông P.Bình Trị Đông Q.Bình Tân TPHCM','Hà Văn Dũng',NULL,'08.38501041',NULL,NULL,'1',NULL,'HCM','2HCM09745',NULL,'2','BTA');
INSERT INTO shop_vw 
VALUES('2HCM09790','2','Đại lý Phương Quân-TTGD Q.Bình Chánh (MobiFone HCM2)-Chuyên MF','A15/3 QL1A Ấp Bình Chánh Xã Bình Chánh H.Bình Chánh TPHCM','Phùng Vĩnh Khoa',NULL,'902776969',NULL,NULL,'1','Tạo mã 15/06/2011','HCM','2HCM30035',NULL,'2','BCH');
INSERT INTO shop_vw 
VALUES('2HCM09704','0','Tổ Nghiệp Vụ-CN HCM 1','TPHCM',NULL,NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM09830','2','Đại lý Phú Thịnh (MobiFone HCM2)-Chuyên MF','626 Kinh Dương Vương P.An Lạc Q.Bình Tân TPHCM','Huỳnh Tiến Hạnh',NULL,'929222555',NULL,NULL,'1',NULL,'HCM','2HCM09745',NULL,'2','BTA');
INSERT INTO shop_vw 
VALUES('2HCM08522','2','Đại Lý Minh Hoàng (MobiFone HCM1)-Chuyên MFone','78 Hùng Vương P.01 Q.10 TPHCM','Nguyễn Văn Minh','CHT','8350220',NULL,NULL,'1','Tạo Mã 25/10/2006','HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM09803','2','Đại lý An Phúc Thịnh (MobiFone HCM2)-Chuyên MF','21 Đường D2 P.25 Q.Bình Thạnh TPHCM','Lương Nguyễn Thanh Trúc',NULL,'908170999',NULL,NULL,'1','Tạo mã 04/07/2011','HCM','2HCM08803',NULL,'2','BTH');
INSERT INTO shop_vw 
VALUES('2HCM06129','2','Đại Lý Xuân Hồng (MobiFone HCM1)-Chuyên MF','190A Đường 3/2 P.14 Q.10 TPHCM','Bùi Văn Đáng; Phan Thụy Thúy Hồng;Nguyễn Văn Minh','GĐ','8649437, 8666878',NULL,NULL,'1','Tạo Mã 28/01/2008;Ngưng MG từ 13h 25/08/2008','HCM','2HCM00495',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM06427','1','Đại Lý Vĩnh Trường Phát (MobiFone HCM1)','39 Đường 232 Cao Lỗ P.04 Q.08 TPHCM','Nguyễn Quan Tấn',NULL,NULL,NULL,NULL,'1','Tạo Mã 22/04/2008','HCM','2HCM06130',NULL,'2','008');
INSERT INTO shop_vw 
VALUES('2HCM06617','1','Đại Lý Nam Quang (MobiFone HCM1)-MobiEZ','841 CMT8 P.06 Q.Tân Bình TPHCM','Nguyễn Xuân Nam','CHT','8644316',NULL,'HHPTTB','1','Tạo Mã 10/08/2006','HCM','2HCM06130',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM06945','1','Pháp Nhân Thu Cước Đại Chúng (MobiFone HCM1)','42 Xuân Diệu P.04 Q.Tân Bình TPHCM','Lê Minh Nhựt; Nguyễn Công Thái','CHT','908212512, 8337906',NULL,NULL,'1','Tạo Mã 23/06/2008','HCM','2HCM09740',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM09415','2','Đại Lý Triều Dâng (MobiFone HCM2)-Chuyên MF','B2/8 Đinh Đức Thiện ấp 2 Xã Bình Chánh H.Bình Chánh TPHCM','Trịnh Kim Thoa','CHT','4290511',NULL,NULL,'1','Tạo mã 26/11/2007','HCM','2HCM30035',NULL,'2','BCH');
INSERT INTO shop_vw 
VALUES('2HCM09473','0','Cửa Hàng Thủ Đức (MobiFone HCM1)','222 Võ Văn ngân P.Bình Thọ Q.Thủ Đức TPHCM','Lương Thanh Khâm','CHT','7225230;0903001353','7225230',NULL,'1',NULL,'HCM','2HCM20013',NULL,'2','TDU');
INSERT INTO shop_vw 
VALUES('2HCM09703','2','Đại lý Một Sáu Tám (MobiFone HCM1)-Chuyên MF','164 Lê Quang Định P.14 Q.Bình Thạnh','Trần Văn Tiến;Lương Hồng Loan',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 22/10/2009','HCM','2HCM08803',NULL,'2','BTH');
INSERT INTO shop_vw 
VALUES('2HCM09722','2','Đại lý Phúc Thịnh-TTGD Quận Bình Tân (MobiFone HCM2)-Chuyên MF','783 Lũy Bán Bích P.Phú Thọ Hòa Q.Tân Phú TPHCM','Lê Ngọc Hoàng Nam',NULL,'38170921',NULL,NULL,'1','Tạo mã ngày 28/07/2010','HCM','2HCM09745',NULL,'2','TPH');
INSERT INTO shop_vw 
VALUES('2HCM09728','1','Đại lý Thiên Tân (MobiFone HCM1) - Phân phối thẻ nạp','752/126 Lạc Long Quân, P.9  Q.Tân Bình TPHCM','Nguyễn Tống Trung',NULL,'38800567',NULL,NULL,'1','Tạo mã 27/08/2010 - dangth','HCM','2HCM06130',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM09792','1','Đại lý Hoằng Phát (MobiFone HCM1)-Tổng đại lý MobiEZ','355 Lê Văn Lương P.Tân Qui Q.07 TPHCM','Đặng Sĩ Thanh Bình',NULL,'08.35033333',NULL,NULL,'1','Tạo mã 15/06/2011','HCM','2HCM09743',NULL,'2','007');
INSERT INTO shop_vw 
VALUES('2HCM00632','0','Tồ HTKH - Đài 1090','C30','Bui Ngoc Diep',NULL,'8662400',NULL,'anhnt@vms.com.vn','1','D1090','HCM','2HCM09875',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM00747','0','Tổ Giải Quyết Khiếu Nại - MobiFone HCM1','123 BHTQ Q.03 TPHCM','Nguyễn Thị Mộng Huyền','Tổ Trưởng',NULL,NULL,NULL,'1',NULL,'HCM','2HCM06130',NULL,'2','003');
INSERT INTO shop_vw 
VALUES('2HCM60005','2','Đại Lý Hoàng Kim (MobiFone HCM2)-Chuyên MF','154 Phạm Văn Bạch P.15 Q.Tân Bình TPHCM','Nguyễn Phạm Quốc Ảnh',NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM00551',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM01063','2','DNTN TM DV Viễn Nam (MobiFone HCM1)-Chuyên MFone','37Bis/7 Đinh Công Tráng P.Tân Định Q.01 TPHCM','Nguyễn Đình Sâm Thương-Nguyễn Quang Minh-Trần Quang Nguyên','Đặng Thị Hồng Hà','8832648,9021886(Q8)','7732338','@HHPTTB','1',NULL,'HCM','2HCM10023',NULL,'2','001');
INSERT INTO shop_vw 
VALUES('2HCM03982','2','Đại Lý Viễn Thông Miền Tây (MobiFone HCM1)-Chuyên MFone','804 Trường Chinh P.15 Q.Tân Bình TPHCM','Nguyễn Văn Thành;Nguyễn Thị Trúc Chi','Giám Đốc','38156093',NULL,'@HHPTTB','1','Tạo Mã 27/07/2006','HCM','2HCM00740',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM00543','0','Cửa Hàng 665 Hậu Giang (MobiFone HCM2)','TP HCM',NULL,NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM09741',NULL,'2','006');
INSERT INTO shop_vw 
VALUES('2HCM00746','0','Cửa Hàng 148 Trường Chinh (MobiFone HCM2)','148 Trường Chinh P.12 Q.Tân Bình TPHCM','Lê Huỳnh Bửu nghiêm','CHT','8105612/13',NULL,NULL,'1',NULL,'HCM','2HCM60007',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM06424','0','Tồ HTDL - CN MobiFone HCM1 1','C30',NULL,'HTDL',NULL,NULL,NULL,'1','CNTP2','HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM08339','2','Đại Lý Mai Nguyễn (MobiFone HCM2)-Chuyên MF','6/11A KP8 T.Trấn Hóc Môn H.Hóc Môn TPHCM','Huỳnh Thị Thanh Thảo;Võ Thanh Hải','GĐ','8914999',NULL,NULL,'1','Tạo Mã 11/09/2006','HCM','2HCM09744',NULL,'2','HMO');
INSERT INTO shop_vw 
VALUES('2HCM03839','2','Đại Lý Châu Anh (MobiFone HCM1)-Chuyên MFone','362A Lê Quang Định P.11 Q.Bình Thạnh TPHCM','Huỳnh Cảnh; Trần Thị Ngọc Nga','CHT','5107099',NULL,'HHPTTB','1','Tạo Mã 09/06/2006','HCM','2HCM06130',NULL,'2','BTH');
INSERT INTO shop_vw 
VALUES('2HCM00748','0','HĐ máy công vụ TT2','MM18 Trường Sơn P.14 Q.10 TPHCM',NULL,NULL,NULL,NULL,NULL,'1','Chuyển ko hd -> đang hd 30/11/2010 -dangth','HCM','2HCM00495',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM04907','1','Đại Lý CN CTY TNHH Phân Phối FPT','TPHCM',NULL,NULL,NULL,NULL,NULL,'1','Tạo mã 07/03/2007','HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM05442','1','Đại Lý XN Viễn Thông Dầu Khí (MobiFone HCM1)-MC','12AB C/X Thanh Đa P.27 Q.Bình Thạnh TPHCM','Huỳnh Văn Thi',NULL,'5561586',NULL,NULL,'1','Tạo mã 24/08/07','HCM','2HCM06130',NULL,'2','BTH');
INSERT INTO shop_vw 
VALUES('2HCM05561','1','Đại lý CTY CP Trực Tuyến (MobiFone HCM1)-EZ','781/C9 Lê Hồng Phong (Nối Dài) P.12 Q.10 TPHCM','Lê Long Điền','CHT','8620377',NULL,NULL,'1','Tạo Mã 07/12/2007','HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM08245','2','Đại Lý VietPhone (MobiFone HCM1)-Chuyên MFone','70 Nguyễn Đình Chiểu P.Đakao Q.01 TPHCM','Trần Thị Mỹ Ngọc, Huỳnh Lê Vinh','PTCH','8241194',NULL,'HHPTTB','1','Tạo Mã 25/11/2005','HCM','2HCM08803',NULL,'2','001');
INSERT INTO shop_vw 
VALUES('2HCM09706','1','Đại lý An Phú (MobiFone HCM1) - Đại lý không chuyên','559A Đường 3/2 Phường 8 Quận 10 TPHCM','Phạm Văn Khương',NULL,'62779800 62779809',NULL,NULL,'1','Tạo mã ngày 04/12/2009','HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM09708','2','Đại lý Duy Nguyên (MobiFone HCM1) - Chuyên MF','53H Nguyễn Du P.Bến Nghé Q.1','Ngô Anh Cường',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 11/01/2010','HCM','2HCM00746',NULL,'2','001');
INSERT INTO shop_vw 
VALUES('2HCM09711','1','Đại Lý Tiên Bích Thủy (CN HCM) - Đại Lý MC','26-28 Đường số 50 P.10 Q.06 TP.HCM','Nguyễn Thị Thủy Tiên',NULL,'37554840',NULL,NULL,'1','Tạo mã ngày 16/03/2010','HCM','2HCM06130',NULL,'2','006');
INSERT INTO shop_vw 
VALUES('2HCM09717','1','Đại lý Minh Đăng Sơn (MobiFone HCM1) - Đại lý PP','Lầu 2 425 Võ Văn Tần P.5 Q3 TPHCM','Bà Trần Ngọc Uyên',NULL,'38292986',NULL,NULL,'1','Tạo mã 03/06/2010','HCM','2HCM06130',NULL,'2','003');
INSERT INTO shop_vw 
VALUES('3QBI00059','2','Đại lý Hoàng Việt Hưng(Quảng Bình)-Chuyên MF','491/35 Lê Văn Sỹ-P12-Q3- TPHCM','Tạ Ngọc Lan','Giám Đốc',NULL,NULL,NULL,'1','Tạo mã ngày 30/09/2011','HCM','3QBI00024',NULL,'2','003');
INSERT INTO shop_vw 
VALUES('2HCM01700','2','Đại Lý Thiên Hưng (MobiFone HCM2)-Chuyên MF','07 Quang Trung P.11 Q.Gò Vấp TPHCM','Nguyễn Thanh Minh','Giám Đốc','8942290-0907426966',NULL,NULL,'1','Tạo Mã 14/04/2006','HCM','2HCM00551',NULL,'2','GVA');
INSERT INTO shop_vw 
VALUES('2HCM09740','6','Chi Nhánh TPHCM 2','TPHCM',NULL,NULL,NULL,NULL,NULL,'1','Tạo mã 13/01/2011','HCM','2HCM09876',NULL,'2','TDU');
INSERT INTO shop_vw 
VALUES('2HCM08011','0','Dai Chuyen mach','TP HCM',NULL,NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM00808',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM02831','2','Đại Lý Vật Tư Bưu Điện (MobiFone HCM1)-Chuyên MF','270 Lý Thường Kiệt P.14 Q.10 TPHCM','Nguyễn Quốc Hùng-Đỗ Đức Hiếu','GĐ-CHT','8639218',NULL,'HHPTTB','1','Tạo Mã 07/12/2005','HCM','2HCM00495',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM00656','6','Trung Tâm 2','TPHCM',NULL,NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM00632',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM09769','1','Đại lý Tiến Minh (MobiFone HCM2)-MobiEz','114A Đường HT6 P.Hiệp Thành Q.12 TPHCM','Đặng Trường Minh',NULL,'08.62559869',NULL,NULL,'1','Tạo mã 26/05/2011','HCM','2HCM09744',NULL,'2','012');
INSERT INTO shop_vw 
VALUES('2HCM05794','1','Đại Lý Mùa Xuân (MobiFone HCM1)-EZ','10 Phổ Quang Q.Tân Bình TPHCM','Lê Cao Việt','Giám Đốc','9973951',NULL,NULL,'1','Tạo mã 25/09/2007','HCM','2HCM06130',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM00541','0','MAY NGHIEP VU','TP HCM',NULL,NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM00495',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM00808','0','Tổ Đấu nối-P.CSKH','TP HCM',NULL,NULL,'088662446',NULL,NULL,'1',NULL,'HCM','0',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM00811','2','ĐLC Huy Phát (MobiFone HCM1)-Chuyên MFone','37/1 Hưng Thạnh Cần Thạnh Cần Giờ TPHCM','Trần Đình Đạm, Nguyễn Thị Búp','CHT','8740477','8740477',NULL,'1',NULL,'HCM','2HCM09746',NULL,'2','CGI');
INSERT INTO shop_vw 
VALUES('2HCM05410','0','Dai Vo Tuyen','TP HCM',NULL,NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM00808',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM09053','2','Đại Lý Kim ánh (MobiFone HCM1)-Chuyên MFone','11A Hùng Vương Q.05 TPHCM','Châu Tuyết Anh','CHT','8354916',NULL,'HHPTTB','1','Tạo Mã 25/11/2005','HCM','2HCM06130',NULL,'2','005');
INSERT INTO shop_vw 
VALUES('2HCM01419','1','Đại Lý Kim ánh (MobiFone HCM1)-Đại Lý MobiEz','20 Hùng Vương P.04 Q.05 TPHCM',NULL,NULL,'8392665',NULL,NULL,'1','Tạo Mã 06/05/2005. Không hđ: 28/11/2005','HCM','2HCM06130',NULL,'2','005');
INSERT INTO shop_vw 
VALUES('2HCM09810','2','Đại lý Trung Lập Hạ (MobiFone HCM2)-Chuyên MF','216 Tỉnh lộ 2 ấp Xóm Mới xã Trung Lập Hạ H.Củ Chi TPHCM','Nguyễn Thị Kim Chi',NULL,'08.35019966',NULL,NULL,'1','Tạo mã ngày 11/08/2011','HCM','2HCM09832',NULL,'2','CCH');
INSERT INTO shop_vw 
VALUES('2HCM09820','2','Đại lý Vạn Phát (MobiFone HCM2)-Chuyên MF','228 Tân Sơn Nhì P.Tân Sơn Nhì Q.Tân Phú TPHCM','Đỗ Xuân Nguyên',NULL,NULL,NULL,NULL,'1','Tạo mã ngày 19/09/2011','HCM','2HCM00551',NULL,'2','TPH');
INSERT INTO shop_vw 
VALUES('2HCM01211','2','Đại Lý TKV (MobiFone HCM2)-Chuyên MF','432 Tân Sơn Nhì P.Tân Quý  Q.Tân Phú TPHCM','Tạ Khánh Vũ','CHT','8120372','4084456-4084041',NULL,'1',NULL,'HCM','2HCM00746',NULL,'2','BTA');
INSERT INTO shop_vw 
VALUES('2HCM07647','2','Đại Lý Phú Khang (MobiFone HCM1)-Chuyên MF','34 Trần Não P.Bình An Q.09 TPHCM','Phạm Thu Hà;Nguyễn Anh Thư',NULL,'7404186;7400987;0909552937 (A.Thu)',NULL,NULL,'1','Tạo mã 27/08/2007','HCM','2HCM09775',NULL,'2','002');
INSERT INTO shop_vw 
VALUES('2HCM00498','1','Đại Lý Công Ty Linh Linh (MobiFone HCM1)-MobiEz','1854 Lạc Long Quân P.10 Q.Tân Bình TPHCM',NULL,NULL,NULL,NULL,'HHPTTB','1','Tạo Mã 06/06/2005','HCM','2HCM06130',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM06830','2','Đại Lý Đại Toàn Phúc (MobiFone HCM1)-Chuyên MF','497 Điện Biên Phủ P.03 Q.03 TPHCM','Nguyễn Công Thái;Phan Ngọc Trâm','CHT','8339707',NULL,NULL,'1','Tạo Mã 16/10/2008','HCM','2HCM00485',NULL,'2','003');
INSERT INTO shop_vw 
VALUES('2HCM06889','2','Đại Lý Điện Thoại Tây TP (MobiFone HCM1)-Chuyên MF','02 Hùng Vương P.01 Q.10 TPHCM','Lê Thị Thu Hà','PGĐ','38322666 - 38652720 - 38910555',NULL,NULL,'1','Tạo mã 20/11/2008','HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM06942','1','Đại Lý CN CTY Sao Sáng (MobiFone HCM1)-PP Bộ Trọn Gói','Lầu 4 42 Phạm NGọc Thạch Q.03 TPHCM','Lê Kiều Khoa','GĐ','0838275566',NULL,'HHPTTB','1','Tạo Mã 29/08/2006','HCM','2HCM06130',NULL,'2','003');
INSERT INTO shop_vw 
VALUES('2HCM07011','2','Đại Lý Hòa Lạc (MobiFone HCM2)-Chuyên MF','311/36 Đường Số 6 P.11 Q.Gò Vấp TPHCM','Đặng Văn Hữu , Phan Thị Hương Thủy','PGĐ','2955561,0903669915,0979754764',NULL,NULL,'1','Tạo Mã 19/01/2007','HCM','2HCM00551',NULL,'2','GVA');
INSERT INTO shop_vw 
VALUES('2HCM04440','0','Đài 1090','c30','a. dien',NULL,NULL,NULL,NULL,'1','D1090','HCM','2HCM00656',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM07648','2','Đại Lý Viễn Phương Nam (MobiFone HCM1)-Chuyên MF','336-338 Lạc Long Quân P.05 Q.11 TPHCM','Nguyễn Thị Thanh;Nguyễn Phi Tiễn',NULL,'9750967',NULL,NULL,'1','Tạo mã 27/08/2007','HCM','2HCM06130',NULL,'2','011');
INSERT INTO shop_vw 
VALUES('2HCM09377','2','Đại Lý Phúc Nguyên Sinh (MobiFone HCM1)-Chuyên MF','401 Lương Định Của P.An Phú Q.02 TPHCM','Nguyễn Duy Huệ','GĐ',NULL,NULL,NULL,'1','Tạo Mã 19/03/2009','HCM','2HCM09775',NULL,'2','002');
INSERT INTO shop_vw 
VALUES('2HCM04317','1','Đại lý Thành Công (MobiFone HCM11)','382B-B1 Nam Kỳ Khởi Nghĩa Phường 8 Quận 3 TP.HCM','Nguyễn Quốc Bảo; Trương Minh Hải; Ng T Ngọc Thúy','CHT','35265838',NULL,NULL,'1','Tạo mã 23/10/2006;Khđ 22/11/2007; Ký lại HĐ 29/04/2010','HCM','2HCM10010',NULL,'2','003');
INSERT INTO shop_vw 
VALUES('2HCM00484','0','PHONG BH-M TT2','TP HCM',NULL,NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM05409',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM06926','2','Đại Lý Viễn Huy (MobiFone HCM2)-Chuyên MF','275 Lê Trọng Tấn P.Sơn Kỳ Q.Tân Phú TPHCM','Nguyễn Tấn Hưng','GĐ','0907778854;8164878',NULL,NULL,'1','Tạo mã 05/10/2007','HCM','2HCM00551',NULL,'2','TPH');
INSERT INTO shop_vw 
VALUES('2HCM04563','2','Đại Lý Thanh Xuân (MobiFone HCM1)-Chuyên MF','190 KP2 Đỗ Xuân Hợp P.Phước Long A Q.09 TPHCM','Phạm Thanh Hoàng','CHT','2827541',NULL,NULL,'1','Tạo Mã 02/11/2006','HCM','2HCM20012',NULL,'2','009');
INSERT INTO shop_vw 
VALUES('2HCM00749','0','Cửa Hàng 82B Nguyễn Du (MobiFone HCM1)','82B Nguyễn Du P.Bến Nghé Q.01 TPHCM','Thuy','Dũng-3803212;Hằng-3777979','8228171',NULL,NULL,'1',NULL,'HCM','2HCM10020',NULL,'2','001');
INSERT INTO shop_vw 
VALUES('2HCM09285','2','Đại Lý Viễn Tiến Phát (MobiFone HCM2)-Chuyên MF','324 Phạm thế hiển P.03 Q.08 TPHCM','Lê Xuân Hồng Nguyên','Giám Đốc','8510990-0908470802',NULL,NULL,'1','Tạo Mã 28/11/2006','HCM','2HCM00543',NULL,'2','008');
INSERT INTO shop_vw 
VALUES('2HCM01550','2','Đại Lý CTY CP VT Đông Tây (MobiFone HCM2)-Chuyên MF','137-139 Chợ Lớn Khu Dân Cư Bình Phú P.11 Q.06 TPHCM','Nguyễn Thị ánh-Tạ Lệ Quyên-Hồ Xuân Trọng','Giám Đốc','8777381',NULL,NULL,'1','Tạo Mã 02/08/2005, chuyển thành chuyên 10/08/2005','HCM','2HCM09741',NULL,'2','006');
INSERT INTO shop_vw 
VALUES('2HCM00495','0','Cửa Hàng 477 Lê Hồng Phong (MobiFone HCM1)','477A-477B Lê Hồng Phong P.02 Q.10 TPHCM',NULL,NULL,'08.38305587-08.38305594',NULL,NULL,'1',NULL,'HCM','2HCM10021',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM06426','2','Đại Lý Nhịp Sống Số (MobiFone HCM1)-Chuyên MFone','Siêu Thị BigC Shop 21- 22 1231 QL1A P.Bình Trị Đông Q.Bình Tân TPHCM','Trương Chí Thiện','GĐ','933909291',NULL,NULL,'1','Tạo Mã 07/04/2008; Sửa chuyển từ CN1 về CN3 25/03/2013;Ngày 01/04/2013 chuyển lại CN1, tạo mã mới cho CN3_VIETHOA','HCM','2HCM00740',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM00560','1','Đại Lý CTY TNHH Tiến Vinh (MobiFone HCM1)-Đlý MobiEz','285 Nguyễn Thiện Thuật P.01 Q.03 TPHCM',NULL,NULL,'8335399',NULL,'HHPTTB','1','Thanh lý HĐ đ/l MCard từ 11/10/04;Chuyển thành Đlý MobiEz 18/02/2005','HCM','2HCM06130',NULL,'2','003');
INSERT INTO shop_vw 
VALUES('2HCM06829','2','Ngân hàng Nông nghiệp','TP HCM',NULL,NULL,NULL,NULL,NULL,'1','Ngân hàng Nông nghiệp','HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM06861','2','Đại Lý Bưu Điện Trung Tâm Thủ Đức(MobiFone HCM1)-Chuyên MF','128A Kha Vạn Cân P.Trường Thọ Q.Thủ Đức TPHCM','Lê T Hồng Cẩm;Anh Thơ;Ngọc Hải;Thu Hồng;Văn Hùng','Xuân Loan;Minh Lý;Thanh Hương','37262566(Bình Triệu);9370124;37201100','Lê T Thoan (Bình Triệu)',NULL,'1','Tạo Mã 27/04/07','HCM','2HCM09740',NULL,'2','TDU');
INSERT INTO shop_vw 
VALUES('2HCM06943','1','Đại Lý Tiên Phúc Kha (MobiFone HCM1)-ĐL Bộ Trọn Gói','37 Phú Lâm P.09 Q.06 TPHCM','Trần Thị Lệ Giang','CHT','2988013',NULL,NULL,'1','Tạo Mã 02/07/2008','HCM','2HCM06130',NULL,'2','006');
INSERT INTO shop_vw 
VALUES('2HCM07428','2','Đại Lý CTY Quảng Cáo Đại Cát (MobiFone HCM1)-Chuyên MF','198 Xô Viết Nghệ Tĩnh P.21 Q.Bình Thạnh TPHCM','Phan Xuân Dương Cầm;Lê Hồ Quang Vĩnh','DĐ: 0913710972-5180043','5144099;8982302 8409642-0909042046','8409642',NULL,'1','Tạo Mã 19/07/2007','HCM','2HCM08803',NULL,'2','BTH');
INSERT INTO shop_vw 
VALUES('2HCM06130','6','Chi Nhánh TPHCM 1','TPHCM',NULL,NULL,NULL,NULL,NULL,'1','Tạo mã 22/02/2008','HCM','2HCM09876',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM06877','2','Đại Lý Phúc Sơn Thịnh (MobiFone HCM1)-Chuyên MF','601 Bình Thới P.10 Q.11 TPHCM','Bùi Thu Hường; Đinh Tuấn Vũ;Diệp Thị Thanh Huệ;Nguyễn Thị Phương Thúy','Nguyễn Phương Thảo','9636525/26',NULL,'@HHPTTB','1','Tạo Mã 03/01/2007','HCM','2HCM00740',NULL,'2','011');
INSERT INTO shop_vw 
VALUES('2HCM09269','0','Tổ Hỗ Trợ Nghiệp Vụ - Đài 1090','C30','Nguyễn Ngọc Khánh',NULL,NULL,NULL,NULL,'1','D1090','HCM','2HCM04440',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM00551','0','Cửa Hàng 170C Quang Trung (MobiFone HCM2)','170C Quang Trung P.10 Q.Gò Vấp TPHCM','Nguyễn Phước Trung','CHT','9892986,9894073,903708383','9890449',NULL,'1',NULL,'HCM','2HCM00746',NULL,'2','GVA');
INSERT INTO shop_vw 
VALUES('2HCM01064','2','Đại Lý Hoài Thủy (BĐ Số 3-MobiFone HCM2)-Chuyên MF','838 QL22 T.Trấn Củ Chi H.Củ Chi TPHCM','Lê Thị Thu Thủy-Trần Thanh Hoài-Huỳnh Bạch Lý','Cửa Hàng Trưởng','37925599',NULL,NULL,'1','Đổi Tên 23/05/2005 (Tên cũ: Đại Lý Bưu Điện Số 3)','HCM','2HCM09744',NULL,'2','CCH');
INSERT INTO shop_vw 
VALUES('2HCM01208','2','Đại Lý Tân Thiên Dương (MobiFone HCM1)-Chuyên MFone','23A Nguyễn Đình Chiểu P.Đakao Q.01 TPHCM','Trần Bình Dương','Giám Đốc','9975253-9974546','9973662',NULL,'1',NULL,'HCM','2HCM10010',NULL,'2','001');
INSERT INTO shop_vw 
VALUES('2HCM00485','0','Cửa Hàng Bà Huyện Thanh Quan (MobiFone HCM1)','123 Bà Huyện Thanh Quan Q.03 TP HCM',NULL,NULL,'088468023',NULL,NULL,'1',NULL,'HCM','2HCM10019',NULL,'2','003');
INSERT INTO shop_vw 
VALUES('2HCM08803','0','Cửa Hàng 145 Lê Quang Định (MobiFone HCM1)','145 Lê Quang Định P.14 Q.Bình Thạnh TPHCM','Nguyễn Thị Lan Anh',NULL,'08.35101786','08.38411157',NULL,'1','15/10/2013 sửa tên từ CH: Cửa Hàng 127 Đinh Tiên Hoàng_VIETHOA','HCM','2HCM09884',NULL,'2','BTH');
INSERT INTO shop_vw 
VALUES('2HCM01859','2','Đại Lý Mê Kông (MobiFone HCM1)-Chuyên MFone','804 Trường Chinh P.15 Q.Tân Bình TPHCM','Nguyễn Thị Minh Hiền','CHT','8158210(TC)',NULL,'HHPTTB','1','Tạo Mã 20/02/2006','HCM','2HCM06130',NULL,'2','TBI');
INSERT INTO shop_vw 
VALUES('2HCM06639','2','Đại Lý Con Đường Mới (MobiFone HCM1)-Chuyên MF','540 CMT8 P.11 Q.03 TPHCM','Hồ Quang Lâm','TGĐ','2412775/76-0933002333',NULL,NULL,'1','Tạo mã 08/10/2007','HCM','2HCM06130',NULL,'2','003');
INSERT INTO shop_vw 
VALUES('2HCM09123','1','Đại Lý Đông Giao (MobiFone HCM1)-MobiEZ','2/5E C/X Cửu Long P.22 Q.Bình Thạnh TPHCM','Nguyễn Mạnh Đức','GĐ','5142636',NULL,'HHPTTB','1','Tạo Mã 10/05/2006','HCM','2HCM06130',NULL,'2','BTH');
INSERT INTO shop_vw 
VALUES('2HCM00797','0','SIM THU','TP HCM',NULL,NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM00489','4CTH00052','2','010');
INSERT INTO shop_vw 
VALUES('2HCM09697','2','Đại lý Chuyên Điện Máy DV Viễn Thông (MobiFone HCM1)','28 Đặng Thị Nhu Q1 TPHCM','Nguyen Huu Thoai - Trung tam Dien May DV Vien Thon','Giam doc','088213609',NULL,NULL,'1','Cap ngay 23/07/2008','HCM','2HCM06130',NULL,'2','001');
INSERT INTO shop_vw 
VALUES('2HCM04318','2','Đại Lý Thế Giới Di Động (MobiFone HCM1)','115 Nguyễn Huệ P.Bến Nghé Q.01 TPHCM','Nguyễn Đức Tài;Huỳnh Anh Huy','CHT','5100100',NULL,NULL,'1','Tạo Mã 23/10/2006','HCM','2HCM00749',NULL,'2','001');
INSERT INTO shop_vw 
VALUES('2HCM00740','0','Cửa  Hàng An Dương Vương (MobiFone HCM1)','252 Trần Hưng Đạo P.04 Q.05 TPHCM','Trần Thị Huyền','Cửa Hàng Trưởng','08.38333456','08.38307179',NULL,'1','25/11/2013 sửa tên CH','HCM','2HCM10018',NULL,'2','005');
INSERT INTO shop_vw 
VALUES('2HCM00806','2','Đại Lý Viễn Thông A (MobiFone HCM1)-Chuyên MFone','328-330 Đường 3/2 P.12 Q.10 TPHCM;415A Hoàng Văn Thụ P.02 Q.TB TPHCM','Huỳnh Thị Lành-Huỳnh Việt Anh-Lan Vy','Tr T Q Quyên-Lê Thị Minh Hiếu','8622788;8112744;0908077977(Hiếu)','8622997;8110099;Lê T Lan Vy','HHPTTB','1','Chuyển thành Đl chuyên 26/09/2005','HCM','2HCM00495',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM05660','2','Đại Lý CTY TNHH Lương Trung (MobiFone HCM1)-Chuyên MF','260 QL1A KP3 P.Tam Bình Q.Thủ Đức TPHCM','Nguyễn Trần Hòa;Nguyễn T Tuyết Hương;Ng Viết Doanh','GĐ','8977100',NULL,NULL,'1','Tạo Mã 12/05/2008','HCM','2HCM09473',NULL,'2','TDU');
INSERT INTO shop_vw 
VALUES('2HCM01210','2','Đại Lý Hiển Trang (MobiFone HCM2)-Chuyên MF','698 Khu Phố 8 Tỉnh Lộ 10 P.Bình Trị Đông Q.Bình Tân TPHCM','Trần Quốc Dũng','Giám Đốc','7626402-0903633313','7523988',NULL,'1',NULL,'HCM','2HCM09745',NULL,'2','BTA');
INSERT INTO shop_vw 
VALUES('2HCM00653','0','Phòng Tin Học Tính Cước','TP HCM',NULL,NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM00808',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM01980','2','Đại Lý Viễn Thịnh (MobiFone HCM2)-Chuyên MF','C4/13 ấp 03 Xã Bình Hưng H.Bình Chánh TPHCM','Trần Thế Linh;Kim Chi;Phùng Hưng;Nguyễn Huệ','Giám Đốc','7582087',NULL,NULL,'1','Tạo Mã 06/03/2006','HCM','2HCM09741',NULL,'2','BCH');
INSERT INTO shop_vw 
VALUES('2HCM08000','1','Đại Lý PT&T (MobiFone HCM1)-MobiEZ','148i Lý Chính Thắng P.07 Q.03','Nguyễn Quang Huy','Giám Đốc','8483208',NULL,'HHPTTB','1','Tạo Mã 16/08/2005','HCM','2HCM06130',NULL,'2','003');
INSERT INTO shop_vw 
VALUES('2HCM09346','0','TT VAS-Ky Thuat DV GTGT','TPHCM',NULL,NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM00808',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM09695','2','Bưu điện','TP HCM',NULL,NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM60006','2','Đại Lý Minh Tuệ (MobiFone HCM1)-Chuyên MF','1004 Tỉnh lộ 43 KP1 P.Bình Chiểu Q.Thủ Đức TPHCM','Trần Minh Tuệ',NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM09473',NULL,'2','TDU');
INSERT INTO shop_vw 
VALUES('2HCM08811','1','Đại Lý Huy Trần (MobiFone HCM1)','70 Trần Hưng Đạo P.Phạm Ngũ Lão Q.01 TP HCM','Nguyễn Thị Quý Hòa - A.Huy','Giám Đốc','8369246-0908006899','9506230','HHPTTB','1','Thanh lý HĐ đ/l MCard từ 11/10/04','HCM','2HCM06130',NULL,'2','001');
INSERT INTO shop_vw 
VALUES('2HCM09422','2','Đại Lý CTY TNHH Bán lẻ FPT (MobiFone HCM1)-Chuyên MF','458 Nguyễn Thị Minh Khai P.02 Q.03 TPHCM','Trần Quốc Hoài;Hoàng Giáng Sinh;Trần Thanh Tâm','Nguyễn Trương Ngọc Hạnh','8301880',NULL,NULL,'1','Tạo Mã 26/10/2007;khđ 13/11/2008','HCM','2HCM06130',NULL,'2','003');
INSERT INTO shop_vw 
VALUES('2HCM00489','0','Phòng CSKH TT2','TP HCM',NULL,NULL,NULL,NULL,NULL,'1','Chi su dung cho P.CSKH','HCM','2HCM00656',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM01438','0','Ke toan thong ke tai chinh','TPHCM',NULL,NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM00808',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM05754','2','Đại Lý ánh Dương (MobiFone HCM1)-Chuyên MFone','347 Nguyễn Thị Thập P.Tân Phong Q.07 TPHCM','Lê Thị Bé Hai','CHT','7751515/16-0907466886',NULL,NULL,'1','Tạo Mã 15/12/2006','HCM','2HCM09746',NULL,'2','007');
INSERT INTO shop_vw 
VALUES('2HCM06425','0','Tồ  BHDL - CN MobiFone HCM1 1','C30',NULL,NULL,NULL,NULL,NULL,'1','CNTP2','HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM06888','2','Đại Lý CTY VT Phúc Thịnh (MobiFone HCM1)-Chuyên MF','78C Bà Huyện Thanh Quan P.09 Q.03 TPHCM','Lê Ngọc Hoàng Nam;Nguyễn Quan Tấn','CHT','2220091',NULL,NULL,'1','Tạo Mã 11/12/2008','HCM','2HCM00495',NULL,'2','003');
INSERT INTO shop_vw 
VALUES('2HCM00561','1','Đại Lý Viễn Quang (MobiFone HCM1)','8 Bàn Cờ Q.03 TP HCM','Phan Thị Minh Trang','8331872','8302522-0908338888','8304483-8395137','HHPTTB','1','Ngưng hđ 22/03/2005, mở lại cho MCard 06/05/2005','HCM','2HCM06130',NULL,'2','003');
INSERT INTO shop_vw 
VALUES('2HCM07833','2','Đại Lý Thuận Thành (MobiFone HCM1)-Chuyên MF','225 Lê văn Lương P.Tân Kiểng Q.07 TPHCM','Nguyễn Thanh Hùng','CHT','37730830',NULL,NULL,'1','Tạo mã 10/04/2009','HCM','2HCM09746',NULL,'2','007');
INSERT INTO shop_vw 
VALUES('2HCM09692','2','Ngân hàng Đầu tư','Ngân hàng Đầu tư',NULL,NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM06130',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM00657','0','Phòng TTCP','TP HCM',NULL,NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM00489',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM01418','1','Đại Lý Hiệp Phát (MobiFone HCM1)','172 Phan Đăng Lưu P.03 Q.Phú Nhuận TPHCM','Vũ Văn Thanh','Giám Đốc','2941030',NULL,'HHPTTB','1','Tạo Mã 30/04/2005','HCM','2HCM06130',NULL,'2','003');
INSERT INTO shop_vw 
VALUES('2HCM05795','0','Tổ Trả Lời Khách Hàng - Đài 1090','C30','Hồ Bạch Thu Trang',NULL,NULL,NULL,NULL,'1','D1090','HCM','2HCM04440',NULL,'2','010');
INSERT INTO shop_vw 
VALUES('2HCM05409','0','Tổ quản lý hồ sơ - P.CSKH','TP HCM',NULL,NULL,NULL,NULL,NULL,'1',NULL,'HCM','2HCM00808',NULL,'2','010');