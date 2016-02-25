

INSERT INTO DM_LOAIBAO(MsLoaiBao, TenLoaiBao, Stt, GhiChu, MaLoaiBao) VALUES (1, 'Báo đấu thầu', 1, 'Báo đấu thầu', 'BDT');
INSERT INTO DM_LOAIBAO(MsLoaiBao, TenLoaiBao, Stt, GhiChu, MaLoaiBao) VALUES (2, 'Sài Gòn giải phóng', 2, 'Sài Gòn giải phóng', 'SGGP');
INSERT INTO DM_LOAIBAO(MsLoaiBao, TenLoaiBao, Stt, GhiChu, MaLoaiBao) VALUES (3, 'Thanh niên', 3, 'Thanh niên', 'TN');

INSERT INTO DM_NOIDUNG(MsNoidung, TenNoiDung, Stt, GhiChu) VALUES (1, 'Thông báo mời thầu', 1, 'Thông báo mời thầu');


INSERT INTO permissiongroup(permissiongroupid, code, description) VALUES (1, 'XT', 'Xét thầu');
INSERT INTO permissiongroup(permissiongroupid, code, description) VALUES (2, 'TD', 'Thẩm định');


INSERT INTO permission(permissionid, code, name, permissiongroupid) VALUES (1, 'XT', 'Xét thầu', 1);
INSERT INTO permission(permissionid, code, name, permissiongroupid) VALUES (2, 'TD', 'Thẩm định', 2);

insert into useracl(useraclid, userid, permissionid) values(1, 1, 1);


insert into usergroup(usergroupid, code, description, iscenter) values(1, 'ADMIN', 'Admin', 1);
insert into usergroup(usergroupid, code, description, iscenter) values(2, 'TP', 'Trưởng phòng', 1);
insert into usergroup(usergroupid, code, description, iscenter) values(6, 'NV', 'Nhân viên', 1);

insert into usergroupacl(usergroupaclid, usergroupid, permissionid) values(1, 2, 1);
insert into usergroupacl(usergroupaclid, usergroupid, permissionid) values(2, 2, 2);
insert into usergroupacl(usergroupaclid, usergroupid, permissionid) values(3, 3, 1);
insert into usergroupacl(usergroupaclid, usergroupid, permissionid) values(4, 4, 2);



INSERT INTO DM_TINHTRANG(MsTinhTrang, TenTinhTrang, Active, MaTinhTrang, DisplayOrder) VALUES (12, 'Thẩm định phương án', 1, 'TDPA', 1);
INSERT INTO DM_TINHTRANG(MsTinhTrang, TenTinhTrang, Active, MaTinhTrang, DisplayOrder) VALUES (8, 'Trình phê duyệt PA', 1, 'TPDPA', 2);
INSERT INTO DM_TINHTRANG(MsTinhTrang, TenTinhTrang, Active, MaTinhTrang, DisplayOrder) VALUES (14, 'Thẩm định hồ sơ mời thầu', 1, 'TDHSMT', 3);
INSERT INTO DM_TINHTRANG(MsTinhTrang, TenTinhTrang, Active, MaTinhTrang, DisplayOrder) VALUES (15, 'Thẩm định hồ sơ mời chào giá cạnh tranh', 1, 'TDHSMCGCT', 4);
INSERT INTO DM_TINHTRANG(MsTinhTrang, TenTinhTrang, Active, MaTinhTrang, DisplayOrder) VALUES (16, 'Thẩm định hồ sơ yêu cầu', 1, 'TDHSYC', 5);
INSERT INTO DM_TINHTRANG(MsTinhTrang, TenTinhTrang, Active, MaTinhTrang, DisplayOrder) VALUES (17, 'Trình phê duyệt HSMT/HSYC', 1, 'TPDHS', 6);
INSERT INTO DM_TINHTRANG(MsTinhTrang, TenTinhTrang, Active, MaTinhTrang, DisplayOrder) VALUES (18, 'Chuẩn bị mời thầu', 1, 'CBMT', 7);
INSERT INTO DM_TINHTRANG(MsTinhTrang, TenTinhTrang, Active, MaTinhTrang, DisplayOrder) VALUES (3, 'Đang mời thầu', 1, 'DMT', 8);
INSERT INTO DM_TINHTRANG(MsTinhTrang, TenTinhTrang, Active, MaTinhTrang, DisplayOrder) VALUES (4, 'Đang đánh giá', 1, 'DDG', 9);
INSERT INTO DM_TINHTRANG(MsTinhTrang, TenTinhTrang, Active, MaTinhTrang, DisplayOrder) VALUES (21, 'Đang thẩm định kết quả', 1, 'DTDKQ', 10);
INSERT INTO DM_TINHTRANG(MsTinhTrang, TenTinhTrang, Active, MaTinhTrang, DisplayOrder) VALUES (22, 'Trình phê duyệt kết quả', 1, 'TPDKQ', 11);
INSERT INTO DM_TINHTRANG(MsTinhTrang, TenTinhTrang, Active, MaTinhTrang, DisplayOrder) VALUES (23, 'Thông báo kết quả', 1, 'TBKQ', 12);
INSERT INTO DM_TINHTRANG(MsTinhTrang, TenTinhTrang, Active, MaTinhTrang, DisplayOrder) VALUES (6, 'Hoàn tất', 1, 'HT', 13);


update department set active = 0;
update department set active = 1 where departmentid in (49,1,31,23,33,26);

INSERT INTO DEPARTMENT(departmentid, code, name, active) values (51, 'MBF2KPP', 'P.Kênh Phân Phối', 1);
INSERT INTO DEPARTMENT(departmentid, code, name, active) values (52, 'KTTC', 'P.Kế Toán', 1);
INSERT INTO DEPARTMENT(departmentid, code, name, active) values (53, 'BHM', 'P.Bán Hàng-Marketing', 1);
INSERT INTO DEPARTMENT(departmentid, code, name, active) values (54, 'CNHCM1', 'MobiFone Hồ Chí Minh 1', 1);
INSERT INTO DEPARTMENT(departmentid, code, name, active) values (55, 'CNHCM6', 'MobiFone Hồ Chí Minh 6', 1);





