# JDBCUtils-JDBC-MYSQL
<h4>简单的数据库增删查改程序</h4>
<h5>使用MySQL+JDBC+JDBCUtils+DBCP连接池做的一个简单的有增删改查功能的家庭账务处理软件可以用于练手,熟悉JDBC常用开发流程

<p>SQL
/***
<p>CREATE DATABASE ZHANGWU;</p>
<p>CREATE TABLE zhangwu (</p>
 <p> zwid INT PRIMARY KEY AUTO_INCREMENT,
 <p> flname VARCHAR(200),
 <p> money DOUBLE,
<p>  zhangHu VARCHAR(100),
<p>  createtime DATE,
<p>  description VARCHAR(1000) 
); </p>
<p>INSERT  INTO zhangwu(zwid,flname,money,zhangHu,createtime,description) <p>VALUES (1,'吃饭支出',247,'交通银行','2016-03-02','家庭聚餐');
<p>INSERT  INTO zhangwu(zwid,flname,money,zhangHu,createtime,description) <p>VALUES (2,'工资收入',12345,'现金','2016-03-15','开工资了');
<p>INSERT  INTO zhangwu(zwid,flname,money,zhangHu,createtime,description) <p>VALUES (3,'服装支出',1998,'现金','2016-04-02','买衣服');
<p>INSERT  INTO zhangwu(zwid,flname,money,zhangHu,createtime,description) <p>VALUES 
***/


<p>mysql配置基于JDBCUtils中.可以修改.
<p>开发流程:

<p>1.使用Eclipse创建Java工程，命名为zhangwu

<p>2.创建工程包 zhangwu.app: 存放main方法类；zhangwu.domain: 存放JavaBean；
 zhangwu.view: 存放界面，及表现层类； zhangwu.service: 存放业务层类；zhangwu.dao: 存放数据访问层类;zhangwu.tools:存放工具类
 
<p>3. mysql-connector-java-5.1.28-bin.jar[MySQL的JDBC驱动包;
  <p> 用JDBC连接MySQL数据库必须使用该JAR包];
   <p>commons-dbutils-1.4.jar[封装并简化了JDBC];
   <p>commons-dbcp-1.4.jar;
  <p> commons-pool-1.3.jar[DBCP连接池依赖该jar包].
  <p> 将必要的jar进行Buildpath
<p>4.在app包中，创建类MainApp.java，编写main主方法，用来完成本项目的启动
<p>5.在domain包中，创建类ZhangWu.java，它是用来封装账务信息的JavaBean。
<p>6.在dao包中，创建类ZhangWuDao.java，给ZhangWuDao类添加一个成员变量QueryRunner对象，因为我们使用dbutils来操作数据库。
<p>7.在service包中，创建类ZhangWuService.java，给ZhangWuService类添加一个类型为ZhangWuDao的成员变量，因为service依赖dao。
<p>8.在view包中，创建类MainView.java，给MainView类添加一个类型为ZhangWuService的成员变量，因为本项目中view依赖service。
<p>功能详见代码
