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
	//balls

	private JLabel background;
	
	//Main Boxes
	private JPanel alarmPanel;
	private JPanel buttonPanel;
	private GridBagConstraints gc;
	
	//Buttons etc
	private JButton snooze;
	private JButton dismiss;
	private JButton newAlarm;
	
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
		background.add( buttonPanel, gc );
		gc.weightx = .2;
		gc.gridx = 2;
		gc.gridy = 0;
		background.add( alarmPanel, gc );
		
		
		this.setVisible( true );
	}

	private void instantiateObjects() {

		alarmPanel = new JPanel();
		buttonPanel = new JPanel( );
		
		//set up panels
		
		JLabel left = new JLabel("Alarms: ");
		left.setForeground( Color.WHITE);
		
		//Make Panels Translucent
		alarmPanel.setOpaque( false );
		alarmPanel.setBackground( Color.gray );
		buttonPanel.setOpaque( false );
		buttonPanel.setBackground( Color.gray );
		
		//Layouts
		alarmPanel.setLayout( new GridBagLayout( ) );
		buttonPanel.setLayout( new GridLayout(60, 1) );
		
		snooze = new JButton("SNOOZE");
		dismiss = new JButton( "DISMISS" );
		newAlarm = new JButton( "NEW ALARM" );
		
		ActionListener AlarmsUI = new AlarmsDriver();
		//action
		snooze.addActionListener( AlarmsUI  );
		dismiss.addActionListener( AlarmsUI );
		newAlarm.addActionListener( AlarmsUI );
		
		//visuals
		snooze.setBackground( Color.WHITE );
		dismiss.setBackground( Color.WHITE );
		newAlarm.setBackground( Color.WHITE );
		
		//TODO: useless please fix
		gc.ipady = 15;
		gc.weighty = 1;
		gc.weightx = 1;
		gc.gridx = 0;
		gc.gridy = 0;
		
		//Add to Panels
		alarmPanel.add( newAlarm, gc );
		gc.gridy = 1;
		alarmPanel.add( dismiss, gc );
		gc.gridy = 2;
		alarmPanel.add( snooze, gc );
		buttonPanel.add( left );
		
		
		
	}
}
