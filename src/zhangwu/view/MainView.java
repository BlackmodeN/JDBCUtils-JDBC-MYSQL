package zhangwu.view;

import java.util.List;
import java.util.Scanner;

import zhangwu.domain.ZhangWu;
import zhangwu.service.ZhangWuService;

//��ͼ��
//���ݴ��ݸ�C��

public class MainView {
	private ZhangWuService zws = new ZhangWuService();
//	����Scanner���� ���Է������� ���ⷴ��new Scanner����
	private static 	Scanner in = new Scanner(System.in);
	
	
//  ʵ�ֽ�����ʾ
//	�����û�������
//	��������,���ò�ͬ����
	public void run() {


//	          ����ѭ�����Ʊ�־
	    boolean flag = true;
//	          �������ѭ��
	    while(flag) {
			System.out.println("|--------------------��ͥ�������---------------------|");
			System.out.println("|                                                  |");
			System.out.println("|1.�������|��2.�༭����|��3.ɾ������|��4.��ѯ����|��5.�˳�ϵͳ|");
			System.out.println("|                                                  |");
			System.out.println("|---------------������Ҫ�����Ĺ�����[1-5]---------------|");
//			�����û��Ĳ˵�ѡ��
			int choose = in.nextInt();
//			��ѡ��Ĳ˵����ò�ͬ�Ĺ���
			switch(choose) {
			case 1:
				//�������,�����������ķ���
				addZhangWu();
				break;
			case 2:
				editZhangWu();
				break;
			case 3:
				//ɾ������,����ɾ�����񷽷�
				deleteZhangWu();
				break;
			case 4:
				//��ѯ����,���ò�ѯ����
				selectZhangWu();
				break;
			case 5:
				System.out.println("�ټ�~");
				flag = false;
				break;
			default:
				System.out.println("û�д˹���Ŷ!");
				break;
			}
	    }
		
	}
	
//ʵ���������ݵ�ɾ��
	public void deleteZhangWu() {
//		�ȵ��ò�ѯ�����˻���Ϣ
		selectAll();
		System.out.println("����������ɾ�����е�ID:");
		int id = in.nextInt();
		System.out.println("�����Ҫɾ����?T/F");
		String flag = in.next();
		if (flag.equals("T")) {
			zws.deleteZhangWu(id);
			System.out.println("ɾ���ɹ�!");
		}
		else {
			System.out.println("ֹͣɾ��!");
		}
		
	}
	
	
		
	
	
//  ʵ�����ݿ���Ϣ�ĸ���
//	������Ϣ���޸�
	public void editZhangWu() {
//		�ȵ��ò�ѯ�����˻���Ϣ
		selectAll();
		ZhangWu zw = new ZhangWu();
		System.out.println("������ѡ���޸��е�ID");
		zw.setZwid(in.nextInt());
		System.out.println("�����������");
		zw.setFlname(in.next());
		System.out.println("���������˻�");
		zw.setZhanghu(in.next());	
		System.out.println("�������½�Ǯ");
		zw.setMoney(in.nextDouble());
		System.out.print("��������ʱ�䰴�ո�ʽXXXX-XX-XX:");
		zw.setCreatetime(in.next());
		System.out.println("������������");
		zw.setDescription(in.next());
     	zws.editZhangWu(zw);
     	System.out.println("�޸ĳɹ�");
		
	}
	
	
	
//	ʵ�������ݿ��������Ϣ
//	������Ϣ���
	public void addZhangWu() {
		ZhangWu zw = new ZhangWu();
		System.out.println("���������");
		zw.setFlname(in.next());
		System.out.println("�������˻�");
		zw.setZhanghu(in.next());	
		System.out.println("�������Ǯ");
		zw.setMoney(in.nextDouble());
		System.out.print("������ʱ�䰴�ո�ʽXXXX-XX-XX:");
		zw.setCreatetime(in.next());
		System.out.println("����������");
		zw.setDescription(in.next());
     	zws.addZhangWu(zw);
     	System.out.println("����ɹ�");
					
	}
	
	

	
	
	public void selectZhangWu() {
//		���ռ��̵���������ö�Ӧ�ķ�����1.��ѯ���С�2.��������ѯ��
		System.out.println("1.��ѯ����------2.��������ѯ");
		int selectChoose = in.nextInt();
	    switch(selectChoose) {
	    case 1:
//	    	��ѯ����
	    	selectAll();
	    	break;
	    case 2:
//	    	��������ѯ
	    	select();
	    	break;
	    default :
	    	System.out.println("û���������!��!");
	    	break;
	    	
	    }
		
	}
//	���巽��,ʵ�ֲ�ѯ������������
	public void selectAll() {
		List<ZhangWu>list = zws.selectAll();
		print(list);
		
		
	}

//	���巽��,ʵ�ְ�������ѯ��ѯ
//	�ṩ�û�����������,��ʼ����,��������
//	����ʼ�ͽ������ڴ��ݵ�ҵ������
//	��ò�ѯ�Ľ��������ӡ
	public void select() {
		System.out.print("�����뿪ʼ����!�밴��XXXX-XX-XX�ĸ�ʽ:");
		String dateStart = in.next();
		System.out.print("�������������!�밴��XXXX-XX-XX�ĸ�ʽ:");
		String dateEnd = in.next();
		List<ZhangWu> list = zws.select(dateStart,dateEnd);
		print(list);
	}
	
	
	
//	��ӡ��ѯ�Ľ��!
	private void print(List<ZhangWu> list) {
		if(list.size()!=0) {
//			��ӱ�ͷ
							System.out.println("ID\t���\t\t����\t\t���\t\tʱ��\t\t˵��");
//		��������,������
		for(ZhangWu zw:list) {
								System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t\t"+
		                           zw.getZhanghu()+"\t\t"+zw.getMoney()+"\t\t"
		                           +zw.getCreatetime()+"\t"+zw.getDescription());
		  }
		
		}
		else {
			System.out.println("�Բ���,û�в�ѯ���������!");
		 }
	}
	
}

