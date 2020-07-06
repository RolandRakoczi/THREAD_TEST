import java.awt.image.BufferedImage;
import java.util.*;

public class RaceCar implements Runnable{

	private static RaceTrack track;
	private volatile Thread control;
	private volatile boolean raceSuspended;
	private BufferedImage img;
	private String name;
	private int x;
	private int y;
	private int sleepTime;
	private int step;
	private Random rSleepTime=new Random();
	private Random rStep=new Random();
	
	public RaceCar(String name,BufferedImage img,int x,int y){
		this.name=name;
		this.img=img;
		this.x=x;
		this.y=y;
		sleepTime=rSleepTime.nextInt(999);
		step=rStep.nextInt(5);
		System.out.println(this.name+" Y="+this.y);
	}

	public void start(){		
		control=new Thread(this);
		raceSuspended=false;
		control.start();
	}
	
	public void stop(){
		Thread tmp=control;
		control=null;
		tmp.interrupt();		
	}
	
	public void suspend(){
		raceSuspended=true;
	}
	
	public void resume(){
		synchronized(this){
			raceSuspended=false;
			notifyAll();
		}
	}
	
	public void run(){
		Thread thisThread=Thread.currentThread();
		while ((thisThread==control)&&(this.y>140)){
			try{
				if (raceSuspended){
					synchronized(this){
						while (raceSuspended){
							wait();
						}
					}
				}
				sleepTime=rSleepTime.nextInt(99);
				step=rStep.nextInt(5);				
				Thread.sleep(sleepTime);
				setY(this.y-step);
				System.out.println(this.name+" Y="+this.y);
				track.repaint();
			}catch(InterruptedException e){
				break;
			}
		}
	}
	
	public static void setRaceTrack(RaceTrack t){
		track=t;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public BufferedImage getImage(){
		return img;
	}
}