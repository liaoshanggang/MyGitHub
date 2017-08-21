
--用户表主键序列
create sequence USERSINFO_SEQ
start with 2;

select * from USERSINFO;

create table "USERSINFO"(
	"USER_ID"		NUMBER not null , 
   "USER_NAME" 		VARCHAR2(20) not null unique,
   "PASSWORD"		VARCHAR2(12) not null,
   "TEL" 			CHAR(11),
   "EMAIL" 			VARCHAR2(50),
	constraint "SYS_C005292" primary key ("USER_ID")
);

--create unique index "SYS_C005292" on "USERSINFO"("USER_ID");
--create unique index "SYS_C005293" on "USERSINFO"("USER_NAME");
	
insert into USERSINFO values(USERSINFO_SEQ.NEXTVAL,'admin','admin','18623423090','65538815@qq.com');
insert into USERSINFO values(USERSINFO_SEQ.NEXTVAL,'manager','manager','18623423090','65538815@qq.com');	
	
  SELECT * FROM USERSINFO;
  
--创建区县表
DROP TABLE DISTRICT;
create table DISTRICT
(
  ID   NUMBER not null PRIMARY KEY,
  NAME VARCHAR2(50) not null
);
insert into DISTRICT (ID, NAME) values (101, '海淀');
insert into DISTRICT (ID, NAME) values (102, '朝阳');
insert into DISTRICT (ID, NAME) values (103, '石景山');
insert into DISTRICT (ID, NAME) values (106, '丰台');
insert into DISTRICT (ID, NAME) values (100, '东城');
insert into DISTRICT (ID, NAME) values (104, '西城');
commit;
select * from district order by id;

--创建街道表
DROP TABLE STREET;
create table STREET
(
  ID          NUMBER not null PRIMARY KEY,
  NAME        VARCHAR2(50),
  DISTRICT_ID NUMBER NOT NULL REFERENCES DISTRICT(ID)	--外键，引用区县
);
insert into STREET (ID, NAME, DISTRICT_ID) values (1000, '平安路', 101);
insert into STREET (ID, NAME, DISTRICT_ID) values (1001, '中关村大街', 101);
insert into STREET (ID, NAME, DISTRICT_ID) values (1002, '学院路', 102);
insert into STREET (ID, NAME, DISTRICT_ID) values (1003, '朝阳路', 102);
commit;
select * from STREET order by id;

--出租类型表
DROP TABLE TYPES;
create table TYPES
(
  ID   NUMBER not null PRIMARY KEY,
  NAME VARCHAR2(10) not null
);
insert into TYPES (ID, NAME) values (0, '不限');
insert into TYPES (ID, NAME) values (1, '地下室');
insert into TYPES (ID, NAME) values (2, '平房');
insert into TYPES (ID, NAME) values (3, '普通住宅');
insert into TYPES (ID, NAME) values (4, '公寓');
insert into TYPES (ID, NAME) values (5, '别墅');
commit;


create sequence HOUSE_SEQ
start with 1;

--创建出租信息表
DROP TABLE HOUSE;
create table HOUSE
(
  ID          NUMBER NOT NULL PRIMARY KEY,
  USER_ID     NUMBER REFERENCES USERSINFO(USER_ID),
  STREET_ID	  NUMBER REFERENCES STREET(ID),
  TYPE_ID     NUMBER  REFERENCES TYPES(ID),
  ROOM		  NUMBER,   --几室
  HALL		  NUMBER,   --几厅
  TITLE       VARCHAR2(50), --标题
  DESCRIPTION VARCHAR2(2000),
  PRICE       NUMBER,
  PUBDATE     timestamp default systimestamp, --发布时间
  TELEPHONE   VARCHAR2(13),     --联系电话
  CONTACT     VARCHAR2(10)      --联系人
);
--ALTER TABLE HOUSE MODIFY CONTACT VARCHAR2(10);

insert into house(ID,User_Id,Street_Id,Type_Id,Room,Hall,Title,Description,Price,Telephone,Contact) 
  values(HOUSE_SEQ.NEXTVAL,4,1001,3,2,1,'北大附近招合租','水电煤气，欢迎看房，现住一人，再招一人，限女生，要求：年龄18－22岁，身高165左右，相貌好，性格开朗，脾气好，未婚，没有男朋友。帅哥＋好房速抢！',1000.00,'010-12345678','周星星');

insert into house(ID,User_Id,Street_Id,Type_Id,Room,Hall,Title,Description,Price,Telephone,Contact)  
  values(HOUSE_SEQ.NEXTVAL,4,1001,3,1,1,'健翔桥一居出租了','房间干净家具电器全有.24小时保安.24小时热水.交通购物方便.房子紧邻万达广场.华贸.阳光100.后现代.房子非常适合在附近上班的人士居住.',1200.00,'133123123321','刘景杨');

insert into house(ID,User_Id,Street_Id,Type_Id,Room,Hall,Title,Description,Price,Telephone,Contact)  
  values(HOUSE_SEQ.NEXTVAL,4,1001,4,3,2,'出租2居','冲着我你也得来',2100.00,'87654321','伊先生');

insert into house(ID,User_Id,Street_Id,Type_Id,Room,Hall,Title,Description,Price,Telephone,Contact)  
  values(HOUSE_SEQ.NEXTVAL,4,1001,4,3,2,'便宜出租前门四合院','如此宝地，如此好房，快抢，先来先得',2500.00,'13456789023','赵大宝');

insert into house(ID,User_Id,Street_Id,Type_Id,Room,Hall,Title,Description,Price,Telephone,Contact)  
  values(HOUSE_SEQ.NEXTVAL,4,1001,3,3,1,'西便门北二区出租3室1厅','西便门住宅小区北二区，简装修、3居1厅2卫、带阳台，新房从未居住过，小区环境优雅，交通购物方便，离城铁走路需5分钟。价格可商议！有意者请速于我联系。',1900.00,'13311582033','陈先生');

insert into house(ID,User_Id,Street_Id,Type_Id,Room,Hall,Title,Description,Price,Telephone,Contact)  
  values(HOUSE_SEQ.NEXTVAL,3,1001,3,2,1,'北太平庄房屋出租','房子是新房,新装修,两个卫生间,一个客厅,有独立卫生间,环境好,交通方便,欢迎入住.',1000.00,'13141406453','米女士');

insert into house(ID,User_Id,Street_Id,Type_Id,Room,Hall,Title,Description,Price,Telephone,Contact)  
  values(HOUSE_SEQ.NEXTVAL,3,1001,4,3,2,'后现代城一居室出租','房间干净家具电器全有.24小时保安.24小时热水.交通购物方便.房子紧邻万达广场.华贸.阳光100.后现代.房子非常适合在附近上班的人士居住.',2400.00,'13240775017','时先生');

insert into house(ID,User_Id,Street_Id,Type_Id,Room,Hall,Title,Description,Price,Telephone,Contact)  
  values(HOUSE_SEQ.NEXTVAL,3,1002,3,2,2,'北三环北太平庄蓟门桥蓟门里小区两居','房子地理位置好,就在三环边上,有几座大学,小区环境也相当好,屋内家电家具全都有.这的房子这个价可是最便宜的了,好房子快快来电话吧!7月10号以后能住.中介勿扰!',2200.00,'13661193065','钟小姐');

insert into house(ID,User_Id,Street_Id,Type_Id,Room,Hall,Title,Description,Price,Telephone,Contact)  
  values(HOUSE_SEQ.NEXTVAL,3,1002,3,1,1,'出租鼓楼地铁附近/鼓楼西大街!','房子是一个单间,和一个厨房,两间都能洗澡,电视,冰箱,洗衣机,空调什么都齐全,有意者尽快与我联系! ',1500.00,'15801424883','赵先生');

insert into house(ID,User_Id,Street_Id,Type_Id,Room,Hall,Title,Description,Price,Telephone,Contact)  
  values(HOUSE_SEQ.NEXTVAL,3,1003,2,2,1,'出租健翔桥二居室','电器齐全，交通便利',1100.00,'03114525655','伊先生');

  
 select * from house; 
  
  
  
  
  
  
  
  
  
  
  
  
  
/* 讲hibernate才会用到的表，多对多关系 */
--人员表
create table numbers(
	id number not null primary key,
	name varchar2(50) not null unique,
	descr varchar2(200)
);

--工程表
create table projects(
	id number not null primary key,
	name varchar2(50) not null unique,
	descr varchar2(200)
);

--关系中间表
create table r_numb_proj(
	numb_id not null references numbers(id),
	proj_id not null references projects(id),
	primary key (numb_id,proj_id)
);

select *  from numbers;
select *  from projects;
select *  from r_numb_proj;




