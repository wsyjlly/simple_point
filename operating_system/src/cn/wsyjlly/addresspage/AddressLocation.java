package cn.wsyjlly.addresspage;

import java.util.Scanner;


/**
 * @Author     	晏沈威
 * @Email	   	wsyjlly@qq.com
 * @Type_name  	AddressLocation
 * @Createtime 	2018年10月23日 下午11:58:58
 */


public class AddressLocation {
	private final static int pagesize = 1024;
	private final static int page = 64;
	private final static int[] pagetable = {0,42,29,15,45,31,44,43, 
						41,28,1,30,12,24,6,32, 
						14,27,13,46,7,33,10,22, 
						40,2,51,11,39,23,49,50, 
						26,16,25,4,47,17,3,48, 
						52,36,58,35,57,34,21,63, 
						5,37,18,8,62,56,20,54, 
						60,19,38,9,61,55,59,53};
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("系统页号对应块号情况（页号——>块号）：");
		System.out.printf("--------------------------------------------------------------------------------");
		for (int i = 0; i < pagetable.length; i++) {
			if(i%10==0)System.out.println();
			System.out.printf(i+"——>"+pagetable[i]+"\t");
		}
		System.out.printf("\n--------------------------------------------------------------------------------");
		while(true){
			System.out.println("\n请输入逻辑地址(请输入9位及以下数字)：");
			int address = new Scanner(System.in).nextInt();
			
			int pagenum = address/pagesize;
			int deviation = address%pagesize;
			if(pagenum>page){
				System.out.println("本次访问的地址已超出进程的地址空间，系统将产生越界中断！");continue;
			}else{
				int add = pagetable[pagenum]*pagesize+deviation;
				System.out.println("对应的物理地址页为："+pagetable[pagenum]);
				System.out.println("对应的物理地址页地址为："+deviation);
				System.out.println("对应的物理地址为："+add);
			}
		}
	}
}
