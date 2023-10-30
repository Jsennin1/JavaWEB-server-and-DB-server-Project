create table member (
ID char(255),
email char(255),
password char(31),
name varchar(255),
name_kana varchar(255),
zip varchar(7),
addr1 varchar(255),
addr2 varchar(255),
addr3 varchar(255),
primary key(ID)
)engine=innodb;

select * from member;