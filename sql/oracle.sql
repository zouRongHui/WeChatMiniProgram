------------------------------------------------------------------------------------------------------------------------
create table ADMIN_LOGIN_LOG
(
    LOGIN_ACCOUNT      VARCHAR2(32),
    SESSION_ID         VARCHAR2(64),
    LOGIN_TIME         TIMESTAMP(6),
    LOGIN_IP           VARCHAR2(64),
    LOGIN_STATUS       VARCHAR2(1),
    LOGIN_FAIL_MESSAGE VARCHAR2(128)
);
comment on table ADMIN_LOGIN_LOG is '管理平台登陆日志';
comment on column ADMIN_LOGIN_LOG.LOGIN_ACCOUNT is '登陆账号';
comment on column ADMIN_LOGIN_LOG.SESSION_ID is 'sessionId';
comment on column ADMIN_LOGIN_LOG.LOGIN_TIME is '登陆的时间';
comment on column ADMIN_LOGIN_LOG.LOGIN_IP is '登陆IP';
comment on column ADMIN_LOGIN_LOG.LOGIN_STATUS is '登陆状态，详见 AdminLoginLogStatusEnum ';
comment on column ADMIN_LOGIN_LOG.LOGIN_FAIL_MESSAGE is '登陆失败信息';


------------------------------------------------------------------------------------------------------------------------
create table ADMIN_MENU_INFO
(
    ID              NUMBER(10) not null
        primary key,
    PARENT_ID       NUMBER(10) not null,
    MENU_NAME       VARCHAR2(64),
    MENU_ICON       VARCHAR2(512),
    URL             VARCHAR2(512),
    DELETED         VARCHAR2(1),
    CREATE_TIME     TIMESTAMP(6),
    UPDATE_TIME     TIMESTAMP(6),
    PERMISSION_CODE VARCHAR2(32)
);
comment on table ADMIN_MENU_INFO is '菜单表';
comment on column ADMIN_MENU_INFO.ID is 'ID';
comment on column ADMIN_MENU_INFO.PARENT_ID is '父级ID';
comment on column ADMIN_MENU_INFO.MENU_NAME is '菜单名称';
comment on column ADMIN_MENU_INFO.MENU_ICON is '菜单图标';
comment on column ADMIN_MENU_INFO.URL is '请求URL';
comment on column ADMIN_MENU_INFO.DELETED is '是否已删除（0否 1是）';
comment on column ADMIN_MENU_INFO.CREATE_TIME is '创建时间';
comment on column ADMIN_MENU_INFO.UPDATE_TIME is '修改时间';
comment on column ADMIN_MENU_INFO.PERMISSION_CODE is '权限编码，必须用 ROLE_ 作为前缀';
INSERT INTO ADMIN_MENU_INFO (ID, PARENT_ID, MENU_NAME, MENU_ICON, URL, DELETED, CREATE_TIME, UPDATE_TIME, PERMISSION_CODE) VALUES (1, 0, '系统管理', 'layui-icon-set-sm', null, '0', sysdate, null, null);
INSERT INTO ADMIN_MENU_INFO (ID, PARENT_ID, MENU_NAME, MENU_ICON, URL, DELETED, CREATE_TIME, UPDATE_TIME, PERMISSION_CODE) VALUES (2, 1, '用户管理', 'layui-icon-username', '/user/list', '0', sysdate, null, 'ROLE_USER');
INSERT INTO ADMIN_MENU_INFO (ID, PARENT_ID, MENU_NAME, MENU_ICON, URL, DELETED, CREATE_TIME, UPDATE_TIME, PERMISSION_CODE) VALUES (3, 1, '角色管理', 'layui-icon-user', '/role/list', '0', sysdate, null, 'ROLE_ROLE');
INSERT INTO ADMIN_MENU_INFO (ID, PARENT_ID, MENU_NAME, MENU_ICON, URL, DELETED, CREATE_TIME, UPDATE_TIME, PERMISSION_CODE) VALUES (4, 1, '系统参数管理', 'layui-icon-util', '/sysparam/list', '0', sysdate, null, 'ROLE_SYS_PARAM');
INSERT INTO ADMIN_MENU_INFO (ID, PARENT_ID, MENU_NAME, MENU_ICON, URL, DELETED, CREATE_TIME, UPDATE_TIME, PERMISSION_CODE) VALUES (5, 0, '黑名单用户', 'layui-icon-user', '/blockUser/list', '0', sysdate, null, 'ROLE_BLOCK_USER');
INSERT INTO ADMIN_MENU_INFO (ID, PARENT_ID, MENU_NAME, MENU_ICON, URL, DELETED, CREATE_TIME, UPDATE_TIME, PERMISSION_CODE) VALUES (6, 0, '产品菜单管理', 'layui-icon-list', '/productmenu/list', '0', sysdate, null, 'ROLE_PRODUCT_MENU');


------------------------------------------------------------------------------------------------------------------------
create table ADMIN_ROLE_INFO
(
    ID          NUMBER(10) not null
        primary key,
    ROLE_NAME   VARCHAR2(64),
    ROLE_DESC   VARCHAR2(512),
    DELETED     VARCHAR2(1),
    CREATE_TIME TIMESTAMP(6),
    UPDATE_TIME TIMESTAMP(6)
);
comment on table ADMIN_ROLE_INFO is '角色表';
comment on column ADMIN_ROLE_INFO.ID is 'ID';
comment on column ADMIN_ROLE_INFO.ROLE_NAME is '角色名称';
comment on column ADMIN_ROLE_INFO.ROLE_DESC is '角色说明';
comment on column ADMIN_ROLE_INFO.DELETED is '是否已删除（0否 1是）';
comment on column ADMIN_ROLE_INFO.CREATE_TIME is '创建时间';
comment on column ADMIN_ROLE_INFO.UPDATE_TIME is '修改时间';
create sequence S_ROLE_ID;
create trigger ROLE_INFO_TRIGGER
    before insert
    on ADMIN_ROLE_INFO
    for each row
BEGIN
    select S_ROLE_ID.nextval into :NEW.id from dual;
END;
INSERT INTO ADMIN_ROLE_INFO (ID, ROLE_NAME, ROLE_DESC, DELETED, CREATE_TIME, UPDATE_TIME) VALUES (1, '超级管理员', '拥有所有权限', '0', sysdate, null);


------------------------------------------------------------------------------------------------------------------------
create table ADMIN_ROLE_MENU
(
    ID          NUMBER(10) not null
        primary key,
    ROLE_ID     NUMBER(10) not null,
    MENU_ID     NUMBER(10) not null,
    CREATE_TIME TIMESTAMP(6),
    UPDATE_TIME TIMESTAMP(6)
);
comment on table ADMIN_ROLE_MENU is '角色菜单中间表';
comment on column ADMIN_ROLE_MENU.ID is 'ID';
comment on column ADMIN_ROLE_MENU.ROLE_ID is '角色ID';
comment on column ADMIN_ROLE_MENU.MENU_ID is '菜单ID';
comment on column ADMIN_ROLE_MENU.CREATE_TIME is '创建时间';
comment on column ADMIN_ROLE_MENU.UPDATE_TIME is '修改时间';
create sequence S_ROLE_MENU_ID;
create trigger ROLE_MENU_TRIGGER
    before insert
    on ADMIN_ROLE_MENU
    for each row
BEGIN
    select S_ROLE_MENU_ID.nextval into :NEW.id from dual;
END;
INSERT INTO ADMIN_ROLE_MENU (ID, ROLE_ID, MENU_ID, CREATE_TIME, UPDATE_TIME) VALUES (1, 1, 1, sysdate, null);
INSERT INTO ADMIN_ROLE_MENU (ID, ROLE_ID, MENU_ID, CREATE_TIME, UPDATE_TIME) VALUES (2, 1, 2, sysdate, null);
INSERT INTO ADMIN_ROLE_MENU (ID, ROLE_ID, MENU_ID, CREATE_TIME, UPDATE_TIME) VALUES (3, 1, 3, sysdate, null);
INSERT INTO ADMIN_ROLE_MENU (ID, ROLE_ID, MENU_ID, CREATE_TIME, UPDATE_TIME) VALUES (4, 1, 4, sysdate, null);
INSERT INTO ADMIN_ROLE_MENU (ID, ROLE_ID, MENU_ID, CREATE_TIME, UPDATE_TIME) VALUES (5, 1, 5, sysdate, null);
INSERT INTO ADMIN_ROLE_MENU (ID, ROLE_ID, MENU_ID, CREATE_TIME, UPDATE_TIME) VALUES (6, 1, 6, sysdate, null);
INSERT INTO ADMIN_ROLE_MENU (ID, ROLE_ID, MENU_ID, CREATE_TIME, UPDATE_TIME) VALUES (7, 1, 7, sysdate, null);


------------------------------------------------------------------------------------------------------------------------
create table ADMIN_SYS_PARAMS
(
    ID          NUMBER(10) not null
        primary key,
    PARAM_KEY   VARCHAR2(64),
    PARAM_NAME  VARCHAR2(64),
    PARAM_VALUE VARCHAR2(512),
    DESCRIPTION VARCHAR2(512),
    STATUS      VARCHAR2(1),
    DELETED     VARCHAR2(1),
    CREATE_TIME TIMESTAMP(6),
    UPDATE_TIME TIMESTAMP(6)
);
comment on table ADMIN_SYS_PARAMS is '系统参数表';
comment on column ADMIN_SYS_PARAMS.ID is 'ID';
comment on column ADMIN_SYS_PARAMS.PARAM_KEY is '参数key';
comment on column ADMIN_SYS_PARAMS.PARAM_NAME is '参数名称';
comment on column ADMIN_SYS_PARAMS.PARAM_VALUE is '参数值';
comment on column ADMIN_SYS_PARAMS.DESCRIPTION is '描述';
comment on column ADMIN_SYS_PARAMS.STATUS is '状态（0正常 1停用）';
comment on column ADMIN_SYS_PARAMS.DELETED is '是否已删除（0否 1是）';
comment on column ADMIN_SYS_PARAMS.CREATE_TIME is '创建时间';
comment on column ADMIN_SYS_PARAMS.UPDATE_TIME is '修改时间';
create sequence S_SYS_PARAMS_ID;
create trigger SYS_PARAMS_TRIGGER
    before insert
    on ADMIN_SYS_PARAMS
    for each row
BEGIN
    select S_SYS_PARAMS_ID.nextval into :NEW.id from dual;
END;


------------------------------------------------------------------------------------------------------------------------
create table ADMIN_USER_INFO
(
    ID                     NUMBER(10) not null
        primary key,
    USER_NAME              VARCHAR2(64),
    ACCOUNT                VARCHAR2(20),
    PASSWORD               VARCHAR2(512),
    ROLE_ID                NUMBER(10),
    STARTED                VARCHAR2(1),
    CREATE_TIME            TIMESTAMP(6),
    UPDATE_TIME            TIMESTAMP(6),
    STATUS                 VARCHAR2(1),
    TEMP_LOCK_INVALID_TIME TIMESTAMP(6)
);
comment on table ADMIN_USER_INFO is '用户表';
comment on column ADMIN_USER_INFO.ID is 'ID';
comment on column ADMIN_USER_INFO.USER_NAME is '用户名';
comment on column ADMIN_USER_INFO.ACCOUNT is '账号';
comment on column ADMIN_USER_INFO.PASSWORD is '密码（加密后）';
comment on column ADMIN_USER_INFO.ROLE_ID is '角色ID';
comment on column ADMIN_USER_INFO.STARTED is '是否启用（0关闭 1开启）';
comment on column ADMIN_USER_INFO.CREATE_TIME is '创建时间';
comment on column ADMIN_USER_INFO.UPDATE_TIME is '修改时间';
comment on column ADMIN_USER_INFO.STATUS is '用户状态';
comment on column ADMIN_USER_INFO.TEMP_LOCK_INVALID_TIME is '账号临时锁定失效时间';
create sequence S_USER_ID start with 2;
create trigger USER_INFO_TRIGGER
    before insert
    on ADMIN_USER_INFO
    for each row
BEGIN
    select S_USER_ID.nextval into :NEW.id from dual;
END;
INSERT INTO ADMIN_USER_INFO (ID, USER_NAME, ACCOUNT, PASSWORD, ROLE_ID, STARTED, CREATE_TIME, UPDATE_TIME, STATUS, TEMP_LOCK_INVALID_TIME) VALUES (1, '超级管理员', 'admin', 'h2qvSqkx49k=', 1, '1', sysdate, null, '0', null);


------------------------------------------------------------------------------------------------------------------------
create table WD_LOGON_CONTROL
(
    WLC_LOGON_SEQ        VARCHAR2(20),
    WLC_CUST_NO          VARCHAR2(10),
    WLC_LOGON_TYPE       VARCHAR2(1),
    WLC_OPENID           VARCHAR2(60),
    WLC_SESSION_KEY      VARCHAR2(60),
    WLC_SESSIONID        VARCHAR2(60),
    WLC_LOGON_TIME       TIMESTAMP(6),
    WLC_LOGON_IP         VARCHAR2(60),
    WLC_LAST_LOGON_TIME  TIMESTAMP(6),
    WLC_LAST_LOGON_IP    VARCHAR2(60),
    WLC_LOGON_STATUS     VARCHAR2(1),
    WLC_FAIL_MSG         VARCHAR2(200),
    WLC_DAY_FAIL_TIMES   NUMBER(10) default 0,
    WLC_TOTAL_FAIL_TIMES NUMBER(10) default 0
);
comment on table WD_LOGON_CONTROL is '微店小程序登录控制表';
comment on column WD_LOGON_CONTROL.WLC_LOGON_SEQ is 'YYYYMMDD+12位序号';
comment on column WD_LOGON_CONTROL.WLC_CUST_NO is '客户编号';
comment on column WD_LOGON_CONTROL.WLC_LOGON_TYPE is '1:手机验证码；2:指纹';
comment on column WD_LOGON_CONTROL.WLC_OPENID is '微信OPENID';
comment on column WD_LOGON_CONTROL.WLC_SESSION_KEY is '微信登录会话密钥';
comment on column WD_LOGON_CONTROL.WLC_SESSIONID is '会话id';
comment on column WD_LOGON_CONTROL.WLC_LOGON_TIME is '登录时间';
comment on column WD_LOGON_CONTROL.WLC_LOGON_IP is '登录IP';
comment on column WD_LOGON_CONTROL.WLC_LAST_LOGON_TIME is '上次登录时间';
comment on column WD_LOGON_CONTROL.WLC_LAST_LOGON_IP is '上次登录IP';
comment on column WD_LOGON_CONTROL.WLC_LOGON_STATUS is '登录状态 0:成功；2:失败';
comment on column WD_LOGON_CONTROL.WLC_FAIL_MSG is '登录失败信息';
comment on column WD_LOGON_CONTROL.WLC_DAY_FAIL_TIMES is '当日失败次数';
comment on column WD_LOGON_CONTROL.WLC_TOTAL_FAIL_TIMES is '累计失败次数';
create index WD_LCWO_INDEX on WD_LOGON_CONTROL (WLC_OPENID);


------------------------------------------------------------------------------------------------------------------------
create table WD_SEND_SMS_FLOW
(
    SEQ       VARCHAR2(20),
    SMS_TYPE  VARCHAR2(3),
    IP        VARCHAR2(200),
    MOBILE_NO VARCHAR2(20),
    TIME      TIMESTAMP(6),
    CONTENT   VARCHAR2(4000)
);
comment on table WD_SEND_SMS_FLOW is '短信发送流水';
comment on column WD_SEND_SMS_FLOW.SEQ is '流水号';
comment on column WD_SEND_SMS_FLOW.SMS_TYPE is '短信类型，0:其他;1:验证码';
comment on column WD_SEND_SMS_FLOW.IP is '请求发送短信的ip';
comment on column WD_SEND_SMS_FLOW.MOBILE_NO is '手机号';
comment on column WD_SEND_SMS_FLOW.TIME is '发送时间';
comment on column WD_SEND_SMS_FLOW.CONTENT is '短信内容';
create index WD_SSFIT_INDEX on WD_SEND_SMS_FLOW (IP, TIME);


------------------------------------------------------------------------------------------------------------------------
create table WD_USER_INFO
(
    WUI_CUST_NO            VARCHAR2(10) not null
        primary key,
    WUI_CERT_TYPE          VARCHAR2(8),
    WUI_CERT_NO            VARCHAR2(60),
    WUI_CUST_NAME          VARCHAR2(100),
    WUI_OPENID             VARCHAR2(60),
    WUI_MOBILE_NO          VARCHAR2(11),
    WUI_STATUS             VARCHAR2(2),
    WUI_REGISTER_TIME      TIMESTAMP(6),
    WUI_UNIONID            VARCHAR2(60),
    WUI_AUTH_MODE          VARCHAR2(10) default '1000000000',
    WUI_CORE_CUST_NO       VARCHAR2(60),
    WUI_LEGAL_NO           VARCHAR2(16),
    WUI_DEFAULT_ACCOUNT_NO VARCHAR2(60),
    WUI_LINK_MAN_NO        VARCHAR2(20),
    ORG_NO                 VARCHAR2(16),
    BRANCH_NO              VARCHAR2(16),
    USER_TYPE              NUMBER(4),
    CUST_SOURCE            NUMBER(2),
    SOURCE_RIGHTS_ID       NUMBER(10)
);
comment on table WD_USER_INFO is '微店小程序用户信息表';
comment on column WD_USER_INFO.WUI_CUST_NO is '客户编号';
comment on column WD_USER_INFO.WUI_CERT_TYPE is '证件类型';
comment on column WD_USER_INFO.WUI_CERT_NO is '证件号码';
comment on column WD_USER_INFO.WUI_CUST_NAME is '客户姓名';
comment on column WD_USER_INFO.WUI_OPENID is '微信OPENID';
comment on column WD_USER_INFO.WUI_MOBILE_NO is '手机号码';
comment on column WD_USER_INFO.WUI_STATUS is '用户状态 00:正常；01:临时锁定；02:永久锁定；03:注销；';
comment on column WD_USER_INFO.WUI_REGISTER_TIME is '注册时间';
comment on column WD_USER_INFO.WUI_UNIONID is '微信UNIONID';
comment on column WD_USER_INFO.WUI_AUTH_MODE is '第一位:手机验证码（必须开启，默认开启，不可取消）；第二位1100000000:指纹';
comment on column WD_USER_INFO.WUI_CORE_CUST_NO is '核心客户号';
comment on column WD_USER_INFO.WUI_LEGAL_NO is '法人机构号';
comment on column WD_USER_INFO.WUI_DEFAULT_ACCOUNT_NO is '默认关联的账户(卡)';
comment on column WD_USER_INFO.WUI_LINK_MAN_NO is '推荐注册的客户经理工号';
comment on column WD_USER_INFO.ORG_NO is '开卡支行号';
comment on column WD_USER_INFO.BRANCH_NO is '开卡分行号';
comment on column WD_USER_INFO.USER_TYPE is '用户类型，详见 com.sunyard.enumeration.UserInfoTypeEnum ';
comment on column WD_USER_INFO.CUST_SOURCE is '客户来源';
comment on column WD_USER_INFO.SOURCE_RIGHTS_ID is '来源自权益的用户，关联的权益id';
create sequence S_WD_CUST_NO;
create trigger WD_USER_INFO_TRIGGER
    before insert
    on WD_USER_INFO
    for each row
BEGIN
    SELECT TO_CHAR(S_WD_CUST_NO.NEXTVAL, 'FM0000000000') INTO :NEW.WUI_CUST_NO FROM DUAL;
END;


------------------------------------------------------------------------------------------------------------------------
create table WD_USER_TOKEN
(
    USER_ID     VARCHAR2(32) not null
        constraint WD_USER_TOKEN_PK
            primary key,
    USER_TOKEN  VARCHAR2(32),
    SESSION_ID  VARCHAR2(64),
    CREATE_TIME TIMESTAMP(6),
    EXPIRE_TIME TIMESTAMP(6),
    SERVER_IP   VARCHAR2(16)
);
comment on table WD_USER_TOKEN is '用户Token表';
comment on column WD_USER_TOKEN.USER_ID is '用户ID';
comment on column WD_USER_TOKEN.USER_TOKEN is '用户Token';
comment on column WD_USER_TOKEN.SESSION_ID is '申请Token时的sessionId';
comment on column WD_USER_TOKEN.CREATE_TIME is 'Token签发时间';
comment on column WD_USER_TOKEN.EXPIRE_TIME is 'Token失效时间';
comment on column WD_USER_TOKEN.SERVER_IP is '服务器IP';
create index WD_USER_TOKEN_USER_TOKEN_INDEX on WD_USER_TOKEN (USER_TOKEN);


------------------------------------------------------------------------------------------------------------------------
create table WD_BLOCK_USER
(
    ID             NUMBER(10) not null
        constraint WD_BLOCK_USER_PK
            primary key,
    CUSTOMER_NAME  VARCHAR2(100),
    PHONE          VARCHAR2(11),
    CARD_NO        VARCHAR2(60),
    CARD_BRANCH    VARCHAR2(16),
    CARD_SUBBRANCH VARCHAR2(16),
    OPEN_ID        VARCHAR2(60),
    RULE           VARCHAR2(128),
    CREATE_TIME    TIMESTAMP(6),
    STATUS         VARCHAR2(4),
    EDIT_TIME      TIMESTAMP(6),
    CREATOR        VARCHAR2(16)
);
comment on table WD_BLOCK_USER is '黑名单';
comment on column WD_BLOCK_USER.ID is '主键';
comment on column WD_BLOCK_USER.CUSTOMER_NAME is '姓名';
comment on column WD_BLOCK_USER.PHONE is '手机号';
comment on column WD_BLOCK_USER.CARD_NO is '卡号';
comment on column WD_BLOCK_USER.CARD_BRANCH is '卡所属分行';
comment on column WD_BLOCK_USER.CARD_SUBBRANCH is '卡所属支行';
comment on column WD_BLOCK_USER.OPEN_ID is '微信号open_id';
comment on column WD_BLOCK_USER.RULE is '违反反欺诈规则';
comment on column WD_BLOCK_USER.CREATE_TIME is '加入黑名单时间';
comment on column WD_BLOCK_USER.STATUS is '状态，0:未启用;1:启用';
comment on column WD_BLOCK_USER.EDIT_TIME is '最近修改时间';
comment on column WD_BLOCK_USER.CREATOR is '添加者';
create sequence S_WD_BLOCK_USER_ID;


------------------------------------------------------------------------------------------------------------------------
create table APP_PRODUCT_MENU
(
    ID                NUMBER(10) not null
        primary key,
    MENU_NAME         VARCHAR2(64),
    PRODUCT_DESC      VARCHAR2(1500),
    CONSULT_WORK_NO   VARCHAR2(100),
    BUSINESS_TYPE     VARCHAR2(20),
    MENU_ICON         VARCHAR2(128)  default NULL,
    CATEGORY_ID       NUMBER(10),
    ADVERT_PHOTO      VARCHAR2(128)  default NULL,
    JUMP_URL          VARCHAR2(100),
    JUMP_PARAM        VARCHAR2(4000) default NULL,
    HOLD_URL          VARCHAR2(100),
    HOLD_PARAM        VARCHAR2(100),
    FONT_ID           NUMBER(10),
    SORT              NUMBER(10),
    DELETED           VARCHAR2(1),
    CREATE_TIME       TIMESTAMP(6),
    UPDATE_TIME       TIMESTAMP(6),
    USABLE            VARCHAR2(1),
    SHOW_FIRST        VARCHAR2(1),
    NEED_LOGIN        VARCHAR2(1)    default '0',
    SUPPORT_USER_TYPE VARCHAR2(8)
);
comment on table APP_PRODUCT_MENU is '产品菜单表';
comment on column APP_PRODUCT_MENU.ID is 'ID';
comment on column APP_PRODUCT_MENU.MENU_NAME is '名称';
comment on column APP_PRODUCT_MENU.PRODUCT_DESC is '描述';
comment on column APP_PRODUCT_MENU.CONSULT_WORK_NO is '负责人工号';
comment on column APP_PRODUCT_MENU.BUSINESS_TYPE is '业务种类';
comment on column APP_PRODUCT_MENU.MENU_ICON is '菜单图标';
comment on column APP_PRODUCT_MENU.CATEGORY_ID is '分类ID';
comment on column APP_PRODUCT_MENU.ADVERT_PHOTO is '广告图地址';
comment on column APP_PRODUCT_MENU.JUMP_URL is '可购页面';
comment on column APP_PRODUCT_MENU.JUMP_PARAM is '可购页面参数';
comment on column APP_PRODUCT_MENU.HOLD_URL is '持有页面';
comment on column APP_PRODUCT_MENU.HOLD_PARAM is '持有页面参数';
comment on column APP_PRODUCT_MENU.FONT_ID is '字体ID';
comment on column APP_PRODUCT_MENU.SORT is '排序';
comment on column APP_PRODUCT_MENU.DELETED is '是否已删除（0否 1是）';
comment on column APP_PRODUCT_MENU.CREATE_TIME is '创建时间';
comment on column APP_PRODUCT_MENU.UPDATE_TIME is '修改时间';
comment on column APP_PRODUCT_MENU.USABLE is '是否启用，0：不启用；1：启用';
comment on column APP_PRODUCT_MENU.SHOW_FIRST is '是否首页展示，0：不展示；1：展示';
comment on column APP_PRODUCT_MENU.NEED_LOGIN is '查看时是否需要登陆，0:不需要;1:需要';
comment on column APP_PRODUCT_MENU.SUPPORT_USER_TYPE is '支持的用户类型，详见 com.sunyard.enumeration.UserInfoTypeEnum';
create sequence S_PRODUCT_MENU_ID;
create trigger PRODUCT_MENU_TRIGGER
    before insert
    on APP_PRODUCT_MENU
    for each row
BEGIN
    select S_PRODUCT_MENU_ID.nextval into :NEW.id from dual;
END;


------------------------------------------------------------------------------------------------------------------------
create table APP_PRODUCT_MENU_CATEGORY
(
    ID            NUMBER(10) not null
        primary key,
    CATEGORY_NAME VARCHAR2(64),
    CATEGORY_DESC VARCHAR2(512),
    SHOW_STYLE    VARCHAR2(1),
    SORT          NUMBER(10),
    DELETED       VARCHAR2(1),
    CREATE_TIME   TIMESTAMP(6),
    UPDATE_TIME   TIMESTAMP(6)
);
comment on table APP_PRODUCT_MENU_CATEGORY is '产品菜单分类表';
comment on column APP_PRODUCT_MENU_CATEGORY.ID is 'ID';
comment on column APP_PRODUCT_MENU_CATEGORY.CATEGORY_NAME is '名称';
comment on column APP_PRODUCT_MENU_CATEGORY.CATEGORY_DESC is '描述';
comment on column APP_PRODUCT_MENU_CATEGORY.SHOW_STYLE is '展示风格（1横向  2竖向）';
comment on column APP_PRODUCT_MENU_CATEGORY.SORT is '排序';
comment on column APP_PRODUCT_MENU_CATEGORY.DELETED is '是否已删除（0否 1是）';
comment on column APP_PRODUCT_MENU_CATEGORY.CREATE_TIME is '创建时间';
comment on column APP_PRODUCT_MENU_CATEGORY.UPDATE_TIME is '修改时间';
create sequence S_PRODUCT_MENU_CATEGORY_ID;
create trigger PRODUCT_MENU_CATEGORY_TRIGGER
    before insert
    on APP_PRODUCT_MENU_CATEGORY
    for each row
BEGIN
    select S_PRODUCT_MENU_CATEGORY_ID.nextval into :NEW.id from dual;
END;


------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
-- drop table ADMIN_LOGIN_LOG;
-- drop table ADMIN_MENU_INFO;
-- drop table ADMIN_ROLE_INFO;
-- drop table ADMIN_ROLE_MENU;
-- drop table ADMIN_SYS_PARAMS;
-- drop table ADMIN_USER_INFO;
-- drop table WD_LOGON_CONTROL;
-- drop table WD_SEND_SMS_FLOW;
-- drop table WD_USER_INFO;
-- drop table WD_USER_TOKEN;
-- drop table WD_BLOCK_USER;
-- drop table APP_PRODUCT_MENU;
-- drop table APP_PRODUCT_MENU_CATEGORY;
--
-- drop sequence S_ROLE_ID;
-- drop sequence S_ROLE_MENU_ID;
-- drop sequence S_SYS_PARAMS_ID;
-- drop sequence S_USER_ID;
-- drop sequence S_WD_CUST_NO;
-- drop sequence S_WD_BLOCK_USER_ID;
-- drop sequence S_PRODUCT_MENU_ID;
-- drop sequence S_PRODUCT_MENU_CATEGORY_ID;

