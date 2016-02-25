
  select department_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(departmentid) into l_max_id from department;
      -- Get the current sequence value;
      select department_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence department_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select department_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence department_seq increment by 1';

   end;
--

select department_seq.nextval from dual;

   select dm_giaidoan_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(msgiaidoan) into l_max_id from dm_giaidoan;
      -- Get the current sequence value;
      select dm_giaidoan_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence dm_giaidoan_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select dm_giaidoan_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence dm_giaidoan_seq increment by 1';

   end;
--
 select dm_giaidoan_seq.nextval from dual;
 select dm_lanhdao_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(mslanhdao) into l_max_id from dm_lanhdao;
      -- Get the current sequence value;
      select dm_lanhdao_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence dm_lanhdao_seq  increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select dm_lanhdao_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence dm_lanhdao_seq  increment by 1';

   end;
--
   select dm_lanhdao_seq.nextval from dual;

 select dm_loai_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(msloai) into l_max_id from dm_loai;
      -- Get the current sequence value;
      select dm_loai_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence dm_loai_seq  increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select dm_loai_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence dm_loai_seq  increment by 1';

   end;
--
   select dm_loai_seq.nextval from dual;
   select dm_loaibao_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(msloaibao) into l_max_id from dm_loaibao;
      -- Get the current sequence value;
      select dm_loaibao_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence dm_loaibao_seq  increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select dm_loaibao_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence dm_loaibao_seq  increment by 1';

   end;
--
   select dm_loaibao_seq.nextval from dual;

 select dm_loaibieumau_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(msbieumau) into l_max_id from dm_loaibieumau;
      -- Get the current sequence value;
      select dm_loaibieumau_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence dm_loaibieumau_seq  increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select dm_loaibieumau_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence dm_loaibieumau_seq  increment by 1';

   end;
--
   select dm_loaibieumau_seq.nextval from dual;


 select dm_nguonvon_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(msnguonvon) into l_max_id from dm_nguonvon;
      -- Get the current sequence value;
      select dm_nguonvon_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence dm_nguonvon_seq  increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select dm_nguonvon_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence dm_nguonvon_seq  increment by 1';

   end;
--
   select dm_nguonvon_seq.nextval from dual;

 select dm_nhathau_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(msnhathau) into l_max_id from dm_nhathau;
      -- Get the current sequence value;
      select dm_nhathau_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence dm_nhathau_seq  increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select dm_nhathau_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence dm_nhathau_seq  increment by 1';

   end;
--
   select dm_nhathau_seq.nextval from dual;

    select dm_noidung_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(msnoidung) into l_max_id from dm_noidung;
      -- Get the current sequence value;
      select dm_noidung_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence dm_noidung_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select dm_noidung_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence dm_noidung_seq  increment by 1';

   end;
--
   select dm_noidung_seq.nextval from dual;

   select dm_noidunghoso_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(msnoidunghs) into l_max_id from dm_noidunghoso;
      -- Get the current sequence value;
      select dm_noidunghoso_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence dm_noidunghoso_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select dm_noidunghoso_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence dm_noidunghoso_seq  increment by 1';

   end;
--
   select dm_noidunghoso_seq.nextval from dual;

    select dm_quimo_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(msquimo) into l_max_id from dm_quimo;
      -- Get the current sequence value;
      select dm_quimo_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence dm_quimo_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select dm_quimo_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence dm_quimo_seq  increment by 1';

   end;
--
   select dm_quimo_seq.nextval from dual;

   select dm_thamsoguimail_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(msthamsoguimail) into l_max_id from dm_thamsoguimail;
      -- Get the current sequence value;
      select dm_thamsoguimail_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence dm_thamsoguimail_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select dm_thamsoguimail_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence dm_thamsoguimail_seq  increment by 1';

   end;
--
   select dm_thamsoguimail_seq.nextval from dual;

   select dm_thamsohethong_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(msthamsohethong) into l_max_id from dm_thamsohethong;
      -- Get the current sequence value;
      select dm_thamsohethong_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence dm_thamsohethong_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select dm_thamsohethong_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence dm_thamsohethong_seq  increment by 1';

   end;
--
   select dm_thamsohethong_seq.nextval from dual;

    select dm_thamsohethong_bk_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(msthamsohethong) into l_max_id from dm_thamsohethong_bk;
      -- Get the current sequence value;
      select dm_thamsohethong_bk_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence dm_thamsohethong_bk_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select dm_thamsohethong_bk_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence dm_thamsohethong_bk_seq  increment by 1';

   end;
--
   select dm_thamsohethong_bk_seq.nextval from dual;

   select dm_thamsoquimo_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(msthamso) into l_max_id from dm_thamsoquimo;
      -- Get the current sequence value;
      select dm_thamsoquimo_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence dm_thamsoquimo_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select dm_thamsoquimo_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence dm_thamsoquimo_seq  increment by 1';

   end;
--
   select dm_thamsoquimo_seq.nextval from dual;

    select dm_tinhchatgt_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(mstinhchat) into l_max_id from dm_tinhchatgt;
      -- Get the current sequence value;
      select dm_tinhchatgt_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence dm_tinhchatgt_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select dm_tinhchatgt_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence dm_tinhchatgt_seq  increment by 1';

   end;
--
   select dm_tinhchatgt_seq.nextval from dual;
   select dm_tinhtrang_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(mstinhtrang) into l_max_id from dm_tinhtrang;
      -- Get the current sequence value;
      select dm_tinhtrang_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence dm_tinhtrang_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select dm_tinhtrang_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence dm_tinhtrang_seq  increment by 1';

   end;
--
   select dm_tinhtrang_seq.nextval from dual;
   select goithau_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(msgoithau) into l_max_id from goithau;
      -- Get the current sequence value;
      select goithau_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence goithau_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select goithau_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence goithau_seq  increment by 1';

   end;
--
   select goithau_seq.nextval from dual;

   select goithau_nhanvien_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(msgoithau_nv) into l_max_id from goithau_nhanvien;
      -- Get the current sequence value;
      select goithau_nhanvien_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence goithau_nhanvien_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select goithau_nhanvien_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence goithau_nhanvien_seq  increment by 1';

   end;
--
   select goithau_nhanvien_seq.nextval from dual;

    select goithau_nhathau_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(msgoithau_nt) into l_max_id from goithau_nhathau;
      -- Get the current sequence value;
      select goithau_nhathau_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence goithau_nhathau_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select goithau_nhathau_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence goithau_nhathau_seq  increment by 1';

   end;
--
   select goithau_nhathau_seq.nextval from dual;

   select hosoluutru_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(msluutru) into l_max_id from hosoluutru;
      -- Get the current sequence value;
      select hosoluutru_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence hosoluutru_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select hosoluutru_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence hosoluutru_seq  increment by 1';

   end;
--
   select hosoluutru_seq.nextval from dual;

    select hosothau_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(mshosothau) into l_max_id from hosothau;
      -- Get the current sequence value;
      select hosothau_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence hosothau_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select hosothau_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence hosothau_seq  increment by 1';

   end;
--
   select hosothau_seq.nextval from dual;
   select kinhphi_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(mskinhphi) into l_max_id from kinhphi;
      -- Get the current sequence value;
      select kinhphi_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence kinhphi_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select kinhphi_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence kinhphi_seq  increment by 1';

   end;
--
   select kinhphi_seq.nextval from dual;

   select tiendo_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(mstiendo) into l_max_id from tiendo;
      -- Get the current sequence value;
      select tiendo_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence tiendo_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select tiendo_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence tiendo_seq  increment by 1';

   end;
--
   select tiendo_seq.nextval from dual;

    select users_seq.nextval from dual;
 declare
      l_max_id number;
       l_max_seq number;
    begin
       -- Get the maximum ID
       select max(userid) into l_max_id from users;
      -- Get the current sequence value;
      select users_seq.nextval into l_max_seq from dual;

      -- Alter the sequence to increment by the difference ( -5 in this case )
      execute immediate 'alter sequence users_seq increment by ' || ( l_max_id - l_max_seq );
      -- 'increment' by -5
      select users_seq.nextval into l_max_seq from dual;

      -- Change the sequence back to normal
      execute immediate 'alter sequence users_seq  increment by 1';

   end;
--
   select users_seq.nextval from dual;