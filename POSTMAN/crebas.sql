
drop table TBL_ACCOUNT;

drop table TBL_PERSON;

drop table TBL_TRANSACTION;

drop table TBL_USER;

/*==============================================================*/
/* Table: TBL_ACCOUNT                                           */
/*==============================================================*/
create table TBL_ACCOUNT (
   ACCOUNT_ID           INT4                 not null,
   PERSON_ID            VARCHAR(36)          null,
   TYPE                 VARCHAR(1)           not null,
   INITIAL_BALANCE      DECIMAL              null,
   CREATED_BY_USER      VARCHAR(36)          not null,
   CREATED_DATE         TIMESTAMP            not null,
   LAST_MODIFIED_BY_USER VARCHAR(36)          null,
   LAST_MODIFIED_DATE   TIMESTAMP            null,
   CREATED_FROM_IP      VARCHAR(50)          not null,
   UPDATED_FROM_IP      VARCHAR(50)          null,
   STATUS               BOOL                 not null,
   VERSION              INT2                 null,
   constraint PK_TBL_ACCOUNT primary key (ACCOUNT_ID)
);

/*==============================================================*/
/* Table: TBL_PERSON                                            */
/*==============================================================*/
create table TBL_PERSON (
   PERSON_ID            VARCHAR(36)          not null,
   NAME                 VARCHAR(50)          not null,
   ADDRESS              VARCHAR(50)          not null,
   PHONE                VARCHAR(10)          not null,
   BIRTHDATE            TIMESTAMP            not null,
   GENDER               VARCHAR(1)           null,
   CREATED_BY_USER      VARCHAR(36)          not null,
   CREATED_DATE         TIMESTAMP            not null,
   LAST_MODIFIED_BY_USER VARCHAR(36)          null,
   LAST_MODIFIED_DATE   TIMESTAMP            null,
   CREATED_FROM_IP      VARCHAR(50)          not null,
   UPDATED_FROM_IP      VARCHAR(50)          null,
   STATUS               BOOL                 not null,
   VERSION              INT2                 null,
   constraint PK_TBL_PERSON primary key (PERSON_ID)
);

/*==============================================================*/
/* Table: TBL_TRANSACTION                                       */
/*==============================================================*/
create table TBL_TRANSACTION (
   TRANSACTION_ID       VARCHAR(36)          not null,
   ACCOUNT_ID           INT4                 null,
   TYPE                 VARCHAR(1)           not null,
   DATE                 TIMESTAMP            not null,
   INITIAL_BALANCE      DECIMAL              not null,
   MOVEMENT             DECIMAL              null,
   AVAILABLE_BALANCE    DECIMAL              not null,
   CREATED_BY_USER      VARCHAR(36)          not null,
   CREATED_DATE         TIMESTAMP            not null,
   LAST_MODIFIED_BY_USER VARCHAR(36)          null,
   LAST_MODIFIED_DATE   TIMESTAMP            null,
   CREATED_FROM_IP      VARCHAR(50)          not null,
   UPDATED_FROM_IP      VARCHAR(50)          null,
   STATUS               BOOL                 not null,
   VERSION              INT2                 null,
   constraint PK_TBL_TRANSACTION primary key (TRANSACTION_ID)
);

/*==============================================================*/
/* Table: TBL_USER                                              */
/*==============================================================*/
create table TBL_USER (
   USER_ID              VARCHAR(36)          not null,
   PERSON_ID            VARCHAR(36)          null,
   USER_NAME            VARCHAR(20)          not null,
   PASSWORD             VARCHAR(20)          not null,
   CREATED_BY_USER      VARCHAR(36)          not null,
   CREATED_DATE         TIMESTAMP            not null,
   LAST_MODIFIED_BY_USER VARCHAR(36)          null,
   LAST_MODIFIED_DATE   TIMESTAMP            null,
   CREATED_FROM_IP      VARCHAR(50)          not null,
   UPDATED_FROM_IP      VARCHAR(50)          null,
   STATUS               BOOL                 not null,
   VERSION              INT2                 null,
   constraint PK_TBL_USER primary key (USER_ID)
);

alter table TBL_ACCOUNT
   add constraint FK_TBL_ACCO_REFERENCE_TBL_PERS foreign key (PERSON_ID)
      references TBL_PERSON (PERSON_ID)
      on delete restrict on update restrict;

alter table TBL_TRANSACTION
   add constraint FK_TBL_TRAN_REFERENCE_TBL_ACCO foreign key (ACCOUNT_ID)
      references TBL_ACCOUNT (ACCOUNT_ID)
      on delete restrict on update restrict;

alter table TBL_USER
   add constraint FK_TBL_USER_REFERENCE_TBL_PERS foreign key (PERSON_ID)
      references TBL_PERSON (PERSON_ID)
      on delete restrict on update restrict;

