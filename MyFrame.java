import javax.swing.*;
import java.awt.event.*;

public class MyFrame extends JFrame{
	
	private Race race;
	private JButton start;
	private JButton stop;
	private JButton suspend;
	private JButton resume;
	
	public MyFrame(){
		this.setBounds(5,5,800,850);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		race=new Race();
		this.add(race.getRaceTrack());
		addButtons();
		this.setVisible(true);
		this.setResizable(false);
		race.getRaceTrack().repaint();
	}
	
	public void addButtons(){
		start=new JButton("Start");
		stop=new JButton("Stop");
		suspend=new JButton("Suspend");
		resume=new JButton("Resume");
		this.add(start);
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				validateControls(false,true,true,false);
				race.getRaceTrack().getCar1().start();
				race.getRaceTrack().getCar2().start();
				race.getRaceTrack().getCar3().start();
				race.getRaceTrack().getCar4().start();
			}
		});
		this.add(stop);
		stop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				validateControls(false,false,false,true);
				race.getRaceTrack().getCar1().stop();
				race.getRaceTrack().getCar2().stop();
				race.getRaceTrack().getCar3().stop();
				race.getRaceTrack().getCar4().stop();
			}
		});
		this.add(suspend);
		suspend.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				validateControls(false,true,false,true);
				race.getRaceTrack().getCar1().suspend();
				race.getRaceTrack().getCar2().suspend();
				race.getRaceTrack().getCar3().suspend();
				race.getRaceTrack().getCar4().suspend();
			}
		});
		this.add(resume);
		resume.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				validateControls(false,true,true,false);
				race.getRaceTrack().getCar1().resume();
				race.getRaceTrack().getCar2().resume();
				race.getRaceTrack().getCar3().resume();
				race.getRaceTrack().getCar4().resume();
			}
		});
		validateControls(true,false,false,false);
		start.setBounds(180,760,100,35);
		stop.setBounds(290,760,100,35);
		suspend.setBounds(400,760,100,35);
		resume.setBounds(510,760,100,35);
	}
	
	private void validateControls(boolean start,boolean stop,boolean suspend,boolean resume){
		this.start.setEnabled(start);
		this.stop.setEnabled(stop);
		this.suspend.setEnabled(suspend);
		this.resume.setEnabled(resume);
	}
}