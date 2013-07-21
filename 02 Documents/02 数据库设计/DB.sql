drop database if exists rst;
create database rst;
use rst;

drop table if exists ajx_user;
drop table if exists ajx_role;
drop table if exists ajx_user_role;
drop table if exists ajx_role_permission;
drop table if exists ajx_permission;
drop table if exists ajx_facter;
drop table if exists ajx_menu;
drop table if exists ajx_action;
drop table if exists ajx_customer;
drop table if exists ajx_comment;
drop table if exists ajx_cuisine_style;
drop table if exists ajx_cuisine;
drop table if exists ajx_area;
drop table if exists ajx_dining_table;
drop table if exists ajx_hotnews;
drop table if exists ajx_aboutus;
drop table if exists ajx_order;
drop table if exists ajx_order_area;
drop table if exists ajx_order_table;
drop table if exists ajx_order_cuisine;
drop table if exists ajx_weather;

##用户
create table ajx_user (
	id int auto_increment,
	username varchar(128) not null unique,
	password varchar(128) not null unique,
	description varchar(255),
	status varchar(10) not null,
	createby int not null,
	createtime timestamp not null default 0,
	updateby int,
	updatetime timestamp,
    primary key (id)
) engine=InnoDB;

##角色
create table ajx_role (
	id int auto_increment,
	role_name varchar(128) not null,
	description varchar(255),
	status varchar(10) not null,
	createby int not null,
	createtime timestamp not null default 0,
	updateby int,
	updatetime timestamp,
    primary key (id)
) engine=InnoDB;

##用户角色关系
create table ajx_user_role (
	id int auto_increment,
	user_id int not null, ##FK
	role_id int not null, ##FK
    primary key (id)
) engine=InnoDB;

##角色权限关系
create table ajx_role_permission (
	id int auto_increment,
	role_id int not null, ##FK 
	facter_id int not null, ##FK 
    primary key (id)
) engine=InnoDB;

##权限项
create table ajx_permission (
	id int auto_increment,
	facter_id int not null, ##FK
	action_type varchar(64) not null, ## 查看 修改 删除 新增
	description varchar(255),
	status varchar(10) not null,
	createby int not null,
	createtime timestamp not null default 0,
	updateby int,
	updatetime timestamp,
    primary key (id)
) engine=InnoDB;

##权限因子
create table ajx_facter (
	id int auto_increment,
	facter_name varchar(128) not null, ##对应持久层对象的class简称
	facter_value varchar(128) not null, ##对应持久层对象的class全名
	primary key (id)
) engine=InnoDB;

##菜单
create table ajx_menu (
	id int auto_increment,
	name varchar(128) not null,
	parent_id int not null, ##FK
	permission_id int not null, ## FK
	url varchar(128),
	primary key (id)
) engine=InnoDB;

##按钮
create table ajx_action(
	id int auto_increment,
	menu_id int not null, ##FK
	permission_id int not null, ## FK
	name varchar(128) not null,
	action_code varchar(64),
	primary key (id)
) engine=InnoDB;

##客户
create table ajx_customer (
	id int auto_increment,
	name varchar(128),##客户名字
	password varchar(128),
	tel_no varchar(20) not null,
	customer_type varchar(10),##客户类型（普通、vip）
	description varchar(255),
	status varchar(10) not null,
	createby int not null,
	createtime timestamp not null default 0,
	updateby int,
	updatetime timestamp,
    primary key (id)
) engine=InnoDB;

##评论
create table ajx_comment (
	id int auto_increment,
	customer_id int not null, ##FK
	comment_type varchar(10),
	description varchar(255),##评论内容
	status varchar(10) not null,
	createby int not null,
	createtime timestamp not null default 0,
	updateby int,
	updatetime timestamp,
    primary key (id)
) engine=InnoDB;

##菜系
create table ajx_cuisine_style (
	id int auto_increment,
	style_code varchar(10),##菜系编码
	style_name varchar(128),##菜系名称
	cuisine_number int,##菜系包含的菜品数量
	description varchar(1000),
	normal_image_url varchar(255),
	mini_image_url varchar(255),
	status varchar(10) not null,
	createby int not null,
	createtime timestamp not null default 0,
	updateby int,
	updatetime timestamp,
    primary key (id)
) engine=InnoDB;

##菜品
create table ajx_cuisine (
	id int auto_increment,
	cuisine_style_id int not null,  ##FK
	cuisine_code varchar(10),##菜品编号
	cuisine_name varchar(128),##菜品名称
	price int not null default 0,##价格
	description varchar(1000),
	normal_image_url varchar(255),
	mini_image_url varchar(255),
	is_recommend varchar(10), ##是否推荐
	recommend_no int not null default 0, ##推荐序号
	status varchar(10) not null,
	createby int not null,
	createtime timestamp not null default 0,
	updateby int,
	updatetime timestamp,
    primary key (id)
) engine=InnoDB;

##宴会厅,普通厅,包厢
create table ajx_area (
	id int auto_increment,
	area_name varchar(128),
	area_type varchar(10),
	description varchar(255),
	status varchar(10) not null,
	createby int not null,
	createtime timestamp not null default 0,
	updateby int,
	updatetime timestamp,
    primary key (id)
) engine=InnoDB; 

##餐桌
create table ajx_dining_table (
	id int auto_increment,
	area_id varchar(10),##FK
	dining_table_no varchar(10),##餐桌号
	description varchar(255),
	status varchar(10) not null,
	createby int not null,
	createtime timestamp not null default 0,
	updateby int,
	updatetime timestamp,
    primary key (id)
) engine=InnoDB; 

##最热消息(优惠活动)
create table ajx_hotnews (
	id int auto_increment,
	title varchar(64) not null,
	content varchar(1000) not null,
	description varchar(255),
	starttime timestamp not null default 0,
	endtime timestamp not null default 0,
	normal_image_url varchar(255),
	mini_image_url varchar(255),
	status varchar(10) not null,
	createby int not null,
	createtime timestamp not null default 0,
	updateby int,
	updatetime timestamp,
    primary key (id)
) engine=InnoDB; 

##关于我们
create table ajx_aboutus (
	id int auto_increment,
	title varchar(64) not null,
	content varchar(1000) not null,
	address varchar(255) not null,
	tel_no varchar(20),
	description varchar(255),
	normal_image_url varchar(255),
	mini_image_url varchar(255),
	status varchar(10) not null,
	createby int not null,
	createtime timestamp not null default 0,
	updateby int,
	updatetime timestamp,
    primary key (id)
) engine=InnoDB; 

##订单(婚宴预订、普通聚餐预订)
 create table ajx_order (
	id int auto_increment,
	order_type varchar(10) not null, ##婚宴or聚餐
	order_no int not null,##订单号
	customer_name varchar(255) not null,##客户姓名
	customer_number int not null default 0,##人数
	tel_no varchar(20),##手机号
	description varchar(255),##备注
	booking_type varchar(10),##预订类型(大厅、包厢)
	bookingtime_start timestamp not null default 0,
	bookingtime_end timestamp not null default 0,
	order_status varchar(10),##订单状态(已受理or未受理or已取消or用餐中or已结束)
	createby int not null,
	createtime timestamp not null default 0,
	updateby int,
	updatetime timestamp,
    primary key (id)
) engine=InnoDB; 

##订单对应的包厢
 create table ajx_order_area (
	id int auto_increment,
	order_id int not null,##FK
	area_id int not null,##FK
	description varchar(255),
    primary key (id)
) engine=InnoDB; 

##订单对应的餐桌
 create table ajx_order_table (
	id int auto_increment,
	order_id int not null,##FK
	table_id int not null,##FK
	description varchar(255),
    primary key (id)
) engine=InnoDB; 

##订单对应的菜品
 create table ajx_order_cuisine (
	id int auto_increment,
	order_id int not null,##FK
	cuisine_id int not null,##FK
	description varchar(255),
    primary key (id)
) engine=InnoDB; 

##天气
create table ajx_weather (
	id int auto_increment,
	weather_date timestamp not null default 0,##时间
	weather_type varchar(64),##天气状态
	temperature varchar(64),##温度
	warm_tips varchar(64),##温馨提示
	description varchar(255),##备注
    primary key (id)
) engine=InnoDB; 