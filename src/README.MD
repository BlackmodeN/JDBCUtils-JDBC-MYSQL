使用MySQL+JDBC+JDBCUtils+DBCP连接池做的一个简单的有增删改查功能的家庭账务处理软件
可以用于练手,熟悉JDBC常用开发流程

SQL
/***
CREATE DATABASE ZHANGWU;
CREATE TABLE zhangwu (
  zwid INT PRIMARY KEY AUTO_INCREMENT,
  flname VARCHAR(200),
  money DOUBLE,
  zhangHu VARCHAR(100),
  createtime DATE,
  description VARCHAR(1000) 
);
INSERT  INTO zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (1,'吃饭支出',247,'交通银行','2016-03-02','家庭聚餐');
INSERT  INTO zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (2,'工资收入',12345,'现金','2016-03-15','开工资了');
INSERT  INTO zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (3,'服装支出',1998,'现金','2016-04-02','买衣服');
INSERT  INTO zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES 
***/
mysql配置基于JDBCUtils中.可以修改.
开发流程:
1.使用Eclipse创建Java工程，命名为zhangwu
2.创建工程包
 zhangwu.app: 存放main方法类；
 zhangwu.domain: 存放JavaBean；
 zhangwu.view: 存放界面，及表现层类；
 zhangwu.service: 存放业务层类；
 zhangwu.dao: 存放数据访问层类;
zhangwu.tools:存放工具类
3. mysql-connector-java-5.1.28-bin.jar[MySQL的JDBC驱动包;
   用JDBC连接MySQL数据库必须使用该JAR包];
   commons-dbutils-1.4.jar[封装并简化了JDBC];
   commons-dbcp-1.4.jar;
   commons-pool-1.3.jar[DBCP连接池依赖该jar包].
   将必要的jar进行Buildpath
4.在app包中，创建类MainApp.java，编写main主方法，用来完成本项目的启动
5.在domain包中，创建类ZhangWu.java，它是用来封装账务信息的JavaBean。
6.在dao包中，创建类ZhangWuDao.java，给ZhangWuDao类添加一个成员变量QueryRunner对象，因为我们使用dbutils来操作数据库。
7.在service包中，创建类ZhangWuService.java，给ZhangWuService类添加一个类型为ZhangWuDao的成员变量，因为service依赖dao。
8.在view包中，创建类MainView.java，给MainView类添加一个类型为ZhangWuService的成员变量，因为本项目中view依赖service。
功能详见代码
