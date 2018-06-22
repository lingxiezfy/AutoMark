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
INSERT INTO judgetype values (null,'输入输出型');/* 3 */
insert into questiontype values (null,'jdbc');
insert into questiontype values (null,'html');
insert into questiontype values (null,'算法设计');
insert into question values (null,2,1,3,1,'输入输出','输入什么输出什么');
insert into question values (null,2,1,1,1,'题目2题目2题目2题目2题目2','描述2描述2描述2描述2描述2描述2描述2');
insert into question values (null,2,1,1,1,'题目3','描述3');
insert into question values (null,5,1,1,1,'题目4','描述4');
insert into question values (null,5,1,1,1,'题目5','描述5');
insert into question values (null,5,1,1,1,'题目6','描述6');
insert into question values (null,5,1,1,1,'题目7','描述6');
insert into question values (null,2,1,1,1,'题目8','描述3');
insert into question values (null,2,1,1,1,'题目9','描述3');
insert into question values (null,2,1,1,1,'题目10','描述10');
insert into question values (null,2,1,1,1,'题目11','描述11');
insert into question values (null,2,1,1,1,'题目12','描述12');
insert into question values (null,2,1,1,1,'题目13','描述13');
insert into question values (null,2,1,1,1,'题目14','描述14');
insert into question values (null,2,1,1,1,'题目15','描述15');
insert into question values (null,2,1,1,1,'题目16','描述16');
insert into question values (null,2,1,1,1,'题目17','描述17');
insert into question values (null,2,1,1,1,'题目18','描述18');
insert into question values (null,2,1,1,1,'题目19','描述19');
insert into question values (null,2,1,1,1,'题目20','描述20');
insert into question values (null,2,1,1,1,'题目21','描述21');
insert into question values (null,2,1,1,1,'题目22','描述22');
insert into question values (null,2,1,1,1,'题目23','描述23');
insert into question values (null,2,1,1,1,'题目24','描述24');
insert into question values (null,2,1,1,1,'题目25','描述25');
insert into question values (null,2,3,3,1,'题目26','描述26');
insert into question values (null,2,3,3,1,'题目27','描述27');
insert into question values (null,2,3,3,1,'题目28','描述28');
insert into question values (null,2,3,3,1,'题目29','描述29');

insert into answer values(null,1,'1','1');
insert into answer values(null,1,'测试','测试');
insert into answer values(null,1,'通过','通过');
insert into answer values(null,1,'第四个测试','第四个测试');

insert into answer values(null,26,'输入1','输出1');
insert into answer values(null,26,'输入2','输出2');
insert into answer values(null,26,'输入3','输出3');
insert into answer values(null,26,'输入4','输出4');

insert into answer values(null,27,'输入1','输出1');
insert into answer values(null,27,'输入2','输出2');
insert into answer values(null,27,'输入3','输出3');
insert into answer values(null,27,'输入4','输出4');

insert into answer values(null,28,'输入1','输出1');
insert into answer values(null,28,'输入2','输出2');

insert into answer values(null,29,'输入1','输出1');
insert into answer values(null,29,'输入2','输出2');

insert into paper values(null,2,1,'教师1试卷',100);
insert into paper values(null,5,1,'教师2试卷',100);
insert into paper values(null,2,1,'教师3试卷',100);
insert into paper values(null,5,1,'教师4试卷',100);
insert into paper values(null,2,1,'教师5试卷',100);
insert into paper values(null,5,1,'教师6试卷',100);
/*试卷1*/
insert into makepaper values(null,1,1,30);
insert into makepaper values(null,1,2,30);
insert into makepaper values(null,1,3,40);
/*试卷2*/
insert into makepaper values(null,2,4,30);
insert into makepaper values(null,2,5,30);
insert into makepaper values(null,2,6,30);
insert into exam values (null,1,2,1,'2018-6-22 07:00:00','2018-6-22 14:00:00','平时测试1');
insert into exam values (null,2,5,2,'2018-6-11 05:00:00','2018-06-11 21:00:00','评估统考1');
insert into exam values (null,1,5,1,'2018-5-29 12:00:00','2018-5-29 14:00:00','平时测试2');
insert into exam values (null,1,2,2,'2018-5-25 12:00:00','2018-5-31 14:00:00','评估统考2');
insert into judgegrant values(null,2,2);
insert into judgegrant values(null,5,2);
insert into judgegrant values(null,2,4);
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