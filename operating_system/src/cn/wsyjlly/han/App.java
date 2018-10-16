package cn.wsyjlly.han;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		ArrayList<Pcb> arrayList = new ArrayList<Pcb>();
		int len = Math.abs(new Random().nextInt(10) );
		if(len==0)
			len = 5;
		System.out.println("系统随机创建了"+len+"个线程");
		create(len, arrayList);
		printAllInfo(arrayList);
		while(arrayList.size()>0){
			Pcb pcb = App.Schedule(arrayList);
			boolean over = pcb.run();
			if(over){
				arrayList.remove(pcb);
			}
			printAllInfo(arrayList);
		}
		System.out.println("所有线程运行结束");
	}
	
	public static void printAllInfo(List<Pcb> list) {
		if(list.size()>0)
		System.out.println("线程名  ||到达时间  ||需要运行时间 ||已运行时间|| 级别|| 状态");
		for (Iterator<Pcb> iterator = list.iterator(); iterator.hasNext();) {
			Pcb pcbInfo = (Pcb) iterator.next();
			pcbInfo.info();
		}
	}

	@SuppressWarnings("resource")
	public static void create(Integer num,List<Pcb> arrayList) {
		
		for(int i = 0;i < num;i++){
			Pcb pcb = new Pcb();
			//设置进程名字
			pcb.setCourSeName("进程 "+(i+1));
			System.out.println("请输入进程"+(i+1)+"的到达时间（int）");
			int arriveTime = 0 ;
			while(arriveTime<=0){
				try{
					arriveTime = new Scanner(System.in).nextInt();
				}catch(Exception e){
					e.printStackTrace();
				}
				if(arriveTime<=0)
					System.out.println("到达时间应该大于o");
			}
			pcb.setArriveTime(arriveTime);
			int needTime = Math.abs(new Random().nextInt(5));
			pcb.setNeedTime(needTime);
			
			int grade =Math.abs( new Random().nextInt(10));
			pcb.setGreade(grade);
			
			pcb.setState("就绪");
			arrayList.add(pcb );
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Pcb Schedule(List<Pcb> list){
		list.sort(new Comparator<Pcb>() {
			@Override
			public int compare(Pcb o1, Pcb o2) {
				if(o1.getGreade()==o2.getGreade()){
					return o1.getArriveTime()-o2.getArriveTime();
				}else{
					return o2.getGreade()-o1.getGreade();
				}
			}
		});
		return list.get(0);
	}
}
