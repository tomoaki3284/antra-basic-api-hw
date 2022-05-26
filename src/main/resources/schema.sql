create table USERS(
  uid int not null AUTO_INCREMENT,
  username varchar(20) not null,
  email varchar(30) not null,
  password varchar(256) not null,
  creationdate DATE NOT NULL,
  PRIMARY KEY ( uid )
);
