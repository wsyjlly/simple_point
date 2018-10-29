package cn.wsyjlly.pagesubstitution;

import java.util.Scanner;

public class LRU {
	private static Integer MAXSIZE=20;
	private static Integer input=0;  //用于输入作业号
	private static Integer worknum=0;  //输入的作业个数
	private static Integer storesize=0;  //系统分配的存储区块数
	private static Integer interrupt=0;  //缺页中断次数
	private static Integer[] stack = new Integer[MAXSIZE];;  //栈，LRU算法的主要数据结构
	private static Integer[] workstep = new Integer[MAXSIZE];  //记录作业走向
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		/*初始化*/ 
		for(int i=0;i<MAXSIZE;i++) { 
			stack[i]=0; 
			workstep[i]=0; 
		}
		for (int i = 0; i < workstep.length; i++) {
			System.out.println("输入页面走向：（66结束）");
			input = new Scanner(System.in).nextInt();
			if(input==66){
				break;
			}else{
				workstep[i] = input;
				worknum++;
				System.out.println(worknum);
			}
			
		}
		
		System.out.println("输入存储区块数：");
		storesize = new Scanner(System.in).nextInt();
		
		for (int i = 0; i < worknum; i++) {
			for (int j = 0; j < storesize; j++) {
				if(stack[i]==0){
					System.out.println("内存有空闲，页面"+i+"直接调入！");
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		

		System.out.println(worknum);
		
		for(int i=0;i<worknum;i++) { 
			System.out.print(workstep[i]+"\t");
		}
	}

}
