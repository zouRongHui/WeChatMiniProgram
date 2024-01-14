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
------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
-- drop table ADMIN_LOGIN_LOG;
-- drop table ADMIN_MENU_INFO;
-- drop table ADMIN_ROLE_INFO;
-- drop table ADMIN_ROLE_MENU;
-- drop table ADMIN_SYS_PARAMS;
-- drop table ADMIN_USER_INFO;
--
-- drop sequence S_ROLE_ID;
-- drop sequence S_ROLE_MENU_ID;
-- drop sequence S_SYS_PARAMS_ID;
-- drop sequence S_USER_ID;

