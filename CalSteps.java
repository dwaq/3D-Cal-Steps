//*************************************************************************************************
// 3D-Cal-Steps
//
// By: Dillon Nichols
// http://tinkeringetc.blogspot.com/2012/08/printrbot-calibration-prints.html
//
// Description: 
// Java program used to easily calculate the the modified step-per-mm value for a 3D printer.
//
// This work is licensed under a Creative Commons Attribution 3.0 Unported License.
//*************************************************************************************************

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.String.*;

public class CalSteps extends JFrame implements ActionListener {
	
	// Sets up field variables to use in calculate()
	JTextField oldSteps = new JTextField(12);
	JTextField definedLength = new JTextField(12);
	JTextField measuredLength = new JTextField(12);
	JTextField newSteps = new JTextField(12);
						
	public CalSteps() {
		// Sets up defaults for UI
		super("3D Printer Steps-per-mm Calculator");
		setLookAndFeel();
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Sets up layout for entire app
		FlowLayout flow = new FlowLayout();
		setLayout(flow);
		
		// Sets up layout for row 1
		FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		JPanel row1 = new JPanel();
		JLabel oldStepsText = new JLabel("Old steps-per-mm value: ", JLabel.RIGHT);
		row1.setLayout(layout1);
		row1.add(oldStepsText);
		row1.add(oldSteps);
		add(row1);
		
		// Sets up layout for row 2
		FlowLayout layout2 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		JPanel row2 = new JPanel();
		JLabel definedLengthText = new JLabel("Defined object length: ", JLabel.RIGHT);
		row2.setLayout(layout2);
		row2.add(definedLengthText);
		row2.add(definedLength);
		add(row2);

		// Sets up layout for row 3
		FlowLayout layout3 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		JPanel row3 = new JPanel();
		JLabel measuredLengthText = new JLabel("Measured object length: ", JLabel.RIGHT);
		row3.setLayout(layout3);
		row3.add(measuredLengthText);
		row3.add(measuredLength);
		add(row3);

		// Sets up layout for row 4
		FlowLayout layout4 = new FlowLayout(FlowLayout.CENTER, 30, 10);     
		JPanel row4 = new JPanel();
		// Adds button to clear all values
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		// Adds button to begin calculation
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(this);
		row4.setLayout(layout4);
		row4.add(clearButton);
		row4.add(calculateButton);
		add(row4);

		// Sets up layout for row 5
		FlowLayout layout5 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		JPanel row5 = new JPanel();
		JLabel newStepsText = new JLabel("New steps-per-mm value: ", JLabel.RIGHT);
		row5.setLayout(layout5);
		row5.add(newStepsText);
		row5.add(newSteps);
		newSteps.setEditable(false);
		add(row5);

		// Sets up layout for row 6
		FlowLayout layout6 = new FlowLayout(FlowLayout.CENTER, 10, 10);     
		JPanel row6 = new JPanel();
		// Adds button to swap newSteps into oldSteps
		JButton swapButton = new JButton("Swap");
		swapButton.addActionListener(this);
		row6.setLayout(layout6);
		row6.add(swapButton);
		add(row6);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals("Calculate")) {
			calculate();
		}
		if (command.equals("Clear")) {
			clear();
		}
		if (command.equals("Swap")) {
			swap();
		}
	}

	void clear() {
		oldSteps.setText("");
		definedLength.setText("");
		measuredLength.setText("");
		newSteps.setText("");
	}

	void calculate() {
		float oldStepsValue = Float.parseFloat(oldSteps.getText());
		float definedLengthValue = Float.parseFloat(definedLength.getText());
		float measuredLengthValue = Float.parseFloat(measuredLength.getText());
		float newStepsValue = ((oldStepsValue * definedLengthValue) / measuredLengthValue);
		String newStepsValueString;
		newStepsValueString = String.valueOf(newStepsValue);
		newSteps.setText(newStepsValueString);
	}

	void swap() {
		oldSteps.setText(newSteps.getText());
		measuredLength.setText("");
		newSteps.setText("");
	}

	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(
				"com.sun.java.swing.plaf.nimbus.NumbusLookAndFeel"
			);
		} catch (Exception exc) {
			// ignore error
		}
	}
	
	public static void main(String[] arguments) {
		CalSteps Cal = new CalSteps();
	}
}
