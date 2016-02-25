-- CREATE PACKAGE SPECS
CREATE OR REPLACE PACKAGE UserPckg AS
TYPE user_ref_cursor IS REF CURSOR RETURN users%ROWTYPE;
PROCEDURE GetUserById
(
  user_Id IN users.userId%TYPE,
  user_ref OUT user_ref_cursor);

TYPE Report101RecTyp IS RECORD (userId NUMBER(24,0), userName VARCHAR(100));
TYPE Report101RecTyps IS TABLE OF Report101RecTyp;

FUNCTION GetUserByUserName(user_Name VARCHAR) RETURN Report101RecTyps PIPELINED;

TYPE report101Type IS RECORD(
userId NUMBER(24,0), userName VARCHAR(100), email VARCHAR(100)
);
TYPE report101Table IS TABLE OF report101Type;
FUNCTION queryReport101(user_Name VARCHAR) RETURN report101Table PIPELINED;
END UserPckg;
/
-- CREATE PACKAGE BODY: There are 2 BODY that wrote below. Just use one in your case.
-- Return Only One Row
CREATE OR REPLACE PACKAGE BODY UserPckg AS
  PROCEDURE GetUserById
  (user_Id IN users.userId%TYPE,
  user_ref OUT user_ref_cursor) IS
  BEGIN
    OPEN user_ref FOR
      SELECT userId, userName, email, password, status, departmentId, subDepartmentId, createdDate, modifiedDate, displayName, userGroupId, lastLoginDatTime, isLDAP FROM Users WHERE userId = user_Id;
  END GetUserById;

  FUNCTION GetUserByUserName(user_Name VARCHAR) RETURN Report101RecTyps PIPELINED
  AS
    Report101RS Report101RecTyp;
  BEGIN
      SELECT userId, userName INTO Report101RS FROM Users WHERE userName = user_Name ORDER BY userName DESC;
      PIPE ROW(Report101RS);
  END GetUserByUserName;
END UserPckg;
/
-- Return multiple row
CREATE OR REPLACE PACKAGE BODY UserPckg AS
FUNCTION GetUserByUserName(user_Name VARCHAR) RETURN Report101RecTyps PIPELINED
  AS
    Report101RS Report101RecTyp;
  BEGIN
      SELECT userId, userName INTO Report101RS FROM Users WHERE userName = user_Name ORDER BY userName DESC;
      PIPE ROW(Report101RS);
  END GetUserByUserName;


  FUNCTION queryReport101(user_Name VARCHAR) RETURN report101Table PIPELINED
  AS tmpObject report101Type;
  BEGIN
    FOR e IN (SELECT userId, userName, email FROM Users)
    LOOP
      tmpObject.userId := e.userId;
      tmpObject.userName := e.userName;
      tmpObject.Email := e.Email;
      PIPE ROW(tmpObject);
    END LOOP;
    RETURN;
  END;
END UserPckg;

-- INVOKE
select * from Table(UserPckg.GetUserByUserName('admin'));
select * from Table(UserPckg.queryReport101('admin'));