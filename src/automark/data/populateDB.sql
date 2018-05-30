INSERT INTO user VALUES (null, '15201229', '15201229', 1, '张凤育');
INSERT INTO user VALUES (null, '12345678', '12345678', 2, '教师1');/* 2*/
INSERT INTO user VALUES (null, '15201230', '15201230', 1, '张家旺');
INSERT INTO user VALUES (null, '15201231', '15201231', 1, '周志凯');
INSERT INTO user VALUES (null, '23456789', '23456789', 2, '教师2');/* 5*/
INSERT INTO user VALUES (null, '15201131', '15201131', 1, '周依依');
INSERT INTO user VALUES (null, '15201331', '15201331', 1, '周某某');
INSERT INTO user VALUES (null, '15201431', '15201431', 1, '李某某');
INSERT INTO classes VALUES (null, '152011');
INSERT INTO classes VALUES (null, '152012');
INSERT INTO classes VALUES (null, '152013');
INSERT INTO classes VALUES (null, '152014');
INSERT INTO teach VALUES (null, 2, 2, '课程1');
INSERT INTO teach VALUES (null, 2, 1, '课程1');
INSERT INTO teach VALUES (null, 5, 2, '课程2');
INSERT INTO teach VALUES (null, 5, 3, '课程2');
INSERT INTO study VALUES (null, 1, 2);
INSERT INTO study VALUES (null, 3, 2);
INSERT INTO study VALUES (null, 4, 2);
INSERT INTO study VALUES (null, 6, 1);
INSERT INTO study VALUES (null, 7, 3);
INSERT INTO study VALUES (null, 8, 4);
INSERT INTO judgetype values (null,'手动批阅');/* 1 */
INSERT INTO judgetype values (null,'解释型');/* 2 */
INSERT INTO judgetype values (null,'算法');/* 3 */
insert into questiontype values (null,'jdbc');
insert into questiontype values (null,'html');
insert into questiontype values (null,'算法设计');
insert into question values (null,2,1,1,1,'题目1题目1题目1题目1题目1题目1题目1题目1','描述1描述1描述1描述1描述1描述1描述1描述1');
insert into question values (null,2,1,1,1,'题目2题目2题目2题目2题目2','描述2描述2描述2描述2描述2描述2描述2');
insert into question values (null,2,1,1,1,'题目3','描述3');
insert into question values (null,5,1,1,1,'题目4','描述4');
insert into question values (null,5,1,1,1,'题目5','描述5');
insert into question values (null,5,1,1,1,'题目6','描述6');
insert into paper values(null,2,1,'教师1试卷',100);
insert into paper values(null,5,1,'教师2试卷',100);
/*试卷1*/
insert into makepaper values(null,1,1,30);
insert into makepaper values(null,1,2,30);
insert into makepaper values(null,1,3,40);
/*试卷2*/
insert into makepaper values(null,2,4,30);
insert into makepaper values(null,2,5,30);
insert into makepaper values(null,2,6,30);
insert into exam values (null,1,2,1,'2018-5-25 12:00:00','2018-5-30 14:00:00','平时测试1');
insert into exam values (null,2,5,2,'2018-5-24 12:00:00','2018-5-29 14:00:00','评估统考1');
insert into exam values (null,1,5,1,'2018-5-29 12:00:00','2018-5-29 14:00:00','平时测试2');
insert into examdo values(null,1,1,0,0);
insert into examdo values(null,1,3,0,0);
insert into examdo values(null,3,1,0,0);
insert into examdo values(null,3,3,0,0);
insert into examdo values(null,4,1,0,0);
insert into examdo values(null,4,3,0,0);
insert into examdo values(null,6,1,0,0);
insert into examdo values(null,6,3,0,0);
insert into examdo values(null,1,2,0,0);
insert into examdo values(null,3,2,0,0);
insert into examdo values(null,4,2,0,0);
insert into examdo values(null,8,2,0,0);
insert into examdodetail values (null,1,1,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,2,1,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,3,1,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,1,2,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,2,2,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,3,2,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,1,3,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,2,3,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,3,3,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,1,4,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,2,4,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,3,4,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,1,5,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,2,5,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,3,5,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,1,6,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,2,6,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,3,6,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,1,7,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,2,7,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,3,7,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,1,8,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,2,8,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,3,8,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,4,9,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,5,9,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,6,9,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,4,10,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,5,10,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,6,10,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,4,11,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,5,11,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,6,11,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,4,12,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,5,12,'',1,'2018-5-26 12:00:00',0,'',-1)
insert into examdodetail values (null,6,12,'',1,'2018-5-26 12:00:00',0,'',-1)