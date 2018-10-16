package cn.wsyjlly.han;


public class Pcb {
	
	/**
	 * 进程名
	 */
	private String courSeName;
	
	/**
	 * 到达时间
	 */
	private Integer arriveTime;
	
	/**
	 * 需要时间  
	 */
	private Integer needTime;

	/**
	 * 状态
	 */
	private String  state;
	
	/**
	 * 已用CPU 时间
	 */
	private Integer runTime =0;
	
	/**
	 * 优先级
	 */
	private Integer greade;

	public String getCourSeName() {
		return courSeName;
	}

	public void setCourSeName(String courSeName) {
		this.courSeName = courSeName;
	}

	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

	public boolean run(){
		System.out.println(this.courSeName+"正在运行.........");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.runTime+= 1;
		this.greade-=1;
		this.state="运行";
		if(this.runTime>=this.needTime){
			System.out.println(this.courSeName+"运行结束!!!!!!!");
			this.state="结束";
			return true;
		}
		return false;
	}

	public Integer getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(Integer arriveTime) {
		this.arriveTime = arriveTime;
	}

	public Integer getNeedTime() {
		return needTime;
	}

	public void setNeedTime(Integer needTime) {
		this.needTime = needTime;
	}

	public Integer getRunTime() {
		return runTime;
	}

	public void setRunTime(Integer runTime) {
		this.runTime = runTime;
	}

	public Integer getGreade() {
		return greade;
	}

	public void setGreade(Integer greade) {
		this.greade = greade;
	}
	
	public void info(){
		System.out.println(this.courSeName+" || " +
				this.arriveTime +"     ||"+
				this.needTime +"        ||"+ this.runTime+"      ||"+
				this.greade+"    ||"+this.state);
	}
}
