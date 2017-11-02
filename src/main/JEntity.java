/**
 * 
 */
package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Bronwyn
 *
 */
public class JEntity extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel background;
	ActionListener alarmsListener = new AlarmsDriver();
	
	//Main Boxes
	private JPanel buttonPanel;
	private JPanel alarmPanel;
	private GridBagConstraints gc;
	
	//Buttons etc
	private JButton snooze;
	private JButton dismiss;
	private JButton newAlarm;
	private JButton newTimer;
	
	public JEntity() {
		
		//Set Up basic Frame 
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		this.setLocationRelativeTo( null );
		this.setSize( 600, 600 );
		
		background = new JLabel(new ImageIcon ("background.jpg") );
		background.setLayout( new GridBagLayout() );
		gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = .8;
		
		//Add Objects
		instantiateObjects();
		
		//Add it all to the Frame
		this.add( background );
		gc.gridx = 0;
		gc.gridy = 0;
		background.add( alarmPanel, gc );
		gc.weightx = .2;
		gc.gridx = 2;
		gc.gridy = 0;
		background.add( buttonPanel, gc );
		
		
		this.setVisible( true );
	}

	private void instantiateObjects() {

		buttonPanel = new JPanel();
		alarmPanel = new JPanel( );
		
		//set up panels
		
		JLabel alarmSide = new JLabel("Alarms: ");
		alarmSide.setForeground( Color.WHITE);
		
		//Make Panels Translucent
		buttonPanel.setOpaque( false );
		buttonPanel.setBackground( Color.gray );
		alarmPanel.setOpaque( false );
		alarmPanel.setBackground( Color.gray );
		
		//Layouts
		buttonPanel.setLayout( new GridBagLayout( ) );
		alarmPanel.setLayout( new GridLayout(60, 1) );
		
		//snooze = new JButton("SNOOZE");
		dismiss = new JButton( "DISMISS" );
		newAlarm = new JButton( "NEW ALARM" );
		newTimer = new JButton( "NEW TIMER" );
		
		
		//action
		//snooze.addActionListener( AlarmsUI  );
		dismiss.addActionListener( alarmsListener );
		newAlarm.addActionListener( alarmsListener );
		newTimer.addActionListener(alarmsListener);
		
		//visuals
		//snooze.setBackground( Color.WHITE );
		dismiss.setBackground( Color.WHITE );
		newAlarm.setBackground( Color.WHITE );
		newTimer.setBackground(Color.WHITE);
		
		//TODO: useless please fix
		gc.ipady = 15;
		gc.weighty = 1;
		gc.weightx = 1;
		gc.gridx = 0;
		gc.gridy = 0;
		
		//Add to Panels
		buttonPanel.add( newAlarm, gc );
		gc.gridy = 1;
		buttonPanel.add(newTimer, gc);
		gc.gridy = 2;
		buttonPanel.add( dismiss, gc );
		gc.gridy = 3;
		//alarmPanel.add( snooze, gc );
		
		
		//Add Alarms to AlarmSide
		addAlarms( );
		alarmPanel.add( alarmSide );
		
		
	}
	
	//TODO: this whole thing is broken
	private void addAlarms( ){
		
		System.out.println("Alarms");
		//bring in alarms using 
		for (int i = 0; i < AlarmsDriver.alarmList.size(); i++) {
			
			JButton alarmLabel = new JButton( AlarmsDriver.alarmList.get(i).getAlarmName() );
			System.out.println( "ALAMRAFDs" + AlarmsDriver.alarmList.get(i).getAlarmName());
			alarmLabel.addActionListener( alarmsListener );
			
			alarmPanel.add(alarmLabel);
			
		}
		
	}
}
