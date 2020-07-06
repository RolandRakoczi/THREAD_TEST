import java.awt.*;
import java.awt.Color.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.imageio.*;

public class RaceTrack extends JPanel{
	private RaceCar car1;
	private RaceCar car2;
	private RaceCar car3;
	private RaceCar car4;
	
	public RaceTrack(){
		this.setSize(800,750);
		addRaceCars();
	}
	
	public void addRaceCars(){
		try{
			BufferedImage img1=ImageIO.read(new File("bluef1car.jpg"));
			this.car1=new RaceCar("car1",img1,50,750-120);
			BufferedImage img2=ImageIO.read(new File("redf1car.jpg"));
			this.car2=new RaceCar("car2",img2,250,750-120);
			BufferedImage img3=ImageIO.read(new File("yellowf1car.jpg"));
			this.car3=new RaceCar("car3",img3,450,750-120);
			BufferedImage img4=ImageIO.read(new File("greenf1car.jpg"));
			this.car4=new RaceCar("car4",img4,650,750-120);
		} catch(IOException e){
			System.exit(1);
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0,135,(int)(this.getBounds().getWidth()),5);
		g.fillRect(0,(int)(this.getBounds().getHeight())-140,(int)(this.getBounds().getWidth()),5);
		g.drawImage(car1.getImage(),car1.getX(),car1.getY(),this);
		g.drawImage(car2.getImage(),car2.getX(),car2.getY(),this);
		g.drawImage(car3.getImage(),car3.getX(),car3.getY(),this);
		g.drawImage(car4.getImage(),car4.getX(),car4.getY(),this);
	}
	
	public RaceCar getCar1(){
		return car1;
	}

	public RaceCar getCar2(){
		return car2;
	}

	public RaceCar getCar3(){
		return car3;
	}
	
	public RaceCar getCar4(){
		return car4;
	}

}