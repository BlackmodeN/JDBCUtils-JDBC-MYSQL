package zhangwu.service;
//业务层类
//接受上一层的数据
//经过计算传递给DAO层 操作数据库
// 调用dao层中的类

import java.util.List;

import zhangwu.dao.ZhangWuDao;
import zhangwu.domain.ZhangWu;

public class ZhangWuService {
	private ZhangWuDao dao = new ZhangWuDao();
	
	

	
//  定义方法,删除数据	
//  此方法由视图层调用,去调用dao层的方法
	public void deleteZhangWu(int id) {
		dao.deleteZhangWu(id);
	}
	
//  定义方法,实现修改账务
//  此方法由视图层调用,去调用dao层的方法
	public void editZhangWu(ZhangWu zw) {
		dao.editZhangWu(zw);
		
	}
	

		
	
	
//    定义方法,实现添加账务
//    此方法由视图层调用,去调用dao层的方法
     public void addZhangWu(ZhangWu zw) {
    	 
    	 dao.addZhangWu(zw);
    	 
    	 
     }
	
	

	
	
	
//	定义方法,实现查询所有账务
//	此方法由视图层调用,去调用dao层的方法
	public List<ZhangWu> selectAll() {
		return dao.selectAll();
		
	}
//	定义方法,实现按条件查询账务
//	此方法由视图层调用,去调用dao层的方法
	public List<ZhangWu> select(String dateStart,String dateEnd) {
		
		return 	dao.select(dateStart,dateEnd);
		
		
	}

}
