create database d_ssh_case default charset utf8;

use d_ssh_case;

/**学生基本信息表*/
create table t_stu (
  id bigint primary key auto_increment comment '编号',
  num char(10) unique not null comment '学号',
  real_name varchar(10) not null comment '姓名',
  class_id bigint not null comment '班级编号，t_class表的id字段'
) engine = InnoDB default charset utf8;

/**学生详情表*/
create table t_stu_detail (
  id bigint primary key comment '编号，t_stu表的id字段',
  identity_no char(18) unique not null comment '身份证号',
  phone char(11) not null comment '手机号',
  gender tinyint default 0 comment '性别，默认为0，表示填写，1表示男，2表示女'
) engine = InnoDB default charset utf8;

/**班级表*/
create table t_class (
  id bigint primary key auto_increment comment '编号',
  title varchar(20) unique not null comment '班级名'
) engine = InnoDB default charset utf8;

/**学生联系人表*/
create table t_contract (
  id bigint primary key auto_increment comment '编号',
  name varchar(10) not null comment '姓名',
  phone char(11) not null comment '手机号'
) engine = InnoDB default charset utf8;

/**学生与联系人关联表*/
create table t_stu_contract (
  id bigint primary key auto_increment comment '编号',
  stu_id bigint not null comment '学生编号，关联t_stu表的id字段',
  contract_id bigint not null comment '联系人编号，t_contract表的id字段'
) engine = InnoDB default charset utf8;

/**教师表*/
create table t_teacher (
  id bigint primary key auto_increment comment '编号',
  name varchar(10) not null comment '姓名',
  phone varchar(11) not null comment '手机号'
) engine = InnoDB default charset utf8;

/**班级与教师关联表*/
create table t_class_teacher (
  id bigint primary key auto_increment comment '编号',
  class_id bigint not null comment '班级编号，t_class表的id字段',
  teacher_id bigint not null comment '教师编号，t_contract表的id字段'
) engine = InnoDB default charset utf8;
