package zhangwu.view;

import java.util.List;
import java.util.Scanner;

import zhangwu.domain.ZhangWu;
import zhangwu.service.ZhangWuService;

//视图层
//数据传递给C层

public class MainView {
	private ZhangWuService zws = new ZhangWuService();
//	创建Scanner对象 可以反复输入 避免反复new Scanner对象
	private static 	Scanner in = new Scanner(System.in);
	
	
//  实现界面显示
//	接受用户的输入
//	根据数据,调用不同方法
	public void run() {


//	          创建循环控制标志
	    boolean flag = true;
//	          进入程序循环
	    while(flag) {
			System.out.println("|--------------------家庭记账软件---------------------|");
			System.out.println("|                                                  |");
			System.out.println("|1.添加账务|　2.编辑账务|　3.删除账务|　4.查询账务|　5.退出系统|");
			System.out.println("|                                                  |");
			System.out.println("|---------------请输入要操作的功能序[1-5]---------------|");
//			接受用户的菜单选择
			int choose = in.nextInt();
//			对选择的菜单调用不同的功能
			switch(choose) {
			case 1:
				//添加账务,调用添加账务的方法
				addZhangWu();
				break;
			case 2:
				editZhangWu();
				break;
			case 3:
				//删除账务,调用删除账务方法
				deleteZhangWu();
				break;
			case 4:
				//查询账务,调用查询方法
				selectZhangWu();
				break;
			case 5:
				System.out.println("再见~");
				flag = false;
				break;
			default:
				System.out.println("没有此功能哦!");
				break;
			}
	    }
		
	}
	
//实现账务数据的删除
	public void deleteZhangWu() {
//		先调用查询所有账户信息
		selectAll();
		System.out.println("请输入你想删除的行的ID:");
		int id = in.nextInt();
		System.out.println("你真的要删除吗?T/F");
		String flag = in.next();
		if (flag.equals("T")) {
			zws.deleteZhangWu(id);
			System.out.println("删除成功!");
		}
		else {
			System.out.println("停止删除!");
		}
		
	}
	
	
		
	
	
//  实现数据库信息的更改
//	财务信息的修改
	public void editZhangWu() {
//		先调用查询所有账户信息
		selectAll();
		ZhangWu zw = new ZhangWu();
		System.out.println("请输入选择修改行的ID");
		zw.setZwid(in.nextInt());
		System.out.println("请输入新类别");
		zw.setFlname(in.next());
		System.out.println("请输入新账户");
		zw.setZhanghu(in.next());	
		System.out.println("请输入新金钱");
		zw.setMoney(in.nextDouble());
		System.out.print("请输入新时间按照格式XXXX-XX-XX:");
		zw.setCreatetime(in.next());
		System.out.println("请输入新描述");
		zw.setDescription(in.next());
     	zws.editZhangWu(zw);
     	System.out.println("修改成功");
		
	}
	
	
	
//	实现往数据库内添加信息
//	账务信息添加
	public void addZhangWu() {
		ZhangWu zw = new ZhangWu();
		System.out.println("请输入类别");
		zw.setFlname(in.next());
		System.out.println("请输入账户");
		zw.setZhanghu(in.next());	
		System.out.println("请输入金钱");
		zw.setMoney(in.nextDouble());
		System.out.print("请输入时间按照格式XXXX-XX-XX:");
		zw.setCreatetime(in.next());
		System.out.println("请输入描述");
		zw.setDescription(in.next());
     	zws.addZhangWu(zw);
     	System.out.println("增添成功");
					
	}
	
	

	
	
	public void selectZhangWu() {
//		接收键盘的输入项，调用对应的方法（1.查询所有　2.按条件查询）
		System.out.println("1.查询所有------2.按条件查询");
		int selectChoose = in.nextInt();
	    switch(selectChoose) {
	    case 1:
//	    	查询所有
	    	selectAll();
	    	break;
	    case 2:
//	    	按条件查询
	    	select();
	    	break;
	    default :
	    	System.out.println("没有这个功能!哼!");
	    	break;
	    	
	    }
		
	}
//	定义方法,实现查询所有账务数据
	public void selectAll() {
		List<ZhangWu>list = zws.selectAll();
		print(list);
		
		
	}

//	定义方法,实现按条件查询查询
//	提供用户的输入日期,开始日期,结束日期
//	将开始和结束日期传递到业务层调用
//	获得查询的结果集并打印
	public void select() {
		System.out.print("请输入开始日期!请按照XXXX-XX-XX的格式:");
		String dateStart = in.next();
		System.out.print("请输入结束日期!请按照XXXX-XX-XX的格式:");
		String dateEnd = in.next();
		List<ZhangWu> list = zws.select(dateStart,dateEnd);
		print(list);
	}
	
	
	
//	打印查询的结果!
	private void print(List<ZhangWu> list) {
		if(list.size()!=0) {
//			添加表头
							System.out.println("ID\t类别\t\t账务\t\t金额\t\t时间\t\t说明");
//		遍历集合,结果输出
		for(ZhangWu zw:list) {
								System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t\t"+
		                           zw.getZhanghu()+"\t\t"+zw.getMoney()+"\t\t"
		                           +zw.getCreatetime()+"\t"+zw.getDescription());
		  }
		
		}
		else {
			System.out.println("对不起,没有查询到相关数据!");
		 }
	}
	
}

