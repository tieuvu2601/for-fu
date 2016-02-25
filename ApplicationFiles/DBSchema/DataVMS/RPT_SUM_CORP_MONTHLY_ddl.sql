-- Start of DDL Script for Table DGNVKHDN_OWNER.RPT_SUM_CORP_MONTHLY
-- Generated 09-Sep-2015 16:52:53 from DGNVKHDN_OWNER@srv_dw2_70.168

CREATE TABLE rpt_sum_corp_monthly
    (sum_month                      DATE,
    tin                            VARCHAR2(100 BYTE),
    bus_permit_no                  VARCHAR2(250 BYTE),
    corp_name                      VARCHAR2(550 BYTE),
    address                        VARCHAR2(600 BYTE),
    pay_full_address               VARCHAR2(700 BYTE),
    district_code_reg              VARCHAR2(40 BYTE),
    district_code_payment          VARCHAR2(40 BYTE),
    emp_code                       VARCHAR2(60 BYTE),
    amount                         NUMBER)
  TABLESPACE  dgnvkhdn_data 
/
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'3603119522001','41112000111','Chi Nhánh Công Ty TNHH Bosch Việt Nam Tại Thành Phố Hồ Chí Minh','Tầng 10 - Tòa Nhà 194 Golden Building Số 473 Đường Điện Biên Phủ Phường 25 Quận Bình Thạnh Thành Phố Hồ Chí Minh','Tầng 10 - Tòa Nhà 194 Golden Building Số 473 Đường Điện Biên Phủ Phường 25 Quận Bình Thạnh Thành Phố Hồ Chí Minh','BTH','BTH',NULL,4);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0312731277','0312731277','Công Ty Trách Nhiệm Hữu Hạn Thương Mại Dịch Vụ Kỹ Thuật Khai Sáng','895 Nguyễn Kiệm Phường 03 Quận Gò Vấp Thành Phố Hồ Chí Minh','895 Nguyễn Kiệm Phường 03 Quận Gò Vấp Thành Phố Hồ Chí Minh','009','GVA',NULL,10);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2900534791','nan_nlo_nlon_ubnd','Đảng Ủy Xã Nghi Long','Xã Nghi Long H.Nghi Lộc Nghệ An','(anh Tuấn Quân Khu) Tổ Xóm 13 Xã Nghi Liên H.Nghi Lộc Nghệ An','NLO','NLO','1NANC00A1147',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0300942001021','0300942001-021','Công Ty Điện Lực Vĩnh Long- Điện Lực Trà Ôn','Số 3 Lê Văn Duyệt T.Trấn Trà Ôn H.Trà Ôn Vĩnh Long','Số 3 Lê Văn Duyệt T.Trấn Trà Ôn H.Trà Ôn Vĩnh Long','VLO','TON','4CTHC00A0009',6);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100111948013','0100111948-013','Ngân Hàng TMCP Công Thương Việt Nam - Chi Nhánh Hà Tây','269 Quang Trung P.Quang Trung Q.Hà Đông Hà Nội','269 Quang Trung P.Quang Trung Q.Hà Đông Hà Nội****sim POS','HDO','HDO',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100230800','0100230800','Ngân Hàng Thương Mại Cổ Phần Kỹ Thương Việt Nam(Lê Đức Thuận 02-3575)','191 Bà Triệu P.Lê Đại Hành Q.Hai Bà Trưng Hà Nội','191 Bà Triệu P.Lê Đại Hành Q.Hai Bà Trưng Hà Nội','HMA','HBT',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0800298850','0800298850','Công Ty Cổ Phần Hoàng Minh','75 Phố Trương Hán Siêu P.Nhị Châu P.Ngọc Châu Thành phố Hải Dương Hải Dương','75 Phố Trương Hán Siêu P.Ngọc Châu Thành phố Hải Dương Hải Dương','HDU','HDU','5HDUC07A0001',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2801311212','THO_THA_THOA_TIHO_THOA',' Trường Tiểu Học Thiệu Hòa','16 1 Cột Cờ  P.Tân Sơn TP Thanh Hóa Thanh Hóa','(tống Văn Thông) Trường Tiểu Học Thiệu Hòa Xã Thiệu Hòa H.Thiệu Hóa Thanh Hóa','THO','THA',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100112437028','0100112437-028','  Ngân Hàng Thương Mại Cổ Phần Ngoại Thương Việt Nam - Chi Nhánh Hải Dương','66 Nguyễn Lương Bằng P.Bình Hàn Thành phố Hải Dương Hải Dương','66 Nguyễn Lương Bằng P.Bình Hàn Thành phố Hải Dương Hải Dương','HDU','HDU','5HDUC07A0001',2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'390196000','3901196000','Công Ty TNHH Một Thành Viên Dịch Vụ Cộng Đồng Trang Thị Tây Ninh','38/8B Ấp Long Bình Xã Long Thành Nam H.Hòa Thành Tây Ninh','38/8B Ấp Long Bình Xã Long Thành Nam H.Hòa Thành Tây Ninh','TNI','HTH',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0304075529','0304075529','Công Ty Cổ Phần Công Nghiệp Vĩnh Tường','Lô C23a  Khu Công Nghiệp Hiệp Phước Xã Hiệp Phước Huyện Nhà Bè Thành Phố Hồ Chí Minh','Lô C23a  Khu Công Nghiệp Hiệp Phước Xã Hiệp Phước Huyện Nhà Bè Thành Phố Hồ Chí Minh','NBE','NBE','2HCMC05A1038',15);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0101135814','0102002663','Công Ty Trách Nhiệm Hữu Hạn Lan','36 Ngách 158/23 Ngọc Hà P.Ngọc Hà Q.Ba Đình Hà Nội','36 Ngách 158/23 Ngọc Hà P.Ngọc Hà Q.Ba Đình Hà Nội','BDI','BDI',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0105702831','0105702831','Công Ty TNHH Thương Mại Và Dịch Vụ Viễn Thông Quang Đăng','120 Lương Thế Vinh P.Thanh Xuân Bắc Q.Thanh Xuân Hà Nội','120 Lương Thế Vinh P.Thanh Xuân Bắc Q.Thanh Xuân Hà Nội','TBI','TXU',NULL,5);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'1801136720','Nguyễn Thanh Sang','P.Tân Lộc Q.Thốt Nốt TP Cần Thơ','248 Tổ 9 Đông Bình P.Tân Lộc Q.Thốt Nốt TP Cần Thơ','HMA','TNO',NULL,3);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0105840359','0105840359','Công Ty Cổ Phần Phát Triển Phần Mềm Và Công Nghệ Việt','Số 16 Thành Công P.Thành Công Q.Ba Đình Hà Nội','Tầng KT Tòa Nhà Licogi 12 Số 21 Đại Từ Đại Từ P.Đại Kim Q.Hoàng Mai Hà Nội','CGI','HMA','1HNOC01A1018',4);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'3602655520','3602655520','Công Ty TNHH Thương Mại Dịch Vụ Cường Hưng Phát','31/4 Kp4 Tổ 5 P.An Bình TP Biên Hòa Đồng Nai','Số 1E Quốc Lộ 1 KP1 P.Bình Đa TP Biên Hòa Đồng Nai','BHO','BHO','6DNIC05A1020',2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0105909000','0105909000','Công Ty Trách Nhiệm Hữu Hạn Jasslin Việt Nam','Số 5 Ngách 43/98 Ngõ 110 Trần Duy Hưng P.Trung Hòa Q.Cầu Giấy Hà Nội','A2 Khu Tập Thể Học Viện Hành Chính Quốc Gia 195 Trung Kính P.Yên Hòa Q.Cầu Giấy Hà Nội','CGI','CGI','1HNOC00A1063',2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0101778163053','0101778163053','Chi Nhánh Hà Nam Công Ty Cổ Phần Viễn Thông FPT','Trần Hưng Đạo P.Trần Hưng Đạo TP.Phủ Lý Hà Nam','132(trang) Trần Hưng Đạo P.Trần Hưng Đạo TP.Phủ Lý Hà Nam','PLY','PLY',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'4600284752','4600284752','Doanh Nghiệp Tư Nhân Hoa Mai','111 Thống Nhất Tổ 1 Xã Tân Lập TP Thái Nguyên Thái Nguyên','111 Thống Nhất Tổ 1 Xã Tân Lập TP Thái Nguyên Thái Nguyên','TNG','TNG','5TNGC12A0002',5);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'1500250887','54A8065668','HKD Lan Thanh','56/8 Nguyễn Trung Trực P.08 TP Vĩnh Long Vĩnh Long','56/8 Nguyễn Trung Trực P.08 TP Vĩnh Long Vĩnh Long','VLO','VLO',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0101567589033','747/QĐ-THVN','Ban Truyền Hình Đối Ngoại Đài Truyền Hình Việt Nam','43 Nguyễn Chí Thanh P.Láng Hạ Q.Ba Đình Hà Nội','43 Nguyễn Chí Thanh P.Thành Công Q.Ba Đình Hà Nội','DDA','BDI',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2800633904006','2800633904-006','Chi Nhánh Tổng Công Ty Thương Mại Và Xây Dựng Đông Bắc - Công Ty THHH Tại Nghệ An','Tổ Xóm 8 Xã Hưng Lợi H.Hưng Nguyên Nghệ An','Anh Tú Tổ Xóm 8 Xã Hưng Lợi H.Hưng Nguyên Nghệ An','HNG','HNG','1NANC00A1003',9);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2500312427','2500312427','Công Ty TNHH Một Thành Viên Thương Mại Và Dịch Vụ Kỹ Thuật Huy Dương','Xã Liên Bảo T/X Vĩnh Yên Vĩnh Phúc','(Nguyễn Tiến Sơn) Xã Liên Bảo T/X Vĩnh Yên Vĩnh Phúc','VYE','VYE','1VPHC00A1007',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0105281809','0105281809','Công Ty Trách Nhiệm Hữu Hạn Đầu Tư Công Nghệ Số Việt Nam','47 Kim Đồng P.Giáp Bát Q.Hoàng Mai Hà Nội','N03 A Chung Cư K26 Đường Dương Quảng Hàm Phường 07 Quận Gò Vấp Thành Phố Hồ Chí Minh','GVA','GVA','2HCMC00A1076',48);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0300942001024','0300942001024','Công Ty Điện Lực Kiên Giang','Số 50 Mạc Thiên Tích P.Bình San T/X Hà Tiên Kiên Giang','Số 77 Cô Bắc P.Vĩnh Bảo TP Rạch Giá Kiên Giang','HTI','RGI','4KGIC08A1023',4);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0500581070','0500581070','Công Ty Trách Nhiệm Hữu Hạn Sản Xuất Và Thương Mại NA-SAI-I','Xã Tốt Động H.Chương Mỹ Hà Nội','242 Lò Đúc P.Đống Mác Q.Hai Bà Trưng Hà Nội****Thư','HBT','HBT',NULL,20);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'NAN_TKY_UBND_NHOAN','Ủy Ban Nhân Dân Xã Nghĩa Hoàn','Xã Nghĩa Hoàn H.Tân Kỳ Nghệ An','Hà Khắc Trung ĐT 975093898 Thường Trực CA Xã Nghĩa Hoàn T.Trấn Tân Kỳ H.Tân Kỳ Nghệ An','TKY','TKY',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'3800426402','442032000068','Công Ty Cổ Phần Gỗ MDF VRG Dongwha','.  Xã Minh Hưng H.Chơn Thành Bình Phước','Lô G KCN MInh Hưng III Xã Minh Hưng H.Chơn Thành Bình Phước****Tuyết','DXO','CTH','6BPHC03A1011',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0312368180','0312368180','Công Ty Trách Nhiệm Hữu Hạn Thương Mại Dịch Vụ Viễn Thông Viễn Hưng','321 Tây Thạnh Phường Tây Thạnh Quận Tân Phú Thành Phố Hồ Chí Minh','321 Tây Thạnh Phường Tây Thạnh Quận Tân Phú Thành Phố Hồ Chí Minh****Cấm Tra Chi Tiết Thuê Bao Và Tác Động Từ Tổng Đài','BTA','TPH','2HCMC06A1053',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2200693852','2200693852','Công Ty TNHH HT&Đ','163 Nguyễn Trung Trực P.02 TP Sóc Trăng Sóc Trăng','Số 11 Ấp An Thạnh T.Trấn Kế Sách H.Kế Sách Sóc Trăng****TBC: Ấp An Thạnh, TT Kế Sách, Kế Sách,ST','STR','KSA',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0302670314','0302670314','Công Ty Trách Nhiệm Hữu Hạn Nhóm Thiên Minh','181A Điện Biên Phủ Phường Đakao Quận 01 Thành Phố Hồ Chí Minh','181A Điện Biên Phủ Phường Đakao Quận 01 Thành Phố Hồ Chí Minh','010','001','2HCMC01A1004',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100112500','0100112500','Công Ty TNHH DELOITTE Việt Nam','Tầng 12A Tòa Nhà Vinaconex, 34 Láng Hạ P.Láng Hạ Q.Đống Đa Hà Nội','Tầng 12A Tòa Nhà Vinaconex 34 Láng Hạ P.Láng Hạ Q.Đống Đa Hà Nội****Cty TNHH DELOITTE Việt Nam Phòng Kế Toán','CGI','DDA','1HNOC00A1043',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'6001384021','6001384021','Doanh Nghiệp Tư Nhân Mỹ Ngọc Ngọc','A1 Quang Trung P.Tân Tiến TP Buôn Mê Thuột ĐắkLắk','A1 Quang Trung P.Tân Tiến TP Buôn Mê Thuột ĐắkLắk','BMT','BMT',NULL,17);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0101014104','0101014104','Công Ty Trách Nhiệm Hữu Hạn Nam Minh Hoàng','Trung Tâm Thương Mại Hoàng Cầu Số 36  Hoàng Cầu P.Ô Chợ Dừa Q.Đống Đa Hà Nội','Trung Tâm Thương Mại Hoàng Cầu Số 36 Hoàng Cầu (tầng 3) P.Ô Chợ Dừa Q.Đống Đa Hà Nội','CGI','DDA','1HNOC01A1008',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'3702309330','462023001148','Công Ty Trách Nhiệm Hữu Hạn Teamade Stationery Việt Nam','Lô G7-G8 KCN Nam Tân Uyên Mở Rộng  Thị xã Tân Uyên Bình Dương','Lô G7-G8 KCN Nam Tân Uyên 2 H.Tân Uyên Bình Dương','TDM','TUY',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'02B8010655','Hộ Kinh Doanh Cá Thể Đỗ Quỳnh Chi','44 Lê Lợi P.Máy Tơ Q.Ngô Quyền Hải Phòng','44 Lê Lợi P.Máy Tơ Q.Ngô Quyền Hải Phòng','NQU','NQU','5HPHC01A1048',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2901513089','2901513089','Công Ty Trách Nhiệm Hữu Hạn Một Thành Viên Xây Lắp 26','P.Đội Cung Vinh Nghệ An','26 Nguyễn Thái Học P.Lê Lợi Vinh Nghệ An****0932380003','VIN','VIN','1NANC00A1003',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'SLA_SLA_BAOSLA','Báo Sơn La','45 Tổ 5 Tô Hiệu P.Tô Hiệu T/X Sơn La Sơn La','45 Tổ 5 Tô Hiệu P.Tô Hiệu T/X Sơn La Sơn La','SLA','SLA',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0106283634','0106283634','Công Ty TNHH Dịch Vụ Viễn Thông Minh An','340 Khương Đình P.Hạ Đình Q.Thanh Xuân Hà Nội','340 Khương Đình P.Hạ Đình Q.Thanh Xuân Hà Nội','HMA','TXU',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2901237713','2901237713','Công Ty TNHH Lan Hải','P.Quang Trung Vinh Nghệ An','37 Nguyễn Huy Oánh Tổ Khối 11 P.Trường Thi Vinh Nghệ An','VIN','VIN','1NANC00A1147',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'64A8003669','HKD Nguyễn Hoàng Tấn Phước','Thửa Đất Số 2440,2441, Tờ Bản Đồ Số 17 Đường Hậu Giang KV2 P.05 TP Vị Thanh Hậu Giang','Kinh Nông Dân Đại Lộ Võ Nguyên Giáp KV2 P.05 TP Vị Thanh Hậu Giang****Lh Chị Huỳnh 0975842240','VTA','VTA',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0105867311','0105867311','Công Ty Trách Nhiệm Hữu Hạn Thương Mại Và Dịch Vụ Sao Hà Thành','100 Ngõ Trại Cá Trương Định P.Trương Định Q.Hai Bà Trưng Hà Nội','P606 Nhà A1 Ngõ 229 Phố Vọng P.Phương Liên Q.Đống Đa Hà Nội','DDA','DDA','1HNOC05A1032',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0303490096','0303490096','Công Ty Cổ Phần VNG','322B Lý Thường Kiệt Phường 14 Quận 10 Thành Phố Hồ Chí Minh','Lầu 13 Số 182 Lê Đại Hành P.15 Q.11 TPHCM','TBI','011','2HCMC06A1047',2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'1801127708','1801127708','Công Ty TNHH Sản Xuất Và Thương Mại Khánh Việt','42/1 Tỉnh Lộ 918 P.Bình Thủy Q.Bình Thủy TP Cần Thơ','42/1 Tỉnh Lộ 918 P.Bình Thủy Q.Bình Thủy TP Cần Thơ','NKI','BTH',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0310623565','0310623565','Công Ty Cổ Phần Đầu Tư Kinh Doanh Sáng Tạo Việt','145 Lê Quang Định Phường 14 Quận Bình Thạnh Thành Phố Hồ Chí Minh','145 Lê Quang Định Phường 14 Quận Bình Thạnh Thành Phố Hồ Chí Minh','BTH','BTH','2HCMC06A1115',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'54A80007002','Shop Tuổi Thơ','168/6A Lê Thái Tổ P.02 TP Vĩnh Long Vĩnh Long','Khóm 3 Gia Long T.Trấn Trà Ôn H.Trà Ôn Vĩnh Long','VLO','TON',NULL,5);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'54E80001590','Trương Đào Xuân','109A/06 Ấp Sơn Đông Xã Thanh Đức H.Long Hồ Vĩnh Long','Ấp Đông Hưng 1 Tổ 3 Xã Đông Thành T/X Bình Minh Vĩnh Long','VLO','BMI',NULL,5);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'3701485291','3701485291','Công Ty TNHH Tư Vấn Xây Dựng Nam Việt Hưng','Khu Phố 2 T.Trấn Dầu Tiếng H.Dầu Tiếng Bình Dương','Khu Phố 2 T.Trấn Dầu Tiếng H.Dầu Tiếng Bình Dương****Khu Phố 4B - Gần Đường Sân Bay_Trần Quốc Toàn','TDM','DTI','6BDUC02A1031',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0300942001020','0300942001020','Điện Lực Tân Phước','Khu 4 T.Trấn Mỹ Phước H.Tân Phước Tiền Giang','Khu 4 T.Trấn Mỹ Phước H.Tân Phước Tiền Giang','MTH','TPH','4TGIC10A1006',4);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0104962121','0104962121','Công Ty Cổ Phần Vcomsat','Tầng 4 Số 349 Đường Hoàng Quốc Việt P.Nghĩa Tân Q.Cầu Giấy Hà Nội','Tầng 4 Số 349 Đường Hoàng Quốc Việt P.Nghĩa Tân Q.Cầu Giấy Hà Nội','DDA','CGI','1HNOC01A1018',196);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'3600253135001','472043000256','Chi Nhánh Công Ty TNHH TENMA (HCM) Việt Nam','Kho Bải Trám  Xã Việt Hùng H.Đông Anh Hà Nội','Kho Bãi Trám Xã Việt Hùng H.Đông Anh Hà Nội','LBI','DAN','1HNOC00A1238',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2801946931','2801946931','Công Ty TNHH Xây Dựng Và Vận Tải Trung Dũng','Xã Cẩm Yên H.Cẩm Thủy Thanh Hóa','01 Nguyễn Công Trứ P.Đông Sơn TP Thanh Hóa Thanh Hóa','THO','THO',NULL,3);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0106299911','0106299911','Công Ty Trách Nhiệm Hữu Hạn Thương Mại Dịch Vụ Giao Nhận Tín Phát','56/169 Hoàng Mai P.Hòang Văn Thụ Q.Hoàng Mai Hà Nội','56/169 Hoàng Mai P.Hòang Văn Thụ Q.Hoàng Mai Hà Nội','TXU','HMA',NULL,3);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'4100387037','4100387037','Doanh Nghiệp Tư Nhân Thương Mại Thu Thảo','20 Nguyễn Hữu Thọ P.Thị Nại TP Qui Nhơn Bình Định','20 Nguyễn Hữu Thọ P.Thị Nại TP Qui Nhơn Bình Định','QNH','QNH',NULL,7);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2700579876','09B8003487','Hộ Kinh Doanh Như Ý','P.Bắc Sơn T/X Tam Điệp Ninh Bình','Số Nhà 594 Tổ 11 P.Bắc Sơn T/X Tam Điệp Ninh Bình','TDI','TDI',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2300835282','2300835282','CÔNG TY CP VẬN TẢI VÀ DỊCH VỤ CÔNG CỘNG BẮC NINH','34 Nguyễn Gia Thiều P.Suối Hoa TP Bắc Ninh Bắc Ninh','34 Nguyễn Gia Thiều P.Suối Hoa TP Bắc Ninh Bắc Ninh','BNI','BNI','5BNIC08A1008',7);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2801158271','26-07L00002','Hợp Tác Xã Thương Mại Và Dịch Vụ Vận Tải Tiến Phương','Xã Yên Cát H.Như Xuân Thanh Hóa','Xe(0308) Thị Trấn Bến Sung H.Như Thanh Thanh Hóa','NTH','NTH',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0104867975','0104867975','Công Ty Cổ Phần Công Nghệ Điện Tử Và Viễn Thông Việt Nam','Lô 8, Dãy B, Số Nhà 29, Khu Đô Thị Mới Định Công  P.Định Công Q.Hoàng Mai Hà Nội','Lô 8 Dãy B,số Nhà 29, Khu Đô Thị Mới Định Công P.Định Công Q.Hoàng Mai Hà Nội','DDA','HMA','1HNOC00A1237',10);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100230800','0100230800','Ngân Hàng Thương Mại Cổ Phần Kỹ Thương Việt Nam(Trần Thị Thúy Vân 02-2765)','191 Bà Triệu P.Lê Đại Hành Q.Hai Bà Trưng Hà Nội','191 Bà Triệu P.Lê Đại Hành Q.Hai Bà Trưng Hà Nội****500K','HMA','HBT',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0106571194','0106571194','Công Ty Cổ Phần Thương Mại Điểm Vàng SKL','62/255 Lý Chính Thắng Phường 08 Quận 03 Thành Phố Hồ Chí Minh','62/255 Lý Chính Thắng Phường 08 Quận 03 Thành Phố Hồ Chí Minh','CGI','003','1HNOC00A1043',48);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'4300386506','4300386506','Đại Lý Bưu Điện Long Thành','Xóm 5 Thạch By 1 Xã Phổ Thạnh H.Đức Phổ Quảng Ngãi','Xóm 5 Thạch By 1 Xã Phổ Thạnh H.Đức Phổ Quảng Ngãi','DPH','DPH',NULL,8);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0305247442','0305247442','Công Ty Trách Nhiệm Hữu Hạn Phát Triển Công Nghệ Một Chín Ba','204/1 Nơ Trang Long Phường 12 Quận Bình Thạnh Thành Phố Hồ Chí Minh','204/1 Nơ Trang Long Phường 12 Quận Bình Thạnh Thành Phố Hồ Chí Minh','TBI','BTH',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'04/BNG-BC','Văn Phòng Báo Chí Thường Trú Channel Newsasia Tại Hà Nội','Phòng 3-01 A Khách Sạn Sofitel Plaza Thanh Niên P.Trúc Bạch Q.Ba Đình Hà Nội','Số 1 Phòng 3-01 A Khách Sạn Sofitel Plaza Thanh Niên P.Trúc Bạch Q.Ba Đình Hà Nội','TXU','BDI',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0302538267','0302538267','Công Ty Trách Nhiệm Hữu Hạn Thương Mại Điện Tử Vinh Hiển','12 Bàu Cát 3 Phường 13 Quận Tân Bình Thành Phố Hồ Chí Minh','12 Bàu Cát 3 Phường 13 Quận Tân Bình Thành Phố Hồ Chí Minh','010','TBI','2HCMC00A1090',245);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'nbi_gvi_gv_thgv','Trường Tiểu Học Gia Vượng','Xã Gia Vượng H.Gia Viễn Ninh Bình','Xã Gia Vượng H.Gia Viễn Ninh Bình','GVI','GVI',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0302538267','0302538267','Công Ty Trách Nhiệm Hữu Hạn Thương Mại Điện Tử Vinh Hiển','12 Bàu Cát 3 Phường 13 Quận Tân Bình Thành Phố Hồ Chí Minh','12 Bàu Cát 3 Phường 13 Quận Tân Bình Thành Phố Hồ Chí Minh','010','TBI',NULL,5);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0105818226','011043001542','Công Ty Trách Nhiệm Hữu Hạn Giải Pháp Công Trường Xây Dựng Doosan Việt Nam','P1806 Keangnam Hà Nội Landmark Tower Phường Mễ Trì Quận Nam Từ Liêm Hà Nội','P1806 Keangnam Hà Nội Landmark Tower Phường Mễ Trì Quận Nam Từ Liêm Hà Nội','CGI','NTL',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0104587576','0104587576','Công Ty Cổ Phần Xây Dựng Hạ Tầng Kỹ Thuật','Số 13 Ngõ 97  P.Khương Trung Q.Thanh Xuân Hà Nội','Tầng 13 Tòa Nhà Vinaconex 9 Phường Mễ Trì Quận Nam Từ Liêm Hà Nội','CGI','NTL',NULL,5);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100971460','011043000295','Công Ty Trách Nhiệm Hữu Hạn KDDI Việt Nam','Tầng 15 Tòa Nhà Icon4 Số 243A La Thành P.Láng Thượng Q.Đống Đa Hà Nội','Tầng 15 Tòa Nhà Icon4 Số 243A La Thành P.Láng Thượng Q.Đống Đa Hà Nội','CGI','DDA','1HNOC01A1020',6);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0401226413','0401226413','Công Ty CP Vận Tải & Dịch Vụ Phú Hoàng','192 Xuân Thủy P.Khuê Trung Q.Cẩm Lệ Đà Nẵng','150 Đường 2/9 P.Bình Hiên Q.Hải Châu Đà Nẵng****Sim 3G Wifi','TKH','HCH',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100686174026','0100686174-026','Ngân Hàng Nông Nghiệp Và Phát Triển Nông Thôn Việt Nam-Chi Nhánh Phú Nhuận','135A Phan Đăng Lưu Phường 02 Quận Phú Nhuận Thành Phố Hồ Chí Minh','135A Phan Đăng Lưu Phường 02 Quận Phú Nhuận Thành Phố Hồ Chí Minh','TBI','PNH','2HCMC01A1055',8);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0801014893','0801014893','  Công Ty Cổ Phần Thương Mại Và Dịch Vụ Hà Thái Liên','Số 10 Ngõ 18A Phố Triệu Quang Phục Xã Cẩm Thượng Thành phố Hải Dương Hải Dương','Số 10 Ngõ 18A Phố Triệu Quang Phục Xã Cẩm Thượng Thành phố Hải Dương Hải Dương','HDU','HDU','5HDUC07A0001',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'NAN_ASO_TSO1_VPUB','Ủy Ban Nhân Dân Xã Thạch Sơn Huyện Anh Sơn','Xã Thạch Sơn H.Anh Sơn Nghệ An','Kim Anh 0976034882 Xã Thạch Sơn H.Anh Sơn Nghệ An','ASO','ASO',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0312368180','0312368180','Công Ty Trách Nhiệm Hữu Hạn Thương Mại Dịch Vụ Viễn Thông Viễn Hưng','321 Tây Thạnh Phường Tây Thạnh Quận Tân Phú Thành Phố Hồ Chí Minh','321 Tây Thạnh Phường Tây Thạnh Quận Tân Phú Thành Phố Hồ Chí Minh','BTA','TPH','2HCMC06A1053',4);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100230800','0100230800','Ngân Hàng Thương Mại Cổ Phần Kỹ Thương Việt Nam(Nguyễn Thị Hồng Yến 02-4981)','191 Bà Triệu P.Lê Đại Hành Q.Hai Bà Trưng Hà Nội','191 Bà Triệu P.Lê Đại Hành Q.Hai Bà Trưng Hà Nội','HMA','HBT',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0310671135','411043001520','Công Ty Trách Nhiệm Hữu Hạn Johnson & Johnson (Việt Nam)','Số 35 Lầu 3 Tòa Nhà Harbour View Tower Đường Nguyễn Huệ Phường Bến Nghé Quận 01 Thành Phố Hồ Chí Minh','Số 35 Lầu 3 Tòa Nhà Harbour View Tower Đường Nguyễn Huệ Phường Bến Nghé Quận 01 Thành Phố Hồ Chí Minh','009','001','2HCMC01A1162',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2900785883','2900785883','Công Ty Trách Nhiệm Hữu Hạn Thương Mại Và Dịch Vụ Công Minh','197 Lê Duẩn P.Trung Đô Vinh Nghệ An','Số 44 Đinh Công Tráng P.Lê Mao Vinh Nghệ An','VIN','VIN',NULL,5);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0309865746','411032000081','Công Ty Cổ Phần UPS Việt Nam','18A Cộng Hòa Phường 12 Quận Tân Bình Thành Phố Hồ Chí Minh','18A Cộng Hòa Phường 12 Quận Tân Bình Thành Phố Hồ Chí Minh','TBI','TBI','2HCMC06A1166',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'3901196000','3901196000','Công Ty TNHH Một Thành Viên Dịch Vụ Cộng Đồng Trang Thị Tây Ninh','38/8B Ấp Long Bình Xã Long Thành Nam H.Hòa Thành Tây Ninh','38/8B Ấp Long Bình Xã Long Thành Nam H.Hòa Thành Tây Ninh','TNI','HTH',NULL,47);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100111948059','0100111948-059','Ngân Hàng Thương Mại Cổ Phần Công Thương Việt Nam-Chi Nhánh 10 Thành Phố Hồ Chí Minh','111-121 Ngô Gia Tự Phường 02 Quận 10 Thành Phố Hồ Chí Minh','111-121 Ngô Gia Tự P.02 Q.10 TPHCM','010','010','2HCMC01A1000',4);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0103834550','0102038939','Công Ty TNHH Thương Mại Và Kỹ Thuật Máy Văn Phòng Quang Minh','597 Giải Phóng P.Giáp Bát Q.Hoàng Mai Hà Nội','597 Giải Phóng P.Giáp Bát Q.Hoàng Mai Hà Nội','CGI','HMA',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'5700883712','5700883712','Công Ty TNHH Hai Thành Viên Thương Mại - Dịch Vụ Và XNK Tổng Hợp Trường Phúc','Số 47 Tổ 4 Khu 2B P.Cẩm Trung TP Cẩm Phả Quảng Ninh','Ngõ 344 (Nguyễn Trọng Anh - 100287954) Trần Phú Tổ 8 P.Cẩm Trung TP Cẩm Phả Quảng Ninh','CPH','CPH','5QNIC03A1002',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100150619067','0100150619-067','Ngân Hàng Thương Mại Cổ Phần Đầu Tư Và Phát Triển Việt Nam - Chi Nhánh Sở Giao Dịch 1','191 Bà Triệu P.Lê Đại Hành Q.Hai Bà Trưng Hà Nội','Tháp A Vincom - Tầng 8,191 Bà Triệu P.Lê Đại Hành Q.Hai Bà Trưng Hà Nội','HMA','HBT',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100686174028','0100686174-028','Ngân Hàng Nông Nghiệp Và Phát Triển Nông Thôn Việt Nam-Chi Nhánh 4','Tầng Trệt Tầng Lửng Tầng 1 Và Tầng 2 Cao Ốc H2 Hoàng Diệu Phường 08 Quận 04 Thành Phố Hồ Chí Minh','Tầng Trệt Tầng Lửng Tầng 1 Và Tầng 2 Cao Ốc H2 Hoàng Diệu Phường 08 Quận 04 Thành Phố Hồ Chí Minh','004','004','2HCMC01A1183',50);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100150619114','0100150619-114','Ngân Hàng Thương Mại Cổ Phần Đầu Tư Và Phát Triển Việt Nam - Chi Nhánh Hoàn Kiếm','Số 194 Trần Quang Khải P.Lý Thái Tổ Q.Hoàn Kiếm Hà Nội','Số 194 Trần Quang Khải P.Lý Thái Tổ Q.Hoàn Kiếm Hà Nội','HMA','HKI','1HNOC05A1040',15);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0312773252','0312773252','Công Ty Trách Nhiệm Hữu Hạn Dịch Vụ Bất Động Sản An Phước Hưng','14/20 Nhất Chi Mai Phường 13 Quận Tân Bình Thành Phố Hồ Chí Minh','14/20 Nhất Chi Mai Phường 13 Quận Tân Bình Thành Phố Hồ Chí Minh','BTH','TBI',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'3501970854','3501970854','Công Ty Trách Nhiệm Hữu Hạn Thương Mại Hữu Linh','352 Nguyễn An Ninh P.08 TP Vũng Tàu Bà Rịa - Vũng Tàu','352 Nguyễn An Ninh P.08 TP Vũng Tàu Bà Rịa - Vũng Tàu','BRI','VTA','6BRVC01A1014',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0105999413','53/2012/QĐ-BXD','Cty JFE Engineering Corporation NB-TP TCGT 72000 Thuộc GT Số 10A Cho DAXD Nhà Ga HK T2 Cảng HKQT NB','Thôn Thạch Lỗi Xã Thanh Xuân H.Sóc Sơn Hà Nội','Lô 1 Khu Công Nghiệp Nội Bài Xã Quang Tiến H.Sóc Sơn Hà Nội','LBI','SSO',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100111948057','0100111948-057','Ngân Hàng Thương Mại Cổ Phần Công Thương Việt Nam-Chi Nhánh 8-Thành Phố Hồ Chí Minh','1073 Phạm Thế Hiển Phường 05 Quận 08 Thành Phố Hồ Chí Minh','1073 Phạm Thế Hiển Phường 05 Quận 08 Thành Phố Hồ Chí Minh','BTA','008','2HCMC03A1028',3);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0305247442','0305247442','Công Ty Trách Nhiệm Hữu Hạn Phát Triển Công Nghệ Một Chín Ba','204/1 Nơ Trang Long P.12 Q.Bình Thạnh TPHCM','321 Tây Thạnh Phường Tây Thạnh Quận Tân Phú Thành Phố Hồ Chí Minh','TBI','TPH',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'5900324567','5900324567','Công Ty TNHH Dịch Vụ Và Thương Mại Vĩnh Thạnh','83 Đinh Tiên Hoàng P.Diên Hồng TP Pleiku Gia Lai','83 Đinh Tiên Hoàng P.Diên Hồng TP Pleiku Gia Lai****Quẹt Thẻ ATM','PLE','PLE',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100111948067','0100111948-067','Ngân Hàng Thương Mại Cổ Phần Công Thương Việt Nam - Chi Nhánh Hoàn Kiếm','37 Hàng Bồ  P.Hàng Bồ Q.Hoàn Kiếm Hà Nội','37 Hàng Bồ P.Hàng Bồ Q.Hoàn Kiếm Hà Nội','HDO','HKI','1HNOC05A1037',5);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0105184040','0105184040','Công Ty Trách Nhiệm Hữu Hạn Đầu Tư Và Thương Mại Vitaco Việt Nam','Tổ Cụm Dân Cư Nội Thương Xã Dương Xá H.Gia Lâm Hà Nội','Anh Lê Văn Thắng Tổ Khu 2 T.Trấn Kỳ Sơn H.Kỳ Sơn Hòa Bình','HBI','KSO',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0106097665','0106097665','Công Ty Trách Nhiệm Hữu Hạn Thương Mại Dịch Vụ Huy Nhật','195 Ngõ 192 Lê Trọng Tấn P.Định Công Q.Hoàng Mai Hà Nội','195 Ngõ 192 Lê Trọng Tấn P.Định Công Q.Hoàng Mai Hà Nội','HMA','HMA',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'4101432606','4101432606','Công Ty TNHH Nhà Sạch Quang Minh','Tổ 15 KV3 Tổ 15 KV3 P.Ghềnh Ráng TP Qui Nhơn Bình Định','1/8/29 La Văn Tiến Tổ 15 KV3 P.Ghềnh Ráng TP Qui Nhơn Bình Định****Chùa Phước Điền-gần Trạm 10-983128009','QNH','QNH','3BDIC03A1003',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'4201604048','4201604048','Công Ty TNHH Nguyên Lê Bảo','30 Âu Cơ Phước Tân TP Nha Trang Khánh Hòa','30 Âu Cơ Phước Tân TP Nha Trang Khánh Hòa','NTR','NTR',NULL,4);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'khongcoso','Đài Truyền Thanh','T.Trấn Quế H.Kim Bảng Hà Nam','T.Trấn Thiện Khê H.Thanh Liêm Hà Nam','TLI','TLI',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0304729926','0304729926','Công Ty Trách Nhiệm Hữu Hạn Ứng Dụng Bản Đồ Việt','160 Trần Bình Trọng Phường 03 Quận 05 Thành Phố Hồ Chí Minh','108 Tây Thạnh Phường Tây Thạnh Quận Tân Phú Thành Phố Hồ Chí Minh','GVA','TPH',NULL,60);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'6001385522','6001385522','Doanh Nghiệp Tư Nhân Vàng Bạc Kim Ngọc Hòa','47 Điện Biên Phủ P.Thống Nhất TP Buôn Mê Thuột ĐắkLắk','47 Điện Biên Phủ P.Thống Nhất TP Buôn Mê Thuột ĐắkLắk','BMT','BMT',NULL,5);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100150619065','0100150619-065','Ngân Hàng Thương Mại Cổ Phần Đầu Tư Và Phát Triển Việt Nam - Chi Nhánh Hà Nội','4 Lê Thánh  Tông P.Phan Chu Trinh Q.Hoàn Kiếm Hà Nội','4 Lê Thánh Tông P.Phan Chu Trinh Q.Hoàn Kiếm Hà Nội','CGI','HKI','1HNOC05A1040',10);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0305503086','411030000026','Công Ty Cổ Phần Quản Lý Và Phát Triển Bất Động Sản Lâm Campbell Shillinglaw','Số 52-54 Đường 9A Khu Dân Cư Trung Sơn Xã Bình Hưng Huyện Bình Chánh Thành Phố Hồ Chí Minh','Số 52-54 Đường 9A Khu Dân Cư Trung Sơn Xã Bình Hưng Huyện Bình Chánh Thành Phố Hồ Chí Minh','008','BCH',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0700707820','0700707820','Công Ty TNHH Xuất Nhập Khẩu Thịnh Hùng','Lê Lợi Xã Minh Khai TP.Phủ Lý Hà Nam','(cúc) Lê Lợi P.Trần Hưng Đạo TP.Phủ Lý Hà Nam','PLY','PLY',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0104867975','0104867975','Công Ty Cổ Phần Công Nghệ Điện Tử Và Viễn Thông Việt Nam','Lô 8 Dãy B, Số Nhà 29, Khu Đô Thị Mới Định Công  P.Định Công Q.Hoàng Mai Hà Nội','Lô 8 Dãy B, Số Nhà 29, Khu Đô Thị Mới Định Công P.Định Công Q.Hoàng Mai Hà Nội','DDA','HMA','1HNOC00A1237',38);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'4400861995','4400861995','Công Ty TNHH Phát Mỹ Hưng','30 Cao Thắng P.01 TP.Tuy Hòa Phú Yên','30 Cao Thắng P.01 TP.Tuy Hòa Phú Yên','THA','THA','3PYEC02A1002',13);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'1601300017','1601300017','Công Ty TNHH Đoàn Hòa Phát','363/31C Trần Hưng Đạo P.Mỹ Phước TP Long Xuyên An Giang','363/31C Trần Hưng Đạo P.Mỹ Phước TP Long Xuyên An Giang','CTH','LXU','4AGIC01A1028',16);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'1801116600','1801116600','Công Ty Cổ Phần Cấp Nươc Cần Thơ 2','366c Cách Mạng Tháng Tám P.Bùi Hữu Nghĩa Q.Bình Thủy TP Cần Thơ','366C Cách Mạng Tháng Tám P.Bùi Hữu Nghĩa Q.Bình Thủy TP Cần Thơ','NKI','BTH',NULL,9);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0401530639','0401530639','Công Ty TNHH MTV Phúc Tuấn Đà Nẵng','Lô 1 A Tống Duy Tân P.Hòa Minh Q.Liên Chiểu Đà Nẵng','53 Nguyễn Quyền P.Hòa An Q.Cẩm Lệ Đà Nẵng','LCH','CLE',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0800388342','0800388342',' Công Ty Cổ Phần V.I.P Việt Nam','Số 919 Lê Thanh Nghị P.Hải Tân Thành phố Hải Dương Hải Dương','342 (Thế Giới TrẻThơ-Phòng 305-tầng3)  Nguyễn Lương Bằng P.Thanh Bình Thành phố Hải Dương Hải Dương','HDU','HDU','5HDUC07A0001',3);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100112437','0100112437_137','Ngân Hàng Thương Mại Cổ Phần Ngoại Thương Việt Nam-chi Nhánh Nam Định','Số 198 Đường Trần Quang Khải P.Lý Thái Tổ Q.Hoàn Kiếm Hà Nội','Số 91 Đường Quang Trung P.Quang Trung TP Nam Định Nam Định','NDI','NDI',NULL,7);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0101425270','0101425270','Công Ty Cổ Phần Môi Giới Bảo Hiểm Á Đông','36 Nghi Tàm P.Yên Phụ Q.Tây Hồ Hà Nội','36 Nghi Tàm P.Yên Phụ Q.Tây Hồ Hà Nội','THO','THO','1HNOC01A1019',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'1800003663','54A8003663','Phạm Thị Cẩm Nhung','72/3 Phó Cơ Điều P.03 TP Vĩnh Long Vĩnh Long','31 Ấp Phước An Xã An Phước H.Mang Thít Vĩnh Long','VLO','MTH',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0102354569','0102354569','Công Ty Trách Nhiệm Hữu Hạn Phúc Hưng Thịnh','Tầng 19 TN Pacific Place Số 83B Lý Thường Kiêt  P.Trần Hưng Đạo Q.Hoàn Kiếm Hà Nội','Tầng 14 TN Pacific Place Số 83B Lý Thường Kiệt P.Trần Hưng Đạo Q.Hoàn Kiếm Hà Nội','CGI','HKI',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2300835282','2300835282','CÔNG TY CỔ PHẦN VẬN TẢI VÀ DỊCH VỤ CÔNG CỘNG BẮC NINH','34 Nguyễn Gia Thiều P.Suối Hoa TP Bắc Ninh Bắc Ninh','34 Nguyễn Gia Thiều P.Suối Hoa TP Bắc Ninh Bắc Ninh','BNI','BNI','5BNIC08A1008',16);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100112437099','0100112437-099','Ngân Hàng Thương Mại Cổ Phần Ngoại Thương Việt Nam - Chi Nhánh Trung Đô','Số 9 Nguyễn Sỹ Sách P.Hà Huy Tập Vinh Nghệ An','Số 9 Nguyễn Sỹ Sách P.Hà Huy Tập Vinh Nghệ An','VIN','VIN','1NANC00A1331',6);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0300648218','411033000002','Công Ty Cổ Phần Đầu Tư Times Square Việt Nam','22-36 Nguyễn Huệ Và Số 57-69F Đồng Khởi Phường Bến Nghé Quận 01 Thành Phố Hồ Chí Minh','Số 8 Lầu 11 Nguyễn Huệ Phường Bến Nghé Quận 01 Thành Phố Hồ Chí Minh','010','001','2HCMC01A1004',2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0400625736','0400625736','Công Ty TNHH Thương Mại Và Dịch Vụ P.A.P','Lô 16B1.14 Phạm Thế Hiển P.Khuê Trung Q.Cẩm Lệ Đà Nẵng','66 Võ Văn Tần P.Chính Gián Q.Thanh Khê Đà Nẵng','TKH','TKH','3DNAC14A1001',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'000106370145','0106370145','Công Ty Cổ Phần Thương Mại Xuất Nhập Khẩu Đại Thăng','2 Ngách 298/33/15 Đường Ngọc Hồi Thôn Yên Ngưu Xã Tam Hiệp H.Thanh Trì Hà Nội','9 Tây Kết P.Bạch Đằng Q.Hai Bà Trưng Hà Nội','HMA','HBT',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0105281809','0105281809','Công Ty Trách Nhiệm Hữu Hạn Đầu Tư Công Nghệ Số Việt Nam','47 Kim Đồng P.Giáp Bát Q.Hoàng Mai Hà Nội','N03 A Chung Cư K26 Đường Dương Quảng Hàm Phường 03 Quận Gò Vấp Thành Phố Hồ Chí Minh','GVA','GVA','2HCMC00A1076',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100150619046','0100150619-046','Ngân Hàng Thương Mại Cổ Phần Đầu Tư Và Phát Triển Việt Nam - Chi Nhánh Kiên Giang','259-261 Trần Phú P.Vĩnh Thanh Vân TP Rạch Giá Kiên Giang','259-261 Trần Phú P.Vĩnh Thanh Vân TP Rạch Giá Kiên Giang','RGI','RGI',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'5701552618','5701552618','Công Ty TNHH Hương Hải Hạ Long','Tổ 2 Khu 2 Khu Vườn Đào P.Bãi Cháy TP Hạ Long Quảng Ninh','Số 713( Phạm Hoàn) Đường Trần Phú P.Cẩm Thủy TP Cẩm Phả Quảng Ninh','CPH','CPH','5QNIC03A0001',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0200784873','0200784873','Công Ty Cổ Phần Thiết Bị Điện - Điện Tử Bách Khoa','125 Lô 6 Nguyễn Bỉnh Khiêm P.Đằng Giang Q.Ngô Quyền Hải Phòng','125 Lô 6 Nguyễn Bỉnh Khiêm P.Đằng Giang Q.Ngô Quyền Hải Phòng','NQU','NQU','5HPHC01A1048',50);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0105878560004','0105878560-004','Chi Nhánh Tại Thành Phố Hồ Chí Minh-Công Ty Cổ Phần Dịch Vụ Và Thương Mại HDT Việt Nam','126H Phan Đăng Lưu Phường 03 Quận Phú Nhuận Thành Phố Hồ Chí Minh','203 Lạc Long Quân Phường 13 Quận 11 Thành Phố Hồ Chí Minh','005','011','2HCMC00A1090',49);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'5700883712','5700883712','Công Ty TNHH Hai Thành Viên Thương Mại - Dịch Vụ Và XNK Tổng Hợp Trường Phúc','Số 47 Tổ 4 Khu 2B P.Cẩm Trung TP Cẩm Phả Quảng Ninh','( Ngô Ngọc Thái -101246272) Số 17 Tổ 4 Khu Minh Thái P.Cẩm Tây TP Cẩm Phả Quảng Ninh','CPH','CPH','5QNIC03A1002',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'1300485412','55D8000295','HKD_Thanh Phong','Số 207 Ấp Tân Thuận Trong Xã Tân Phú Tây H.Mỏ Cày Bắc Bến Tre','Số 207 Ấp Tân Thuận Trong Xã Tân Phú Tây H.Mỏ Cày Bắc Bến Tre','BTR','MCB',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'3701485291','3701485291','Công Ty TNHH Tư Vấn Xây Dựng Nam Việt Hưng','Khu Phố 2 T.Trấn Dầu Tiếng H.Dầu Tiếng Bình Dương','Khu Phố 2 T.Trấn Dầu Tiếng H.Dầu Tiếng Bình Dương****Khu Phố 4B - Gần Đường Sân Bay_Hoàng Cao Thảo','TDM','DTI','6BDUC02A1031',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0403000279','0403000279','Công Ty Cổ Phần Hưng Hải','9 Lê Hồng Phong P.Nguyễn Trãi Thành phố Hải Dương Hải Dương','(0903217219) 09 Lê Hồng Phong P.Nguyễn Trãi Thành phố Hải Dương Hải Dương','HDU','HDU',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100111948079','0100111948079','Ngân Hàng Thương Mại Cổ Phần Công Thương Việt Nam - Chi Nhánh Quảng Bình','50 Lý Thường Kiệt phường Đồng Phú TP Đồng Hới Quảng Bình','50 Lý Thường Kiệt phường Đồng Phú TP Đồng Hới Quảng Bình','DHO','DHO','3QBIC09A1001',3);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0105878560004','0105878560-004','Chi Nhánh Tại Thành Phố Hồ Chí Minh-Công Ty Cổ Phần Dịch Vụ Và Thương Mại HDT Việt Nam','126H Phan Đăng Lưu Phường 03 Quận Phú Nhuận Thành Phố Hồ Chí Minh','203 Phan Đăng Lưu Phường 13 Quận 11 Thành Phố Hồ Chí Minh','003','011','2HCMC00A1090',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'5000271619','1502000322','Công Ty Trách Nhiệm Hữu Hạn Huy Hà','Tổ Xóm Cây Thị Xã Đạo Viện H.Yên Sơn Tuyên Quang','Tổ Xóm Cây Thị Xã Đạo Viện H.Yên Sơn Tuyên Quang','TQU','YSO',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2500302838','19F8003569','Hộ Kinh Doanh Nguyễn Thị Luyến','Xã Tam Hồng H.Yên Lạc Vĩnh Phúc','( Nguyễn Văn Chung) xã Đồng Cương H.Yên Lạc Vĩnh Phúc','YLA','YLA',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0104507429','0104507429','Công Ty Cổ Phần Phát Hành Báo Chí Và Truyền Thông Việt Nam','Số 76 Tập Thể Giaó Dục - Đồng Xa P.Mai Dịch Q.Cầu Giấy Hà Nội','73 Nguyễn Lương Bằng P.Nam Đồng Q.Đống Đa Hà Nội','NTL','DDA',NULL,5);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'1201415398','1201415398','Công Ty Trách Nhiệm Hữu Hạn Một Thành Viên Hưng Trường Thịnh','102B Bis Nguyễn Văn Giác P.03 TP Mỹ Tho Tiền Giang','102B Bis Nguyễn Văn Giác P.03 TP Mỹ Tho Tiền Giang','MTH','MTH',NULL,10);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0102306702001','0102306702-001','Chi Nhánh Công Ty Trách Nhiệm Hữu Hạn Phát Triển Công Nghệ Điện Tử Bình Anh','272/5B Đinh Bộ Lĩnh Phường 26 Quận Bình Thạnh Thành Phố Hồ Chí Minh','108 Tây Thạnh Phường Tây Thạnh Quận Tân Phú Thành Phố Hồ Chí Minh','TBI','TPH','2HCMC06A1047',169);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2901057703','2901057703','Công Ty TNHH Một Thành Viên Tuấn Hường','Xã Vinh Tân Vinh Nghệ An','(Anh Cường-0904450777) Tổ 5 Xã Nghi Văn H.Nghi Lộc Nghệ An','NLO','NLO',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'1600662127','1600662127','Công Ty TNHH Mai Hưng','61-63 Lê Minh Ngươn P.Mỹ Long TP Long Xuyên An Giang','61-63 Lê Minh Ngươn P.Mỹ Long TP Long Xuyên An Giang','LXU','LXU',NULL,4);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100113769001','4112000098','Chi Nhánh Công Ty Trách Nhiệm Hữu Hạn Vận Tải Hỗn Hợp Việt Nhật Số 1 Tại TPHCM','36 Bùi Thị Xuân Phường Bến Thành Quận 01 Thành Phố Hồ Chí Minh','23 Trần Não Phường Bình An Quận 02 Thành Phố Hồ Chí Minh','002','002',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0401584810','0401584810','Công Ty TNHH Giải Pháp Công Nghệ Thông Minh Smart Tech','23 Hàn Mậc Tử P.Thuận Phước Q.Hải Châu Đà Nẵng','23 Hàn Mặc Tử P.Thuận Phước Q.Hải Châu Đà Nẵng****Sim Định Vị','TKH','HCH',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'3602168686','3602168686','Công Ty Trách Nhiệm Hữu Hạn Tài Tiến','F228 Võ Thị Sáu P.Thống Nhất TP Biên Hòa Đồng Nai','F228 Võ Thị Sáu P.Thống Nhất TP Biên Hòa Đồng Nai','LTH','BHO',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'54E80002508','Thảo Phương','Số 36/6 Phạm Thái Bường P.04 TP Vĩnh Long Vĩnh Long','36/6 Phạm Thái Bường P.04 TP Vĩnh Long Vĩnh Long','VLO','VLO',NULL,5);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0312456373','0312456373','Công Ty Trách Nhiệm Hữu Hạn Đầu Tư Phát Triển Gia Lâm','115/45 Lê Đức Thọ Phường 17 Quận Gò Vấp Thành Phố Hồ Chí Minh','270A Lý Thường Kiệt Phường 14 Quận 10 Thành Phố Hồ Chí Minh','010','010',NULL,33);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0104755076','0104755076','Công Ty Cổ Phần Dịch Vụ Viễn Thông NTC','Số 1, Ngõ 178 Đường Giải Phóng P.Phương Liệt Q.Thanh Xuân Hà Nội','Số 1 Ngõ 178 Giải Phóng P.Phương Liệt Q.Thanh Xuân Hà Nội','TXU','TXU','1HNOC05A0002',4);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0312635982','0312635982','Công Ty Trách Nhiệm Hữu Hạn Công Nghệ Kiến Việt','296 Cô Bắc Phường Cô Giang Quận 01 Thành Phố Hồ Chí Minh','296 Cô Bắc Phường Cô Giang Quận 01 Thành Phố Hồ Chí Minh','001','001','DUONGNTT',4);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0102910110','011022000171','Công Ty Trách Nhiệm Hữu Hạn Hanaro TNS Việt Nam','P3 Tầng M Tòa Nhà TTC Lô B1A Cụm Sản Xuất Tiểu Thủ CN Và CN Nhỏ Duy Tân P.Dịch Vọng Hậu Q.Cầu Giấy Hà Nội','P.Dịch Vọng Hậu Q.Cầu Giấy Hà Nội','CGI','CGI','1HNOC00A1043',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'4100554552','4100554552','Công Ty TNHH TM & DV Bình Minh','328 Lê Hồng Phong P.Lê Hồng Phong TP Qui Nhơn Bình Định','328 Lê Hồng Phong P.Lê Hồng Phong TP Qui Nhơn Bình Định****Lê Ngọc Quý','QNH','QNH','3BDIC03A1003',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0312399608','0312399608','Công Ty Trách Nhiệm Hữu Hạn Thương Mại Dịch Vụ Viễn Thông Nhất Thành Phát','140/2 Nguyễn Ảnh Thủ Ấp Trung Chánh 2 Xã Trung Chánh Huyện Hóc Môn Thành Phố Hồ Chí Minh','140/2 Nguyễn Ảnh Thủ Ấp Trung Chánh 2 Xã Trung Chánh Huyện Hóc Môn Thành Phố Hồ Chí Minh','HMO','HMO',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'nbi_tdi_bson','Trung Tâm Văn Hóa Thông Tin Thể Thao Thị Xã Tam Điệp','Tổ 10 P.Bắc Sơn T/X Tam Điệp Ninh Bình','Tổ 10 P.Bắc Sơn T/X Tam Điệp Ninh Bình****Chị Đoan 0905376777','TDI','TDI',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'5700883712','5700883712','Công Ty TNHH Hai Thành Viên Thương Mại - Dịch Vụ Và XNK Tổng Hợp Trường Phúc','Số 47 Tổ 4 Khu 2B P.Cẩm Trung TP Cẩm Phả Quảng Ninh','Số 47( Vũ Quang Tùng) Tổ 4 Khu 2B P.Cẩm Trung TP Cẩm Phả Quảng Ninh','CPH','CPH','5QNIC03A1002',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0304598430','304598430','Công Ty Trách Nhiệm Hữu Hạn Thương Mại Dịch Vụ Quốc Tế An Lộc Phát','Tầng 5 Số 209 Hoàng Văn Thụ Phường 08 Quận Phú Nhuận Thành Phố Hồ Chí Minh','209 Lầu 5 Hoàng Văn Thụ Phường 08 Quận Phú Nhuận Thành Phố Hồ Chí Minh','010','PNH',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100112437003','0100112437003','NGÂN HÀNG THƯƠNG MẠI CỔ PHẦN NGOẠI THƯƠNG VIỆT NAM - CHI NHÁNH ĐÀ NẴNG','140-142 Lê Lợi P.Hải Châu 1 Q.Hải Châu Đà Nẵng','140-142 Lê Lợi P.Hải Châu 1 Q.Hải Châu Đà Nẵng','TKH','HCH','3DNAC05A1007',9);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0102306702001','0102306702-001','Chi Nhánh Công Ty Trách Nhiệm Hữu Hạn Phát Triển Công Nghệ Điện Tử Bình Anh','272/5B Đinh Bộ Lĩnh Phường 26 Quận Bình Thạnh Thành Phố Hồ Chí Minh','108 Tây Thạnh Phường Tây Thạnh Quận Tân Phú Thành Phố Hồ Chí Minh','BTH','TPH','2HCMC06A1047',298);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'5700883712','5700883712','Công Ty TNHH Hai Thành Viên Thương Mại - Dịch Vụ Và XNK Tổng Hợp Trường Phúc','Số 47 Tổ 4 Khu 2B P.Cẩm Trung TP Cẩm Phả Quảng Ninh','Số 47 Tổ 4 Khu 2B P.Cẩm Trung TP Cẩm Phả Quảng Ninh','CPH','CPH','5QNIC03A1002',3);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'4201581055','4201581055','Công Ty TNHH AT&T Khánh Hòa','35 Đường B6 Vĩnh Điềm Trung P.Vĩnh Hiệp TP Nha Trang Khánh Hòa','35 B6 Vĩnh Điềm Trung P.Vĩnh Hiệp TP Nha Trang Khánh Hòa','NTR','NTR',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0400443969','3202000912','Công Ty TNHH Bảo Khánh','65-67 Cao Thắng P.Thanh Bình Q.Hải Châu Đà Nẵng','65-67 Cao Thắng P.Thanh Bình Q.Hải Châu Đà Nẵng','HCH','HCH','3DNAC05A1004',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'4202000592','4202000592','Công Ty Trách Nhiệm Hữu Hạn Hồng Quảng','31 Phạm Phú Thứ P.B''Lao T/X Bảo Lộc Lâm Đồng','31 Phạm Phú Thứ P.B''Lao T/X Bảo Lộc Lâm Đồng','BLO','BLO',NULL,6);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'3901154378','3901154378','Doanh Nghiệp Tư Nhân Thương Mại - Dịch Vụ - Du Lịch Hiếu Thanh Thảo','270A Phạm Hùng Ấp Long Thới Xã Long Thành Trung H.Hòa Thành Tây Ninh','270A Phạm Hùng Ấp Long Thới Xã Long Thành Trung H.Hòa Thành Tây Ninh','TNI','HTH',NULL,15);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100111948058','0100111948-058','Ngân Hàng Thương Mại Cổ Phần Công Thương Việt Nam-Chi Nhánh 9-TPHCM','01 Nguyễn Oanh Phường 10 Quận Gò Vấp Thành Phố Hồ Chí Minh','01 Nguyễn Oanh Phường 10 Quận Gò Vấp Thành Phố Hồ Chí Minh','GVA','GVA','2HCMC06A1232',20);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'6000504199','6000504199','Công Ty TNHH Xây Dựng Phương Nam','Tổ Thôn 3 Xã Nhân Cơ H.Đắc R''Lấp Đắc Nông','(Mỏ Khai Thác Đá Đăk Wer) Tổ Thôn 13 Đăk Wer H.Đắc R''Lấp Đắc Nông****GĐ Bùi Văn Thuận - 0947537966 - 0905437966','GNG','DRL',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0312385147','0312385147','Công Ty TNHH Một Thành Viên Thương Mại Và Phân Phối Nhân Trí Networks','50 Tây Hòa Phường Phước Long A Quận 09 Thành Phố Hồ Chí Minh','458 Nguyễn Tất Thành Phường 18 Quận 04 Thành Phố Hồ Chí Minh','005','004',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0311793030','0311793030','Công Ty Trách Nhiệm Hữu Hạn Thương Mại Dịch Vụ Viễn Thông Tân Đức','14/4 Phan Văn Hớn Ấp Tiền Lân Xã Bà Điểm Huyện Hóc Môn Thành Phố Hồ Chí Minh','14/4 Phan Văn Hớn Ấp Tiền Lân Xã Bà Điểm Huyện Hóc Môn Thành Phố Hồ Chí Minh','HMO','HMO',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'3700594361','3700594361','Công Ty Cổ Phần Thương Mại Thành Thành Công','Số 7 Đại Lộ Độc Lập Lô D KCN Sóng Thần 1 P.Dĩ An T/X Dĩ An Bình Dương','62 Trần Huy Liệu Phường 12 Quận Phú Nhuận Thành Phố Hồ Chí Minh','PNH','PNH','2HCMC01A1000',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100230800','0100230800','Ngân Hàng Thương Mại Cổ Phần Kỹ Thương Việt Nam(Hoàng Thị Thúy Hậu 02-5002)','191 Bà Triệu P.Lê Đại Hành Q.Hai Bà Trưng Hà Nội','191 Bà Triệu P.Lê Đại Hành Q.Hai Bà Trưng Hà Nội','HMA','HBT',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0901000101','NBI_YKH_TBVTV','Trạm Bảo Vệ Thực Vật Huyện Yên Khánh','T.Trấn Thiên Tôn H.Hoa Lư Ninh Bình','Phố Hưng Phúc P.Ninh Khánh T/X Ninh Bình Ninh Bình','NBI','NBI',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'3900334402','3900334402','Công Ty Trách Nhiệm Hữu Hạn Phú Quý','065 Pasteur KP3 P.02 TP Tây Ninh Tây Ninh','10/1 Đường 30/4 KP1 P.01 TP Tây Ninh Tây Ninh','TNI','TNI',NULL,98);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'02A8006546/HKD','Hộ Kinh Doanh Nguyễn Thị Kim Phương','1133 Đại Lộ Tôn Đức Thắng P.Sở Dầu Q.Hồng Bàng Hải Phòng','1133 Đại Lộ Tôn Đức Thắng P.Sở Dầu Q.Hồng Bàng Hải Phòng','NQU','HBA','5HPHC01A1048',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0901000101','0901000101','Doanh Nghiệp Tư Nhân Phan Bình','92 Nguyễn Văn Giản P.Đông Thành T/X Ninh Bình Ninh Bình','92 Nguyễn Văn Giản P.Đông Thành T/X Ninh Bình Ninh Bình','NBI','NBI',NULL,4);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'8016734811','27L8000001506','Hộ Kinh Doanh Cá Thể Nguyễn Tuấn Anh','T.Trấn Yên Thành H.Yên Thành Nghệ An','Khối 1 T.Trấn Yên Thành H.Yên Thành Nghệ An','YTH','YTH',NULL,3);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'nbi_tdi_bson','Trung Tâm Văn Hóa Thông Tin Thể Thao Thị Xã Tam Điệp','Tổ 10 P.Bắc Sơn T/X Tam Điệp Ninh Bình','Tổ 10 P.Bắc Sơn T/X Tam Điệp Ninh Bình','TDI','TDI',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2900747623','2701001278','Doanh Nghiệp Tư Nhân Tiến Hoàng','Xã Nghĩa Xuân H.Quỳ Hợp Nghệ An','(Anh Hùng - 0904687799) Số 17 Hải Thượng Lãn Ông P.Hà Huy Tập Vinh Nghệ An','VIN','VIN','1NANC00A1331',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0104962121','0104962121','Công Ty Cổ Phần Vcomsat','Tầng 4-Số 349 Hoàng Quốc Việt P.Nghĩa Tân Q.Cầu Giấy Hà Nội','Tầng 4-Số 349 Hoàng Quốc Việt P.Nghĩa Tân Q.Cầu Giấy Hà Nội','DDA','CGI',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0312515540','41-003917','Văn Phòng Đại Diện Allergan Singapore Pte. Ltd. Tại Thành Phố Hồ Chí Minh','Căn Phòng Số 2004-07 Lầu 20 Số 37 Tôn Đức Thắng Phường Bến Nghé Quận 01 Thành Phố Hồ Chí Minh','Phòng 2109-2111 Lầu 21 Toà Nhà Saigon Trade Center 37 Tôn Đức Thắng Phường Bến Nghé Quận 01 Thành Phố Hồ Chí Minh','010','001','2HCMC01A1192',25);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0105878560004','0105878560-004','Chi Nhánh Tại Thành Phố Hồ Chí Minh-Công Ty Cổ Phần Dịch Vụ Và Thương Mại HDT Việt Nam','126H Phan Đăng Lưu Phường 03 Quận Phú Nhuận Thành Phố Hồ Chí Minh','203 Lạc Long Quân Phường 13 Quận 11 Thành Phố Hồ Chí Minh','010','011','2HCMC00A1090',149);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0311995622','0311995622','Công Ty Trách Nhiệm Hữu Hạn Thương Mại Dịch Vụ Vận Tải Hải Biên','106C Đường 138 Phường Tân Phú Quận 09 Thành Phố Hồ Chí Minh','106C Đường 138 Phường Tân Phú Quận 09 Thành Phố Hồ Chí Minh','TDU','009','2HCMC02A1058',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0200253985','0200253985','Ngân Hàng Thương Mại Cổ Phần Đông Nam Á(Ms.Lê Thu Thủy-Phó Tổng Giám Đốc)','25 Trần Hưng Đạo P.Phan Chu Trinh Q.Hoàn Kiếm Hà Nội','25 Trần Hưng Đạo P.Phan Chu Trinh Q.Hoàn Kiếm Hà Nội','HMA','HKI','1HNOC05A1038',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'NAN_TKY_CAX_NHOAN','Công An Xã NGHĨA HOÀN','T.Trấn Tân Kỳ H.Tân Kỳ Nghệ An','Anh Linh Quân Sự 985114992 Tổ . Xã Nghĩa Hoàn H.Tân Kỳ Nghệ An','TKY','TKY',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'8325070734','39a8003322','Hộ Kinh Doanh Nguyễn Đỗ Ngọc Tuyền','13 Đoàn Thị Điểm P.Diên Hồng TP Pleiku Gia Lai','13 Đoàn Thị Điểm P.Diên Hồng TP Pleiku Gia Lai****0935789678','PLE','PLE',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'6300237096','64A8004217','Hộ Kinh Doanh Kim Thắm','Xã Vĩnh Lộc H.Hồng Dân Bạc Liêu','Số 13 Trần Ngọc Quế P.01 TP Vị Thanh Hậu Giang','VTA','VTA',NULL,3);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0106370145','0106370145         ','Công Ty Cổ Phần Thương Mại Xuất Nhập Khẩu Đại Thăng','2 Ngách 298/33/15 Đường Ngọc Hồi Thôn Yên Ngưu Xã Tam Hiệp H.Thanh Trì Hà Nội','9 Tây Kết P.Bạch Đằng Q.Hai Bà Trưng Hà Nội','HMA','HBT',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2900534791','nan_nlo_nlon_ubnd','Đảng Ủy Xã Nghi Long','Xã Nghi Long H.Nghi Lộc Nghệ An','0932350999 Xã Nghi Hoa H.Nghi Lộc Nghệ An','NLO','NLO','1NANC00A1147',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100150619006','0100150619-006','Ngân Hàng Thương Mại Cổ Phần Đầu Tư Và Phát Triển Việt Nam Chi Nhánh Bà Rịa Vũng Tàu','24 Trần Hưng Đạo P.01 TP Vũng Tàu Bà Rịa - Vũng Tàu','24 Trần Hưng Đạo P.01 TP Vũng Tàu Bà Rịa - Vũng Tàu','VTA','VTA','6BRVC01A1009',5);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2802111741','2802111741','Công Ty T.N.H.H Dịch Vụ Và Thương Mại TND','Thôn Tân Cộng Xã Đông Tân H. Đông Sơn Thanh Hóa','Thôn Tân Cộng Xã Đông Tân H. Đông Sơn Thanh Hóa','THO','DSO','1THOC00A1122',20);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0104755076','0104755076','Công Ty Cổ Phần Dịch Vụ Viễn Thông NTC','Số 1, Ngõ 178 Đường Giải Phóng P.Phương Liệt Q.Thanh Xuân Hà Nội','Số 1 Ngõ 178 Giải Phóng P.Phương Liệt Q.Thanh Xuân Hà Nội','TXU','TXU',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0312064591','0312064591','Công Ty Trách Nhiệm Hữu Hạn Thương Mại Sản Xuất Sơn Long','59 Đường 11 KP.4 Phường Linh Xuân Quận Thủ Đức Thành Phố Hồ Chí Minh','42 Đường 20 KP.3 Phường Linh Chiểu Quận Thủ Đức Thành Phố Hồ Chí Minh','002','TDU',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0312132026','0312132026','Công Ty Trách Nhiệm Hữu Hạn Thương Mại Dịch Vụ Viễn Thông Thảo Anh','43 Đường Số 3 Khu Phố 3 Phường Cát Lái Quận 02 Thành Phố Hồ Chí Minh','43 Đường Số 3 Khu Phố 3 Phường Cát Lái Quận 02 Thành Phố Hồ Chí Minh','009','002',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0312680382','0312680382','Công Ty Cổ Phần ATG','Số 3 Đường 152A Cao Lỗ Phường 04 Quận 08 Thành Phố Hồ Chí Minh','207/19C Trần Bình Trọng Phường 03 Quận 05 Thành Phố Hồ Chí Minh','005','005',NULL,38);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100106264','0100106264-058','Công Ty TNHH Một Thành Viên Vận Tải Đường Sắt Hà Nội-Chi Nhánh Vận Tải Đường Sắt Hải Phòng','Số 75 Lương Khánh Thiện P.Lương Khánh Thiện Q.Ngô Quyền Hải Phòng','Số 75 Lương Khánh Thiện P.Lương Khánh Thiện Q.Ngô Quyền Hải Phòng','HBA','NQU',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'54B8001778','Thanh Bình','107A/06 Ấp Sơn Đông Xã Thanh Đức H.Long Hồ Vĩnh Long','336 Ấp Thuận Tiến Xã Nguyễn Văn Thảnh H.Bình Tân Vĩnh Long','VLO','BTA',NULL,6);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0300942001026','0300942001026','Công Ty Điện Lực Bà Rịa Vũng Tàu','Trung Tâm Hành Chính Huyện Tân Thành T.Trấn Phú Mỹ H.Tân Thành Bà Rịa - Vũng Tàu','Khu Trung Tâm Hành Chính Huyện Tân Thành Thôn Vạn Hạnh T.Trấn Phú Mỹ H.Tân Thành Bà Rịa - Vũng Tàu****Điện Lực Tân Thành','VTA','TTH',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100230800','0100230800','Ngân Hàng Thương Mại Cổ Phần Kỹ Thương Việt Nam(Trần Thị Phương 02-5110)','191 Bà Triệu P.Lê Đại Hành Q.Hai Bà Trưng Hà Nội','191 Bà Triệu P.Lê Đại Hành Q.Hai Bà Trưng Hà Nội','HMA','HBT',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100112437011','0100112437-011','Ngân Hàng Thương Mại Cổ Phần Ngoại Thương Việt Nam - Chi Nhánh Vinh','Số 21 Quang Trung P.Quang Trung Vinh Nghệ An','Số 21 Quang Trung P.Quang Trung Vinh Nghệ An','VIN','VIN','1NANC00A1003',10);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'4200935978','4200935978','Công Ty TNHH Dịch Vụ Quảng Cáo Và Truyền Thông Nghinh Phong','2B Nguyễn Trung Trực Tân Lập TP Nha Trang Khánh Hòa','2B Nguyễn Trung Trực Tân Lập TP Nha Trang Khánh Hòa','NTR','NTR',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100111948006','0100111948006','Ngân Hàng Thương Mại Cổ Phần Công Thương Việt Nam-chi Nhánh Hưng Yên','Số 1 Điện Biên I P.Lê Lợi T/X Hưng Yên Hưng Yên','Số 1 Điện Biên I P.Lê Lợi T/X Hưng Yên Hưng Yên****Anh Hiểu - Phòng Vi Tính','HYE','HYE','5HYEC06A0001',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'3600450091','472043000531','Công Ty Trách Nhiệm Hữu Hạn Henkel Adhesive Technologies Việt Nam','7 Đường 9A KCN Biên Hòa 2 TP Biên Hòa Đồng Nai','7 Đường 9A KCN Biên Hòa 2 TP Biên Hòa Đồng Nai','BHO','BHO','6DNIC05A1033',2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100111948084','0100111948-084','Ngân Hàng Thương Mại Cổ Phần Công Thương Việt Nam - Chi Nhánh Sóc Trăng','139 Trần Hưng Đạo P.03 TP Sóc Trăng Sóc Trăng','139 Trần Hưng Đạo P.03 TP Sóc Trăng Sóc Trăng','STR','STR','4STRC09A1026',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0311872035','0311872035','Công Ty Trách Nhiệm Hữu Hạn Một Thành Viên Thiết Bị Viễn Thông Phú Thiên','416/8 Hòa Hảo Phường 05 Quận 10 Thành Phố Hồ Chí Minh','416/8 Hòa Hảo Phường 05 Quận 10 Thành Phố Hồ Chí Minh','010','010',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0102629277','0102629277','Công Ty TNHH Thương Mại Và Dịch Vụ Vinh Phát','41 Trần Cao Vân P.Phố Huế Q.Hai Bà Trưng Hà Nội','Bưu Điện Thanh Trì Xã Văn Điển H.Thanh Trì Hà Nội','TTR','TTR',NULL,3);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100150619127','0100150619127','Ngân Hàng TMCP Đầu Tư Và Phát Triển VN -CN NAM GIA LAI','117 Trần Phú P.Diên Hồng TP Pleiku Gia Lai','117 Trần Phú P.Diên Hồng TP Pleiku Gia Lai','PLE','PLE','3GLAC10A1002',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2300333116','2300333116','Công Ty Trách Nhiêm Hữu Hạn Thương Mại Dịch Vụ Và Sản Xuất Phi Kha Miền Bắc','TS7 KCN Xã Hòan Sơn H.Tiên Du Bắc Ninh','Tầng 10 Tháp A, Số 18 Phạm Hùng Phường Mỹ Đình 1 Quận Nam Từ Liêm Hà Nội','CGI','NTL','1HNOC01A1018',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0104646856','0104646856',' Công Ty Cổ Phần Truyền Thông Lạc Hồng','78 Trần Bình  P.Mai Dịch Q.Cầu Giấy Hà Nội','Tầng 5 Số 172 Lê Trọng Tấn P.Khương Mai Q.Thanh Xuân Hà Nội','HMA','TXU','1HNOC05A1023',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0201177818','0201177818','Công Ty TNHH Cơ Điện Bách Thắng','Đội 4B (nhà Ông Trần Xuân Cương) Xã Tân Dương H.Thủy Nguyên Hải Phòng','907 Tôn Đức Thắng P.Sở Dầu Q.Hồng Bàng Hải Phòng','NQU','HBA','5HPHC01A1048',20);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0311491167','0311491167','Công Ty Trách Nhiệm Hữu Hạn TTAS','39 Đô Đốc Chấn Phường Sơn Kỳ Quận Tân Phú Thành Phố Hồ Chí Minh','Lầu 2 Tòa Nhà 316 Lê Văn Sỹ Phường 01 Quận Tân Bình Thành Phố Hồ Chí Minh','BTA','TBI','2HCMC03A1145',51);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0801041907','0801041907','Công Ty Cổ Phần TM & DV Rồng Vàng','01 Bình Minh P.Phạm Ngũ Lão Thành phố Hải Dương Hải Dương','01 Bình Minh P.Phạm Ngũ Lão Thành phố Hải Dương Hải Dương','HDU','HDU','5HDUC07A0001',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0105954469','0105954469','Công Ty Trách Nhiệm Hữu Hạn Thương Mại Dịch Vụ Viễn Thông Hương Nguyễn','Dục Nội Xã Việt Hùng H.Đông Anh Hà Nội','Xóm Cời,trung Oai Xã Tiên Dương H.Đông Anh Hà Nội','DAN','DAN','1HNOC00A1237',4);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0310226744','0310226744','Công Ty Trách Nhiệm Hữu Hạn Lô Gi Stíc Pantos Việt Nam','Phòng 2510 Tầng 25 KĐT Mới Cầu Giấy Toà Nhà Keangnam 72 Tầng Phường Mễ Trì Quận Nam Từ Liêm Hà Nội','Phòng 2510 Tầng 25 KĐT Mới Cầu Giấy Toà Nhà Keangnam 72 Tầng Phường Mễ Trì Quận Nam Từ Liêm Hà Nội','CGI','NTL',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0302841094','0302841094','Công Ty Cổ Phần Hùng Vinh','61/9 Quang Trung Phường 10 Quận Gò Vấp Thành Phố Hồ Chí Minh','61/9 Quang Trung Phường 10 Quận Gò Vấp Thành Phố Hồ Chí Minh','TBI','GVA','2HCMC00A1087',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'32B8010363','Nguyễn Thị Nhất','100 Lý Thái Tổ Tổ 5 P.Thạc Gián Q.Thanh Khê Đà Nẵng','100 Lý Thái Tổ Tổ 5 P.Thạc Gián Q.Thanh Khê Đà Nẵng','TKH','TKH',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100111948126','0100111948126','Ngân Hàng Thương Mại Cổ Phần Công Thương Việt Nam - Chi Nhánh Quang Minh','Xã Quang Minh H.Mê Linh Hà Nội','Xã Quang Minh H.Mê Linh Hà Nội','MLI','MLI','1HNOC00A1208',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'1401352434','51F8003037','Hộ Kinh Doanh Lê Ngọc Dung','147 Ấp Tân An Xã Tân Huề H.Thanh Bình Đồng Tháp','32 Hùng Vương P. An Thạnh T/X Hồng Ngự Đồng Tháp****Đạt NV PTTT','THN','THN',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0106136089','0106136089','Công Ty Cổ Phần Kiến Trúc Xây Dựng Và Đầu Tư Newway Việt Nam','29/424 Trần Khát Chân P.Phố Huế Q.Hai Bà Trưng Hà Nội','29/424 Trần Khát Chân P.Phố Huế Q.Hai Bà Trưng Hà Nội****Thái 328 Phố Huế','HBT','HBT',NULL,20);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0106087716','0106087716','Công Ty TNHH Thương Mại Và Công Nghệ LINK Việt Nam','Số Nhà 22,hẻm 5,ngách 197/58,đường Hoàng Mai P.Hòang Văn Thụ Q.Hoàng Mai Hà Nội','Số Nhà 22,hẻm 5,ngách 197/58,đường Hoàng Mai P.Hòang Văn Thụ Q.Hoàng Mai Hà Nội','TTR','HMA',NULL,25);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0106087716','0106087716','Công Ty TNHH Thương Mại Và Công Nghệ LINK Việt Nam','Số Nhà 22,hẻm 5,ngách 197/58 Hoàng Mai P.Hòang Văn Thụ Q.Hoàng Mai Hà Nội','Số Nhà 22,hẻm 5,ngách 197/58 Hoàng Mai P.Hòang Văn Thụ Q.Hoàng Mai Hà Nội','TTR','HMA',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'2901057703','2901057703','Công Ty TNHH Một Thành Viên Tuấn Hường','Xã Vinh Tân Vinh Nghệ An','(Anh Chung-0904073456) Tổ 5 Xã Nghi Văn H.Nghi Lộc Nghệ An','NLO','NLO','1NANC00A1147',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0600449439','0600449439','Công Ty Cổ Phần Xây Dựng A.C.B','Số 663 Trần Thái Tông P.Lộc Vượng TP Nam Định Nam Định','Số 663 Trần Thái Tông P.Lộc Vượng TP Nam Định Nam Định****Phạm Mai Phương - Nhân Viên Văn Phòng','NDI','NDI',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0106571194','0106571194','Công Ty Cổ Phần Thương Mại Điểm Vàng SKL','62/255 Lý Chính Thắng Phường 03 Quận 08 Thành Phố Hồ Chí Minh','62/255 Lý Chính Thắng Phường 08 Quận 03 Thành Phố Hồ Chí Minh','CGI','003',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100230800','0100230800','Ngân Hàng Thương Mại Cổ Phần Kỹ Thương Việt Nam(Martin Hronek 01-7299)','191 Bà Triệu P.Lê Đại Hành Q.Hai Bà Trưng Hà Nội','191 Bà Triệu P.Lê Đại Hành Q.Hai Bà Trưng Hà Nội****500K','HMA','HBT',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'NAN_NDN_NMIN_BCHD','BAN CHẤP HÀNH ĐOÀN X.NGHĨA MINH','Xã Nghĩa Minh H.Nghĩa Đàn Nghệ An','Khối Kim Tân P.Hòa Hiếu T/X Thái Hòa Nghệ An','VIN','THO',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0700732802','0700732802','Công Ty TNHH Khai Thác Đá Xuân Tùng','Thôn Đồng Ao Xã Thanh Thủy H.Thanh Liêm Hà Nam','Thôn Đồng Ao Xã Thanh Thủy H.Thanh Liêm Hà Nam','PLY','TLI',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0301449409','0301449409','Công Ty Trách Nhiệm Hữu Hạn Sản Xuất Thương Mại Minh Diệu','11/12 Nguyễn Văn Quỳ Phường Phú Thuận Quận 07 Thành Phố Hồ Chí Minh','11/12 Nguyễn Văn Quỳ Phường Phú Thuận Quận 07 Thành Phố Hồ Chí Minh','NBE','007',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0303351261','0303351261','Công Ty Cổ Phần Thương Mại Tân Bình','446 Lý Thường Kiệt Phường 07 Quận Tân Bình Thành Phố Hồ Chí Minh','446 Lý Thường Kiệt Phường 07 Quận Tân Bình Thành Phố Hồ Chí Minh','TBI','TBI',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'0100150619034','Ngân Hàng Thương Mại Cổ Phần Đầu Tư Và Phát Triển Việt Nam - Chi Nhánh Quảng Trị','24 Hùng Vương P.01 TP Đông Hà QuảngTrị','24 Hùng Vương P.01 TP Đông Hà QuảngTrị****Gặp Chị Hạnh Phòng Tổ Chức Hành Chính','DHA','DHA',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0104260316','0104260316','Công Ty Cổ Phần Dịch Vụ Truyền Thông Hà Hải','104 Ngõ 82 Phạm Ngọc Thạch P.Quang Trung Q.Đống Đa Hà Nội','Số 147 Nguyễn Trãi P.Thượng Đình Q.Thanh Xuân Hà Nội','TXU','TXU',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100112437030','0100112437030','Ngân Hàng Thương Mại Cổ Phần Ngoại Thương Việt Nam- Chi Nhánh Quảng Ngãi','345 Hùng Vương P.Trần Phú TP Quảng Ngãi Quảng Ngãi','345 Hùng Vương P.Trần Phú TP Quảng Ngãi Quảng Ngãi','QNG','QNG','3QNGC04A1003',5);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'4101235527','4101235527','DNTN Vận Tải Khách Thành Long','Khối Phú Xuân T.Trấn Phú Phong H.Tây Sơn Bình Định','Khối Phú Xuân T.Trấn Phú Phong H.Tây Sơn Bình Định','QNH','TSO','3BDIC03A1005',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'5700883712','5700883712','Công Ty TNHH Hai Thành Viên Thương Mại - Dịch Vụ Và XNK Tổng Hợp Trường Phúc','Số 47 Tổ 4 Khu 2B P.Cẩm Trung TP Cẩm Phả Quảng Ninh','SN 19 Ngõ 85 Nguyễn Văn Trỗi Tổ 7 Tân Lập 8 P.Cẩm Thủy TP Cẩm Phả Quảng Ninh','CPH','CPH','5QNIC03A1002',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'5700883712','5700883712','Công Ty TNHH Hai Thành Viên Thương Mại - Dịch Vụ Và XNK Tổng Hợp Trường Phúc','Số 47 Tổ 4 Khu 2B P.Cẩm Trung TP Cẩm Phả Quảng Ninh','Số 47( Lê Văn Tùng 101099120) Tổ 4 Khu 2B P.Cẩm Trung TP Cẩm Phả Quảng Ninh','CPH','CPH','5QNIC03A1002',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'5700858875','5700858875','Công Ty Cổ Phần Thương Mại Hùng Thắng','Tổ 16 - Khu 4 P.Hùng Thắng TP Hạ Long Quảng Ninh','Tổ 16 - Khu 4 P.Hùng Thắng TP Hạ Long Quảng Ninh','HLO','HLO','5QNIC02A1024',41);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0301103030','0301103030',' Công Ty Cổ Phần Hàng Không Jetstar Pacific Airlines','112 Hồng Hà Phường 02 Quận Tân Bình Thành Phố Hồ Chí Minh','112 Hồng Hà Phường 02 Quận Tân Bình Thành Phố Hồ Chí Minh','TBI','TBI','2HCMC00A1089',4);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0306340691012','0306340691-012','Chi Nhánh Công Ty TNHH Thực Phẩm Tân Việt Nhật','Số 34 Đường Song Hành KP5 Phường An Phú Quận 02 Thành Phố Hồ Chí Minh','26C-26D-26E Lê Quốc Hưng Phường 12 Quận 04 Thành Phố Hồ Chí Minh','001','004',NULL,6);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0200253985','0200253985','Ngân Hàng Thương Mại Cổ Phần Đông Nam Á(Nguyễn Thị Hương Trang-SB02481)','25 Trần Hưng Đạo P.Phan Chu Trinh Q.Hoàn Kiếm Hà Nội','25 Trần Hưng Đạo P.Phan Chu Trinh Q.Hoàn Kiếm Hà Nội','HMA','HKI',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0310350068','0310350068','Công Ty Cổ Phần Cấp Nước Tân Hòa','95 Phạm Hữu Chí Phường 12 Quận 05 Thành Phố Hồ Chí Minh','95 Phạm Hữu Chí Phường 12 Quận 05 Thành Phố Hồ Chí Minh','005','005','2HCMC01A1017',5);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100111948026','0100111948026','Ngân Hàng TMCP Công Thương VN - Chi Nhánh Khánh Hòa','04 Hoàng Hoa Thám Vạn Thạnh TP Nha Trang Khánh Hòa','04 Hoàng Hoa Thám Vạn Thạnh TP Nha Trang Khánh Hòa','NTR','NTR','3KHOC01A1002',2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0303251299','4102021160','Công Ty Trách Nhiệm Hữu Hạn Tư Vấn Thiết Kế Xây Dựng Đương Đại','53/4 Nguyễn Văn Cừ Phường 01 Quận 05 Thành Phố Hồ Chí Minh','9B Thái Văn Lung Phường Bến Nghé Quận 01 Thành Phố Hồ Chí Minh','001','001',NULL,8);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'1300286876','55F8000165','Hộ Kinh Doanh_ Xe Khách Phấn Hương','Số 23 Đường Tán Kế P.03 TP Bến Tre Bến Tre','Số 23 Đường Tán Kế P.03 TP Bến Tre Bến Tre','BTR','BTR',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'54H8004176','Hộ Kinh Doanh Ngọc Hà','Ấp Phú Điền Tổ 10 Xã Song Phú H.Tam Bình Vĩnh Long','Ấp Phú Điền Tổ 10 Xã Song Phú H.Tam Bình Vĩnh Long','VLO','TBI',NULL,5);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0101429564','01010048','Văn Phòng Luật Sư Phạm Ngọc Hùng','Số 42 Hàng Than P.Nguyễn Trung Trực Q.Ba Đình Hà Nội','Số Nhà 81 Bia Bà Tổ 4 P.La Khê Q.Hà Đông Hà Nội','HDO','HDO',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),NULL,'54H8003180','Hộ Kinh Doanh Minh Hiểu','Tổ 6 Hòa Hiệp Xã Nguyễn Văn Thảnh H.Bình Tân Vĩnh Long','Tổ 6 Ấp Hòa Hiệp Xã Nguyễn Văn Thảnh H.Bình Tân Vĩnh Long','VLO','BTA',NULL,4);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0106299911','0106299911','Công Ty TNHH Thương Mại Dịch Vụ Giao Nhận Tín Phát','56/169 Hoàng Mai P.Hòang Văn Thụ Q.Hoàng Mai Hà Nội','56/169 Hoàng Mai P.Hòang Văn Thụ Q.Hoàng Mai Hà Nội','TXU','HMA',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0312898653001','0112000864','Chi Nhánh Công Ty Trách Nhiệm Hữu Hạn Schenker Logistics Việt Nam Tại Hà Nội','Tầng 8 Tòa Tháp IPH Số 241 Xuân Thủy  P.Dịch Vọng Hậu Q.Cầu Giấy Hà Nội','Tầng 8,Tòa Tháp IPH,241 Xuân Thủy P.Dịch Vọng Hậu Q.Cầu Giấy Hà Nội','CGI','CGI',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0401226413','0401226413','Công Ty CP Vận Tải & Dịch Vụ Phú Hoàng','192 Xuân Thủy P.Khuê Trung Q.Cẩm Lệ Đà Nẵng','192 Xuân Thủy P.Khuê Trung Q.Cẩm Lệ Đà Nẵng****Sim 3G Wifi','TKH','CLE',NULL,110);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0401226413','0401226413','Công Ty CP Vận Tải & Dịch Vụ Phú Hoàng','192 Xuân Thủy P.Khuê Trung Q.Cẩm Lệ Đà Nẵng','150 Đu7o2ng 2/9 P.Hòa Thuận Q.Hải Châu Đà Nẵng****Sim 3G Wifi','TKH','HCH',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'4400707094','4400707094','Cty TNHH Gia Hòa Phát','Lô B67 Tái Định Cư P.09 TP.Tuy Hòa Phú Yên','Lô B67 Tái Định Cư P.09 TP.Tuy Hòa Phú Yên','THA','THA','3PYEC02A1004',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0102364045','0102364045','Công Ty Cổ Phần Đầu Tư Thương Mại Ô Tô Quốc Tế','P301 Tòa Nhà Hòa Bình, Lô 2 -3A Cụm Công Nghiệp Hoàng Mai P.Hòang Văn Thụ Q.Hoàng Mai Hà Nội','P301 Tòa Nhà Hòa Bình, Lô 2 -3A Cụm Công Nghiệp Hoàng Mai P.Hòang Văn Thụ Q.Hoàng Mai Hà Nội','HMA','HMA','1HNOC05A1037',9);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0303313001','411043000136','Công Ty Trách Nhiệm Hữu Hạn Ô Tô Ngôi Sao Việt Nam','2 Trường Chinh Phường Tây Thạnh Quận Tân Phú Thành Phố Hồ Chí Minh','811-813 Nguyễn Văn Linh Phường Tân Phong Quận 07 Thành Phố Hồ Chí Minh','NBE','007','2HCMC05A1039',3);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'4001001555','4001001555','DNTN Đàn Khoa','Xã DLê Yang Ea H''leo ĐắkLắk','Xã DLê Yang Ea H''leo ĐắkLắk****Biện Thị Trang Nhung','EHL','EHL','3DLAC12A1003',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0101314122001','0101314122-001','Chi Nhánh Thành Phố Hồ Chí Minh Công Ty Trách Nhiệm Hữu Hạn Một Thành Viên Du Lịch Trâu Việt Nam (TP Hà Nội)','Tầng 8 Số 157-157A Pasteur Phường 06 Quận 03 Thành Phố Hồ Chí Minh','Tầng 8 Số 157-157A Pasteur Phường 06 Quận 03 Thành Phố Hồ Chí Minh','003','003','2HCMC01A1008',5);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0102560459','0102560459','Công Ty Cổ Phần Dịch Vụ Kỹ Thuật Điện Lực Dầu Khí Việt Nam','198 Nguyễn Tuân P.Thanh Xuân Trung Q.Thanh Xuân Hà Nội','Tầng 7, Toà Nhà HH3, Khu Đô Thị Mỹ Đình Phường Mễ Trì Quận Nam Từ Liêm Hà Nội','HMA','NTL','1HNOC00A1047',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0311041489','41-003308','Văn Phòng Đại Diện L.Powell Acquisition Corp. Tại Thành Phố Hồ Chí Minh','17B Sông Thương Phường 02 Quận Tân Bình Thành Phố Hồ Chí Minh','17B Sông Thương Phường 02 Quận Tân Bình Thành Phố Hồ Chí Minh','TBI','TBI',NULL,1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'4200535803','3701000764','DNTN Vận Tải Vĩnh Nguyên','152A Lê Hồng Phong P.Phước Hải TP Nha Trang Khánh Hòa','152A Lê Hồng Phong P.Phước Hải TP Nha Trang Khánh Hòa','NTR','NTR',NULL,2);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0100150619114','0100150619-114','Ngân Hàng Thương Mại Cổ Phần Đầu Tư Và Phát Triển Việt Nam - Chi Nhánh Hoàn Kiếm','Số 194 Trần Quang Khải P.Lý Thái Tổ Q.Hoàn Kiếm Hà Nội','Số 194 Trần Quang Khả P.Lý Thái Tổ Q.Hoàn Kiếm Hà Nội','HMA','HKI','1HNOC05A1040',1);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0312290054','0312290054','Công Ty Trách Nhiệm Hữu Hạn Điện Tử Nhật Quang-Thái Bình','361/21/1 Phan Huy Ích Phường 14 Quận Gò Vấp Thành Phố Hồ Chí Minh','361/21/1 Phan Huy Ích Phường 14 Quận Gò Vấp Thành Phố Hồ Chí Minh','TPH','GVA','2HCMC06A1180',10);
INSERT INTO rpt_sum_corp_monthly 
VALUES(TO_DATE('2015-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'0101537520','0101537520','Công Ty Cổ Phần Taxi Hà Nội','Tầng 5- Tòa Nhà 6 Tầng Số 105 Láng Hạ Phường P.Láng Hạ Q.Đống Đa Hà Nội','Tầng 5- Tòa Nhà 6 Tầng Số 105 Láng Hạ Phường P.Láng Hạ Q.Đống Đa Hà Nội','CGI','DDA','1HNOC00A1043',10);