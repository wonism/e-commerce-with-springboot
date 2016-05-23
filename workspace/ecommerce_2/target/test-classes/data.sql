insert into t_user(id, username, password) values (1, 'user01','$2a$10$ouU7VJi9oSIDCykxKiV7uuRjvUPcpwZk2TBV2L52DDOIvtSp79fnO');
insert into t_authority(id, authority) values (1, 'USER');
insert into t_user_authority(user_id, authority_id) values (1, 1);

