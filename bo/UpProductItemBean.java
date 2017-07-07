package huangwf5.bo;

public class UpProductItemBean {
	/*
	create table PRODUCT.UP_PRODUCT_ITEM
	(
	  PRODUCT_ITEM_ID    NUMBER(12) not null,
	  EXTEND_ID          NUMBER(12),
	  CODE               VARCHAR2(50),
	  NAME               VARCHAR2(200),
	  ALPHA_NAME         VARCHAR2(200),
	  ITEM_TYPE          VARCHAR2(50),
	  PRIORITY           NUMBER(6),
	  SORT_BY            INTEGER,
	  DESCRIPTION        VARCHAR2(1024),
	  CREATER            NUMBER(12),
	  MODIFIER           NUMBER(12),
	  STATE              VARCHAR2(50),
	  DEL_FLAG           CHAR(1),
	  REMARKS            VARCHAR2(255),
	  CREATE_DATE        DATE,
	  MODIFY_DATE        DATE,
	  EFF_DATE           DATE,
	  EXP_DATE           DATE,
	  USE_EFF_DATE       DATE,
	  USE_EXP_DATE       DATE,
	  ENTITY_ID          NUMBER(12),
	  CHECKER            NUMBER(12),
	  ISLOCK             CHAR(1),
	  SUPPLIER_ID        NUMBER(12),
	  PROVIDER_TYPE      NUMBER(2),
	  BUSINESS_DOMAIN_ID NUMBER(6),
	  OPER_REGION        VARCHAR2(6),
	  SHORT_NAME         VARCHAR2(200)
	)
	*/
	private String productItemId;
	private String extendId;
	private String code;
	private String name;
	private String alphaName;
	private String itemType;
	private String priority;
	private String sortBy;
	private String description;
	private String creater;
}
