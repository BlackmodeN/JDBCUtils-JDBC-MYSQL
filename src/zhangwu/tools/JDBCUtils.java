package zhangwu.tools;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/*这个类是一个获取数据库连接的工具类
      实现连接池*/

public class JDBCUtils {
	public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/zhangwu";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "1234";
	
	private static BasicDataSource dataSource = new BasicDataSource();
	static {
		dataSource.setDriverClassName(DRIVER_CLASS_NAME);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		dataSource.setInitialSize(10);   //初始化连接数量	
		dataSource.setMaxActive(10);  //最大连接数
		dataSource.setMaxIdle(5); // 最大空闲数
		dataSource.setMinIdle(2);
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
}