/**
 * 
 */
package cn.wsyjlly.processschedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
	 *设计一个有N 个进程共行的进程调度程序。
	进程调度算法： 采用最高优先数优先的调度算法（即把处理机分配给优先数最高的进
	程）和先来先服务算法。每个进程有一个进程控制块（ PCB）表示。进程控制块可以包
	含如下信息：进程名、优先数、到达时间、需要运行时间、已用CPU 时间、进程状态等
	等。进程的优先数及需要的运行时间可以事先人为地指定（也可以由随机数产生） 。进程
	的到达时间为进程输入的时间。进程的运行时间以时间片为单位进行计算。每个进程的状
	态可以是就绪W（Wait ）、运行R（Run）、或完成F（ Finish）三种状态之一。就绪进程
	获得CPU 后都只能运行一个时间片。用已占用CPU 时间加1 来表示。如果运行一个时
	间片后，进程的已占用CPU 时间已达到所需要的运行时间，则撤消该进程，如果运行一
	运行
	就绪阻塞
	进程因某事件（如等待I/O
	完成）变成阻塞状态
	某事件被解除
	（I/O 完成）
	时间片
	已用完
	进程调度程序把处
	理机分配给进程
	（ 1）
	（ 2）
	（3）
	（4）
	计算机操作系统教程（第三版）
	个时间片后进程的已占用CPU 时间还未达所需要的运行时间，也就是进程还需要继续运
	行，此时应将进程的优先数减1（即降低一级） ，然后把它插入就绪队列等待CPU。每进
	行一次调度程序都打印一次运行进程、就绪队列、以及各个进程的PCB，以便进行检查。
	重复以上过程，直到所要进程都完成为止。
 	*/
/**
 * 
 * @Author     	晏沈威
 * @Email	   	wsyjlly@qq.com
 * @Type_name  	Pcb
 * @Createtime 	2018年10月17日 下午5:04:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
public class Pcb {
	//进程名
	private String pname;
	
	//优先数
	private Integer pprioritynumber;
	
	//到达时间
	private Integer parrivetime;

	//已用CPU时间
	private Integer pcputime;
	
	//需要运行时间
	private Integer pruntime;
	
	
	//进程状态
	private String pstatus;
	
	//运行
	public boolean run() throws Exception {
		this.pstatus="运行";
		this.pprioritynumber--;
		this.pruntime++;
		Thread.sleep(500);
		if(this.pcputime==this.pruntime) {
			this.pstatus="完成";
			this.pprioritynumber=0;
			return true;
		}
		return false;
	}
	
}
