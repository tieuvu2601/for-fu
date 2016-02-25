
package com.banvien.vmsreport.common;

import java.math.BigInteger;

public class Constants {
    /* *
     * Bcc recipients delimiter
     */
    public static final String DELIMITER = ",";
    public static final String EMAIL_DELIMITER = ";";
    public static final String SEPERATE = ":";
    /**
     * Sort direction constants
     */
    public static final String SORT_ASC = "2";
    public static final String SORT_DESC = "1";

    public static final int MAXPAGEITEMS = 20;

    public static final int REPORT_MAXPAGEITEMS = 100;

    public static final int MAXAUTOCOMPLETESEARCH = 5;


    //~ Static fields/initializers =============================================

    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String VI_DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";
    public static final String DB_DATE_FORMAT = "YYYY-MM-DD";
    public static final String JAVA_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DBVMS_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * The Alphabet number for search query
     */
    public static final String ALPHABET_SEARCH_PREFIX = "^$^";
    /**
     * The name of the ResourceBundle used in this application
     */
    public static final String BUNDLE_KEY = "ApplicationResources";

    /**
     * File separator from System properties
     */
    public static final String FILE_SEP = System.getProperty("file.separator");

    /**
     * User home from System properties
     */
    public static final String USER_HOME = System.getProperty("user.home") + FILE_SEP;

    /**
     * The name of the configuration hashmap stored in application scope.
     */
    public static final String CONFIG = "appConfig";

    /**
     * Session scope attribute that holds the locale set by the user. By setting this key
     * to the same one that Struts uses, we get synchronization in Struts w/o having
     * to do extra work or have two session-level variables.
     */
    public static final String PREFERRED_LOCALE_KEY = "org.apache.struts2.action.LOCALE";

    /**
     * The request scope attribute that holds the list form
     */
    public static final String LIST_MODEL_KEY = "items";

    /**
     * The request scope attribute that holds the form
     */
    public static final String FORM_MODEL_KEY = "item";


    /**
     * The name of the Administrator role, as specified in web.xml
     */
    public static final String ADMIN_ROLE = "ADMIN";
    public static final String USER_ROLE = "NORMAL_USER";
    public static final String USER_PHONG_BAN_KHAC = "NVPBK";
    public static final String CENTER_ROLE = "CENTER_ROLE";

    public static final String HAS_GRANTED_DISTRICTS = "HAS_GRANTED_DISTRICTS";
    public static final String NO_PERMISSION_GRANTED = "NO_PERMISSION_GRANTED";

    /**
     * The name of the available roles list, common.a request-scoped attribute
     * when adding/editing common.a user.
     */
    public static final String AVAILABLE_ROLES = "availableRoles";

    /**
     * The name of the CSS Theme setting.
     */
    public static final String CSS_THEME = "csstheme";


    /**
     * Acegi security constants
     */

    public static final String ACEGI_SECURITY_FORM_USERNAME_KEY = "j_username";
    public static final String ACEGI_SECURITY_FORM_PASSWORD_KEY = "j_password";
    public static final String ACEGI_SECURITY_LAST_USERNAME_KEY = "ACEGI_SECURITY_LAST_USERNAME";


    /**
     * Cookie for web and content security
     */
    public static final String LOGIN_USER_ID_COOKIE = "j_loggined_userid";
    public static final String LOGIN_CHECKSUM = "j_loginned_checksum";
    public static final String LOGIN_ROLE_COOKIE = "j_role";

    /**
     * Spring Credential delimiter.
     */
    public static final String SECURITY_CREDENTIAL_DELIMITER = "${SEC_CRED}";


    /**
     * User status constants
     */
    public static final int USER_ACTIVE = 1;
    public static final int USER_INACTIVE = 0;

    public static final String GLOBAL_META_ROLE_PREFIX = "role_";
    public static final String REPORT_REMEMBER_ME_COOKIE_KEY = "REPORT_REMEMBER_ME_COOKIE_KEY";
    public static final String CHECKSUM_SECURITY_HASH = "VMS_REPORT_SEC_HASH";

    public static final String MESSAGE_RESPONSE_MODEL_KEY = "messageResponse";

    public static final String ACTION_DELETE = "delete";
    public static final String ACTION_DISABLE = "disable";
    public static final String ACTION_EXPORT = "export";
    public static final String ACTION_SEARCH = "search";
    public static final String INSERT_OR_UPDATE = "insert-update";
    public static final String INSERT_OR_UPDATE_PROFILE = "insert-update-profile";


    public static final String ALERT_TYPE = "alertType";

    public static final String LOGON_ROLE = "LOGON";

    /*Roles*/
    public static final String MANAGE_USER_FULL = "MANAGE_USER_FULL";
    public static final String MANAGE_USER_ADD = "MANAGE_USER_ADD";
    public static final String MANAGE_USER_EDIT = "MANAGE_USER_EDIT";
    public static final String MANAGE_USER_VIEW = "MANAGE_USER_VIEW";
    public static final String MANAGE_USER_DELETE = "MANAGE_USER_DELETE";
    public static final String MANAGE_USER_PERMISSION = "MANAGE_USER_PERMISSION";

    public static final String MANAGE_USERGROUP_FULL = "MANAGE_USERGROUP_FULL";
    public static final String MANAGE_USERGROUP_ADD = "MANAGE_USERGROUP_ADD";
    public static final String MANAGE_USERGROUP_EDIT = "MANAGE_USERGROUP_EDIT";
    public static final String MANAGE_USERGROUP_VIEW = "MANAGE_USERGROUP_VIEW";
    public static final String MANAGE_USERGROUP_PERMISSION = "MANAGE_USERGROUP_PERMISSION";

    public static final String MANAGE_ROLE_FULL = "MANAGE_ROLE_FULL";
    public static final String MANAGE_ROLE_ADD = "MANAGE_ROLE_ADD";
    public static final String MANAGE_ROLE_EDIT = "MANAGE_ROLE_EDIT";
    public static final String MANAGE_ROLE_VIEW = "MANAGE_ROLE_VIEW";
    public static final String MANAGE_ROLE_DELETE = "MANAGE_ROLE_DELETE";
    public static final String MANAGE_ROLE_PERMISSION = "MANAGE_ROLE_PERMISSION";

    public static final String MANAGE_TEAM_ADD = "MANAGE_TEAM_ADD";
    public static final String MANAGE_TEAM_EDIT = "MANAGE_TEAM_EDIT";
    public static final String MANAGE_TEAM_VIEW = "MANAGE_TEAM_VIEW";
    public static final String MANAGE_TEAM_DELETE = "MANAGE_TEAM_DELETE";
    public static final String MANAGE_TEAM_FULL = "MANAGE_TEAM_FULL";
    public static final String MANAGE_TEAM_DISTRICT = "MANAGE_TEAM_DISTRICT";

    public static final String MANAGE_PACKAGE_FULL = "MANAGE_PACKAGE_FULL";
    public static final String MANAGE_PACKAGE_ADD = "MANAGE_PACKAGE_ADD";
    public static final String MANAGE_PACKAGE_EDIT = "MANAGE_PACKAGE_EDIT";
    public static final String MANAGER_PACKAGE_VIEW = "MANAGER_PACKAGE_VIEW";
    public static final String MANAGE_PACKAGE_DELETE = "MANAGE_PACKAGE_DELETE";
    public static final String MANAGE_PACKAGE_PACKAGEGROUP = "MANAGE_PACKAGE_PACKAGEGROUP";

    public static final String MANAGE_REPORT_101_FULL = "MANAGE_REPORT_101_FULL";
    public static final String MANAGE_REPORT_101_VIEW = "MANAGE_REPORT_101_VIEW";
    public static final String MANAGE_REPORT_101_EXPORT = "MANAGE_REPORT_101_EXPORT";

    public static final String MANAGE_REPORT_102_FULL = "MANAGE_REPORT_102_FULL";
    public static final String MANAGE_REPORT_102_VIEW = "MANAGE_REPORT_102_VIEW";
    public static final String MANAGE_REPORT_102_EXPORT = "MANAGE_REPORT_102_EXPORT";

    public static final String MANAGE_REPORT_103_FULL = "MANAGE_REPORT_103_FULL";
    public static final String MANAGE_REPORT_103_VIEW = "MANAGE_REPORT_103_VIEW";
    public static final String MANAGE_REPORT_103_EXPORT = "MANAGE_REPORT_103_EXPORT";

    public static final String MANAGE_REPORT_104_FULL = "MANAGE_REPORT_104_FULL";
    public static final String MANAGE_REPORT_104_VIEW = "MANAGE_REPORT_104_VIEW";
    public static final String MANAGE_REPORT_104_EXPORT = "MANAGE_REPORT_104_EXPORT";

    public static final String MANAGE_REPORT_105_FULL = "MANAGE_REPORT_105_FULL";
    public static final String MANAGE_REPORT_105_VIEW = "MANAGE_REPORT_105_VIEW";
    public static final String MANAGE_REPORT_105_EXPORT = "MANAGE_REPORT_105_EXPORT";

    public static final String MANAGE_REPORT_106_FULL = "MANAGE_REPORT_106_FULL";
    public static final String MANAGE_REPORT_106_VIEW = "MANAGE_REPORT_106_VIEW";
    public static final String MANAGE_REPORT_106_EXPORT = "MANAGE_REPORT_106_EXPORT";

    public static final String MANAGE_REPORT_107_FULL = "MANAGE_REPORT_107_FULL";
    public static final String MANAGE_REPORT_107_VIEW = "MANAGE_REPORT_107_VIEW";
    public static final String MANAGE_REPORT_107_EXPORT = "MANAGE_REPORT_107_EXPORT";

    public static final String MANAGE_REPORT_108_FULL = "MANAGE_REPORT_108_FULL";
    public static final String MANAGE_REPORT_108_VIEW = "MANAGE_REPORT_108_VIEW";
    public static final String MANAGE_REPORT_108_EXPORT = "MANAGE_REPORT_108_EXPORT";

    public static final String MANAGE_REPORT_109_FULL = "MANAGE_REPORT_109_FULL";
    public static final String MANAGE_REPORT_109_VIEW = "MANAGE_REPORT_109_VIEW";
    public static final String MANAGE_REPORT_109_EXPORT = "MANAGE_REPORT_109_EXPORT";

    public static final String MANAGE_DEPARTMENT_FULL = "MANAGE_DEPARTMENT_FULL";
    public static final String MANAGE_DEPARTMENT_ADD = "MANAGE_DEPARTMENT_ADD";
    public static final String MANAGE_DEPARTMENT_EDIT = "MANAGE_DEPARTMENT_EDIT";
    public static final String MANAGE_DEPARTMENT_VIEW = "MANAGE_DEPARTMENT_VIEW";
    public static final String MANAGE_DEPARTMENT_DELETE = "MANAGE_DEPARTMENT_DELETE";



    public static final Integer IS_NOT_MANAGING = 0;
    public static final Integer IS_MANAGING = 1;

    /*LDAP*/
    public static final int USER_LOCAL = 0;
    public static final int USER_LDAP = 1;

    /*Team*/
    public static final int TEAM_ACTIVE = 1;
    public static final int TEAM_INACTIVE = 0;
    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;

    public static final int RP7_TANG = 1;
    public static final int RP7_GIAM = 0;

    public static final int IS_NOT_DISTRICT = 1;
    public static final int IS_DISTRICT = 0;

//    CenCode
    public static final String CENCODE_CTY_II = "2";
    public static final String CENNAME = "Công Ty";

//    month
    public static final Integer JAN = 1;
    public static final Integer FEB = 2;
    public static final Integer MAR = 3;
    public static final Integer APR = 4;
    public static final Integer MAY = 5;
    public static final Integer JUN = 6;
    public static final Integer JUL = 7;
    public static final Integer AUG = 8;
    public static final Integer SEP = 9;
    public static final Integer OTC = 10;
    public static final Integer NOV = 11;
    public static final Integer DEC = 12;

//    SUB TYPE
    public static final String CDT_TYPE = "CDT";
    public static final String CHCT_TYPE = "CHCT";
    public static final String DTRR_TYPE = "DTRR";
    public static final String MSTT_TYPE = "MSTT";
    public static final String CGCT_TYPE = "CGCT";
    public static final String HT_TYPE = "HT";
    //    BRANCH
    public static final String HCM1 = "2MFHCM1";
    public static final String HCM2 = "2MFHCM2";

    //    FIELD TYPE
    public static final String DKM_TYPE = "DKM";
    public static final String GH_TYPE = "GH";
    public static final String HUY_TYPE = "HUY";
    public static final String DTTT_TYPE = "DTTT";
    public static final String SLTB_TYPE = "SLTB";

    // QUOTA TYPE
    public static final String IN_TYPE = "IN";
    public static final String OUT_TYPE = "OUT";

    //CTY
    public static final String CTY1 = "1";
    public static final String CTY2 = "2";
    public static final String CTY3 = "3";
    public static final String CTY4 = "4";
    public static final String CTY5 = "5";
    public static final String CTY6 = "6";
    public static final String CTY7 = "7";
    public static final String CTY8 = "8";
    public static final String CTY9 = "9";


    public static final String HEADER_BG_COLOR = "BLUE";
    public static final String HEADER_RED_BG_COLOR = "RED";
    public static final String HEADER_TEXT_COLOR = "WHITE";
    public static final String HEADER_BRANCH_TEXT_COLOR = "LIGHT_BLUE";
    public static final String DVDN = "DVDN";
    public static final String TBC = "TBC";
    public static final String TCTY = "TCTY";
    public static final String ToanCTY = "ToanCTY";
    public static final String ADMIN_OR_CENTER_ROLE = "ADMIN_OR_CENTER";
    public static final String NOT_ADMIN_OR_CENTER_ROLE = "NOT_ADMIN_OR_CENTER";
    public static final String LIST_TOTAL_KEY = "totalItems";

    public static String TOTAL = "TỔNG";
    public static String OTHER = "#N/A";
    public static String COMPARE = "COMPARE";
    public static String COMPARE_BRANCH = "COMPARE_BRANCH";
    public static String ALL = "ALL";
    public static String QUOTATYPE = "QUOTA_TYPE";
    public static Integer STATUS = 1;

    public static final String CONTENT_PATH_JCR_AVATAR = "/bid/fileCV/";
    public static final String NAME_FILE_CV = "cvpdpa";

    public static final String USER_AVATAR = "USER_AVATAR";
    public static final String MANAGE_USER = "MANAGE_USER";
    public static final String MANAGE_TEAM = "MANAGE_TEAM";
    public static final String MANAGE_PACKAGE_TYPE = "MANAGE_PACKAGE_TYPE";
    public static final String MANAGE_PACKAGE_GROUP = "MANAGE_PACKAGE_GROUP";
    public static final String MANAGE_ROLE = "MANAGE_ROLE";
    public static final String MANAGE_USERGROUP = "MANAGE_USERGROUP";

    public static final String PACKAGE_LEVEL_EMPTY = "empty";

    public static final Integer CENTER_USER_GROUP = 1;

    public static final String TINHTRANG_GOITHAU_DANGLAPHOSO = "DLHS";

    public static final String PERMISSION_XET_THAU = "XT";
    public static final String PERMISSION_THAM_DINH = "TD";

    public static final String XET_THAU = "XT";
    public static final String THAM_DINH = "TD";


    public static final String GROUP_ADMIN = "ADMIN";
    public static final String GROUP_TRUONGPHONG = "TP";
    public static final String GROUP_XETTHAU = "NVXT";
    public static final String GROUP_THAMDINH = "NVTD";

    public static final String GROUP_NHANVIEN = "NV";

    public static final String STATUS_COMPLE = "HT";
    public static final BigInteger IS_CHAIR = BigInteger.valueOf(1);
    public static final BigInteger IS_TRUNGTHAU = BigInteger.valueOf(1);

    public static final String GOI_THAU_THAM_DINH_PHUONG_AN = "TDPA";
    //Thẩm định phương án
    public static final String GOI_THAU_TRINH_PHE_DUYET_PA = "TPDPA";
    // Trình Phê Duyệt PA

    public static final String GOI_THAU_THAM_DINH_HO_SO_MOI_THAU = "TDHSMT";
    // Thẩm định hồ sơ mời thầu
    public static final String GOI_THAU_THAM_DINH_HO_SO_MOI_CHAO_GIA_CANH_TRANH = "TDHSMCGCT";
    //Thẩm định hồ sơ mời chào giá cạnh tranh
    public static final String GOI_THAU_THAM_DINH_HO_SO_YEU_CAU = "TDHSYC";
    //Thẩm định hồ sơ yêu cầu
    public static final String GOI_THAU_TRINH_PHE_DUYET_HO_SO = "TPDHS";
    //Trình phê duyệt HSMT/HSYC
    public static final String GOI_THAU_CHUAN_BI_MOI_THAU = "CBMT";
    //Chuẩn bị mời thầu
    public static final String GOI_THAU_DANG_MOI_THAU = "DMT";
    //Đang mời thầu
    public static final String GOI_THAU_DANG_DANH_GIA = "DDG";
    // Đang đánh giá
    public static final String GOI_THAU_DANG_THAM_DINH_KET_QUA = "DTDKQ";
    //Đang thẩm định kết quả
    public static final String GOI_THAU_TRINH_PHE_DUYET_KET_QUA = "TPDKQ";
    //Trình phê duyệt kết quả
    public static final String GOI_THAU_THONG_BAO_KET_QUA = "TBKQ";
    //Thông báo kết quả
    public static final String GOI_THAU_HOAN_TAT = "HT";
    //Hoàn tất

    public static final String GOI_THAU_THANH_LAP_TO_CHUYEN_GIA = "TLTCG";
    // Thanh lap to chuyen gia

    public static final String GOI_THAU_TRINH_KET_QUA = "TKQ";

    public static final String GOI_THAU_MO_THAU = "MT";

    public static final String GOI_THAU_PHAT_HANH_HO_SO = "PHHS";

    public static final String GOI_THAU_PHE_DUYET_HO_SO = "PDHS";


    public static final String HINH_THUC_MUA_SAM_TRUC_TIEP = "MSTT";
    public static final String HINH_THUC_CHI_DINH_THAU = "CDT";
    public static final String HINH_THUC_DAU_THAU_RONG_RAI = "DTRR";
    public static final String HINH_THUC_CHAO_HANG_CANH_TRANH = "CHCT";
    public static final String HINH_THUC_CHAO_GIA_CANH_TRANH = "CGCT";

    //Form
    public static final String varHSDX = "varHSDX";
    public static final String varHSMCGCT = "varHSMCGCT";
    public static final String varTENNHATHAU = "varTENNHATHAU";
    public static final String varCHUCDANH = "varCHUCDANH";
    public static final String varSTT = "varSTT";
    public static final String varHOVATEN = "varHOVATEN";
    public static final String USER_LDAP_CODE = "ldap-user";


    public static final Integer time2UpdateStatus = 0;
    public static final Integer time2SendSMS = 7;

//    Input string
    public static final String fileCongVanPheDuyetPA ="fileCongVanPheDuyetPA";
    public static final String thamDinhPhuongAn ="thamDinhPA";
    public static final String qdPheDuyetPA ="qdPheDuyetPA";
    public static final String dbKeHoachThau ="dbKeHoachThau";
    public static final String toTrinhDSTCG ="toTrinhDSTCG";
    public static final String qdThanhLapTCG ="qdThanhLapTCG";
    public static final String trinhHSMTHSYC ="trinhHSMTHSYC";
    public static final String baoCaoThamDinh ="baoCaoThamDinh";
    public static final String qdPheDuyetHSMTHSYC ="qdPheDuyetHSMTHSYC";
    public static final String qdTenNhaThauThamGia ="qdTenNhaThauThamGia";
    public static final String trinhPheDuyetKPDB ="trinhPheDuyetKPDB";
    public static final String thuMoiThuongThao ="thuMoiThuongThao";
    public static final String bcDanhGiaHoSo ="bcDanhGiaHoSo";
    public static final String bienBanThuongThao ="bienBanThuongThao";
    public static final String trinhKetQua ="trinhKetQua";
    public static final String bcThamDinhKetQua ="bcThamDinhKetQua";
    public static final String pheDuyetKetQua ="pheDuyetKetQua";
    public static final String danhGiaLuaChonNhaThau ="danhGiaLuaChonNhaThau";
    public static final String thongBaoKet ="thongBaoKet";


}
