-- 用户表
create table blog_user (
    id bigint primary key ,
    openid bigint null,
    nick_name VARCHAR (200) not null,
    head_img_url varchar (255) ,
    password varchar (255) not null,
    register_time DATE not null,
    status tinyint default 1
);
# 角色表
create table blog_role (
    id bigint primary key,
    role_name varchar(100) not null
);
# 用户角色关联表
create table blog_user_role_relation (
    user_id bigint not null,
    role_id bigint not null,
    foreign key (user_id) references blog_user(id),
    foreign key (role_id) references blog_role(id)
);

ALTER TABLE blog_user_role_relation add
constraint PK_USER_ROLE_UID foreign key (user_id) references blog_user(id);
ALTER TABLE blog_user_role_relation add
    constraint PK_USER_ROLE_RID foreign key (role_id) references blog_user(id);

# 权限表（此博客暂不考虑）
