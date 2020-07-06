import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Race {
	private RaceTrack raceTrack;
	
	public Race(){
		raceTrack=new RaceTrack();
		RaceCar.setRaceTrack(raceTrack);
	}

	public RaceTrack getRaceTrack(){
		return this.raceTrack;
	}
}