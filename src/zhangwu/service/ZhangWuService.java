package zhangwu.service;
//ҵ�����
//������һ�������
//�������㴫�ݸ�DAO�� �������ݿ�
// ����dao���е���

import java.util.List;

import zhangwu.dao.ZhangWuDao;
import zhangwu.domain.ZhangWu;

public class ZhangWuService {
	private ZhangWuDao dao = new ZhangWuDao();
	
	

	
//  ���巽��,ɾ������	
//  �˷�������ͼ�����,ȥ����dao��ķ���
	public void deleteZhangWu(int id) {
		dao.deleteZhangWu(id);
	}
	
//  ���巽��,ʵ���޸�����
//  �˷�������ͼ�����,ȥ����dao��ķ���
	public void editZhangWu(ZhangWu zw) {
		dao.editZhangWu(zw);
		
	}
	

		
	
	
//    ���巽��,ʵ���������
//    �˷�������ͼ�����,ȥ����dao��ķ���
     public void addZhangWu(ZhangWu zw) {
    	 
    	 dao.addZhangWu(zw);
    	 
    	 
     }
	
	

	
	
	
//	���巽��,ʵ�ֲ�ѯ��������
//	�˷�������ͼ�����,ȥ����dao��ķ���
	public List<ZhangWu> selectAll() {
		return dao.selectAll();
		
	}
//	���巽��,ʵ�ְ�������ѯ����
//	�˷�������ͼ�����,ȥ����dao��ķ���
	public List<ZhangWu> select(String dateStart,String dateEnd) {
		
		return 	dao.select(dateStart,dateEnd);
		
		
	}

}
