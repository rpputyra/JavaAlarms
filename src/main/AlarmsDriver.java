
package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * @author Bronwyn Herndon, Rob Putyra, Max Fine
 * 
 * Brief Description: 
 * In this project, you will write a Java Swing application that will allow a user to add alarms that will go off on certain dates and time. 
 * The features that your program must have are as follows:
 *
 */
public class AlarmsDriver implements ActionListener {
	
	static Alarm tempAlarm; //I haven't fully thought this through but maybe save selected alarm here and use that for the action listener
	static ArrayList<Alarm> alarmList = new ArrayList<Alarm>();
	
	
	public static void main(String[] args) {
		
		//start window
		JEntity AlarmWindow = new JEntity();
		
		tempAlarm = new Alarm();
		tempAlarm.setAlarmName( "TEMP" );
		alarmList.add(tempAlarm);	
		
	}

	
	//Action listener is to Control the buttons in the JFrame
	@Override
	public void actionPerformed(ActionEvent e) {

		String action = e.getActionCommand();
		
		switch ( action ) {
			
			case "NEW ALARM":
				//needs to pop open window instead this is just to prove that sound works
				tempAlarm.playSoundFile();
				break;
				
			case "DISMISS":
				tempAlarm.dismiss();
				break;
				
			case "SNOOZE":
				tempAlarm.pause();
				break;
		}
	}
	
}
