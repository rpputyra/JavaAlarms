/**
 * 
 */
package main;

import java.io.File;
import java.io.IOException;

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
	int date;
	boolean playing;
	String message;
	int numSnoozes;
	
	//Audio
	String soundFile = "ALARM_Slow_Deep_Pingpong_loop_stereo.wav";
	Clip clip;
	

	public Alarm() {
		numSnoozes = 0;
	}
	
	
	//call when you need to play the alarm sound. 
	public void playSoundFile() {


		try {
			
			File f = new File("./" + soundFile);
		    AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
		    clip = AudioSystem.getClip();
		    clip.open(audioIn);
		    clip.loop( 15 );
		    
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
		}
		
		playing = true;
		
	}

	//Call to Snooze alarm sound
	public void pause() {

		numSnoozes++;
		
		if ( playing ) {
			
			dismiss();
			
			//I don't link how this works it freezes up the whole JFrame for the extent of the pause. 
			try {
				Thread.sleep( 180000 );
			} catch ( InterruptedException e ) {
	
				e.printStackTrace();
			}
			clip.loop( 15 );
			
			playing = true;
		}
	}

	//call to dismiss alarm sound
	public void dismiss() {
		
		clip.stop();
		playing = false;
		
	}
}
