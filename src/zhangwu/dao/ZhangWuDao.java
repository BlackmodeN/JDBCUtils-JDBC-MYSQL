package zhangwu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import zhangwu.domain.ZhangWu;
import zhangwu.tools.JDBCUtils;

// 实现对数据表gjp_zhangwu 数据增删改查操作

public class ZhangWuDao {
	private static QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	
//定义删除信息方法
	public void deleteZhangWu(int id) {
//		创建sql语句
		String sql = "DELETE FROM zhangwu Where zwid =?";
		try{qr.update(sql,id);}catch(SQLException ex)
		{
			System.out.println(ex);
			throw new RuntimeException("删除失败");
		}
			
	}
	
	
	
	
	
	
	
//	定义方法修改信息
	public void editZhangWu(ZhangWu zw) {
//		创建sql语句
		String sql = "UPDATE zhangwu SET flname=?,money=?,zhangHu=?,createtime=?,description=? where zwid = ?";
//		创建对象数组输入占位符
		Object [] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),
				            zw.getZwid()};
		
		try{qr.update(sql,params);}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("修改失败");
		}
	}
	
	
	
	
	
//	定义方法,将信息嵌入数据库
    public void addZhangWu(ZhangWu zw) {
    	
    	String sql = "INSERT INTO zhangwu(flname,money,zhangHu,createtime,description) VALUES (?,?,?,?,?);" ;
//    	定义对象数组来存储占位信息
    	Object [] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
    	try {
    		qr.update(sql,params);
	    
    	}catch(SQLException ex) {
    		System.out.println(ex);
    		throw new RuntimeException("增添失败!");
    	}
    	
    }
	
	
	
	
//	定义方法,查询数据库,获取所有账务数据
//	由业务层调用
//	结果集,将所有账务存储到Bean对象中,存储到集合
	public List<ZhangWu> selectAll() {
		try {
	//		查询账务数据的SQL语句
			String sql = "SELECT * FROM zhangwu;";
	//		调用qr的query方法
		    List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
		    return list;
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("查询失败!");
		}
	}
//	定义方法,查询数据库,按条件查询账务数据
//	由业务层调用
//	结果集,将所有账务存储到Bean对象中,存储到集合
	public List<ZhangWu> select(String dateStart,String dateEnd) {
		try {
//		查询账务数据的SQL语句
		String sql = "SELECT * FROM zhangwu WHERE createtime BETWEEN ? AND ?";
//		定义一个对象数组来存储?站位符
		Object[] params = {dateStart,dateEnd};
//		调用query的方法
		return qr.query(sql, new BeanListHandler<>(ZhangWu.class),params);
		}catch(SQLException ex)
		{
			System.out.println(ex);
			throw new RuntimeException("查询失败");
		}
	
		
	}

}
