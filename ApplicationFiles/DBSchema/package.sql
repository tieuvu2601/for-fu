create or replace PACKAGE pck_query_rpt
AS
TYPE report101AType IS RECORD(branch_Code VARCHAR(50),
                              branch_Name VARCHAR(50),
                              district_Code VARCHAR(50),
                              district_Name VARCHAR(100),
                              sub_Type VARCHAR(20),
                              amount NUMBER,
                              monthVal NUMBER,
                              cen_code_reg VARCHAR(20),
                              cen_code_payment VARCHAR(20));
TYPE report101ATable IS TABLE OF report101AType;
FUNCTION queryReport101A(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, branchCodeVar VARCHAR, districtCodeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR) RETURN report101ATable PIPELINED;

TYPE report101BType IS RECORD(branch_Code VARCHAR(50),
                              branch_Name VARCHAR(50),
                              district_Code VARCHAR(50),
                              district_Name VARCHAR(100),
                              sub_Type VARCHAR(20),
                              amount NUMBER,
                              monthVal NUMBER,
                              cenCode VARCHAR(20));
TYPE report101BTable IS TABLE OF report101BType;
FUNCTION queryReport101B(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, branchCodeVar VARCHAR, districtCodeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR) RETURN report101BTable PIPELINED;

TYPE report101CType IS RECORD(Cen_code VARCHAR(20),
                              SUB_TYPE VARCHAR(20),
                              Amount NUMBER,
                              MonthVal NUMBER);
TYPE report101CTable IS TABLE OF report101CType;
FUNCTION queryReport101C(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, subTypeVar VARCHAR) RETURN report101CTable PIPELINED;

TYPE report102AType IS RECORD(branchCode VARCHAR2(50 BYTE),
                              branchName VARCHAR2(50 BYTE),
                              districtName VARCHAR2(50 BYTE),
                              districtCode VARCHAR2(50 BYTE),
                              amount NUMBER,
                              daily NUMBER, 
                              cenCodeReg VARCHAR(20),
                              cenCodePayment VARCHAR(20));
TYPE report102ATable IS TABLE OF report102AType;
FUNCTION queryReport102A(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, branchCodeVar VARCHAR, districtCodeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR) RETURN report102ATable PIPELINED;

TYPE report102BType IS RECORD(branchCode VARCHAR2(50 BYTE),
                              branchName VARCHAR2(50 BYTE),
                              districtName VARCHAR2(50 BYTE),
                              districtCode VARCHAR2(50 BYTE),
                              amount NUMBER,
                              daily NUMBER, 
                              cenCode VARCHAR(20));
TYPE report102BTable IS TABLE OF report102BType;
FUNCTION queryReport102B(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, branchCodeVar VARCHAR, districtCodeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR) RETURN report102BTable PIPELINED;

TYPE report102CType IS RECORD(Cencode VARCHAR(20),
                              amount NUMBER,
                              daily NUMBER);
TYPE report102CTable IS TABLE OF report102CType;
FUNCTION queryReport102C(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, subTypeVar VARCHAR) RETURN report102CTable PIPELINED;

TYPE report103AType IS RECORD(Sub_Type VARCHAR(20),
                              Package_Code VARCHAR(60),
                              Branch_code VARCHAR(20),
                              Amount NUMBER,
                              MonthVal NUMBER,
                              cenCode VARCHAR(20));
TYPE report103ATable IS TABLE OF report103AType;
FUNCTION queryReport103A(cenCodeVar VARCHAR, fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, packageCodeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR) RETURN report103ATable PIPELINED;

TYPE report103BType IS RECORD(Sub_Type VARCHAR(20),
                              Package_Code VARCHAR(60),
                              Branch_code VARCHAR(20),
                              Amount NUMBER,
                              MonthVal NUMBER,
                              cenCode VARCHAR(20));
TYPE report103BTable IS TABLE OF report103BType;
FUNCTION queryReport103B(cenCodeVar VARCHAR, fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, packageCodeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR) RETURN report103BTable PIPELINED;

TYPE report103CType IS RECORD(Sub_Type VARCHAR(20),
                              Package_Code VARCHAR(60),
                              Cen_Code VARCHAR(20),
                              Amount NUMBER,
                              MonthVal NUMBER);
TYPE report103CTable IS TABLE OF report103CType;
FUNCTION queryReport103C(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, subTypeVar VARCHAR) RETURN report103CTable PIPELINED;

TYPE report104Type IS RECORD( Branch_Code VARCHAR2(20), 
                              Branch_Name VARCHAR2(20), 
                              Channel_Type VARCHAR2(30 BYTE), 
                              Channel_Name VARCHAR2(100 BYTE),
                              Sub_Type VARCHAR(20),
                              MonthVal NUMBER,                                                        
                              Amount NUMBER,
                              cenCodeReg VARCHAR(20),
                              cenCodePayment VARCHAR(20));
TYPE report104Table IS TABLE OF report104Type;
FUNCTION queryReport104(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR,  branchCodeVar VARCHAR, channelTypeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR) RETURN report104Table PIPELINED;

TYPE report105Type IS RECORD(branch_Code VARCHAR(50),
                              branch_Name VARCHAR(50),
                              teamCode VARCHAR2(50),
                              teamName VARCHAR2(255),                              
                              district_Code VARCHAR(50),
                              district_Name VARCHAR(100),
                              emp_Code VARCHAR2(50),                              
                              emp_Name VARCHAR2(255),
                              sta_Date DATE,
                              QUOTA_TYPE VARCHAR2(50),
                              monthVal NUMBER,
                              amount NUMBER,
                              cenCodeReg VARCHAR(20),
                              cenCodePayment VARCHAR(20),
                              shopCode VARCHAR(100));
TYPE report105Table IS TABLE OF report105Type;
FUNCTION queryReport105(statusVar NUMBER, quotatypeVar VARCHAR, fromDateVar VARCHAR, toDateVar VARCHAR, 
                          formatDateVar VARCHAR, branchCodeVar VARCHAR, districtCodeVar VARCHAR,  teamIdVar VARCHAR, empCodeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR) RETURN  report105Table PIPELINED;

TYPE report106Type IS RECORD(branchCode VARCHAR2(20 BYTE),
                              mst VARCHAR2(100 BYTE),
                              gpkd VARCHAR2(250 BYTE),
                              tendn VARCHAR2(550 BYTE),                              
                              address VARCHAR2(600 BYTE),
                              pay_full_address VARCHAR2(700 BYTE),                             
                              districtCode VARCHAR2(40 BYTE),     
                               branchCodeReg VARCHAR2(20 BYTE),
                              empCode VARCHAR2(60 BYTE),                           
                              monthVal NUMBER,
                              amount NUMBER
                              );
TYPE report106Table IS TABLE OF report106Type;
FUNCTION queryReport106(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, branchCodeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR) RETURN  report106Table PIPELINED;

TYPE report108Type IS RECORD( Branch_Code VARCHAR2(20), 
                              Branch_Name VARCHAR2(50),  
                              packageLevelCode VARCHAR2(50), 
                              packageLevelName VARCHAR2(60),   
                              packageGroupCode VARCHAR2(50),
                              packageGroupName VARCHAR2(255),
                              packageCode VARCHAR(20),
                              field_type VARCHAR(20),
                              dailyVal NUMBER,                                                        
                              amount NUMBER);
TYPE report108Table IS TABLE OF report108Type;
FUNCTION queryReport108(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, 
                          branchCodeVar VARCHAR, packageLevelIdVar VARCHAR, packageGroupIdVar VARCHAR, fieldTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR) RETURN report108Table PIPELINED;


TYPE report109Type IS RECORD(branchCode VARCHAR2(20 BYTE),
                             branchName VARCHAR2(50 BYTE),
                             packageLevelCode VARCHAR2(50 BYTE), 
                             packageLevelName VARCHAR2(60 BYTE),   
                             packageGroupCode VARCHAR2(50 BYTE),
                             packageGroupName VARCHAR2(255 BYTE),
                             packageCode VARCHAR2(60 BYTE),
                             fieldType VARCHAR2(20 BYTE),
                             monthVal NUMBER,
                             amount NUMBER );
TYPE report109Table IS TABLE OF report109Type;
FUNCTION queryReport109(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR,
branchCodeVar VARCHAR, fieldTypeVar VARCHAR, packageLevelIdVar VARCHAR, packageGroupIdVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR) RETURN report109Table PIPELINED;

END pck_query_rpt;

create or replace PACKAGE BODY pck_query_rpt
AS
FUNCTION queryReport101A(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, branchCodeVar VARCHAR, districtCodeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR) RETURN report101ATable PIPELINED
  AS tmpObject report101AType;
  BEGIN
    FOR e IN (
      SELECT a.branch_Code,
              a.branch_Name,
              a.district_Code,
              a.district_Name,
              DECODE(rpt_m.sub_Type, 'FDN', 'FDN', 'MDT', 'DATA', 'GOLD', 'GOLD') as sub_Type,
              EXTRACT(MONTH FROM rpt_m.sum_Month) as monthVal,
              SUM(rpt_m.amount) as amount,
              rpt_m.cen_code_reg,
              rpt_m.cen_code_payment
        FROM RPT_Sum_Sub_monthly rpt_m
        LEFT JOIN Area_vw a ON a.district_code = rpt_m.district_code_reg
        WHERE rpt_m.sum_data_type = 'CORP_PTM' AND (case when a.branch_Code is null then '%' else a.branch_Code end)
                      LIKE (CASE WHEN branchCodeVar IS NOT NULL THEN branchCodeVar ELSE '%' END)
            AND(case when a.district_code is null then '%' else a.district_code end)
                  LIKE (CASE WHEN districtCodeVar IS NOT NULL THEN districtCodeVar ELSE '%' END)
            AND((case when rpt_m.sub_Type is null then '%' else rpt_m.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('FDN')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END)
            OR(case when rpt_m.sub_Type is null then '%' else rpt_m.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('MDT')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END))
            AND TRUNC(rpt_m.sum_month) >= TRUNC(TO_DATE(fromDateVar, formatDateVar))
            AND TRUNC(rpt_m.sum_month) <= TRUNC(TO_DATE(toDateVar, formatDateVar))
            AND (rpt_m.district_code_reg IN (SELECT ua.Code FROM UserAreaACL ua WHERE ua.userId = userIdVar AND flag = 0)
                  OR 'ADMIN_OR_CENTER' = RoleVar
                  OR rpt_m.district_code_reg IN (SELECT avw.district_Code FROM Area_vw avw WHERE EXISTS
                        (SELECT 1 FROM UserAreaACL ua WHERE ua.userId = userIdVar AND avw.branch_Code = ua.code AND flag = 1)))
        GROUP BY rpt_m.cen_code_reg, a.branch_Code, a.district_Name, a.district_Code, a.district_Code, a.branch_Name, rpt_m.sub_Type, EXTRACT(MONTH FROM rpt_m.sum_Month),rpt_m.cen_code_payment
        ORDER BY rpt_m.cen_code_reg, a.branch_Code, a.district_Code, rpt_m.sub_Type, EXTRACT(MONTH FROM rpt_m.sum_Month)
    )
    LOOP
      tmpObject.branch_Code := e.branch_Code;
      tmpObject.branch_Name := e.branch_Name;
      tmpObject.district_Code := e.district_Code;
      tmpObject.district_Name := e.district_Name;
      tmpObject.sub_Type := e.sub_type;
      tmpObject.amount := e.amount;
      tmpObject.monthVal := e.monthVal;
      tmpObject.cen_code_reg := e.cen_code_reg;
      tmpObject.cen_code_payment := e.cen_code_payment;
      PIPE ROW(tmpObject);
    END LOOP;
    RETURN;
  END;

FUNCTION queryReport101B(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, branchCodeVar VARCHAR, districtCodeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR) RETURN report101BTable PIPELINED
  AS tmpObject report101BType;
  BEGIN
    FOR e IN (
      SELECT a.branch_Code,
              a.branch_Name,
              a.district_Code,
              a.district_Name,
              DECODE(rpt_m.sub_Type, 'FDN', 'FDN', 'MDT', 'DATA', 'GOLD', 'GOLD') as sub_Type,
              EXTRACT(MONTH FROM rpt_m.sum_Month) as monthVal,
              SUM(rpt_m.amount) as amount,
              rpt_m.Cen_code_payment
        FROM RPT_Sum_Sub_monthly rpt_m
        LEFT JOIN Area_vw a ON a.district_code = rpt_m.district_code_payment
        WHERE rpt_m.sum_data_type = 'CORP_PTM' AND (case when a.branch_Code is null then '%' else a.branch_Code end)
                      LIKE (CASE WHEN branchCodeVar IS NOT NULL THEN branchCodeVar ELSE '%' END)
            AND(case when a.district_code is null then '%' else a.district_code end)
                  LIKE (CASE WHEN districtCodeVar IS NOT NULL THEN districtCodeVar ELSE '%' END)
            AND((case when rpt_m.sub_Type is null then '%' else rpt_m.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('FDN')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END)
              OR(case when rpt_m.sub_Type is null then '%' else rpt_m.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('MDT')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END))
            AND TRUNC(rpt_m.sum_month) >= TRUNC(TO_DATE(fromDateVar, formatDateVar))
            AND TRUNC(rpt_m.sum_month) <= TRUNC(TO_DATE(toDateVar, formatDateVar))
            AND (rpt_m.district_code_payment IN (SELECT ua.code FROM UserAreaACL ua WHERE ua.userId = userIdVar AND flag = 0)
                  OR 'ADMIN_OR_CENTER' = RoleVar
                  OR rpt_m.district_code_payment IN (SELECT avw.district_Code FROM Area_vw avw WHERE EXISTS
                        (SELECT 1 FROM UserAreaACL ua WHERE ua.userId = userIdVar AND avw.branch_Code = ua.code AND flag = 1)))
        GROUP BY rpt_m.Cen_code_payment, a.branch_Code, a.district_Name, a.district_Code, a.district_Code, a.branch_Name, rpt_m.sub_Type, EXTRACT(MONTH FROM rpt_m.sum_Month)
        ORDER BY rpt_m.Cen_code_payment, a.branch_Code, a.district_Code, rpt_m.sub_Type, EXTRACT(MONTH FROM rpt_m.sum_Month)
    )
    LOOP
      tmpObject.branch_Code := e.branch_Code;
      tmpObject.branch_Name := e.branch_Name;
      tmpObject.district_Code := e.district_Code;
      tmpObject.district_Name := e.district_Name;
      tmpObject.sub_Type := e.sub_type;
      tmpObject.amount := e.amount;
      tmpObject.monthVal := e.monthVal;
      tmpObject.cenCode := e.Cen_code_payment;
      PIPE ROW(tmpObject);
    END LOOP;
    RETURN;
  END;

  FUNCTION queryReport101C(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, subTypeVar VARCHAR) RETURN report101CTable PIPELINED
  AS tmpObject report101CType;
  BEGIN
    FOR e IN (
    SELECT Cen_code_payment,
           DECODE(rpt_m.sub_Type, 'FDN', 'FDN', 'MDT', 'DATA', 'GOLD', 'GOLD') as sub_Type,
           EXTRACT(MONTH FROM rpt_m.Sum_Month) as MonthVal,
           SUM(Amount) as amount
     FROM RPT_Sum_Sub_monthly rpt_m
      WHERE rpt_m.sum_data_type = 'CORP_PTM' AND ((case when rpt_m.sub_Type is null then '%' else rpt_m.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('FDN')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END)
              OR(case when rpt_m.sub_Type is null then '%' else rpt_m.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('MDT')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END))
              AND TRUNC(rpt_m.sum_month) >= TRUNC(TO_DATE(fromDateVar, formatDateVar))
              AND TRUNC(rpt_m.sum_month) <= TRUNC(TO_DATE(toDateVar, formatDateVar))
     GROUP BY Cen_code_payment, rpt_m.Sub_Type, EXTRACT(MONTH FROM rpt_m.Sum_Month)
     ORDER BY Cen_code_payment, rpt_m.Sub_Type, EXTRACT(MONTH FROM rpt_m.Sum_Month)
    )
    LOOP
      tmpObject.Cen_code := e.Cen_code_payment;
      tmpObject.sub_type := e.sub_type;
      tmpObject.amount := e.amount;
      tmpObject.MonthVal := e.MonthVal;
      PIPE ROW(tmpObject);
    END LOOP;
    RETURN;
  END;

FUNCTION queryReport102A(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, branchCodeVar VARCHAR, districtCodeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR) RETURN report102ATable PIPELINED
  AS tmpObject report102AType;
  BEGIN
    FOR e IN (
      SELECT a.branch_Code, a.branch_Name, a.district_Code, a.district_Name, SUM(amount) amount,
              EXTRACT(DAY FROM rpt_d.SUM_DATE) daily,
              rpt_d.Cen_code_reg,
              rpt_d.Cen_code_payment
      FROM RPT_SUM_SUB_DAILY rpt_d
      LEFT JOIN Area_vw a
      ON a.district_Code = rpt_d.district_code_reg
      WHERE rpt_d.sum_data_type = 'CORP_PTM'
            AND (case when a.branch_Code is null then '%' else a.branch_Code end)
                      LIKE (CASE WHEN branchCodeVar IS NOT NULL THEN branchCodeVar ELSE '%' END)
            AND(case when a.district_code is null then '%' else a.district_code end)
                  LIKE (CASE WHEN districtCodeVar IS NOT NULL THEN districtCodeVar ELSE '%' END)
            AND((case when rpt_d.sub_Type is null then '%' else rpt_d.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('FDN')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END)
            OR(case when rpt_d.sub_Type is null then '%' else rpt_d.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('MDT')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END))
              AND TRUNC(rpt_d.sum_date) >= TRUNC(TO_DATE(fromDateVar, formatDateVar))
              AND TRUNC(rpt_d.sum_date) <= TRUNC(TO_DATE(toDateVar, formatDateVar))
              AND (rpt_d.district_code_reg IN (SELECT ua.code FROM UserAreaACL ua WHERE ua.userId = userIdVar AND flag = 0)
                  OR 'ADMIN_OR_CENTER' = RoleVar
                  OR rpt_d.district_code_reg IN (SELECT avw.district_Code FROM Area_vw avw WHERE EXISTS
                        (SELECT 1 FROM UserAreaACL ua WHERE ua.userId = userIdVar AND avw.branch_Code = ua.code AND flag = 1)))
      GROUP BY rpt_d.Cen_code_reg, a.branch_Code, a.district_Code, a.district_Name, a.branch_Name,  EXTRACT(DAY FROM rpt_d.SUM_DATE),rpt_d.Cen_code_payment
      ORDER BY rpt_d.Cen_code_reg, a.branch_Code, a.district_Code, EXTRACT(DAY FROM rpt_d.SUM_DATE)
    )
    LOOP
      tmpObject.branchCode := e.branch_Code;
      tmpObject.branchName := e.branch_Name;
      tmpObject.districtCode := e.district_Code;
      tmpObject.districtName := e.district_Name;
      tmpObject.amount := e.amount;
      tmpObject.daily := e.daily;
      tmpObject.cenCodeReg := e.Cen_code_reg;
      tmpObject.cenCodePayment := e.Cen_code_payment;
      PIPE ROW(tmpObject);
    END LOOP;
    RETURN;
  END;

  FUNCTION queryReport102B(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, branchCodeVar VARCHAR, districtCodeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR) RETURN report102BTable PIPELINED
  AS tmpObject report102BType;
  BEGIN
    FOR e IN (
      SELECT a.branch_Code, a.branch_Name, a.district_Code, a.district_Name, SUM(amount) amount,
              EXTRACT(DAY FROM rpt_d.SUM_DATE) daily,
              rpt_d.Cen_code_payment
      FROM RPT_SUM_SUB_DAILY rpt_d
      LEFT JOIN Area_vw a
      ON a.district_Code = rpt_d.district_code_payment
      WHERE rpt_d.sum_data_type = 'CORP_PTM'
            AND (case when a.branch_Code is null then '%' else a.branch_Code end)
                      LIKE (CASE WHEN branchCodeVar IS NOT NULL THEN branchCodeVar ELSE '%' END)
            AND(case when a.district_code is null then '%' else a.district_code end)
                  LIKE (CASE WHEN districtCodeVar IS NOT NULL THEN districtCodeVar ELSE '%' END)
            AND((case when rpt_d.sub_Type is null then '%' else rpt_d.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('FDN')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END)
            OR(case when rpt_d.sub_Type is null then '%' else rpt_d.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('MDT')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END))
              AND TRUNC(rpt_d.sum_date) >= TRUNC(TO_DATE(fromDateVar, formatDateVar))
              AND TRUNC(rpt_d.sum_date) <= TRUNC(TO_DATE(toDateVar, formatDateVar))
              AND (rpt_d.district_code_payment IN (SELECT ua.code FROM UserAreaACL ua WHERE ua.userId = userIdVar AND flag = 0)
                  OR 'ADMIN_OR_CENTER' = RoleVar
                  OR rpt_d.district_code_payment IN (SELECT avw.district_Code FROM Area_vw avw WHERE EXISTS
                        (SELECT 1 FROM UserAreaACL ua WHERE ua.userId = userIdVar AND avw.branch_Code = ua.code AND flag = 1)))
      GROUP BY rpt_d.Cen_code_payment, a.branch_Code, a.district_Code, a.district_Name, a.branch_Name,  EXTRACT(DAY FROM rpt_d.SUM_DATE)
      ORDER BY rpt_d.Cen_code_payment, a.branch_Code, a.district_Code, EXTRACT(DAY FROM rpt_d.SUM_DATE)
    )
    LOOP
      tmpObject.branchCode := e.branch_Code;
      tmpObject.branchName := e.branch_Name;
      tmpObject.districtCode := e.district_Code;
      tmpObject.districtName := e.district_Name;
      tmpObject.amount := e.amount;
      tmpObject.daily := e.daily;
      tmpObject.cenCode := e.Cen_code_payment;
      PIPE ROW(tmpObject);
    END LOOP;
    RETURN;
  END;

  FUNCTION queryReport102C(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, subTypeVar VARCHAR) RETURN report102CTable PIPELINED
  AS tmpObject report102CType;
  BEGIN
    FOR e IN (
      SELECT Cen_code_payment, SUM(amount) amount, EXTRACT(DAY FROM rpt_d.SUM_DATE) daily
      FROM RPT_SUM_SUB_DAILY rpt_d
      WHERE rpt_d.sum_data_type = 'CORP_PTM' AND TRUNC(rpt_d.sum_date) >= TRUNC(TO_DATE(fromDateVar, formatDateVar))
                AND TRUNC(rpt_d.sum_date) <= TRUNC(TO_DATE(toDateVar, formatDateVar))
                AND((case when rpt_d.sub_Type is null then '%' else rpt_d.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('FDN')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END)
            OR(case when rpt_d.sub_Type is null then '%' else rpt_d.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('MDT')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END))
      GROUP BY Cen_code_payment, rpt_d.SUM_DATE
      ORDER BY Cen_code_payment, rpt_d.SUM_DATE
    )
    LOOP

      tmpObject.CenCode := e.Cen_code_payment;
      tmpObject.Amount := e.amount;
      tmpObject.Daily := e.daily;
      PIPE ROW(tmpObject);
    END LOOP;
    RETURN;
  END;


  FUNCTION queryReport103A(cenCodeVar VARCHAR, fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, packageCodeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR)
    RETURN report103ATable PIPELINED
  AS
    tmpObject report103AType;
  BEGIN
    FOR e IN(
    SELECT rpt_m.Sub_Type, rpt_m.Package_Code, a.BRANCH_CODE,
      EXTRACT(MONTH FROM rpt_m.Sum_Month) as Monthval, SUM(Amount) as Amount
    FROM RPT_Sum_Sub_monthly rpt_m
    LEFT JOIN Area_vw a
          ON a.District_code = rpt_m.District_code_reg
    WHERE rpt_m.sum_data_type = 'CORP_PTM' AND rpt_m.cen_code_reg = cenCodeVar
            AND (case when rpt_m.package_Code is null then '%' else rpt_m.package_Code end)
                      LIKE (CASE WHEN packageCodeVar IS NOT NULL THEN packageCodeVar ELSE '%' END)
            AND((case when rpt_m.sub_Type is null then '%' else rpt_m.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('FDN')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END)
            OR(case when rpt_m.sub_Type is null then '%' else rpt_m.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('MDT')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END))
            AND TRUNC(rpt_m.sum_month) >= TRUNC(TO_DATE(fromDateVar, formatDateVar))
            AND TRUNC(rpt_m.sum_month) <= TRUNC(TO_DATE(toDateVar, formatDateVar))
            AND (rpt_m.district_code_reg IN (SELECT ua.code FROM UserAreaACL ua WHERE ua.userId = userIdVar AND flag = 0)
                  OR 'ADMIN_OR_CENTER' = RoleVar
                  OR rpt_m.district_code_reg IN (SELECT avw.district_Code FROM Area_vw avw WHERE EXISTS
                        (SELECT 1 FROM UserAreaACL ua WHERE ua.userId = userIdVar AND avw.branch_Code = ua.code AND flag = 1)))
    GROUP BY Sub_Type, Package_Code, EXTRACT(MONTH FROM rpt_m.Sum_Month), a.BRANCH_CODE
    ORDER BY Sub_Type, Package_Code, a.BRANCH_CODE
    )
    LOOP
      tmpObject.Sub_Type := e.Sub_Type;
      tmpObject.Package_Code := e.Package_Code;
      tmpObject.Branch_code := e.Branch_code;
      tmpObject.Amount := e.Amount;
      tmpObject.MonthVal := e.MonthVal;
      PIPE ROW(tmpObject);
    END LOOP;
    RETURN;
  END;

  FUNCTION queryReport103B(cenCodeVar VARCHAR, fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, packageCodeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR)
    RETURN report103BTable PIPELINED
  AS
    tmpObject report103BType;
  BEGIN
    FOR e IN(
    SELECT rpt_m.Sub_Type, rpt_m.Package_Code, a.BRANCH_CODE, EXTRACT(MONTH FROM rpt_m.Sum_Month) as Monthval, SUM(Amount) as Amount
    FROM RPT_Sum_Sub_monthly rpt_m
    LEFT JOIN Area_vw a
      ON a.District_code = rpt_m.District_code_payment
      WHERE rpt_m.sum_data_type = 'CORP_PTM' AND rpt_m.cen_code_payment = cenCodeVar
        AND(case when rpt_m.package_Code is null then '%' else rpt_m.package_Code end)
                  LIKE (CASE WHEN packageCodeVar IS NOT NULL THEN packageCodeVar ELSE '%' END)
        AND((case when rpt_m.sub_Type is null then '%' else rpt_m.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('FDN')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END)
            OR(case when rpt_m.sub_Type is null then '%' else rpt_m.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('MDT')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END))
        AND TRUNC(rpt_m.sum_month) >= TRUNC(TO_DATE(fromDateVar, formatDateVar))
        AND TRUNC(rpt_m.sum_month) <= TRUNC(TO_DATE(toDateVar, formatDateVar))
        AND (rpt_m.district_code_payment IN (SELECT ua.code FROM UserAreaACL ua WHERE ua.userId = userIdVar AND flag = 0)
                  OR 'ADMIN_OR_CENTER' = RoleVar
                  OR rpt_m.district_code_payment IN (SELECT avw.district_Code FROM Area_vw avw WHERE EXISTS
                        (SELECT 1 FROM UserAreaACL ua WHERE ua.userId = userIdVar AND avw.branch_Code = ua.code AND flag = 1)))
    GROUP BY Sub_Type, Package_Code, EXTRACT(MONTH FROM rpt_m.Sum_Month), a.BRANCH_CODE
    ORDER BY Sub_Type, Package_Code, a.BRANCH_CODE
    )
    LOOP
      tmpObject.Sub_Type   := e.Sub_Type;
      tmpObject.Package_Code := e.Package_Code;
      tmpObject.Branch_code := e.Branch_code;
      tmpObject.Amount := e.Amount;
      tmpObject.MonthVal    := e.MonthVal;
      PIPE ROW(tmpObject);
    END LOOP;
    RETURN;
  END;

  FUNCTION queryReport103C(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, subTypeVar VARCHAR)
    RETURN report103CTable PIPELINED
  AS
    tmpObject report103CType;
  BEGIN
    FOR e IN
    (SELECT rpt_m.Sub_Type, rpt_m.Package_Code, Cen_code_payment, EXTRACT(MONTH FROM rpt_m.Sum_Month) as Monthval, SUM(Amount) as Amount
      FROM RPT_Sum_Sub_monthly rpt_m
      WHERE rpt_m.sum_data_type = 'CORP_PTM' AND ((case when rpt_m.sub_Type is null then '%' else rpt_m.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('FDN')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END)
            OR(case when rpt_m.sub_Type is null then '%' else rpt_m.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('MDT')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END))
            AND TRUNC(rpt_m.sum_month) >= TRUNC(TO_DATE(fromDateVar, formatDateVar))
            AND TRUNC(rpt_m.sum_month) <= TRUNC(TO_DATE(toDateVar, formatDateVar))
      GROUP BY Sub_Type, Package_Code, Cen_code_payment, EXTRACT(MONTH FROM rpt_m.Sum_Month)
      ORDER BY Sub_Type, Package_Code
    )
    LOOP
      tmpObject.Sub_Type   := e.Sub_Type;
      tmpObject.Package_Code := e.Package_Code;
      tmpObject.Cen_Code := e.Cen_code_payment;
      tmpObject.Amount := e.Amount;
      tmpObject.MonthVal    := e.MonthVal;
      PIPE ROW(tmpObject);
    END LOOP;
    RETURN;
  END;
  FUNCTION queryReport104(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, branchCodeVar VARCHAR, channelTypeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR)
    RETURN report104Table PIPELINED
  AS
    tmpObject report104Type;
  BEGIN
    FOR e IN
    (
      SELECT a.branch_code, a.branch_name, rpt_d.code, rpt_d.name,
            DECODE(rpt_m.sub_Type, 'FDN', 'FDN', 'MDT', 'DATA', 'GOLD', 'GOLD') as sub_Type,
            EXTRACT(MONTH FROM rpt_m.Sum_Month) as Monthval, sum(amount) as Amount,
            rpt_m.cen_code_reg, rpt_m.cen_code_payment
     FROM RPT_Sum_Sub_Monthly rpt_m, Area_vw a,
     (SELECT *
          FROM rpt_ap_domain
         WHERE TYPE = 'CHANNEL_TYPE' AND status = 1) rpt_d
     WHERE rpt_m.sum_data_type = 'CORP_PTM' AND rpt_m.channel_type = rpt_d.code(+) AND a.district_code(+) = rpt_m.district_code_reg
          AND(case when a.branch_Code is null then '%' else a.branch_Code end)
                  LIKE (CASE WHEN branchCodeVar IS NOT NULL THEN branchCodeVar ELSE '%' END)
          AND(case when rpt_d.Code is null then '%' else rpt_d.Code end)
                  LIKE (CASE WHEN channelTypeVar IS NOT NULL THEN channelTypeVar ELSE '%' END)
          AND((case when rpt_m.sub_Type is null then '%' else rpt_m.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('FDN')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END)
          OR(case when rpt_m.sub_Type is null then '%' else rpt_m.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('MDT')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END))
          AND TRUNC(rpt_m.sum_month) >= TRUNC(TO_DATE(fromDateVar, formatDateVar))
          AND TRUNC(rpt_m.sum_month) <= TRUNC(TO_DATE(toDateVar, formatDateVar))
          AND (rpt_m.district_code_reg IN (SELECT ua.code FROM UserAreaACL ua WHERE ua.userId = userIdVar AND flag = 0)
                  OR 'ADMIN_OR_CENTER' = RoleVar
                  OR rpt_m.district_code_reg IN (SELECT avw.district_Code FROM Area_vw avw WHERE EXISTS
                        (SELECT 1 FROM UserAreaACL ua WHERE ua.userId = userIdVar AND avw.branch_Code = ua.code AND flag = 1)))
     GROUP BY a.branch_code, a.branch_name, rpt_d.code, rpt_d.name, rpt_m.sub_type,
              EXTRACT(MONTH FROM rpt_m.Sum_Month), rpt_m.cen_code_reg, rpt_m.cen_code_payment
     ORDER BY rpt_m.cen_code_reg, a.branch_code, rpt_d.code, rpt_m.sub_type
    )
    LOOP
      tmpObject.Branch_Code   := e.Branch_Code;
      tmpObject.Branch_Name   := e.Branch_Name;
      tmpObject.Channel_Type   := e.code;
      tmpObject.Channel_Name   := e.name;
      tmpObject.Sub_Type   := e.Sub_Type;
      tmpObject.Amount := e.Amount;
      tmpObject.MonthVal    := e.MonthVal;
      tmpObject.cenCodeReg    := e.cen_code_reg;
      tmpObject.cenCodePayment    := e.Cen_code_payment;
      PIPE ROW(tmpObject);
    END LOOP;
    RETURN;
  END;

  FUNCTION queryReport105(statusVar NUMBER, quotatypeVar VARCHAR, fromDateVar VARCHAR, toDateVar VARCHAR,
                          formatDateVar VARCHAR, branchCodeVar VARCHAR, districtCodeVar VARCHAR,  teamIdVar VARCHAR, empCodeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR)
    RETURN  report105Table PIPELINED
  AS tmpObject report105Type;
  BEGIN
    FOR e IN (
      SELECT  a.branch_Code,
        a.branch_Name,
        t.teamCode,
        t.teamName,
        a.district_Code,
        a.district_Name,
        emp.emp_Code,
        emp.emp_Name,
        emp.sta_Date,
        rpt_m.QUOTA_TYPE,
        EXTRACT(MONTH FROM rpt_m.sum_Month) as monthVal,
        SUM(rpt_m.amount) as amount,
        rpt_m.cen_code_reg, rpt_m.cen_code_payment
        ,emp.SHOP_CODE
        FROM RPT_SUM_SUB_MONTHLY rpt_m
        LEFT JOIN ((SELECT DISTINCT e.emp_Code, e.emp_Name, e.sta_Date, e.SHOP_CODE  FROM EMPLOYEE_VW e, SHOP_VW s
                      where s.cen_code != '2' AND e.SHOP_CODE = s.SHOP_CODE) UNION
                    (SELECT DISTINCT e1.emp_Code, e1.emp_Name, e1.sta_Date, e1.SHOP_CODE  FROM EMPLOYEE_VW e1, SHOP_VW s1
                      where s1.cen_code = '2' AND e1.SHOP_CODE = s1.SHOP_CODE
                            AND (e1.end_date is null
                                  OR (e1.end_date >= TO_DATE(fromDateVar, formatDateVar)
                                  AND e1.end_date <= TO_DATE(toDateVar, formatDateVar)))
                      )) emp ON rpt_m.EMP_CODE = emp.EMP_CODE AND emp.SHOP_CODE = rpt_m.SHOP_CODE
        LEFT JOIN AREA_VW a ON a.DISTRICT_CODE = rpt_m.DISTRICT_CODE_REG
        LEFT JOIN (SELECT DISTINCT tm1.TEAMID, tm1.DISTRICTCODE FROM TEAMMANAGER tm1 WHERE tm1.endDate >= CURRENT_DATE AND tm1.endDate is null ) tm ON tm.DISTRICTCODE = rpt_m.DISTRICT_CODE_REG
        LEFT JOIN TEAM t ON t.TEAMID = tm.TEAMID
        LEFT JOIN (Select * From RPT_AP_DOMAIN d WHERE d.TYPE = quotatypeVar AND d.STATUS = statusVar )rpt_ad ON rpt_ad.CODE = rpt_m.QUOTA_TYPE
        WHERE rpt_m.sum_data_type = 'CORP_PTM'
          AND(case when a.branch_Code is null then '%' else a.branch_Code end)
                  LIKE (CASE WHEN branchCodeVar IS NOT NULL THEN branchCodeVar ELSE '%' END)
          AND(case when a.district_Code is null then '%' else a.district_Code end)
                  LIKE (CASE WHEN districtCodeVar IS NULL THEN '%' ELSE districtCodeVar END)
          AND(case when t.teamId is null then '%' else to_char(t.teamId) end)
                  LIKE (CASE WHEN teamIdVar IS NOT NULL THEN teamIdVar ELSE '%' END)
          AND(case when emp.emp_Code is null then '%' else emp.emp_Code end)
                  LIKE (CASE WHEN empCodeVar IS NOT NULL THEN empCodeVar ELSE '%' END)
          AND((case when rpt_m.sub_Type is null then '%' else rpt_m.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('FDN')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END)
            OR(case when rpt_m.sub_Type is null then '%' else rpt_m.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('MDT')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END))
          AND TRUNC(rpt_m.sum_month) >= TRUNC(TO_DATE(fromDateVar, formatDateVar))
          AND TRUNC(rpt_m.sum_month) <= TRUNC(TO_DATE(toDateVar, formatDateVar))
          AND (rpt_m.district_code_reg IN (SELECT ua.code FROM UserAreaACL ua WHERE ua.userId = userIdVar AND flag = 0)
                  OR 'ADMIN_OR_CENTER' = RoleVar
                  OR rpt_m.district_code_reg IN (SELECT avw.district_Code FROM Area_vw avw WHERE EXISTS
                        (SELECT 1 FROM UserAreaACL ua WHERE ua.userId = userIdVar AND avw.branch_Code = ua.code AND flag = 1)))
        GROUP BY rpt_m.cen_code_reg, a.branch_Code, a.branch_Name,  t.teamCode, t.teamName, a.district_Code, a.district_Name,
        emp.emp_Code, emp.sta_Date, emp.emp_Name,
                  rpt_m.QUOTA_TYPE, EXTRACT(MONTH FROM rpt_m.sum_Month), rpt_m.cen_code_payment
                  , emp.SHOP_CODE
        ORDER BY rpt_m.Cen_code_reg, a.branch_Code, t.teamCode, a.district_Code
        , emp.emp_Code, emp.sta_Date, emp.emp_Name
    )
    LOOP
      tmpObject.branch_Code := e.branch_Code;
      tmpObject.branch_Name := e.branch_Name;
      tmpObject.teamCode := e.teamCode;
      tmpObject.teamName := e.teamName;
      tmpObject.district_Code := e.district_Code;
      tmpObject.district_Name := e.district_Name;
      tmpObject.emp_Code := e.emp_Code;
      tmpObject.emp_Name := e.emp_Name;
      tmpObject.sta_Date := e.sta_Date;
      tmpObject.QUOTA_TYPE := e.QUOTA_TYPE;
      tmpObject.monthVal := e.monthVal;
      tmpObject.amount := e.amount;
      tmpObject.cenCodeReg := e.Cen_code_reg;
      tmpObject.cenCodePayment := e.Cen_code_payment;
      tmpObject.shopCode := e.SHOP_CODE;
      PIPE ROW(tmpObject);
    END LOOP;
    RETURN;
  END;

  FUNCTION queryReport106(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, branchCodeVar VARCHAR, subTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR) RETURN  report106Table PIPELINED
  AS tmpObject report106Type;
  BEGIN
    FOR e IN (
      SELECT  a.branch_code as branch_code,
              rpt_sc.TIN ,
              rpt_sc.BUS_PERMIT_NO,
              rpt_sc.CORP_NAME,
              rpt_sc.ADDRESS,
              rpt_sc.PAY_FULL_ADDRESS,
              rpt_sc.DISTRICT_CODE_REG,
              (select a2.branch_code from AREA_VW a2 where a2.DISTRICT_CODE = rpt_sc.DISTRICT_CODE_REG ) as branch_code_reg  ,
              rpt_sc.EMP_CODE,
              EXTRACT(MONTH FROM rpt_sc.SUM_MONTH) as monthVal,
              SUM(AMOUNT) as amount
      FROM RPT_SUM_CORP_MONTHLY rpt_sc
      LEFT JOIN AREA_VW a
      ON rpt_sc.district_code_payment = a.district_Code
      WHERE rpt_sc.cen_code_payment = 2
          AND (case when a.branch_Code is null then '%' else a.branch_Code end)
                  LIKE (CASE WHEN branchCodeVar IS NOT NULL THEN branchCodeVar ELSE '%' END)
          AND TRUNC(rpt_sc.sum_month) >= TRUNC(TO_DATE(fromDateVar, formatDateVar))
                AND TRUNC(rpt_sc.sum_month) <= TRUNC(TO_DATE(toDateVar, formatDateVar))
          AND((case when rpt_sc.sub_Type is null then '%' else rpt_sc.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('FDN')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END)
            OR(case when rpt_sc.sub_Type is null then '%' else rpt_sc.sub_Type end)
                  LIKE (CASE
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'DATA' THEN ('MDT')
                          WHEN subTypeVar IS NOT NULL AND subTypeVar = 'GOLD' THEN ('GOLD')
                          ELSE '%' END))
          AND (rpt_sc.district_code_payment IN (SELECT ua.code FROM UserAreaACL ua WHERE ua.userId = userIdVar AND flag = 0)
                  OR 'ADMIN_OR_CENTER' = RoleVar
                  OR rpt_sc.district_code_payment IN (SELECT avw.district_Code FROM Area_vw avw WHERE EXISTS
                        (SELECT 1 FROM UserAreaACL ua WHERE ua.userId = userIdVar AND avw.branch_Code = ua.code AND flag = 1)))
      GROUP BY a.branch_code, rpt_sc.TIN , rpt_sc.BUS_PERMIT_NO, rpt_sc.CORP_NAME, rpt_sc.ADDRESS,
      rpt_sc.PAY_FULL_ADDRESS, rpt_sc.DISTRICT_CODE_REG, rpt_sc.EMP_CODE, EXTRACT(MONTH FROM rpt_sc.SUM_MONTH)
      ORDER BY a.branch_code
    )
    LOOP
      tmpObject.branchCode := e.branch_code;
      tmpObject.mst := e.TIN;
      tmpObject.gpkd := e.BUS_PERMIT_NO;
      tmpObject.tendn := e.CORP_NAME;
      tmpObject.address := e.ADDRESS;
      tmpObject.pay_full_address := e.PAY_FULL_ADDRESS;
      tmpObject.districtCode := e.DISTRICT_CODE_REG;
      tmpObject.branchCodeReg := e.branch_code_reg;
      tmpObject.empCode := e.EMP_CODE;
      tmpObject.monthVal := e.monthVal;
      tmpObject.amount := e.amount;
      PIPE ROW(tmpObject);
    END LOOP;
    RETURN;
  END;


 FUNCTION queryReport108(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR,
                          branchCodeVar VARCHAR, packageLevelIdVar VARCHAR, packageGroupIdVar VARCHAR, fieldTypeVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR)
    RETURN report108Table PIPELINED
  AS
    tmpObject report108Type;
  BEGIN
      FOR e IN
      (
        SELECT a.branch_code, a.branch_name, pl.packageName, pl.packageCode, pg.packageGroupName, pg.packageGroupCode, rpt_d.package_Code,
                EXTRACT(DAY FROM rpt_d.sum_date) as dailyVal, rpt_d.field_type, SUM(rpt_d.amount) as amount
        FROM rpt_sum_sub_vas_daily rpt_d
        LEFT JOIN packageGroupPackage pgp ON pgp.pck_code = rpt_d.package_Code
        LEFT JOIN packagelevel pl ON pl.packageLevelId = pgp.packagelevelId
        LEFT JOIN packageGroup pg ON pg.packageGroupId = pgp.packageGroupId
        LEFT JOIN area_vw a
          ON (rpt_d.PAYMENT_TYPE = 'MC' and a.DISTRICT_CODE = rpt_d.DISTRICT_CODE_REG) OR
         (rpt_d.PAYMENT_TYPE = 'MF' and a.DISTRICT_CODE = rpt_d.DISTRICT_CODE_PAYMENT)
          WHERE (case when a.branch_Code is null then '%' else a.branch_Code end)
                  LIKE (CASE WHEN branchCodeVar IS NOT NULL THEN branchCodeVar ELSE '%' END)
          AND(case when pl.packageLevelId is null then '%' else to_char(pl.packageLevelId) end)
                  LIKE (CASE WHEN packageLevelIdVar IS NULL THEN '%' ELSE packageLevelIdVar END)
          AND(case when pg.packageGroupId is null then '%' else to_char(pg.packageGroupId) end)
                  LIKE (CASE WHEN packageGroupIdVar IS NOT NULL THEN packageGroupIdVar ELSE '%' END)
          AND TRUNC(rpt_d.sum_date) >= TRUNC(TO_DATE(fromDateVar, formatDateVar))
          AND TRUNC(rpt_d.sum_date) <= TRUNC(TO_DATE(toDateVar, formatDateVar))
           AND((case when rpt_d.field_type is null then '%' else rpt_d.field_type end)
                  LIKE (CASE
                          WHEN fieldTypeVar IS NOT NULL AND fieldTypeVar = 'SLTB' THEN ('DKM')
                          WHEN fieldTypeVar IS NOT NULL AND fieldTypeVar = 'DTTT' THEN ('DTTT')
                          ELSE '%' END)
            OR(case when rpt_d.field_type is null then '%' else rpt_d.field_type end)
                  LIKE (CASE
                          WHEN fieldTypeVar IS NOT NULL AND fieldTypeVar = 'SLTB' THEN ('GH')
                          WHEN fieldTypeVar IS NOT NULL AND fieldTypeVar = 'DTTT' THEN ('DTTT')
                          ELSE '%' END)
            OR(case when rpt_d.field_type is null then '%' else rpt_d.field_type end)
                  LIKE (CASE
                          WHEN fieldTypeVar IS NOT NULL AND fieldTypeVar = 'SLTB' THEN ('HUY')
                          WHEN fieldTypeVar IS NOT NULL AND fieldTypeVar = 'DTTT' THEN ('DTTT')
                          ELSE '%' END))
            AND (CASE rpt_d.PAYMENT_TYPE WHEN 'MC' THEN rpt_d.district_code_reg WHEN 'MF' THEN rpt_d.district_code_payment END
                      IN (SELECT ua.code FROM UserAreaACL ua WHERE ua.userId = userIdVar AND flag = 0)
                  OR 'ADMIN_OR_CENTER' = RoleVar
                  OR CASE rpt_d.PAYMENT_TYPE WHEN 'MC' THEN rpt_d.district_code_reg WHEN 'MF' THEN rpt_d.district_code_payment END
                      IN (SELECT avw.district_Code FROM Area_vw avw WHERE EXISTS
                        (SELECT 1 FROM UserAreaACL ua WHERE ua.userId = userIdVar AND avw.branch_Code = ua.code AND flag = 1)))
        GROUP BY a.branch_code, a.branch_name, pl.packageName, pl.packageCode, pg.packageGroupName, pg.packageGroupCode, rpt_d.package_Code,
                EXTRACT(DAY FROM rpt_d.sum_date), rpt_d.field_type
        ORDER BY a.branch_code, a.branch_name, pl.packageName, pg.packageGroupName, rpt_d.package_Code,
                EXTRACT(DAY FROM rpt_d.sum_date), rpt_d.field_type
      )
      LOOP
        tmpObject.Branch_Code   := e.Branch_Code;
        tmpObject.Branch_Name   := e.Branch_Name;
        tmpObject.packageLevelCode := e.packageCode;
        tmpObject.packageLevelName := e.packageName;
        tmpObject.packageGroupCode := e.packageGroupCode;
        tmpObject.packageGroupName := e.packageGroupName;
        tmpObject.packageCode   := e.package_Code;
        tmpObject.field_type   := e.field_type;
        tmpObject.dailyVal := e.dailyVal;
        tmpObject.amount    := e.amount;
        PIPE ROW(tmpObject);
      END LOOP;
      RETURN;
  END;

  FUNCTION queryReport109(fromDateVar VARCHAR, toDateVar VARCHAR, formatDateVar VARCHAR, branchCodeVar VARCHAR,
  fieldTypeVar VARCHAR, packageLevelIdVar VARCHAR, packageGroupIdVar VARCHAR, userIdVar NUMBER, RoleVar VARCHAR) RETURN report109Table PIPELINED
  AS tmpObject report109Type;
  BEGIN
  FOR e IN(
        SELECT a.branch_code, a.branch_name,pl.PACKAGECODE, pl.PACKAGENAME, pg.PACKAGEGROUPCODE, pg.PACKAGEGROUPNAME, rpt_sv.PACKAGE_CODE,
        rpt_sv.FIELD_TYPE, EXTRACT(MONTH FROM rpt_sv.SUM_MONTH) as monthVal, SUM(AMOUNT) as amount
      FROM RPT_SUM_SUB_VAS_MONTHLY rpt_sv
      LEFT JOIN PACKAGEGROUPPACKAGE pgp
      ON pgp.PCK_CODE = rpt_sv.PACKAGE_CODE
      LEFT JOIN PACKAGEGROUP pg
      ON pg.PACKAGEGROUPID = pgp.PACKAGEGROUPID
      LEFT JOIN PACKAGELEVEL pl
      ON pl.PACKAGELEVELID =  pgp.PACKAGELEVELID
      LEFT JOIN AREA_VW a
      ON (rpt_sv.PAYMENT_TYPE = 'MC' and a.DISTRICT_CODE = rpt_sv.DISTRICT_CODE_REG) OR
         (rpt_sv.PAYMENT_TYPE = 'MF' and a.DISTRICT_CODE = rpt_sv.DISTRICT_CODE_PAYMENT)
      WHERE TRUNC(rpt_sv.SUM_MONTH) >= TRUNC(TO_DATE(fromDateVar, formatDateVar))
                AND TRUNC(rpt_sv.SUM_MONTH) <= TRUNC(TO_DATE(toDateVar, formatDateVar))
                AND(case when a.branch_Code is null then '%' else a.branch_Code end)
                  LIKE (CASE WHEN branchCodeVar IS NOT NULL THEN branchCodeVar ELSE '%' END)
                AND(case when pl.packageLevelId is null then '%' else to_char(pl.packageLevelId) end)
                  LIKE (CASE WHEN packageLevelIdVar IS NULL THEN '%' ELSE packageLevelIdVar END)
                AND(case when pg.packageGroupId is null then '%' else to_char(pg.packageGroupId) end)
                  LIKE (CASE WHEN packageGroupIdVar IS NOT NULL THEN packageGroupIdVar ELSE '%' END)
                AND((case when rpt_sv.FIELD_TYPE is null then '%' else rpt_sv.FIELD_TYPE end)
                  LIKE (CASE
                          WHEN fieldTypeVar IS NOT NULL AND fieldTypeVar = 'SLTB' THEN ('DKM')
                          WHEN fieldTypeVar IS NOT NULL AND fieldTypeVar = 'DTTT' THEN ('DTTT')
                          ELSE '%' END)
                OR(case when rpt_sv.FIELD_TYPE is null then '%' else rpt_sv.FIELD_TYPE end)
                  LIKE (CASE
                          WHEN fieldTypeVar IS NOT NULL AND fieldTypeVar = 'SLTB' THEN ('GH')
                          WHEN fieldTypeVar IS NOT NULL AND fieldTypeVar = 'DTTT' THEN ('DTTT')
                          ELSE '%' END)
                OR(case when rpt_sv.FIELD_TYPE is null then '%' else rpt_sv.FIELD_TYPE end)
                  LIKE (CASE
                          WHEN fieldTypeVar IS NOT NULL AND fieldTypeVar = 'SLTB' THEN ('HUY')
                          WHEN fieldTypeVar IS NOT NULL AND fieldTypeVar = 'DTTT' THEN ('DTTT')
                          ELSE '%' END))
            AND (CASE rpt_sv.PAYMENT_TYPE WHEN 'MC' THEN rpt_sv.district_code_reg WHEN 'MF' THEN rpt_sv.district_code_payment END
                      IN (SELECT ua.code FROM UserAreaACL ua WHERE ua.userId = userIdVar AND flag = 0)
                  OR 'ADMIN_OR_CENTER' = RoleVar
                  OR CASE rpt_sv.PAYMENT_TYPE WHEN 'MC' THEN rpt_sv.district_code_reg WHEN 'MF' THEN rpt_sv.district_code_payment END
                      IN (SELECT avw.district_Code FROM Area_vw avw WHERE EXISTS
                        (SELECT 1 FROM UserAreaACL ua WHERE ua.userId = userIdVar AND avw.branch_Code = ua.code AND flag = 1)))
      GROUP BY a.branch_code, a.branch_name,pl.PACKAGECODE, pl.PACKAGENAME, pg.PACKAGEGROUPCODE, pg.PACKAGEGROUPNAME, rpt_sv.PACKAGE_CODE,
        rpt_sv.FIELD_TYPE, EXTRACT(MONTH FROM rpt_sv.SUM_MONTH)
      ORDER BY a.branch_code, a.branch_name,pl.PACKAGECODE, pl.PACKAGENAME, pg.PACKAGEGROUPCODE, pg.PACKAGEGROUPNAME, rpt_sv.PACKAGE_CODE,
        rpt_sv.FIELD_TYPE, EXTRACT(MONTH FROM rpt_sv.SUM_MONTH)
  )
  LOOP
      tmpObject.branchCode := e.branch_code;
      tmpObject.branchName := e.branch_name;
      tmpObject.packageLevelCode := e.PACKAGECODE;
      tmpObject.packageLevelName := e.PACKAGENAME;
       tmpObject.packageGroupCode := e.PACKAGEGROUPCODE;
      tmpObject.packageGroupName := e.PACKAGEGROUPNAME;
      tmpObject.packageCode := e.PACKAGE_CODE;
      tmpObject.fieldType := e.FIELD_TYPE;
      tmpObject.monthVal := e.monthVal;
      tmpObject.amount := e.amount;
      PIPE ROW(tmpObject);
  END LOOP;
  RETURN;
  END;

END pck_query_rpt;