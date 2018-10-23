/**
 * 
 */
package cn.wsyjlly.processschedule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * @Author     	晏沈威
 * @Email	   	wsyjlly@qq.com
 * @Type_name  	ProcessSchedule
 * @Createtime 	2018年10月17日 下午5:26:31
 */
public class ProcessSchedule {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		List<Pcb> process = ProcessSchedule.createProcess();
		while(process.size()!=0) {
			process.get(0).run();
			System.out.println(process.get(0).getPname()+"运行中！\n");
			if(process.get(0).getPstatus()=="完成") process.remove(0);
			ProcessSchedule.processSort(process);
			processPrint(process);
		}
		System.out.println("进程全部运行完毕！");
	}
	
	//Pcb进程创建
	public static List<Pcb> createProcess(){
		List<Pcb> list = new ArrayList<Pcb>();
		list.add(new Pcb("进程1", 2, 1, 5, 0, "就绪"));
		list.add(new Pcb("进程2", 8, 1, 5, 0, "就绪"));
		list.add(new Pcb("进程3", 6, 1, 5, 0, "就绪"));
		list.add(new Pcb("进程4", 4, 3, 5, 0, "就绪"));
		list.add(new Pcb("进程5", 4, 1, 5, 0, "就绪"));
		list.add(new Pcb("进程6", 7, 1, 5, 0, "就绪"));
		System.out.println("创建如下进程，PCB列表如下:");
		processSort(list);
		processPrint(list);
		return list;
	}
	
	//Pcb进程执行排序
	public static void processSort(List<Pcb> list) {
		list.sort(new Comparator<Pcb>() {
			@Override
			public int compare(Pcb a, Pcb b) {
				if(a.getPprioritynumber()==b.getPprioritynumber()){
					return a.getParrivetime()-b.getParrivetime();
				}else{
					return b.getPprioritynumber()-a.getPprioritynumber();
				}
			}
		});
	}
	
	//Pcb列表打印
	public static void processPrint(List<Pcb> list) {
		System.out.println("进程名"+"\t"+"优先数"+"\t"+"到达时间"+"\t"+"CPU时间"+"\t"+"已运行时间"+"\t"+"运行状态");
		for (Pcb pcb : list) {
			System.out.println(pcb.getPname()+"\t"+pcb.getPprioritynumber()+"\t"+pcb.getParrivetime()+"\t"+pcb.getPcputime()+"\t"+pcb.getPruntime()+"\t"+pcb.getPstatus());
		}
		System.out.println("-----------------------------------------------");
	}
}
