import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class CalSteps extends JFrame implements ActionListener {
	
	// Set up row 1
	JPanel row1 = new JPanel();
	// Adds text and room for input
	JLabel oldStepsText = new JLabel("Old steps-per-mm value: ", JLabel.RIGHT);
	JTextField oldSteps = new JTextField(12);
		
	// Set up row 2
	JPanel row2 = new JPanel();
	// Adds text and room for input
	JLabel definedLengthText = new JLabel("Defined object length: ", JLabel.RIGHT);
	JTextField definedLength = new JTextField(12);
		
	// Set up row 3
	JPanel row3 = new JPanel();
	// Adds text and room for input
	JLabel measuredLengthText = new JLabel("Measured object length: ", JLabel.RIGHT);
	JTextField measuredLength = new JTextField(12);

	// Set up row 4
	JPanel row4 = new JPanel();
	// Adds button to begin calculation
	JButton calculateButton = new JButton("Calculate");
	calculateButton.addActionListener(this);

	// Set up row 5
	JPanel row5 = new JPanel();
	// Adds text and room for output
	JLabel newStepsText = new JLabel("New steps-per-mm value: ", JLabel.RIGHT);
	JTextField newSteps = new JTextField(12);
		
	public CalSteps() {
		// Sets up defaults for UI
		super("3D Printer Steps-per-mm Calculator");
		setLookAndFeel();
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Sets up layout for entire app
		FlowLayout flow = new FlowLayout();
		setLayout(flow);
		
		// Sets up layout for row 1
		FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		// Adds the components of row 1 using layout1
		row1.setLayout(layout1);
		row1.add(oldStepsText);
		row1.add(oldSteps);
		add(row1);
		
		// Sets up layout for row 2
		FlowLayout layout2 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		// Adds the components of row 2 using layout2
		row2.setLayout(layout2);
		row2.add(definedLengthText);
		row2.add(definedLength);
		add(row2);

		// Sets up layout for row 3
		FlowLayout layout3 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		// Adds the components of row 3 using layout3
		row3.setLayout(layout3);
		row3.add(measuredLengthText);
		row3.add(measuredLength);
		add(row3);

		// Sets up layout for row 4
		FlowLayout layout4 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		// Adds the components of row 4 using layout4
		row4.setLayout(layout4);
		row4.add(calculateButton);
		add(row4);

		// Sets up layout for row 5
		FlowLayout layout5 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		// Adds the components of row 5 using layout5
		row5.setLayout(layout5);
		row5.add(newStepsText);
		row5.add(newSteps);
		newSteps.setEditable(false);
		add(row5);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals("Calculate")) {
			calculate();
		}
	}

	void calculate() {
		float oldStepsValue = Float.parseFloat(field.oldSteps);
		float definedLengthValue = Float.parseFloat(field.definedLength);
		float measuredLengthValue = Float.parseFloat(field.measuredLength);
		float newStepsValue = ((oldStepsValue * definedLengthValue) / measuredLengthValue);
		field.newSteps.setText(newStepsValue);
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