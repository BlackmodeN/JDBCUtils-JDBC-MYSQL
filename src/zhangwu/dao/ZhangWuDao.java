package zhangwu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import zhangwu.domain.ZhangWu;
import zhangwu.tools.JDBCUtils;

// ʵ�ֶ����ݱ�gjp_zhangwu ������ɾ�Ĳ����

public class ZhangWuDao {
	private static QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	
//����ɾ����Ϣ����
	public void deleteZhangWu(int id) {
//		����sql���
		String sql = "DELETE FROM zhangwu Where zwid =?";
		try{qr.update(sql,id);}catch(SQLException ex)
		{
			System.out.println(ex);
			throw new RuntimeException("ɾ��ʧ��");
		}
			
	}
	
	
	
	
	
	
	
//	���巽���޸���Ϣ
	public void editZhangWu(ZhangWu zw) {
//		����sql���
		String sql = "UPDATE zhangwu SET flname=?,money=?,zhangHu=?,createtime=?,description=? where zwid = ?";
//		����������������ռλ��
		Object [] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),
				            zw.getZwid()};
		
		try{qr.update(sql,params);}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("�޸�ʧ��");
		}
	}
	
	
	
	
	
//	���巽��,����ϢǶ�����ݿ�
    public void addZhangWu(ZhangWu zw) {
    	
    	String sql = "INSERT INTO zhangwu(flname,money,zhangHu,createtime,description) VALUES (?,?,?,?,?);" ;
//    	��������������洢ռλ��Ϣ
    	Object [] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
    	try {
    		qr.update(sql,params);
	    
    	}catch(SQLException ex) {
    		System.out.println(ex);
    		throw new RuntimeException("����ʧ��!");
    	}
    	
    }
	
	
	
	
//	���巽��,��ѯ���ݿ�,��ȡ������������
//	��ҵ������
//	�����,����������洢��Bean������,�洢������
	public List<ZhangWu> selectAll() {
		try {
	//		��ѯ�������ݵ�SQL���
			String sql = "SELECT * FROM zhangwu;";
	//		����qr��query����
		    List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
		    return list;
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("��ѯʧ��!");
		}
	}
//	���巽��,��ѯ���ݿ�,��������ѯ��������
//	��ҵ������
//	�����,����������洢��Bean������,�洢������
	public List<ZhangWu> select(String dateStart,String dateEnd) {
		try {
//		��ѯ�������ݵ�SQL���
		String sql = "SELECT * FROM zhangwu WHERE createtime BETWEEN ? AND ?";
//		����һ�������������洢?վλ��
		Object[] params = {dateStart,dateEnd};
//		����query�ķ���
		return qr.query(sql, new BeanListHandler<>(ZhangWu.class),params);
		}catch(SQLException ex)
		{
			System.out.println(ex);
			throw new RuntimeException("��ѯʧ��");
		}
	
		
	}

}
