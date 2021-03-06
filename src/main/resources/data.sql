create table user (user_name varchar(20) not null, password varchar(500) not null, kor_nm varchar(30));
INSERT INTO USER(USER_NAME, PASSWORD, KOR_NM) VALUES ('smhgood3', '$2a$10$5rWSd1pL7FIbB1RVmM.2c.hXGowUjz0T/V1I.GlWGY7lVg4AKPxvu', '손민혜');
INSERT INTO USER(USER_NAME, PASSWORD, KOR_NM) VALUES ('zxv0105', '$2a$10$5rWSd1pL7FIbB1RVmM.2c.hXGowUjz0T/V1I.GlWGY7lVg4AKPxvu', '정진양');


create table user_role (USER_NAME varchar(20) not null, role_cd varchar(5) not null);
create table role (role_cd varchar(5) not null, role_name varchar(100));

INSERT INTO USER_ROLE(USER_NAME, ROLE_CD) VALUES ('smhgood3', 'R0001');
INSERT INTO USER_ROLE(USER_NAME, ROLE_CD) VALUES ('zxv0105', 'R0002');
INSERT INTO ROLE(ROLE_CD, ROLE_NAME) VALUES ('R0001', '관리자');
INSERT INTO ROLE(ROLE_CD, ROLE_NAME) VALUES ('R0002', '유저'); 



create table coin (coin_code varchar(255) not null, market_code varchar(255) not null, coin_name varchar(255), primary key (coin_code, market_code));
create table diary (diary_no integer generated by default as identity, avg_price varchar(255), inout varchar(255), invest_amt varchar(255), profit_amt varchar(255), profit_rate varchar(255), write_dt varchar(255), market_code varchar(255), coin_code varchar(255), primary key (diary_no));
create table market (market_code varchar(255) not null, market_name varchar(255), primary key (market_code));
alter table coin add constraint FKm6oxcf7xaekwcrvehq618mkdg foreign key (market_code) references market;
alter table diary add constraint FKhyd6t2qubcowh9ividbq2e7a5 foreign key (market_code, coin_code) references coin;

INSERT INTO market (MARKET_CODE, MARKET_NAME) VALUES ('UPBIT', '업비트');
INSERT INTO market (MARKET_CODE, MARKET_NAME) VALUES ('BITSUM', '빗썸');
INSERT INTO market (MARKET_CODE, MARKET_NAME) VALUES ('COINONE', '코인원');

INSERT INTO coin (MARKET_CODE, coin_code, coin_name) VALUES ('UPBIT', 'BTC', '비트코인');
INSERT INTO coin (MARKET_CODE, coin_code, coin_name) VALUES ('UPBIT', 'ETC', '이더리움클래식');
INSERT INTO coin (MARKET_CODE, coin_code, coin_name) VALUES ('BITSUM', 'ETH', '이더리움');
