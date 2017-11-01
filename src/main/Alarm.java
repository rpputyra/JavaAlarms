
package main;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author I don't remember
 * 
 * We still need to set up time and alarm functionalities
 *	
 */
public class Alarm {

	double currentTime;
	String alarmName;
	int date;
	boolean playing;
	boolean snooze;
	String message;
	int numSnoozes;
	
	Date d = new Date("10/31/2017");
	Time t = new Time(date);
	//Audio
	String soundFile = "ALARM_Slow_Deep_Pingpong_loop_stereo.wav";
	Clip clip;
	

	public Alarm() {
		numSnoozes = 0;
	}
	
	
	//call when you need to play the alarm sound. 
	public void playSoundFile() {


		if ( !playing ) {
			
			try {
				
				File f = new File("./" + soundFile);
			    AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
			    clip = AudioSystem.getClip();
			    clip.open(audioIn);
			    clip.loop( 15 );
			    playing = true;
			    
			} catch ( LineUnavailableException e ) {
				// TODO Auto-generated catch block
				System.out.println( "Exception Caught 1: LineUnavailableException" );
				e.printStackTrace();
			} catch ( UnsupportedAudioFileException e ) {
				// TODO Auto-generated catch block
				System.out.println( "Exception Caught 2: UnsupportedAudioFileException" );
				e.printStackTrace();
			} catch ( IOException e ) {
				// TODO Auto-generated catch block
				System.out.println( "Exception Caught 3: IOException" );
				e.printStackTrace();
			} catch( IllegalArgumentException e){
				
				System.out.println(e.getMessage() + " + possibly related to hardware inadiquacies " );
			}
			
		}
		
	}

	//Call to Snooze alarm sound
	public void pause() {

		numSnoozes++;
		
		if ( playing ) {
			
			dismiss();
			//I don't link how this works it freezes up the whole JFrame for the extent of the pause. 
			try {
				Thread.sleep( 10000 );
			} catch ( InterruptedException e ) {
	
				e.printStackTrace();
			}

			playSoundFile();
			
		}
	}

	//call to dismiss alarm sound 
	//(side note I tried using clip.isActive and it threw an error if clip hadn't been instantiated yet so I'm sticking with the bool for now)
	public void dismiss() {
		
		if ( playing) {
			clip.stop();
			playing = false;
		}
		
		
	}


	public String getAlarmName() {
		return alarmName;
	}


	public void setAlarmName(String alarmName) {
		this.alarmName = alarmName;
	}
}
